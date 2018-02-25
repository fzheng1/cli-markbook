import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class main {

    //user inputs first name of student
    private static String getFirstName() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter first name: ");
        String firstName = input.nextLine();

        return firstName;
    }
    
    //user inputs last name of student
    private static String getLastName() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter last name: ");
        String lastName = input.next();

        return lastName;
    }

    //user inputs student number
    private static String getStudentNumber() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter student ID: ");
        int studentNumber = input.nextInt();

        return Integer.toString(studentNumber);
    }
    
    //user inputs graduating year
    private static String getGraduatingYear() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter graduating year: ");
        int graduatingYear = input.nextInt();

        return Integer.toString(graduatingYear);
    }


    // gets all info for a certain student from the user and returns a list of the student's info
    private static List addStudentInfo() {
        System.out.println("\nAdd student information");

        List info = new ArrayList();

        String nameF = getFirstName();
        String nameL = getLastName();
        String studentNo = getStudentNumber();
        String gradYear = getGraduatingYear();

        info.add(0, nameF);
        info.add(1, nameL);
        info.add(2, studentNo);
        info.add(3, gradYear);

        /*
        firstNames.add(nameF);
        lastNames.add(nameL);
        studentNumbers.add(studentNo);
        graduatingYears.add(gradYear);
        */

        System.out.println("You have added: " + nameF + " " + nameL + " " + studentNo + " " + gradYear);
        return info;
    }

    //user inputs a student's grades
    private static List getMarks() {

        //ask user how many marks are being entered
        List empty = new ArrayList();
        Scanner input = new Scanner(System.in);
        System.out.print("How many assignemt marks are being entered?: ");
        int numMarks = input.nextInt();

        List studentMarks = new ArrayList();

        //allows user to continue entering marks for number specified above
        for (int i = 0; i < numMarks; i++) {

            System.out.print("What is the mark for assignment " + (i + 1) + "?: ");
            int grade = input.nextInt();
            studentMarks.add(grade);

            System.out.println(studentMarks);



        }
        return studentMarks;
    }


        // returns index number of student given his full name from the class list, if name is not found, returns -1
        // call command is int x = indexOfStudent(classList);
    private static int indexOfStudent (List classList){
        Scanner input = new Scanner(System.in);

        // get name of student to be found
        System.out.println("Enter Full Name of Student");
        String student = input.nextLine();

        // loop within the 2d list to first make the full name then check if it matches up with input
        for (int i = 0; i < classList.size(); i++) {

            // string to collect full name
            String name = "";

            // first and last names are stored within the first 2 indexes of inner list
            for (int j = 0; j < 2; j++) {

                // check each inner list within classList
                List first = (List) classList.get(i);

                // retrieves the first name first then last name from inner list and adds them together
                String full = " " + first.get(j).toString();
                name += full;
            }

            System.out.println("you entered: " + name.trim());

            // check if entered name is the same as retrieved name, then return the index of that name if found
            if (name.trim().equals(student)) {
                return i;
            }

        }
        // if name not found in class list return -1
        return -1;
    }

    private static List addMarklist(List classList) {
        
        List markList = new ArrayList();
        System.out.println(classList);

        int index = indexOfStudent(classList);

        for (int i = 0; i < 10; i++) {
            markList.add("");
        }
        System.out.println(markList);

        markList.add(index, getMarks());

        System.out.println(markList);



        return markList;
    }

    //calculates a student's average
    private static double studentAverage(List studentMarks) {

        int addedEntries = 0;

        for (int i = 0; i < studentMarks.size(); i ++){

            int grade = (Integer) studentMarks.get(i);
            addedEntries += grade;
        }

        double studentAverage = (addedEntries/studentMarks.size());
        System.out.print(studentAverage);
        return studentAverage;
    }
    
    private static List correspondingMark(List classList, List markList) {
        List studentmarks = new ArrayList();

        int index = indexOfStudent(classList);

        studentmarks = (List) markList.get(index);

        return studentmarks;

    }

    private static String lessThan65(List classList, List markList) {
        String dangerzone = "";

        for (int i=0; i<classList.size(); i++) {
            List studentMarks = (List) markList.get(i);

            if (studentAverage(studentMarks) <= 65) {

                // loop within the 2d list to first make the full name then check if it matches up with input
                for (int j = 0; j < classList.size(); j++) {

                }
                    // first and last names are stored within the first 2 indexes of inner list
                    for (int k = 0; k < 2; k++) {

                        // check each inner list within classList
                        List first = (List) classList.get(i);

                        // retrieves the first name first then last name from inner list and adds them together
                        String full = " " + first.get(k).toString();
                        dangerzone += full;
                    }
            }

        }
        System.out.println(dangerzone.trim());
        return dangerzone.trim();
    }
    
    private static String username(){
        String firstname = getFirstName();
        String lastname = getLastName();
        String year = getGraduatingYear();
        return ("Login email: " + firstname + "." + lastname + year.substring(year.length()-2) + "@ycdsbk12.ca");
    }
    
    private static String passwordInformation(){

        String firstname = getFirstName();
        String lastname = getLastName();
        String studentNumber = getStudentNumber();
        
        String upperfirstinitial = String.valueOf(Character.toUpperCase(firstname.charAt(0)));
        String lowerlastinitial = String.valueOf(Character.toLowerCase(lastname.charAt(0)));
        return (upperfirstinitial + lowerlastinitial + studentNumber);
    }
    
    public static void main (String[]args){
        List firstNames = new ArrayList();
        List lastNames = new ArrayList();
        List studentNumbers = new ArrayList();
        List graduatingYears = new ArrayList();

        // 2d list in which each indexed list has the student's name, number and grad date
        List classList = new ArrayList();
        List markList = new ArrayList();

        Scanner input = new Scanner(System.in);

        // User chooses what they want to do
        System.out.println("1) Manage Class List \n2) Input marks");
        System.out.print("Enter 1 or 2: ");
        String manage = input.nextLine();


        if (manage.equals("1")) {

            // user chooses how they want to manipulate the class list
            System.out.println("1) Add Student Info \n2) Remove Student \n3) Edit ");
            System.out.print("Enter 1, 2 or 3: ");
            String options = input.nextLine();

            if (options.equals("1")) {
                // this stores the list returned by entering all the data into the full class list
                classList.add(addStudentInfo());


            }

        }
        System.out.println(classList.toString());

        markList = addMarklist(classList);
        System.out.println(markList);


    }
    
}


}
