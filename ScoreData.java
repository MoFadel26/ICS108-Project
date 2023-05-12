package com.example.original;


import java.util.ArrayList;

import java.util.Collections;

public  class ScoreData {
    private int currentScore;
    private final int objectsNumber = 10;
    private ArrayList<Integer> topScores =new ArrayList<>();

    private int top1=0;
    private int top2=0;
    private int top3=0;
    private int top4=0;
    private int top5=0;


    public ScoreData() {
        this.currentScore = 0;
    }

    public int getCurrentScore() {
        return currentScore;
    }
    public void incrementCurrentScore(int objectValue){
        this.currentScore = this.currentScore + objectValue;
    }
    public void resetCurrentScore(){
        this.currentScore = 0;
    }
    public void addScore(){
        topScores.add(currentScore);
        orderScores();
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
        }

    }
    public void createtable(){


    }
}