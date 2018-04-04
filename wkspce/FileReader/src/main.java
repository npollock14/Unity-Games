import java.io.*;

public class main {
	public static int i;
	public static String[] text = new String[100];
	public static String line;
    public static void main(String [] args) {
    	i=0;
        // The name of the file to open.
        String fileLocation = "C:\\Users\\npoll\\Desktop\\test.txt";

        // This will reference one line at a time
        line = null;

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
        System.out.println(text[2]);
    }
}