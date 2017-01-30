//********************************************************************************************************
// CLASS: OnlineStudent(OnlineStudent.java)
//
// DESCRIPTION
// The OnlineStudent class of Project 2
//
// COURSE AND PROJECT INFO
// CSE205 Object Oriented Programming and Data Structures, Spring A 2017
// Project Number: 2
//
// AUTHOR
// Torian Crane (tcrane2@asu.edu)
//********************************************************************************************************

package tuition;

public class OnlineStudent extends Student
{   
   private boolean mTechFee;
   
   public OnlineStudent(String pId, String pFname, String pLname)
   {
      super(pId, pFname, pLname);
   }
   
   @Override
   public void calcTuition()
   {
      double t = getCredits() * TuitionConstants.ONLINE_CREDIT_RATE;
      if(getTechFee())
      {
         t = t + TuitionConstants.ONLINE_TECH_FEE;
      }
      setTuition(t);
   }
   
   public boolean getTechFee()
   {
      return mTechFee;
   }
   
   public void setTechFee(boolean pTechFee)
   {
      mTechFee = pTechFee;
   }
}