package com.learn.guava.example.strings;

import com.google.common.base.CharMatcher;
import com.google.common.base.Splitter;

/**
 * This example demonstrate Guava's CharMatcher.
 * 
 * We can think of CharMatcher as representing a particular class of characters,
 * like digits or whitespace.
 * 
 * Practically speaking, a CharMatcher is a boolean predicate on characters --
 * indeed, CharMatcher implements Predicate<Character> -- but because it is so
 * common to refer to "all whitespace characters" or "all lowercase letters,"
 * Guava provides this specialized syntax and API for characters.
 * 
 * But the utility of a CharMatcher is in the operations it lets you perform on
 * occurrences of the specified class of characters: trimming, collapsing,
 * removing, retaining, and much more.
 * 
 * An object of type CharMatcher represents notion 1: what constitutes a
 * matching character? It then provides many operations answering notion 2: what
 * to do with those matching characters? The result is that API complexity
 * increases linearly for quadratically increasing flexibility and power.
 * 
 * Note: 
 * 		CharMatcher deals onlu with char values; it does not understand
 * supplementary Unicode code points in the range 0x10000 to 0x10FFFF.
 * 
 * @author srimeda
 * 
 */
public class CharMatcherExample {
	public static void main(String[] args) {
		/**
		 * remove control characters
		 * 
		 * removeFrom(CharSequence)	-- Removes matching characters from the sequence.
		 */
		String noControl = CharMatcher.JAVA_ISO_CONTROL.removeFrom("sample string");
		System.out.println(noControl);
		
		/**
		 * Retains only digits and removes all the non digits
		 * 
		 * retainFrom(CharSequence)	-- Removes all non-matching characters from the sequence.
		 */
		String theDigits = CharMatcher.DIGIT.retainFrom("abcd12ef345"); 
		System.out.println(theDigits); // prints 12345
		
		/**
		 * trim whitespace at ends, and replace/collapse whitespace into single spaces 
		 * 
		 * trimFrom(CharSequence) -- Removes leading and trailing matching characters.
		 * collapseFrom(CharSequence, char)	-- Replace each group of consecutive matched characters with the specified character. 
		 * 				For example, WHITESPACE.collapseFrom(string, ' ') collapses whitespaces down to a single space.
		 * trimAndCollapseFrom(CharSequence, char)	-- Removes the whitespaces at ends, and replace/collapse 
		 * 																whitespaces in single char given.
		 */
		String spaced = CharMatcher.WHITESPACE.trimAndCollapseFrom(" sample       test    ", ' ');
		System.out.println(spaced); // prints 'sample test' 
		
		/**
		 * Star out all digits.
		 * 
		 * Identifies all the digits in the string and replace them with '*'
		 * 
		 * replaceFrom(CharSequence, CharSequence)	-- Replace matching characters with a given sequence.
		 */
		String noDigits = CharMatcher.JAVA_DIGIT.replaceFrom("abcd23sd01", "*");
		System.out.println(noDigits); // prints abcd**sd**
		
		/**
		 * Eliminate all characters that aren't digits or lowercase
		 * 
		 */
		String lowerAndDigit = CharMatcher.JAVA_DIGIT.or(CharMatcher.JAVA_LOWER_CASE).retainFrom("Abe231123sdf@AA");
		System.out.println(lowerAndDigit); // prints be231123sdf
		
		/**
		 * anyOf() example
		 * 
		 * anyOf(CharSequence) -- Returns a char matcher that matches any character present in the given character sequence.
		 */
		Splitter.on(CharMatcher.anyOf(";,.")).split("One, Two; Three.Four..Six");
		
		// CharMatcher has lot more methods.
	}
}
