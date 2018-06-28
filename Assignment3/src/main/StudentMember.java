public class StudentMember extends Member {
    private int studentId;
    private String collegeName;


    public StudentMember(String email, String name, String address, String gender, float height, float startWeight,
                         int studentId, String collegeName, String chosenPackage)
    {
        super(email, name, address, gender, height, startWeight, chosenPackage);
        this.studentId = studentId;
        this.collegeName = collegeName;
    }


   public void setStudentId(int studentId) { this.studentId = studentId;}

   public void setCollegeName(String collegeName) { this.collegeName = collegeName;}

   public int getStudentId () { return studentId;}

   public String getCollegeName () {return collegeName;}

  @Override
   public String toString() { return super.toString() + "Student ID:" + studentId + "College Name" + collegeName; }

}
