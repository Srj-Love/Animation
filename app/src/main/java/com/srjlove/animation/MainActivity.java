package com.srjlove.animation;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.transition.Slide;
import android.util.Pair;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button explodeJava, explodeXml, slideJava, slideXml, fadeJava, fadeXml;
    Toolbar mToolbar;
    TextView tShared;
    ImageView img;
    LinearLayout shareLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        shareLayout = (LinearLayout) findViewById(R.id.sharedLayout);
        tShared = (TextView) findViewById(R.id.txtsharedElemet);
        img = (ImageView) findViewById(R.id.sharedImageView);


        explodeJava = (Button) findViewById(R.id.explodeJava);
        explodeXml = (Button) findViewById(R.id.explodeXml);
        slideJava = (Button) findViewById(R.id.slideJava);
        slideXml = (Button) findViewById(R.id.slideXml);
        fadeJava = (Button) findViewById(R.id.fadeJava);
        fadeXml = (Button) findViewById(R.id.fadeXml);

        explodeXml.setOnClickListener(this);
        explodeJava.setOnClickListener(this);
        slideJava.setOnClickListener(this);
        slideXml.setOnClickListener(this);
        fadeXml.setOnClickListener(this);
        fadeJava.setOnClickListener(this);

        setUpMainActivityAnimation();
        txtControl();

    }

    private void setUpMainActivityAnimation() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Slide enterTransaction = new Slide(Gravity.LEFT);
            // when mainActivity.java renter to the screens
            getWindow().setReenterTransition(enterTransaction);
            // Exiting mainactivity animation transaction
            getWindow().setExitTransition(enterTransaction);
            // when TransactionActivity.class returns to mainActivity
            getWindow().setAllowReturnTransitionOverlap(false);
        }
    }

    private void txtControl() {

        TextView rwb = (TextView) findViewById(R.id.rwb);
        TextView rwtb = (TextView) findViewById(R.id.rwtb);
        TextView crwb = (TextView) findViewById(R.id.crwb);
        TextView crwtb = (TextView) findViewById(R.id.crwtb);


        shareLayout.setOnClickListener(this);
        rwb.setOnClickListener(this);
        rwtb.setOnClickListener(this);
        crwb.setOnClickListener(this);
        crwtb.setOnClickListener(this);

    }


    public void explodeJava() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mToolbar.setElevation(13f);
            ActivityOptions mOptions = ActivityOptions.makeSceneTransitionAnimation(this);
            Intent mIntent = new Intent(this, TransitionActivity.class);
            mIntent.putExtra(Constants.KEY_TYPE, Constants.AnimType.explodeJava);
            mIntent.putExtra(Constants.KEY_TITLE, "Explode Animation");
            mIntent.putExtra(Constants.KEY_NAME, "Explode By Code");
            startActivity(mIntent, mOptions.toBundle());
        }
    }

    private void explodeXml() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mToolbar.setElevation(13f);
            ActivityOptions mOptions = ActivityOptions.makeSceneTransitionAnimation(this);
            Intent mIntent = new Intent(this, TransitionActivity.class);
            mIntent.putExtra(Constants.KEY_TYPE, Constants.AnimType.explodeXml);
            mIntent.putExtra(Constants.KEY_TITLE, "Explode Animation");
            mIntent.putExtra(Constants.KEY_NAME, "Explode By XML");
            startActivity(mIntent, mOptions.toBundle());
        }
    }


    public void slideJava() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mToolbar.setElevation(13f);
            ActivityOptions mOptions = ActivityOptions.makeSceneTransitionAnimation(this);
            Intent mIntent = new Intent(this, TransitionActivity.class);
            mIntent.putExtra(Constants.KEY_TYPE, Constants.AnimType.slideJava);
            mIntent.putExtra(Constants.KEY_TITLE, "Slide Animation");
            mIntent.putExtra(Constants.KEY_NAME, "Slide By Code");
            startActivity(mIntent, mOptions.toBundle());
        }
    }

    private void slideXml() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mToolbar.setElevation(13f);
            ActivityOptions mOptions = ActivityOptions.makeSceneTransitionAnimation(this);
            Intent mIntent = new Intent(this, TransitionActivity.class);
            mIntent.putExtra(Constants.KEY_TYPE, Constants.AnimType.slideXml);
            mIntent.putExtra(Constants.KEY_TITLE, "Slide Animation");
            mIntent.putExtra(Constants.KEY_NAME, "Slide By XML");
            startActivity(mIntent, mOptions.toBundle());
        }
    }

    private void fadeJava() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mToolbar.setElevation(5f);
            ActivityOptions mOptions = ActivityOptions.makeSceneTransitionAnimation(this);
            Intent mIntent = new Intent(this, TransitionActivity.class);
            mIntent.putExtra(Constants.KEY_TYPE, Constants.AnimType.fadeJava);
            mIntent.putExtra(Constants.KEY_TITLE, "Fade Animation");
            mIntent.putExtra(Constants.KEY_NAME, "Fade By Code");
            startActivity(mIntent, mOptions.toBundle());
        }
    }

    private void fadeXml() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mToolbar.setElevation(13f);
            ActivityOptions mOptions = ActivityOptions.makeSceneTransitionAnimation(this);
            Intent mIntent = new Intent(this, TransitionActivity.class);
            mIntent.putExtra(Constants.KEY_TYPE, Constants.AnimType.fadeXml);
            mIntent.putExtra(Constants.KEY_TITLE, "Fade Animation");
            mIntent.putExtra(Constants.KEY_NAME, "Fade By XML");
            startActivity(mIntent, mOptions.toBundle());
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.explodeJava:
                explodeJava();
                break;
            case R.id.explodeXml:
                explodeXml();
                break;
            case R.id.slideJava:
                slideJava();
                break;
            case R.id.slideXml:
                slideXml();
                break;
            case R.id.fadeJava:
                fadeJava();
                break;
            case R.id.fadeXml:
                fadeXml();
                break;
            case R.id.sharedLayout:
                Pair[] pairs = new Pair[2];
                pairs[0] = new Pair<View, String>(img, "bear");
                pairs[1] = new Pair<View, String>(tShared, "sharedElements");

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    ActivityOptions activityOptions = ActivityOptions.makeSceneTransitionAnimation(this,pairs);
                    startActivity((new Intent(this, SharedElements.class)), activityOptions.toBundle());
                }
                break;
        }
    }


}
