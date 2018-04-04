import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class mathMain {
public static int random1, random2, randomSign;
public static String[] signs = new String[] {"*", "+", "-", "/"};
public static Scanner scan = new Scanner(System.in);
public static int userInput;
	public static void main(String[] args) throws InterruptedException {
		System.out.println("Welcome to mathGame!");
		userInput = scan.nextInt();
		//clear(50);
		countdown(3);
		play(userInput);

	}
public static void play(int times) {
	int i = 0;
	while(i<times) {
		i++;
	int random1 = ThreadLocalRandom.current().nextInt(1, 15);
	int random2 = ThreadLocalRandom.current().nextInt(1, 15);
	int randomSign = ThreadLocalRandom.current().nextInt(0, 3);
	
	System.out.println(random1 + signs[randomSign] + random2 + "=");
	userInput = scan.nextInt();
	if(randomSign == 0 && userInput == random1*random2) {
		System.out.println("You Won");
	}else if(randomSign == 1 && userInput == random1+random2) {
		System.out.println("You Won");
	}else if(randomSign == 2 && userInput == random1-random2) {
		System.out.println("You Won");
	}else if(randomSign == 3 && userInput == random1/random2) {
		System.out.println("You Won");
	}else {
		System.out.println("You Lost!");
	}
	
	
}
}
public static void clear(int lines) {
	for(int i=0; i<lines; i++) {
		System.out.println();
	}
}
public static void countdown(int time) throws InterruptedException {
	
	for(int i=time; i>0; i--) {
		//clear(40);
		System.out.println(i);
	TimeUnit.SECONDS.sleep(1);
	}
}
}
