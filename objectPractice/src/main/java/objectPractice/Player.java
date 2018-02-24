package objectPractice;

public class Player {

	public static final int STONE = 0;
	public static final int SCISSORS = 1;
	public static final int PAPER = 2;

	private String name_;

	private int winCount_ = 0;

	private Tactics tactics_;

	public Player(String name) {
		name_ = name;
	}

	void setTactics(Tactics tactics) {
		tactics_ = tactics;
	}

	public int showHand() {
		int hand = tactics_.readTactics();
		//
		// double randomNum = Math.random() * 3;
		// if (randomNum < 1) {
		// hand = STONE;
		//
		// } else if (randomNum < 2) {
		// hand = SCISSORS;
		// } else {
		// hand = PAPER;
		// }
		return hand;
	}

	public void notifyResult(boolean result) {
		if (true == result) {
			winCount_++;
		}
	}

	public int getWinCount() {
		return winCount_;
	}

	public String getName() {
		return name_;
	}
}
