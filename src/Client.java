import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import javax.lang.model.util.ElementScanner6;

import Student.*;
import Unit.*;
import Helper.CheckType;
import Helper.Date;
import Exceptions.*;

public class Client {
    public static void main(String[] args) throws Exception {
        //Declare  variables
        ArrayList <Student> studentList = new ArrayList<Student>();
        String studentFileName = "student.csv";
        Boolean isSorted = false, flag = true;
        
        //Load Student info
        studentList = LoadStudentInfo(studentFileName);
        //Checks if array are filled with any data
        if(studentList != null)
        {
            System.out.println("Successfully loaded student data.");
        }
        else
        {
            System.out.println("No student data found");
        }

        // Initialize scanner
        Scanner input = new Scanner(System.in);

        //Display menu
        try
        {
            while(flag)
            {
                
                DisplayMenu();
                String tempInput = input.nextLine();

                // Run different function based on user input
                switch(tempInput)
                {
                    case "1":
                        flag = false;
                        input.close();
                        break;
                    case "2":
                        //Ask user for file name for marks information
                        System.out.println("Enter filepath of file for marks information.");
                        tempInput = input.nextLine();
                        // Check & load marks information to student
                        LoadStudentMarks(tempInput, studentList);

                        break;
                    case "3":
                        //Ask user for student ID
                        System.out.println("Enter a studentID");
                        tempInput = input.nextLine();

                        //Search for student
                        int index = SearchStudentById(studentList, Long.parseLong(tempInput));

                        // Display/print student Id and name
                        System.out.println("Student Id: " + studentList.get(index).GetStudentID());
                        System.out.println("Student Name: " + studentList.get(index).GetFirstName() + " " + studentList.get(index).GetLastName());

                        System.out.println("Confirm removal of student displayed above by replying 'Y'");
                        tempInput = input.nextLine();

                        // Remove student
                        if(tempInput == "Y")
                        {
                            studentList.remove(index);
                        }

                        break;
                    case "4":
                        // Display/print student details available
                        System.out.println(DisplayStudentDetails(studentList));

                        break;
                    case "5": 
                        // Display number of student with above/below average overall marks
                        double average = CalAverageScore(studentList);
                        int numAboveAverage = CalNumAboveAverage(studentList, average);
                        int numBelowAverage = CalNumBelowAverage(studentList, average);
                        System.out.println(DisplayNumAverage(numAboveAverage,numBelowAverage));

                        break;
                    case "6":
                        //Ask user for student ID
                        System.out.println("Enter a studentID");
                        tempInput = input.nextLine();

                        //Display/print student details available
                        System.out.println(DisplayStudentDetails(studentList, tempInput));
                            
                        break;
                    case "7":
                        //Sort Student by student ID
                        isSorted = SortStudentList(studentList);

                        if(isSorted == true)
                        {
                            System.out.print("Student list had been successfully sorted");
                        }
                        else 
                        {
                            System.out.println("Sorting failed");
                        }

                        break;
                    case "8":
                        //Check if function 7 has ran
                        // If function 7 ran then write student info to CSV file

                        if (isSorted = true)
                        {
                            WriteSortedStudentInfoToCSV(studentList);
                        }
                        else if (isSorted = false)
                        {
                            throw new ListNotSortedException("Please sort the student list using function 7 before using function 8.");
                        }

                        break;
                }
            }
        }
        catch(ListNotSortedException e)
        {
            System.out.println(e);
        }
        finally
        {
            if(input != null)
            {
                input.close();
            }
        }

    }

    static ArrayList<Student> LoadStudentInfo(String fileName)
    {
        //Declare variables
        ArrayList<Student> studentList = new ArrayList<>();
        String line = null;

        try {
            //Read file
            BufferedReader studentInfo = new BufferedReader(new FileReader(fileName));
            //Read and ignore header
            line = studentInfo.readLine();
            line = null;
            
            //Loops every line in file
            while((line = studentInfo.readLine()) != null)
            {
                //Get individual field's value
                String[] split = line.split(",");

                //Check if dates are int and StudentId is long
                if(CheckType.IsInt(split[4]) == true && CheckType.IsInt(split[5]) == true && CheckType.IsInt(split[6]) == true && CheckType.IsLong(split[1]))
                {
                     //Create Date object from birth date
                     Date tempDate = new Date(Integer.parseInt(split[4]), Integer.parseInt(split[5]), Integer.parseInt(split[6]));

                    //check if student already exist
                    if(SearchStudentById(studentList, Long.parseLong(split[1])) >= 0)
                    {
                        throw new DuplicateStudentException("Duplicate student found. Only student with unique student ID are allowed.");
                    }
                    else
                    {
                        // Load into Student class as undergraduate or graduate and store in studentList depending on student's enrolment type
                        if (split[0].toUpperCase().equals("U"))
                        {
                            studentList.add(new UndergraduateStudent(Long.parseLong(split[1]), split[2], split[3], tempDate));
                        }
                        else if (split[0].toUpperCase().equals("G"))
                        {
                            studentList.add(new GraduateStudent(Long.parseLong(split[1]), split[2], split[3], tempDate));
                        }
                        else 
                        {
                            throw new WrongDataTypeException("Invalid Enrolment Type. Only single character 'U' and 'G' allowed.");
                        }
                    }
                }
                else
                {
                    throw new WrongDataTypeException("StudentId/Date data type incorrect. Kindly check data dictionary provided.");
                }
            }
            studentInfo.close();
            return studentList;
        } catch (IOException | WrongDataTypeException | DuplicateStudentException e) {
            System.out.println(e);
        }


        return null;
    }

    static void DisplayMenu()
    {
        // Display menu
        System.out.println("1) Quit system.");
        System.out.println("2) Load student marks information (Require CSV file).");
        System.out.println("3) Remove student by student ID.");
        System.out.println("4) Display all students' information");
        System.out.println("5) Display number of student that obtained above or below average overall marks (Only for undergrad students).");
        System.out.println("6) Report grade of student by student ID.");
        System.out.println("7) Sort list of student by studentID.");
        System.out.println("8) Write sorted student information to CSV (Requires (7))");
        System.out.println();
        System.out.println("Enter number 1-8 to select a function.");
    }

    static void LoadStudentMarks(String tempInput, ArrayList<Student> studentList)
    {
        int studentIndex = -1;

        //Split CSV and load data into student as Unit objects
        BufferedReader marksInfo = null;
        try 
        {
            marksInfo = new BufferedReader(new FileReader(tempInput));
            String line = marksInfo.readLine();
            line = null;
            ArrayList<String> marksStudentId = new ArrayList<>();

            while(line != null)
            {
                String[] split = line.split(",");
                
                //Check EnrolmentType and studentId is correct type
                if (CheckType.IsLong(split[1]) == false || CheckType.IsChar(split[0]) == false)
                {
                    throw new WrongDataTypeException("Data type does not match accepted type.");
                }
                //Search for same studentId in existing array
                //If exist then continue
                //if not exist then throw exception
                studentIndex = SearchStudentById(studentList, Long.parseLong(split[1]));

                if(studentIndex < 0)
                {
                    throw new StudentNotFoundException("Student does not already exist.");
                }

                //Check if student Id already found in csv
                if(marksStudentId.contains(split[1]) == false)
                {
                    throw new DuplicateStudentException("Student Id already found in CSV");
                }
                //Stores processed marks record's studentId for later loops' check
                marksStudentId.add(split[1]);

                //Check if student's enrolment type is same as mark's enrolment type
                if(String.valueOf(studentList.get(studentIndex).GetEnrolmentType()) != split[0])
                {
                    throw new EnrolmentTypeMismatchException("Enrolment type of student and unit do not match.");
                }

                //Check where marks is for Undergraduate/Graduate
                if(split[0] == "U")
                {
                    //Create Unit
                    Unit tempUnit = new UndergraduateUnit(split[2], split[3] , split[4], split[5], split[6], split[7]);

                    //Load unit into student
                    studentList.get(studentIndex).SetUnit(tempUnit);
                }
                else if(split[0] == "G")
                {
                    //Create Unit
                    Unit tempUnit = new GraduateUnit(split[8], split[9], split[10]);

                    //Load unit into student
                    studentList.get(studentIndex).SetUnit(tempUnit);
                }

            }

        } 
        catch (IOException|StudentNotFoundException|EnrolmentTypeMismatchException|DuplicateStudentException|WrongDataTypeException e) 
        {
            System.out.println(e);
        }
        finally
        {
            try
            {
                if(marksInfo != null)
                {
                    marksInfo.close();
                }
            }
            catch(IOException e)
            {
                System.out.println(e);
            }
        }
    }

    static int SearchStudentById(ArrayList<Student> studentList, Long id)
    {
        for(int i = 0; i < studentList.size(); i++)
        {
            if(studentList.get(i).Equals(id))
            {
                return i;
            }
        }

        return -1;
    }

    static String DisplayStudentDetails(ArrayList<Student> studentList, String id)
    {
        if(CheckType.IsLong(id) == true)
        {
            int index = SearchStudentById(studentList, Long.parseLong(id));

            //Get student Info
            return studentList.get(index).ReportGrade();
        }
        return "";
    }

    static String DisplayStudentDetails(ArrayList<Student> studentList)
    {
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < studentList.size(); i++)
        {
            //Get student Info
            builder.append(studentList.get(i).ReportGrade());
            builder.append("\n");
        }
        return builder.toString();
    }

    static double CalAverageScore(ArrayList<Student> studentList)
    {
        double totalScore = 0;
        for (int i = 0; i < studentList.size(); i++)
        {
            if(studentList.get(i).GetEnrolmentType() == 'U')
            {
                UndergraduateUnit tempU = (UndergraduateUnit) studentList.get(i).GetUnit();
                totalScore += tempU.CalOverallMark();
            }
        }
        return totalScore/studentList.size();
    }

    static int CalNumAboveAverage(ArrayList<Student> studentList, double average)
    {
        int count = 0;

        for (int i = 0; i < studentList.size(); i++)
        {
            if(studentList.get(i).GetEnrolmentType() == 'U')
            {
                UndergraduateUnit tempU = (UndergraduateUnit) studentList.get(i).GetUnit();
                if(tempU.CalOverallMark() >= average)
                {
                    count++;
                }
            }
        }

        return count;
    }

    static int CalNumBelowAverage(ArrayList<Student> studentList, double average)
    {
        int count = 0;

        for (int i = 0; i < studentList.size(); i++)
        {
            if(studentList.get(i).GetEnrolmentType() == 'U')
            {
                UndergraduateUnit tempU = (UndergraduateUnit) studentList.get(i).GetUnit();
                if(tempU.CalOverallMark() < average)
                {
                    count++;
                }
            }
        }

        return count;
    }

    static String DisplayNumAverage(int aboveA,int belowA)
    {
        StringBuilder builder = new StringBuilder();

        builder.append("Number of undergraduate student with equal or above average score: ");
        builder.append(String.valueOf(aboveA));
        builder.append("\n");
        builder.append("Number of graduate student with below average score: ");
        builder.append(String.valueOf(belowA));
        builder.append("\n");

        return builder.toString();
    }

    static boolean SortStudentList(ArrayList<Student> studentList)
    {
        //SelectionSort
        // will iterate throughout the entire list to sort
        try
        {
            for (int i = 0; i < studentList.size() - 1; i++)
            {
                int lowestValue = i;
                // will iterate through list to find next smallest value
                for (int j = i + 1; j < studentList.size(); j++)
                {
                    if(studentList.get(j).GetStudentID().compareTo(studentList.get(lowestValue).GetStudentID()) < 0)
                    {
                        lowestValue = j;
                    }
                }

                // swap out the next lowest value with the next value in the list
                Student tempStudent = studentList.get(i);
                studentList.set(i, studentList.get(lowestValue));
                studentList.set(lowestValue, tempStudent);
            }
            //return true to indicate array had been sorted
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
        

    }

    static void WriteSortedStudentInfoToCSV(ArrayList<Student> studentList)
    {
        String outFileName = "SortedStudentList.csv";
        PrintWriter writer = null;
        StringBuilder builder = new StringBuilder();

        try
        {
            writer = new PrintWriter(outFileName);
            //Append header
            builder.append("StudentID,EnrolmentType,Name,BirthDate,UnitID,OverallMark,GraduateType,FinalGrade");
            builder.append("\n");

            //Append student info
            for (int i = 0; i < studentList.size(); i++)
            {
                if(studentList.get(i).GetEnrolmentType() == 'U')
                {
                    UndergraduateUnit tempU = (UndergraduateUnit) studentList.get(i).GetUnit();

                    builder.append(Long.toString(studentList.get(i).GetStudentID()));//StudentID
                    builder.append(",");
                    builder.append("U");//EnrolmentType
                    builder.append(",");
                    builder.append(studentList.get(i).GetFirstName() + " " + studentList.get(i).GetLastName());//FullName
                    builder.append(",");
                    builder.append(studentList.get(i).GetBirthDate().getFullDate());//BirthDate
                    builder.append(",");
                    builder.append(tempU.GetUnitId());//UnitID
                    builder.append(",");
                    builder.append(tempU.CalOverallMark());//OverallMarks
                    builder.append(",");
                    //No Graduate type for undergraduate
                    builder.append(",");
                    builder.append(tempU.CalFinalGrade());//FinalGrade

                    builder.append("\n");
                }
                else if(studentList.get(i).GetEnrolmentType() == 'G')
                {
                    GraduateUnit tempU = (GraduateUnit) studentList.get(i).GetUnit();

                    builder.append(Long.toString(studentList.get(i).GetStudentID()));//StudentID
                    builder.append(",");
                    builder.append("U");//EnrolmentType
                    builder.append(",");
                    builder.append(studentList.get(i).GetFirstName() + " " + studentList.get(i).GetLastName());//FullName
                    builder.append(",");
                    builder.append(studentList.get(i).GetBirthDate().getFullDate());//BirthDate
                    builder.append(",");
                    //No UnitID for Graduate
                    builder.append(",");
                    //No OverallMarks for graduate
                    builder.append(",");
                    builder.append(tempU.GetGradEnrolmentType());//Graduate type
                    builder.append(",");
                    builder.append(tempU.GetFinalGrade());//FinalGrade

                    builder.append("\n");
                }

            }
            //Remove excess nextline
            builder.setLength(builder.length() - 1);
            writer.println(builder.toString());
        }
        catch(FileNotFoundException e)
        {
            System.out.println(e);
        }
        finally
        {
            if(writer != null)
            {
                writer.close();
            }
        }
    }

}
