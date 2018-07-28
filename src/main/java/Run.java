import com.codingame.gameengine.runner.MultiplayerGameRunner;

public class Run {

	public static void main(String[] args) {

		MultiplayerGameRunner gameRunner = new MultiplayerGameRunner();
		// Properties prop = new Properties();
		// prop.setProperty("shufflePlayer0Seed", "5907049492976863398");
		// prop.setProperty("seed", "266006825144847540");
		// prop.setProperty("draftChoicesSeed", "5569108065788591147");
		// prop.setProperty("shufflePlayer1Seed", "8876129168052231687");
		// gameRunner.setGameParameters(prop);

		gameRunner.addAgent("java -jar C:/Users/tiramon/workspace/cg/LegendsOfCodeAndMagic/AfterSprint.jar", "Sprint", null);
		gameRunner.addAgent("java -jar C:/Users/tiramon/workspace/cg/LegendsOfCodeAndMagic/target/LegendsOfCodeAndMagic-0.0.1-SNAPSHOT.jar", "current", null);

		// Properties prop = new Properties();
		// prop.setProperty("shufflePlayer0Seed", "-3229124939997002929");
		// prop.setProperty("seed", "-8849961841640340774");
		// prop.setProperty("draftChoicesSeed", "5200614240935379458");
		// prop.setProperty("shufflePlayer1Seed", "-7703289021269189872");
		// gameRunner.setGameParameters(prop);
		gameRunner.start();

	}

}
