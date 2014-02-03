package com.learn.guava.example.strings;

import com.google.common.base.CharMatcher;
import com.google.common.base.Splitter;

/**
 * This example demonstrate the usage and benefits of Guava's Splitter
 * 
 * The built-in Java utilities for splitting can have some quirky behaviors.
 * 	 
 * For example, 
 * 		String.split() silently ignores trailing separators.
 * 		StringTokenizer respects exactly 5 whitespace characters and nothing else.
 * 
 * 
 * Splitters allow complete control over all this confusing behavior.
 * 
 * @author srimeda
 * 
 */
public class SplitterExample {
	public static void main(String[] args) {
		
		/**
		 *  - returns an Iterable<String> containing "one", "two", "three". 
		 *  - trimResults() trims the results if they have any trailing and ending white spaces.
		 *  - omitEmptyStrings() ignores the empty strings if they get any while splitting.

		 * 	A Splitter may be set to split on any Pattern, char, String, or CharMatcher.
		 * 
		 *
		 *  1. Splitter.on(char) - splits on occurrences of specific, individual character.
		 *  
		 */
		Iterable<String> result1 = Splitter.on(',').trimResults().omitEmptyStrings().split("one,two,,   three"); 
		displayResult(result1);
		
	
		/**
		 *  2. Splitter.on(CharMatcher) - splits on occurrences of any character in some category
		 *  
		 */
		Iterable<String> result2 = Splitter.on(CharMatcher.anyOf(";,.")).trimResults().omitEmptyStrings().split("One, Two; Three.Four..Six");
		displayResult(result2);
		
		
		/**
		 *  3. Splitter.on(String) - splits on a string literal
		 *  
		 */
		Iterable<String> result3 = Splitter.on(", ").trimResults().omitEmptyStrings().split("One, Two; Three,Four..Six");
		displayResult(result3); // splits into "One" and "Two; Three,Four..Six"
								// as there is only one entry of comma followed
								// by whitespace in the given string.

		/**
		 *  4. Splitter.on(Pattern)
		 *  	Splitter.onPattern(String) - splits on a regular expression.
		 */
		//	?	The question mark indicates there is zero or one of the preceding element. 
		//  For example, colou?r matches both "color" and "colour".
		displayResult(Splitter.on("\r?\n").split("Sample \n Test\rdfg"));
		
		/**
		 *  5. Splitter.fixedLength(3) - splits strings into substrings of the specified fixed length. 
		 *  		The last piece can be smaller than length, but will never be empty.
		 *  
		 */
		displayResult(Splitter.fixedLength(3).split("1234567"));
		
		/**
		 *  limit() method - stops splitting after the specified number of strings have been returned.
		 *  
		 */
		displayResult(Splitter.on(',').limit(3).split("a,b,c,d,e")); // returns only "a", "b", "c,d,e" as its limited to return only 3 substrings.
		
		/**
		 * Note: 
		 * 
		 * 		1. Splitter instances are always immutable.
		 * 		2. The splitter configuration methods are always return a new Splitter. 
		 * 			This makes any Splitter thread-safe, and usable as a static final constant. 
		 */
	}
	
	public static void displayResult(Iterable<String> iterable){
		for(String s : iterable){
			System.out.println(s);
		}
	}
}
