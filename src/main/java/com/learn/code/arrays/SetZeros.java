package com.learn.code.arrays;

import java.util.HashSet;

public class SetZeros {

    public static void main(String[] args) {

    }

    public static void setZeroes(int[][] matrix) {

        //first row and col of every cell as flag
        //(3,2) -> 1st row -> (3,0) and 1st col -> (0,2)
        // where the value is 0

        //rows
        int rows = matrix.length;
        int cols = matrix[0].length;

        boolean row_flag = false;
        boolean col_flag = false;

        for(int i=0; i< rows; i++) {
            for(int j=0; j<cols; j++) {

                if (i == 0 && matrix[i][j] == 0)
                    row_flag = true;

                if (j == 0 && matrix[i][j] == 0)
                    col_flag = true;

                if(matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < matrix.length; i ++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if(matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        //considering the (0,0) cell position
        if(row_flag  == true) {
            for (int j = 0; j < cols; j++){
                matrix[0][j] = 0;
            }
        }

        if(col_flag == true) {
            for (int i = 0; i < rows; i++){
                matrix[i][0] = 0;
            }
        }

    }
}
