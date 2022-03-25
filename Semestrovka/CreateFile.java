import java.util.*;
import java.io.File; 
import java.io.FileWriter;
import java.io.IOException;




public class CreateFile {

	public static void createFile(File file) throws IOException {
		try {

			if (!file.exists()) {
				file.createNewFile();
			}

		} catch (IOException e) {
			System.out.println("Error: " + e);
		}

	}
	
	public static void addNumber(File file, int size) throws IOException {

		try {

			int[] numbers = new int[size];
			
			Random rnd = new Random();
			FileWriter fw = new FileWriter(file);

			for (int i = 0; i < numbers.length; i++) {
				numbers[i] = rnd.nextInt(10000);
				fw.write(numbers[i] + " ");
			}
			
			fw.close();

		} catch (IOException e) {
			System.out.println("Error: " + e);	
		}

	}

	public static void main(String[] args)  throws IOException {
		
		File file = new File("data.txt");

		createFile(file);
		int size = 100;
		addNumber(file, size);

		/*
		int counter = 100;
		for (int i = 0; i < 99; i++) {
			addNumber(file, counter);
			counter += 100;
		}
		*/	

	}


}