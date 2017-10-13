package com.example.andriod.mytourguide;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by eKasiLab Alex CDTB on 2017/10/13.
 */

public class DetailActivity2 extends AppCompatActivity{
    public static final String EXTRA_POSITION = "position";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail3);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // Set Collapsing Toolbar layout to the screen
        CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        // Set title of Detail page
        collapsingToolbar.setTitle(getString(R.string.events_title));

        int postion = getIntent().getIntExtra(EXTRA_POSITION, 0);
        Resources resources = getResources();
        String[] places = resources.getStringArray(R.array.events);
        collapsingToolbar.setTitle(places[postion % places.length]);

        String[] eventsDetails = resources.getStringArray(R.array.resturant_details);
        TextView eventsDetail = (TextView) findViewById(R.id.resturant_detail);
        eventsDetail.setText(eventsDetails[postion % eventsDetails.length]);

        String[] eventsLocations = resources.getStringArray(R.array.resturant_locations);
        TextView eventsLocation =  (TextView) findViewById(R.id.events_location);
        eventsLocation.setText(eventsLocations[postion % eventsLocations.length]);

        TypedArray placePictures = resources.obtainTypedArray(R.array.resturant_picture);
        ImageView placePicutre = (ImageView) findViewById(R.id.image);
        placePicutre.setImageDrawable(placePictures.getDrawable(postion % placePictures.length()));

        placePictures.recycle();
    }
}


