package com.learn.guava.example.strings;

import java.io.UnsupportedEncodingException;

import com.google.common.base.Charsets;

/**
 * This Example demonstrate the use of Guava's CharSets.
 * 
 * Charsets contains constant definition for the six standard Charset instances,
 * which are guaranteed to be supported by all Java platform implementations.
 * 
 * Use the constants instead of referring them by their names.
 * 
 * @author srimeda
 * 
 */
public class CharSetsExample {
	public static void main(String[] args) {
		String str = "sample string";
		byte[] bytes;
		
		// Don't do this
		try {
			bytes = str.getBytes("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		// Do this:
		bytes = str.getBytes(Charsets.UTF_8);
		
	}
}
