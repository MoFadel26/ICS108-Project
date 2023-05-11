package com.example.original;


import java.util.ArrayList;

import java.util.Collections;

public  class ScoreData {
    private int currentScore;
    private int objectsNumber;
    private ArrayList<Integer> topScores =new ArrayList<>();

    private int top1;
    private int top2;
    private int top3;
    private int top4;
    private int top5;


    public ScoreData() {
        this.currentScore = 0;
        this.objectsNumber = 1;
    }

    public int getCurrentScore() {
        return currentScore;
    }

    public int getObjectsNumber() {
        return objectsNumber;
    }
    public void incrementCurrentScore(){
        this.currentScore = this.currentScore + this.objectsNumber + 1;
    }
    public void incrementObjectsNumber(){
        this.objectsNumber = this.objectsNumber + 2;

    }

    public int getTop1() {
        return top1;
    }

    public int getTop2() {
        return top2;
    }

    public int getTop3() {
        return top3;
    }

    public int getTop4() {
        return top4;
    }

    public int getTop5() {
        return top5;
    }

    public ArrayList<Integer> getTopScores() {
        return topScores;
    }
    public void orderScores(){
        try{
            Collections.sort(topScores);
            top1=topScores.get(topScores.size()-1);
            top2=topScores.get(topScores.size()-2);
            top3=topScores.get(topScores.size()-3);
            top4=topScores.get(topScores.size()-4);
            top5=topScores.get(topScores.size()-5);
        }
        catch (IndexOutOfBoundsException  e){
            // the rest will be zero;
        }

    }
}


