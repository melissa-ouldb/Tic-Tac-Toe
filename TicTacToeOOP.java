package miniprojects;

import java.util.Scanner;

public class TicTacToeOOP {
	
	static Scanner scanner= new Scanner(System.in);
    static String[][] array= new String[3][3];
    static int i=0;
    static int emptyCell=9;
    
//Creating the grid
	public static String[][] creatingGrid() {
		System.out.println("---------");
	      for(int i=0; i<3;i++) {
	   	   System.out.print("| ");
	   	   for(int j=0;j<3;j++) {
	   		   array[i][j]="  ";
	   		   System.out.print(array[i][j]);
	   	   }
	   	   System.out.println("|");
	      }
	      System.out.println("---------");
		return array;
	}
	
//Making a move
	public static void nextMove() throws RuntimeException {
		int x=0,y=0; 
		i++;
		do {
		String move= scanner.nextLine();
        String a= move.substring(0,1); 
        String b= move.substring(2,3);
        
        try {
        x= Integer.parseInt(a);
        y= Integer.parseInt(b);
        }
        catch(NumberFormatException nfe){
	        System.out.println("You should enter numbers!");
        }
        
        if(x>3 || y>3) {System.out.println("Coordinates should be from 1 to 3!");}
		}while(x>3 || y>3 || x==0 || y==0);
        
       occupiedCell((x-1),(y-1));
	}

//Checking if the cell is empty
	public static int occupiedCell(int a, int b) {
	
		if(array[a][b].equals("  ")) {
		if(i%2==1) { array[a][b]="X ";}	
		else {	     array[a][b]="O ";}
			
			finalGrid(array);
	       }
	       else {
	    	   System.out.println("This cell is occupied! Choose another one!");
	    	  i--;
	    	   nextMove();
	       }
		return i;
	}
	
//displaying the final grid	
	public static void finalGrid(String[][]array) {
		 emptyCell--;
		 
		System.out.println("---------");
	      for(int i=0; i<3;i++) {
	   	   System.out.print("| ");
	   	   for(int j=0;j<3;j++) {
	   		   System.out.print(array[i][j]);
	   	   }
	   	   System.out.println("|");
	      }
	      System.out.println("---------"); 
	   winner(array);

	}
	
	
 //Determining the winner
    public static void winner(String[][]array) {
    	
    	//comparing rows
    	   if(array[0][0].equals(array[0][1]) && array[0][1].equals(array[0][2]) && array[0][0]!="  ") {
    		   if(array[0][0].equals("X ")) {System.out.println("X wins "); }
    		   else { System.out.println("O wins");}
    		
    	   }
    	   else if(array[1][0].equals(array[1][1]) && array[1][1].equals(array[1][2]) && array[1][0]!="  ") {
    		   if(array[1][0].equals("X ")) {System.out.println("X wins "); }
    		   else { System.out.println("O wins");}
    		
    	   }
    	   else if(array[2][0].equals(array[2][1]) && array[2][0].equals(array[2][2]) && array[2][0]!="  ") {
    		   if(array[2][0].equals("X ")) {System.out.println("X wins "); }
    		   else { System.out.println("O wins");}
    		
    	   }
    	//-------------------------
    	   //camparing column
    	   else if(array[0][0].equals(array[1][0]) && array[0][0].equals(array[2][0]) && array[0][0]!="  ") {
      	      if(array[0][0].equals("X ")) {System.out.println("X wins");  }
  		      else { System.out.println("O wins"); } 
      		   
      	   }
      	   else if(array[0][1].equals(array[1][1]) && array[0][1].equals(array[2][1]) && array[0][1]!="  ") {
       	      if(array[0][1].equals("X ")) {System.out.println("X wins");  }
   		      else { System.out.println("O wins"); } 
       		   
       	   }
      	   
      	   else if(array[0][2].equals(array[1][2]) && array[0][2].equals(array[2][2]) && array[0][2]!="  ") {
        	      if(array[0][2].equals("X ")) {System.out.println("X wins");  }
    		      else { System.out.println("O wins"); } 
      	   }	   
        //------------------------
    	   //comparing diagonals
           else if(array[1][1].equals(array[0][0])&& array[1][1].equals(array[2][2]) && array[1][1]!="  ") {
        	   if(array[1][1].equals("X ")) {System.out.println("X wins"); }
    		   else { System.out.println("O wins"); }
    		}
           
           else if(array[1][1].equals(array[0][2])&& array[1][1].equals(array[2][0]) && array[1][1]!="  ") {
        	   if(array[1][1].equals("X ")) {System.out.println("X wins"); }
    		   else { System.out.println("O wins");}
    		}
           
           else if(emptyCell==0) {
        	   System.out.println("Draw");
           }
           else {   
        	   nextMove();
           }
    	   }
    
	public static void main(String[] args) {
		creatingGrid();
		nextMove();
			
	}

}
