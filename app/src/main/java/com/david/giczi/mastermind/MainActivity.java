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
import java.util.Timer;
import java.util.TimerTask;


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

    private void evaluateFirstRowTip(){
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

    private void evaluateSecondRowTip(){
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

    private void addOnClickListenersForFirstRow(){
        findViewById(R.id.ok_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                evaluateFirstRowTip();
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
                evaluateSecondRowTip();
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