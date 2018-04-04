import java.util.Scanner;

public class backwardsWords {
public static Scanner scan = new Scanner(System.in);
public static String userInput;
	public static void main(String[] args) {
		userInput = scan.nextLine();
		char[] cArray = userInput.toCharArray();
		for(int i=cArray.length; i>0;) {
			i--;
			System.out.print(cArray[i]);
		}
	
	}

}
