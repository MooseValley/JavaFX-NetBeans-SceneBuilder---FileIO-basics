/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileio;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;

/**
 *
 * @author MichaelO
 */
public class FileIO 
{

    private static void writeFile (String fileNameStr, ArrayList<String> arrayList)
    {
        //Formatter outFile = null;
                
        try (Formatter outFile = new Formatter (fileNameStr) )
        {
            //outFile = new Formatter (fileNameStr);
        
            for (int k = 0; k < arrayList.size(); k++)
            {
                outFile.format (arrayList.get(k) + "\n");
            }
        }
        catch (Exception err)
        {
            System.out.println ("ERROR: could not write file.");
            
            err.printStackTrace();
        }
        //finally
        //{
        //    if (outFile != null)
        //        outFile.close();
        //}
    }
    
    private static ArrayList<String> readFile (String fileNameStr)
    {
        ArrayList<String> arrayList = null;
        //Scanner inFile = null;
        
        try (Scanner inFile = new Scanner(new FileReader (fileNameStr)) )
        {
            //inFile = new Scanner(new FileReader (fileNameStr));
        
            arrayList = new ArrayList<>(); 

            while (inFile.hasNext() == true)
            {
                arrayList.add (inFile.next() );
            }
        }
        catch (Exception err)
        {
            System.out.println ("ERROR: could not read file.");
            
            err.printStackTrace();
        }        
        //finally
        //{
        //    if (inFile != null)
        //        inFile.close();
        //}
        
        return arrayList;        
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        // TODO code application logic here
        // Create an ArrayList and add data to it.
        // Write the ArrayList to file
        // Clear the ArrayList
        // Read in the ArrayList
        // Display the ArrayList
        
        ArrayList<String> namesArrayList = new ArrayList<>();
        
        namesArrayList.add ("Moose");
        namesArrayList.add ("Frankie");
        namesArrayList.add ("Bella");
        
        writeFile ("file.txt", namesArrayList);
        
        namesArrayList.clear();
        
        namesArrayList = readFile ("file.txt");
        
        for (String s : namesArrayList)
        {
            System.out.println (s);
        }
    }
    
}
