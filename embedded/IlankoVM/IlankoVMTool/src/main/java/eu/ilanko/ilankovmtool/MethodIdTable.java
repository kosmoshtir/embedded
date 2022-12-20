/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eu.ilanko.ilankovmtool;

/**
 *
 * @author Lelek
 */
public class MethodIdTable {
  private static int[] mindex;

  // build the complete method id table
  public static void build() {
    mindex = new int[ClassLoader.totalMethods()];

    // clear index table
    for(int i=0;i<ClassLoader.totalMethods();i++) mindex[i] = -1;

    // generate table
    for(int i=0,id = 0;i<ClassLoader.totalMethods();i++) {
      // entry has not been set yet
      if(mindex[i] == -1) {
	// use same id on all methods mit same name and signature
	for(int j = i;j<ClassLoader.totalMethods();j++) {
	  if(ClassLoader.getMethod(i).getName().equals(
	       ClassLoader.getMethod(j).getName()) &&
	     ClassLoader.getMethod(i).getSignature().equals(
	       ClassLoader.getMethod(j).getSignature())) {
	    
	    mindex[j] = id;
	  }
	}
	id++;
      }
    }
  }

  // get one entry from the method id table
  public static int getEntry(int i) {
    return mindex[i];
  }    
}
