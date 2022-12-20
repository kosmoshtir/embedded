/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eu.ilanko.ilankovmtool;
import java.io.*;
import java.util.*;
import gnu.io.*;  // needs to be added to vm
/**
 *
 * @author Lelek
 */
public abstract class Uploader {

  private static Uploader uploader;

  protected Uploader() {
  }

  public abstract void doUpload(String device, int target, int speed, byte[] file, int length);


  public static void upload(String device, int target, int speed, byte[] file, int length){
    uploader.doUpload(device, target, speed, file, length);
  }


  public static void setUploader(String type){
    if (type.equals("nvc1")) {
      uploader = new UploaderNvmCom1();
    } else if (type.equals("nvc2")) {
      uploader = new UploaderNvmCom2();
    } else if (type.equals("ctbot")) {
    //  uploader = new UploaderCtBot();
    }
  }


  public static void main(String[] args) {
    byte[] buffer = null;

    if(args.length != 3) {
      System.out.println("Usage: Uploader device {bitrate|asuro} file");
      System.exit(-1);
    }
    
    // load file into memory
	// nvmcomm2 not enabled here yet.
    try {
      File inputFile = new File(args[2]);
      buffer = new byte[(int)inputFile.length()];      
      FileInputStream in = new FileInputStream(inputFile);
      in.read(buffer);
      in.close();
    } catch(IOException e) {
      System.out.println("Error loading file " + args[2]);
      System.exit(-1);      
    }

    setUploader("nvc1");

    if(args[1].equalsIgnoreCase("asuro"))
      upload(args[0], Config.TARGET_NVC1_ASURO, 2400, buffer, buffer.length);
    else
      upload(args[0], Config.TARGET_NVC1_UART, Integer.parseInt(args[1]), buffer, buffer.length);
  }
}

