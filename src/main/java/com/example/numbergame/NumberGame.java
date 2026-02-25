package com.example.numbergame;

import java.util.Random;

public class NumberGame {
    private int answer;
    private Random rand = new Random();

    public NumberGame() {
     generateAnswer();
    }

    public void generateAnswer() {
        answer = rand.nextInt(10) + 1;
    }
   public int getAnswer() {
        return answer;
   }

   public void resetGame() {
      generateAnswer();
   }
}
