//********************************************************************************************************
// CLASS: OnCampusStudent(OnCampusStudent.java)
//
// DESCRIPTION
// The OnCampusStudent class of Project 2
//
// COURSE AND PROJECT INFO
// CSE205 Object Oriented Programming and Data Structures, Spring A 2017
// Project Number: 2
//
// AUTHOR
// Torian Crane (tcrane2@asu.edu)
//********************************************************************************************************

package tuition;

public class OnCampusStudent extends Student
{   
   private boolean mResident;
   private double mProgramFee;
   
   public OnCampusStudent(String pId, String pFname, String pLname)
   {
      super(pId, pFname, pLname);
   }
   @Override
   public void calcTuition()
   {
      double t;
      if(getResidency())
      {
         t = TuitionConstants.ONCAMP_RES_BASE;
      }
      else
      {
         t = TuitionConstants.ONCAMP_NONRES_BASE;
      }
      
      t = t + getProgramFee();
      
      if(getCredits() > TuitionConstants.MAX_CREDITS)
      {
         t = t + (getCredits() - TuitionConstants.MAX_CREDITS) * TuitionConstants.ONCAMP_ADD_CREDITS;
      }
      setTuition(t);
   }
   
   public double getProgramFee()
   {
      return mProgramFee;
   }
   
   public boolean getResidency()
   {
      return mResident;
   }
   
   public void setProgramFee(double pProgramFee)
   {
      mProgramFee = pProgramFee;
   }
   
   public void setResidency(boolean pResident)
   {
      mResident = pResident;
   }
}