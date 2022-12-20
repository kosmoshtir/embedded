/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eu.ilanko.ilankovmtool;
import java.io.PrintStream;
/**
* All classfile debugging information gets piped through this class.  
* You can turn off categories of debug information by setting the 
* appropriate String to null.
 * @author Lelek
 */
public class Debug {
  public static String strClass = "class: ";
  public static String strConstPool = "CP: ";
  public static String strField = "field: ";
  public static String strMethod = "method: ";
  public static String strCode = "code: ";
  public static String strInterface = "interface: ";
  public static String strLineNumbers = "line numbers: ";
  public static String strLocalVariables = "local variables: ";
  public static String strInnerClasses = "inner classes: ";
  public static String strUnknownAttribute = "unknown attribute: ";
  public static String strBadData = "bad data: ";
  
  /**
   * Indent subsequent messages.  Subsequent messages will be indented by 
   * two spaces until outdent() is called.  All calls to indent() should eventually
   * be followed by a call to outdent().
   */
  public static void indent() {
    indentLevel++;
  }
  /**
   * Outdent subsequent messages.  This should only be called after a previous
   * call to indent().
   */
  public static void outdent() {
    indentLevel--;
  }
  
  /**
   * Enable or disable printing of any debug message.
   */
  public static void setEnabled(boolean e) {
    enabled = e;
  }
  /**
   * Get whether printing of debug messages is enabled.
   */
  public static boolean isEnabled() {
    return enabled;
  }
  
  /**
   * Redirect where debug messages are sent.
   */
  public static void setOutput(PrintStream out) {
    msgs = out;
  }
  /**
   * Get the destination of debug messages.
   */
  public static PrintStream getOutput() {
    return msgs;
  }
  
  /**
   * Print a debug message.  If the prefix is null, the message is not printed.
   * The message will be prefixed by blank space, the length of which is
   * determined by the current level of indentation.
   */
  public static void println(String prefix, String msg) {
    if (enabled && prefix != null) {
      for (int i = 0; i < indentLevel; i++)
	msgs.print("  ");
      msgs.println(prefix + msg);
    }
  }
  
  private static PrintStream msgs = System.out;
  private static boolean enabled = true;
  private static int indentLevel = 0;
}
