package objectPracticeCardGameFramework;

public class Card {
	// スペード
	public static final int SUIT_SPADE = 1;
	// ダイヤ
	public static final int SUIT_DIAMOND = 2;
	// クローバー
	public static final int SUIT_CLUB = 3;
	// ハート
	public static final int SUIT_HEART = 4;

	/** スーツの数 */
	public static final int SUIT_NUM = 4;

	/** 値の数 */
	public static int CARD_NUM = 13;

	// カードの種類
	protected int suit_;

	// カードの示す数
	protected int number_;

	// コンストラクタ
	public Card(int suit, int number) {
		this.suit_ = suit;
		this.number_ = number;
	}

	// 数字を見る
	public int getNumber() {
		return number_;
	}

	/** スートを見る */
	public int getSuit() {
		return suit_;
	}

	// カードを文字列で表現する
	public String toString() {
		StringBuffer sb = new StringBuffer();

		if (number_ > 0) {

			// スイートの表示
			switch (suit_) {
			case SUIT_SPADE:
				sb.append("S");
				break;
			case SUIT_DIAMOND:
				sb.append("D");
				break;
			case SUIT_CLUB:
				sb.append("C");
				break;
			case SUIT_HEART:
				sb.append("H");
				break;
			default:
				break;
			}

			// 数の表示
			switch (number_) {
			case 1:
				sb.append("A");
				break;
			case 10:
				sb.append("T");
				break;
			case 11:
				sb.append("J");
				break;
			case 12:
				sb.append("Q");
				break;
			case 13:
				sb.append("K");
				break;
			default:
				sb.append(number_);
				break;
			}
		}
		return sb.toString();
	}
}
