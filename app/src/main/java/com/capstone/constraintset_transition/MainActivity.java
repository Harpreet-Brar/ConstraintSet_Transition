package com.capstone.constraintset_transition;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import android.os.Bundle;
import android.transition.ChangeBounds;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.view.View;
import android.view.animation.AnticipateOvershootInterpolator;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    private boolean show = false;
    private ConstraintLayout constraint;
    private ConstraintSet constraintSet = new ConstraintSet();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        constraint = findViewById(R.id.constraint);
        Button DetailButton = findViewById(R.id.button);
        Button RemoveButton = findViewById(R.id.button2);

        DetailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                show=!show;
                constraintSet.clone(MainActivity.this, R.layout.activity_main2);
                Transition transition = new ChangeBounds();
                transition.setInterpolator(new AnticipateOvershootInterpolator(1.0f));
                transition.setDuration(1000);

                TransitionManager.beginDelayedTransition(constraint, transition);
                constraintSet.applyTo(constraint);
            }
        });

        RemoveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                show=!show;
                constraintSet.clone(MainActivity.this, R.layout.activity_main);
                Transition transition = new ChangeBounds();
                transition.setInterpolator(new AnticipateOvershootInterpolator(1.0f));
                transition.setDuration(1000);

                TransitionManager.beginDelayedTransition(constraint, transition);
                constraintSet.applyTo(constraint);
            }
        });

    }
}
