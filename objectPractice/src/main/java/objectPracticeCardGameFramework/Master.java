package objectPracticeCardGameFramework;

import java.util.ArrayList;

public class Master {

    /** プレイヤーのリスト */
    private ArrayList<Player> players_ = new ArrayList<Player>();

    public void prepareGame(Hand cards) {

	System.out.print("【カードを配ります】");

	// カードをシャッフルする
	cards.shuffle();

	// カードの枚数を取得
	int numberOfCards = cards.getNumberOfCards();

	// プレイヤーの人数を取得
	int numberOfPlayers = players_.size();

	for (int index = 0; index < numberOfCards; index++) {
	    // カードから1枚引く
	    Card card = cards.pickCard(0);

	    // 各プレイヤーに順番にカードを配る
	    Player player = (Player) players_.get(index % numberOfPlayers);
	    player.receiveCard(card);

	}
    }

    /**
     * ゲームを開始する。
     */
    public void startGame() {
	System.out.println("\n【ゲームを開始します】");

	for (int count = 0; players_.size() > 1; count++) {
	    int playerIndex = count % players_.size();

	    int nextPlayerIndex = (count + 1) % players_.size();

	    // 指名するプレイヤーの取得
	    Player player = (Player) players_.get(playerIndex);

	    // 次のプレイヤーの取得
	    Player nextPlayer = (Player) players_.get(nextPlayerIndex);

	    System.out.println("\n" + player + "さんの番です");

	    player.play(nextPlayer);
	}
	System.out.println("ゲームを終了しました");
    }

    /**
     * あがりを宣言する。
     * 
     * @param winner
     */
    public void declareWin(Player winner) {
	System.out.println(winner + "さんが上がりました");

	// 上がったプレイヤーをリストから外す
	deregisterplayer(winner);
    }

    /**
     * プレイヤーを追加する。
     * 
     * @param player
     */
    public void registerPlayer(Player player) {
	players_.add(player);
    }

    public void deregisterplayer(Player player) {
	// 上がったプレイヤーをリストから外す
	players_.remove(players_.indexOf(player));

	if (players_.size() == 1) {
	    Player loser = (Player) players_.get(0);
	    System.out.println(loser + "さんの負けです！");

	}
    }
}
