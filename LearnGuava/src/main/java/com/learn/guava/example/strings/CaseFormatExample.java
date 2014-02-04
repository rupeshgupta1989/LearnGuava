package com.learn.guava.example.strings;

import com.google.common.base.CaseFormat;

/**
 * CaseFormat is a handy little class for converting between ASCII case
 * conventions.
 * 
 * @author srimeda
 * 
 */
public class CaseFormatExample {
	public static void main(String[] args) {
		System.out.println(CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, "CONSTANT_NAME")); // returns "constantName"
	}
}
