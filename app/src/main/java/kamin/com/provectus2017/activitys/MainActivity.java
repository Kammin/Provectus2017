package kamin.com.provectus2017.activitys;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Arrays;

import kamin.com.provectus2017.R;
import kamin.com.provectus2017.adapter.UserAdapter;
import kamin.com.provectus2017.model.ResponseBody;
import kamin.com.provectus2017.network.StrRequest;
import kamin.com.provectus2017.network.URLs;
import kamin.com.provectus2017.network.VolleySingleton;

public class MainActivity extends AppCompatActivity {

    public static final int requestInternetPermissions = 100;
    public final static String TAG = MainActivity.class.getSimpleName();
    com.android.volley.Response.ErrorListener errorListener;
    Response.Listener<String> responseListener;
    Gson gson;
    private RecyclerView recyclerView;
    private UserAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
            if ((ActivityCompat.checkSelfPermission(this, Manifest.permission.INTERNET) != PackageManager.PERMISSION_GRANTED))
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.INTERNET}, requestInternetPermissions);

        errorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
               Log.d(TAG,"VolleyError "+ error.getMessage());
            }
        };

        responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                ResponseBody resp = gson.fromJson(response, ResponseBody.class);
                Log.d(TAG ,"  "+ resp.getUsers().length + " users loaded.  ");
                adapter.userList.addAll(Arrays.asList(resp.getUsers()));
                adapter.notifyDataSetChanged();
            }
        };

        GsonBuilder gsonBuilder = new GsonBuilder();
        gson = gsonBuilder.create();

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        if(adapter==null)
        adapter = new UserAdapter(this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        if(adapter.userList.size()==0)
        makeRequest();
        recyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                LinearLayoutManager mLayoutManager = (LinearLayoutManager)recyclerView.getLayoutManager();
                if((adapter.userList.size()-mLayoutManager.findLastVisibleItemPosition())<50)
                    makeRequest();
            }
        });

    }

    void makeRequest(){
        StrRequest request = new StrRequest(Request.Method.GET, URLs.fiftyUser, responseListener,errorListener);
        VolleySingleton.getInstance(this.getApplicationContext()).addToRequestQueue(request);

    }

    public void startDetailed(int pos){
        startActivity(new Intent(this, DetailedActivity.class));
        Log.d(TAG,"  "+pos);
        overridePendingTransition(R.anim.right_in, R.anim.left_out);

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == requestInternetPermissions)
            if (grantResults.length > 0) {
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED)
                    Log.d(TAG, "GRANTED");
                if (grantResults[0] == PackageManager.PERMISSION_DENIED)
                    Log.d(TAG, "DENIED");
            }
    }
}
