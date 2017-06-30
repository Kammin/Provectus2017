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


    public String getThumbnail(){
        return picture.getThumbnail();
    }
    public String getLarge(){
        return picture.getLarge();
    }
    public String getSignature(){
        return name.getSignature();
    }
    public String getEmail(){
        return email;
    }


    public String getStreet(){
        return location.getStreet();
    }
    public String getCity(){
        return location.getCity();
    }
    public String getState(){
        return location.getState();
    }
    public String getPostcode(){
        return location.getPostcode();
    }


    public String getDob(){
        return dob;
    }
    public String getRegistered(){
        return registered;
    }
    public String getPhone(){
        return phone;
    }
    public String getCell(){
        return cell;
    }
    public String getName(){
        return ID.getIdName();
    }
    public String getValue(){
        return ID.getValue();
    }


    public String getUsername(){
        return login.getUsername();
    }
    public String getPassword(){
        return login.getPassword();
    }
    public String getSalt(){
        return login.getSalt();
    }
    public String getMd5(){
        return login.getMd5();
    }
    public String getSha1(){
        return login.getSha1();
    }
    public String getSha256(){
        return login.getSha256();
    }
}
