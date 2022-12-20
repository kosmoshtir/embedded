/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eu.ilanko.ilankovmtool;

/**
 * A class for storing information about methods.
 * @author Lelek
 */
public class UsedFeatures {
  static final int LOOKUPSWITCH = (1<<0);
  static final int TABLESWITCH  = (1<<1);
  static final int BIT32        = (1<<2);
  static final int FLOAT        = (1<<3);
  static final int ARRAY        = (1<<4);
  static final int INHERITANCE  = (1<<5);
  static final int EXTSTACK     = (1<<6);

  private static int features;

  public static void add(int f){
    features |= f;
  }
  
  public static int get(){
    System.out.println("Feature value is 0x"+Integer.toHexString(features));
    return features;
  }

}