package kamin.com.provectus2017.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import kamin.com.provectus2017.R;
import kamin.com.provectus2017.activitys.MainActivity;
import kamin.com.provectus2017.model.User;



public class UserAdapter extends RecyclerView.Adapter<UserAdapter.MyViewHolder> {
    private Context mContext;

    MainActivity mainActivity;

    public UserAdapter(Context mContext) {
        this.mContext = mContext;
        mainActivity = (MainActivity) mContext;
        if(DataHolder.userList==null)
            DataHolder.userList=new ArrayList<>();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_card_item, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Log.d("TAG","nBindViewHolder ");
        User user = DataHolder.userList.get(position);
        holder.login.setText(user.getLogin().getLogin());
        holder.name.setText(user.getName().getFirstLast());
        Glide.with(mContext).load(user.getThumbnail()).into(holder.thumbnail);
    }

    @Override
    public int getItemCount() {
        return DataHolder.userList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        public TextView login, name;
        public ImageView thumbnail;
        public MyViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            login = (TextView) itemView.findViewById(R.id.login);
            name = (TextView) itemView.findViewById(R.id.name);
            thumbnail = (ImageView) itemView.findViewById(R.id.thumbnail);
        }

        @Override
        public void onClick(View view) {
            mainActivity.startDetailed(getLayoutPosition());
        }
    }
}
