package objectPractice;

public class ObjectJanken {
	/**
	 * じゃんけんプログラム。
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Judge saito = new Judge();

		Player murata = new Player("村田さん");
		Tactics murataTactics = new StoneOnlyTactics();
		murata.setTactics(murataTactics);

		Player yamada = new Player("山田さん");
		Tactics yamadaTactics = new RandomTactics();
		yamada.setTactics(yamadaTactics);

		// じゃんけん
		saito.startJanken(murata, yamada);

	}

}
