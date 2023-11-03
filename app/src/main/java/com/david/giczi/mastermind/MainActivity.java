package com.david.giczi.mastermind;

import android.content.pm.ActivityInfo;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.appcompat.content.res.AppCompatResources;
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
    private static int COLOR_INDEX = 5;
    private MasterMind logic;

    private Drawable getDrawableForNextColor(Drawable actualDrawable){
        int actualDrawableIndex = COLORS.indexOf(actualDrawable);
        return actualDrawableIndex == COLOR_INDEX ? COLORS.get(0) : COLORS.get(actualDrawableIndex + 1);
    }

    private int getDrawableColorIndex(Drawable actualDrawable){
        return COLORS.indexOf(actualDrawable);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        logic = new MasterMind(COLOR_INDEX + 1, false);
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

        findViewById(R.id.ok_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.circle_1_1).setForeground(getDrawable(R.drawable.white_circle));
                findViewById(R.id.circle_1_2).setForeground(getDrawable(R.drawable.white_circle));
                findViewById(R.id.circle_1_3).setForeground(getDrawable(R.drawable.black_circle));
                findViewById(R.id.circle_1_4).setForeground(getDrawable(R.drawable.black_circle));
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
        }
        else if( id == R.id.different_colors_setting
                && itemTitle.equals(getString(R.string.different_colors))){
            item.setTitle(R.string.different_colors_OK);
            optionsMenu.findItem(R.id.same_color_setting).setTitle(R.string.same_colors);
        }
        else if( id == R.id.colors_6 ){
            item.setTitle(R.string.colors_6_X);
            optionsMenu.findItem(R.id.colors_7).setTitle(R.string.colors_7);
            optionsMenu.findItem(R.id.colors_8).setTitle(R.string.colors_8);
            optionsMenu.findItem(R.id.colors_9).setTitle(R.string.colors_9);
        }
        else if( id == R.id.colors_7 ){
            item.setTitle(R.string.colors_7_X);
            optionsMenu.findItem(R.id.colors_6).setTitle(R.string.colors_6);
            optionsMenu.findItem(R.id.colors_8).setTitle(R.string.colors_8);
            optionsMenu.findItem(R.id.colors_9).setTitle(R.string.colors_9);
        }
        else if( id == R.id.colors_8 ){
            item.setTitle(R.string.colors_8_X);
            optionsMenu.findItem(R.id.colors_6).setTitle(R.string.colors_6);
            optionsMenu.findItem(R.id.colors_7).setTitle(R.string.colors_7);
            optionsMenu.findItem(R.id.colors_9).setTitle(R.string.colors_9);
        }
        else if( id == R.id.colors_9 ){
            item.setTitle(R.string.colors_9_X);
            optionsMenu.findItem(R.id.colors_6).setTitle(R.string.colors_6);
            optionsMenu.findItem(R.id.colors_7).setTitle(R.string.colors_7);
            optionsMenu.findItem(R.id.colors_8).setTitle(R.string.colors_8);
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