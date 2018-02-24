package objectPractice;

public class StoneOnlyTactics implements Tactics {

	@Override
	public int readTactics() {
		return Player.STONE;
	}

}
