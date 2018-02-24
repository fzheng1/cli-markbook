import java.util.Scanner;

public class Main {

    private static String getFirstName(){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter first name: ");
        String firstName = input.next();

        return firstName;
    }

    private static String getLastName(){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter last name: ");
        String lastName = input.next();

        return lastName;
    }
    private static int getStudentNumber(){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter student ID: ");
        int studentNumber = input.nextInt();

        return studentNumber;
    }

    private static int getGraduatingYear(){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter graduating year: ");
        int  graduatingYear = input.nextInt();

        return graduatingYear;
    }

     public static void main(String[] args){
        List firstNames = new ArrayList();
        List lastNames = new ArrayList();
        List studentNumbers = new ArrayList();
        List graduatingYears = new ArrayList();

        Scanner input = new Scanner(System.in);
        System.out.print("Manage Class List, input marks: ");
        String manage = input.next();

        if (manage.equals("manage class list") || manage.equals("Manage Class List")){
            System.out.print("Add, remove, edit: ");
            String edit = input.next();
            if (edit.equals("add") || edit.equals("Add"))  {
                firstNames.add(getFirstName());

                lastNames.add(getLastName());

                studentNumbers.add(getStudentNumber());

                graduatingYears.add(getGraduatingYear());
                }
            }



    }
}
