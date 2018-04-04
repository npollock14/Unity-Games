import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class main {
public static boolean isFirstTurn = true;
public static Scanner userInput = new Scanner(System.in);
public static int health = 5;
public static int weaponDamage;
public static int turn;
public static boolean playing = true;
public static String weapon = ("Fists");
public static String stats = ("Player Stats: " + "Health: "+health+ "   " + "Weapon: " + weapon + ", " + weaponDamage + " Damage");
public static String enemyStats = ("Player Stats: " + "Health: "+health+ "   " + "Weapon: " + weapon + ", " + weaponDamage + " Damage");
	public static void main(String[] args) {
		startMenu();
	}
	public static void startMenu() {
		String cont;
		System.out.println(" ______________________________________________________");
		System.out.println("|                                                      |");
		System.out.println("|                                                      |");
		System.out.println("|                Welcome to the GAME                   |");
		System.out.println("|                                                      |");
		System.out.println("|          Type anything and 'enter' to start!         |");
		System.out.println("|                                                      |");
		System.out.println("|______________________________________________________|");
		cont = userInput.next();
		printStats();
	}
	public static void printStats() {
		if(health>5) {
			health = 5;
		}
		if(weapon == "Fists") {
			weaponDamage = 1;
		} else if(weapon == "Sword") {
			weaponDamage = 3;
		}
		stats = ("Player Stats: " + "Health: "+health+ "   " + "Weapon: " + weapon + ", " + weaponDamage + " Damage");
		System.out.println(stats);
		gm();
	}
public static void gm() {//player can fight, heal, view status, try to flee
		do { System.out.println("Welcome to the GAME");
			
		} while(isFirstTurn == true);
}
}
	


