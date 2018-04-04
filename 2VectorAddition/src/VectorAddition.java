import java.util.Scanner;

public class VectorAddition {
	public static Scanner scan = new Scanner(System.in);
	public static int vectors, i, added;
	public static int places = 2; // defaults to two places precision
	public static double mag, angle, xCompSum, yCompSum, resultantAngle, resultantMag;
	public static double[] xComps;
	public static double[] yComps;
	public static String angleString;

	public static void main(String[] args) { // init
		while (vectors <= 0) {
			System.out.println("How many vectors to sum?");
			vectors = scan.nextInt();
			if (vectors <= 0) {
				places = -vectors;
				System.out.println("Rounding to " + places + " decimal places.");

			}
			xComps = new double[vectors];
			yComps = new double[vectors];
		}
		i = 0;
		System.out.println();

		while (i < vectors) { // gathering all magnitudes and angles for comp
			i++;

			System.out.println("Magnitude " + i + ":");
			mag = scan.nextDouble();

			System.out.println("Angle " + i + ":");
			angle = scan.nextDouble();

			yComps[i - 1] = round(Math.sin(Math.toRadians(angle)) * mag, places);
			xComps[i - 1] = round(Math.cos(Math.toRadians(angle)) * mag, places);

			yCompSum = arraySum(yComps, 0);
			xCompSum = arraySum(xComps, 0);
		}

		resultantMag = Math.sqrt((xCompSum * xCompSum) + (yCompSum * yCompSum));
		resultantMag = round(resultantMag, places);

		if (xCompSum > 0 && yCompSum > 0) { // finds quadrant
			resultantAngle = Math.toDegrees(Math.atan(yCompSum / xCompSum));// in quadrant 1
			angleString = "Angle = tan-1("+ round(yCompSum,places) + "/" + round(xCompSum,places) + ") - in quarter 1";
		} else if (xCompSum < 0 && yCompSum > 0) {
			resultantAngle = Math.abs(Math.toDegrees(Math.atan(xCompSum / yCompSum))) + 90;// in quadrant 2
			angleString = "Angle = tan-1("+ round(Math.abs(xCompSum),places) + "/" + round(yCompSum,places) + ") + 90 - in quarter 2";
		} else if (xCompSum < 0 && yCompSum < 0) {
			resultantAngle = Math.toDegrees(Math.atan(yCompSum / xCompSum)) + 180;// in third quadrant
			angleString = "Angle = tan-1("+ round(Math.abs(yCompSum),places) + "/" + round(Math.abs(xCompSum),places) + ") + 180 - in quarter 3";
		} else if (xCompSum > 0 && yCompSum < 0) {
			resultantAngle = Math.abs(Math.toDegrees(Math.atan(xCompSum / yCompSum))) + 270;// in 4th quadrant
			angleString = "Angle = tan-1("+ round(Math.abs(xCompSum),places) + "/" + round(Math.abs(yCompSum),places) + ") + 270 - in quarter 4";
		} else {
			System.out.println("You have no magnitude of vectors!!");
		}
		resultantAngle = round(resultantAngle, places);

		System.out.println(); // answer
		System.out.println("		X-Comps  |  Y-Comps");
		for (int x = 0; x < xComps.length; x++) {
			if (xComps[x] == Math.abs(xComps[x]) && yComps[x] == Math.abs(yComps[x])) { //lines up the |'s mostly
				System.out.println("Vector " + (x + 1) + ":    	    " + round(xComps[x], places) + "  |  " + round(yComps[x], places));
			} else if (xComps[x] != Math.abs(xComps[x]) && yComps[x] == Math.abs(xComps[x])) {
				System.out.println("Vector " + (x + 1) + ":    	   " + round(xComps[x],places) + "  |  " + round(yComps[x],places));
			} else if (xComps[x] == Math.abs(xComps[x]) && yComps[x] != Math.abs(xComps[x])) {
				System.out.println("Vector " + (x + 1) + ":    	    " + round(xComps[x],places) + "  | " + round(yComps[x],places));
			} else if (xComps[x] != Math.abs(xComps[x]) && yComps[x] != Math.abs(xComps[x])) {
				System.out.println("Vector " + (x + 1) + ":    	   " + round(xComps[x],places) + "  | " + round(yComps[x],places));
			}

		}
		System.out.println("__________________________________");
		if (xCompSum == Math.abs(xCompSum) && yCompSum == Math.abs(yCompSum)) {
			System.out.println("Sums:		   " + round(xCompSum, places) + "  |  " + round(yCompSum,places));
		} else if (xCompSum != Math.abs(xCompSum) && yCompSum == Math.abs(yCompSum)) {
			System.out.println("Sums:		  " + round(xCompSum, places) + "  |  " + round(yCompSum,places));
		} else if (xCompSum == Math.abs(xCompSum) && yCompSum != Math.abs(yCompSum)) {
			System.out.println("Sums:		   " + round(xCompSum, places) + "  | " + round(yCompSum,places));
		} else if (xCompSum != Math.abs(xCompSum) && yCompSum != Math.abs(yCompSum)) {
			System.out.println("Sums:		  " + round(xCompSum, places) + "   | " + round(yCompSum,places));
		}
		System.out.println();
		System.out.println("Magnitude = sqrt("+round(xCompSum,places)+"^2 + " + round(yCompSum,places)+"^2)");
		System.out.println(angleString);
		System.out.println();
		System.out.println("The vectors sum to: " + resultantMag + " magnitude and " + resultantAngle + " degrees.");
		//String endMobile = scan.next();
	}

	public static double round(double number, int precision) { // rounds
		number = number * java.lang.Math.pow(10, precision);
		number = Math.round(number);
		number = number / java.lang.Math.pow(10, precision);
		return number;
	}

	public static double arraySum(double array[], double arraySum) { //sums arrays
		for (int i = 0; i < array.length; i++) {
			arraySum = array[i] + arraySum;
		}
		return arraySum;
	}

}
