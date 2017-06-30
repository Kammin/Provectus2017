package kamin.com.provectus2017.activitys;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import kamin.com.provectus2017.R;
import kamin.com.provectus2017.adapter.DataHolder;
import kamin.com.provectus2017.model.User;


public class DetailedActivity extends AppCompatActivity {
    public final static String TAG = DetailedActivity.class.getSimpleName();
    private Toolbar mToolbar;
    int position=0;
    User user;
    ImageView ivLargePhoto;
    TextView first_name,last_name,gender;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed);
        position = getIntent().getExtras().getInt("position",0);
        Log.d(TAG,"position "+position);
        user = DataHolder.userList.get(position);
        initView();
        fillView();
    }

    void initView(){
        ivLargePhoto = (ImageView)findViewById(R.id.ivLargePhoto);
        first_name = (TextView)findViewById(R.id.first_name);
        last_name = (TextView)findViewById(R.id.last_name);
        gender = (TextView) findViewById(R.id.gender);

    }

    void fillView(){
        Glide.with(this).load(user.getLarge()).into(ivLargePhoto);
        first_name.setText(user.getFirst());
        last_name.setText(user.getLast());
        gender.setText(user.getGender());

    }

    private void initToolbar() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        mToolbar.setTitleTextColor(getResources().getColor(android.R.color.white));
    }
}
