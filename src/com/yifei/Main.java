package com.yifei;

import java.io.*;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 * @author Yifei Chen
 * 
 */
public class Main {
	public static void main(String[] args) throws IOException {
		String site = "http://www.caanes.com/";
		String path = "F:/sort.txt";// disk path to store sorted words
		String[] array = processPage(site);
		StoogeSortIteration mySort = new StoogeSortIteration();

		// call the sort method and store the array back
		mySort.sort(array);

		// print out and write the sorted words into a file
		File sortFile = new File(path);
		FileWriter fw2 = new FileWriter(sortFile);
		for (String element : array) {
			System.out.print(element + " ");
			fw2.write(element + "\n");
		}
		fw2.close();
	}

	/**
	 * This method is used for crawling a site, extracting the string words and
	 * then sorting the words and store them into a file in disk
	 * 
	 * @param URL site that needs to be crawled
	 * @return sorted words from the site
	 */
	public static String[] processPage(String URL) throws IOException {

		Document doc = Jsoup.connect(URL).get();
		String initial = doc.toString();
		Document docText = Jsoup.parse(initial);
		String text = docText.text();

		text = text.replaceAll("[^A-Za-z]", " ");// remove all but words
		
		// make the words unique using ArrayList
		String[] textArr = null;
		textArr = text.split("\\s+");
		ArrayList<String> stored = new ArrayList<String>();
		for (String stdata : textArr) {
			if (stdata != null) {
				if (!stored.contains(stdata)) {
					stored.add(stdata);
				}
			}
		}
		// convert the ArrayList to array
		int size = stored.size();
		String[] array = (String[]) stored.toArray(new String[size]);

		return array;
	}
}
