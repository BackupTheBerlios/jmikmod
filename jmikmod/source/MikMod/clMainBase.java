package MikMod;

import MikMod.MMIO.*;
import MikMod.MUniTrk.*;
import MikMod.MLoader.*;


public class clMainBase extends Object
{
	public final String mikversion_ =
		"-= MikMod for Java v2.14 - development version, 22 Nov 97 =---\n";

	public final String mikbannerhead = "\n" + mikversion_ +
		" - main code (in ANSI C) by MikMak <mikmak@via.nl>\n" +
		" - ported to Java by Shlomi Fish <shlomif@ibm.net>\n";
	
	public final String mikbannerdriver =  
		" - Java sound drivers by Shlomi Fish <shlomif@ibm.net>\n";

	public final String mikbannertail =
		" - interface / zip code by Steve McIntyre <stevem@chiark.greenend.org.uk>\n" +
		" - This program is SHAREWARE - Read MIKMOD.TXT for more info \n";


	public final String mikbanner = mikbannerhead + mikbannerdriver + mikbannertail ;

    public final String ERROR_LOADING_HEADER = "Error loading header";
    public final String ERROR_NOT_A_MODULE = "Unknown module format";

    /*
            error variables:
            ===============
    */

    public final String ERROR_ALLOC_STRUCT = "Error allocating structure";
    public final String ERROR_LOADING_PATTERN = "Error loading pattern";
    public final String ERROR_LOADING_TRACK = "Error loading track";
    public final String ERROR_LOADING_SAMPLEINFO = "Error loading sampleinfo";
    public final String ERROR_OUT_OF_HANDLES = "Out of sample-handles";
    public final String ERROR_SAMPLE_TOO_BIG = "Sample too big, out of memory";

	public curmod cur_mod;

	public MikMod.MMIO.MMIO mmIO;
	public MikMod.MUniTrk.clMUniTrk MUniTrk;
	public MikMod.MLoader.clMLoader MLoader;
	public MikMod.clDisplayBase Display;
	public MikMod.clMDriverBase MDriver;
}
