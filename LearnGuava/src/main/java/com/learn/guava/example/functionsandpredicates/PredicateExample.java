package com.learn.guava.example.functionsandpredicates;

import java.util.List;

import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;

/**
 * Predicates evaluate if something is true or false but can also be combined
 * into more complex evaluations using "and", "or", "not" and "in".
 * 
 * @author srimeda
 * 
 */
public class PredicateExample {
	public static void main(String[] args) {

		Predicate<Integer> evenNumberPolicy = new Predicate<Integer>() {
			@Override
			public boolean apply(Integer number) {
				return (number % 2) == 0;
			}

		};

		List<Integer> numbers = Lists.newArrayList(1, 2, 4, 5, 33, 65, 89);

		/**
		 * It would normally require a for-loop and bunch of if statements.
		 * But now it is reduced to a one-liner. 
		 */
		List<Integer> evenNumbers = Lists.newArrayList(Collections2.filter(numbers, evenNumberPolicy));
		
		for (Integer number : evenNumbers) {
			System.out.println(number);
		}
	}
}