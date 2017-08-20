package com.srjlove.animation;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Slide;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.Gravity;
import android.view.View;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.TextView;
import android.widget.Toast;

public class TransitionActivity extends AppCompatActivity {

    Constants.AnimType type;
    String toolbarTitle = "", animName;
    TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transition);


        type = (Constants.AnimType) getIntent().getSerializableExtra(Constants.KEY_TYPE);
        toolbarTitle = getIntent().getExtras().getString(Constants.KEY_TITLE);
        animName = getIntent().getExtras().getString(Constants.KEY_NAME);

        bindControl();
        setupToolbar();

        setupAnimation();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setAllowReturnTransitionOverlap(false);
        }
    }

    private void setupAnimation() {
        switch (type) {
            case explodeJava:
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    Explode e = new Explode();
                    e.setDuration(1000);
                    e.setInterpolator(new OvershootInterpolator());
                    getWindow().setEnterTransition(e);
                    Toast.makeText(this, "happening", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "nothing", Toast.LENGTH_SHORT).show();
                }
                break;

            case explodeXml:
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    Transition enterTransition = TransitionInflater.from(this).inflateTransition(R.transition.explode);
                    enterTransition.setDuration(1000);
                    getWindow().setEnterTransition(enterTransition);
                    Toast.makeText(this, "happening", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "nothing", Toast.LENGTH_SHORT).show();
                }
                break;
            case slideJava:

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    Slide enterTransaction = new Slide(Gravity.BOTTOM);
                    enterTransaction.setDuration(1000);
                    enterTransaction.setInterpolator(new AnticipateOvershootInterpolator());
                    getWindow().setEnterTransition(enterTransaction);
                }
                break;

            case slideXml:
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    Transition enterTransition = TransitionInflater.from(this).inflateTransition(R.transition.slide);
                    enterTransition.setStartDelay(500);
                    getWindow().setEnterTransition(enterTransition);
                    Toast.makeText(this, "happening", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "nothing", Toast.LENGTH_SHORT).show();
                }
                break;

            case fadeJava:
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    Fade enterTransaction = new Fade(Fade.OUT);
                    enterTransaction.setDuration(1000);
                    getWindow().setEnterTransition(enterTransaction);
                }
                break;

            case fadeXml:
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    Transition enterTransition = TransitionInflater.from(this).inflateTransition(R.transition.fade);
                    getWindow().setEnterTransition(enterTransition);
                    Toast.makeText(this, "happening", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "nothing", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) finishAfterTransition();
        return true;
    }

    private void setupToolbar() {
        Toolbar mToolbar = (Toolbar) findViewById(R.id.tToolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(toolbarTitle);

    }

    private void bindControl() {
        findViewById(R.id.exit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) finishAfterTransition();
                else finish();
            }
        });
        mTextView = (TextView) findViewById(R.id.animName);
        mTextView.setText(animName);
    }
}
