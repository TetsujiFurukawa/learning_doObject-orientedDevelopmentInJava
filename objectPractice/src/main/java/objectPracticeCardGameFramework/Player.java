package objectPracticeCardGameFramework;

public abstract class Player {

	/** 名前 */
	protected String name_;

	/** テーブル */
	protected Table table_;

	/** 手札 */
	protected Hand myHand_ = new Hand();

	/** 進行役 */
	protected Master master_;

	/** ルール */
	protected Rule rule_;

	/**
	 * コンストラクタ
	 * 
	 * @param name
	 * @param master
	 * @param table
	 */
	public Player(String name, Table table, Master master, Rule rule) {
		this.name_ = name;
		this.master_ = master;
		this.table_ = table;
		this.rule_ = rule;
	}

	/**
	 * 順番を指定する 実際の処理はサブクラスで記述する事
	 * 
	 * @param nextPlayer
	 *            次のプレイヤー
	 */
	public abstract void play(Player nextPlayer);

	/**
	 * カードを受け取る。
	 * 
	 * @param card
	 */
	public void receiveCard(Card card) {
		myHand_.addCard(card);
	}

	/**
	 * プレイヤーの名前を返す。
	 */
	public String toString() {
		return name_;
	}
}
