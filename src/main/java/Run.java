import com.codingame.gameengine.runner.MultiplayerGameRunner;

public class Run {

	public static void main(String[] args) {

		MultiplayerGameRunner gameRunner = new MultiplayerGameRunner();
		gameRunner.addAgent("java -jar d:/Privat/cg/LegendsOfCodeAndMagic/AfterSprint.jar", "Sprint", null);
		gameRunner.addAgent(
				"java -jar d:/Privat/cg/LegendsOfCodeAndMagic/target/LegendsOfCodeAndMagic-0.0.1-SNAPSHOT.jar",
				"current", null);

		gameRunner.start();
	}

}
