import java.util.Scanner;

public class KSP {
	public static Scanner userInput = new Scanner(System.in);
	public static int thrust;
	public static float massMax, massMin, gravity;
	public static String input; 
	public static boolean commandNotRecognised = false;
	public static boolean allValid = false;
	
	public static void main(String[] args) {
		System.out.println("What to calculate?");
		do {
		input = userInput.nextLine();
		switch(input.toLowerCase()) {
		case "twr":
		case "thrust to weight ratio":
			twr();
			break;			
		case "acc":
		case "acceleration":
			acc();
			break;
		case "stats":
		case "all":
		case "statistics":
		all();
		break;
		case "help":
			System.out.println("thrust to weight ratio(twr), acceleration(acc), all(statistics, stats)");
			commandNotRecognised = true;
		default:
			System.out.println("Command not recognised. To get a list of commands, type 'help'.");
			commandNotRecognised = true;
		}
		}while(commandNotRecognised == true);
		
	
	}
	private static void all() {
		System.out.println("Thrust: ");
		thrust = userInput.nextInt();
		System.out.println("Max Mass: ");
		massMax = userInput.nextInt();
		System.out.println("Min Mass: ");
		massMin = userInput.nextInt();
		System.out.println("Planet: ");
		input = userInput.next();
		switch (input.toLowerCase()) {
		case "kerbin":
			gravity = (float) 9.81;
			break;
		case "moon":
		case "mun": 
			gravity = (float) 1.63;
		}
		}
	private static void acc() {
		// TODO Auto-generated method stub
		
	}
	private static void twr() {
		// TODO Auto-generated method stub
		
	}
	public static void calculate(int thrust, float massMax, float massMin, float g) {
		double twrMax = thrust/(massMin*g);
		double twrMin = thrust/(massMax*g);
		double twrAdv = (twrMax+twrMin)/2;
		double aMax = (twrMax-1)*g;
		double aMin = (twrMin-1)*g;
		double aAdv = (aMax+aMin)/2;

	}

}
