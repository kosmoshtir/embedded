/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eu.ilanko.ilankovm.io;

/**
 *
 * @author Lelek
 */
public class Lcd {
  public static native void clear();
  public static native void gotoYX(int y, int x);
  public static native void print(String str);
  public static native void print(int num);
  public static native void print(char chr);
}
