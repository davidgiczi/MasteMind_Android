package com.david.giczi.mastermind;

import android.content.pm.ActivityInfo;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Handler;
import android.view.View;
import androidx.core.view.MenuCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.david.giczi.mastermind.databinding.ActivityMainBinding;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;
import java.util.Arrays;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;
    private Menu optionsMenu;
    private static List<Drawable> COLORS;
    private static int COLOR_NUMBER = 6;
    private static boolean IS_DIFFERENT_COLORS = true;
    private MasterMind logic;

    private Drawable getDrawableForNextColor(Drawable actualDrawable){
        int actualDrawableIndex = COLORS.indexOf(actualDrawable);
        return actualDrawableIndex == COLOR_NUMBER - 1 ? COLORS.get(0) : COLORS.get(actualDrawableIndex + 1);
    }

    private int getDrawableColorIndex(Drawable actualDrawable){
        return COLORS.indexOf(actualDrawable);
    }
    private void init(){
        logic = new MasterMind(COLOR_NUMBER, IS_DIFFERENT_COLORS);
        runIntro();
        findViewById(R.id.circle_1_1).setForeground(getDrawable(R.drawable.background_circle));
        findViewById(R.id.circle_1_2).setForeground(getDrawable(R.drawable.background_circle));
        findViewById(R.id.circle_1_3).setForeground(getDrawable(R.drawable.background_circle));
        findViewById(R.id.circle_1_4).setForeground(getDrawable(R.drawable.background_circle));
        Button btn1 = (Button) findViewById(R.id.row_1_1);
        Button btn2 = (Button) findViewById(R.id.row_1_2);
        Button btn3 = (Button) findViewById(R.id.row_1_3);
        Button btn4 = (Button) findViewById(R.id.row_1_4);
        btn1.setForeground(getDrawable(R.drawable.default_btn_style));
        btn2.setForeground(getDrawable(R.drawable.default_btn_style));
        btn3.setForeground(getDrawable(R.drawable.default_btn_style));
        btn4.setForeground(getDrawable(R.drawable.default_btn_style));

        findViewById(R.id.circle_2_1).setForeground(getDrawable(R.drawable.background_circle));
        findViewById(R.id.circle_2_2).setForeground(getDrawable(R.drawable.background_circle));
        findViewById(R.id.circle_2_3).setForeground(getDrawable(R.drawable.background_circle));
        findViewById(R.id.circle_2_4).setForeground(getDrawable(R.drawable.background_circle));
        Button btn5 = (Button) findViewById(R.id.row_2_1);
        Button btn6 = (Button) findViewById(R.id.row_2_2);
        Button btn7 = (Button) findViewById(R.id.row_2_3);
        Button btn8 = (Button) findViewById(R.id.row_2_4);
        btn5.setForeground(getDrawable(R.drawable.default_btn_style));
        btn6.setForeground(getDrawable(R.drawable.default_btn_style));
        btn7.setForeground(getDrawable(R.drawable.default_btn_style));
        btn8.setForeground(getDrawable(R.drawable.default_btn_style));

        findViewById(R.id.circle_3_1).setForeground(getDrawable(R.drawable.background_circle));
        findViewById(R.id.circle_3_2).setForeground(getDrawable(R.drawable.background_circle));
        findViewById(R.id.circle_3_3).setForeground(getDrawable(R.drawable.background_circle));
        findViewById(R.id.circle_3_4).setForeground(getDrawable(R.drawable.background_circle));
        Button btn9 = (Button) findViewById(R.id.row_3_1);
        Button btn10 = (Button) findViewById(R.id.row_3_2);
        Button btn11 = (Button) findViewById(R.id.row_3_3);
        Button btn12 = (Button) findViewById(R.id.row_3_4);
        btn9.setForeground(getDrawable(R.drawable.default_btn_style));
        btn10.setForeground(getDrawable(R.drawable.default_btn_style));
        btn11.setForeground(getDrawable(R.drawable.default_btn_style));
        btn12.setForeground(getDrawable(R.drawable.default_btn_style));

        findViewById(R.id.circle_4_1).setForeground(getDrawable(R.drawable.background_circle));
        findViewById(R.id.circle_4_2).setForeground(getDrawable(R.drawable.background_circle));
        findViewById(R.id.circle_4_3).setForeground(getDrawable(R.drawable.background_circle));
        findViewById(R.id.circle_4_4).setForeground(getDrawable(R.drawable.background_circle));
        Button btn13 = (Button) findViewById(R.id.row_4_1);
        Button btn14 = (Button) findViewById(R.id.row_4_2);
        Button btn15 = (Button) findViewById(R.id.row_4_3);
        Button btn16 = (Button) findViewById(R.id.row_4_4);
        btn13.setForeground(getDrawable(R.drawable.default_btn_style));
        btn14.setForeground(getDrawable(R.drawable.default_btn_style));
        btn15.setForeground(getDrawable(R.drawable.default_btn_style));
        btn16.setForeground(getDrawable(R.drawable.default_btn_style));

        findViewById(R.id.circle_5_1).setForeground(getDrawable(R.drawable.background_circle));
        findViewById(R.id.circle_5_2).setForeground(getDrawable(R.drawable.background_circle));
        findViewById(R.id.circle_5_3).setForeground(getDrawable(R.drawable.background_circle));
        findViewById(R.id.circle_5_4).setForeground(getDrawable(R.drawable.background_circle));
        Button btn17 = (Button) findViewById(R.id.row_5_1);
        Button btn18 = (Button) findViewById(R.id.row_5_2);
        Button btn19 = (Button) findViewById(R.id.row_5_3);
        Button btn20 = (Button) findViewById(R.id.row_5_4);
        btn17.setForeground(getDrawable(R.drawable.default_btn_style));
        btn18.setForeground(getDrawable(R.drawable.default_btn_style));
        btn19.setForeground(getDrawable(R.drawable.default_btn_style));
        btn20.setForeground(getDrawable(R.drawable.default_btn_style));

        findViewById(R.id.circle_6_1).setForeground(getDrawable(R.drawable.background_circle));
        findViewById(R.id.circle_6_2).setForeground(getDrawable(R.drawable.background_circle));
        findViewById(R.id.circle_6_3).setForeground(getDrawable(R.drawable.background_circle));
        findViewById(R.id.circle_6_4).setForeground(getDrawable(R.drawable.background_circle));
        Button btn21 = (Button) findViewById(R.id.row_6_1);
        Button btn22 = (Button) findViewById(R.id.row_6_2);
        Button btn23 = (Button) findViewById(R.id.row_6_3);
        Button btn24 = (Button) findViewById(R.id.row_6_4);
        btn21.setForeground(getDrawable(R.drawable.default_btn_style));
        btn22.setForeground(getDrawable(R.drawable.default_btn_style));
        btn23.setForeground(getDrawable(R.drawable.default_btn_style));
        btn24.setForeground(getDrawable(R.drawable.default_btn_style));

        findViewById(R.id.circle_7_1).setForeground(getDrawable(R.drawable.background_circle));
        findViewById(R.id.circle_7_2).setForeground(getDrawable(R.drawable.background_circle));
        findViewById(R.id.circle_7_3).setForeground(getDrawable(R.drawable.background_circle));
        findViewById(R.id.circle_7_4).setForeground(getDrawable(R.drawable.background_circle));
        Button btn25 = (Button) findViewById(R.id.row_7_1);
        Button btn26 = (Button) findViewById(R.id.row_7_2);
        Button btn27 = (Button) findViewById(R.id.row_7_3);
        Button btn28 = (Button) findViewById(R.id.row_7_4);
        btn25.setForeground(getDrawable(R.drawable.default_btn_style));
        btn26.setForeground(getDrawable(R.drawable.default_btn_style));
        btn27.setForeground(getDrawable(R.drawable.default_btn_style));
        btn28.setForeground(getDrawable(R.drawable.default_btn_style));

        findViewById(R.id.circle_8_1).setForeground(getDrawable(R.drawable.background_circle));
        findViewById(R.id.circle_8_2).setForeground(getDrawable(R.drawable.background_circle));
        findViewById(R.id.circle_8_3).setForeground(getDrawable(R.drawable.background_circle));
        findViewById(R.id.circle_8_4).setForeground(getDrawable(R.drawable.background_circle));
        Button btn29 = (Button) findViewById(R.id.row_8_1);
        Button btn30 = (Button) findViewById(R.id.row_8_2);
        Button btn31 = (Button) findViewById(R.id.row_8_3);
        Button btn32 = (Button) findViewById(R.id.row_8_4);
        btn29.setForeground(getDrawable(R.drawable.default_btn_style));
        btn30.setForeground(getDrawable(R.drawable.default_btn_style));
        btn31.setForeground(getDrawable(R.drawable.default_btn_style));
        btn32.setForeground(getDrawable(R.drawable.default_btn_style));

        findViewById(R.id.circle_9_1).setForeground(getDrawable(R.drawable.background_circle));
        findViewById(R.id.circle_9_2).setForeground(getDrawable(R.drawable.background_circle));
        findViewById(R.id.circle_9_3).setForeground(getDrawable(R.drawable.background_circle));
        findViewById(R.id.circle_9_4).setForeground(getDrawable(R.drawable.background_circle));
        Button btn33 = (Button) findViewById(R.id.row_9_1);
        Button btn34 = (Button) findViewById(R.id.row_9_2);
        Button btn35 = (Button) findViewById(R.id.row_9_3);
        Button btn36 = (Button) findViewById(R.id.row_9_4);
        btn33.setForeground(getDrawable(R.drawable.default_btn_style));
        btn34.setForeground(getDrawable(R.drawable.default_btn_style));
        btn35.setForeground(getDrawable(R.drawable.default_btn_style));
        btn36.setForeground(getDrawable(R.drawable.default_btn_style));

        findViewById(R.id.circle_10_1).setForeground(getDrawable(R.drawable.background_circle));
        findViewById(R.id.circle_10_2).setForeground(getDrawable(R.drawable.background_circle));
        findViewById(R.id.circle_10_3).setForeground(getDrawable(R.drawable.background_circle));
        findViewById(R.id.circle_10_4).setForeground(getDrawable(R.drawable.background_circle));
        Button btn37 = (Button) findViewById(R.id.row_10_1);
        Button btn38 = (Button) findViewById(R.id.row_10_2);
        Button btn39 = (Button) findViewById(R.id.row_10_3);
        Button btn40 = (Button) findViewById(R.id.row_10_4);
        btn37.setForeground(getDrawable(R.drawable.default_btn_style));
        btn38.setForeground(getDrawable(R.drawable.default_btn_style));
        btn39.setForeground(getDrawable(R.drawable.default_btn_style));
        btn40.setForeground(getDrawable(R.drawable.default_btn_style));
    }
    private void runIntro()  {
        long endTime = System.currentTimeMillis() + 2 * 1000;
       Handler handler = new Handler();
       Runnable runnable = new Runnable() {
           @Override
           public void run() {
               Button task1 = (Button) findViewById(R.id.task_1);
               task1.setForeground(COLORS.get((int) (Math.random() * COLOR_NUMBER)));
               Button task2 = (Button) findViewById(R.id.task_2);
               task2.setForeground(COLORS.get((int) (Math.random() * COLOR_NUMBER)));
               Button task3 = (Button) findViewById(R.id.task_3);
               task3.setForeground(COLORS.get((int) (Math.random() * COLOR_NUMBER)));
               Button task4 = (Button) findViewById(R.id.task_4);
               task4.setForeground(COLORS.get((int) (Math.random() * COLOR_NUMBER)));
               handler.postDelayed(this, 100);
               if( System.currentTimeMillis() > endTime ){
                   handler.removeCallbacks(this);
                   task1.setForeground(getDrawable(R.drawable.default_btn_style));
                   task2.setForeground(getDrawable(R.drawable.default_btn_style));
                   task3.setForeground(getDrawable(R.drawable.default_btn_style));
                   task4.setForeground(getDrawable(R.drawable.default_btn_style));
               }
           }
       };
       handler.post(runnable);
    }

    private void congratulations(List<Integer> results){
        if(results.size() == 4 &&
                results.get(0) == 1 &&
                results.get(1) == 1 &&
                results.get(2) == 1 &&
                results.get(3) == 1){
            showTask(logic.getTask());
            Toast.makeText(this, "Gratulálunk, ügyes vagy!", Toast.LENGTH_LONG).show();
        }
    }

    private void endOfGame(List<Integer> results){
        showTask(logic.getTask());
        if(results.size() == 4 &&
                results.get(0) == 1 &&
                results.get(1) == 1 &&
                results.get(2) == 1 &&
                results.get(3) == 1){
            Toast.makeText(this, "Gratulálunk, ügyes vagy!", Toast.LENGTH_LONG).show();
        }
       else if( results.isEmpty() || results.contains(2) ){
            Toast.makeText(this, "Sebaj, legközelebb!", Toast.LENGTH_LONG).show();
        }
    }

    private void evaluateFirstRowTips(){
    Button btn1 = (Button) findViewById(R.id.row_1_1);
    Button btn2 = (Button) findViewById(R.id.row_1_2);
    Button btn3 = (Button) findViewById(R.id.row_1_3);
    Button btn4 = (Button) findViewById(R.id.row_1_4);
    List<Integer> results = logic.evaluateTip(
            getDrawableColorIndex(btn1.getForeground()),
            getDrawableColorIndex(btn2.getForeground()),
            getDrawableColorIndex(btn3.getForeground()),
            getDrawableColorIndex(btn4.getForeground()));

    for (int i = 0; i < results.size(); i++) {

        if( i == 0 && results.get(i) == 1 ){
            findViewById(R.id.circle_1_1).setForeground(getDrawable(R.drawable.white_circle));
        }
        else if( i == 0 && results.get(i) == 2 ){
            findViewById(R.id.circle_1_1).setForeground(getDrawable(R.drawable.black_circle));
        }
        else if( i == 1 && results.get(i) == 1 ){
            findViewById(R.id.circle_1_2).setForeground(getDrawable(R.drawable.white_circle));
        }
        else if( i == 1 && results.get(i) == 2 ){
            findViewById(R.id.circle_1_2).setForeground(getDrawable(R.drawable.black_circle));
        }
        else if( i == 2 && results.get(i) == 1 ){
            findViewById(R.id.circle_1_3).setForeground(getDrawable(R.drawable.white_circle));
        }
        else if( i == 2 && results.get(i) == 2 ){
            findViewById(R.id.circle_1_3).setForeground(getDrawable(R.drawable.black_circle));
        }
        else if( i == 3 && results.get(i) == 1 ){
            findViewById(R.id.circle_1_4).setForeground(getDrawable(R.drawable.white_circle));
        }
        else if( i == 3 && results.get(i) == 2 ){
            findViewById(R.id.circle_1_4).setForeground(getDrawable(R.drawable.black_circle));
        }
    }
       congratulations(results);
}

    private void evaluateSecondRowTips(){
        Button btn5 = (Button) findViewById(R.id.row_2_1);
        Button btn6 = (Button) findViewById(R.id.row_2_2);
        Button btn7 = (Button) findViewById(R.id.row_2_3);
        Button btn8 = (Button) findViewById(R.id.row_2_4);
        List<Integer> results = logic.evaluateTip(
                getDrawableColorIndex(btn5.getForeground()),
                getDrawableColorIndex(btn6.getForeground()),
                getDrawableColorIndex(btn7.getForeground()),
                getDrawableColorIndex(btn8.getForeground()));

        for (int i = 0; i < results.size(); i++) {

            if( i == 0 && results.get(i) == 1 ){
                findViewById(R.id.circle_2_1).setForeground(getDrawable(R.drawable.white_circle));
            }
            else if( i == 0 && results.get(i) == 2 ){
                findViewById(R.id.circle_2_1).setForeground(getDrawable(R.drawable.black_circle));
            }
            else if( i == 1 && results.get(i) == 1 ){
                findViewById(R.id.circle_2_2).setForeground(getDrawable(R.drawable.white_circle));
            }
            else if( i == 1 && results.get(i) == 2 ){
                findViewById(R.id.circle_2_2).setForeground(getDrawable(R.drawable.black_circle));
            }
            else if( i == 2 && results.get(i) == 1 ){
                findViewById(R.id.circle_2_3).setForeground(getDrawable(R.drawable.white_circle));
            }
            else if( i == 2 && results.get(i) == 2 ){
                findViewById(R.id.circle_2_3).setForeground(getDrawable(R.drawable.black_circle));
            }
            else if( i == 3 && results.get(i) == 1 ){
                findViewById(R.id.circle_2_4).setForeground(getDrawable(R.drawable.white_circle));
            }
            else if( i == 3 && results.get(i) == 2 ){
                findViewById(R.id.circle_2_4).setForeground(getDrawable(R.drawable.black_circle));
            }
        }
        congratulations(results);
    }

    private void evaluateThirdRowTips(){
        Button btn9 = (Button) findViewById(R.id.row_3_1);
        Button btn10 = (Button) findViewById(R.id.row_3_2);
        Button btn11 = (Button) findViewById(R.id.row_3_3);
        Button btn12 = (Button) findViewById(R.id.row_3_4);
        List<Integer> results = logic.evaluateTip(
                getDrawableColorIndex(btn9.getForeground()),
                getDrawableColorIndex(btn10.getForeground()),
                getDrawableColorIndex(btn11.getForeground()),
                getDrawableColorIndex(btn12.getForeground()));

        for (int i = 0; i < results.size(); i++) {

            if( i == 0 && results.get(i) == 1 ){
                findViewById(R.id.circle_3_1).setForeground(getDrawable(R.drawable.white_circle));
            }
            else if( i == 0 && results.get(i) == 2 ){
                findViewById(R.id.circle_3_1).setForeground(getDrawable(R.drawable.black_circle));
            }
            else if( i == 1 && results.get(i) == 1 ){
                findViewById(R.id.circle_3_2).setForeground(getDrawable(R.drawable.white_circle));
            }
            else if( i == 1 && results.get(i) == 2 ){
                findViewById(R.id.circle_3_2).setForeground(getDrawable(R.drawable.black_circle));
            }
            else if( i == 2 && results.get(i) == 1 ){
                findViewById(R.id.circle_3_3).setForeground(getDrawable(R.drawable.white_circle));
            }
            else if( i == 2 && results.get(i) == 2 ){
                findViewById(R.id.circle_3_3).setForeground(getDrawable(R.drawable.black_circle));
            }
            else if( i == 3 && results.get(i) == 1 ){
                findViewById(R.id.circle_3_4).setForeground(getDrawable(R.drawable.white_circle));
            }
            else if( i == 3 && results.get(i) == 2 ){
                findViewById(R.id.circle_3_4).setForeground(getDrawable(R.drawable.black_circle));
            }
        }
        congratulations(results);
    }


    private void evaluateForthRowTips(){
        Button btn13 = (Button) findViewById(R.id.row_4_1);
        Button btn14 = (Button) findViewById(R.id.row_4_2);
        Button btn15 = (Button) findViewById(R.id.row_4_3);
        Button btn16 = (Button) findViewById(R.id.row_4_4);
        List<Integer> results = logic.evaluateTip(
                getDrawableColorIndex(btn13.getForeground()),
                getDrawableColorIndex(btn14.getForeground()),
                getDrawableColorIndex(btn15.getForeground()),
                getDrawableColorIndex(btn16.getForeground()));

        for (int i = 0; i < results.size(); i++) {

            if( i == 0 && results.get(i) == 1 ){
                findViewById(R.id.circle_4_1).setForeground(getDrawable(R.drawable.white_circle));
            }
            else if( i == 0 && results.get(i) == 2 ){
                findViewById(R.id.circle_4_1).setForeground(getDrawable(R.drawable.black_circle));
            }
            else if( i == 1 && results.get(i) == 1 ){
                findViewById(R.id.circle_4_2).setForeground(getDrawable(R.drawable.white_circle));
            }
            else if( i == 1 && results.get(i) == 2 ){
                findViewById(R.id.circle_4_2).setForeground(getDrawable(R.drawable.black_circle));
            }
            else if( i == 2 && results.get(i) == 1 ){
                findViewById(R.id.circle_4_3).setForeground(getDrawable(R.drawable.white_circle));
            }
            else if( i == 2 && results.get(i) == 2 ){
                findViewById(R.id.circle_4_3).setForeground(getDrawable(R.drawable.black_circle));
            }
            else if( i == 3 && results.get(i) == 1 ){
                findViewById(R.id.circle_4_4).setForeground(getDrawable(R.drawable.white_circle));
            }
            else if( i == 3 && results.get(i) == 2 ){
                findViewById(R.id.circle_4_4).setForeground(getDrawable(R.drawable.black_circle));
            }
        }
        congratulations(results);
    }

    private void evaluateFifthRowTips(){
        Button btn17 = (Button) findViewById(R.id.row_5_1);
        Button btn18 = (Button) findViewById(R.id.row_5_2);
        Button btn19 = (Button) findViewById(R.id.row_5_3);
        Button btn20 = (Button) findViewById(R.id.row_5_4);
        List<Integer> results = logic.evaluateTip(
                getDrawableColorIndex(btn17.getForeground()),
                getDrawableColorIndex(btn18.getForeground()),
                getDrawableColorIndex(btn19.getForeground()),
                getDrawableColorIndex(btn20.getForeground()));

        for (int i = 0; i < results.size(); i++) {

            if( i == 0 && results.get(i) == 1 ){
                findViewById(R.id.circle_5_1).setForeground(getDrawable(R.drawable.white_circle));
            }
            else if( i == 0 && results.get(i) == 2 ){
                findViewById(R.id.circle_5_1).setForeground(getDrawable(R.drawable.black_circle));
            }
            else if( i == 1 && results.get(i) == 1 ){
                findViewById(R.id.circle_5_2).setForeground(getDrawable(R.drawable.white_circle));
            }
            else if( i == 1 && results.get(i) == 2 ){
                findViewById(R.id.circle_5_2).setForeground(getDrawable(R.drawable.black_circle));
            }
            else if( i == 2 && results.get(i) == 1 ){
                findViewById(R.id.circle_5_3).setForeground(getDrawable(R.drawable.white_circle));
            }
            else if( i == 2 && results.get(i) == 2 ){
                findViewById(R.id.circle_5_3).setForeground(getDrawable(R.drawable.black_circle));
            }
            else if( i == 3 && results.get(i) == 1 ){
                findViewById(R.id.circle_5_4).setForeground(getDrawable(R.drawable.white_circle));
            }
            else if( i == 3 && results.get(i) == 2 ){
                findViewById(R.id.circle_5_4).setForeground(getDrawable(R.drawable.black_circle));
            }
        }
        congratulations(results);
    }

    private void evaluateSixthRowTips(){
        Button btn21 = (Button) findViewById(R.id.row_6_1);
        Button btn22 = (Button) findViewById(R.id.row_6_2);
        Button btn23 = (Button) findViewById(R.id.row_6_3);
        Button btn24 = (Button) findViewById(R.id.row_6_4);
        List<Integer> results = logic.evaluateTip(
                getDrawableColorIndex(btn21.getForeground()),
                getDrawableColorIndex(btn22.getForeground()),
                getDrawableColorIndex(btn23.getForeground()),
                getDrawableColorIndex(btn24.getForeground()));

        for (int i = 0; i < results.size(); i++) {

            if( i == 0 && results.get(i) == 1 ){
                findViewById(R.id.circle_6_1).setForeground(getDrawable(R.drawable.white_circle));
            }
            else if( i == 0 && results.get(i) == 2 ){
                findViewById(R.id.circle_6_1).setForeground(getDrawable(R.drawable.black_circle));
            }
            else if( i == 1 && results.get(i) == 1 ){
                findViewById(R.id.circle_6_2).setForeground(getDrawable(R.drawable.white_circle));
            }
            else if( i == 1 && results.get(i) == 2 ){
                findViewById(R.id.circle_6_2).setForeground(getDrawable(R.drawable.black_circle));
            }
            else if( i == 2 && results.get(i) == 1 ){
                findViewById(R.id.circle_6_3).setForeground(getDrawable(R.drawable.white_circle));
            }
            else if( i == 2 && results.get(i) == 2 ){
                findViewById(R.id.circle_6_3).setForeground(getDrawable(R.drawable.black_circle));
            }
            else if( i == 3 && results.get(i) == 1 ){
                findViewById(R.id.circle_6_4).setForeground(getDrawable(R.drawable.white_circle));
            }
            else if( i == 3 && results.get(i) == 2 ){
                findViewById(R.id.circle_6_4).setForeground(getDrawable(R.drawable.black_circle));
            }
        }
        congratulations(results);
    }

    private void evaluateSeventhRowTips(){
        Button btn25 = (Button) findViewById(R.id.row_7_1);
        Button btn26 = (Button) findViewById(R.id.row_7_2);
        Button btn27 = (Button) findViewById(R.id.row_7_3);
        Button btn28 = (Button) findViewById(R.id.row_7_4);
        List<Integer> results = logic.evaluateTip(
                getDrawableColorIndex(btn25.getForeground()),
                getDrawableColorIndex(btn26.getForeground()),
                getDrawableColorIndex(btn27.getForeground()),
                getDrawableColorIndex(btn28.getForeground()));

        for (int i = 0; i < results.size(); i++) {

            if( i == 0 && results.get(i) == 1 ){
                findViewById(R.id.circle_7_1).setForeground(getDrawable(R.drawable.white_circle));
            }
            else if( i == 0 && results.get(i) == 2 ){
                findViewById(R.id.circle_7_1).setForeground(getDrawable(R.drawable.black_circle));
            }
            else if( i == 1 && results.get(i) == 1 ){
                findViewById(R.id.circle_7_2).setForeground(getDrawable(R.drawable.white_circle));
            }
            else if( i == 1 && results.get(i) == 2 ){
                findViewById(R.id.circle_7_2).setForeground(getDrawable(R.drawable.black_circle));
            }
            else if( i == 2 && results.get(i) == 1 ){
                findViewById(R.id.circle_7_3).setForeground(getDrawable(R.drawable.white_circle));
            }
            else if( i == 2 && results.get(i) == 2 ){
                findViewById(R.id.circle_7_3).setForeground(getDrawable(R.drawable.black_circle));
            }
            else if( i == 3 && results.get(i) == 1 ){
                findViewById(R.id.circle_7_4).setForeground(getDrawable(R.drawable.white_circle));
            }
            else if( i == 3 && results.get(i) == 2 ){
                findViewById(R.id.circle_7_4).setForeground(getDrawable(R.drawable.black_circle));
            }
        }
        congratulations(results);
    }
    private void evaluateEighthRowTips(){
        Button btn29 = (Button) findViewById(R.id.row_8_1);
        Button btn30 = (Button) findViewById(R.id.row_8_2);
        Button btn31 = (Button) findViewById(R.id.row_8_3);
        Button btn32 = (Button) findViewById(R.id.row_8_4);
        List<Integer> results = logic.evaluateTip(
                getDrawableColorIndex(btn29.getForeground()),
                getDrawableColorIndex(btn30.getForeground()),
                getDrawableColorIndex(btn31.getForeground()),
                getDrawableColorIndex(btn32.getForeground()));

        for (int i = 0; i < results.size(); i++) {

            if( i == 0 && results.get(i) == 1 ){
                findViewById(R.id.circle_8_1).setForeground(getDrawable(R.drawable.white_circle));
            }
            else if( i == 0 && results.get(i) == 2 ){
                findViewById(R.id.circle_8_1).setForeground(getDrawable(R.drawable.black_circle));
            }
            else if( i == 1 && results.get(i) == 1 ){
                findViewById(R.id.circle_8_2).setForeground(getDrawable(R.drawable.white_circle));
            }
            else if( i == 1 && results.get(i) == 2 ){
                findViewById(R.id.circle_8_2).setForeground(getDrawable(R.drawable.black_circle));
            }
            else if( i == 2 && results.get(i) == 1 ){
                findViewById(R.id.circle_8_3).setForeground(getDrawable(R.drawable.white_circle));
            }
            else if( i == 2 && results.get(i) == 2 ){
                findViewById(R.id.circle_8_3).setForeground(getDrawable(R.drawable.black_circle));
            }
            else if( i == 3 && results.get(i) == 1 ){
                findViewById(R.id.circle_8_4).setForeground(getDrawable(R.drawable.white_circle));
            }
            else if( i == 3 && results.get(i) == 2 ){
                findViewById(R.id.circle_8_4).setForeground(getDrawable(R.drawable.black_circle));
            }
        }
        congratulations(results);
    }

    private void evaluateNinthRowTips(){
        Button btn33 = (Button) findViewById(R.id.row_9_1);
        Button btn34 = (Button) findViewById(R.id.row_9_2);
        Button btn35 = (Button) findViewById(R.id.row_9_3);
        Button btn36 = (Button) findViewById(R.id.row_9_4);
        List<Integer> results = logic.evaluateTip(
                getDrawableColorIndex(btn33.getForeground()),
                getDrawableColorIndex(btn34.getForeground()),
                getDrawableColorIndex(btn35.getForeground()),
                getDrawableColorIndex(btn36.getForeground()));

        for (int i = 0; i < results.size(); i++) {

            if( i == 0 && results.get(i) == 1 ){
                findViewById(R.id.circle_9_1).setForeground(getDrawable(R.drawable.white_circle));
            }
            else if( i == 0 && results.get(i) == 2 ){
                findViewById(R.id.circle_9_1).setForeground(getDrawable(R.drawable.black_circle));
            }
            else if( i == 1 && results.get(i) == 1 ){
                findViewById(R.id.circle_9_2).setForeground(getDrawable(R.drawable.white_circle));
            }
            else if( i == 1 && results.get(i) == 2 ){
                findViewById(R.id.circle_9_2).setForeground(getDrawable(R.drawable.black_circle));
            }
            else if( i == 2 && results.get(i) == 1 ){
                findViewById(R.id.circle_9_3).setForeground(getDrawable(R.drawable.white_circle));
            }
            else if( i == 2 && results.get(i) == 2 ){
                findViewById(R.id.circle_9_3).setForeground(getDrawable(R.drawable.black_circle));
            }
            else if( i == 3 && results.get(i) == 1 ){
                findViewById(R.id.circle_9_4).setForeground(getDrawable(R.drawable.white_circle));
            }
            else if( i == 3 && results.get(i) == 2 ){
                findViewById(R.id.circle_9_4).setForeground(getDrawable(R.drawable.black_circle));
            }
        }
        congratulations(results);
    }

    private void evaluateTenthRowTips(){
        Button btn37 = (Button) findViewById(R.id.row_10_1);
        Button btn38 = (Button) findViewById(R.id.row_10_2);
        Button btn39 = (Button) findViewById(R.id.row_10_3);
        Button btn40 = (Button) findViewById(R.id.row_10_4);
        List<Integer> results = logic.evaluateTip(
                getDrawableColorIndex(btn37.getForeground()),
                getDrawableColorIndex(btn38.getForeground()),
                getDrawableColorIndex(btn39.getForeground()),
                getDrawableColorIndex(btn40.getForeground()));

        for (int i = 0; i < results.size(); i++) {

            if( i == 0 && results.get(i) == 1 ){
                findViewById(R.id.circle_10_1).setForeground(getDrawable(R.drawable.white_circle));
            }
            else if( i == 0 && results.get(i) == 2 ){
                findViewById(R.id.circle_10_1).setForeground(getDrawable(R.drawable.black_circle));
            }
            else if( i == 1 && results.get(i) == 1 ){
                findViewById(R.id.circle_10_2).setForeground(getDrawable(R.drawable.white_circle));
            }
            else if( i == 1 && results.get(i) == 2 ){
                findViewById(R.id.circle_10_2).setForeground(getDrawable(R.drawable.black_circle));
            }
            else if( i == 2 && results.get(i) == 1 ){
                findViewById(R.id.circle_10_3).setForeground(getDrawable(R.drawable.white_circle));
            }
            else if( i == 2 && results.get(i) == 2 ){
                findViewById(R.id.circle_10_3).setForeground(getDrawable(R.drawable.black_circle));
            }
            else if( i == 3 && results.get(i) == 1 ){
                findViewById(R.id.circle_10_4).setForeground(getDrawable(R.drawable.white_circle));
            }
            else if( i == 3 && results.get(i) == 2 ){
                findViewById(R.id.circle_10_4).setForeground(getDrawable(R.drawable.black_circle));
            }
        }
        endOfGame(results);
    }

    private void addOnClickListenersForFirstRow(){
        findViewById(R.id.ok_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                evaluateFirstRowTips();
            }
        });
        findViewById(R.id.row_1_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button btn = (Button) findViewById(R.id.row_1_1);
                btn.setForeground(getDrawableForNextColor(btn.getForeground()));
            }
        });
        findViewById(R.id.row_1_2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button btn = (Button) findViewById(R.id.row_1_2);
                btn.setForeground(getDrawableForNextColor(btn.getForeground()));
            }
        });
        findViewById(R.id.row_1_3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button btn = (Button) findViewById(R.id.row_1_3);
                btn.setForeground(getDrawableForNextColor(btn.getForeground()));
            }
        });
        findViewById(R.id.row_1_4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button btn = (Button) findViewById(R.id.row_1_4);
                btn.setForeground(getDrawableForNextColor(btn.getForeground()));
            }
        });
    }

    private void addOnClickListenersForSecondRow(){
        findViewById(R.id.ok_2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                evaluateSecondRowTips();
            }
        });
        findViewById(R.id.row_2_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button btn = (Button) findViewById(R.id.row_2_1);
                btn.setForeground(getDrawableForNextColor(btn.getForeground()));
            }
        });
        findViewById(R.id.row_2_2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button btn = (Button) findViewById(R.id.row_2_2);
                btn.setForeground(getDrawableForNextColor(btn.getForeground()));
            }
        });
        findViewById(R.id.row_2_3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button btn = (Button) findViewById(R.id.row_2_3);
                btn.setForeground(getDrawableForNextColor(btn.getForeground()));
            }
        });
        findViewById(R.id.row_2_4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button btn = (Button) findViewById(R.id.row_2_4);
                btn.setForeground(getDrawableForNextColor(btn.getForeground()));
            }
        });
    }

    private void addOnClickListenersForThirdRow(){
        findViewById(R.id.ok_3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                evaluateThirdRowTips();
            }
        });
        findViewById(R.id.row_3_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button btn = (Button) findViewById(R.id.row_3_1);
                btn.setForeground(getDrawableForNextColor(btn.getForeground()));
            }
        });
        findViewById(R.id.row_3_2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button btn = (Button) findViewById(R.id.row_3_2);
                btn.setForeground(getDrawableForNextColor(btn.getForeground()));
            }
        });
        findViewById(R.id.row_3_3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button btn = (Button) findViewById(R.id.row_3_3);
                btn.setForeground(getDrawableForNextColor(btn.getForeground()));
            }
        });
        findViewById(R.id.row_3_4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button btn = (Button) findViewById(R.id.row_3_4);
                btn.setForeground(getDrawableForNextColor(btn.getForeground()));
            }
        });
    }
    private void addOnClickListenersForForthRow(){
        findViewById(R.id.ok_4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                evaluateForthRowTips();
            }
        });
        findViewById(R.id.row_4_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button btn = (Button) findViewById(R.id.row_4_1);
                btn.setForeground(getDrawableForNextColor(btn.getForeground()));
            }
        });
        findViewById(R.id.row_4_2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button btn = (Button) findViewById(R.id.row_4_2);
                btn.setForeground(getDrawableForNextColor(btn.getForeground()));
            }
        });
        findViewById(R.id.row_4_3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button btn = (Button) findViewById(R.id.row_4_3);
                btn.setForeground(getDrawableForNextColor(btn.getForeground()));
            }
        });
        findViewById(R.id.row_4_4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button btn = (Button) findViewById(R.id.row_4_4);
                btn.setForeground(getDrawableForNextColor(btn.getForeground()));
            }
        });
    }

    private void addOnClickListenersForFifthRow(){
        findViewById(R.id.ok_5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                evaluateFifthRowTips();
            }
        });
        findViewById(R.id.row_5_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button btn = (Button) findViewById(R.id.row_5_1);
                btn.setForeground(getDrawableForNextColor(btn.getForeground()));
            }
        });
        findViewById(R.id.row_5_2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button btn = (Button) findViewById(R.id.row_5_2);
                btn.setForeground(getDrawableForNextColor(btn.getForeground()));
            }
        });
        findViewById(R.id.row_5_3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button btn = (Button) findViewById(R.id.row_5_3);
                btn.setForeground(getDrawableForNextColor(btn.getForeground()));
            }
        });
        findViewById(R.id.row_5_4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button btn = (Button) findViewById(R.id.row_5_4);
                btn.setForeground(getDrawableForNextColor(btn.getForeground()));
            }
        });
    }

    private void addOnClickListenersForSixthRow(){
        findViewById(R.id.ok_6).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                evaluateSixthRowTips();
            }
        });
        findViewById(R.id.row_6_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button btn = (Button) findViewById(R.id.row_6_1);
                btn.setForeground(getDrawableForNextColor(btn.getForeground()));
            }
        });
        findViewById(R.id.row_6_2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button btn = (Button) findViewById(R.id.row_6_2);
                btn.setForeground(getDrawableForNextColor(btn.getForeground()));
            }
        });
        findViewById(R.id.row_6_3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button btn = (Button) findViewById(R.id.row_6_3);
                btn.setForeground(getDrawableForNextColor(btn.getForeground()));
            }
        });
        findViewById(R.id.row_6_4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button btn = (Button) findViewById(R.id.row_6_4);
                btn.setForeground(getDrawableForNextColor(btn.getForeground()));
            }
        });
    }

    private void addOnClickListenersForSeventhRow(){
        findViewById(R.id.ok_7).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                evaluateSeventhRowTips();
            }
        });
        findViewById(R.id.row_7_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button btn = (Button) findViewById(R.id.row_7_1);
                btn.setForeground(getDrawableForNextColor(btn.getForeground()));
            }
        });
        findViewById(R.id.row_7_2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button btn = (Button) findViewById(R.id.row_7_2);
                btn.setForeground(getDrawableForNextColor(btn.getForeground()));
            }
        });
        findViewById(R.id.row_7_3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button btn = (Button) findViewById(R.id.row_7_3);
                btn.setForeground(getDrawableForNextColor(btn.getForeground()));
            }
        });
        findViewById(R.id.row_7_4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button btn = (Button) findViewById(R.id.row_7_4);
                btn.setForeground(getDrawableForNextColor(btn.getForeground()));
            }
        });
    }

    private void addOnClickListenersForEighthRow(){
        findViewById(R.id.ok_8).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                evaluateEighthRowTips();
            }
        });
        findViewById(R.id.row_8_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button btn = (Button) findViewById(R.id.row_8_1);
                btn.setForeground(getDrawableForNextColor(btn.getForeground()));
            }
        });
        findViewById(R.id.row_8_2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button btn = (Button) findViewById(R.id.row_8_2);
                btn.setForeground(getDrawableForNextColor(btn.getForeground()));
            }
        });
        findViewById(R.id.row_8_3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button btn = (Button) findViewById(R.id.row_8_3);
                btn.setForeground(getDrawableForNextColor(btn.getForeground()));
            }
        });
        findViewById(R.id.row_8_4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button btn = (Button) findViewById(R.id.row_8_4);
                btn.setForeground(getDrawableForNextColor(btn.getForeground()));
            }
        });
    }
    private void addOnClickListenersForNinthRow(){
        findViewById(R.id.ok_9).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                evaluateNinthRowTips();
            }
        });
        findViewById(R.id.row_9_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button btn = (Button) findViewById(R.id.row_9_1);
                btn.setForeground(getDrawableForNextColor(btn.getForeground()));
            }
        });
        findViewById(R.id.row_9_2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button btn = (Button) findViewById(R.id.row_9_2);
                btn.setForeground(getDrawableForNextColor(btn.getForeground()));
            }
        });
        findViewById(R.id.row_9_3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button btn = (Button) findViewById(R.id.row_9_3);
                btn.setForeground(getDrawableForNextColor(btn.getForeground()));
            }
        });
        findViewById(R.id.row_9_4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button btn = (Button) findViewById(R.id.row_9_4);
                btn.setForeground(getDrawableForNextColor(btn.getForeground()));
            }
        });
    }
    private void addOnClickListenersForTenthRow(){
        findViewById(R.id.ok_10).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                evaluateTenthRowTips();
            }
        });
        findViewById(R.id.row_10_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button btn = (Button) findViewById(R.id.row_10_1);
                btn.setForeground(getDrawableForNextColor(btn.getForeground()));
            }
        });
        findViewById(R.id.row_10_2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button btn = (Button) findViewById(R.id.row_10_2);
                btn.setForeground(getDrawableForNextColor(btn.getForeground()));
            }
        });
        findViewById(R.id.row_10_3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button btn = (Button) findViewById(R.id.row_10_3);
                btn.setForeground(getDrawableForNextColor(btn.getForeground()));
            }
        });
        findViewById(R.id.row_10_4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button btn = (Button) findViewById(R.id.row_10_4);
                btn.setForeground(getDrawableForNextColor(btn.getForeground()));
            }
        });
    }
    private void showTask(List<Integer> task){
        Button btn1 = (Button) findViewById(R.id.task_1);
        btn1.setForeground(COLORS.get(task.get(0)));
        Button btn2 = (Button) findViewById(R.id.task_2);
        btn2.setForeground(COLORS.get(task.get(1)));
        Button btn3 = (Button) findViewById(R.id.task_3);
        btn3.setForeground(COLORS.get(task.get(2)));
        Button btn4 = (Button) findViewById(R.id.task_4);
        btn4.setForeground(COLORS.get(task.get(3)));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        logic = new MasterMind(COLOR_NUMBER, true);
        COLORS = Arrays.asList(
                getDrawable(R.drawable.red_btn_style),
                getDrawable(R.drawable.blue_btn_style),
                getDrawable(R.drawable.purple_btn_style),
                getDrawable(R.drawable.yellow_btn_style),
                getDrawable(R.drawable.green_btn_style),
                getDrawable(R.drawable.white_btn_style),
                getDrawable(R.drawable.light_green_btn_style),
                getDrawable(R.drawable.gray_btn_style),
                getDrawable(R.drawable.black_btn_style));
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.toolbar);
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        runIntro();
        addOnClickListenersForFirstRow();
        addOnClickListenersForSecondRow();
        addOnClickListenersForThirdRow();
        addOnClickListenersForForthRow();
        addOnClickListenersForFifthRow();
        addOnClickListenersForSixthRow();
        addOnClickListenersForSeventhRow();
        addOnClickListenersForEighthRow();
        addOnClickListenersForNinthRow();
        addOnClickListenersForTenthRow();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        MenuCompat.setGroupDividerEnabled(menu, true);
        optionsMenu = menu;
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        String itemTitle = item.getTitle().toString();
        //noinspection SimplifiableIfStatement
        if( id == R.id.same_color_setting
                && itemTitle.equals(getString(R.string.same_colors))){
            item.setTitle(R.string.same_colors_OK);
            optionsMenu.findItem(R.id.different_colors_setting).setTitle(R.string.different_colors);
            IS_DIFFERENT_COLORS = false;
        }
        else if( id == R.id.different_colors_setting
                && itemTitle.equals(getString(R.string.different_colors))){
            item.setTitle(R.string.different_colors_OK);
            optionsMenu.findItem(R.id.same_color_setting).setTitle(R.string.same_colors);
            IS_DIFFERENT_COLORS = true;
        }
        else if( id == R.id.colors_6 ){
            item.setTitle(R.string.colors_6_X);
            optionsMenu.findItem(R.id.colors_7).setTitle(R.string.colors_7);
            optionsMenu.findItem(R.id.colors_8).setTitle(R.string.colors_8);
            optionsMenu.findItem(R.id.colors_9).setTitle(R.string.colors_9);
            COLOR_NUMBER = 6;
        }
        else if( id == R.id.colors_7 ){
            item.setTitle(R.string.colors_7_X);
            optionsMenu.findItem(R.id.colors_6).setTitle(R.string.colors_6);
            optionsMenu.findItem(R.id.colors_8).setTitle(R.string.colors_8);
            optionsMenu.findItem(R.id.colors_9).setTitle(R.string.colors_9);
            COLOR_NUMBER = 7;
        }
        else if( id == R.id.colors_8 ){
            item.setTitle(R.string.colors_8_X);
            optionsMenu.findItem(R.id.colors_6).setTitle(R.string.colors_6);
            optionsMenu.findItem(R.id.colors_7).setTitle(R.string.colors_7);
            optionsMenu.findItem(R.id.colors_9).setTitle(R.string.colors_9);
            COLOR_NUMBER = 8;
        }
        else if( id == R.id.colors_9 ){
            item.setTitle(R.string.colors_9_X);
            optionsMenu.findItem(R.id.colors_6).setTitle(R.string.colors_6);
            optionsMenu.findItem(R.id.colors_7).setTitle(R.string.colors_7);
            optionsMenu.findItem(R.id.colors_8).setTitle(R.string.colors_8);
            COLOR_NUMBER = 9;
        } else if ( id == R.id.new_game_setting) {
            init();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }

}