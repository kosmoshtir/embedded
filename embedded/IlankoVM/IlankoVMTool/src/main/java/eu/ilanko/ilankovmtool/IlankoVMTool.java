/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package eu.ilanko.ilankovmtool;

/**
 *
 * @author Lelek
 */
public class IlankoVMTool {

  public static void usage() {
    System.out.println("Usage: IlankoVMTool [options] config classpath class");
    System.out.println("Options:");
    System.out.println("    -c        write c header file");
    System.out.println("    -f name   force output file name");
  }
  
  public static void main(String[] args) {
    int curArg = 0;
    boolean writeHeader = false;
    String outputFileName = null;

    System.out.println("IlankoVMTool " + Version.version + 
		       " - (c) 2020-2022  by Ilya Koptyug");

    // parse options
    while((args.length > curArg) && (args[curArg].charAt(0) == '-')) {
      switch(args[curArg].charAt(1)) {
	case 'c':
	  writeHeader = true;
	  break;

	case 'f':
	  outputFileName = args[++curArg];
	  break;

	default:
	  System.out.println("Unknown option " + args[curArg]);
	  usage();
	  return;
      }

      // interpret next option
      curArg++;
    }

    if((args.length - curArg) != 3) {
      usage();
      return;
    }
  
    // load config
    Config.load(args[curArg]);

    // overwrite filename if given on command line
    if(outputFileName != null)
      Config.overwriteFileName(outputFileName);

    ClassLoader.setClassPath(args[curArg+1]);
    ClassLoader.load(args[curArg+2]);    

    System.out.println("Successfully loaded " + 
		       ClassLoader.totalClasses() + " classes");

    // for first tries: write converted file to disk
    UVMWriter writer = new UVMWriter(writeHeader);
  }
}
