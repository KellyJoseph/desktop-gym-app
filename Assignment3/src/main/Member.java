import java.util.Scanner;
import java.util.HashSet;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
// THIS CODE IS INCOMPLETE

public class Member extends Person {
    private float height;
    private float startWeight;
    private String chosenPackage;
    public  HashMap<String, Assessment> assessmentList;


    public Member(String email, String name, String address,
                  String gender, float height, float startWeight, String chosenPackage) {
        super(email, name, address, gender);
        this.height = setHeight(height);
        this.startWeight = setStartWeight(startWeight);
        this.chosenPackage = chosenPackage;
        assessmentList = new HashMap<String, Assessment>();
    }


    public float setHeight(float height) {
        if ((height >= 1) && (height <= 3)) {
            this.height = height;
        } else {
            this.height = 1.5f;
        }
        return this.height;
    }

    public float setStartWeight(float startWeight) {
        if ((startWeight >= 35) && (startWeight <= 250)) {
            this.startWeight = startWeight;
        } else {
            this.startWeight = 60f;
        }
        return this.startWeight;
    }

    public void setChosenPackage(String chosenPackage) {
        this.chosenPackage = chosenPackage;
    }


    public float getHeight() {
        return height;
    }

    public float getStartWeight() {
        return startWeight;
    }

    public String getChosenPackage() {
        return chosenPackage;
    }

    public Assessment getAssessment(String date)
    {
        Assessment assessment = assessmentList.get(date);
        return assessment;
    }


    public Assessment latestAssessment() // use sorted assessments to get the key for latest assessment object
    {
        String key = sortedAssessmentDates().last().toString();
        return getAssessment(key);
    }

//http://data-structure-learning.blogspot.jp/2015/06/sort-hashmap-by-keys.html
    public SortedSet sortedAssessmentDates()
    {
        TreeSet<String> set = new TreeSet<String>(assessmentList.keySet());
        return set;
    }


    public String toString() {
        return super.toString() + "\n" + "Height: " + height + ", Starting Weight" +
                startWeight + ", Package" + chosenPackage;
    }


}




