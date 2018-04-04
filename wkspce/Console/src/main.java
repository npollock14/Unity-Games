import java.util.Scanner;
	
public class main {
public static Scanner userInput = new Scanner(System.in);
	public static void main(String[] args) {
		switch(getUI()) {
		case help: 
			
		
		default:
		System.out.println("Command not recognised.");
		System.out.println("Enter a valid command");
		System.out.println("type: 'help' for a list of vaild commands");
			break;
				}

	}
	public static String getUI() {
		String scan = userInput.nextLine();
		return scan;
		
	}

}
