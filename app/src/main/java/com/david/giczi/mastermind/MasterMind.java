package com.david.giczi.mastermind;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class MasterMind {

private int numberOfColors;
private boolean isDifferentColors;
private List<Integer> task = new ArrayList<>();

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
        while( 4 > task.size()){
            task.add((int) (Math.random() * numberOfColors));
        }
    }

    public List<Integer> getTask() {
        return task;
    }

    public List<Integer> evaluateTip(int tip1, int tip2, int tip3, int tip4){
        List<Integer> tips = Arrays.asList(tip1, tip2, tip3, tip4);
        List<Integer> task = new ArrayList<>(this.task);
        List<Integer> results = new ArrayList<>();
        for (int i = 0; i < task.size(); i++) {
                if(task.get(i) == tips.get(i)) {
                    tips.set(i, -1);
                    task.set(i, -2);
                    results.add(2);
                }
        }
        for (int i = 0; i < task.size(); i++) {
            if(task.contains(tips.get(i))){
                task.set(task.indexOf(tips.get(i)), -2);
                results.add(1);
            }
        }
        return results;
    }
}
