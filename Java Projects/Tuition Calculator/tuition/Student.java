//********************************************************************************************************
// CLASS: Student (Student.java)
//
// DESCRIPTION
// The Student class of Project 2
//
// COURSE AND PROJECT INFO
// CSE205 Object Oriented Programming and Data Structures, Spring A 2017
// Project Number: 2
//
// AUTHOR
// Torian Crane (tcrane2@asu.edu)
//********************************************************************************************************
package tuition;

public abstract class Student implements Comparable<Student>
{   
   private int mCredits;
   private String mFname;
   private String mId;
   private String mLname;
   private double mTuition;
   
   public Student(String pId, String pFname, String pLname)
   {
      mId = pId;
      mFname = pFname;
      mLname = pLname;
   }
   
   abstract void calcTuition();
   
   @Override
   public int compareTo(Student pStudent)
   {
      int var = this.mId.compareTo(pStudent.mId);
      return var;
   }
   
   public int getCredits()
   {
      return mCredits;
   }
   
   public String getFirstName()
   {
      return mFname;
   }
   
   public String getId()
   {
      return mId;
   }
   
   public String getLastName()
   {
      return mLname;
   }
   
   public double getTuition()
   {
      return mTuition;
   }
   
   public void setCredits(int pCredits)
   {
      mCredits = pCredits;
   }
   
   public void setFname(String pFname)
   {
      mFname = pFname;
   }
   
   public void setId(String pId)
   {
      mId = pId;
   }
   
   public void setLname(String pLname)
   {
      mLname = pLname;
   }
   
   protected void setTuition(double pTuition)
   {
      mTuition = pTuition;
   }
}