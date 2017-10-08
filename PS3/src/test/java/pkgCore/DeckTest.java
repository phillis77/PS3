package pkgCore;

import static org.junit.Assert.*;

import org.junit.Test;

import pkgEnum.*;
import pkgException.DeckException;

public class DeckTest {

	@Test(expected = DeckException.class)
	public void TestEmptyDeck() throws DeckException {
		Deck d = new Deck();
		for (int i = 1; i < 54; i++) {
			d.Draw();
		}
	}

	@Test
	public void TestDrawSuit() {
		Deck d = new Deck();

		for (eSuit ieSuit : eSuit.values()) {
			Card c = d.Draw(ieSuit);
			assertTrue(c.geteSuit() == ieSuit);
		}
	}

	@Test
	public void TestDrawRank() {
		Deck d = new Deck();
		for (eRank ieRank : eRank.values()) {
			Card c = d.Draw(ieRank);
			assertTrue(c.geteRank() == ieRank);
		}
	}

	@Test
	public void TestDeckRankCount() {
		Deck d = new Deck();
		for (eRank ieRank : eRank.values()) {
			int rankCount = d.cardCounteRank(ieRank);
			assertEquals(rankCount, 4);
		}
	}

	@Test
	public void TestDeckSuitCount() {
		Deck d = new Deck();
		for (eSuit ieSuit : eSuit.values()) {
			int suitCount = d.cardCounteSuit(ieSuit);
			assertEquals(suitCount, 13);
		}
	}

	@Test
	public void TestIsCardLeft() throws DeckException {
		Deck d = new Deck();
		for (int i = 1; i < 53; i++) {
			Card c = d.Draw();
			assertEquals(d.isCardLeft(c.geteSuit(), c.geteRank()), 0);
		}
	}
}
