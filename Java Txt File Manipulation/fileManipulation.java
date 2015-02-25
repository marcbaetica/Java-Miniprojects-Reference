import java.io.*;


public class fileManipulation {

	static File f = new File("myfile.txt"); //create file object and name the file

	
	
	public static void main (String[] args) throws IOException { //IOException for an error for file creation
		
		createFile();
		writeToFile();
		readFromFile();
		
	}
	
	
	public static void createFile() {
		//if filename doesn't exist create it
		if (!f.exists()){
			try {
				f.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("New file \"myfile.txt\" has been created to the current directory.");
		} else {
			System.out.println("Did not create file. File already exists.");
		}
	}
	
	
	//inserts text into the file using FileWriter
	public static void writeToFile() {
		FileWriter fs = null;
		BufferedWriter op = new BufferedWriter(fs); //takes in the character and inputs it into the buffer to add it to the text file
		try {
			fs = new FileWriter(f);
			op.write("Hello World.");
			op.close(); //stop writing and close the file once this is done. Do not forget this as it might leave the running application still accessing your text file
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //FileWriter inputs the character string and passes in f as the file to write to. if you don't want that you can use output stream
				
	}
			
	
	//outputs the contents of the text file into your CLI
	public static void readFromFile() throws IOException {
		FileInputStream ifs = new FileInputStream(f); //file f is ready to be read
		DataInputStream in = new DataInputStream(ifs); //reads primitive data type -> new need to convert from machine language into human readable text
		
		BufferedReader br = new BufferedReader(new InputStreamReader(in)); //BufferedReader is just an extra luxury that makes things more efficient. Conversion can also be done directly through InputStreamReader
	
		String str; //put into a string and print it
		while((str = br.readLine()) != null) {
			System.out.println(str);
		}
		
		in.close(); //close the input stream
	}
	
	
	
}
