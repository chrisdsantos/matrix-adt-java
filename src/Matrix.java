/////////////////////////////////
// MATRIX MULTIPLICATION - ADT, dynamic 2D array (class)
// author: Christopher Santos
// modified: 2/26/2016
//////

import java.util.Scanner;

public final class Matrix{
    public int rows;
    public int cols;
    private double data[][];
    
    Scanner reader = new Scanner(System.in); //set scanner for input
    
    // *******************
    //  MATRIX FUNCTIONS
    // *******************    
    public Matrix(int rows, int cols, boolean randomize){
        double input;
        
        this.rows = rows;
        this.cols = cols;
        double newmat[][] = new double[this.rows][this.cols];
    
        for(int i = 0; i < this.rows; i++){
            newmat[i] = new double[this.cols];
            for(int j = 0; j < this.cols; j++){
                if(!randomize){
                    System.out.print("("+(i+1)+", "+(j+1)+") = ");
                	input = reader.nextInt();
                	newmat[i][j] = input;
                }
                else{
                	//create random numbers
            		java.util.Random random = new java.util.Random();
                	input = (random.nextInt(99));
                    newmat[i][j] = input;
                }
            }
        }
        this.data = newmat;
    }
      
    public void print(){
        for(int i = 0; i < this.rows; i++){
            for(int j = 0; j < this.cols; j++){
                    System.out.print(this.data[i][j]+" ");
            }
            System.out.println();
        }        
        System.out.println();
    }
    
    // *******************
    //  MATRIX OPERATIONS
    // *******************

    public Matrix addition(Matrix matrixB){
        Matrix matrixC = new Matrix(this.rows, matrixB.cols, true);
    	if((this.rows != matrixB.rows) || (this.cols != matrixB.cols)){
        	System.out.println("* cannot add matrices with different dimensions.");
            return matrixC;
      }
        for(int i = 0; i < this.rows; i++){
            for(int j = 0; j < this.cols; j++){
                    matrixC.data[i][j] = this.data[i][j] + matrixB.data[i][j];
            }
        }
        return matrixC;
    }

    public Matrix subtraction(Matrix matrixB){
        Matrix matrixC = new Matrix(this.rows, matrixB.cols, true);
        if((this.rows != matrixB.rows) || (this.cols != matrixB.cols)){
        	System.out.println("* cannot subtract matrices with different dimensions.");
            return matrixC;
        }
        for(int i = 0; i < this.rows; i++){
            for(int j = 0; j < this.cols; j++){
                    matrixC.data[i][j] = this.data[i][j] - matrixB.data[i][j];
            }
        }
        return matrixC;
    }

    public Matrix multiplication(Matrix matrixB){
        Matrix matrixC = new Matrix(this.rows, matrixB.cols, true);
        if(this.cols != matrixB.rows){
        	System.out.println("* incompatible matrices for multiplication. ");
            return matrixC;
        }
        for(int i = 0; i < this.rows; i++){
            for(int j = 0; j < matrixB.cols; j++){
                for(int k = 0; k < matrixB.rows; k++){
                    matrixC.data[i][j] = matrixC.data[i][j] + (this.data[i][k] * matrixB.data[k][j]);
                }
            }
        }
        return matrixC;
    }
}