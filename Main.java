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
        Scanner input = new Scanner(System.in);
        System.out.print("Manage Class List, input marks: ");
        String manage = input.next();
        if (manage.equals("manage class list") || manage.equals("Manage Class List")){
            System.out.print("Add, remove, edit: ");
            String edit = input.next();
            if (edit.equals("add") || edit.equals("Add"))  {
                List firstNames = new ArrayList();
                firstNames.add(getFirstName());

                List lastNames = new ArrayList();
                lastNames.add(getLastName());

                List studentNumbers = new ArrayList();
                studentNumbers.add(getStudentNumber());

                List graduatingYears = new ArrayList();
                graduatingYears.add(getGraduatingYear());
                }
            }



    }
}
