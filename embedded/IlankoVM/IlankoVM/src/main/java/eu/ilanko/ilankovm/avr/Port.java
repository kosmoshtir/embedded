/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eu.ilanko.ilankovm.avr;

/**
 *
 * @author Lelek
 */
public class Port {
//  public static final boolean INPUT  = false;
//  public static final boolean OUTPUT = true;

  public native void setInput(int bit);
  public native void setOutput(int bit);
  public native void setBit(int bit);
  public native void clrBit(int bit);
}
