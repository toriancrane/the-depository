import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
import java.util.HashSet;
import java.io.FileNotFoundException;
import java.io.*;
 
public class Main
{
   public static void main(String[] args) throws FileNotFoundException
   {
     
      ArrayList<Integer> list = new ArrayList<>();
      ArrayList<Integer> runs = new ArrayList<>();
     
      //Display error message if input file can't be opened and immediately terminate program.
      try
      {
        // Prompt for input file names
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter the name of your file, " +
          "to include the file extension (Ex: filename.txt): ");
        String inputFileName = input.next();
        
        //Construct Scanner object for reading.
        File inputFile = new File(inputFileName);
       
        //Scanner object that will read text from inputFile.
        Scanner in = new Scanner(inputFile);
 
        //While loop that populates list with values from inputFile.
        while(in.hasNextInt())
        {
            int value = in.nextInt();
            list.add(value);
        }
        in.close();
               
      } catch (FileNotFoundException pExcept)
      {
         // Print friendly error message
         System.out.println("Sorry, the program could not open 'p01-in.txt' for reading.");
         System.out.println("\nStopping...");
         System.exit(-1);
      }
           
      //Adds the values of BOTH the runsUp and runsDown methods to an ArrayList in the Main method.
      runs.addAll(runsUp(list));
      runs.addAll(runsDown(list));
     
      //Write run information to txt file.
      printRuns(runs);      
           
   }
   static ArrayList<Integer> runsUp(ArrayList<Integer> array)
   {
      int x = 1; //x is used to detetermine position in the arrayList
      int sequence = 0; //used to keep track of each monotonic increase in a sequence.
      ArrayList<Integer> storedSeq = new ArrayList<>();
      int max = array.size();
     
      //Compute Runs Up
      System.out.println();
 
      for(x = 1; x < max; ++x)//A loop to check each element 'x' in the array.
      {
        sequence = 0;
       
        while(x < array.size() && array.get(x) > array.get(x - 1))//A loop to check array element 'x' against 'x - 1') to see if it is increasing.
         {
            sequence = sequence + 1; //The count of how many times it monotonically increases before being false.
            ++x;  
         }
         if(sequence > 0)
            storedSeq.add(sequence); //This keeps track of the repeats stored each time the loop runs.
      }
      return storedSeq;        
   }
   
   static ArrayList<Integer> runsDown(ArrayList<Integer> array)
   {
      int x = 1; //x is used to detetermine position in the arrayList
      int sequence = 0; //used to keep track of each monotonic increase in a sequence.
      ArrayList<Integer> storedSeq = new ArrayList<>();
      int max = array.size();
     
      //Compute Runs Up
      System.out.println();
 
      for(x = 1; x < max; ++x)//A loop to check each element 'x' in the array.
      {
        sequence = 0;
       
        while(x < array.size() && array.get(x - 1) > array.get(x))//A loop to check array element 'x' against 'x - 1') to see if it is increasing.
         {
            sequence = sequence + 1; //The count of how many times it monotonically increases before being false.
            ++x;  
         }
         if(sequence > 0)
            storedSeq.add(sequence); //This keeps track of the repeats stored each time the loop runs.
      }
      return storedSeq;    
   }
   static void printRuns(ArrayList<Integer> sequence) throws FileNotFoundException
   {
      ArrayList<Integer> fullRunsList = new ArrayList<>();
     
      fullRunsList.addAll(sequence);
   
      int total = fullRunsList.size();
     
     
      //Produce output file named p01-runs.txt containing runs total and runs for k = 1 through n-1.
      PrintWriter out = new PrintWriter("p01-runs.txt");
     
      try
      {
         //Compute runs total.      
         for(Integer key : fullRunsList)
         {            
            Collections.frequency(fullRunsList, key);            
         }
         
         out.print("runs_total, " + total);
         out.println();
         
         for(int x = 0; x < fullRunsList.size(); ++x)
         {
            if(x != 0)
            {
               out.print("runs_" + x + ", " + Collections.frequency(fullRunsList, x));
               out.println();
            }
         }
         System.out.println("Your runs have been calculated.");
         System.out.println("\nPlease view the p01-runs.txt file for more info.");
      }
      catch(Exception e)
      {
         e.printStackTrace();
      }
      finally
      {
         out.close();
      }  
   }
}
