package FileHandling;
import java.io.*;
import java.util.regex.*;

public class practiceExam1 {
    public static void main(String[] args) throws IOException {
   
            // Read the text file
            File file = new File("C:\\Users\\Gail\\Documents\\NetBeansProjects\\review\\src\\main\\java\\FileHandling\\no_numbers.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));

            // For the output file 
            File fileOut = new File ("no_numbers.txt");
            // for transferring the txt file without digits
		BufferedWriter bw = new BufferedWriter(new FileWriter(fileOut));
		
		try {
                    // initial string line for while loop
			String lines;
                        // while loop until no more lines or null
                        // buffered reader to read each line until it loops again to null
			while (((lines = br.readLine()) != null)) {
                            // string declaration for replacing digits with white lines
                            // also, to use for the output text or the buffered writer
				String clean = (lines.replaceAll("\\d", ""));
                                // writing the txt file with no digits to a new texr file
				bw.write(clean);
                                // for lines
				bw.write("\n");
				
			}	
                        // to flush and close the buffered writer
			bw.flush();
			bw.close();
		} 
                // incase of an error
		catch (IOException e) {
			System.out.println(e.getMessage());
        }
    }
}
