/////////////////////////////////
// MATRIX TEST
// author: Christopher Santos
// modified: 2/26/2016
//////

import java.util.Scanner;

public class MatrixTest{
	public MatrixTest(){
		//set scanner for input
		Scanner reader = new Scanner(System.in);
		boolean israndom = false;
		char randomize = 'n';
		
	    //declare input variables
	    int rowsA;
	    int colsA;
	    int rowsB;
	    int colsB;
	    	
	    //input matrix 1 size
	    System.out.print("M1 row size: ");
	    rowsA = reader.nextInt();
	    System.out.print("M1 col size: ");
	    colsA = reader.nextInt();
	    System.out.print("randomize? (y/n) ");
	    randomize = reader.next().charAt(0);
	    if(randomize == 'y'){
	    	israndom = true;
	    }
	    if(randomize == 'n'){
	    	israndom = false;
	    }
	    
	    //matrix 1
	    Matrix matrix1 = new Matrix(rowsA, colsA, israndom);
	    System.out.println("M1 = ");
	    matrix1.print();
	
	    //input matrix 2 size 
	    System.out.print("M2 row size: ");
	    rowsB = reader.nextInt();
	    System.out.print("M2 col size: ");
	    colsB = reader.nextInt();
	    System.out.print("randomize? (y/n) ");
	    randomize = reader.next().charAt(0);
	    
	    if(randomize == 'y'){
	    	israndom = true;
	    }
	    if(randomize == 'n'){
	    	israndom = false;
	    }
	    
	    //matrix 2
	    Matrix matrix2 = new Matrix(rowsB, colsB, israndom);
	    System.out.println("M2 = ");
	    matrix2.print();
	    	    
	    //initialize timer
	    SortTimer time = new SortTimer();
	    
	    //operate on matrices
	    while(true){
		    System.out.println("* MATRIX OPS MENU *");
		    System.out.println("[a] M1 + M2");
		    System.out.println("[s] M1 - M2");
		    System.out.println("[m] M1 * M2");
		    System.out.println("[q] quit");
		    System.out.print("choice: ");
		    char choice = reader.next().charAt(0);
		    
		    //print menu
		    switch(choice){
		        case 'a':
		    	    time.reset();
		            Matrix matrix3 = matrix1.addition(matrix2);
		    	    System.out.println("M3 = M1 + M2 = ");
		            matrix3.print();
		        break;
		        case 's':
		    	    time.reset();
		            Matrix matrix4 = matrix1.subtraction(matrix2);
		    	    System.out.println("M4 = M1 - M2 = ");
		    	    matrix4.print();
		        break;
		        case 'm':
		    	    time.reset();
		            Matrix matrix5 = matrix1.multiplication(matrix2);
		    	    System.out.println("M5 = M1 * M2 = ");
		    	    matrix5.print();
		        break;
		        case 'q':
		    	    reader.close();
		        	System.exit(0);
		        default:
		        break;
		    }
		    //print time elapsed
		    System.out.println(time.getElapsedTime()+" microseconds");
	    }
	}
	
	public static void main(String[] args){
		new MatrixTest();
	}
}