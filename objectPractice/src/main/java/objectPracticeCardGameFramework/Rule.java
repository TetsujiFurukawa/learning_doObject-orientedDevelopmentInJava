package objectPracticeCardGameFramework;

/**
 * ルールインターフェース
 * 
 */
public interface Rule {

	/**
	 * 
	 * @param hand
	 * @param table
	 * @return
	 */
	public Card[] findCandidate(Hand hand, Table table);
}
