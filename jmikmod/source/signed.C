#include <stdio.h>

int main()
{
	unsigned char buf[2048];
	int len,a;

	while ( (len = fread(buf, 1, sizeof(buf), stdin)) == sizeof(buf) )
	{
		for(a=0;a<len;a++)
		{
			buf[a] ^= (unsigned char)0x80;
		}
		fwrite(buf,1, len, stdout);
	}

	for(a=0;a<len;a++)
	{
		buf[a] ^= (unsigned char)0x80;
	}
	fwrite(buf,1, len, stdout);
			

	return 0;
}