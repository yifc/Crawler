package com.yifei;

import java.util.Stack;

/**
 * @author Yifei Chen
 *
 */
public class StoogeSortIteration {
	public class stackElem {
		private int start;
		private int end;

		public stackElem(int a, int b) {
			this.start = a;
			this.end = b;
		}
	}	
	/**
	 * This method is to sort the array using stack and iteration, instead of recursion
	 * @param array Strings that needs to be sorted
	 */
	void sort(String[] array) {
		Stack<stackElem> stack = new Stack<stackElem>();
		stack.push(new stackElem(0, array.length - 1));
		while (!stack.empty()) {
			stackElem presentElement = stack.pop();
			int start = presentElement.start;
			int end = presentElement.end;
			//if the last one's length is smaller than first's, then swap them
			if (array[end].length() < array[start].length()) {
				String temp = array[start];
				array[start] = array[end];
				array[end] = temp;
			}
			if ((end - start + 1) >= 3) {
				int third = (end - start + 1) / 3;
				//using stack to simulate recursion
				stack.push(new stackElem(start, end - third));
				stack.push(new stackElem(start + third, end));
				stack.push(new stackElem(start, end - third));
			}
		}
	}
}
