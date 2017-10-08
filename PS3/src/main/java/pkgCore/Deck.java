package pkgCore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.*;

import pkgEnum.eRank;
import pkgEnum.eSuit;

import pkgException.DeckException;

public class Deck {

	private ArrayList<Card> cardsInDeck;

	public Deck() {
		cardsInDeck = new ArrayList<Card>();
		for (eSuit eSuit : eSuit.values()) {
			for (eRank eRank : eRank.values()) {
				this.cardsInDeck.add(new Card(eSuit, eRank));
			}
		}
		Collections.shuffle(cardsInDeck);
	}

	public Card Draw() throws DeckException {
		try {
			if (cardsInDeck.size() == 0) {
				throw new DeckException(this);
			}
		} catch (DeckException e) {
			throw e;
		}
		catch (Exception e) {
			throw e;
		}
		return cardsInDeck.remove(0);
	}


	public Card Draw(eSuit eSuit) {
		for (Card c : cardsInDeck) {
			if (c.geteSuit() == eSuit) {
				cardsInDeck.remove(c);
				return c;
			}
		}
		return null;
	}

	public Card Draw(eRank eRank) {
		for (Card c : cardsInDeck) {
			if (c.geteRank() == eRank) {
				cardsInDeck.remove(c);
				return c;
			}
		}
		return null;
	}

	public int cardCounteSuit(eSuit eSuit) {
		List<Card> cards = cardsInDeck.stream().filter(c -> c.geteSuit() == eSuit).collect(Collectors.toList());
		return cards.size();

	}

	public int cardCounteRank(eRank eRank) {
		List<Card> cards = cardsInDeck.stream().filter(c -> c.geteRank() == eRank).collect(Collectors.toList());
		return cards.size();
	}

	public int isCardLeft(eSuit eSuit, eRank eRank) {
		List<Card> cards = cardsInDeck.stream().filter(c -> c.geteSuit() == eSuit && c.geteRank() == eRank)
				.collect(Collectors.toList());
		if (cards.size() == 0) {
			return 0;
		} else {
			return 1;
		}

	}
}
