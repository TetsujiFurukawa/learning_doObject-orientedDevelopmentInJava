package objectPracticeOldMaid;

import java.util.ArrayList;

public class Hand {

	/** カード */
	private ArrayList<Card> hand_ = new ArrayList<Card>();

	/**
	 * カードを加える。
	 * 
	 * @param card
	 *            加えるカード
	 */
	public void addCard(Card card) {
		hand_.add(card);

	}

	/**
	 * カードを引く。
	 * 
	 * @return 引いたカード
	 */
	public Card pickCard() {
		Card pickedCard = (Card) hand_.remove(0);

		return pickedCard;
	}

	/**
	 * シャッフルする。
	 */
	public void shuffle() {
		// 手札の枚数を取得
		int number = hand_.size();

		// カードを抜きだす位置
		int pos;

		// カードをランダムに抜き取って最後に加える動作を繰り返す
		for (int count = 0; count < number * 2; count++) {
			pos = (int) (Math.random() * number);
			Card pickedCard = (Card) hand_.remove(pos);

			// 抜き取ったカードを最後に加える
			hand_.add(pickedCard);
		}
	}

	/**
	 * 枚数を数える。
	 */
	public int getNumberOfCards() {
		return hand_.size();
	}

	/**
	 * 同じ数のカードを探す。
	 * 
	 * @return 同じ数のカード
	 */
	public Card[] findSameNumberCard() {
		int numberOfCards = hand_.size();
		Card[] sameCards = null;

		if (getNumberOfCards() > 0) {
			// 最後に追加されたカードの数字を取得する
			int lastIndex = numberOfCards - 1;
			Card lastAddedCard = (Card) hand_.get(lastIndex);

			int lastAddedCardNum = lastAddedCard.getNumber();

			for (int index = 0; index < lastIndex; index++) {
				Card card = (Card) hand_.get(index);
				if (card.getNumber() == lastAddedCardNum) {
					sameCards = new Card[2];
					sameCards[0] = (Card) hand_.remove(lastIndex);
					sameCards[1] = (Card) hand_.remove(index);

					break;
				}
			}

		}
		return sameCards;

	}

	/**
	 * 手札にあるカードを文字列で表現する。
	 */
	public String toString() {
		StringBuffer sb = new StringBuffer();
		int size = hand_.size();

		if (size > 0) {
			for (Card card : hand_) {
				sb.append(card);
				sb.append(" ");
			}
		}
		return sb.toString();
	}
}
