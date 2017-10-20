package be.pxl.streams;

import java.util.Arrays;
import java.util.List;

public class Challenge3 {
	public static void main(String[] args) {
		List<String> topNames = Arrays.asList(
                "Amelia",
                "Olivia",
                "emily",
                "Isla",
                "Ava",
                "oliver",
                "Jack",
                "Charlie",
                "harry",
                "Jacob"
        );
		// 1. Druk alle namen van de lijst af in gesorteerde volgorde.
		// Zorg dat de eerste letter van een naam steeds met hoofdletter begint.
		topNames.stream().sorted().forEach(s -> System.out.println(s.substring(0, 1).toUpperCase() + s.substring(1)));
		
		// 2. Druk alle namen af die beginnen met A (of a)
		// Zorg dat de eerste letter van een naam steeds met hoofdletter begint.
		// Verwachte output: Amelia Ava
		String namesWithA = topNames.stream().filter(s -> s.substring(0, 1).toLowerCase().equals("a")).reduce("", (acc,el) -> acc + el + " ");
		System.out.println(namesWithA);
		// 3. Hoeveel namen beginnen er met A
		// Verwachte output: 2
		long numberOfNamesWithA = topNames.stream().filter(s -> s.substring(0, 1).toLowerCase().equals("a")).count();
		System.out.println(numberOfNamesWithA);
		
	}
}
