import java.util.Scanner;

public class Assessment

{
    private float thigh;
    private float waist;
    private float weight;
    private String comment;
    private String trainerName;

    public Assessment (float weight, float thigh, float waist, String comment)
    {
        setWeight(weight);
        setThigh(thigh);
        setWaist(waist);
        setComment(comment);
        //setTrainerName(trainerName);
    }

    public float setWeight(float weight)
    {
        this.weight = weight;
        return this.weight;
    }

    public float setThigh (float thigh)
    {
        this.thigh = thigh;
        return this.thigh;
    }

    public float setWaist (float waist)

    {
        this.waist = waist;
        return this.waist;
    }

    public String setComment (String comment)
    {
        this.comment = comment;
        return this.comment;
    }
   /* public String setTrainerName (String trainerName)
    {
        this.trainerName = trainerName;
        return this.trainerName;
    }*/

    public float getWeight() { return weight;}
    public float getThigh() { return thigh;}
    public float getWaist() { return waist;}
    public String getComment() { return comment;}
    //public String getTrainerName() { return trainerName;}

    public String getReport ()
    {
        return "Weight: " + weight + "Thigh size: " + thigh + "Waist size: " + waist + "\n" +  "Trainer Comment"
                + comment + "\n";
    }

    public String assessmentToString() {
        return "Weight: " + weight + "\n" + "Thigh: " + thigh + "\n" + "Waist: " + waist + "\n" +
                "Trainer comment: "+ comment + "\n";
    }

}
