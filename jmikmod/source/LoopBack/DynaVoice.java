//******************************************************************************
// DynaVoice.java:	Applet
//
//******************************************************************************
import java.applet.*;
import java.awt.*;
import java.net.*;
import java.io.*;

import SoundServer;

//==============================================================================
// Main Class for applet DynaVoice
//
//==============================================================================
public class DynaVoice extends Applet implements Runnable
{
	// THREAD SUPPORT:
	//		m_DynaVoice	is the Thread object for the applet
	//--------------------------------------------------------------------------
	Thread	 m_DynaVoice = null;

	boolean m_fStandAlone = false;

	SoundServer m_SoundServer = null;

	// ANIMATION SUPPORT:
	//		m_Graphics		used for storing the applet's Graphics context
	//		m_Images[]		the array of Image objects for the animation
	//		m_nCurrImage	the index of the next image to be displayed
	//		m_ImgWidth		width of each image
	//		m_ImgHeight		height of each image
	//		m_fAllLoaded	indicates whether all images have been loaded
	//		NUM_IMAGES 		number of images used in the animation
	//--------------------------------------------------------------------------
	private Graphics m_Graphics;
	private Image	 m_Images[];
	private int 	 m_nCurrImage;
	private int 	 m_nImgWidth  = 0;
	private int 	 m_nImgHeight = 0;
	private boolean  m_fAllLoaded = false;
	private final int NUM_IMAGES = 0;
	private final int SOUND_PORT = 2770;


	// DynaVoice Class Constructor
	//--------------------------------------------------------------------------
	public DynaVoice()
	{
		// TODO: Add constructor code here
	}

	// APPLET INFO SUPPORT:
	//		The getAppletInfo() method returns a string describing the applet's
	// author, copyright date, or miscellaneous information.
    //--------------------------------------------------------------------------
	public String getAppletInfo()
	{
		return "Name: DynaVoice\r\n" +
		       "Author: Shlomi Fish\r\n" +
		       "Created with Microsoft Visual J++ Version 1.0";
	}


	// The init() method is called by the AWT when an applet is first loaded or
	// reloaded.  Override this method to perform whatever initialization your
	// applet needs, such as initializing data structures, loading images or
	// fonts, creating frame windows, setting the layout manager, or adding UI
	// components.
    //--------------------------------------------------------------------------
	public void init()
	{
        // If you use a ResourceWizard-generated "control creator" class to
        // arrange controls in your applet, you may want to call its
        // CreateControls() method from within this method. Remove the following
        // call to resize() before adding the call to CreateControls();
        // CreateControls() does its own resizing.
        //----------------------------------------------------------------------
		resize(320, 240);

		// TODO: Place additional initialization code here
	}

	// Place additional applet clean up code here.  destroy() is called when
	// when you applet is terminating and being unloaded.
	//-------------------------------------------------------------------------
	public void destroy()
	{
		// TODO: Place applet cleanup code here
	}

    // ANIMATION SUPPORT:
    //		Draws the next image, if all images are currently loaded
    //--------------------------------------------------------------------------
	private void displayImage(Graphics g)
	{
		if (!m_fAllLoaded)
			return;

		// Draw Image in center of applet
		//----------------------------------------------------------------------
		g.drawImage(m_Images[m_nCurrImage],
				   (size().width - m_nImgWidth)   / 2,
				   (size().height - m_nImgHeight) / 2, null);
	}

	// DynaVoice Paint Handler
	//--------------------------------------------------------------------------
	public void paint(Graphics g)
	{
		// ANIMATION SUPPORT:
		//		The following code displays a status message until all the
		// images are loaded. Then it calls displayImage to display the current
		// image.
		//----------------------------------------------------------------------
		if (m_fAllLoaded)
		{
			//Rectangle r = g.getClipRect();
			g.drawString( "Hello, World! Separator is "+ File.separator, 50, 25 );

			//g.clearRect(r.x, r.y, r.width, r.height);
			//displayImage(g);
		}
		else
			g.drawString("Loading images...", 10, 20);

		// TODO: Place additional applet Paint code here
	}

	//		The start() method is called when the page containing the applet
	// first appears on the screen. The AppletWizard's initial implementation
	// of this method starts execution of the applet's thread.
	//--------------------------------------------------------------------------
	public void start()
	{
		if (m_DynaVoice == null)
		{
			m_DynaVoice = new Thread(this);
			m_DynaVoice.start();
			//m_SoundServer = new SoundServer(this, 2770);
			//m_SoundServer.start();
		}
		// TODO: Place additional applet start code here
	}
	
	//		The stop() method is called when the page containing the applet is
	// no longer on the screen. The AppletWizard's initial implementation of
	// this method stops execution of the applet's thread.
	//--------------------------------------------------------------------------
	public void stop()
	{
		if (m_DynaVoice != null)
		{
			m_DynaVoice.stop();			
			m_DynaVoice = null;
			//m_SoundServer.stop();
			//m_SoundServer = null;
		}

		// TODO: Place additional applet stop code here
	}

	public static void main(String args[])
	{
		DebugToolFrame frame = new DebugToolFrame("DebugTool");

		// Must show Frame before we size it so insets() will return valid values
		//----------------------------------------------------------------------
		frame.show();
                frame.hide();
		frame.resize(frame.insets().left + frame.insets().right  + 320,
					 frame.insets().top  + frame.insets().bottom + 240);

		// The following code starts the applet running within the frame window.
		// It also calls GetParameters() to retrieve parameter values from the
		// command line, and sets m_fStandAlone to true to prevent init() from
		// trying to get them from the HTML page.
		//----------------------------------------------------------------------
		DynaVoice applet_DebugTool = new DynaVoice();
		
		frame.add("Center", applet_DebugTool);
		applet_DebugTool.m_fStandAlone = true;
		applet_DebugTool.init();
		applet_DebugTool.start();
                frame.show();
	}

	// THREAD SUPPORT
	//		The run() method is called when the applet's thread is started. If
	// your applet performs any ongoing activities without waiting for user
	// input, the code for implementing that behavior typically goes here. For
	// example, for an applet that performs animation, the run() method controls
	// the display of images.
	//--------------------------------------------------------------------------
	public void run()
	{
		try 
		{

		m_nCurrImage = 0;
		
		// If re-entering the page, then the images have already been loaded.
		// m_fAllLoaded == TRUE.
		//----------------------------------------------------------------------
        if (!m_fAllLoaded)
		{
    		repaint();
    		m_Graphics = getGraphics();
    		//m_Images   = new Image[NUM_IMAGES];

    		// Load in all the images
    		//------------------------------------------------------------------
    		//MediaTracker tracker = new MediaTracker(this);
    		String strImage;

    		// For each image in the animation, this method first constructs a
    		// string containing the path to the image file; then it begins
    		// loading the image into the m_Images array.  Note that the call to
    		// getImage will return before the image is completely loaded.
    		//------------------------------------------------------------------
    		/*for (int i = 1; i <= NUM_IMAGES; i++)
    		{
    			// Build path to next image
    			//--------------------------------------------------------------
    			strImage = "images/img00" + ((i < 10) ? "0" : "") + i + ".gif";
			    m_Images[i-1] = getImage(getDocumentBase(), strImage);

                tracker.addImage(m_Images[i-1], 0);
    		}

    		// Wait until all images are fully loaded
    		//------------------------------------------------------------------
			try
			{
				tracker.waitForAll();
				m_fAllLoaded = !tracker.isErrorAny();
			}
			catch (InterruptedException e)
			{
				// TODO: Place exception-handling code here in case an
				//       InterruptedException is thrown by Thread.sleep(),
				//		 meaning that another thread has interrupted this one
			}
			
			if (!m_fAllLoaded)
			{
			    stop();
			    m_Graphics.drawString("Error loading images!", 10, 40);
			    return;
			}
			

			// Assuming all images are same width and height.
			//--------------------------------------------------------------
		    m_nImgWidth  = m_Images[0].getWidth(this);
		    m_nImgHeight = m_Images[0].getHeight(this);*/
			m_fAllLoaded = true;
        }		
		repaint();
		
		String AudioFile = "";
		java.net.Socket sock;


		/*try {
			java.net.URL nameURL = new java.net.URL("http", "localhost", 2770, "/");
			try {
			URLConnection con = nameURL.openConnection( );
			BufferedInputStream in = 
				new BufferedInputStream( con.getInputStream(), 2048 );
			int nbytes;
			String content;
			byte buf[] = new byte[ 1024 ];

			while( (nbytes = in.read( buf, 0, 1024 )) != -1 ) {
				content = new String( buf, 0, 0, nbytes );
				AudioFile += content;
			}
			} catch (IOException ioe) {}
		} catch (MalformedURLException a) {} */

                //play(getDocumentBase(), AudioFile);


                if (isActive())
                {
                    System.out.println ("Stub is null.\n");
                }
                else
                {
                    System.out.println ("Stub is ok.\n");
                }

		// Wait for the Sound Server to be initialized
		try { 
                    //Thread.sleep(5000);
                    Thread.sleep(1);
		} catch (InterruptedException a) {}
		
		try {
			int i;
			URL AudioUrl = new URL("http", "localhost", 2770, "/hello.au");
			for(i=0;i<20;i++)
			{				
                            if (true)
                            {
                                play ( AudioUrl );
                            }
                            else
                            {
				//try {
					try {
						URLConnection con = AudioUrl.openConnection( );
						FileOutputStream o = new FileOutputStream("out"+(i/10)+(i%10)+".au");
						int nbytes;
						byte buf[] = new byte[ 1024 ];

						while( (nbytes = con.getInputStream().read( buf, 0, 1024 )) != -1 ) {
							o.write(buf, 0, nbytes);
						}
						o.flush();
						o.close();
					} catch (IOException ioe) {}
                                //} catch (MalformedURLException a) {}
                            }
			}
			for(i=0;i<20;i++)
			{
				play(getDocumentBase(), "out"+(i/10)+(i%10)+".au");
			}
		} catch (MalformedURLException e) {}

		}
		catch (NullPointerException e)
		{
			System.out.println("exception:  "  +  e.getMessage());
			e.printStackTrace();
		}
				

		while (true)
		{
			try
			{
				// Draw next image in animation
				//--------------------------------------------------------------
				/*displayImage(m_Graphics);
				m_nCurrImage++;
				if (m_nCurrImage == NUM_IMAGES)
					m_nCurrImage = 0;*/

				// TODO:  Add additional thread-specific code here
				Thread.sleep(50);
			}
			catch (InterruptedException e)
			{
				// TODO: Place exception-handling code here in case an
				//       InterruptedException is thrown by Thread.sleep(),
				//		 meaning that another thread has interrupted this one
				stop();
			}
		}
	}

	// MOUSE SUPPORT:
	//		The mouseDown() method is called if the mouse button is pressed
	// while the mouse cursor is over the applet's portion of the screen.
	//--------------------------------------------------------------------------
	public boolean mouseDown(Event evt, int x, int y)
	{
		// TODO: Place applet mouseDown code here
		return true;
	}

	// MOUSE SUPPORT:
	//		The mouseUp() method is called if the mouse button is released
	// while the mouse cursor is over the applet's portion of the screen.
	//--------------------------------------------------------------------------
	public boolean mouseUp(Event evt, int x, int y)
	{
		// TODO: Place applet mouseUp code here
		return true;
	}


	// TODO: Place additional applet code here

}
