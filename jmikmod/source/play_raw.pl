#!/usr/bin/perl
use FileHandle;

%sizeof = ('int' => 4);
require 'sys/ioctl.ph';
require 'sys/soundcard.ph';
#use PerlWave;

#@a = PerlWave::Open(11025, 0, 0);
#PerlWave::Close();

print "SNDCTL_DSP_SPEED is ", sprintf("%X", (SNDCTL_DSP_SPEED() )), "\n";
print "IOC_INOUT is ", sprintf("%X", (IOC_INOUT() )), "\n";
print "IOC_INOUT is ", sprintf("%X", (IOC_INOUT() )), "\n";

printf("_IOC_DIRSHIFT is %.8lX\n", _IOC_DIRSHIFT());
printf("_IOC_SIZESHIFT is %.8lX\n", _IOC_SIZESHIFT());
printf("_IOC_NRSHIFT is %.8lX\n", _IOC_NRSHIFT());
print $sizeof{'int'}, "\n";
print %sizeof;


my ($buf, $siz);

printf "SND... is %lX\n", ( &SNDCTL_DSP_SPEED );

$ret = sysopen(O, '/dev/dsp', O_WRONLY);

print "\$ret is ", (($ret)?'True':'False'), "\n";

# $ret = ioctl (O, ( &SNDCTL_DSP_SPEED ), pack("L", 44100));
# $ret = ioctl (O, ( &SNDCTL_DSP_SPEED ), 44100);

$speed = pack("L", shift(@ARGV));
$ret = ioctl (O, 0xC0045002 , $speed);
print "\$ret is ", (($ret)?'True':'False'), "\n";
if (! $ret)
{
    exit;
}

$stereo = pack("L", ((shift(@ARGV) eq 'm') ? 0 : 1));
$ret = ioctl (O, &SNDCTL_DSP_STEREO , $stereo);
print "\$ret is ", (($ret)?'True':'False'), "\n";
if (! $ret)
{
    exit;
}

$precision = pack("L", ((shift(@ARGV) eq '8') ? 8 : 16));
$ret = ioctl (O, &SNDCTL_DSP_SAMPLESIZE , $precision);
print "\$ret is ", (($ret)?'True':'False'), "\n";
if (! $ret)
{
    exit;
}


# exit;
$ret = open (I, shift(@ARGV));
while (($siz=read(I, $buf, 1024)) == 1024)
{
   print O $buf;
}
print O $buf;
close O;
close I;


