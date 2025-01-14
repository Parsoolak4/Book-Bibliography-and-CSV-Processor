
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class do_part_1 {
	public static void main(String[] args) {
  Scanner scan=null;
  try {
	  scan=new Scanner(new FileInputStream("books1995.csv.txt"));
	  while (scan.hasNextLine()) {
		  String line = scan.nextLine();
		  // matches commas that are not enclosed in quotation marks. This means that commas inside quotation marks will be ignored
		  String[] fields = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
		  //remove any leading or trailing whitespace from each field.
          String title = fields[0].trim();
          String author= fields[1].trim();
          double price=Double.parseDouble(fields[2].trim()) ;
         String isbn = fields[3].trim();
          String genre = fields[4].trim();
          int year = Integer.parseInt(fields[5].trim());
          
         
          PrintWriter writer = null;
          
       try {
    	   
       if((year<1995) || (year>2010)) {
        	throw new invalidYearException();
        
       }
       }
       catch(invalidYearException e) { 
    	   
    	   
    	   try {
    	        writer = new PrintWriter(new FileWriter("Semantic.error.txt"));
    	        writer.println(e.getMessage());
    	        writer.close();
    	       
    	    } catch (IOException ex) {
    	        System.out.println("An error occurred while writing to file.");
    	        ex.printStackTrace();
    	    }
    	   
       }
          try {
          if(price<0) {
        	  throw new invalidPriceException();
          }
	  }
          catch(invalidPriceException e) {
        	  try {
      	        writer = new PrintWriter(new FileWriter("Semantic.error.txt", true));
      	        writer.println(e.getMessage());
      	        writer.close();
      	       
      	    } catch (IOException ex) {
      	        System.out.println("An error occurred while writing to file.");
      	        ex.printStackTrace();
      	    }
       	   
          }
          try {
          if (isbn.length() == 10) {

              int sum = 0;
              for (int i = 0; i < isbn.length(); i++) {
                  int digit = Character.getNumericValue(isbn.charAt(i));
                  sum += digit * (10 - i);
              }
              if(sum%11!=0) {
            	  throw new invalidISBNException(genre);
              }
          }        
          
           
          else if (isbn.length() == 13) {
            	  

             int sum = 0;
             for (int i = 0; i < isbn.length(); i++) {
                 int digit = Character.getNumericValue(isbn.charAt(i));
                 if (i % 2 == 0) {
                     sum += digit;
                 } else {
                     sum += digit * 3;
                 }
           } 
                  if(sum%10!=0) {
                	  throw new invalidISBNException(genre);
                  }
             }         
          
               
         
         else {
        	
        	  throw new invalidISBNException(genre);
      }
	  }
      catch(invalidISBNException e) {
    	  try {
  		  writer = new PrintWriter(new FileWriter("Semantic.error.txt", true));
  		  writer.println(e.getMessage());
  		  writer.close();
    		} catch (IOException ex) {
    			 System.out.println("An error occurred while writing to file.");
    		    // Handle the exception
    		}
        }
           
            
           
         try {
      	   PrintWriter  pw1=new PrintWriter(new FileOutputStream("Cartoons_Comics_Books.csv.txt"));
          	  if(genre=="CCB") {
      	   pw1.println(line);
      	   pw1.close();
         } 
         }
         catch(FileNotFoundException e) {
          			System.out.println("Error! opening the file : "+"books1995.csv.txt");
          			System.exit(0);
          		}
         PrintWriter pw2=null;
         try {
   		  pw2=new PrintWriter(new FileOutputStream("Hobbies_Collectibles_Books.csv.txt"));
   	  if(genre=="HCB") {
      	   pw2.println(line);
         }}
   	  catch(FileNotFoundException e) {
   			System.out.println("Error! opening the file : "+"Hobbies_Collectibles_Books.csv.txt");
   			System.exit(0);
   		}
        
         try {
      	   PrintWriter  pw3=new PrintWriter(new FileOutputStream("Movies_TV.csv.txt"));
      	   
      	   pw3.print("heyy");
    	   if(genre.equals("MTV")) {
    		 
    		   pw3.print("heyy");
       	   pw3.println(line);
       	   pw3.close();
    		    } }
    	  catch(FileNotFoundException e) {
    			System.out.println("Error! opening the file : "+"Movies_TV.csv.txt");
    			System.exit(0);
    		}
       
         PrintWriter pw4=null;
          try {
      		  pw4=new PrintWriter(new FileOutputStream("Music_Radio_Books.csv.txt"));
      	  if(genre=="MRB") {
         	   pw4.println(line);
            }  }
      	  catch(FileNotFoundException e) {
      			System.out.println("Error! opening the file : "+"Music_Radio_Books.csv.txt");
      			System.exit(0);
      		}
          PrintWriter pw5=null;
            try {
      		  pw5=new PrintWriter(new FileOutputStream("Nostalgia_Eclectic_Books.csv.txt"));
      	 if(genre=="NEB") {
         	   pw5.println(line);
            } }
      	  catch(FileNotFoundException e) {
      			System.out.println("Error! opening the file : "+"Nostalgia_Eclectic_Books.csv.txt");
      			System.exit(0);
      		}
            PrintWriter pw6=null;
            try {
      		  pw6=new PrintWriter(new FileOutputStream("Old_Time_Radio.csv.txt"));
      	  if(genre=="OTR") {
         	   pw6.println(line);
            } } 
      	  catch(FileNotFoundException e) {
      			System.out.println("Error! opening the file : "+" Old_Time_Radio.csv.txt");
      			System.exit(0);
      		}
            PrintWriter pw7=null;
            try {
      		  pw7=new PrintWriter(new FileOutputStream("Sports_Sports_Memorabilia.csv.txt"));
      	 if(genre=="SSM") {
         	   pw7.println(line);
            } }
      	  catch(FileNotFoundException e) {
      			System.out.println("Error! opening the file : "+"  Sports_Sports_Memorabilia.csv.txt");
      			System.exit(0);
      		}
            PrintWriter pw8=null;
            try {
      		  pw8=new PrintWriter(new FileOutputStream("Trains_Planes_Automobiles.csv.txt"));
      	   if(genre=="TPA") {
         	   pw8.println(line);
            }
            }
      	  catch(FileNotFoundException e) {
      			System.out.println("Error! opening the file : "+" Trains_Planes_Automobiles.csv.txt");
      			System.exit(0);
      		}
           
  	  }
  	  
    }
    catch(FileNotFoundException e) {
  		System.out.println("Error! opening the file : "+"books1995.csv.txt");
  		System.exit(0);
    }
	}
	
	String [] cars = {"BMW","LAmbo","Benz"};
	System.out.print()
	
}

  		    