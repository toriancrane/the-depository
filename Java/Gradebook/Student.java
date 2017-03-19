//********************************************************************************************************
// CLASS: Student(Student.java)
//
// DESCRIPTION
// The Student class of Project 3
//
// COURSE AND PROJECT INFO
// CSE205 Object Oriented Programming and Data Structures, Spring A 2017
// Project Number: 3
//
// AUTHOR
// Torian Crane (tcrane2@asu.edu)
//********************************************************************************************************

import java.util.ArrayList;

/**
 * The Student class stores the grade information for one Student.
 */
public class Student implements Comparable<Student> 
{

    // Declare the instance variables.
    private String mFirstName;
    private String mLastName;
    private ArrayList<Integer> mExamList;
    private ArrayList<Integer> mHomeworkList;

    /**
     * Student()
     *
     * PSEUDOCODE:
     * Save pFirstName and pLastName.
     * Create mExamList
     * Create mHomeworkList
     */
    public Student(String pFirstName, String pLastName) 
    {
        mFirstName = pFirstName;
        mLastName = pLastName;
        mExamList = new ArrayList<>();
        mHomeworkList = new ArrayList<>();
    }

    /**
     * addExam()
     *
     * PSEUDOCODE:
     * Call add(pScore) on getExamList() to add a new exam score to the list of exam scores.
     */
    public void addExam(int pScore) 
    {
        getExamList().add(pScore);
    }

    /**
     * addHomework()
     *
     * PSEUDOCODE:
     * Call add(pScore) on getHomeworkList() to add a new homework score to the list of homework scores.
     */
    public void addHomework(int pScore) 
    {
        getHomeworkList().add(pScore);
    }

    /**
     * compareTo()
     *
     * PSEUDOCODE:
     * Return: -1 if the last name of this Student is < the last name of pStudent
     * Return:  0 if the last name of this Student is = the last name of pStudent
     * Return:  1 if the last name of this Student is > the last name of pStudent
     * Hint: the last names are Strings.
     */
    @Override
    public int compareTo(Student pStudent) 
    {
        int result = this.getLastName().compareTo(pStudent.getLastName());

        if (result > 0) 
        {
            result = 1;
        } 
        else if (result < 0) 
        {
            result = -1;
        }
        return result;
    }

    /**
     * getExam()
     *
     * Accessor method to retreive an exam score from the list of exams.
     */
    public int getExam(int pNum) 
    {
        return getExamList().get(pNum);
    }

    /**
     * getExamList()
     *
     * Accessor method for mExamList.
     */
    protected ArrayList<Integer> getExamList() 
    {
        return mExamList;
    }

    /**
     * getFirstName()
     *
     * Accessor method for mFirstName.
     */
    public String getFirstName() 
    {
        return mFirstName;
    }

    /**
     * getHomework()
     *
     * Accessor method to retrieve a homework score from the list of homeworks.
     */
    public int getHomework(int pNum) 
    {
        return getHomeworkList().get(pNum);
    }

    /**
     * getHomeworkList()
     *
     * Accessor method for mHomeworkList.
     */
    protected ArrayList<Integer> getHomeworkList() 
    {
        return mHomeworkList;
    }

    /**
     * getLastname()
     *
     * Accessor method for mLastName.
     */
    public String getLastName() 
    {
        return mLastName;
    }

    /**
     * setExam()
     *
     * Mutator method to store an exam score into the list of exam scores.
     */
    public void setExam(int pNum, int pScore) 
    {
        getExamList().set(pNum, pScore);
    }

    /**
     * setExamList()
     *
     * Mutator method for mExamList.
     */
    protected void setExamList(ArrayList<Integer> pExamList) 
    {
        mExamList = pExamList;
    }

    /**
     * setFirstName()
     *
     * Mutator method for mFirstName.
     */
    public void setFirstName(String pFirstName) 
    {
        mFirstName = pFirstName;
    }

    /**
     * setHomework()
     *
     * Mutator method to store a homework score into the list of homework
     * scores.
     */
    public void setHomework(int pNum, int pScore) 
    {
        getHomeworkList().set(pNum, pScore);
    }

    /**
     * setHomeworkList()
     *
     * Mutator method for mHomeworkList.
     */
    protected void setHomeworkList(ArrayList<Integer> pHomeworkList) 
    {
        mHomeworkList = pHomeworkList;
    }

    /**
     * setLastname()
     *
     * Mutator method for mLastName.
     */
    public void setLastName(String pLastName) 
    {
        mLastName = pLastName;
    }

    /**
     * toString()
     *
     * Returns a String representation of this Student. The format of the
     * returned string shall be such that the Student information can be printed
     * to the output file, i.e:
     *
     * lastname firstname hw1 hw2 hw3 hw4 exam1 exam2
     */
    @Override
    public String toString() 
    {
        String result = getLastName() + " " + getFirstName() + " ";
        for (Integer grade : getHomeworkList()) 
        {
            result = result + grade.toString() + " ";
        }
        for (Integer grade : getExamList()) 
        {
            result = result + grade.toString() + " ";
        }
        result = result.substring(0, result.length() - 1);

        return result;
    }
}
