package com.learn.guava.example.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.common.base.Joiner;

/**
 * This example demonstrate how we can use Guava' Joiner to join together a
 * sequence of string with a separator.
 * 
 * Joining together a sequence of strings with a separator can be unnecessarily
 * tricky - but it shouldn't be.
 * 
 * If your sequence contains nulls, it can be even harder. The Joiner makes it
 * simple as shown below:
 * 
 * @author srimeda
 * 
 */
public class JoinerExample {
	public static void main(String[] args) {

		/**
		 * on() method returns a joiner which automatically places separator
		 * between consecutive elements.
		 * 
		 * skipNulls() skips the null strings while joining.
		 */
		Joiner joiner = Joiner.on(",").skipNulls();

		System.out.println(joiner.join("One", "Two", null, "Four", "Five", null, "Seven"));
															// returns the string "One,Two,Four,Five,Seven".

		/**
		 * Alternative to the use of skipNulls(), we can also use
		 * useForNull(String) to specify a string instead of null.
		 */
		Joiner joiner1 = Joiner.on(",").useForNull("Sample");
		System.out.println(joiner1.join("One", "Two", null, "Four", "Five", null, "Seven"));
											// returns the string "One,Two,Sample,Four,Five,Sample,Seven".
											// It replace null value with 'Sample'

		/**
		 * Using Joiner, we have seen joining variable number of Objects. we can
		 * also join all the Objects in an Iterable, also all the elements in an
		 * array.
		 * 
		 */
		System.out.println(Joiner.on(",").join(Arrays.asList(1, 5, 7)));	// returns 1,5,7
		
		/**
		 * NOTE:
		 * 
		 * 		1. joiner instances are always Immutable. 
		 * 		2. The joiner configuration methods will always return a new Joiner, which you must use to get
		 * 			the desired semantics. This makes Joiner thread-safe, and usable as static final constant.
		 * 
		 */
		
		/**
		 * Below is the comparison of using Joiner's join and joining typical java api style:
		 * 
		 */
		List<String> stringList = new ArrayList<String>();
		stringList.add("One");
		stringList.add("Two");
		stringList.add("Three");
		stringList.add("Four");
		stringList.add("Five");

		System.out.println("String Joined typical style: " + buildString(stringList, ","));

		System.out.println("String Joined using Joiner class: " + Joiner.on(",").skipNulls().join(stringList));
	}

	/**
	 *  Typical Style
	 *  
	 * @param stringList
	 * @param delimiter
	 * @return
	 */
	public static String buildString(List<String> stringList, String delimiter) {

		StringBuilder builder = new StringBuilder();

		for (String s : stringList) {
			if (s != null) {
				builder.append(s).append(delimiter);
			}
		}

		builder.setLength(builder.length() - delimiter.length());

		return builder.toString();
	}

}
