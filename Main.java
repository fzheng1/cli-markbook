//import required libraries
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

    // user inputs student number
    private static String getStudentNumber() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter student ID: ");
        int studentNumber = input.nextInt();

        return Integer.toString(studentNumber);
    }

    // user inputs graduating year
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
        //String gradYear = getGraduatingYear();

        info.add(0, nameF);
        info.add(1, nameL);
        info.add(2, studentNo);
        //info.add(3, gradYear);


        System.out.println("You have added: " + nameF + " " + nameL + " " + studentNo);
        return info;
    }

    // user inputs a student's grades
    private static List getMarks() {

        //asks user how many marks are being entered
        List empty = new ArrayList();
        Scanner input = new Scanner(System.in);
        System.out.print("How many assignemt marks are being entered?: ");
        int numMarks = input.nextInt();

        List studentMarks = new ArrayList();

        //allows the user to continue entering marks for the number specified above
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

        boolean done = false;

        while (!done) {

            System.out.println(classList);

            // get name of student to be found
            System.out.println("Enter Student ID");
            String student = input.nextLine();

            // loop within the 2d list to first make the full name then check if it matches up with input
            for (int i = 0; i < classList.size(); i++) {

                List studentinfo = (List) classList.get(i);
                String studentNumber = (String) studentinfo.get(2);

                // check if entered name is the same as retrieved name, then return the index of that name if found
                if (studentNumber.equals(student)) {
                    return i;
                }
            }
        }
        // if name not found in class list return -1
        return -1;
    }

    // this function is useless plz ignore
    private static List addMarklist(List classList) {

        List markList = new ArrayList();
        System.out.println(classList);

        int index = indexOfStudent(classList);

        for (int i = 0; i < classList.size(); i++) {
            markList.add("");
        }
        System.out.println(markList);


        markList.add(index, getMarks());

        System.out.println(markList);

        return markList;
    }

    // calculates a student's average
    private static double studentAverage(List studentMarks) {

        double addedEntries = 0;

        for (int i = 0; i < studentMarks.size(); i ++){

            int grade = (Integer) studentMarks.get(i);
            addedEntries += grade;
        }

        return (double) (addedEntries/studentMarks.size());
    }

    // finds the list of the student's grades
    private static List correspondingMark(List classList, List markList) {


        int index = indexOfStudent(classList);

        List studentmarks = (List) markList.get(index);

        return studentmarks;

    }

    // prints a list of students with avg less than 65
    private static String LessThan65(List classList, List markList) {
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
        return dangerzone.trim();
    }

    // returns username of student in format {firstname}.{lastname}{last two digits of grad year}@ycdsbk12.ca
    private static String username(String firstname, String lastname, String year){

        return ("Login email: " + firstname + "." + lastname + year.substring(year.length()-2) + "@ycdsbk12.ca");
    }

    // returns password of student in format first initial}{lowercase last initial}{student number}
    private static String passwordInformation(String firstname, String lastname, String studentNumber){

        String upperFirstInitial = String.valueOf(Character.toUpperCase(firstname.charAt(0)));
        String lowerLastInitial = String.valueOf(Character.toLowerCase(lastname.charAt(0)));
        return (upperFirstInitial + lowerLastInitial + studentNumber);
    }

    //calculates the average of the class
    private static double classAverage(List markList){

        double classTotal = 0;

        //uses studentAverage function to caclulate class average and return it
        for (int i = 0; i < markList.size(); i++){

            List studentmarks = (List)markList.get(i);

            classTotal += studentAverage(studentmarks);

        }
        double classAverage = (classTotal/markList.size());
        return classAverage;
    }
    //determines students with assignments that are missing
    private static String missingAssignments(List classList, List markList) {

        Scanner input = new Scanner(System.in);

        System.out.print("Number of assignments students should have: ");
        String assignments =  input.nextLine();
        int assignmentI = Integer.parseInt(assignments);

        String badStudents = "";

        //scans for students with inadequte assignment entries and adds them to a list
        for (int i = 0; i < classList.size(); i++) {
            List studentmarks = (List) markList.get(i);

            if (studentmarks.size() < assignmentI) {
                List studentname = (List) classList.get(i);
                String first = (String) studentname.get(0);
                String last = (String) studentname.get(1);

                String fullname = first + " " + last;
                badStudents += fullname + " ";

            }

        }
        return badStudents.trim();
    }
    // returns a list of the students names with the student's average and the class average
    private static List studentReport(List classList, List markLists) {
        List report = new ArrayList();

        for (int i = 0; i < classList.size(); i++) {

            List studentreport = new ArrayList();

            List studentMarks =(List) markLists.get(i);
            List studentList = (List) classList.get(i);


            double studentavg = studentAverage((studentMarks));
            double classavg = classAverage(markLists);
            String fname = (String) studentList.get(0);
            String lname = (String) studentList.get(1);
            studentreport.add(fname);
            studentreport.add(lname);
            studentreport.add(studentavg);
            studentreport.add(classavg);
            report.add(studentreport);

        }

    return report;
    }
    
    // main
    public static void main (String[] args){

        // 2d list in which each indexed list has the student's name, number and grad date
        List classList = new ArrayList();
        List markList = new ArrayList();

        Scanner input = new Scanner(System.in);

        boolean done = false;

        while (!done) {
            // User chooses what they want to do
            System.out.println("1) Manage Class List \n2) Manage Marks \n3) Display");
            System.out.print("Enter 1, 2, 3: ");
            String manage = input.nextLine();

            if (manage.equals("1")) {

                // user chooses how they want to manipulate the class list
                System.out.println("1) Add Student Info \n2) Remove Student \n3) Edit ");
                System.out.print("Enter 1, 2 or 3: ");
                String options = input.nextLine();

                if (options.equals("1")) {
                    List empty = new ArrayList();
                    // this stores the list returned by entering all the data into the full class list
                    classList.add(addStudentInfo());


                    markList.add(empty);
                }
                //remove student info option
                else if (options.equals("2")) {
                    int index = indexOfStudent(classList);

                    classList.remove(index);
                    markList.remove(index);
                }
                //edit student info
                else if (options.equals("3")) {
                    classList.set(indexOfStudent(classList), addStudentInfo());
                }
            }
            //more user options
            else if (manage.equals("2")) {
                System.out.println("1) Add Marks \n2) Remove Marks \n3) Edit");
                System.out.print("Enter 1, 2, or 3: ");
                String options = input.nextLine();

                //add student marks
                if (options.equals("1")) {

                    markList.set(indexOfStudent(classList), getMarks());
                    System.out.println(markList);
                }
                //remove student marks
                else if (options.equals("2")) {
                    int index = indexOfStudent(classList);
                    List empty = new ArrayList();

                    markList.set(index, empty);
                }

                //edit student marks
                else if (options.equals("3")) {
                    markList.set(indexOfStudent(classList), getMarks());
                }
            
            //display options
            else if (manage.equals("3")) {
                System.out.println("1) Display Class List \n2) Display marks of a student \n3) Display Login Info of student");
                System.out.println("4) Display Student Average \n5) Display Class Average \n6) Students with average below 65");
                System.out.println("7) Students With Missing Assignments \n8) Student report of average compared to class average");
                System.out.println("Enter 1, 2, 3, 4, 5, 6, 7, 8: ");
                String options = input.nextLine();

                //display class list
                if (options.equals("1")) {
                    System.out.println(classList);
                }
                //display marks of a student
                else if (options.equals("2")) {
                    List studentMarks = correspondingMark(classList, markList);
                    System.out.println(studentMarks);
                }play
                //display login info
                else if (options.equals("3")) {
                    String firstname = getFirstName();
                    String lastname = getLastName();
                    String studentnumber = getStudentNumber();
                    String gradYear = getGraduatingYear();

                    String username = username(firstname, lastname, gradYear);
                    String password = passwordInformation(firstname, lastname, studentnumber);
                    System.out.println(username);
                    System.out.println("Password: " + password);
                }
               
                //display student average
                else if (options.equals("4")) {
                    double avg = studentAverage(correspondingMark(classList, markList));
                    System.out.println("This student's average is: " + avg);
                }
                
                //display class average
                else if (options.equals("5")) {
                    double classavg = classAverage(markList);
                    System.out.println("The class average is: " + classavg);
                }
                
                //display student with average lower than 65
                else if (options.equals("6")) {
                    String dangerzone = LessThan65(classList, markList);
                    System.out.println(dangerzone);
                }

                //display students with missing assignments
                else if (options.equals("7")) {
                    String missing = missingAssignments(classList, markList);
                    System.out.println(missing);
                }
                
                //report
                else if (options.equals("8")) {
                    List report = studentReport(classList, markList);
                    System.out.println(report);

                }
            }
        }
    }

}
