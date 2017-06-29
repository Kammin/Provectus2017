package kamin.com.provectus2017.model;

public class Login {
    String username;
    String password;
    String salt;
    String md5;
    String sha1;
    String sha256;

    public String getLogin(){
        return username;
    }
}
