import java.io.*;

public class LittleEndianInputStream extends InputStream
{
	protected InputStream strmSrc;
	protected byte buffer[];
	
	public LittleEndianInputStream(InputStream in)
	{
		strmSrc = in;
		buffer = new byte[32];
	}

	public short readShort()
	{
		strmSrc.read(buffer,0,2);
		return (short)buffer[0]+(((short)buffer[1])<<8);
	}

	public long readLong()
	{
		long lRet=0;
		int a;

		strmSrc.read(buffer,0,4);
		for(a=3;a>=0;a--)
			lRet = buffer[0]+(lRet<<8);
	}
}


