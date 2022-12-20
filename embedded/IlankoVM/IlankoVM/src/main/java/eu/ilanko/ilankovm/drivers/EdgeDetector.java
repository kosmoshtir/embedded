/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eu.ilanko.ilankovm.drivers;

/**
 * Encapsulates the information about the two
 * IR-reflex-sensors for edge detection. You will have to call the update
 * Method first to get actual values.
 * @author Lelek
 */
public class EdgeDetector {

  /**
   * Maximum value from IR-sensor
   */
  public static final int MAXIMUM = 255;
  
  /**
   * Minimum value from IR-sensor
   */
  public static final int MINIMUM = 0;
  
  /**
   * Measure the reflex values on both sides and update the values.
   */
  public static native void update();

  /**
   * Get the difference between the measurement with and without IR-enlightment
   * from the left sensor.
   * @return measured value
   */
  public static native int getLeftRel();

  /**
   * Get the difference between the measurement with and without IR-enlightment
   * from the right sensor.
   * @return measured value
   */
  public static native int getRightRel();

  /**
   * Get the measured value from the left sensor with IR-enlightment.
   * @return measured value
   */
  public static native int getLeftAbs();

  /**
   * Get the measured value from the right sensor with IR-enlightment.
   * @return measured value
   */
  public static native int getRightAbs();
}



