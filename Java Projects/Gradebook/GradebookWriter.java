//********************************************************************************************************
// CLASS: GradebookWriter(GradebookWriter.java)
//
// DESCRIPTION
// The GradebookWriter class of Project 3
//
// COURSE AND PROJECT INFO
// CSE205 Object Oriented Programming and Data Structures, Spring A 2017
// Project Number: 3
//
// AUTHOR
// Torian Crane (tcrane2@asu.edu)
//********************************************************************************************************

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * GradebookWriter inherits from PrintWriter and writes the gradebook info to the file name passed to the ctor.
 */
public class GradebookWriter extends PrintWriter 
{

    private PrintWriter mOut;

    /**
     * GradebookWriter()
     * Call the super class ctor that takes a String.
     */
    public GradebookWriter(String pFname) throws FileNotFoundException 
    {
        super(new File(pFname));
        mOut = this;
    }

    /**
     * writeGradebook()
     * Writes the gradebook info to the file, which was opened in the ctor.
     *
     * PSEUDOCODE:
     * EnhancedFor each student in pRoster.getStudentList() Do
     *    Call println(student)
     * End For
     * Call close()
     */
    public void writeGradebook(Roster pRoster) 
    {

        for (Student student : pRoster.getStudentList()) 
        {
            mOut.println(student);
        }
        mOut.close();
    }
}
