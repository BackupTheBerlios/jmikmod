
# Settings for Linux

INCLUDE=-I/usr/lib/java/include -I/usr/lib/java/include/linux

CFLAGS=-g $(INCLUDE)

LIB_NAME=libjmikmod_drv.so
STUB_NAME=MikMod_Drivers_Native_0005fDriver
MAIN_CODE_FILE=drv_linux




all: ../$(LIB_NAME)

$(MAIN_CODE_FILE).o: $(MAIN_CODE_FILE).c
	gcc -fPIC -c $(CFLAGS) $(MAIN_CODE_FILE).c

$(STUB_NAME).o: $(STUB_NAME).c
	gcc -fPIC -c $(CFLAGS) $(STUB_NAME).c
        
../$(LIB_NAME): $(MAIN_CODE_FILE).o $(STUB_NAME).o
	gcc -shared -g -Wl,-soname,$(LIB_NAME).1 -o ../$(LIB_NAME) *.o
