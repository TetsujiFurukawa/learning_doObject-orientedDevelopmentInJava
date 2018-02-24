package objectPracticeOldMaid;

public class Player {

	/** 進行役 */
	private Master master_;

	/** テーブル */
	private Table table_;

	/** 手札 */
	private Hand myHand_ = new Hand();

	/** 名前 */
	private String name_;

	/**
	 * コンストラクタ
	 * 
	 * @param name
	 * @param master
	 * @param table
	 */
	public Player(String name, Master master, Table table) {
		this.name_ = name;
		this.master_ = master;
		this.table_ = table;
	}

	/**
	 * プレイする
	 * 
	 * @param nextPlayer
	 */
	public void play(Player nextPlayer) {

		// 次のプレイヤーに手札を出してもらう
		Hand nextHand = nextPlayer.showHand();

		// 相手のカードから1枚引く
		if (nextHand.getNumberOfCards() == 0) {
			return;
		}
		Card pickedCard = nextHand.pickCard();

		System.out.println(this + ":" + nextPlayer + "さんから" + pickedCard + "を引きました");

		// 引いたカードを自分の手札に加え、同じ数のカードがあったら捨てる
		dealCard(pickedCard);

		// 手札がゼロになったか調べる
		if (myHand_.getNumberOfCards() == 0) {
			// 進行役に上がりを宣言する
			master_.declareWin(this);
		} else {
			// 現在の手札を表示する
			System.out.println(this + "残りの手札は" + myHand_ + "です");

		}
	}

	/**
	 * 手札を見せる。
	 * 
	 * @return
	 */
	public Hand showHand() {
		// もしこの時点で手札がなければあがりとなるので宣言する
		if (myHand_.getNumberOfCards() <= 1) {
			master_.declareWin(this);

		}

		// 手札を見せる前にシャッフルする
		myHand_.shuffle();

		return myHand_;
	}

	/**
	 * カードを受け取る。
	 * 
	 * @param card
	 */
	public void receiveCard(Card card) {
		dealCard(card);
	}

	/**
	 * カードを自分の手札に加え、同じ数のカードがあったら捨てる。
	 * 
	 * @param pickedCard
	 */
	private void dealCard(Card pickedCard) {
		myHand_.addCard(pickedCard);

		Card[] sameCards = myHand_.findSameNumberCard();

		if (sameCards != null) {
			System.out.println(this + ":");
			table_.disposeCard(sameCards);
		}
	}

	/**
	 * プレイヤーの名前を返す。
	 */
	public String toString() {
		return name_;
	}
}
