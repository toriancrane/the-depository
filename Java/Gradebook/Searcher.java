//********************************************************************************************************
// CLASS: Searcher(Searcher.java)
//
// DESCRIPTION
// The Searcher class of Project 3
//
// COURSE AND PROJECT INFO
// CSE205 Object Oriented Programming and Data Structures, Spring A 2017
// Project Number: 3
//
// AUTHOR
// Torian Crane (tcrane2@asu.edu)
//********************************************************************************************************
import java.util.ArrayList;

public class Searcher 
{

    public static int search(ArrayList<Student> pList, String pKey) 
    {
        return recBinarySearch(pList, pKey, 0, pList.size() - 1);
    }

    // recursive search used to find the student by last name
    private static int recBinarySearch(ArrayList<Student> pList, String pKey, int pLow, int pHigh) 
    {
        // Base case
        if (pLow > pHigh) 
        {
            return -1;
        }
        int middle = (pLow + pHigh) / 2;

        int result = pList.get(middle).getLastName().compareTo(pKey);

        if (result < 0) 
        {
            // value is less than key, recurse with pLow = middle + 1
            return recBinarySearch(pList, pKey, middle + 1, pHigh);
        } 
        else if (result > 0) 
        {
            // value is greater than key, recurse with pHigh = middle - 1
            return recBinarySearch(pList, pKey, pLow, middle - 1);
        } 
        else 
        {
            // value matches with key; return 'middle'
            return middle;
        }
    }

}
