import java.io.*;


public class AuWriteFile extends Object
{
	protected OutputStream os;
	protected int iStrmPos;
	protected int iNumSamples;
	final int constAU_HDRSIZE = 24;
	final int constAU_LINEAR8 = 2;
	final int constAU_LINEAR16 = 3;

	public AuWriteFile(OutputStream new_os)
	{
		assignStream(new_os);
	}

	public AuWriteFile(OutputStream new_os, 
		int sampling_rate, 
		int is_16bit, 
		int stereo, 
		int num_samples)
	{
		assignStream(new_os);
		WriteHeader(sampling_rate, is_16bit, stereo, num_samples);
	}

	public void assignStream(OutputStream new_os)
	{
		os = new_os;
		iStrmPos = 0;
	}

	public void writeBigEndianDWord(int dwInt)
	{
		byte [] bytes = new byte[4];
		int a;
		try {
			for(a=0;a<4;a++)
			{
				bytes[a] = (byte)((dwInt >> ((3-a)*8)) & 0xFF);
			}
			os.write(bytes, 0, 4);
		}
		catch (IOException ioexp)
		{
		}
	}

	public void WriteHeader (int sampling_rate, int is_16bit, int stereo, int num_samples)
	{
		byte [] buf = new byte[4];
		int dwValue;

		iNumSamples = num_samples;
		
		// 1. Magic key (".snd")
		dwValue = 0x2e736e64;
		writeBigEndianDWord(dwValue);

		// 2. Offset to data. My comment is 4 bytes long so far
		writeBigEndianDWord(constAU_HDRSIZE + 4);

		// 3. Number of bytes of audio data
		writeBigEndianDWord(num_samples*(is_16bit+1)*(stereo+1));

		// 4. Data format
		writeBigEndianDWord((is_16bit != 0) ? constAU_LINEAR16 : constAU_LINEAR8);

		// 5. Sampling Rate
		writeBigEndianDWord(sampling_rate);

		// 6. Channels Number
		writeBigEndianDWord(1+stereo);

		// 7. Comment
		writeBigEndianDWord(0);
	}

	public int cache8BitBuffer(byte [] bSamples, int iOffset, int iDataLen)
	{
		try
		{
			if (iStrmPos <= iNumSamples - iDataLen)
			{
				os.write(bSamples, iOffset, iDataLen);
				iStrmPos += iDataLen;
				return 1;
			}
			else if(iStrmPos < iNumSamples)
			{
				os.write(bSamples, iOffset, iNumSamples-iStrmPos);
				iStrmPos = iNumSamples;
			}
			return 0;
		}
		catch (IOException ioexp)
		{
		}
		return 0;
	}

	public void write8BitMonoFile (OutputStream new_os,
		int sampling_rate,
		byte bDataBuffer[],
		int iOffset, 
		int iDataLen)
	{
		os = new_os;
		if (sampling_rate == 0)
			sampling_rate = 22050;
		WriteHeader(sampling_rate, 0, 0, iDataLen);
		try
		{
			os.write(bDataBuffer, iOffset, iDataLen);
		}
		catch (IOException ioexp)
		{
		}		
	}
}