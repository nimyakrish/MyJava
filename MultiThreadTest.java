package multithreading;

import java.util.Arrays;

public class MultiThreadTest {
	/*
	 * Players Chair Game Play Song When stop Song occupy seat If not get seat
	 * person out remove chair
	 */
	public static void main(String[] args) throws HumanAgeException, NegativeageException {
		ChairGame cgame = new ChairGame(5);
		// set Players
		cgame.setPlayers();
		Music song = new Music();

		while (cgame.numberofPlayers != 1) {
			song.playMusic();
			cgame.playerInRunMode();
			song.stopMusic();

			try {
				cgame.playerThrownOut();
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("Players list have some Problem");
			}
		}
		cgame.getWinner();

	}

}

abstract class Person {
	String name;
	int age;
	char gender;
	Person(String name, int age, char gender){
		this.name = name;
		this.age = age;
		this.gender = gender;
	}
	abstract void play();
}

class Player extends Person implements Runnable {
	Player(String name, int age, char gender) throws HumanAgeException,NegativeageException {
		super(name, age,  gender);
		play();

	}


	@Override
	void play() {
		System.out.println(this.name + " is Playing..");
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 1; i < 3; i++) {
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(name + " is running..." + i + " Round");

		}
	}

}

class ChairGame {
	static int numberofPlayers;
	static int pendingChairs;
	Player[] players;
	Chair[] chairs;
	Player[] outPlayers;

	ChairGame(int numberofPlayers) {
		this.numberofPlayers = numberofPlayers;
		this.pendingChairs = numberofPlayers - 1;

	}

	public void getWinner() {
		// TODO Auto-generated method stub
		System.out.println(players[0].name+" is Winner!!");
		
	}

	public void playerInRunMode() {

		int count = this.getNumberofPlayers();
		Thread[] t = new Thread[count];
		for (int i = 0, j = 1; i < count; i++, j++) { // nullpointerexception
			t[i] = new Thread(players[i]);
			t[i].start();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	public void playerThrownOut() {
		// TODO Auto-generated method stub
		//System.out.println(numberofPlayers);
		int maxval 	= numberofPlayers - 1;
		int minval	= 0;
		int a = (int) (Math.random() * (maxval - minval + 1) + minval);
		try {
			System.out.println("Player " + players[a].name + " is Out!!");
			players[a] = players[(numberofPlayers - 1)];
			players[(numberofPlayers - 1)] = null;
			//System.out.println(Arrays.toString(players));
			System.gc();
			updatenoOfChairs();
		} catch (NoPlayerException e) {
			System.out.println("No such Player");
		} catch (NullPointerException e) {
			System.out.println("No such Player");
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Some error in Player List");
		}

	}

	@Override
	public String toString() {
		return "ChairGame [players=" + Arrays.toString(players) + ", chairs=" + Arrays.toString(chairs)
				+ ", outPlayers=" + Arrays.toString(outPlayers) + "]";
	}

	private static void updatenoOfChairs() {
		numberofPlayers--;
		pendingChairs--;
	}

	public static int getNumberofPlayers() {
		return numberofPlayers;
	}

	public static int getPendingChairs() {
		return pendingChairs;
	}

	public void setPlayers() throws HumanAgeException, NegativeageException {
		int count = this.getNumberofPlayers();
		players = new Player[count];
		chairs = new Chair[count - 1];
		for (int i = 0, j = 1; i < count; i++, j++) { // nullpointerexception
			players[i] = new Player("Player " + j, 15, 'F');
			if (j < count)
				chairs[i] = new Chair();
		}

	}

}

abstract class Sound {

}

class Music extends Sound {
	void playMusic() {
		System.out.println("Music is Playing..");
	}

	void stopMusic() {
		System.out.println("Music is Stopped..");
	}
}

class Chair {
	Chair() {

	}
}

class NochairException extends RuntimeException {
	NochairException(String str) {
		super(str);
	}
}

class NoPlayerException extends RuntimeException {
	NoPlayerException(String str) {
		super(str);
	}
}
class HumanAgeException extends Exception{
	HumanAgeException(String str){
		super(str);
	}	
}
class NegativeageException extends Exception{
	NegativeageException(String str){
		super(str);
	}	
}
class NameException extends Exception{
	NameException(String str){
		super(str);
	}	
}
