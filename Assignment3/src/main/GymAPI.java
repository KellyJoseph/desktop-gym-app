import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

// THIS CODE IS INCOMPLETE

public class GymAPI {
    public ArrayList<Member> members;
    public ArrayList<Trainer> trainers;
    public Assessment assessment;
    private static  Scanner input = new Scanner(System.in);


    public GymAPI() {
        members = new ArrayList<Member>();
        trainers = new ArrayList<Trainer>();
    }

    public void addMember(Member member)
    {
        members.add(member);
    }
    public void addTrainer (Trainer trainer)
    {
        trainers.add(trainer);
    }

    public void registerMember() {
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

            Member member = (new Member(email, name, address, gender, height, startWeight, chosenPackage));
            addMember(member);
        }
    }

    public void registerTrainer()
    {
        input.nextLine();
        System.out.println("Enter name");
        String name = input.nextLine();
        System.out.println("enter email");
        String email = input.nextLine();
        System.out.println("Enter address");
        String address = input.nextLine();
        System.out.println("Enter your gender(M or F");
        String gender = input.nextLine().toUpperCase();
        System.out.println("Enter specialty");
        String specialty = input.nextLine();

        Trainer trainer = (new Trainer(name, email, address, gender, specialty));
        addTrainer(trainer);
    }


    public int numberOfMembers() {
        int number = members.size();
        return number;
    }

    public int numberOfTrainers() {
        int number = trainers.size();
        return number;
    }

    public ArrayList getMembers() {
        return members;
    }

    public ArrayList getTrainers() {
        return trainers;
    }

    public boolean isValidMemberIndex(int index) {
        if (index > members.size() - 1 || members.isEmpty()) {
            return false;
        } else return true;
    }


    public boolean isValidTrainerIndex(int index) {
        if (index + 1 > trainers.size() || trainers.isEmpty()) {
            return false;
        } else return true;
    }



    public ArrayList<String> searchMembersByName(String nameEntered)
    {
        ArrayList fullMatch = new ArrayList<>();
        ArrayList partialMatch = new ArrayList();
        for (int i = 0; i < members.size(); i++)
        {
            String name = members.get(i).getName();
            if ((name.equals(nameEntered))) {fullMatch.add(name);}
            else if ((name.contains(nameEntered))) {partialMatch.add(name);}
        }
        if (!fullMatch.isEmpty()) {return fullMatch;}
        else return partialMatch;
    }

    public ArrayList<String> searchTrainersByName(String nameEntered)
    {
        ArrayList fullMatch = new ArrayList<>();
        ArrayList partialMatch = new ArrayList();
        for (int i = 0; i < trainers.size(); i++)
        {
            String name = trainers.get(i).getName();
            if ((name.equals(nameEntered))) {fullMatch.add(name);}
            else if ((name.contains(nameEntered))) {partialMatch.add(name);}
        }
        if (!fullMatch.isEmpty()) {return fullMatch;}
        else return partialMatch;
    }

    public Member searchMembersByEmail(String emailEntered) {
        for (int i = 0; i < members.size(); i++) {
            if (members.get(i).getEmail().equals(emailEntered)) {
                Member member = members.get(i);
                return member;
            }
        }
        return null;
    }




    public Trainer searchTrainersByEmail(String emailEntered) {
        for (int i = 0; i < trainers.size(); i++)

            if ((trainers.size() != 0) && (trainers.get(i).getEmail().equals(emailEntered)))
            {
                return trainers.get(i);
            }
            else System.out.println("No trainers found");
        return null;
    }





    public  String listMembers() {
        if (members.isEmpty()) {
            return "No members";
        } else {
            String listMembers = " ";
            for (int i = 0; i < members.size(); i++) {
                listMembers += members.get(i).getName().toString() + "\n";
            }
            return listMembers;
        }
    }

    public void addAssessment()
    {
        System.out.println("Enter the email of the user you wish to assess");
        String userSearch = input.nextLine();
        Member member = searchMembersByEmail(userSearch);
        System.out.println("Enter assessment date (YY/MM/DD): ");
        String date = input.nextLine();
        System.out.println("Enter thigh size: ");
        Float thigh = input.nextFloat();
        System.out.println("Enter waist size: ");
        Float waist = input.nextFloat();
        System.out.println("Enter weight (kg): ");
        Float weight = input.nextFloat();
        System.out.println("Trainer comment: ");
        String scannerBug = input.nextLine();//scanner bug
        String comment = input.nextLine();
        System.out.println("Trainer name: ");
        String trainerName = input.nextLine();

        Assessment assessment = new Assessment(weight, thigh, waist, comment);
        member.assessmentList.put(date, assessment);
    }

    public void loadMembers() throws Exception  {
            XStream xstream = new XStream(new DomDriver());
            ObjectInputStream is = xstream.createObjectInputStream(new FileReader("members.xml"));
            members = (ArrayList<Member>) is.readObject();
            is.close();
    }

    public void saveMembers() throws Exception {
            XStream xstream = new XStream(new DomDriver());
            ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter("members.xml"));
            out.writeObject(members);
            out.close();
    }

    public void loadTrainers() throws Exception {
            XStream xstream = new XStream(new DomDriver());
            ObjectInputStream is = xstream.createObjectInputStream(new FileReader("trainers.xml"));
            trainers = (ArrayList<Trainer>) is.readObject();
            is.close();
    }

    public void saveTrainers() throws Exception {
            XStream xstream = new XStream(new DomDriver());
            ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter("trainers.xml"));
            out.writeObject(trainers);
            out.close();
    }





   /* public boolean memberLogIn(String email) {
        for (int i = 0; i < members.size(); i++) {
            members.get(i);
            if (members.get(i).getEmail().equals(email)) {
                return true;
            }
        }
        else return false;
    }*/
}