//SortTimer
//@author Christopher Santos
//updated: 11/3/2015

public class SortTimer {
	long comparisons, moves, time;

	void reset(){
		comparisons = 0;
		moves = 0;
		time = System.nanoTime();
	}
	
	void addComparison(){
		comparisons = comparisons + 1;
	}
	
	void addComparisons(int n){
		comparisons = comparisons + n;
	}
	
	void addMove(){
		moves = moves + 1;
	}
	
	void addMoves(int n){
		moves = moves + n;
	}
	
	long getComparisons(){
		return comparisons;
	}
	
	long getMoves(){
		return moves;
	}
	
	long getElapsedTime(){
		return (System.nanoTime()-time)/((int)(Math.pow(10,3)));
	}

}