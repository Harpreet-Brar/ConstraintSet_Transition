# ConstraintSet_Transition
Constraintset Transition Animation in just 6 lines

There are some rules to follow in order to make this transition work.

First we need to make sure that minSdkVersion should be not less then 19.

Second, Every element in XML file needs to have id defined. otherwise it will not work.

Now, You have to create two different XML files with same elements but different Constraints according to your requirment.

All you have to do is write these six lined code on click or as you want to use.

                ConstraintLayout constraint = findViewById(R.id.constraint);
                constraintSet.clone(MainActivity.this, R.layout.activity_main2);
                Transition transition = new ChangeBounds();
                transition.setInterpolator(new AnticipateOvershootInterpolator(1.0f));
                transition.setDuration(1000);

                TransitionManager.beginDelayedTransition(constraint, transition);
                constraintSet.applyTo(constraint);
