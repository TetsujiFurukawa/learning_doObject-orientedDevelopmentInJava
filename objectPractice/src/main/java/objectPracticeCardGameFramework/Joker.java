package objectPracticeCardGameFramework;

public class Joker extends Card {

	public Joker() {
		super(0, 0);
	}

	public void setNumber(int number) {
		this.number_ = number;
	}

	public void setSuit(int suit) {
		this.suit_ = suit;
	}

	public String toString() {
		return "JK";
	}
}
