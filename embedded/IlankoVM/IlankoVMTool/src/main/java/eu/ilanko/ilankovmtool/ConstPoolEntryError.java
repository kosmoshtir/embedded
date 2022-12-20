/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eu.ilanko.ilankovmtool;

/**
 * * An instance of this class is thrown when a ConstPoolEntry is 
* used incorrectly.  For example, calling setUTF(null), or calling 
* getClassName() on an entry of type INT.  It is a subclass of 
* Error instead of Exception because checking for it all the time 
* would make working with ConstPoolEntries very tedious.
 * @author Lelek
 */
public class ConstPoolEntryError extends Error {
	public ConstPoolEntryError(String msg) {
		super(msg);
	}
}
