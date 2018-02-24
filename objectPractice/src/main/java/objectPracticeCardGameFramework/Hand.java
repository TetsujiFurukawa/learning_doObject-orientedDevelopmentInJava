package objectPracticeCardGameFramework;

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
	 * カードを見る
	 * 
	 * @param position
	 *            位置
	 * @return カード
	 */
	public Card lookCard(int position) {
		Card lookingCard = null;

		if ((0 <= position) && (position < hand_.size())) {
			lookingCard = (Card) hand_.get(position);
		}

		return lookingCard;
	}

	/**
	 * カードを引く。
	 * 
	 * @return 引いたカード
	 */
	public Card pickCard(int position) {
		Card pickedCard = null;
		if ((0 <= position) && (position < hand_.size())) {
			pickedCard = (Card) hand_.remove(0);

		}

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
