/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eu.ilanko.ilankovmtool;
import java.util.Vector;
/**
 * A class for storing information about methods.
 * @author Lelek
 */
public class MethodInfo extends CommonInfo {
  private String signature;
  private Vector exceptions = new Vector();
  private CodeInfo codeInfo;
  private boolean deprecated;
  
  public MethodInfo(short accessFlags, String name, String signature) {
    setAccessFlags(accessFlags);
    setName(name);
    setSignature(signature);
  }
  
  /*
   * Set the signature of the method.  For example "([I,S)Ljava/lang/String;"
   */
  public void setSignature(String signature) {
    this.signature = signature;
  }
  
  // parse signature for number of arguments
  public int getArgs() {
    int args = 0, cur = 0;

    if(signature.charAt(cur++) != '(') {
      System.out.println("MethodInfo.getArgs: Invalid type string");
      System.exit(-1);
    }

    while(signature.charAt(cur) != ')') {
      if((signature.charAt(cur) == 'B')||   // byte
	 (signature.charAt(cur) == 'C')||   // unicode char
	 (signature.charAt(cur) == 'I')||   // integer
	 (signature.charAt(cur) == 'S')||   // short
         (signature.charAt(cur) == 'F')||   // float
	 (signature.charAt(cur) == 'Z'))    // boolean
	args++;
      
      else if(signature.charAt(cur) == 'L') {    // instance of class
	while(signature.charAt(cur) != ';') cur++;
	args++;
      } 
      
      else if(signature.charAt(cur) == '[') {
	// ignore
      } else {
	System.out.println("MethodInfo.getArgs: Unexpected char in type: '"+signature.charAt(cur)+"'");
	System.exit(-1);
      }

      cur++;
    }

    // non-static methods have an hidden extra argument: the reference
    if((getAccessFlags() & AccessFlags.STATIC) == 0) args++;

    return args;
  }

  /*
   * Get the signature of the method. 
   */
  public String getSignature() {
    return signature;
  }
  
  /*
   * Add a checked exception that the method throws.
   */
  public void addException(String exceptionName) {
    exceptions.addElement(exceptionName);
  }
  
  /*
   * Set information about this method's code.  The CodeInfo need
   * not be entirely filled in before this method is called.
   */
  public void setCodeInfo(CodeInfo codeInfo) {
		this.codeInfo = codeInfo;
  }
  
  /*
   * Get the information about this method's code.  If the method
   * has no code, this will return null.
   */
  public CodeInfo getCodeInfo() {
    return codeInfo;
  }
  
  /*
   * Set whether this method is deprecated.  Methods are not
   * deprecated until setDeprecated(true) is called.
   */
  public void setDeprecated(boolean d) {
    deprecated = d;
  }
  
  /*
   * Get whether this method is deprecated.  Methods are not
   * deprecated until setDeprecated(true) is called.
   */
  public boolean isDeprecated() {
    return deprecated;
  }
}

