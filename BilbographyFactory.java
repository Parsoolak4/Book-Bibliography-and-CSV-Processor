import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;


 /* This program acts as a basic bibliography generator. It takes input files
 * with information on multiple articles and creates three different file types
 * for each input file. These types are IEE, NJ and ACM format files. This is an
 * efficient way to create and store literary sources.
 *
 */
public class BilbographyFactory {

////////////////////////////ATTRIBUTES/////////////////////////////////////
private static Scanner[] scanners = new Scanner[10];
private static PrintWriter[][] printers = new PrintWriter[10][3];
private static File files[][] = new File[10][3];
private static int fileNumber = 0;
private static int counter = 0;
private static int remainder = 10;

/**
*
* @param scan
* @param pwIEEE
* @param pwACM
* @param pwNJ
* @param fileName
*/
public static void processFilesForValidation(Scanner scan, PrintWriter pwIEEE, PrintWriter pwACM, PrintWriter pwNJ,
String fileName) {

String[] info = new String[10];
reinitializeInfoArray(info);
for (int i = 0; i < info.length && scan.hasNextLine(); i++) {

String str = scan.nextLine();

try {
if (str.length() >= info[i].length() && str.substring(0, info[i].length()).equals(info[i])) {
info[i] = str.substring(str.indexOf("{") + 1, str.indexOf("}"));

if (info[i].equals("")) {
throw new FileInvalidException("ERROR: DETECTED EMPTY FIELD!\n============================\n");
}
}

else {
i--;
}
}

catch (FileInvalidException e) {
reinitializeInfoArray(info);

System.out.println(e.getMessage());
System.out.println("PROBLEM DETECTED WITH INPUT FILE: " + fileName + "\nFILE IS INVALID: FIELD "
+ info[i]
+ " IS EMPTY. PROCESSING STOPPED AT THIS POINT. OTHER EMPTY FIELDS MAY BE PRESENT AS WELL!");
counter++;
remainder -= 1;

System.out.println(fileNumber);

files[fileNumber][0].delete();
files[fileNumber][1].delete();
files[fileNumber][2].delete();

break;

}

// After extracting all info, print to file and reset array to scan for next
// publication in latex file

if (i == info.length - 1) {
pwIEEE.println(IEEEFormat(info));
pwACM.println(ACMFormat(info));
pwNJ.println(NJFormat(info));
reinitializeInfoArray(info);
i = -1;
}
}
}

// Resets all array elements to default
/**
*
* @param info
*/
private static void reinitializeInfoArray(String[] info) {
info[0] = "author";
info[1] = "journal";
info[2] = "title";
info[3] = "year";
info[4] = "volume";
info[5] = "number";
info[6] = "pages";
info[7] = "doi";
info[8] = "ISSN";
info[9] = "month";
}

/**
*
* @param str
* @return
*/
private static String ACMFormatExtractFirstAuthor(String str) {
if (str.indexOf(" and") == -1) {
return str;
}
return str.substring(0, str.indexOf(" and")) + " et al. ";
}

// IEEE Format: author, title, journal, "vol."+volume, "no." +number, "p."+
// pages,
// month+year.
/**
* IEEE Format: author, title, journal, "vol."+volume, "no." +number, "p."+pages, month+year.
* @param str
* @return
*/
private static String IEEEFormat(String[] str) {
return str[0] + ". " + '\"' + str[2] + "\", " + str[1] + ", vol. " + str[4] + ", no. " + str[5] + ", p. "
+ str[6] + ", " + str[8] + " " + str[3] + ".";
}

/**
* CM Format: first author et al. year. title. journal. PP, + number +(year),
pages. DOI:https://doi.org/10.1109/TVT.2018.2789899
* @param str
* @return
*/
private static String ACMFormat(String[] str) {
return ACMFormatExtractFirstAuthor(str[0]) + str[3] + (".") + str[2] + ". " + str[1] + ". PP, " + str[5] + "("
+ str[3] + "), " + str[6] + ". DOI: https://doi.org/" + str[7] + ".";
}

/**
*  NJ Format: first author & second author &... . title. journal.
* @param str
* @return
*/
private static String NJFormat(String[] str) {
return str[0].replace("and", "&") + ". " + str[2] + ". " + str[1] + ". PP, " + str[6] + "(" + str[3] + ").";
}

public static void main(String[] args) throws IOException {

System.out.println("WELCOME TO THE BIBLIOGRAPHY FACTORY!\n");

for (int i = 0; i < scanners.length; i++) {

String scannerFileName = "Latex" + (i + 1) + ".bib";
String printerFileNameIEEE = "IEEE" + (i + 1) + ".json";
String printerFileNameACM = "ACM" + (i + 1) + ".json";
String printerFileNameNJ = "NJ" + (i + 1) + ".json";
files[i][0] = new File(printerFileNameIEEE);
files[i][1] = new File(printerFileNameACM);
files[i][2] = new File(printerFileNameNJ);

try {
scanners[i] = new Scanner(new FileInputStream(scannerFileName));
printers[i][0] = new PrintWriter(new FileOutputStream(files[i][0]));
printers[i][1] = new PrintWriter(new FileOutputStream(files[i][1]));
printers[i][2] = new PrintWriter(new FileOutputStream(files[i][2]));

} catch (FileNotFoundException e) { /////////////////////////// CAN DELETE ASK OMAR
System.out.println("Could not open input file " + scannerFileName
+ " for reading. Please check if file exists! Program will terminate after closing any opened files.");
System.exit(0);
}

processFilesForValidation(scanners[i], printers[i][0], printers[i][1], printers[i][2], scannerFileName);
fileNumber++;
scanners[i].close();
printers[i][0].close();
printers[i][1].close();
printers[i][2].close();

}

System.out.println("\nA TOTAL OF " + counter + " FILES WERE INVALID, AND COULD NOT BE PROCESSED. ALL OTHER "
+ remainder + " \"VALID\"" + " FILES HAVE BEEN CREATED");
System.out.println("PLEASE ENTER THE NAME OF ONE OF THE FILES THAT YOU NEED TO REVIEW: \n");

Scanner scan = new Scanner(System.in);
String str = scan.nextLine();
System.out.println();
BufferedReader reader = null;
String out = null;
int entry = 1;
try {
reader = new BufferedReader(new FileReader(str));
out = reader.readLine();

while (out != null) {
System.out.println("[" + entry + "] " + out + '\n');
entry++;
//out = reader.readLine();
}

} catch (FileNotFoundException e) {
System.out.println("COULD NOT OPEN INPUT FILE AGAIN! FILE DNE; POSSIBLY NOT CREATED.");
System.out.println("HOWEVER, YOU WILL BE ALLOWED ANOTHER CHANCE TO ENTER FILE NAME. DON'T FORGET TO ADD .json AT THE END\n");
str = scan.nextLine();
System.out.println();
try {

reader = new BufferedReader(new FileReader(str));
out = reader.readLine();

while (out != null) {
System.out.println("[" + entry + "]" + out + '\n');
entry++;
out = reader.readLine();
}
}

catch(FileNotFoundException j) {
System.out.println("COULD NOT OPEN INPUT FILE AGAIN! FILE DNE; POSSIBLY NOT CREATED.");
System.out.println("SORRY! I AM UNABLE TO DISPLAY DESIRED FILES! PROGRAM WILL EXIT.");

}

catch (IOException i) {
System.out.println("COULD NOT OPEN INPUT FILE AGAIN! FILE DNE; POSSIBLY NOT CREATED.");
System.out.println("SORRY! I AM UNABLE TO DISPLAY DESIRED FILES! PROGRAM WILL EXIT.");
}

}

finally {
if(reader != null)
reader.close();
scan.close();

}

}
}
