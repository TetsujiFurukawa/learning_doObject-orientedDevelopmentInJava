package objectPracticeOldMaid;

import java.util.ArrayList;

public class Table {

	/** 捨てられたカードを格納する */
	private ArrayList<Card> disposedCards_ = new ArrayList<Card>();

	/**
	 * カードを捨てる。
	 * 
	 * @param cards
	 *            捨てるカードの配列
	 */
	public void disposeCard(Card[] cards) {
		for (Card card : cards) {
			System.out.println(card);
			disposedCards_.add(card);
		}
	}
}
