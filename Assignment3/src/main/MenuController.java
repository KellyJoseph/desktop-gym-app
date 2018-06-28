import java.util.Scanner;

public class MenuController {
    private Scanner input = new Scanner(System.in);
    private GymAPI api;
    private Assessment assessment;
    private Member loggedInMember;
    private Trainer loggedInTrainer;
    private String sessionEmail; //used to keep track of member or trainer object retrieved in each menu

    public static void main(String[] args) {MenuController c = new MenuController();}

    public MenuController() {
        api = new GymAPI();
        logInMenuChoices(); }

    private int logInMenuOptions()
    {
        System.out.println("Are you a trainer or a gym member?");
        System.out.println("-------------------");
        System.out.println("1. Gym member");
        System.out.println("2. trainer");
        System.out.println("3. Register member");
        System.out.println("4. Register trainer");
        System.out.println("5. Save members and trainers from xml");
        System.out.println("6, Load members and trainers from xml");
        System.out.println("==>>");
        int option = input.nextInt();
        return option;
    }
    private void logInMenuChoices()
    {
        int option = logInMenuOptions();
        while (option != 0)
        {
            switch (option)
            {
                case 1:
                    memberLogIn();
                    break;
                case 2:
                    trainerLogIn();
                    break;
                case 3:
                    api.registerMember();
                    break;
                case 4:
                    api.registerTrainer();
                    break;
                case 5:
                    try {
                        api.saveMembers();
                        api.saveTrainers();
                    }
                    catch (Exception e) {
                        System.err.println("Error writing to file: " + e);
                    }
                    break;
                case 6:
                    try {
                        api.loadMembers();
                        api.loadTrainers();
                    }
                    catch (Exception e) {
                        System.err.println("Error reading from file: "+ e );
                    }
                    break;
                default:
                    System.out.println("Invalid input");
                    break;
            }
            System.out.println("Press any key to continue");
            input.nextLine();
            option = logInMenuOptions();
        }
        System.out.println("Exiting program, bye");
    }

    public void memberLogIn()
    {
        input.nextLine();
        System.out.println("Enter your email address");
        String enteredEmail = input.nextLine();
        boolean proceed = false;
        if (api.searchMembersByEmail(enteredEmail) != null) {
            proceed = true;
            loggedInMember = api.searchMembersByEmail(enteredEmail);
        }

        if (proceed == true)
        {
            sessionEmail = enteredEmail;
            memberMenu();
        }
        System.out.println("The email entered does not exist, please register a new account");

    }

    public void trainerLogIn()
    {
        input.nextLine();
        System.out.println("Enter your email address");
        String enteredEmail = input.nextLine();
        boolean proceed = false;
        if (api.searchTrainersByEmail(enteredEmail)!= null) {
            proceed = true;
        }
        if (proceed == true)
        {
            sessionEmail = enteredEmail;
            trainerMenu();
        }
        System.out.println("The email entered does not exist, please register a new trainer account");
    }


    private int memberMenuOption()
    {
        System.out.println("choose one of these following options");
        System.out.println("1. To view your profile information press 1");
        System.out.println("2. To set your name press 2");
        System.out.println("3. To view an assessment, press 3");
        System.out.println("4. To set your address press 4");
        System.out.println("5. To set your gender press 5");
        System.out.println("6. To set your height press 6");
        System.out.println("7. To set your starting weight press 7");
        System.out.println("8. To view assessment dates press 8");
        System.out.println("9. To view the latest assessment press 9");
        System.out.println("10, View current BMI");
        System.out.println("11, View current BMI category");
        System.out.println("0. To return to previous page, press 0");
        int option = input.nextInt();
        return option;
    }


    private void memberMenu()
    {
        int option =memberMenuOption();
        Member member1 = api.searchMembersByEmail(sessionEmail);
        while(option != 0)
        {
            switch (option)
            {
                case 1:
                    member1.toString();
                    System.out.println(member1.toString());
                    break;
                case 2:
                    input.nextLine();
                    System.out.println("Enter your name");
                    String name = input.nextLine();
                    member1.setName(name);
                    break;
                case 3:
                    input.nextLine();
                    System.out.println("Enter the assessment date you wish to view(yyyymmdd)");
                    String date = input.nextLine();
                    System.out.print(member1.getAssessment(date).assessmentToString());
                    break;
                case 4:
                    input.nextLine();
                    System.out.println("Enter your address");
                    String address = input.nextLine();
                    member1.setAddress(address);
                    break;
                case 5:
                    input.nextLine();
                    System.out.println("Enter your gender");
                    String gender = input.nextLine();
                    member1.setGender(gender);
                    break;
                case 6:
                    System.out.println("Enter your height");
                    float height = input.nextFloat();
                    member1.setHeight(height);
                    break;
                case 7:
                    System.out.println("Enter your starting weight");
                    float startWeight = input.nextFloat();
                    member1.setStartWeight(startWeight);
                    break;
                case 8:
                    System.out.print(member1.sortedAssessmentDates().toString());
                    break;
                case 9:
                    System.out.print(member1.latestAssessment().assessmentToString());
                    break;
                case 10: System.out.print(GymUtility.calculateBMI(member1, member1.latestAssessment()));
                    break;
                case 11:
                    System.out.println("Enter your BMI");
                    double BMI = input.nextDouble();
                    System.out.println(GymUtility.determineBMICategory(BMI));
                    break;

                case 0:
                    System.out.println("Returning to previous page");
                    logInMenuChoices();
                    break;
                default:
                    System.out.println("Invalid input");
                    break;
            }
            System.out.println("Press any key");
            input.nextLine();
            option = memberMenuOption();
        }
    }

    private int trainerMenuOption()
    {
        System.out.println("Select one of the following options");
        System.out.println("1. To add a member, press 1");
        System.out.println("2. To See all members, press 2");
        System.out.println("3. To add an assessment to a gym member, press 3");
        System.out.println("4. To go back to previous page press 4");
        int option = input.nextInt();
        return option;
    }


    private void trainerMenu()
    {
        int option = trainerMenuOption();
        while (option != 0)
        {
            switch (option) {
                case 1:
                    api.registerMember();
                    break;
                case 2:
                    System.out.println(api.listMembers());
                    break;
                case 3:
                    input.nextLine();
                    System.out.println("Enter the email of the user who you wish to comment on");
                    String userEmail =input.nextLine();
                    if(api.searchMembersByEmail(userEmail)!= null) {
                        api.addAssessment();
                    }
                    else System.out.println("A user with that email address does not exist");
                    break;
                case 4:
                    logInMenuChoices();
                    break;
                default:
                    System.out.println("Invalid input");
                    break;
            }
            input.nextLine();
            option = trainerMenuOption();
        }
    }
}
