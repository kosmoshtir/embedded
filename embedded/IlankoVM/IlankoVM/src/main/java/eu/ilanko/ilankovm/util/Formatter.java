/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eu.ilanko.ilankovm.util;

/**
 *
 * @author Lelek
 */
public class Formatter {
  public static native String format(int val, String format);
  public static native String format(boolean val, String format);
  public static native String format(float val, String format);
}

