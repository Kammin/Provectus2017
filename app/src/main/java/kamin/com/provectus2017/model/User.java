package kamin.com.provectus2017.model;

import com.google.gson.annotations.SerializedName;

public class User {
    String gender;
    Name name;
    Location location;
    String email;
    Login login;
    String dob;
    String registered;
    String phone;
    String cell;
    @SerializedName("id")
    Id ID;
    Picture picture;
    String nat;

    public Name getName(){
        return name;
    }
    public Login getLogin(){
        return login;
    }

    public String getThumbnail(){
        return picture.getThumbnail();
    }
    public String getLarge(){
        return picture.getLarge();
    }
    public String getFirst(){
        return getName().first;
    }

    public String getLast(){
        return getName().last;
    }
    public String getGender(){
        return gender;
    }
}
