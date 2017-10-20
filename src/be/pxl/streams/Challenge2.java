package be.pxl.streams;

import java.util.ArrayList;
import java.util.OptionalInt;
import java.util.Random;

public class Challenge2 {
	public static void main(String[] args) {
		// maak een stream met 10 random gehele getallen tussen 0 en 30
		// bekijk hiervoor de methode ints(...) in de klasse Random
		// filter de getallen die deelbaar zijn door 3
		// en geef het maximum 
		// gebruik eventueel peek() om een tussenresultaat van de stream te tonen
		Random rand = new Random();
		
		ArrayList<Integer> numbers = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			numbers.add(rand.nextInt(31));
		}
		
		OptionalInt maxNumber = numbers.stream().filter(n -> (n % 3 == 0)).mapToInt(Integer::intValue).max();
		if (maxNumber.isPresent()) {
			System.out.println(maxNumber.getAsInt());
		}
		
	}
}
