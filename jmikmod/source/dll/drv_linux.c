/* DO NOT EDIT THIS FILE - it is machine generated */

#include <unistd.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <linux/soundcard.h>

#include <native.h>
#include "MikMod_Drivers_Native_0005fDriver.h"


extern long MikMod_Drivers_Native_0005fDriver_sysCheckAccess(struct HMikMod_Drivers_Native_0005fDriver *);
extern long MikMod_Drivers_Native_0005fDriver_sysOpenSound(struct HMikMod_Drivers_Native_0005fDriver *,long,long,long,long,struct Hjava_lang_String *);
extern long MikMod_Drivers_Native_0005fDriver_sysCloseSound(struct HMikMod_Drivers_Native_0005fDriver *,long);
extern long MikMod_Drivers_Native_0005fDriver_sysWriteBuffer(struct HMikMod_Drivers_Native_0005fDriver *,long,HArrayOfByte *,long);

long MikMod_Drivers_Native_0005fDriver_sysCheckAccess(
    struct HMikMod_Drivers_Native_0005fDriver * theClass)
{
	return (access("/dev/dsp",W_OK)==0);
}

extern long MikMod_Drivers_Native_0005fDriver_sysOpenSound(
    struct HMikMod_Drivers_Native_0005fDriver * theClass,
    long iFreq,
    long iBitsNum,
    long iStereo,
    long iBlockSize,
    struct Hjava_lang_String * szError)
{
    int sndfd;
    if((sndfd=open("/dev/dsp",O_WRONLY))<0)
    {
        //*m_->mmIO->myerr="Cannot open sounddevice";
	return -1;
    }

    if(ioctl(sndfd, SNDCTL_DSP_SAMPLESIZE, &iBitsNum) == -1 ||
       ioctl(sndfd, SNDCTL_DSP_STEREO, &iStereo) == -1 ||
       ioctl(sndfd, SNDCTL_DSP_SPEED, &iFreq) == -1)
    {
            //*m_->mmIO->myerr = "Device can't play sound in this format";
            close(sndfd);
            return -1;
    }

    ioctl(sndfd, SNDCTL_DSP_GETBLKSIZE, &iBlockSize);

    return sndfd;
}


long MikMod_Drivers_Native_0005fDriver_sysCloseSound(
    struct HMikMod_Drivers_Native_0005fDriver * theClass,
    long hFile)
{
    return (close(hFile) == 0);
}

long MikMod_Drivers_Native_0005fDriver_sysWriteBuffer(
    struct HMikMod_Drivers_Native_0005fDriver * theClass,
    long hFile,
    HArrayOfByte * bBuffer,
    long iLen)
{
    return write(hFile, bBuffer->obj->body, iLen);
}


