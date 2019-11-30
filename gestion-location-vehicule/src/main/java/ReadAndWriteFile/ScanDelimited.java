package ReadAndWriteFile;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ScanDelimited {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 // delimited file
		  File file = new File("src/main/resources/carFile.txt");
		  Scanner sc = null;
		  try {
		   sc = new Scanner(file);
		   // Check if there is another line of input
		   while(sc.hasNextLine()){
		    String str = sc.nextLine();
		    parseLine(str);
		   }
		   
		  } catch (IOException  exp) {
		   // TODO Auto-generated catch block
		   exp.printStackTrace();
		  }
		  
		  sc.close();
		 }
		 
		 private static void parseLine(String str){
		  String book, author, price;
		  Scanner sc = new Scanner(str);
		 // sc.useDelimiter("[|]");
		  sc.useDelimiter(",");

		  // Check if there is another line of input
		  while(sc.hasNext()){
		   book = sc.next();
		   author = sc.next();
		   price = sc.next();
		   System.out.println("Book - " + book + " Author - " + author + 
		     " Price - " + price);  
		  }
		  sc.close();
	}

}
