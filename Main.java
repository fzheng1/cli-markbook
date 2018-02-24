import java.util.Scanner;
import jave.util.List;
import.java.util.*;
public class Main {

    private static String getFirstName(){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter first name: ");
        String firstName = input.nextLine);

        return firstName;
    }

    private static String getLastName(){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter last name: ");
        String lastName = input.nextLine();

        return lastName;
    }
    private static int getStudentNumber(){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter student ID: ");
        int studentNumber = Integer.parseInt(input.next());

        return studentNumber;
    }

    private static int getGraduatingYear(){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter graduating year: ");
        int  graduatingYear = Integer.parseInt(input.next());

        return graduatingYear;
    }

     public static void main(String[] args){
        List firstNames = new ArrayList();
        List lastNames = new ArrayList();
        List studentNumbers = new ArrayList();
        List graduatingYears = new ArrayList();

        Scanner input = new Scanner(System.in);
        System.out.print("Manage Class List, input marks: ");
        String manage = input.nextLine();

        if (manage.equals("manage class list") || manage.equals("Manage Class List")){
            System.out.print("Add, remove, edit: ");
            String edit = input.nextLine();
            if (edit.equals("add") || edit.equals("Add"))  {
                firstNames.add(getFirstName());

                lastNames.add(getLastName());

                studentNumbers.add(getStudentNumber());

                graduatingYears.add(getGraduatingYear());
                }
            }



    }
}
