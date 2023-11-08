package com.david.giczi.mastermind;

import java.util.ArrayList;
import java.util.Arrays;
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
        giveMeTask();
    }

    private void giveMeTask(){
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

    public List<Integer> evaluateTipp(int tipp1, int tipp2, int tipp3, int tipp4){
        List<Integer> tips = Arrays.asList(tipp1, tipp2, tipp3, tipp4);
        List<Integer> results = new ArrayList<>();
        for (int i = 0; i < task.size(); i++) {
                if(task.get(i) == tips.get(i)) {
                    tips.set(i, -1);
                    results.add(1);
                }
        }

        for (int i = 0; i < task.size(); i++) {
            if(tips.contains(task.get(i))){
                results.add(2);
            }
        }

        return results;
    }
}
