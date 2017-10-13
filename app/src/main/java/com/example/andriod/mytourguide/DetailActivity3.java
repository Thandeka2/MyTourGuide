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
public class DetailActivity3 extends AppCompatActivity {

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
        collapsingToolbar.setTitle(getString(R.string.resturant_title));

        int postion = getIntent().getIntExtra(EXTRA_POSITION, 0);
        Resources resources = getResources();
        String[] places = resources.getStringArray(R.array.resturant);
        collapsingToolbar.setTitle(places[postion % places.length]);

        String[] resturantDetails = resources.getStringArray(R.array.resturant_details);
        TextView resturantDetail = (TextView) findViewById(R.id.resturant_detail);
        resturantDetail.setText(resturantDetails[postion % resturantDetails.length]);

        String[] resturantLocations = resources.getStringArray(R.array.resturant_locations);
        TextView resturantLocation =  (TextView) findViewById(R.id.resturant_location);
        resturantLocation.setText(resturantLocations[postion % resturantLocations.length]);

        TypedArray placePictures = resources.obtainTypedArray(R.array.resturant_picture);
        ImageView placePicutre = (ImageView) findViewById(R.id.image);
        placePicutre.setImageDrawable(placePictures.getDrawable(postion % placePictures.length()));

        placePictures.recycle();
    }
}
