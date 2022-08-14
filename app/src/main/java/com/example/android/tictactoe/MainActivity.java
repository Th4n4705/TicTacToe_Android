package com.example.android.tictactoe;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public  int activePlayer=0;
    public int[] tag={2,2,2,2,2,2,2,2,2};
    public  int[][] winningWays={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    int redPlayer=0,yellowPlayer=0;

    public  int verfiyingTheWinner()
    {
        int theWinnerIs=2;
        for(int[] winningWay : winningWays)
        {
            if (tag[winningWay[0]]==tag[winningWay[1]] && tag[winningWay[1]]==tag[winningWay[2]]
                    && tag[winningWay[0]]==tag[winningWay[2]] && tag[winningWay[0]]!=2)
            {
                theWinnerIs=tag[winningWay[0]];
            }
        }
        return theWinnerIs;
    }

    public void whatColor(ImageView view){
        if(activePlayer==0){
            activePlayer=1;
            view.setImageResource(R.drawable.red);
        }else{
            activePlayer=0;
            view.setImageResource(R.drawable.yellow);
        }
    }


    public  void  again(View view){
        TextView textView7=(TextView) findViewById(R.id.textView47);
        Button againButton=(Button) findViewById(R.id.againButton);
        GridLayout myGrid=(GridLayout)findViewById(R.id.myGridView);
        textView7.setVisibility(View.INVISIBLE);
        againButton.setVisibility(View.INVISIBLE);
        for(int i = 0; i <tag.length;i++)
            tag[i]=2;
        for (int i = 0; i<myGrid.getChildCount();i++)
            ((ImageView) myGrid.getChildAt(i)).setImageResource(0);
            }

    public  void click(View view){
        int getTag,whoIsTheWinner;
        ImageView image=(ImageView) view;
        TextView textView7=(TextView) findViewById(R.id.textView47);
        getTag=Integer.parseInt(image.getTag().toString());
        Button againButton=(Button) findViewById(R.id.againButton);

        TextView redPlayerText=(TextView) findViewById(R.id.Red);
        TextView redPlayerScore=(TextView) findViewById(R.id.RedScore);
        TextView yellowPlayerText=(TextView) findViewById(R.id.Yellow);
        TextView yellowPlayerScore=(TextView) findViewById(R.id.YellowScore);

        if(tag[getTag]==2){
            tag[getTag]=activePlayer;
            image.setTranslationY(-1000f);
            whatColor(image);
            image.animate().translationYBy(1000f).setDuration(350);
            whoIsTheWinner=verfiyingTheWinner();

            if( whoIsTheWinner!=2){
                textView7.setVisibility(View.VISIBLE);
                againButton.setVisibility(View.VISIBLE);
                if(whoIsTheWinner==0)
                {
                    redPlayer++;
                    redPlayerScore.setText(Integer.toString(redPlayer));
                    textView7.setTextColor(Color.RED);
                }
                else
                    {
                        yellowPlayer++;
                        yellowPlayerScore.setText(Integer.toString(yellowPlayer));
                        textView7.setTextColor(Color.YELLOW);
                        }
            }
        }

        if(activePlayer==0){
            redPlayerText.setTextColor(Color.RED);
            redPlayerScore.setTextColor(Color.RED);
            yellowPlayerText.setTextColor(Color.BLACK);
            yellowPlayerScore.setTextColor(Color.BLACK);
        }else{
            yellowPlayerText.setTextColor(Color.YELLOW);
            yellowPlayerScore.setTextColor(Color.YELLOW);
            redPlayerText.setTextColor(Color.BLACK);
            redPlayerScore.setTextColor(Color.BLACK);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView redPlayerText=(TextView) findViewById(R.id.Red);
        TextView redPlayerScore=(TextView) findViewById(R.id.RedScore);
        redPlayerText.setTextColor(Color.RED);
        redPlayerScore.setTextColor(Color.RED);
    }
}
