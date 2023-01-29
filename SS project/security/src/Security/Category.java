package Security;

import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;


public class Category {
    private static int salary;
    private static double GPA;
    private static String interest;
    private static int interestInt = 0;
    private static int num = 1;
    private static int checklong = 0;
    private static String userName;
    private static String password = "";
    private static Scanner sr = new Scanner(System.in);
    private static Scanner srString = new Scanner(System.in);

    private static Timer timer = new Timer();
    private static TimerTask exitApp = new TimerTask() {
        public void run() {
            System.exit(0);
        }
    };

    public static void main(String[] args) {
        System.out.println("Welcome to the system, which will help you decide which degree program is right for you.");
        System.out.println();
        do {
            try {
                login();
            } catch (InputMismatchException a) {
                System.out.println("Problem! Please Enter the correct Username or Password.");
            }
        } while (checklong == 0);

        System.out.println();

        String pass = null;
        int checkPass = 0;
        int loopTime = 1;
        int checkdata = 0;
        timer.schedule(exitApp, new Date(System.currentTimeMillis() + 600 * 1000));
        do {
            do {
                try {
                    information();
                    checkdata = 1;
                } catch (InputMismatchException a) {
                    System.out.println("Problem! Please Enter the correct salary or GPA or interest.");
                    sr.nextLine();
                }
            } while (checkdata == 0);

            do {
                System.out.print("To see the result, please enter the password again: ");
                pass = srString.nextLine();
                if (password.equals(pass)) {
                    System.out.println("\nThe all suggested programs and daily suggested hours for the degree");
                    System.out.println("completion in programs along with required minimum acceptable GPA after degree completion: \n");
                    
                    setInterestInt(interest);
                    getProgram();

                    System.out.println("when you need to exit from the system please enter the number 0 or 1 when need to do the search again.");
                    num = sr.nextInt();
                    if (num == 0) {
                        System.exit(0);
                    }
                    checkPass = 1;
                } else {
                    System.out.println("Problem! Please Enter the correct Password");
                    checkPass = 0;
                    if (loopTime < 3) {
                        loopTime++;
                    } else {
                        System.exit(0);
                    }
                }
            } while (checkPass == 0);
        } while (num == 1);

        sr.close();
        srString.close();
    }

    public static void setInterestInt(String interest) {
        if (interest.equalsIgnoreCase("Very High")) {
            interestInt = 4;
        }
        if (interest.equalsIgnoreCase("High")) {
            interestInt = 3;
        }
        if (interest.equalsIgnoreCase("Medium")) {
            interestInt = 2;
        }
        if (interest.equalsIgnoreCase("Low")) {
            interestInt = 1;
        }
    }

    public static void getProgram() {
        boolean hasProgram = false;
        Programs se = new SE();
        if (salary >= se.getsalary() && GPA >= se.getGPA() && interestInt >= se.getinterest()) {
            se.print();
            System.out.println("---------------------------------------------------");
            hasProgram = true;
        }

        Programs cy = new CY();
        if (salary >= cy.getsalary() && GPA >= cy.getGPA() && interestInt >= cy.getinterest()) {
            cy.print();
            System.out.println("---------------------------------------------------");
            hasProgram = true;
        }

        Programs csai = new CSAI();
        if (salary >= csai.getsalary() && GPA >= csai.getGPA() && interestInt >= csai.getinterest()) {
            csai.print();
            System.out.println("---------------------------------------------------");
            hasProgram = true;
        }

        Programs cne = new CNE();
        if (salary >= cne.getsalary() && GPA >= cne.getGPA() && interestInt >= cne.getinterest()) {
            cne.print();
            System.out.println("---------------------------------------------------");
            hasProgram = true;
        }

        Programs ds = new DS();
        if (salary >= ds.getsalary() && GPA >= ds.getGPA() && interestInt >= ds.getinterest()) {
            ds.print();
            System.out.println("---------------------------------------------------");
            hasProgram = true;
        }

        if (!hasProgram) {
            System.out.println("Sorry, there is no program that matches the data you entered.");
            System.out.println();
        }
    }

    public static boolean checkName(String name) {
        boolean checkName;
        if (name.length() <= 8 && name.length() >= 3) {
            checkName = true;
        } else {
            checkName = false;
        }
        return checkName;
    }

    public static boolean checkPass(String pass) {
        boolean checkPass;
        if (pass.length() <= 6 && pass.length() >= 4) {
            checkPass = true;
        } else {
            checkPass = false;
        }
        return checkPass;
    }

    public static void login() {
        System.out.println("Note: Username will be between 3 to 8 characters and Password between 4 to 6 digits.");
        System.out.print("please enter your Username: ");
        userName = srString.nextLine();

        System.out.print("please enter your Password: ");
        password = srString.nextLine();

        System.out.println();
        if (checkName(userName) && checkPass(password)) {
            checklong = 1;
            System.out.println("The username and password are correct.");
        } else {
            System.out.println("Problem! Please Enter the correct Username or Password.");
        }
    }

    public static void information() {
        System.out.print("please enter Minimum acceptable industry salary: ");
        salary = sr.nextInt();
        System.out.print("please enter Previous GPA: ");
        GPA = sr.nextDouble();
        System.out.print("please enter Computer Programming interest of student: ");
        interest = srString.nextLine();
    }

}