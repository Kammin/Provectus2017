package kamin.com.provectus2017.model;

public class Login {
    String username;
    String password;
    String salt;
    String md5;
    String sha1;
    String sha256;

    public String getUsername(){
        return username;
    }
    public String getPassword(){
        return password;
    }
    public String getSalt(){
        return salt;
    }
    public String getMd5(){
        return md5;
    }
    public String getSha1(){
        return sha1;
    }
    public String getSha256(){
        return sha256;
    }
}
