# Microsoft Developer Studio Generated NMAKE File, Format Version 4.20
# ** DO NOT EDIT **

# TARGTYPE "Java Virtual Machine Java Workspace" 0x0809

!IF "$(CFG)" == ""
CFG=DynaVoice - Java Virtual Machine Debug
!MESSAGE No configuration specified.  Defaulting to DynaVoice - Java Virtual\
 Machine Debug.
!ENDIF 

!IF "$(CFG)" != "DynaVoice - Java Virtual Machine Release" && "$(CFG)" !=\
 "DynaVoice - Java Virtual Machine Debug"
!MESSAGE Invalid configuration "$(CFG)" specified.
!MESSAGE You can specify a configuration when running NMAKE on this makefile
!MESSAGE by defining the macro CFG on the command line.  For example:
!MESSAGE 
!MESSAGE NMAKE /f "DynaVoice.mak" CFG="DynaVoice - Java Virtual Machine Debug"
!MESSAGE 
!MESSAGE Possible choices for configuration are:
!MESSAGE 
!MESSAGE "DynaVoice - Java Virtual Machine Release" (based on\
 "Java Virtual Machine Java Workspace")
!MESSAGE "DynaVoice - Java Virtual Machine Debug" (based on\
 "Java Virtual Machine Java Workspace")
!MESSAGE 
!ERROR An invalid configuration is specified.
!ENDIF 

!IF "$(OS)" == "Windows_NT"
NULL=
!ELSE 
NULL=nul
!ENDIF 
################################################################################
# Begin Project
# PROP Target_Last_Scanned "DynaVoice - Java Virtual Machine Debug"
JAVA=jvc.exe

!IF  "$(CFG)" == "DynaVoice - Java Virtual Machine Release"

# PROP BASE Use_MFC 0
# PROP BASE Use_Debug_Libraries 0
# PROP BASE Output_Dir ""
# PROP BASE Intermediate_Dir ""
# PROP BASE Target_Dir ""
# PROP Use_MFC 0
# PROP Use_Debug_Libraries 0
# PROP Output_Dir ""
# PROP Intermediate_Dir ""
# PROP Target_Dir ""
OUTDIR=.
INTDIR=.

ALL : "$(OUTDIR)\DynaVoice.class" "$(OUTDIR)\SoundServer.class"\
 "$(OUTDIR)\AuWriteFile.class" "$(OUTDIR)\DebugToolFrame.class"

CLEAN : 
	-@erase "$(INTDIR)\AuWriteFile.class"
	-@erase "$(INTDIR)\DebugToolFrame.class"
	-@erase "$(INTDIR)\DynaVoice.class"
	-@erase "$(INTDIR)\SoundServer.class"

# ADD BASE JAVA /O
# ADD JAVA /O

!ELSEIF  "$(CFG)" == "DynaVoice - Java Virtual Machine Debug"

# PROP BASE Use_MFC 0
# PROP BASE Use_Debug_Libraries 1
# PROP BASE Output_Dir ""
# PROP BASE Intermediate_Dir ""
# PROP BASE Target_Dir ""
# PROP Use_MFC 0
# PROP Use_Debug_Libraries 1
# PROP Output_Dir ""
# PROP Intermediate_Dir ""
# PROP Target_Dir ""
OUTDIR=.
INTDIR=.

ALL : "$(OUTDIR)\DynaVoice.class" "$(OUTDIR)\SoundServer.class"\
 "$(OUTDIR)\AuWriteFile.class" "$(OUTDIR)\DebugToolFrame.class"

CLEAN : 
	-@erase "$(INTDIR)\AuWriteFile.class"
	-@erase "$(INTDIR)\DebugToolFrame.class"
	-@erase "$(INTDIR)\DynaVoice.class"
	-@erase "$(INTDIR)\SoundServer.class"

# ADD BASE JAVA /g
# ADD JAVA /g

!ENDIF 

################################################################################
# Begin Target

# Name "DynaVoice - Java Virtual Machine Release"
# Name "DynaVoice - Java Virtual Machine Debug"

!IF  "$(CFG)" == "DynaVoice - Java Virtual Machine Release"

!ELSEIF  "$(CFG)" == "DynaVoice - Java Virtual Machine Debug"

!ENDIF 

################################################################################
# Begin Source File

SOURCE=.\DynaVoice.java

!IF  "$(CFG)" == "DynaVoice - Java Virtual Machine Release"


"$(INTDIR)\DynaVoice.class" : $(SOURCE) "$(INTDIR)"


!ELSEIF  "$(CFG)" == "DynaVoice - Java Virtual Machine Debug"


"$(INTDIR)\DynaVoice.class" : $(SOURCE) "$(INTDIR)"


!ENDIF 

# End Source File
################################################################################
# Begin Source File

SOURCE=.\DynaVoice.html

!IF  "$(CFG)" == "DynaVoice - Java Virtual Machine Release"

!ELSEIF  "$(CFG)" == "DynaVoice - Java Virtual Machine Debug"

!ENDIF 

# End Source File
################################################################################
# Begin Source File

SOURCE=.\SoundServer.java

!IF  "$(CFG)" == "DynaVoice - Java Virtual Machine Release"


"$(INTDIR)\SoundServer.class" : $(SOURCE) "$(INTDIR)"


!ELSEIF  "$(CFG)" == "DynaVoice - Java Virtual Machine Debug"


"$(INTDIR)\SoundServer.class" : $(SOURCE) "$(INTDIR)"


!ENDIF 

# End Source File
################################################################################
# Begin Source File

SOURCE=.\AuWriteFile.java

!IF  "$(CFG)" == "DynaVoice - Java Virtual Machine Release"


"$(INTDIR)\AuWriteFile.class" : $(SOURCE) "$(INTDIR)"


!ELSEIF  "$(CFG)" == "DynaVoice - Java Virtual Machine Debug"


"$(INTDIR)\AuWriteFile.class" : $(SOURCE) "$(INTDIR)"


!ENDIF 

# End Source File
################################################################################
# Begin Source File

SOURCE=.\DebugToolFrame.java

!IF  "$(CFG)" == "DynaVoice - Java Virtual Machine Release"


"$(INTDIR)\DebugToolFrame.class" : $(SOURCE) "$(INTDIR)"


!ELSEIF  "$(CFG)" == "DynaVoice - Java Virtual Machine Debug"


"$(INTDIR)\DebugToolFrame.class" : $(SOURCE) "$(INTDIR)"


!ENDIF 

# End Source File
# End Target
# End Project
################################################################################
