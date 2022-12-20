/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eu.ilanko.ilankovm.drivers;

/**
 * Gives access to a connected text display.
 * @author Lelek
 */
public class TextDisplay {

  /**
   * Minimum value for X coordinate
   */
  public static final int MIN_X = 0;

  /**
   * Maximum value for X coordinate
   */
  public static final int MAX_X = 15;

  /**
   * Minimum value for Y coordinate
   */
  public static final int MIN_Y = 0;

  /**
   * Maximum value for Y coordinate
   */
  public static final int MAX_Y = 1;

  public static final int HIDDEN = 0;
  public static final int BLOCK = 1;
  public static final int BLINKBLOCK = 2;
  public static final int LINE = 3;
  
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
   * Set the visibility of the cursor.
   * @param mode new cursor mode. Possible values are <code>HIDDEN BLOCK BLINKBLOCK LINE</code>
   */
  public static native void setCursorMode(int mode);
}


