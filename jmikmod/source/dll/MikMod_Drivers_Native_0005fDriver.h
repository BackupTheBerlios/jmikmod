/* DO NOT EDIT THIS FILE - it is machine generated */
#include <native.h>
/* Header for class MikMod_Drivers_Native_0005fDriver */

#ifndef _Included_MikMod_Drivers_Native_0005fDriver
#define _Included_MikMod_Drivers_Native_0005fDriver
struct HMikMod_clMain;
struct Hjava_lang_String;

typedef struct ClassMikMod_Drivers_Native_0005fDriver {
    struct HMikMod_clMain *m_;
    struct Hjava_lang_String *Name;
    struct Hjava_lang_String *Version;
    long sndfd;
    long fragmentsize;
    struct HArrayOfByte *audiobuffer;
    long DEFAULT_FRAGSIZE;
    long DEFAULT_NUMFRAGS;
} ClassMikMod_Drivers_Native_0005fDriver;
HandleTo(MikMod_Drivers_Native_0005fDriver);

#ifdef __cplusplus
extern "C" {
#endif
extern long MikMod_Drivers_Native_0005fDriver_sysCheckAccess(struct HMikMod_Drivers_Native_0005fDriver *);
extern long MikMod_Drivers_Native_0005fDriver_sysOpenSound(struct HMikMod_Drivers_Native_0005fDriver *,long,long,long,long,struct Hjava_lang_String *);
extern long MikMod_Drivers_Native_0005fDriver_sysCloseSound(struct HMikMod_Drivers_Native_0005fDriver *,long);
extern long MikMod_Drivers_Native_0005fDriver_sysWriteBuffer(struct HMikMod_Drivers_Native_0005fDriver *,long,HArrayOfByte *,long);
#ifdef __cplusplus
}
#endif
#endif
