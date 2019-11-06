package com.lcw.meet;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.bumptech.glide.Glide;
import com.kakao.usermgmt.UserManagement;
import com.kakao.usermgmt.callback.LogoutResponseCallback;

import de.hdodenhof.circleimageview.CircleImageView;

public class Page2FragPhoto extends Fragment{

    private Context mContext;

    CircleImageView circleImageView;

    Button button;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_photo,container,false);


        String db_imgPath01 =Page1FragHome.fragToFrag.getDb_imgPath01();
        //Toast.makeText(mContext, ""+db_imgPath01, Toast.LENGTH_SHORT).show();

        circleImageView= view.findViewById(R.id.civ_myimg);
        Glide.with(this).load(db_imgPath01).into(circleImageView);

        button=view.findViewById(R.id.btn_logout);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserManagement.requestLogout(new LogoutResponseCallback() {
                    @Override
                    public void onCompleteLogout() {
                        redirectLoginActivity();
                    }
                });
            }
        });


        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mContext= context;


    }

    protected void redirectLoginActivity() {
        final Intent intent = new Intent(mContext, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(intent);
        //finish();
        getActivity().finish();
    }
}
