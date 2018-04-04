import java.util.Scanner;

public class main {
	public static int a, b, c, y, userChoice, i;
	public String back = "b";
	public static int divisor2, divisor1, opp1, opp2;
	public static Scanner userInput = new Scanner(System.in);

	public static void main(String[] args) {
		printMenu();
		System.out.println();
		PointA();
	}

	public static void printMenu() {
		System.out.println(" ______________________________________________________");
		System.out.println("|                                                      |");
		System.out.println("|                                                      |");
		System.out.println("|      Welcome to the Quadratic Point Finder!          |");
		System.out.println("|                                                      |");
		System.out.println("|  Enter values for a, b and c. Type 'b' to go back!   |");
		System.out.println("|                                                      |");
		System.out.println("|______________________________________________________|");
	}

	public static void clearScreen() {
		for (int i = 0; i < 50; ++i)
			System.out.println();
	}

	public static void PointA() {
		System.out.print("a = ");
		if (userInput.hasNextInt() == true) {
			a = userInput.nextInt();
			PointB();
		} else {
			System.out.println("Please enter a valid integer!");
			return;
		}
	}

	public static void PointA2() {
		System.out.print("a = ");
		if (userInput.hasNextInt() == true) {
			a = userInput.nextInt();
			PointB();
		} else {
			System.out.println("Please enter a valid integer!");
			PointA();
		}
	}

	public static void PointB() {
		System.out.print("b = ");
		if (userInput.hasNextInt()) {
			b = userInput.nextInt();
			PointC();
		} else {
			System.out.println("Please enter a valid integer!");
			PointB2();
		}
	}

	public static void PointB2() {
		System.out.print("b = ");
		if (userInput.hasNextInt()) {
			b = userInput.nextInt();
			PointC();
		} else {
			System.out.println("Please enter a valid integer!");
			PointB();
		}
	}

	public static void PointC() {
		System.out.print("c = ");
		if (userInput.hasNextInt()) {
			c = userInput.nextInt();
			PointXY();
		} else {
			System.out.println("Please enter a valid integer!");
			PointC2();
		}
	}

	public static void PointC2() {
		System.out.print("c = ");
		if (userInput.hasNextInt()) {
			c = userInput.nextInt();
			PointXY();
		} else {
			System.out.println("Please enter a valid integer!");
			PointC();
		}
	}

	public static void PointXY() {
		System.out.print("Solve for X:(1) or Y:(2) or Factor(3): ");
		if (userInput.hasNextInt()) {
			userChoice = userInput.nextInt();
			if (userChoice == 1) {
				solvingForX();
			} else if (userChoice == 2) {
				solvingForY();
			} else if (userChoice == 3) {
				Factor();
			} else if (userChoice == 0) {
				y = 0;
				solvingforXnoY();
			}
		}
	}

	public static void PointXY2() {
		System.out.print("Solve for X:(1) or Y:(2) or Factor(3): ");
		if (userInput.hasNextInt()) {
			userChoice = userInput.nextInt();
			if (userChoice == 1) {
				solvingForX();
			} else if (userChoice == 2) {
				solvingForY();
			} else if (userChoice == 3) {
				Factor();
			} else {
				System.out.println("Please enter a valid entry 1-3.");
				PointXY();
			}
		}

	}

	public static void solvingForY() {
		// if (userChoice == 2) {
		System.out.println("Enter a value of X to solve for: ");
		float x = userInput.nextFloat();

		float xsquared = (float) x * x * a;
		float btimesx = (float) b * x;
		float answer = (float) xsquared + btimesx + c;
		System.out.println();
		System.out.println(xsquared + " + " + btimesx + " + " + c);
		System.out.println();
		System.out.println("Answer = " + answer);
		System.out.println();
	}

	public static void solvingForX() {
		System.out.println("Enter a value of Y to solve for: ");
		double y = (double) userInput.nextFloat();
		double divisor = (double) (2 * a);
		double negativeb = (double) (-1 * b);
		double bsquared = (double) (b * b);
		double squarerootbefore = (double) (bsquared - ((c - y) * 4 * a));
		double squarerootafter = Math.sqrt(squarerootbefore);
		double answerpt1 = (double) (squarerootafter / divisor);
		double answerpt2 = (double) (negativeb / divisor);
		double answer1 = (double) (answerpt2 + answerpt1);
		double answer2 = (double) (answerpt2 - answerpt1);
		double totalsecondthing = Math.sqrt(b * b - (4 * a * (c - y)));
		double inverseb = -1 * b;

		// if (userChoice == 1) {
		System.out.println();
		System.out.println(" Step 1: y=ax^2+bx+c");
		System.out.println();
		System.out.print(y);
		System.out.print("=");
		System.out.print(a);
		System.out.print("x^2 + ");
		System.out.print(b);
		System.out.print("x + ");
		System.out.println(c);
		System.out.println("0 = " + a + "x^2" + b + "x + " + (c - y));
		System.out.println();

		// step 1: The Plain Formula
		System.out.println(" Step 2: x=-b+-sqrtb^2-(4)(a)(c)");
		System.out.println("           _____________________");
		System.out.println("                     2a");

		System.out.println();

		// step 2: Inserted Values
		System.out.println(" Step 3: x=-(" + b + ")" + "+-sqrt" + b + "^2-(4)" + "(" + a + ")" + "(" + (c - y) + ")");
		System.out.println("           _________________________");
		System.out.println("                     2(" + a + ")");

		System.out.println();

		// step 3: Combining
		System.out.println(" Step 4: x=" + -1 * b + "+-sqrt" + b * b + "-(" + 4 * a * (c - y) + ")");
		System.out.println("        ________________");
		System.out.println("            " + 2 * a);

		System.out.println();

		// step 4: Answer
		System.out.println(" Step 5: x=" + -1 * b + "+-sqrt" + (b * b - (4 * a * (c - y))));
		System.out.println("        ____________");
		System.out.println("             " + 2 * a);

		System.out.println();

		System.out.println(" Step 6: x=" + -1 * b + "+-" + Math.sqrt(b * b - (4 * a * (c - y))));
		System.out.println("        ____________");
		System.out.println("             " + 2 * a);

		System.out.println();

		System.out.println(" x=          " + (inverseb + totalsecondthing));
		System.out.println("        ____________");
		System.out.println("             " + 2 * a);

		System.out.println();

		System.out.println(" x=          " + (inverseb - totalsecondthing));
		System.out.println("        ____________");
		System.out.println("             " + 2 * a);

		System.out.println();

		// step 5: Decimal
		System.out.println(" Answer: = (" + answer1 + ", " + y + ")");
		System.out.println(" Answer: = (" + answer2 + ", " + y + ")");

		if (squarerootbefore % (a * a * 4) == 0) {

			System.out.println(
					"Or: " + (-1 * b) / (2 * a) + " +- sqrt" + "(" + (b * b - ((c - y) * 4 * a)) / 4 * a * a + ")");

		} else {

			System.out.println("Square root not able to be simplified!");

		}

	}

	public static void solvingforXnoY() {
		double divisor = (double) (2 * a);
		double negativeb = (double) (-1 * b);
		double bsquared = (double) (b * b);
		double squarerootbefore = (double) (bsquared - ((c) * 4 * a));
		double squarerootafter = Math.sqrt(squarerootbefore);
		double answerpt1 = (double) (squarerootafter / divisor);
		double answerpt2 = (double) (negativeb / divisor);
		double answer1 = (double) (answerpt2 + answerpt1);
		double answer2 = (double) (answerpt2 - answerpt1);
		double totalsecondthing = Math.sqrt(b * b - (4 * a * (c)));
		double inverseb = -1 * b;

		System.out.println();

		System.out.println(" x=          " + (inverseb + totalsecondthing));
		System.out.println("        ____________");
		System.out.println("             " + 2 * a);

		System.out.println();

		System.out.println(" x=          " + (inverseb - totalsecondthing));
		System.out.println("        ____________");
		System.out.println("             " + 2 * a);

		System.out.println();

		// step 5: Decimal
		System.out.println(" Answer: = (" + answer1 + ",0)");
		System.out.println(" Answer: = (" + answer2 + ",0)");

		if (squarerootbefore % (a * a * 4) == 0) {

			System.out.println(
					"Or: " + (-1 * b) / (2 * a) + " +- sqrt" + "(" + (b * b - ((c) * 4 * a)) / 4 * a * a + ")");

		} else {

			System.out.println("Square root not able to be simplified!");

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