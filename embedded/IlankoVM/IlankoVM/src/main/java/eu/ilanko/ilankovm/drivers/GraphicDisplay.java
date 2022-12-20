/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eu.ilanko.ilankovm.drivers;

/**
 *Gives access to a connected graphics display.
 * @author Lelek
 */
public class GraphicDisplay {

  /**
   * Minimum value for X coordinate
   */
  public static final int MIN_X = 0;

  /**
   * Maximum value for X coordinate
   */
  public static final int MAX_X = 127;

  /**
   * Minimum value for Y coordinate
   */
  public static final int MIN_Y = 0;

  /**
   * Maximum value for Y coordinate
   */
  public static final int MAX_Y = 63;
  
  /**
   * Clear the entire display
   */
  public static native void clear();
  
  /**
   * Set (invisible) cursor to given coordinate
   * @param x X-coordinate
   * @param y Y-coordinate
   */
  public static native void gotoXY(int x, int y);

  /**
   * Print text on display
   */
  public static native void print(String s);

  /**
   * Set the proportional mode for text output
   * @param proportional true for proportional mode
   */
  public static native void setProportional(boolean proportional);

  /**
   * Get the proportional mode for text output
   * @return true for proportional mode
   */
  public static native boolean getProportional();
}
