package com.yifei;

import java.io.IOException;
import java.util.Scanner;

public class TestCrawl {

	public static void main(String[] args) throws IOException {
		System.out.println("Give a website start with http://");
		Scanner sc = new Scanner(System.in);
		String site = sc.nextLine();
		sc.close();
		// String site = "http://www.caanes.com/";
		String[] array = Main.processPage(site);
		for (String s : array) {
			System.out.print(s + " ");
		}
	}

}