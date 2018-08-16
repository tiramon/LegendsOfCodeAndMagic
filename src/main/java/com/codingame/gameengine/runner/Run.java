package com.codingame.gameengine.runner;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import com.codingame.gameengine.runner.dto.GameResult;

public class Run {

	public static void main(String[] args) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, IOException {
		int[] wins = new int[2];
		for (int i = 0; i < 2000; i++) {
			MultiplayerGameRunner gameRunner = new MultiplayerGameRunner();
			// Properties prop = new Properties();
			// prop.setProperty("shufflePlayer0Seed", "5907049492976863398");
			// prop.setProperty("seed", "266006825144847540");
			// prop.setProperty("draftChoicesSeed", "5569108065788591147");
			// prop.setProperty("shufflePlayer1Seed", "8876129168052231687");
			// gameRunner.setGameParameters(prop);

			// gameRunner.addAgent("java -jar C:/Users/tiramon/workspace/cg/LegendsOfCodeAndMagic/AfterSprint.jar", "Sprint", null);
			gameRunner.addAgent("java -jar C:/Users/tiramon/workspace/OldJar/target/OldJar-0.0.1-SNAPSHOT.jar", "top silver", null);
			gameRunner.addAgent("java -jar C:/Users/tiramon/workspace/cg/LegendsOfCodeAndMagic/target/LegendsOfCodeAndMagic-0.0.1-SNAPSHOT.jar", "current", null);
			GameResult result = gameRunner.simulate();
			wins[0] += result.scores.get(0) > 0 ? 1 : 0 + result.scores.get(1) < 0 ? 1 : 0;
			wins[1] += result.scores.get(1) > 0 ? 1 : 0 + result.scores.get(0) < 0 ? 1 : 0;
			List<Agent> players = gameRunner.players;

			if (players != null) {
				for (Agent player : players) {
					Field getProcess = CommandLinePlayerAgent.class.getDeclaredField("process");
					getProcess.setAccessible(true);
					Process process = (Process) getProcess.get(player);
					process.getInputStream().close();
					process.getErrorStream().close();
					process.getOutputStream().close();
					process.destroy();
				}
			}

			MultiplayerGameRunner gameRunnerSwap = new MultiplayerGameRunner();
			Properties prop = new Properties();
			for (String in : result.uinput.get(0).split("\n")) {
				String[] splitted = in.split("=");
				prop.setProperty(splitted[0], splitted[1]);
			}
			gameRunnerSwap.setGameParameters(prop);
			// Properties prop = new Properties();
			// prop.setProperty("shufflePlayer0Seed", "5907049492976863398");
			// prop.setProperty("seed", "266006825144847540");
			// prop.setProperty("draftChoicesSeed", "5569108065788591147");
			// prop.setProperty("shufflePlayer1Seed", "8876129168052231687");
			// gameRunner.setGameParameters(prop);

			gameRunnerSwap.addAgent("java -jar C:/Users/tiramon/workspace/cg/LegendsOfCodeAndMagic/target/LegendsOfCodeAndMagic-0.0.1-SNAPSHOT.jar", "current", null);
			// gameRunnerSwap.addAgent("java -jar C:/Users/tiramon/workspace/cg/LegendsOfCodeAndMagic/AfterSprint.jar", "Sprint", null);
			gameRunnerSwap.addAgent("java -jar C:/Users/tiramon/workspace/OldJar/target/OldJar-0.0.1-SNAPSHOT.jar", "top silver", null);
			GameResult result2 = gameRunnerSwap.simulate();
			wins[1] += result2.scores.get(0) > 0 ? 1 : 0 + result.scores.get(1) < 0 ? 1 : 0;
			wins[0] += result2.scores.get(1) > 0 ? 1 : 0 + result.scores.get(0) < 0 ? 1 : 0;

			List<Agent> players2 = gameRunnerSwap.players;

			if (players2 != null) {
				for (Agent player : players2) {
					Field getProcess = CommandLinePlayerAgent.class.getDeclaredField("process");
					getProcess.setAccessible(true);
					Process process = (Process) getProcess.get(player);
					process.getInputStream().close();
					process.getErrorStream().close();
					process.getOutputStream().close();
					process.destroy();
				}
			}
			// Properties prop = new Properties();
			// prop.setProperty("shufflePlayer0Seed", "-3229124939997002929");
			// prop.setProperty("seed", "-8849961841640340774");
			// prop.setProperty("draftChoicesSeed", "5200614240935379458");
			// prop.setProperty("shufflePlayer1Seed", "-7703289021269189872");
			// gameRunner.setGameParameters(prop);
			System.out.println("score " + Arrays.toString(wins));
		}
	}

}
