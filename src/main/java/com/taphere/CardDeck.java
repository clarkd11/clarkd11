package com.taphere;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

/**
 * This program manages a deck of cards by allowing the user to shuffle and deal one card at a time.
 * This program is using Java 8.
 * 
 * @author Daniel Clark
 * @version 1.0 (Java 8)
 * @since 2018-06-18
 *
 */
public class CardDeck {
	
    private static final String[] SUITS = {"Hearts", "Diamonds", "Clubs", "Spades"};  // The card suits
    private static final String[] RANKS = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};  // The card ranks
    private static final int NUMBER_OF_CARDS = SUITS.length * RANKS.length;  // The total number of cards in an entire deck 
    private Queue<String> shuffledDeck = new LinkedList<String>();  // The product of the shuffling of the working deck
    private String[] workingDeck = new String[NUMBER_OF_CARDS];  // The working deck of cards that does the shuffling
    private int numOfShuffles = 5;  // The default number of times to shuffle
    
    /**
     * Constructor
     */
	public CardDeck() {
		initializeDeck();
	}
	
	/**
	 * This method initializes the card deck by creating a working deck and shuffling. 
	 */
	private void initializeDeck() {
        for (int i = 0; i < RANKS.length; i++) {
            for (int j = 0; j < SUITS.length; j++) {
            	workingDeck[SUITS.length * i + j] = RANKS[i] + " of " + SUITS[j];
            }
        }
        shuffle();
	}
	
	/**
	 * This method shuffles the entire deck the default number of times.
	 */
    public void shuffle() {
    	shuffle(this.numOfShuffles);
    }
    
    /**
     * This method shuffles the entire card deck the designated number of times.
     * 
     * @param numOfShuffles The number of times to shuffle the entire deck.
     */
    public void shuffle(int numOfShuffles) {
    	String swapCard = null;
    	for (int i = 0; i < numOfShuffles; i++) {
    		for (int j = 0; j < NUMBER_OF_CARDS; j++) {
    			int k = j + (int)(Math.random() * (NUMBER_OF_CARDS - j));
    			swapCard = workingDeck[j];
    			workingDeck[j] = workingDeck[k];
    			workingDeck[k] = swapCard;
    		}
    	}
        shuffledDeck = new LinkedList<String>(Arrays.asList(workingDeck));
    }
	
    /**
     * This method sets the default number of shuffles.
     * 
     * @param numOfShuffles The number of times to shuffle the deck
     */
    public void setNumOfShuffles(int numOfShuffles) {
    	this.numOfShuffles = numOfShuffles;
    }
    
    /**
     * This method supplies the set number of default shuffles.
     * The initial default is 5.
     * 
     * @return int The number of default shuffles.
     */
    public int getNumOfShuffles() {
    	return this.numOfShuffles;
    }
    
    /**
     * This method retrieves the next card from the deck.
     * 
     * @return String The next card from the deck.
     */
	public String dealOneCard() {
		String card = null;
		try {
			card = shuffledDeck.remove();
		} catch (NoSuchElementException nsee) {
			// Return no cards because the deck is empty
		}
		return card;
	}
	
	/**
	 * This method supplies the existing/remaining card deck.
	 * 
	 * @return Collection The remaining card deck.
	 */
	public Collection<String> getDeck() {
		return shuffledDeck;
	}
	
}