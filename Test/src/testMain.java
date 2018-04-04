import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class testMain {
	public static Scanner scan = new Scanner(System.in);
	public static char[] s = new char[26];
	public static int legnth = (int) (5);

	public static void main(String[] args) {
		for (int k = 0; k < 10;) {
			for (int i = 0; i < legnth; i++) {
				s[i] = randomLetter();
			}
			if (s[0] == s[4] && s[1] == s[3]) {
				k++;
				System.out.println(charArrayToString(s));
			}
		}
	}

	public static char randomLetter() {
		char[] alphabet = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
				's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };
		char random = alphabet[ThreadLocalRandom.current().nextInt(0, 26)];
		return random;

	}

	public static String charArrayToString(char[] hola) {
		String b = new String(hola);
		return b;

	}

	public static boolean isHomologus(char[] hola) {
		for (int i = -1; i < hola.length;) {
			i++;
			if (hola[i] != hola[hola.length - i]) {
				break;
			} else {
				return true;
			}

		}
		return false;
	}
}