package com.profile.cv.ahmed.cvprofile.main;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.profile.cv.ahmed.cvprofile.R;
import com.profile.cv.ahmed.cvprofile.adapter.ListMenuAdapter;
import com.profile.cv.ahmed.cvprofile.department.Department;
import com.profile.cv.ahmed.cvprofile.home.HomeFragment;
import com.profile.cv.ahmed.cvprofile.home.WebFragment;
import com.profile.cv.ahmed.cvprofile.interfaces.OnMenuClick;
import com.profile.cv.ahmed.cvprofile.model.MenuModel;
import com.profile.cv.ahmed.cvprofile.offers.Offers;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements OnMenuClick {

    LinearLayout  linHome,linDepartment,linOffers;
    TextView tvHome,tvDepartment,tvOffers;
    ImageView imgOffers,imgDepartment,imgHome;
    int clicked;
    RecyclerView reList;
    ListMenuAdapter listMenuAdapter;
    ArrayList<MenuModel> menuModelArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      getSupportFragmentManager().beginTransaction().add(R.id.main,new HomeFragment()).addToBackStack("").commit();
        declare();
        action();
    }
    private void declare(){
        reList = (RecyclerView) findViewById(R.id.reList);
        reList.setLayoutManager(new LinearLayoutManager(this));
        linHome = (LinearLayout) findViewById(R.id.linHome);
        linDepartment = (LinearLayout) findViewById(R.id.linDepartment);
        linOffers = (LinearLayout) findViewById(R.id.linOffers);
        tvHome = (TextView) findViewById(R.id.tvHome);
        tvDepartment = (TextView) findViewById(R.id.tvDepartment);
        tvOffers = (TextView) findViewById(R.id.tvOffers);
        imgOffers = (ImageView) findViewById(R.id.imgOffers);
        imgDepartment = (ImageView) findViewById(R.id.imgDepartment);
        imgHome = (ImageView) findViewById(R.id.imgHome);
        imgHome.setImageResource(R.drawable.homeon);
        menuModelArrayList = new ArrayList<>();
        change();
    }

    private void action(){
        linHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().add(R.id.main,new HomeFragment()).addToBackStack("").commit();
                clicked = 1;
                change();
            }
        });

        linDepartment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().add(R.id.main,new Department()).addToBackStack("").commit();
                clicked = 2;
                change();

            }
        });

        linOffers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().add(R.id.main,new Offers()).addToBackStack("").commit();
                clicked = 3;
                change();
            }
        });
    }
     private void change(){

         if(clicked == 1){

             tvHome.setTextColor(getResources().getColor(R.color.text_blue));
             tvDepartment.setTextColor(getResources().getColor(R.color.text_gray));
             tvOffers.setTextColor(getResources().getColor(R.color.text_gray));
             imgHome.setImageResource(R.drawable.homeon);
             imgDepartment.setImageResource(R.drawable.departments);
             imgOffers.setImageResource(R.drawable.offers);
         }else  if(clicked == 2){

             tvDepartment.setTextColor(getResources().getColor(R.color.text_blue));
             tvOffers.setTextColor(getResources().getColor(R.color.text_gray));
             tvHome.setTextColor(getResources().getColor(R.color.text_gray));
             imgHome.setImageResource(R.drawable.home);
             imgDepartment.setImageResource(R.drawable.departmentson);
             imgOffers.setImageResource(R.drawable.offers);
         }else  if(clicked == 3){

             tvOffers.setTextColor(getResources().getColor(R.color.text_blue));
             tvHome.setTextColor(getResources().getColor(R.color.text_gray));
             tvDepartment.setTextColor(getResources().getColor(R.color.text_gray));
             imgHome.setImageResource(R.drawable.home);
             imgDepartment.setImageResource(R.drawable.departments);
             imgOffers.setImageResource(R.drawable.offerson);
         }
     }

    @Override
    public void onMenu(int pos) {
        if(pos==5){

        }else
        if(pos!=0) {
            Fragment fragmentProduct = new WebFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable("link", menuModelArrayList.get(pos).getTitle());

            fragmentProduct.setArguments(bundle);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.main, fragmentProduct).addToBackStack("")
                    .commitAllowingStateLoss();

        }
    }
}
