package com.profile.cv.ahmed.cvprofile.controller;

import com.profile.cv.ahmed.cvprofile.R;
import com.profile.cv.ahmed.cvprofile.model.MenuModel;

import java.util.ArrayList;

/**
 * Created by ahmed on 2/26/2017.
 */
public class ListData {

    public ArrayList<MenuModel> slideData(){
        ArrayList<MenuModel> arrayList = new ArrayList<>();
        arrayList.add(new MenuModel("Social",0));
        arrayList.add(new MenuModel("Facebook", R.drawable.facebook));
        arrayList.add(new MenuModel("Twitter",R.drawable.twitter));
        arrayList.add(new MenuModel("Youtube",0));
        arrayList.add(new MenuModel("Instagram",0));
        arrayList.add(new MenuModel("Customer Service",0));

        return arrayList;
    }
}
