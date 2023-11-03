package com.david.giczi.mastermind;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class MasterMind {

private int numberOfColors;
private boolean isDifferentColors;
private List<Integer> task;

    public MasterMind(int numberOfColors, boolean isDifferentColors) {
        this.numberOfColors = numberOfColors;
        this.isDifferentColors = isDifferentColors;
    }

    public void giveMeTask(){
        if( isDifferentColors ){
            giveMeTaskWithDifferentColors();
        }
        else{
            giveMeTaskIfSameColorsArePossible();
        }
    }

    private void giveMeTaskWithDifferentColors(){
        HashSet<Integer> colorSet = new HashSet<>();
         while( 4 > colorSet.size()){
             colorSet.add((int) (Math.random() * numberOfColors));
         }
         task = new ArrayList<>(colorSet);
         Collections.shuffle(task);
    }
    private void giveMeTaskIfSameColorsArePossible(){
        task = new ArrayList<>();
        while( 4 > task.size()){
            task.add((int) (Math.random() * numberOfColors));
        }
    }

    public List<Integer> getTask() {
        return task;
    }

}
