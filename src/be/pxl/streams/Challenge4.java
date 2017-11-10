package be.pxl.streams;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.DoubleStream;

import be.pxl.streams.Person.Gender;

public class Challenge4 {
	public static void main(String[] args) {
		List<Person> personen = Arrays.asList(
				new Person("Sofie", 23, Gender.FEMALE),
				new Person("Adam", 31, Gender.MALE), 
				new Person("Bastiaan", 25, Gender.MALE),
				new Person("Berend", 22, Gender.MALE), 
				new Person("Aagje", 27, Gender.FEMALE)
		);
		// 1. Geef de gemiddelde leeftijd van alle personen
		// Verwachte output:  Gemiddelde leeftijd: 25.6
		OptionalDouble gemiddeld = personen.stream().mapToInt(Person::getAge).average();
		if (gemiddeld.isPresent()) {
			System.out.println(gemiddeld.getAsDouble());
		}
		
		// 2. Hoeveel mannen staan er in de lijst
		// Verwachte output: Aantal mannen: 3
		long numberOfMen = personen.stream().filter(p -> p.getGender() == Person.Gender.MALE).count();
		System.out.println(numberOfMen);
		
		// 3. Hoeveel mannen ouder dan 24 staan er in de lijst
		// Verwachte output: Aantal mannen boven 24: 2
		System.out.println(
				personen.stream().filter(p -> (p.getGender() == Person.Gender.MALE) && (p.getAge() > 24)).count());
		
		// 4. Geef de gemiddelde leeftijd van alle mannen
		// Gemiddelde leeftijd mannen: 26.0
		OptionalDouble gemiddeldLeeftijdMannen = personen.stream().filter(p -> (p.getGender() == Person.Gender.MALE)).mapToInt(Person::getAge).average();
		if (gemiddeldLeeftijdMannen.isPresent()) {
			System.out.println(gemiddeldLeeftijdMannen.getAsDouble());
		}
		
		// 5. Maak een nieuwe persoon met als naam de eerste letter van iedere persoon in de lijst
		// en als leeftijd de som van alle leeftijden
		// Maak gebruik van de methode .reduce()
		Person nieuwPersoon =
				personen.stream().reduce(new Person("", 0, Gender.MALE), (p1, p2) -> {
					p1.setAge(p1.getAge() + p2.getAge());
					p1.setName(p1.getName() + p2.getName().substring(0,1));
					return p1;
				});
		System.out.println(nieuwPersoon.getName() + " " + nieuwPersoon.getAge() + " " + nieuwPersoon.getGender());
	}
}
