package objectPractice;

public class RandomTactics implements Tactics {

	@Override
	public int readTactics() {
		int hand = 0;
		double randomNum = Math.random() * 3;
		if (randomNum < 1) {
			hand = Player.STONE;

		} else if (randomNum < 2) {
			hand = Player.SCISSORS;
		} else {
			hand = Player.PAPER;
		}
		return hand;
	}

}
