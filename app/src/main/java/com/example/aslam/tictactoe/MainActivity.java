package com.example.aslam.tictactoe;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    int activePlayer = 0;
    int[] gameState = { 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 };
    int[][] winPos = {{0,1,2} , {3,4,5} , {6,7,8} , {0,3,6} , {1,4,7} , {2,5,8} , {0,4,8} , {2,4,6}};
    boolean gameActive = true;
    int q=0;

    public  void dropIn (View view)
    {

           ImageView counter = (ImageView) view;

           int tappedCounter = Integer.parseInt(counter.getTag().toString());


                 if(gameState[tappedCounter] == 2 && gameActive) {

                     counter.setTranslationY(-1500);

                     gameState[tappedCounter] = activePlayer;

                     if (activePlayer == 0) {
                         counter.setImageResource(R.drawable.yellow);
                         activePlayer = 1;
                     } else {
                         counter.setImageResource(R.drawable.red);
                         activePlayer = 0;
                     }

                     counter.animate().translationYBy(1500).setDuration(400);

       for (int[] winP : winPos) {
                                   if (gameState[winP[0]] == gameState[winP[1]] && gameState[winP[1]] == gameState[winP[2]] && gameState[winP[1]] != 2)
                                   {

                                    gameActive = false;
                                    String message = "";

                                    if (activePlayer == 1)
                                    {
                                    message = "YELLOW";
                                    } else {
                                    message = "RED";
                                    }

                                    Button playAgain = (Button) findViewById(R.id.playAgain);
                                    TextView answerText = (TextView) findViewById(R.id.answerTextView);
                                    answerText.setText(message + " has  won ");
                                    playAgain.setVisibility(View.VISIBLE);
                                    answerText.setVisibility(View.VISIBLE);
                                  }
                                }

                 GridLayout gridLayout2 = (GridLayout) findViewById(R.id.gridLayout);

                 for(int p =0; p<gridLayout2.getChildCount();p++)

                 {
                     ImageView counter1 = (ImageView) gridLayout2.getChildAt(p);
                     q=q+1;

                     if (gameActive == false)
                         q=0;
                 }

                 Log.i(" tie value is " , String.valueOf(q));
                     if(q == 81 && gameActive)
                     {
                         TextView answer1 = (TextView)  findViewById(R.id.answerTextView);
                         answer1.setText(" ITS A TIE ");
                         Button playAgain1 = (Button) findViewById(R.id.playAgain);
                         answer1.setVisibility(View.VISIBLE);
                         playAgain1.setVisibility(View.VISIBLE);
                     }

                 }
    }

    public void playAgain(View v)
    {
        Button playAgain = (Button) findViewById(R.id.playAgain);
        TextView answerText = (TextView) findViewById(R.id.answerTextView);
        playAgain.setVisibility(View.INVISIBLE);
        answerText.setVisibility(View.INVISIBLE);
        GridLayout gridLayouts = (GridLayout) findViewById(R.id.gridLayout);

        for(int i=0; i<gridLayouts.getChildCount(); i++) {
            ImageView counter = (ImageView) gridLayouts.getChildAt(i);
            counter.setImageDrawable(null);
        }

        for(int i =0 ; i<gameState.length; i++)
        {
            gameState[i] = 2;
        }

        activePlayer = 0;
        gameActive = true;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
