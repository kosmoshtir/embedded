/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eu.ilanko.ilankovm.drivers;

/**
 * Provides methods to send and receive RC5-IR-codes.
 * @author Lelek
 */
public class IrTransceiver {

  /**
   * Get last received command
   * @return received RC5 code, 0 for no command
   */
  public static native int getCommand();
  
  /**
   * Transmitt command
   * @param command RC5 code to transmitt
   */
  public static native int sendCommand(int command);
}
