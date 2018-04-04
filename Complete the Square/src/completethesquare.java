import java.util.Scanner;

public class completethesquare {
	static Scanner userInput = new Scanner(System.in);
	public static int b, a, c, negB, descrimitave, num1, num2, i, denom1, denom2, divisor2, divisor1, opp1, opp2;
	public static boolean isAPerfectSquare = false;
	public static boolean X1HasBeenReduced = false;
	public static boolean X2HasBeenReduced = false;
	public static boolean answer1Set = false;
	public static boolean answer2Set = false;
	public static String answer1, answer2;

	public static void main(String args[]) {
		System.out.print("a: ");
		a = userInput.nextInt();
		System.out.print("b: ");
		b = userInput.nextInt();
		System.out.print("c: ");
		c = userInput.nextInt();
		negB = b * -1;
		descrimitave = (b * b) - (4 * a * c);
		denom1 = 2 * a;
		denom2 = 2 * a;

		if (Math.sqrt(descrimitave) == (int) Math.sqrt(descrimitave)) {
			isAPerfectSquare = true;
			num1 = (negB) + (int) (Math.sqrt(descrimitave));
			num2 = (negB) - ((int) Math.sqrt(descrimitave));

			if ((double) num1 / (double) (denom1) != (int) (num1 / denom1)) { // need to find GCM to reduce by if
																				// num1/denom1 != an integer
				i = 101;
				while (i > 1) {
					i--;
					if ((double)num1 / i == (int) (num1 / i) && (double)denom1 / i == (int) (denom1 / i)) {
						X1HasBeenReduced = true;
						num1 = (int) ((double) (num1) / i);
						denom1 = (int) ((double) (denom1) / i);
						answer1 = ("X: " + num1 + "/" + denom1);
					}
				}
			} else {
				answer1 = ("X: " + num1 / denom1);
				answer1Set = true;
			}
			if ((double) num2 / (double) (denom2) != (int) (num2 / denom2)) { // need to find GCM to reduce by if
																				// num2/denom2 != an integer
				i = 101;
				while (i > 1) {
					i--;
					if ((double) num2 / i == (int) (num2) / i && (double) (denom2) / i == (int) (denom2 / i)) {
						X2HasBeenReduced = true;
						num2 = (int) ((double) (num2) / i);
						denom2 = (int) ((double) (denom2) / i);
						answer2 = ("X: " + num2 + "/" + denom2);
					}
				}
			} else {
				answer2 = ("X: " + num2 / denom2);
				answer2Set = true;
			}
			System.out.println(answer2 + " and " + answer1);
			Factor();
		} else {
			String answer1 = ("X: " + negB + "+ sqrt(" + descrimitave + ")/" + denom1);
			String answer2 = ("X: " + negB + "- sqrt(" + descrimitave + ")/" + denom2);
			System.out.println(answer1 + " and " + answer2);
			Factor();
			
		}
	}
	public static void Factor() {
		double divisor = (double) (2 * a);
		divisor1 = (2 * a);
		divisor2 = (2 * a);
		double negativeb = (double) (-1 * b);
		double bsquared = (double) (b * b);
		double squarerootbefore = (double) (bsquared - ((c) * 4 * a));
		double squarerootafter = Math.sqrt(squarerootbefore);
		double answerpt1 = (double) (squarerootafter / divisor);
		double answerpt2 = (double) (negativeb / divisor);
		double answer1 = (double) (answerpt2 + answerpt1);
		double answer2 = (double) (answerpt2 - answerpt1);
		double numerator1 = negativeb + squarerootafter;
		double numerator2 = negativeb - squarerootafter;

		/*
		 * if (answer1 == answer2 && answer1 < 0) { System.out.println("Factors are: " +
		 * "(x + " + answer1 + ")^2"); return; } else if (answer1 == answer2 && answer1
		 * > 0) { System.out.println("Factors are: " + "(x - " + answer1 + ")^2");
		 * return; }
		 * 
		 * else if (answer1 < 0) { System.out.print("Factors are: " + "(x + " + answer1
		 * * -1 + ")"); } else if (answer1 > 0) { System.out.print("Factors are: " +
		 * "(x - " + answer1 + ")"); } if (answer2 < 0) { System.out.println(" and " +
		 * "(x + " + answer2 * -1 + ")"); } else if (answer2 > 0) {
		 * System.out.println(" and " + "(x - " + answer2 + ")");
		 */
		i = 101;
		while (i > 1) {
			i--;
			if (divisor1 % i == 0 && numerator1 % i == 0) {
				numerator1 = (int) numerator1 / i;
				divisor1 = (int) divisor1 / i;
				opp1 = (int) (numerator1 * -1);
			}
			if (divisor2 % i == 0 && numerator2 % i == 0) {
				numerator2 = (int) numerator2 / i;
				divisor2 = (int) divisor2 / i;
				opp2 = (int) (numerator2 * -1);
			}

		}
		if (divisor1 == 1 && opp1 > 0) {
			System.out.print("Factors are:  (x" + "+" + opp1 + ")");
		} else if (opp1 > 0) {
			System.out.print("Factors are:  (" + divisor1 + "x" + "+" + opp1 + ")");
		}
		if (divisor1 == 1 && opp1 < 0) {
			System.out.print("Factors are:  (x" + opp1 + ")");
		} else if (opp1 < 0) {
			System.out.print("Factors are:  (" + divisor1 + "x" + opp1 + ")");
		}
		if (divisor2 == 1 && opp2 > 0) {
			System.out.print("(x" + "+" + opp2 + ")");
		} else if (opp2 > 0) {
			System.out.print("(" + divisor2 + "x" + "+" + opp2 + ")");
		}
		if (divisor2 == 1 && opp2 < 0) {
			System.out.print("(x" + opp2 + ")");
		} else if (opp2 < 0) {
			System.out.print("(" + divisor2 + "x" + opp2 + ")");
		}

	}

}
