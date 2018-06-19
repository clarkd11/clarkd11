package com.taphere;

import java.util.Scanner;

import com.taphere.CardDeck;

/**
 * This is a sample program that implements the CardDeck API.  It prompts the user for specific options.
 * The user then specifies which option to choose from.  This program is using Java 8.
 * 
 * @author Daniel Clark
 * @version 1.0 (Java 8)
 * @since 2018-06-18
 *
 */
public class SampleCardProgram {
	
	private static CardDeck cardDeck = new CardDeck();
    private static Scanner scanner = new Scanner(System.in);    

	/**
	 * Main method to run the program
	 * 
	 * @param args String array of arguments passed
	 */
	public static void main(String[] args) {
		promptUser();
	}

	/**
	 *  This method prompts the user to execute specified options.
	 */
	public static void promptUser() {
		System.out.print(
			"**************************************\n" +
			"* Select an option below to execute. *\n" +
			"*                                    *\n" +
		    "* 1 = Shuffle                        *\n" +
			"* 2 = Deal one card                  *\n" +
		    "* 3 = Show remaining cards           *\n" +
			"* 4 = Count remaining cards          *\n" +
			"* 5 = Exit program                   *\n" +
		    "*                                    *\n" +
			"**************************************\n\n" +
		    "Enter option: "
		);
		
        // Read a line of text from the user.
        String input = scanner.nextLine();

        switch (input.trim()) {
        	case "1":	cardDeck.shuffle();
        				break;
        	case "2":	printNextCard();
        				break;
        	case "3":	cardDeck.getDeck().forEach(card->System.out.println(card));
        				break;
        	case "4":	System.out.println(cardDeck.getDeck().size());
        				break;
        	case "5":	System.out.println("Goodbye! Y'all come back ya here!");
        				System.exit(0);
						break;
        	default:	System.out.println("Invalid entry. Try again.");
        				break;
        }
        System.out.println("\nPress Enter to continue...");
        input = scanner.nextLine();
        System.out.println();
        promptUser();
	}
	/**
	 * This method prints out the next card to screen.
	 */
	private static void printNextCard() {
		String card = cardDeck.dealOneCard();
		if (card != null) {
			System.out.println(card);
		} else {
			System.out.println("Deck is empty!");
		}
	}
	
}
