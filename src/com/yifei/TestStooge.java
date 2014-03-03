package com.yifei;

public class TestStooge {

	public static void main(String[] args) {
		String[] testString = { "hello", "java", "wonderful", "awesome",
				"stooge", "project", "bug" };
		StoogeSortIteration testStooge = new StoogeSortIteration();
		testStooge.sort(testString);
		for (String i : testString) {
			System.out.print(i + " ");
		}
	}

}