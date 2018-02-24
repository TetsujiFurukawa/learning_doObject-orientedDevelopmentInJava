package objectPracticeFantanGame;

import objectPracticeCardGameFramework.Card;
import objectPracticeCardGameFramework.Table;

public class FantanTable implements Table {

	private Card[][] table_ = new Card[Card.CARD_NUM][Card.CARD_NUM];

	@Override
	public void putCard(Card[] cards) {

		int suit = cards[0].getSuit();
		int number = cards[0].getNumber();

		table_[suit - 1][number - 1] = cards[0];
	}

	@Override
	public Card[][] getCards() {

		// カードを引く
		return table_.clone();
	}

	public String toString() {
		StringBuffer sb = new StringBuffer();

		for (int suit = 0; suit < Card.SUIT_NUM; suit++) {
			for (int number = 0; number < Card.CARD_NUM; number++) {
				if (table_[suit][number] != null) {
					sb.append(table_[suit][number]);
				} else {
					sb.append("..");
				}
				sb.append("  ");
			}
			sb.append("\n");
		}
		return sb.toString();
	}
}
