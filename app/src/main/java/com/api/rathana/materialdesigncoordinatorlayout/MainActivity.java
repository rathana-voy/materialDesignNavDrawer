package com.api.rathana.materialdesigncoordinatorlayout;

import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.SwipeDismissBehavior;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private CardView mCardView;
    private FloatingActionButton btnFloatingSearch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCardView= (CardView) findViewById(R.id.card_view);
        btnFloatingSearch= (FloatingActionButton) findViewById(R.id.btn_floating_search);
        final SwipeDismissBehavior<CardView> swipe=new SwipeDismissBehavior<>();
        swipe.setSwipeDirection(SwipeDismissBehavior.SWIPE_DIRECTION_START_TO_END);
        swipe.setListener(new SwipeDismissBehavior.OnDismissListener() {
            @Override
            public void onDismiss(View view) {
                Toast.makeText(MainActivity.this, "Card is dismissed", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onDragStateChanged(int state) {

            }
        });
        CoordinatorLayout.LayoutParams coordinatorPara= (CoordinatorLayout.LayoutParams) mCardView.getLayoutParams();
        coordinatorPara.setBehavior(swipe);


        //floating button handling
        btnFloatingSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view,"Search anythings here",Snackbar.LENGTH_LONG).show();
            }
        });
    }
}
