import java.util.HashMap;
import java.util.ArrayList;
// THIS CODE IS INCOMPLETE

public class Person {

    private String email;
    private String name;
    private String address;
    private String gender;

    public Person(String email, String name, String address, String gender)
    {
        this.email = email;
        this.name = setName(name);
        this.address = address;
        this.gender = setGender(gender);
    }

    public String setGender (String gender) {
        String sex = gender.substring(0, 1).toUpperCase();
        if (sex.equals("M"))
        {
            sex = "M";
            this.gender = sex;
        }
        if (sex.equals("F"))
        {
            sex = "F";
            this.gender = sex;
        }
        if ((!sex.equals("M")) &&(!sex.equals("F")))
        {
            sex = "Unspecified";
            this.gender = sex;
        }
        return sex; // the return part of this method is because it is called within the constructor
    }

    public String setName(String name)
    {
        String cutName =name;
        if (cutName.length() > 30)
        {
            cutName = cutName.substring(0,30);
            this.name = cutName;
        }
        return cutName;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }
    public void setEmail(String email) { this.email = email; }



    public String getName()
    {
        return name;
    }

    public String getAddress()
    {
        return address;
    }

    public String getEmail()
    {
        return email;
    }

    public String getGender()
    {
        return gender;
    }

    public String toString()
    {
        return "Name: " + name + ", Address: " + address + ", Email: " + email
                + ", Gender:"+ gender;
    }

}
