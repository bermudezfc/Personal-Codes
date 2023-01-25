
package FileHandling;

import java.io.*;

public class practiceExam4 {
    	public static void main(String[] args) throws IOException {

            // method call
		countAcro();
		
	}

        // method class
	public static void countAcro()throws IOException {
            // read the cleaned txt file
		File filein = new File("C:\\Users\\Gail\\Documents\\NetBeansProjects\\review\\src\\main\\java\\FileHandling\\cleaned.txt");
		BufferedReader br = new BufferedReader(new FileReader(filein));
                
                File fileout = new File("final.txt");
                BufferedWriter bw = new BufferedWriter(new FileWriter(fileout));
                

                //try catch statement for Exception handling
		try {

                        // initialization string called line for while loop
			String lines;
                        // regex string pattern: A-Z for acronym and * asterisk for occurance of multiple times 
                        // while loop that reads the lines until null
			while (((lines = br.readLine()) != null)) {
                            String lowercased = lines.toLowerCase();

                            bw.write(lowercased);
                            bw.write("\n");
				}
                        bw.flush();
                        bw.close();
			}
                        // display of the acronym count
		
                // catch statement for errors
		catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}

}
