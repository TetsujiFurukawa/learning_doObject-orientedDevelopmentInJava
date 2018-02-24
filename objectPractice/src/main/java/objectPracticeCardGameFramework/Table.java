package objectPracticeCardGameFramework;

/**
 * テーブルインターフェース
 * 
 */
public interface Table {

	/**
	 * カードを置く
	 * 
	 * @param cards
	 *            カード
	 */
	public void putCard(Card[] cards);

	/**
	 * カードを見る
	 * 
	 * @return テーブルに置かれたカードを表す配列
	 */
	public Card[][] getCards();
}
