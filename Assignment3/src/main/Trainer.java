
public class Trainer extends Person {

    private String specialty;

    public Trainer(String name, String email, String address,
                  String gender, String specialty) {
        super(email, name, address, gender);
        this.specialty = specialty;
    }

    public void setSpecialty(String specialty)
    {
        this.specialty = specialty;
    }

    public String toString()
    {
        return super.toString() + "Specialty: " + specialty;
    }

}

