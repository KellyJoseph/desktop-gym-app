/*

import java.util.Scanner;

public class Driver {
    private Scanner input = new Scanner(System.in);
    private GymAPI members;
    private GymAPI trainers;
    private Member member;
    private Assessment assessment;

    public static void main(String[] args) {
        Driver c = new Driver();
    }

    public Driver() {
        runMenu1();
    }

    private int mainMenu() {
        System.out.println("Please choose one of the following options.");
        System.out.println("--------------");
        System.out.println("1. Register a new Gym Member");
        System.out.println("2. Enter user stats for gym session");
        System.out.println("3. Display user stats.");
        System.out.println("4. Add assessment for gym session");
        System.out.println("0. Exit menu.");
        System.out.println("==>>.");
        int option = input.nextInt();
        return option;
    }

    private void runMenu1() {
        int option = mainMenu();
        while (option != 0) {
            switch (option) {
                case 1:
                    runMenu2();
                    break;
                case 2:
                    System.out.println("No content yet, need to add sessions");
                    //addSession;
                    break;
                case 3:
                    System.out.println("No method yet, no method yet, need to return user info");
                    //userInfo;
                    break;
                case 4:
                    member.addReport();
                    System.out.println("This message should not be displayed!");
                    break;
                case 5:
                    System.out.println("No method yet, no method yet, need to return user info");
                    break;
                default:
                    System.out.println("Invalid input");
                    break;
            }
            input.nextLine();
            option = mainMenu();
        }
        System.out.println("Exiting program, bye!");
    }


    private int chooseMemberMenu() {
        input.nextLine();
        System.out.println("Choose a member type");
        System.out.println("--------------");
        System.out.println("1. Normal Member");
        System.out.println("2. Premium Member");
        System.out.println("3. Student Member.");
        System.out.println("4. Trainer");
        System.out.println("0. Exit menu.");
        System.out.println("==>>.");
        int option = input.nextInt();
        return option;
    }

    private void runMenu2() {
        int option = chooseMemberMenu();
        while (option != 0) {
            switch (option) {
                case 1:
                    registerMember();
                    break;
                case 2:
                    registerPremiumMember();
                    break;
                case 3:
                    registerStudentMember();
                    break;
                case 4:
                    registerTrainer();
                    break;
                case 5:
                    runMenu1();
                default:
                    System.out.println("Invalid input");
                    break;
            }
            System.out.println("\n press any key");
            input.nextLine();
            option = chooseMemberMenu();
        }
            System.out.println("Exiting program, bye!");

    }


    private void registerMember() {
        boolean goodInput = false;
        input.nextLine();
        System.out.println("Enter name");
        String name = input.nextLine();
        System.out.println("enter email");
        String email = input.nextLine();
        System.out.println("Enter address");
        String address = input.nextLine();
        System.out.println("Enter gender");

        String gender = input.nextLine().substring(0, 1).toUpperCase();
        if (!gender.equals("m") && !gender.equals("f")) {
            {
                gender = "undefined";
            }

            goodInput = false;
            float height = 0;
            do {
                try {
                    System.out.println("enter height in meters");
                    height = input.nextFloat();
                    goodInput = true;
                    if ((height > 3) || (height < 1)) {
                        goodInput = false;
                    }

                } catch (Exception e) {
                    input.nextLine();
                    System.out.println("incorrect entry, must be a number between 1 and 3");
                }
            } while (!goodInput);

            goodInput = false;
            float startWeight = 0;
            do {
                try {
                    System.out.println("Enter starting weight in kg between 35 and 250");
                    startWeight = input.nextFloat();
                    goodInput = true;
                    if ((startWeight > 250) || (startWeight < 35)) {
                        goodInput = false;
                    }
                } catch (Exception e) {
                    input.nextLine();
                    System.out.println("Incorrect entry, must be a number between 35 and 250");
                }
            } while (!goodInput);

            System.out.println("Enter the chosen package");
            String bug = input.nextLine();
            String chosenPackage = input.nextLine();

            members.addMember(new Member(email, name, address, gender, height, startWeight, chosenPackage));
        }
    }


    private void registerPremiumMember() {
        boolean goodInput = false;
        input.nextLine();
        System.out.println("Enter name");
        String name = input.nextLine();
        System.out.println("enter email");
        String email = input.nextLine();
        System.out.println("Enter address");
        String address = input.nextLine();

        System.out.println("Enter a gender");
        String gender = input.nextLine().substring(0, 1).toUpperCase();
        if (!gender.equals("m") && !gender.equals("f")) {
            {
                gender = "undefined";
            }

            goodInput = false;
            float height = 0;
            do {
                try {
                    System.out.println("enter height in meters");
                    height = input.nextFloat();
                    goodInput = true;
                    if ((height > 3) || (height < 1)) {
                        goodInput = false;
                    }

                } catch (Exception e) {
                    input.nextLine();
                    System.out.println("incorrect entry, must be a number between 1 and 3");
                }
            } while (!goodInput);

            goodInput = false;
            float startWeight = 0;
            do {
                try {
                    System.out.println("Enter starting weight in kg between 35 and 250");
                    startWeight = input.nextFloat();
                    goodInput = true;
                    if ((startWeight > 250) || (startWeight < 35)) {
                        goodInput = false;
                    }
                } catch (Exception e) {
                    input.nextLine();
                    System.out.println("Incorrect entry, must be a number between 35 and 250");
                }
            } while (!goodInput);

            System.out.println("Enter the chosen package");
            String chosenPackage = input.nextLine();

            members.addMember(new PremiumMember(name, email, address, gender, height, startWeight, chosenPackage));
        }
    }

    private void registerStudentMember() {
        boolean goodInput = false;
        input.nextLine();
        System.out.println("Enter name");
        String name = input.nextLine();
        System.out.println("enter email");
        String email = input.nextLine();
        System.out.println("Enter address");
        String address = input.nextLine();

        System.out.println("Enter a gender");
        String gender = input.nextLine().substring(0, 1).toUpperCase();
        if (!gender.equals("m") && !gender.equals("f")) {
            {
                gender = "undefined";
            }

            goodInput = false;
            float height = 0;
            do {
                try {
                    System.out.println("enter height in meters");
                    height = input.nextFloat();
                    goodInput = true;
                    if ((height > 3) || (height < 1)) {
                        goodInput = false;
                    }

                } catch (Exception e) {
                    input.nextLine();
                    System.out.println("incorrect entry, must be a number between 1 and 3");
                }
            } while (!goodInput);

            goodInput = false;
            float startWeight = 0;
            do {
                try {
                    System.out.println("Enter starting weight in kg between 35 and 250");
                    startWeight = input.nextFloat();
                    goodInput = true;
                    if ((startWeight > 250) || (startWeight < 35)) {
                        goodInput = false;
                    }
                } catch (Exception e) {
                    input.nextLine();
                    System.out.println("Incorrect entry, must be a number between 35 and 250");
                }
            } while (!goodInput);

            System.out.println("Enter student number");
            int studentId = input.nextInt();
            System.out.println("Enter College Name");
            String bug = input.nextLine();
            String collegeName = input.nextLine();
            System.out.println("Enter the chosen package");
            String chosenPackage = input.nextLine();

            members.addMember(new StudentMember(name, email, address, gender, height, startWeight, studentId, collegeName, chosenPackage));

            runMenu1();
        }
    }

    private void registerTrainer()
    {
        input.nextLine();
        System.out.println("Enter name");
        String name = input.nextLine();
        System.out.println("enter email");
        String email = input.nextLine();
        System.out.println("Enter address");
        String address = input.nextLine();
        System.out.println("Enter gender");
        String gender = input.nextLine();
        System.out.println("Enter specialty");
        String specialty = input.nextLine();

        trainers.addTrainer(new Trainer(name, email, address, gender, specialty));
    }

}

*/
