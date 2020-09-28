package com.gorban.interviewprep;

public class MathSolutions {

    public int calculateSqrt(int input){
        int squareRoot = 0;
        for (int i = 1; i < input; i ++){
            squareRoot = i * i;
            if (squareRoot == input){
                return i;
            } else if (input < squareRoot) {
                return i - 1;
            }
        }
        return 0;
    }
//9 -> 3
//4 -> 2
//5 -> 2
}
