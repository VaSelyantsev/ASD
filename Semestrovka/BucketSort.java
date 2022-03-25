import java.util.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.lang.*;

public class BucketSort extends CreateFile {

	public static void bucketSort(int[] array) {
		// создали двумерны массив, который имеет размеры n и rows
		int n = 10; 
		int rows = array.length;
		int[][] bucket = new int[n][rows];

		// создали одномерный массив размером bucket.length
		int[] columnCounter = new int[bucket.length]; 

		// инициализация переменной
		int digits = 1;

		do { 
			// цикл, который заполняем все ячекийки двумерного массива
			// цифрами -1
			for (int i = 0; i < bucket.length; i++) {
				for (int j = 0; j < bucket[0].length; j++) {
					bucket[i][j] = -1; 
				}
			}

			// обнуляем массив
			for (int i = 0; i < bucket.length; i++) {
				columnCounter[i] = 0;
			}

			// вычисление индекса(row), в которую 
			// будет помещаться число 
			for (int i = 0; i < array.length; i++) {

				// например, (156 / 10) % 10 = 5
				// число 156 поместится в ячейку(row) массива 
				// bucket и займет column 0
				int row = (array[i] / digits) % 10; 
				bucket[row][columnCounter[row]] = array[i];

				// увеличиваем row
				columnCounter[row]++;

			}

			// инициализация переменной
			int counter = 0;

			// цикл проверит каждую ячейку массива bucket, 
			// которая не содержит цифру -1
			// если же эта ячейка не содержит -1, то 
			// программа перейдет к строке 56 if блока
			
			for (int i = 0; i < bucket.length; i++) {
				for (int j = 0; j < bucket[0].length; j++) {
					if (bucket[i][j] != -1) {
						array[counter] = bucket[i][j];

						counter++;
						bucket[i][j] = -1;
					} 

				}
			}

		digits *= 10; 

		} while (columnCounter[0] < array.length);


	}

  public static void main(String[] args) throws IOException {

  			int size = 100; 
  			// создание файла
  			File file = new File("data.txt");
  			createFile(file);

  			// получение абсолютного пути
  			String fileName = "C://Praktika/Semestrovka/data.txt";
  			Path path = Paths.get(fileName);

  			// считывание данных из файла в массив строк с помощью split() 
  			Scanner sc = new Scanner(path);

  			for (int z = 0; z < 99; z++) {

  				// массив, в который будут записываться значения
  				int[] array = new int[size];
  				// массив, в который считаются данные из файла (data.txt)	
  				String[] number = new String[size];

	  			while (sc.hasNextLine()) {
	  				String s = sc.nextLine();
	  				// сплитим строку
	  				number = s.split(" ");

	  				// делаю из массива string массив int
	  				for (int i = 0; i < array.length; i++) {
	  					array[i] = Integer.parseInt(number[i]);
	  				}

	  			}


	  			
	  			long timeBegin = System.nanoTime();
	  			// Сортировка
	  			bucketSort(array);
	        long timeEnd = System.nanoTime();
	        System.out.println(timeEnd - timeBegin);
					
	  			// увелечение размера массива 
	  			size += 100;

	  			// заполнение числами массива
	  			addNumber(file, size);

	  			}

    }

}