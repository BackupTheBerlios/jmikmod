COMPILE = javac

CFLAGS = -g

OBJS = AuWriteFile.class DynaVoice.class SoundServer.class Server.class


all: $(OBJS)

$(OBJS): %.class: %.java
	$(COMPILE) $(CFLAGS) $<


