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

public class Menu_Transition extends AppCompatActivity {


    private ConstraintLayout constraint;
    private ConstraintSet constraintSet = new ConstraintSet();
    private Boolean show = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu__transition);

        final Button Menu = findViewById(R.id.button);
        constraint = findViewById(R.id.constraint);

        Menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                show = !show;

                if(show) {
                    constraintSet.clone(Menu_Transition.this, R.layout.activity_menu__transition2);
                    Menu.setText("X");
                }
                else{
                    constraintSet.clone(Menu_Transition.this, R.layout.activity_menu__transition);
                    Menu.setText("MENU");
                }
                Transition transition = new ChangeBounds();
                transition.setInterpolator(new AnticipateOvershootInterpolator(.5f));
                transition.setDuration(1000);
                TransitionManager.beginDelayedTransition(constraint, transition);
                constraintSet.applyTo(constraint);
            }
        });
    }
}
