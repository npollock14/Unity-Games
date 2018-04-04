package coolFunctions;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class coolFunctions {
	public static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		String[] bookText = read("C:\\Users\\npoll\\Desktop\\test.txt");
		
		//printIntArray(reduce(scan.nextInt(), 180)); gives fractional radian measure of an angle
	}

	public static double round(double number, int precision) { // rounds to precision
		number = number * java.lang.Math.pow(10, precision);
		number = Math.round(number);
		number = number / java.lang.Math.pow(10, precision);
		return number;
	}

	public static void end(int insta) { // ends
		if (insta == 0) {
			String end;
			end = scan.nextLine();
		} else {
		}
	}

	public static double arraySum(double array[], double arraySum) {
		for (int i = 0; i < array.length; i++) {
			arraySum = array[i] + arraySum;
		}
		return arraySum;
	}

	public static int[] f(int num) {
		int[] factors = new int[num];
		int k = 0;
		for (int i = 0; i < num;) {
			i++;
			if (num % i == 0) {
				factors[k] = i;
				k++;
			}
		}
		return factors;
	}

	public static void countdown(int time) throws InterruptedException {

		for (int i = time; i > 0; i--) {
			// clear(40);
			System.out.println(i);
			TimeUnit.SECONDS.sleep(1);
		}
	}

	public static void clear(int lines) {
		for (int i = 0; i < lines; i++) {
			System.out.println();
		}
	}

	public static void printCleanIntArray(int[] ints) {
		int i;
		for (i = 0; i < ints.length; i++) {
			if (ints[i] == 0){
				break;
			}
		}
			int[] clean = new int[i];
			for(int h=0; h<clean.length; h++) {
				clean[h] = ints[h];
			}
		
		for (i = -1; i < clean.length - 1;) {
			i++;
			System.out.println(clean[i]);
		}
	}
	public static void printIntArray(int[] ints) {
		for (int i = -1; i < ints.length - 1;) {
			i++;
			System.out.println(ints[i]);
		}
	}
	public static int[] reduce(int num, int denom) {
		int[] fraction = new int[2];
		if(num>=denom) {
			for(int i=1; i<num;) {
				i++;
				if(num%i ==0 && denom%i == 0) {
					num = num/i;
					denom = denom/i;
				}
			}
			fraction[0]=num;
			fraction[1]=denom;
		}else {
			for(int k=1; k<denom;) {
				k++;
				if(num%k ==0 && denom%k == 0) {
					num = num/k;
					denom = denom/k;
				}
			}
			fraction[0]=num;
			fraction[1]=denom;
		}
		
		return fraction;
		
	}
	public static String[] read(String location) {
	String[] text = new String[100];
	String line = null;
		int i=0;
    // The name of the file to open.
    String fileLocation = location;

    // This will reference one line at a time

    try {
        // FileReader reads text files in the default encoding.
        FileReader fileReader = 
            new FileReader(fileLocation);

        // Always wrap FileReader in BufferedReader.
        BufferedReader bufferedReader = 
            new BufferedReader(fileReader);

        while((line = bufferedReader.readLine()) != null) {
            text[i] = line;
        	i++;
            
        }   
        
        // Always close files.
        bufferedReader.close();         
    }
    catch(FileNotFoundException ex) {
        System.out.println(
            "Unable to find file '" + 
            fileLocation + "'");                
    }
    catch(IOException ex) {
        System.out.println(
            "Error reading file '" 
            + fileLocation + "'");                  
        // Or we could just do this: 
        // ex.printStackTrace();
    }
    return(text);
	}
	public static void printStringArray(String[] text) {
		for(int i=0; i<text.length;) {
			if(text[i] != null) {
			System.out.println(text[i]);
			}
			i++;
		}
	}
}
