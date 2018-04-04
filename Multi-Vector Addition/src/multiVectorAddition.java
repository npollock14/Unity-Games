import java.util.Scanner;

public class multiVectorAddition {
	public static Scanner scan = new Scanner(System.in);
	public static int vectors, i;
	public static double mag, angle, xComps, yComps, resultantAngle, resultantMag, tempX, tempY;
	public static int places = 2; // defaults to two places precision

	public static void main(String[] args) { // init
		while (vectors <= 0) {
			System.out.println("How many vectors to sum?");
			vectors = scan.nextInt();
			if (vectors <= 0) {
				places = vectors * -1;
				System.out.println("Rounding to " + places + " decimal places.");
			}
		}
		i = 0;
		System.out.println();

		while (i < vectors) { //gathering all magnitudes and angles for comp
			i++;

			System.out.println("Magnitude " + i + ":");
			mag = scan.nextDouble();

			System.out.println("Angle " + i + ":");
			angle = scan.nextDouble();

			tempY = round(Math.sin(Math.toRadians(angle)) * mag, places);
			tempX = round(Math.cos(Math.toRadians(angle)) * mag, places);

			if (i == 1) { //runs once
				System.out.println("						X-Comps   Y-Comps");
			}
			System.out.println("				  Vector " + i + ":  	   " + tempX + "     " + tempY);

			yComps = (Math.sin(Math.toRadians(angle)) * mag) + yComps; //adds together x and y comps
			xComps = (Math.cos(Math.toRadians(angle)) * mag) + xComps;
		}
		System.out.println("				  Vector Sum: 	   " + round(xComps, places) + "     " + round(yComps, places));

		resultantMag = Math.sqrt((xComps * xComps) + (yComps * yComps));
		resultantMag = round(resultantMag, places);

		if (xComps > 0 && yComps > 0) { // finds quadrant
			resultantAngle = Math.toDegrees(Math.atan(yComps / xComps));// in quadrant 1
		} else if (xComps < 0 && yComps > 0) {
			resultantAngle = Math.abs(Math.toDegrees(Math.atan(xComps / yComps))) + 90;// in quadrant 2
		}else if (xComps < 0 && yComps < 0) {
			resultantAngle = Math.toDegrees(Math.atan(yComps / xComps)) + 180;// in third quadrant
		}else if (xComps > 0 && yComps < 0) {
			resultantAngle = Math.abs(Math.toDegrees(Math.atan(xComps / yComps))) + 270;// in 4th quadrant
		}else {
			System.out.println("You have no magnitude of vectors!!");
			end(true);
		}
		resultantAngle = round(resultantAngle, places);

		System.out.println(); // answer
		System.out.println("The vectors sum to: " + resultantMag + " magnitude and " + resultantAngle + " degrees.");
		end(true);
	}

	public static double round(double number, int precision) { // rounds
		number = number * java.lang.Math.pow(10, precision);
		number = Math.round(number);
		number = number / java.lang.Math.pow(10, precision);
		return number;
	}
	public static void end(boolean insta){//waits to terminate for mobile
		if(insta = false) {
		String end;
		end = scan.next();
		}else {
		}
	}

}
