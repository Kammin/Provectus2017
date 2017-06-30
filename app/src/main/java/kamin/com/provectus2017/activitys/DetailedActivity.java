package kamin.com.provectus2017.activitys;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import jp.wasabeef.glide.transformations.CropCircleTransformation;
import kamin.com.provectus2017.R;
import kamin.com.provectus2017.Utils.DataHolder;
import kamin.com.provectus2017.model.User;


public class DetailedActivity extends AppCompatActivity {
    public final static String TAG = DetailedActivity.class.getSimpleName();
    private Toolbar mToolbar;
    int position=0;
    User user;
    ImageView ivLargePhoto;
    TextView siqnature, mail, street, city, state, postcode, dob, registered, phone, cell, name, value, username, password, salt, md5, sha1, sha256;

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
        siqnature = (TextView) findViewById(R.id.signature);
        mail = (TextView) findViewById(R.id.mail);

        street = (TextView)findViewById(R.id.street);
        city = (TextView)findViewById(R.id.city);
        state = (TextView) findViewById(R.id.state);
        postcode = (TextView) findViewById(R.id.postcode);

        dob = (TextView)findViewById(R.id.dob);
        registered = (TextView)findViewById(R.id.registered);
        phone = (TextView) findViewById(R.id.phone);
        cell = (TextView) findViewById(R.id.cell);
        name = (TextView)findViewById(R.id.name);
        value = (TextView)findViewById(R.id.value);

        username = (TextView)findViewById(R.id.username);
        password = (TextView)findViewById(R.id.password);
        salt = (TextView) findViewById(R.id.salt);
        md5 = (TextView) findViewById(R.id.md5);
        sha1 = (TextView)findViewById(R.id.sha1);
        sha256 = (TextView)findViewById(R.id.sha256);

    }

    void fillView(){
        Glide.with(this).load(user.getLarge()).bitmapTransform(new CropCircleTransformation(this)).into(ivLargePhoto);
        siqnature.setText(user.getSignature());
        mail.setText(user.getEmail());

        street.setText(getResources().getString(R.string.street)+" "+user.getStreet());
        city.setText(getResources().getString(R.string.city)+" "+user.getCity());
        state.setText(getResources().getString(R.string.state)+" "+user.getState());
        postcode.setText(getResources().getString(R.string.postcode)+" "+user.getPostcode());

        dob.setText(getResources().getString(R.string.dob)+" "+user.getDob());
        registered.setText(getResources().getString(R.string.registered)+" "+user.getRegistered());
        phone.setText(getResources().getString(R.string.phone)+" "+user.getPhone());
        cell.setText(getResources().getString(R.string.cell)+" "+user.getCell());
        name.setText(getResources().getString(R.string.name)+" "+user.getName());
        value.setText(getResources().getString(R.string.value)+" "+user.getValue());

        username.setText(getResources().getString(R.string.username)+" "+user.getUsername());
        password.setText(getResources().getString(R.string.password)+" "+user.getPassword());
        salt.setText(getResources().getString(R.string.salt)+" "+user.getSalt());
        md5.setText(getResources().getString(R.string.md5)+" "+user.getMd5());
        sha1.setText(getResources().getString(R.string.sha1)+" "+user.getSha1());
        sha256.setText(getResources().getString(R.string.sha256)+" "+user.getSha256());

    }

    private void initToolbar() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        mToolbar.setTitleTextColor(getResources().getColor(android.R.color.white));
    }
}
