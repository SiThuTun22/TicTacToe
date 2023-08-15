package tictactoe;
import java.util.*;
public class TicTacToe {
      private static String arr[][];
      int row;
      int col;
      static Scanner sc = new Scanner(System.in);
      public static void createArray()
      {
    	  int d = 3;
    	  arr = new String[d][d];
    	  for(int r=0;r<d;r++)
    	  {
    		  for(int c=0;c<d;c++)
    		  {
    			  arr[r][c] = " ";
    		  }
    	  }
      }
      public static boolean isGameOver()
      {
    	  for(int r =0;r<arr.length;r++)
    	  {
    		  for(int c=0;c<arr[r].length;c++)
    		  {
    			  if(arr[r][c] == " ")
    			  {
    				  return false;
    			  }
    		  }
    	  }
    	  return true;
      }
      public static boolean isHWin(int r,String ch)
      {
    	  for(int c = 0;c<arr[r].length;c++)
    	  {
    		  if(arr[r][c] != ch)
    		  {
    			  return false;
    		  }
    	  }
    	  return true;
      }
      public static boolean isVWin(int c,String ch)
      {
    	  for(int r = 0;r<arr[c].length;r++)
    	  {
    		  if(arr[r][c] != ch)
    		  {
    			  return false;
    		  }
    	  }
    	  return true;
      }
      public static boolean isMDWin(int r,int c,String ch)
      {
    	  if(r!=c)
    	  {
    		  return false;
    	  }
    	  for(int i = 0;i<arr.length;i++)
    	  {
    		  if(arr[i][i] != ch)
    		  {
    			  return false;
    		  }
    	  }
    	  return true;
      }
      public static boolean isODWin(int r,int c,String ch)
      {   
    	  int size = arr.length;
    	  if(size-1-r != c)
    	  {
    		  return false;
    	  }
    	  
    		  for(int i = 0;i <arr.length;i++)
    		  {
    			  if(arr[i][size-1-i] != ch)
    			  {
    				  return false;
    			  }
    		  }
    	  
    	  return true;
      }
//      public static boolean isWin(int r,int c,String ch)
//      {
//    	  return isHWin(r,ch)||isVWin(c,ch)||isMDWin(r,c,ch)||isODWin(r,c,ch);
//      }
      public Index fillComputer(String ch,boolean check)
      {   
    	  //System.out.println("here2");
    	  if(check == true)
    	  {
    	  int r,c;
    	  do {
    	  r = (int)(Math.random()*3);
    	  c = (int)(Math.random()*3);
    	  }while(arr[r][c] != " ");
    	  
    	  
    	  
    	  row = r;
    	  col = c;
    	  arr[row][col] = ch;
    	  }
    	  TicTacToeUserInterface t = new TicTacToeUserInterface();
    	  t.computerButton(row,col);
    	  
    	  Index dimension = new Index(row,col);
    	  
    	  return dimension;
    	  
    	  
      }
      public void fillPlayer(String ch,int r,int c)
      {   
    	  //System.out.println("here1");
    	  
    	  if(arr[r][c] == " ")
    	  {
    		  arr[r][c] = ch;
    	  }
    	  
      }
}
