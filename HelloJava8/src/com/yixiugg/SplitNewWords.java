package com.yixiugg;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SplitNewWords {

	public static final String FILE_DIR = "/Users/Charlie/Desktop/new word";

	public static void main(String[] args) throws IOException {
		String content = new String(Files.readAllBytes(Paths.get(FILE_DIR)));
		List<Word> words = Arrays.asList(content.split("\n")).stream()
				.filter(l -> Character.isDigit(l.charAt(0)))
				.map(l -> new Word(l)).collect(Collectors.toList());
		words.forEach(w -> w.setLetters(w.getLetters().split(" ")[1]));
		int index = 0;
		for (Word w : words) {
			if (index == 10) {
				System.out.println("\n");
				System.out.println("=========");
				System.out.println("\n");

				index = 0;
			}
			System.out.println(w.getLetters());
			index++;
		}
	}
}
