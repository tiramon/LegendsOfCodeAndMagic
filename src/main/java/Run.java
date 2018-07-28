import java.util.Properties;

import com.codingame.gameengine.runner.MultiplayerGameRunner;

public class Run {

	public static void main(String[] args) {

		MultiplayerGameRunner gameRunner = new MultiplayerGameRunner();
		Properties prop = new Properties();
		prop.setProperty("shufflePlayer0Seed", "5907049492976863398");
		prop.setProperty("seed", "266006825144847540");
		prop.setProperty("draftChoicesSeed", "5569108065788591147");
		prop.setProperty("shufflePlayer1Seed", "8876129168052231687");
		gameRunner.setGameParameters(prop);

		gameRunner.addAgent("java -jar d:/Privat/cg/LegendsOfCodeAndMagic/AfterSprint.jar", "Sprint", null);
		gameRunner.addAgent(
				"java -jar d:/Privat/cg/LegendsOfCodeAndMagic/target/LegendsOfCodeAndMagic-0.0.1-SNAPSHOT.jar",
				"current", null);

		gameRunner.start();

	}

}
