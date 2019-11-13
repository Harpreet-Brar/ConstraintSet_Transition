package com.capstone.constraintset_transition;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import android.content.Intent;
import android.os.Bundle;
import android.transition.ChangeBounds;
import android.transition.ChangeTransform;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AnticipateOvershootInterpolator;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    private ConstraintLayout constraint;
    private ConstraintSet constraintSet = new ConstraintSet();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button DetailButton = findViewById(R.id.button);
        Button RemoveButton = findViewById(R.id.button2);
        constraint = findViewById(R.id.constraint);

        DetailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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
                constraintSet.clone(MainActivity.this, R.layout.activity_main);
                Transition transition = new ChangeBounds();
                transition.setInterpolator(new AnticipateOvershootInterpolator(1.0f));
                transition.setDuration(1500);

                TransitionManager.beginDelayedTransition(constraint, transition);
                constraintSet.applyTo(constraint);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.next, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();

        if(itemId == R.id.next)
        {
            Intent i = new Intent(getApplicationContext(), Menu_Transition.class);
            startActivity(i);
        }

        return super.onOptionsItemSelected(item);
    }

}
