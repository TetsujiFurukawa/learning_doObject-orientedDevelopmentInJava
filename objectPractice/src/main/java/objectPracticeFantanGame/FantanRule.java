package objectPracticeFantanGame;

import objectPracticeCardGameFramework.Card;
import objectPracticeCardGameFramework.Hand;
import objectPracticeCardGameFramework.Rule;
import objectPracticeCardGameFramework.Table;

public class FantanRule implements Rule {

	@Override
	public Card[] findCandidate(Hand hand, Table table) {

		Card[] candidate = null;

		int numberOfCard = hand.getNumberOfCards();
		for (int position = 0; position < numberOfCard; position++) {
			// 手札にあるカードを見る
			Card lookingCard = hand.lookCard(position);
			int number = lookingCard.getNumber();
			int suit = lookingCard.getSuit();

			// いま注目している手札の左か右にカードがあればカードを置ける
			int leftNumber = (number != 1) ? number - 1 : Card.CARD_NUM;
			int rightNumber = (number != Card.CARD_NUM) ? number + 1 : 1;

			if ((true == isThereCard(table, suit, leftNumber)) || (true == isThereCard(table, suit, rightNumber))) {
				// 手札からカードを引いて候補とする
				candidate = new Card[1];
				candidate[0] = hand.pickCard(position);
				break;
			}
		}
		return candidate;
	}

	/**
	 * テーブルにカードが並べられているか調べる
	 * 
	 * @param table
	 *            テーブル
	 * @param suit
	 *            スーツ
	 * @param number
	 *            番号
	 * @return カードがおかれている場合はtrue
	 */
	private boolean isThereCard(Table table, int suit, int number) {
		Card[][] cards = table.getCards();
		if (cards[suit - 1][number - 1] != null) {
			return true;
		}
		return false;
	}
}
