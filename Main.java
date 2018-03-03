import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * CLI-Marklist assignment
 * @version 2.1
 * @author Brandon Lew, Simon Minich, Joshua Voss, Franklin Zheng
 */
public class main {
    public static void main (String[] args){

        // 2d list in which each indexed list has the student's name, number and grad date
        List classList = new ArrayList();
        List markList = new ArrayList();

        //  program infinite looped
        initializeProgram(classList, markList);
    }

    /**
     * runs the program without stopping
     * @param classList 2D list containing student basic info
     * @param markList  2D list containing student mark info
     */
    private static void initializeProgram(List classList, List markList) {
        Scanner input = new Scanner(System.in);

        boolean done = false;

        // infinite loop
        while (!done) {

            //user initial options
            initialOptionPaths(classList, markList);
        }
    }

    /**
     * Display initial path options for program
     * @param classList 2D list containing student basic info
     * @param markList  2D list containing student mark info
     */
    private static void initialOptionPaths(List classList, List markList) {
        Scanner input = new Scanner(System.in);

        String manage = getInitialOptions();

        if (manage.equals("1")) {

            // classListManipulation
            manageStudents(classList, markList);
        }

        else if (manage.equals("2")) {

            // markManipulation
            markOptions(classList, markList);
        }

        else if (manage.equals("3")) {

            // displayOptions
            displayOptions(classList, markList);

        }
    }

    /**
     * get initial path options to choose what to do
     * @return user input
     */
    private static String getInitialOptions() {
        Scanner input = new Scanner(System.in);

        // User String input
        System.out.println("\n1) Manage Class List \n2) Manage Marks \n3) Display");
        System.out.print("Enter 1, 2, 3: ");
        return input.nextLine();
    }

    /**
     * Options to display
     * @param classList 2D list containing student basic info
     * @param markList  2D list containing student mark info
     */
    private static void displayOptions(List classList, List markList) {
        Scanner input = new Scanner(System.in);

        // Initial options for user
        printDisplayOptionsForUser();

        String options = input.nextLine();

        if (options.equals("1")) {

            reportFormatted(studentReport(classList, markList));

        }

        else if (options.equals("2")) {

            // print login info
            printLoginInfo();
        }

        else if (options.equals("3")) {

            // print students with avg < 65
            LessThan65(classList, markList);
        }

        else if (options.equals("4")) {

            // print students with missing assignments
            missingAssignments(classList, markList);

        }
    }

    /**
     * Display login info froim user input
     */
    private static void printLoginInfo() {

        String firstname = getFirstName();
        String lastname = getLastName();
        String studentnumber = getStudentNumber();
        String gradYear = getGraduatingYear();

        String username = username(firstname, lastname, gradYear);
        String password = passwordInformation(firstname, lastname, studentnumber);

        System.out.println(username);
        System.out.println("Password: " + password);
    }

    /**
     * Options to Display data
     */
    private static void printDisplayOptionsForUser() {
        System.out.println("\n1) Display Class report  \n2) Display Login Info of student");
        //System.out.println("4) Display Student Average \n5) Display Class Average ");
        System.out.println("3) Students with average below 65");
        System.out.println("4) Students With Missing Assignments ");
        System.out.println("\nEnter 1, 2, 3, 4: ");
    }

    /**
     * User input and paths to manipulate mark data
     */
    private static void markOptions(List classList, List markList) {
        Scanner input = new Scanner(System.in);
        System.out.println("\n1) Add Marks \n2) Remove Marks \n3) Edit");
        System.out.print("\nEnter 1, 2, or 3: ");
        String options = input.nextLine();

        if (options.equals("1")) {

            // add marks
            markList.set(indexOfStudent(classList), getMarks());
            System.out.println(markList);
        }

        else if (options.equals("2")) {
            // remove marks
            int index = indexOfStudent(classList);
            List empty = new ArrayList();

            markList.set(index, empty);
        }

        else if (options.equals("3")) {
            // edit marks
            markList.set(indexOfStudent(classList), getMarks());
        }
    }

    /**
     * path users can take to manipulate student data
     * @param classList 2D list containing student basic info
     * @param markList  2D list containing student mark info
     */
    private static void manageStudents(List classList, List markList) {
        String options = getStudentOptions();

        if (options.equals("1")) {

            // newStudent
            newStudent(classList, markList);
        }

        else if (options.equals("2")) {
            // removeStudent
            removeStudent(classList, markList);
        }

        else if (options.equals("3")) {
            // editStudent
            classList.set(indexOfStudent(classList), addStudentInfo());
        }
    }

    /**
     * user input options to manipulate student data
     * @return User input
     */
    private static String getStudentOptions() {
        Scanner input = new Scanner(System.in);

        System.out.println("\n1) Add Student \n2) Remove Student \n3) Edit Student ");
        System.out.print("\nEnter 1, 2 or 3: ");
        return input.nextLine();
    }

    /**
     * remove a Student and their marks from classList and markList
     * @param classList 2D list containing student basic info
     * @param markList  2D list containing student mark info
     */
    private static void removeStudent(List classList, List markList) {
        int index = indexOfStudent(classList);

        classList.remove(index);
        markList.remove(index);
    }

    /**
     * add a student's information to both class and mark lists
     * @param classList 2D list containing student basic info
     * @param markList  2D list containing student mark info
     */
    private static void newStudent(List classList, List markList) {
        List empty = new ArrayList();
        // this stores the list returned by entering all the data into the full class list
        classList.add(addStudentInfo());

        markList.add(empty);
    }

    /**
     * user inputs first name of student
     * @return String first name of student
     */
    private static String getFirstName() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter first name: ");
        String firstName = input.nextLine();

        return firstName;
    }

    /**
     * user inputs last name of student
     * @return String last name of student
     */
    private static String getLastName() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter last name: ");
        String lastName = input.next();

        return lastName;
    }

    /**
     * user inputs student number
     * @return String student number of student
     */
    private static String getStudentNumber() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter student ID: ");
        int studentNumber = input.nextInt();

        return Integer.toString(studentNumber);
    }

    /**
     * user inputs graduating year of student
     * @return String graduating year of student
     */
    private static String getGraduatingYear() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter graduating year: ");
        int graduatingYear = input.nextInt();

        return Integer.toString(graduatingYear);
    }

    /**
     * stores Student's full name and student number into a list
     * @return List of a student's basic information
     */
    private static List addStudentInfo() {
        System.out.println("\nAdd student information");

        List info = new ArrayList();

        String nameF = getFirstName();
        String nameL = getLastName();
        String studentNo = getStudentNumber();

        info.add(0, nameF);
        info.add(1, nameL);
        info.add(2, studentNo);

        System.out.println("You have added: " + nameF + " | " + nameL + " | " + studentNo);
        return info;
    }

    /**
     * user inputs a student's grades based on the number of assignments to be graded
     * @return List of a student's grades on completed assignments
     */
    private static List getMarks() {

        //ask user how many marks are being entered
        List empty = new ArrayList();
        Scanner input = new Scanner(System.in);
        System.out.print("How many assignment marks are being entered?: ");
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

    /**
     * find the location of a student in the class list based on student number in order to store mark data in the same index
     * @param classList 2D list containing student basic info
     * @return int index number of student
     */
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
        // should never reach this point
        return -1;
    }

    /**
     *  calculates a student's average
     * @param studentMarks List of an individual student's marks
     * @return double average of the student's marks
     */
    private static double studentAverage(List studentMarks) {

        double addedEntries = 0;

        for (int i = 0; i < studentMarks.size(); i ++){

            int grade = (Integer) studentMarks.get(i);
            addedEntries += grade;
        }

        return (addedEntries/studentMarks.size());
    }

    /**
     * prints list of students with avg less than 65
     * @param classList 2D list containing basic student info
     * @param markList  2D list containing student mark info
     */
    private static void LessThan65(List classList, List markList) {

        // loop for number of students
        for (int i=0; i<classList.size(); i++) {

            // get marks of student at position i
            List studentMarks = (List) markList.get(i);

            // check if student has avg below 65
            if (studentAverage(studentMarks) <= 65) {
                String dangerzone = "| ";

                // first and last names are stored within the first 2 indexes of inner list
                for (int k = 0; k < 2; k++) {

                    // check each inner list within classList
                    List name = (List) classList.get(i);

                    // retrieves the first name first then last name from inner list and adds them together
                    String full = name.get(k).toString();
                    dangerzone += full + " | ";
                }

                System.out.println(dangerzone);
            }
        }
    }

    /**
     * username of student in format {firstname}.{lastname}{last two digits of grad year}@ycdsbk12.ca
     * @param firstname first name of student
     * @param lastname last name of student
     * @param year graduating year of student
     * @return String formatted login email of student
     */
    private static String username(String firstname, String lastname, String year){

        return ("Login email: " + firstname + "." + lastname + year.substring(year.length()-2) + "@ycdsbk12.ca");
    }

    /**
     * password of student in format first initial}{lowercase last initial}{student number}
     * @param firstname first name of student
     * @param lastname last name of student
     * @param studentNumber student's student number
     * @return String formatted password of student
     */
    private static String passwordInformation(String firstname, String lastname, String studentNumber){

        // make first initial of first name capital and first initial of last name lower case
        String upperFirstInitial = String.valueOf(Character.toUpperCase(firstname.charAt(0)));
        String lowerLastInitial = String.valueOf(Character.toLowerCase(lastname.charAt(0)));
        return (upperFirstInitial + lowerLastInitial + studentNumber);
    }

    /**
     * calculates class average
     * @param markList 2D list containing student mark info
     * @return double average of entire class based on individual student averages
     */
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

    /**
     * full names of students with missing assignments
     * @param classList 2D list containing basic student info
     * @param markList 2D list containing student mark info
     */
    private static void missingAssignments(List classList, List markList) {

        Scanner input = new Scanner(System.in);

        System.out.print("Number of assignments students should have: ");
        String assignments =  input.nextLine();
        int assignmentI = Integer.parseInt(assignments);


        for (int i = 0; i < classList.size(); i++) {
            List studentmarks = (List) markList.get(i);
            String badStudents = "| ";

            // check if number of stored marks is less than number of required assignments
            if (studentmarks.size() < assignmentI) {
                List studentname = (List) classList.get(i);
                String first = (String) studentname.get(0);
                String last = (String) studentname.get(1);

                String fullname = first + " | " + last;
                badStudents += fullname + " | ";

            }
            System.out.println(badStudents);
        }
    }

    /**
     * List of student's basic information with their rounded average and class average
     * @param classList 2D list containing basic student info
     * @param markList 2D list containing student mark info
     * @return 2D List of every student's mark report
     */
    private static List studentReport(List classList, List markList) {
        List report = new ArrayList();

        // loop over all students
        for (int i = 0; i < classList.size(); i++) {

            List studentreport = new ArrayList();

            List studentMarks =(List) markList.get(i);
            List studentList = (List) classList.get(i);

            // round student average to 2 decimal places
            double studentavg = studentAverage(studentMarks);
            double roundedavg = Math.round(studentavg*100.0)/100.0;
            String stringAvg = Double.toString(roundedavg);

            // round class average to 2 decimal places
            double classavg = classAverage(markList);
            double classrounded = Math.round(classavg*100.0)/100.0;
            String stringclassavg = Double.toString(classrounded);

            // get full name and student number of student
            String fname = (String) studentList.get(0);
            String lname = (String) studentList.get(1);
            String studentNumber = (String) studentList.get(2);

            // add all elements to a List
            studentreport.add(fname);
            studentreport.add(lname);
            studentreport.add(studentNumber);
            studentreport.add(stringAvg);
            studentreport.add(stringclassavg);

            // add list into 2D List with other student reports
            report.add(studentreport);

        }

    return report;
    }

    /**
     * formatted version of all student reports
     * @param report 2D List of every student's basic information and their rounded average compared to the class average
     */
    private static void reportFormatted(List report) {

        System.out.println("\n|First Name|Last Name|Student Number|Student Average|Class Average|\n");
        for (int i = 0; i < report.size(); i++) {

            List reportIndividual = (List) report.get(i);

            String formatted = "| ";

            for (int j = 0; j < reportIndividual.size(); j++) {

                String info = (String) reportIndividual.get(j);
                formatted += info + " | ";

            }

            System.out.println(formatted);
        }
    }
}
