//********************************************************************************************************
// CLASS: View (View.java)
//
// DESCRIPTION
// The View class of Project 3
//
// COURSE AND PROJECT INFO
// CSE205 Object Oriented Programming and Data Structures, Spring A 2017
// Project Number: 3
//
// AUTHOR
// Torian Crane (tcrane2@asu.edu)
//********************************************************************************************************

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * The View class implements the GUI.
 */
public class View extends JFrame implements ActionListener {

    public static final int FRAME_WIDTH = 500;
    public static final int FRAME_HEIGHT = 250;

    // Declare instance variables
    private JButton mClearButton;
    private JTextField[] mExamText = new JTextField[CourseConstants.NUM_EXAMS];
    private JButton mExitButton;
    private JTextField[] mHomeworkText = new JTextField[CourseConstants.NUM_HOMEWORKS];
    private Main mMain;
    private JButton mSaveButton;
    private JButton mSearchButton;
    private JTextField mSearchText;
    private Student mStudent;

    /**
     * View()
     *
     * The View constructor creates the GUI interface and makes the frame
     * visible at the end.
     */
    public View(Main pMain) 
    {

        // Save a reference to the Main object pMain in mMain.
        mMain = pMain;

        // PSEUDOCODE:
        // Create a JPanel named panelSearch which uses the FlowLayout.
        // Add a JLabel "Student Name: " to panelSearch
        // Create mSearchText and make the field 25 cols wide
        // Add mSearchText to the panel
        // Create mSearchButton
        // Make this View the action listener for the button
        // Add the button to the panel
        JPanel panelSearch = new JPanel();
        mSearchText = new JTextField(25);
        panelSearch.add(mSearchText);
        mSearchButton = new JButton("Search");
        mSearchButton.addActionListener(this);
        panelSearch.add(mSearchButton);

        // PSEUDOCODE:
        // Create a JPanel named panelHomework which uses the FlowLayout.
        // Add a JLabel "Homework: " to the panel
        // Create mHomeworkText which is an array of CourseConstants.NUM_HOMEWORKS JTextFields
        // For i = 0 to CourseConstants.NUM_HOMEWORKS - 1 Do
        //     Create textfield mHomeworkText[i] displaying 5 cols
        //     Add mHomeworkText[i] to the panel
        // End For
        JPanel panelHomework = new JPanel();
        panelHomework.add(new JLabel("Homework:"));
        for (int x = 0; x < CourseConstants.NUM_HOMEWORKS; ++x) 
        {
            mHomeworkText[x] = new JTextField(5);
            panelHomework.add(mHomeworkText[x]);
        }

        // Create the exam panel which contains the "Exam: " label and the two exam text fields. The pseudocode is omitted
        // because this code is very similar to the code that creates the panelHomework panel.
        JPanel panelExam = new JPanel();
        panelExam.add(new JLabel("Exam:"));
        for (int x = 0; x < CourseConstants.NUM_EXAMS; ++x) 
        {
            mExamText[x] = new JTextField(5);
            panelExam.add(mExamText[x]);
        }

        // PSEUDOCODE:
        // Create a JPanel named panelButtons using FlowLayout.
        // Create the Clear button mClearButton.
        // Make this View the action listener for mClearButton.
        // Add the  Clear button to the panel.
        // Repeat the three above statements for the Save button.
        // Repeat the three above statements for the Exit button.
        JPanel panelButtons = new JPanel();
        mClearButton = new JButton("Clear");
        mClearButton.addActionListener(this);
        panelButtons.add(mClearButton);
        mSaveButton = new JButton("Save");
        mSaveButton.addActionListener(this);
        panelButtons.add(mSaveButton);
        mExitButton = new JButton("Exit");
        mExitButton.addActionListener(this);
        panelButtons.add(mExitButton);

        // PSEUDOCODE:
        // Create a JPanel named panelMain using a vertical BoxLayout.
        // Add panelSearch to panelMain.
        // Add panelHomework to panelMain.
        // Add panelExam to panelMain.
        // Add panelButtons to panelMain.
        JPanel panelMain = new JPanel();
        panelMain.setLayout(new BoxLayout(panelMain, BoxLayout.Y_AXIS));
        panelMain.add(panelSearch);
        panelMain.add(panelHomework);
        panelMain.add(panelExam);
        panelMain.add(panelButtons);

        // Initialize the remainder of the frame, add the main panel to the frame, and make the frame visible.
        setTitle("Gradebook Viewer");
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(panelMain);
        setVisible(true);
    }

    /**
     * actionPerformed()
     *
     * Called when one of the JButtons is clicked. Detects which button was clicked and handles it.
     *
     * PSEUDOCOODE:
     * If the source of the event was the Search button Then
     *     lastName = retrieve the text from the mSearchText text field.
     *     If lastName is the empty string Then
     *         Call messageBox() to display "Please enter the student's last name."
     *     Else
     *         student = Call mMain.search(lastName)
     *         If student is null Then
     *             Call messageBox() to display "Student not found. Try again."
     *         Else
     *             Call displayStudent(student)
     *         End if
     *     End If
     * Else if the source of the event was the Save button Then
     *     If mStudent is not null Then Call saveStudent(mStudent)
     * Else if the source of the event was the Clear button Then
     *     Call clear()
     * Else if the source of the event was the Exit button Then
     *     If mStudent is not null Then Call saveStudent(mStudent)
     *     Call mMain.exit() to terminate the application
     * End If
     */
    @Override
    public void actionPerformed(ActionEvent pEvent) 
    {

        switch (pEvent.getActionCommand()) 
        {
            case "Search":
                String lastName = mSearchText.getText();
                if (lastName.isEmpty()) 
                {
                    this.messageBox("Please enter the student's last name.");
                } 
                else 
                {
                    Student student = mMain.search(lastName);
                    if (student == null) 
                    {
                        this.messageBox("Student not found. Try again.");
                    } 
                    else 
                    {
                        mStudent = student;
                        displayStudent(student);
                    }
                }
                break;
            case "Save":
                if (mStudent != null) 
                {
                    saveStudent(mStudent);
                }
                break;
            case "Clear":
                clear();
                break;
            case "Exit":
                if (mStudent != null) 
                {
                    saveStudent(mStudent);
                }
                mMain.exit();
                break;
        }
    }

    /**
     * clear()
     *
     * Called when the Clear button is clicked. Clears all of the text fields by setting the contents to the empty string.
     * After clear() returns, no student information is being edited or displayed.
     *
     * PSEUDOCODE:
     * Set the mSearchText text field to ""
     * Set each of the homework text fields to ""
     * Set each of the exam text fields to ""
     * Set the mStudent reference to null
     */
    private void clear() 
    {
        mSearchText.setText("");
        for (int x = 0; x < CourseConstants.NUM_HOMEWORKS; ++x) 
        {
            mHomeworkText[x].setText("");
        }
        for (int x = 0; x < CourseConstants.NUM_EXAMS; ++x) 
        {
            mExamText[x].setText("");
        }
        mStudent = null;
    }

    /**
     * displayStudent()
     *
     * Displays the homework and exam scores for a student in the mHomeworkText and mExamText text fields.
     *
     * PSEUDOCODE:
     * For i = 0 to CourseConstants.NUM_HOMEWORKS - 1 Do
     *     int hw = pStudent.getHomework(i)
     *     String hwstr = convert hw to a String (Hint: Integer.toString())
     *     mHomeworkText[i].setText(hwstr)
     * End For
     * Write another for loop similar to the one above to place the exams scores into the text fields
     */
    private void displayStudent(Student pStudent) 
    {
        for (int x = 0; x < CourseConstants.NUM_HOMEWORKS; ++x) 
        {
            Integer hw = pStudent.getHomework(x);
            String hwStr = hw.toString();
            mHomeworkText[x].setText(hwStr);
        }
        for (int x = 0; x < CourseConstants.NUM_EXAMS; ++x) 
        {
            Integer exam = pStudent.getExam(x);
            String examStr = exam.toString();
            mExamText[x].setText(examStr);
        }
    }

    /**
     * messageBox()
     *
     * Displays a message box containing some text.
     */
    public void messageBox(String pMessage) 
    {
        JOptionPane.showMessageDialog(this, pMessage, "Message", JOptionPane.PLAIN_MESSAGE);
    }

    /**
     * saveStudent()
     *
     * Retrieves the homework and exam scores for pStudent from the text fields and writes the results to the Student record
     * in the Roster.
     *
     * PSEUDOCODE:
     * For i = 0 to CourseConstants.NUM_HOMEWORKS - 1 Do
     *     String hwstr = mHomeworkText[i].getText()
     *     int hw = convert hwstr to an int (Hint: Integer.parseInt())
     *     Call pStudent.setHomework(i, hw)
     * End For
     * Write another for loop similar to the one above to save the exam scores
     */
    private void saveStudent(Student pStudent) 
    {

        for (int x = 0; x < CourseConstants.NUM_HOMEWORKS; ++x) 
        {
            String hwStr = mHomeworkText[x].getText();
            Integer hw = Integer.parseInt(hwStr);
            pStudent.setHomework(x, hw);
        }
        for (int x = 0; x < CourseConstants.NUM_EXAMS; ++x) 
        {
            String examStr = mExamText[x].getText();
            Integer exam = Integer.parseInt(examStr);
            pStudent.setExam(x, exam);
        }

        int studentIdx = Searcher.search(mMain.getRoster().getStudentList(),
                pStudent.getLastName());

        mMain.getRoster().getStudentList().set(studentIdx, pStudent);

    }

}
