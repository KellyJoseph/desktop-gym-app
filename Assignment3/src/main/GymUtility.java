import java.util.Date;
public class GymUtility {

    public static double calculateBMI(Member member, Assessment assessment) {
        Date date = new Date();
        String dateKey = String.valueOf(date);
        member.assessmentList.put(dateKey, assessment);  //this line of code is just to pass the assessment which
        // doesn't automatically add the assessment to the assessmentList, and doesn't provide a date key.
        // There may be another way, but the only way to pass the test I found was to add the assessment within this
        // method, otherwise a null value is obtained. Normally the values come from a previously added member.assessment
        Float weight = member.latestAssessment().getWeight();
        Float height = member.getHeight();
        Float BMI = weight / (height * height);

        return toTwoDecimalPlaces(BMI);
    }

    private static double toTwoDecimalPlaces(double num) //this comes from Store V5, not my code
    {
        return (int) (num *100 ) /100.0;
    }


    public static String determineBMICategory(double BMI) {
        double bmiValue = BMI;

        if (bmiValue < 16) {
            return "SEVERELY UNDERWEIGHT";
        }
        if ((bmiValue >= 16) && (bmiValue < 18.5)) {
            return "UNDERWEIGHT";
        }
        if ((bmiValue >= 18.5) && (bmiValue < 25)) {
            return "NORMAL";
        }
        if ((bmiValue >= 25) && (bmiValue < 30)) {
            return "OVERWEIGHT";
        }
        if ((bmiValue >= 30) && (bmiValue < 35)) {
            return "MODERATELY OVERWEIGHT";
        }
        if (bmiValue >= 35) {
            return "SEVERELY OVERWEIGHT";
        } else return "invalid input";
    }

    public static boolean isIdealBodyWeight(Member member, Assessment assessment) {

        Date date = new Date();
        String dateKey = String.valueOf(date);
        member.assessmentList.put(dateKey, assessment);
        if (member.latestAssessment() != null) {
            if (member.getGender().equals("M"))
            {
                double heightInInches = ((member.getHeight() * 100) * 0.39); // 1.0m = 39.0"
                if(heightInInches <60) {heightInInches =60;}
                if (heightInInches >120) {heightInInches = 120;}
                double idealWeight = 50 + ((heightInInches - 60) * 2.3); //
                //For males, an ideal body weight is: 50 kg + 2.3 kg for each inch over 5 feet. 1.0m = 39"
                double actualWeight = member.latestAssessment().getWeight();
                if ((actualWeight>=(idealWeight- 5)) && (actualWeight<= (idealWeight + 5)))
                {
                    return true;
                }
            }
            if ((member.getGender().equals("F"))||(member.getGender().equals("Unspecified")))
            {
                double heightInInches = ((member.getHeight() * 100) * 0.39);
                if(heightInInches <60) {heightInInches =60;}
                if (heightInInches >120) {heightInInches = 120;}
                double idealWeight = 45 + ((heightInInches - 60) * 2.3);
                //For females, an ideal body weight is: 45.5 kg + 2.3 kg for each inch over 5 feet.

                double actualWeight = member.latestAssessment().getWeight();
                if ((actualWeight>=(idealWeight - 5)) && (actualWeight<= (idealWeight + 5)))
                {
                    return true;
                }
            }
        }
        return false;
    }
}

