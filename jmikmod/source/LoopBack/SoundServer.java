import java.lang.Thread;
import java.net.*;
import java.io.*;
//import System;
/*
 *
 * SoundServer
 *
 */
public class SoundServer extends Thread
{
	protected int port;	
	protected final int DEFAULT_PORT = 2770;
	protected java.net.ServerSocket listener;
	protected java.net.Socket clients[];

	public SoundServer(Runnable target)
	{
		super(target);
		port=DEFAULT_PORT;
	}
	public SoundServer(Runnable target, int newport)
	{
		super(target);
		port=newport;
	}

	public void run() 
	{
		clients = new Socket[10];
		try
		{
			listener = new ServerSocket(port);
		}
		catch (IOException a)
		{

		}
		
		String szHeader = "HTTP/1.0 200 OK\nContent-Type: audio/basic\n\n";
		byte header[] = new byte[szHeader.length()];
		szHeader.getBytes(0, szHeader.length(), header, 0);
		
                FileInputStream src_strm;
                src_strm = null;
		try {
                    //src_strm = new FileInputStream("C:\\MSDEV\\projects\\DynaVoice\\friends.au");
                    src_strm = new FileInputStream("/home/shlomi/Download/JMikMod/source/music.signed.raw");
		} catch (IOException a) {}
		byte str[] = new byte[16000];
		int src_numbytes = 16000;

		// while (true)
		while (src_numbytes == 16000)
		{
			try 
			{
				clients[0] = listener.accept();
			}
			catch (IOException a)
			{
				try {listener.close(); } catch (IOException b) {}
				return;
			}

			String s;
			s = "HTTP/1.0 200 OK\nContent-Type: text/plain\n\nimages/madness.au";
			/*while (s.length() < 30)
			{
				s += " ";
			} */
			
			
			int b;
			byte pb, ppb;
			String ss = "";
			try
			{
				
				b = clients[0].getInputStream().read();
				pb = ppb = 0;
				//while ((((byte)b != '\n')||((byte)pb != '\n')) && (b != -1))
				// Loop until encounter an empty HTTP-request header line.
				while (! (
					(b == -1) ||
					(((byte)b == '\n') &&
						( (pb == '\n') ||
						((pb == '\r') && (ppb == '\n')) )
					)
				) )
				{
					byte bs[] = new byte[1];
					bs[0] = (byte)b;
					ss += new String(bs, 0);
					ppb = pb;
					pb = (byte)b;
					b = clients[0].getInputStream().read();					
				}
				pb = 5;
			}
			catch (IOException a) {}
			
			try {			

				clients[0].getOutputStream().write(header);
				
				src_numbytes = src_strm.read(str);
				AuWriteFile auWrite = new AuWriteFile(
					clients[0].getOutputStream(),
					22050,
					0,
					0,
					src_numbytes);
				clients[0].getOutputStream().write(str, 0, src_numbytes);

			} catch (IOException a) {}
			try {clients[0].getOutputStream().flush(); } catch (IOException a) {}
			try {clients[0].close();  } catch (IOException a) {}			
		}
		try {listener.close(); } catch (IOException b) {}
		try {src_strm.close(); } catch (IOException b) {}

	}
}

