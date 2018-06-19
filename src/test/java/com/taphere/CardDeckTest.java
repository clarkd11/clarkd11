package com.taphere;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.Test;

/**
 * This program performs JUnit 4 tests on methods of {@link com.taphere.CardDeck}
 * 
 * @author Daniel Clark
 * @version 1.0 (Java 8)
 * @since 2018-06-18
 *
 */
public class CardDeckTest {

	/**
	 * Tests {@link com.taphere.CardDeck#dealOneCard()}
	 */
	@Test
	public void testDealOneCard() {
		CardDeck cardDeck = new CardDeck();
		String card1 = cardDeck.dealOneCard();
		String card2 = cardDeck.dealOneCard();
		assertNotEquals("card 1 and card 2 are different", card1, card2);
		assertEquals("card count is 50", 50, cardDeck.getDeck().size());
		
		for (int i = 0; i < 50; i++) {
			cardDeck.dealOneCard();
		}
		assertEquals("deck is empty", null, cardDeck.dealOneCard());		
	}

	/**
	 * Tests {@link com.taphere.CardDeck#shuffle()} and {@link com.taphere.CardDeck#shuffle(int)}
	 */
	@Test
	public void testShuffle() {
		List<Collection<String>> shuffledDecks = new ArrayList<Collection<String>>();
		for (int i = 0; i < 100; i++) {
			CardDeck cardDeck = new CardDeck();
			for (int j = 0; j < 50; j++) {
				assertFalse("Duplicate deck default shuffle", shuffledDecks.contains(cardDeck.getDeck()));
				shuffledDecks.add(cardDeck.getDeck());
				cardDeck.shuffle(5);
				assertFalse("Duplicate deck specified shuffle", shuffledDecks.contains(cardDeck.getDeck()));
				shuffledDecks.add(cardDeck.getDeck());
				cardDeck.shuffle();
			}
		}
	}
	
	/**
	 * Tests {@link com.taphere.CardDeck#setNumOfShuffles(int)} and {@link com.taphere.CardDeck#getNumOfShuffles()}
	 */
	@Test
	public void testNumOfShuffles() {
		CardDeck cardDeck = new CardDeck();
		assertEquals("default number of shuffles is 5", 5, cardDeck.getNumOfShuffles());
		cardDeck.setNumOfShuffles(7);
		assertEquals("number of shuffles is 7", 7, cardDeck.getNumOfShuffles());
	}
	
	/**
	 * Tests {@link com.taphere.CardDeck#getDeck()}
	 */
	@Test
	public void testGetDeck() {
		CardDeck cardDeck = new CardDeck();
		assertNotEquals("shuffled deck 1 not null", null, cardDeck.getDeck());
		cardDeck.dealOneCard();
		assertNotEquals("shuffled deck 2 not null", null, cardDeck.getDeck());
		cardDeck.shuffle();
		assertNotEquals("shuffled deck 3 not null", null, cardDeck.getDeck());
	}

}
