package co.grandcircus;

import java.math.BigInteger;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;


public class CountriesApp {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		boolean userQuit = false;
		do {
		
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println("Please choose one of the following: ");
			System.out.println("1. ~Display a list of countries with population~");
			System.out.println("2. ~Add a country to the list~");
			System.out.println("3. ~Quit~");
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			String fileName = "Countries.txt";
			Path filePath = Paths.get("resources", fileName);

			int userIntInput = Validator.getInt(scan, "", 1, 3);
			//System.out.println(userIntInput);
			ArrayList<Country> countryArrList = new ArrayList<>();

			if (userIntInput == 1) {
				CountriesTextFile.readFromFile(filePath);
				for (Country c : countryArrList) {
					System.out.println(c);
				}

			} else if (userIntInput == 2) {
				System.out.println("What country do you want to add?");
				String userCountryAdd = scan.nextLine();
				System.out.println("What's the population?");
				long userPopInput = scan.nextLong();
				BigInteger userPopBigInt = BigInteger.valueOf(userPopInput);
				Country countryObj = new Country(userCountryAdd, userPopBigInt);
				countryArrList.add(countryObj);

				CountriesTextFile.writeCountriesToFile(filePath, countryArrList);

			} else
				userQuit = true;

		} while (!userQuit);
		System.out.println("Goodbye.");
	}

}