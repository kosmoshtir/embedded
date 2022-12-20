/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eu.ilanko.ilankovm.avr;

/**
 *
 * @author Lelek
 */
public class Pwm {
  // valid prescaler constants
  public static final int STOPPED = 0;
  public static final int DIV1 = 1;
  public static final int DIV8 = 2;
  public static final int DIV64 = 3;
  public static final int DIV128 = 4;
  public static final int DIV1024 = 5;

  // set PWM prescaler value
  public native void setPrescaler(int value);

  // set PWM ratio for selected channel
  public native void setRatio(int value);
}
