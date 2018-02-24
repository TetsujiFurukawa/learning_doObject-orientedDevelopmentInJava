package objectPracticeFantanGame;

import objectPracticeCardGameFramework.Card;
import objectPracticeCardGameFramework.Hand;
import objectPracticeCardGameFramework.Master;
import objectPracticeCardGameFramework.Player;
import objectPracticeCardGameFramework.Rule;
import objectPracticeCardGameFramework.Table;

public class Fantan {
	public static void main(String args[]) {

		// 進行役の生成
		Master master = new FantanMaster();

		// テーブルの生成
		Table table = new FantanTable();

		// ルールの生成
		Rule rule = new FantanRule();

		// プレイヤーの生成
		Player murata = new FantanPlayer("村田", table, master, rule);
		Player yamada = new FantanPlayer("山田", table, master, rule);
		Player saito = new FantanPlayer("斉藤", table, master, rule);

		// 進行役へプレイヤーを登録
		master.registerPlayer(murata);
		master.registerPlayer(yamada);
		master.registerPlayer(saito);

		// トランプを生成する
		Hand trump = createTrump();

		// ゲームの準備をする
		master.prepareGame(trump);

		// ゲームを開始する
		master.startGame();
	}

	/**
	 * 53枚のトランプを生成する。
	 * 
	 * @return 生成したトランプ
	 */
	private static Hand createTrump() {
		Hand trump = new Hand();

		// 各スイート53枚のカードを生成する
		for (int number = 1; number <= Card.CARD_NUM; number++) {
			trump.addCard(new Card(Card.SUIT_CLUB, number));
			trump.addCard(new Card(Card.SUIT_DIAMOND, number));
			trump.addCard(new Card(Card.SUIT_HEART, number));
			trump.addCard(new Card(Card.SUIT_SPADE, number));
		}

		return trump;
	}
}
