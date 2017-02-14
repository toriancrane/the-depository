//********************************************************************************************************
// CLASS: Sorter(Sorter.java)
//
// DESCRIPTION
// The Sorter class of Project 3
//
// COURSE AND PROJECT INFO
// CSE205 Object Oriented Programming and Data Structures, Spring A 2017
// Project Number: 3
//
// AUTHOR
// Torian Crane (tcrane2@asu.edu)
//********************************************************************************************************
import java.util.ArrayList;

public class Sorter 
{

    // Partition the list into 'two' lists (within the same list)
    private static int partition(ArrayList<Student> pList, int pFromIdx, int pToIdx) 
    {
        Student pivot = pList.get(pFromIdx);

        int leftIndex = pFromIdx - 1;
        int rightIndex = pToIdx + 1;

        while (leftIndex < rightIndex) {
            leftIndex++;
            while (pList.get(leftIndex).compareTo(pivot) == -1) 
            {
                leftIndex++;
            }
            rightIndex--;
            while (pList.get(rightIndex).compareTo(pivot) == 1) 
            {
                rightIndex--;
            }
            if (leftIndex < rightIndex) {
                swap(pList, leftIndex, rightIndex);
            }
        }
        return rightIndex;
    }

    // Implementation of the quickSort method from notes
    private static void quickSort(ArrayList<Student> pList, int pFromIdx, int pToIdx) 
    {
        if (pFromIdx < pToIdx) 
        {
            int partitionIndex = partition(pList, pFromIdx, pToIdx);
            quickSort(pList, pFromIdx, partitionIndex);
            quickSort(pList, partitionIndex + 1, pToIdx);
        }
    }

    // Entry point for the Sorter
    public static void sort(ArrayList<Student> pList) 
    {

        quickSort(pList, 0, pList.size() - 1);

    }

    // Method to swap two elements within the list
    private static void swap(ArrayList<Student> pList, int pIdx1, int pIdx2) 
    {
        Student temp = pList.get(pIdx1);
        pList.set(pIdx1, pList.get(pIdx2));
        pList.set(pIdx2, temp);
    }

}
