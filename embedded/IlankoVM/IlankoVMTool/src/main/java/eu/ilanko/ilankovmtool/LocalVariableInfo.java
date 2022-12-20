/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eu.ilanko.ilankovmtool;

/**
* A class for storing information about local variables.
* This class represents one row in the LocalVariableTable.
 * @author Lelek
 */
public class LocalVariableInfo {
	public short startPC, length, slot;
	public String name, signature; 

	public LocalVariableInfo(short startPC, short length, String name,
		String signature, short slot) 
	{
		this.startPC = startPC;
		this.length = length;
		this.name = name;
		this.signature = signature;
		this.slot = slot;
	}
}
