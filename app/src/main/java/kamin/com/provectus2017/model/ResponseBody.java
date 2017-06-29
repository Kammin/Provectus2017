package kamin.com.provectus2017.model;


import com.google.gson.annotations.SerializedName;

public class ResponseBody {
    @SerializedName("results")
    User[] users;
    Info info;

   public User[] getUsers(){
        return users;
    }
}
