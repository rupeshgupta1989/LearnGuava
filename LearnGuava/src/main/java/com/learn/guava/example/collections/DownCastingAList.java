package com.learn.guava.example.collections;

import java.util.List;

import com.google.common.base.Function;
import com.google.common.collect.Lists;

/**
 * This Example Demonstrate how we can down cast a list from list of super types
 * to list of sub types.
 * 
 * @author srimeda
 * 
 */
public class DownCastingAList {
	public static void main(String[] args) {

		/**
		 * The Function is defined to convert from super type to sub type.
		 * 
		 * @param <F>
		 *            from type
		 * @param <T>
		 *            to type
		 */
		class CastFunction<F, T extends F> implements Function<F, T> {
			@SuppressWarnings("unchecked")
			public T apply(F from) {
				return (T) from;
			}
		}

		final List<Number> originalList = Lists.newArrayList();

		/**
		 * This transforms the given original list of a specific type of objects
		 * to desired sub types of the same objects using the function provided
		 * as an argument
		 */
		final List<Integer> selectedList = Lists.transform(originalList, new CastFunction<Number, Integer>());

		System.out.println(selectedList);
		
		/**
		 *  Without using Guava -
		 *  
		 *  We can do the same without using Guava. But it involves 2 cast operations as shown below:
		 */
		List<Number> numberList = Lists.newArrayList();
		List<Integer> integerList = (List<Integer>) (List<? extends Number>) numberList;
		System.out.println(integerList);
	}

}
