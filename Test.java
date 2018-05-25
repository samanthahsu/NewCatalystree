package com.example.newcatalystree;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import android.widget.LinearLayout;

// todo: transfer to fragment
public class Test extends AppCompatActivity {

//    declare int for board site
    final static int maxN = 25;
    Context context;
//    declare for imageView (Cells) array
    private ImageView[][] ivCell = new ImageView[maxN][maxN];
    private Drawable[] drawCell = new Drawable[4]; // 0 is empty, 1 is player, 2 is bot, 3 is bg

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        context = this;
        loadResources();
        designBoardGame();
    }

    private void loadResources() {
        drawCell[3] = context.getResources().getDrawable(R.drawable.cell_bg); // background
        drawCell[0] = null;
        drawCell[1] = context.getResources().getDrawable(R.drawable.sample_tile);
        drawCell[2] = context.getResources().getDrawable(R.drawable.sample_tile_1);
//        copy 2 image for 2 drawable player and bot
//        edit it
    }

    @SuppressLint("NewApi")
    private void designBoardGame() {
//        create layout params to optimize
//        create a horizontal linear layout for a row which contains maxN image view
//        need to find outsize of cell first
        int sizeofCell = Math.round(ScreenWidth() / maxN);

        LinearLayout.LayoutParams lpRow = new LinearLayout.LayoutParams(sizeofCell*maxN, sizeofCell);
        LinearLayout.LayoutParams lpCell = new LinearLayout.LayoutParams(sizeofCell, sizeofCell);

        LinearLayout linBoardGame = findViewById(R.id.linBoardGame);

//        create cells
        for(int i = 0; i < maxN; i++) {
            LinearLayout linRow = new LinearLayout(context);
//            make a row
            for (int j = 0; j < maxN; j++) {
//                make a cell
//                make a cell
//                need to get background default for cell
//                cell has 3 status, empty(default, player, bot)
                ivCell[i][j].setBackground(drawCell[3]);
                linRow.addView(ivCell[i][j], lpCell); // todo: generates null pointer exception here
            }
            linBoardGame.addView(linRow, lpRow);
        }
//        ImageView ivX;
//        RelativeLayout rlMapElements = new RelativeLayout();
//        rlMapElements.inflate(ivX);
//
//        onclick of editing button
//        put add button to the top, right, bottom, left, of ivX
//        check if the block is at the extremities of the earth todo: howwwww????
//        put add buttons to all the areas at the extremeties not yet occupied by a block

//        if add button onclick listener, it adds a block at that spot


//        Resources from the R.xx.xx portion of your app, are given an Integer constant as an identifier.
// If you wanted to then make an array of R.drawable.image you could just make it an int[]
//        eg: int[]   mArray = new int[10];
                //    mArray[0] = R.drawable.image1;
                //    mArray[1] = R.drawable.image2;
    }

    private float ScreenWidth() {
        Resources resources = context.getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        return displayMetrics.widthPixels;
    }
}
