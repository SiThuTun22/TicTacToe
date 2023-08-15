package tictactoe;
//to return two var
public class Index {
	
	 private int row,col;
     public Index(int row,int col){
    	 this.row = row;
    	 this.col = col;
     }
     public void setRow(int row)
     {
    	 this.row = row;
     }
     public int getRow()
     {
    	 return row;
     }
     public void setCol(int col)
     {
    	 this.col = col;
     }
     public int getCol()
     {
    	 return col;
     }
}
