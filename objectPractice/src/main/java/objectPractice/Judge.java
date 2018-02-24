package objectPractice;

public class Judge {

	public void startJanken(Player player1, Player player2) {
		// 開始
		mes("【じゃんけん開始】\n");

		// じゃんけん
		for (int count = 0; count < 3; count++) {
			mes("【" + String.valueOf(count + 1) + "回戦目】");

			Player winner = judgeJanken(player1, player2);

			if (winner != null) {
				mes("\n" + winner.getName() + "が勝ちました！\n");
				winner.notifyResult(true);

			} else {
				mes("\n引き分けです！\n");

			}
		}
		// 終了
		mes("【じゃんけん終了】\n");

		// 勝者を判定する
		Player finalWinner = judgeFinelWinner(player1, player2);
		mes(String.valueOf(player1.getWinCount()) + "対" + String.valueOf(player2.getWinCount()) + "で");

		if (finalWinner != null) {
			mes(finalWinner.getName() + "の勝ちです！\n");
		} else {
			mes("引き分けです！\n");
		}
	}

	/**
	 * じゃんけん勝敗の判定 プレイヤーの手を見て、どちらが勝者かを判定する。
	 * 
	 * @param player1
	 * @param player2
	 * @return
	 */
	private Player judgeJanken(Player player1, Player player2) {
		Player winner = null;

		// プレイヤー1の手を出す。
		int player1Hand = player1.showHand();

		// プレイヤー2の手を出す。
		int player2Hand = player2.showHand();

		printHand(player1Hand);
		mes(" vs. ");
		printHand(player2Hand);
		mes("\n");

		if (player1Hand == Player.STONE && player2Hand == Player.SCISSORS
				|| player1Hand == Player.SCISSORS && player2Hand == Player.PAPER
				|| player1Hand == Player.PAPER && player2Hand == Player.STONE) {
			winner = player1;
		} else if (player1Hand == Player.STONE && player2Hand == Player.PAPER
				|| player1Hand == Player.SCISSORS && player2Hand == Player.STONE
				|| player1Hand == Player.PAPER && player2Hand == Player.SCISSORS) {
			winner = player2;
		}
		// どちらでもない場合は引き分けnullを返す

		return winner;
	}

	/**
	 * 最終的な勝者の判定
	 * 
	 * @param player1
	 * @param player2
	 * @return 勝ったプレイヤー。引き分けの場合はnullを返す
	 */
	private Player judgeFinelWinner(Player player1, Player player2) {
		Player winner = null;

		int player1WinCount = player1.getWinCount();
		int player2WinCount = player2.getWinCount();

		if (player1WinCount > player2WinCount) {
			winner = player1;
		} else if (player1WinCount < player2WinCount) {
			winner = player2;
		}

		// どちらでもない場合は引き分け。nullを返す。
		return winner;
	}

	/**
	 * 手を表示する。
	 * 
	 * @param hand
	 */
	private void printHand(int hand) {
		switch (hand) {
		case Player.STONE:
			mes("グー");
			break;
		case Player.SCISSORS:
			mes("チョキ");
			break;
		default:
			mes("パー");

		}
	}

	/**
	 * 出力
	 * 
	 * @param mes
	 */
	public void mes(String mes) {
		StringBuilder sb = new StringBuilder();
		// sb.append("【");
		sb.append(mes);
		// sb.append("】");
		System.out.println(sb.toString());

	}

}
