
package FileHandling;

import java.io.*;

public class practiceExam3 {
    	public static void main(String[] args) throws IOException {

            // method call
		countAcro();
		
	}

        // method class
	public static void countAcro()throws IOException {
            // read the cleaned txt file
		File file = new File("C:\\Users\\Gail\\Documents\\NetBeansProjects\\review\\src\\main\\java\\FileHandling\\cleaned.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));

                //try catch statement for Exception handling
		try {
                    // initialization value for the acronym count
			int i = 1;
                        // initialization string called line for while loop
			String lines;
                        // regex string pattern: A-Z for acronym and * asterisk for occurance of multiple times 
			String pattern = "([A-Z])*";
                        // while loop that reads the lines until null
			while (((lines = br.readLine()) != null)) {
                            // if statement to match the line read to the regex pattern
				if(lines.matches(pattern)) {
					i++;
				}
			}
                        // display of the acronym count
			System.out.println("Count of Acronyms: "+i);
		} 
                // catch statement for errors
		catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}

}
