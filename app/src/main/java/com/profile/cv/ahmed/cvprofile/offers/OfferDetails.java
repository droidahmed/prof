package com.profile.cv.ahmed.cvprofile.offers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.profile.cv.ahmed.cvprofile.R;
import com.profile.cv.ahmed.cvprofile.adapter.OffersAdapter;
import com.profile.cv.ahmed.cvprofile.api.GetOffer;
import com.profile.cv.ahmed.cvprofile.api.GetOfferById;
import com.profile.cv.ahmed.cvprofile.controller.Utility;
import com.profile.cv.ahmed.cvprofile.interfaces.OnLoadingComplete;
import com.profile.cv.ahmed.cvprofile.model.OfferModel;
import com.profile.cv.ahmed.cvprofile.model.OfferModelMain;
import com.profile.cv.ahmed.cvprofile.model.OfferSingleMain;
import com.squareup.picasso.Picasso;

public class OfferDetails extends AppCompatActivity {
    ImageView imgOfferDetails,imgBack;
    OnLoadingComplete onLoadingComplete;
    OfferModel offerModel;
    int id;
    TextView tvTitle,tvOfferDetailsTitle,tvOfferDetailsStart,tvOfferDetailsEnd;
    Button btnCallNow,btnWebSite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offer_details);

        id = getIntent().getExtras().getInt("id",1);
        Log.d("ttt33",""+id);

        declare();
        addData();
    }
    private void declare(){
        imgOfferDetails = (ImageView) findViewById(R.id.imgOfferDetails);
        imgBack = (ImageView) findViewById(R.id.imgBack);
        imgBack.setOnClickListener(view -> finish());
//        int image = getIntent().getExtras().getInt("image");
//        imgOfferDetails.setImageResource(image);
        tvTitle = (TextView) findViewById(R.id.tvTitle);
        tvOfferDetailsTitle = (TextView) findViewById(R.id.tvOfferDetailsTitle);
        tvOfferDetailsStart = (TextView) findViewById(R.id.tvOfferDetailsStart);
        tvOfferDetailsEnd = (TextView) findViewById(R.id.tvOfferDetailsEnd);
        btnCallNow = (Button) findViewById(R.id.btnCallNow);
        btnWebSite = (Button) findViewById(R.id.btnWebSite);
        btnCallNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!offerModel.getPhone().equals("")){
                    Utility utility = new Utility();
                    utility.confirmDialog(OfferDetails.this,offerModel.getPhone());
                }
            }
        });

        btnWebSite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    private void addData(){


        onLoadingComplete = new OnLoadingComplete() {
            @Override
            public void onSuccess(Object object) {
                OfferSingleMain offerModelMain = (OfferSingleMain) object;
                offerModel = offerModelMain.getData();
                Log.d("tttpppp",offerModel.getCompanyName());
                tvTitle.setText(offerModel.getCompanyName());
                tvOfferDetailsTitle.setText(offerModel.getName());
                tvOfferDetailsStart.setText(offerModel.getCreatedDate());
                tvOfferDetailsEnd.setText(offerModel.getModifiedDate());
                Picasso.with(OfferDetails.this).load("http://cv-campany.com/API/ar/general/thumb?url="
                        + offerModel.getPicture() + "&width=600&height=380")
                        .into(imgOfferDetails);


            }

            @Override
            public void onFailure() {

            }
        };
        GetOfferById task= new GetOfferById(OfferDetails.this, onLoadingComplete,id);
        task.execute();
    }

}
