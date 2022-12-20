/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eu.ilanko.ilankovmtool;

/**
 * * A class for storing information about line numbers.
* This class represents one row in the LineNumberTable.
 * @author Lelek
 */
public class LineNumberInfo {
	public short startPC, lineNumber;

	public LineNumberInfo(short startPC, short lineNumber) {
		this.startPC = startPC;
		this.lineNumber = lineNumber;
	}
}
