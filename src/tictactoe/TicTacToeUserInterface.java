package tictactoe;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class TicTacToeUserInterface extends Application{
    private static Button b3;
	private static Button b1;
	private static Button b5;
	private static Button b2;
	private static Button b4;
	private static Button b6;
	private static Button b9;
	private static Button b7;
	private static Button b8;
	private static BorderPane b;
	
	private static GridPane gp;
	private static GridPane gp1;
	private static Button comButton;
	private static Stage s;
	private static BorderPane comB;
	private static Label lose;
	private static Button exit0;
	private static Label win;
	private static Label gameOver;
	private static Button exit1;
	String com = "O";
	boolean check = false;
	boolean gameCondition = true;
	public void computerButton(int r,int c)
	{
		comButton = new Button();
		comButton.setText(com);
		comButton.getStyleClass().add("comRelease");
		comButton.getStyleClass().add("comButton");
		gp.add(comButton, c, r);
		
	}
	public void losing()
	{   
		
		lose = new Label("You Lost!");
		lose.getStyleClass().add("desicion");
		exit0 = new Button("Exit");
		exit0.getStyleClass().add("exit");
		exit0.setOnAction(e->{
			System.exit(0);
		});
		comB = new BorderPane();
		URL url = this.getClass().getResource("TicTacToeUserInterface.css");
		comB.setCenter(lose);
		comB.setBottom(exit0);
		comB.setAlignment(exit0, Pos.CENTER);
	    Stage s1 = new Stage();
		Scene sc1 = new Scene(comB,500,500);
		sc1.getStylesheets().add(url.toExternalForm());
		s1.setScene(sc1);
		s1.setTitle(":(");
		s1.show();
		s.hide();
	}
	public void winning()
	{
		win = new Label("You Won!");
		win.getStyleClass().add("winning");
		exit0 = new Button("Exit");
		exit0.getStyleClass().add("exit");
		exit0.setOnAction(e->{
			System.exit(0);
		});
		comB = new BorderPane();
		URL url = this.getClass().getResource("TicTacToeUserInterface.css");
		comB.setCenter(win);
		comB.setBottom(exit0);
		comB.setAlignment(exit0, Pos.CENTER);
	    Stage s1 = new Stage();
		Scene sc1 = new Scene(comB,300,300);
		sc1.getStylesheets().add(url.toExternalForm());
		s1.setScene(sc1);
		s1.setTitle(":)");
		s1.show();
		s.hide();
	}
	public void draw()
	{
		gameOver = new Label("No one won");
		gameOver.getStyleClass().add("draw");
		exit0 = new Button("Exit");
		exit0.getStyleClass().add("exit");
		exit0.setOnAction(e->{
			System.exit(0);
		});
		comB = new BorderPane();
		URL url = this.getClass().getResource("TicTacToeUserInterface.css");
		comB.setCenter(gameOver);
		comB.setBottom(exit0);
		comB.setAlignment(exit0, Pos.CENTER);
	    Stage s1 = new Stage();
		Scene sc1 = new Scene(comB,300,300);
		sc1.getStylesheets().add(url.toExternalForm());
		s1.setScene(sc1);
		s1.setTitle(":)");
		s1.show();
		s.hide();
	}
	public void fillCom(TicTacToe t)
	{
		t.fillComputer(com,check);
		check = false;
		if(t.isHWin(t.fillComputer(com,check).getRow(),com)){
			losing();
		}
		else if(t.isMDWin(t.fillComputer(com,check).getRow(), t.fillComputer(com,check).getCol(), com))
		{   
			losing();
		}
		else if(t.isVWin(t.fillComputer(com, check).getCol(), com))
		{    
			losing();
		}
		else if(t.isODWin(t.fillComputer(com, check).getRow(), t.fillComputer(com, check).getCol(), com))
		{   
			losing();
		}
	    if(t.isGameOver())
		{
			draw();
		}
	}
	
	public void createNodesForMainPane()
	{   
		TicTacToe t = new TicTacToe();
		t.createArray();
		b1 = new Button();
		b1.setText(" ");
		b1.getStyleClass().add("button");
		b1.setOnMousePressed(e->{
			b1.getStyleClass().add("press");
		});
		b1.setOnMouseReleased(e->{
			check = true;
			b1.getStyleClass().add("release");
			if(b1.getText() == " ")
			{   
				String person= "X";
				b1.setText(person);
				t.fillPlayer(person, 0, 0);
				
			    if(t.isHWin(0,person)){
//					b1.getStyleClass().add("winButton");
//					b2.getStyleClass().add("winButton");
//					b3.getStyleClass().add("winButton");
					gameCondition = false;
					winning();
				}
				else if(t.isMDWin(0, 0, person))
				{
//					b1.getStyleClass().add("winButton");
//					b5.getStyleClass().add("winButton");
//					b9.getStyleClass().add("winButton");
					gameCondition = false;
					winning();
				}
				else if(t.isVWin(0, person))
				{
//					b1.getStyleClass().add("winButton");
//					b4.getStyleClass().add("winButton");
//					b7.getStyleClass().add("winButton");
					gameCondition = false;
					winning();
				}
			    if(t.isGameOver() && gameCondition == true)
				{
			    	draw();
				}
			    if(gameCondition != false)
			    {
			    	fillCom(t);
			    }
			
			
			}});
		
		b2 = new Button();
		b2.setText(" ");
		b2.getStyleClass().add("button");
		b2.setOnMousePressed(e->{
			b2.getStyleClass().add("press");
		});
		b2.setOnMouseReleased(e->{
			check = true;
			b2.getStyleClass().add("release");
			if(b2.getText() == " ")
			{   
				String person= "X";
				b2.setText(person);
				t.fillPlayer(person, 0, 1);
				
			    if(t.isHWin(0,person)){
//					b1.getStyleClass().add("winButton");
//					b2.getStyleClass().add("winButton");
//					b3.getStyleClass().add("winButton");
					gameCondition = false;
					winning();
				}
				else if(t.isVWin(1, person))
				{
//					b2.getStyleClass().add("winButton");
//					b5.getStyleClass().add("winButton");
//					b8.getStyleClass().add("winButton");
					gameCondition = false;
					winning();
				}
			    if(t.isGameOver() && gameCondition == true)
				{
			    	draw();
				}
			    if(gameCondition != false)
			    {
			    	fillCom(t);
			    }
			}});
		b3 = new Button();
		b3.setText(" ");
		b3.getStyleClass().add("button");
		b3.setOnMousePressed(e->{
			b3.getStyleClass().add("press");
		});
		b3.setOnMouseReleased(e->{
			check = true;
			b3.getStyleClass().add("release");
			if(b3.getText() == " ")
			{   
				String person= "X";
				b3.setText(person);
				t.fillPlayer(person, 0, 2);
				
			    if(t.isHWin(0,person)){
//					b1.getStyleClass().add("winButton");
//					b2.getStyleClass().add("winButton");
//					b3.getStyleClass().add("winButton");
					gameCondition = false;
					winning();
				}
				else if(t.isVWin(2, person))
				{
//					b3.getStyleClass().add("winButton");
//					b6.getStyleClass().add("winButton");
//					b9.getStyleClass().add("winButton");
					gameCondition = false;
					winning();
				}
				else if(t.isODWin(0, 2, person))
				{
//					b3.getStyleClass().add("winButton");
//					b5.getStyleClass().add("winButton");
//					b7.getStyleClass().add("winButton");
					gameCondition = false;
					winning();
				}
			    
			    if(t.isGameOver() && gameCondition == true)
				{
			    	draw();
				}
			    if(gameCondition != false)
			    {
			    	fillCom(t);
			    }
		}});
		b4 = new Button();
		b4.setText(" ");
		b4.getStyleClass().add("button");
		b4.setOnMousePressed(e->{
			b4.getStyleClass().add("press");
		});
		b4.setOnMouseReleased(e->{
			check = true;
			b4.getStyleClass().add("release");
			if(b4.getText() == " ")
			{   
				String person= "X";
				b4.setText(person);
				t.fillPlayer(person, 1, 0);
				
			    if(t.isHWin(1,person)){
//					b4.getStyleClass().add("winButton");
//					b5.getStyleClass().add("winButton");
//					b6.getStyleClass().add("winButton");
					gameCondition = false;
					winning();
				}
				else if(t.isVWin(0, person))
				{
//					b1.getStyleClass().add("winButton");
//					b4.getStyleClass().add("winButton");
//					b7.getStyleClass().add("winButton");
					gameCondition = false;
					winning();
				}
				
			    if(t.isGameOver() && gameCondition == true)
				{
			    	draw();
				}
			    if(gameCondition != false)
			    {
			    	fillCom(t);
			    }
		}});
		b5 = new Button();
		b5.setText(" ");
		b5.getStyleClass().add("button");
		b5.setOnMousePressed(e->{
			b5.getStyleClass().add("press");
		});
		b5.setOnMouseReleased(e->{
			check = true;
			b5.getStyleClass().add("release");
			if(b5.getText() == " ")
			{   
				String person= "X";
				b5.setText(person);
				t.fillPlayer(person, 1, 1);
				
			    if(t.isHWin(1,person)){
//					b4.getStyleClass().add("winButton");
//					b5.getStyleClass().add("winButton");
//					b6.getStyleClass().add("winButton");
					gameCondition = false;
					winning();
				}
				else if(t.isVWin(1, person))
				{
//					b2.getStyleClass().add("winButton");
//					b5.getStyleClass().add("winButton");
//					b8.getStyleClass().add("winButton");
					gameCondition = false;
					winning();
				}
			    else if(t.isODWin(1, 1, person))
				{
//					b3.getStyleClass().add("winButton");
//					b5.getStyleClass().add("winButton");
//					b7.getStyleClass().add("winButton");
					gameCondition = false;
					winning();
				}
			    else if(t.isMDWin(1, 1, person))
				{
//					b1.getStyleClass().add("winButton");
//					b5.getStyleClass().add("winButton");
//					b9.getStyleClass().add("winButton");
					gameCondition = false;
					winning();
				}
			    if(t.isGameOver() && gameCondition == true)
				{
			    	draw();
				}
			    if(gameCondition != false)
			    {
			    	fillCom(t);
			    }
		}});
		b6 = new Button();
		b6.setText(" ");
		b6.getStyleClass().add("button");
		b6.setOnMousePressed(e->{
			b6.getStyleClass().add("press");
		});
		b6.setOnMouseReleased(e->{
			check = true;
			b6.getStyleClass().add("release");
			if(b6.getText() == " ")
			{   
				String person= "X";
				b6.setText(person);
				t.fillPlayer(person, 1, 2);
				
			    if(t.isHWin(1,person)){
//					b4.getStyleClass().add("winButton");
//					b5.getStyleClass().add("winButton");
//					b6.getStyleClass().add("winButton");
					gameCondition = false;
					winning();
				}
				else if(t.isVWin(2, person))
				{
//					b3.getStyleClass().add("winButton");
//					b6.getStyleClass().add("winButton");
//					b9.getStyleClass().add("winButton");
					gameCondition = false;
					winning();
				}
			    if(t.isGameOver() && gameCondition == true)
				{
			    	draw();
				}
			    if(gameCondition != false)
			    {
			    	fillCom(t);
			    }
		}});
		b7 = new Button();
		b7.setText(" ");
		b7.getStyleClass().add("button");
		b7.setOnMousePressed(e->{
			b7.getStyleClass().add("press");
		});
		b7.setOnMouseReleased(e->{
			check = true;
			b7.getStyleClass().add("release");
			if(b7.getText() == " ")
			{   
				String person= "X";
				b7.setText(person);
				t.fillPlayer(person, 2, 0);
				
			    if(t.isHWin(2,person)){
//					b7.getStyleClass().add("winButton");
//					b8.getStyleClass().add("winButton");
//					b9.getStyleClass().add("winButton");
					gameCondition = false;
					winning();
				}
				else if(t.isVWin(0, person))
				{
//					b1.getStyleClass().add("winButton");
//					b4.getStyleClass().add("winButton");
//					b7.getStyleClass().add("winButton");
					gameCondition = false;
					winning();
				}
				else if(t.isODWin(2, 0, person))
				{
//					b3.getStyleClass().add("winButton");
//					b5.getStyleClass().add("winButton");
//					b7.getStyleClass().add("winButton");
					gameCondition = false;
					winning();
				}
			    
			    if(t.isGameOver() && gameCondition == true)
				{
			    	draw();
				}
			    if(gameCondition != false)
			    {
			    	fillCom(t);
			    }
		}});
		b8 = new Button();
		b8.setText(" ");
		b8.getStyleClass().add("button");
		b8.setOnMousePressed(e->{
			b8.getStyleClass().add("press");
		});
		b8.setOnMouseReleased(e->{
			check = true;
			b8.getStyleClass().add("release");
			if(b8.getText() == " ")
			{   
				String person= "X";
				b8.setText(person);
				t.fillPlayer(person, 2, 1);
				
			    if(t.isHWin(2,person)){
//					b7.getStyleClass().add("winButton");
//					b8.getStyleClass().add("winButton");
//					b9.getStyleClass().add("winButton");
					gameCondition = false;
					winning();
				}
				else if(t.isVWin(1, person))
				{
//					b2.getStyleClass().add("winButton");
//					b5.getStyleClass().add("winButton");
//					b8.getStyleClass().add("winButton");
					gameCondition = false;
					winning();
				}
			    if(t.isGameOver() && gameCondition == true)
				{
			    	draw();
				}
			    if(gameCondition != false)
			    {
			    	fillCom(t);
			    }
			}});
		b9 = new Button();
		b9.setText(" ");
		b9.getStyleClass().add("button");
		b9.setOnMousePressed(e->{
			b9.getStyleClass().add("press");
		});
		b9.setOnMouseReleased(e->{
			check = true;
			b9.getStyleClass().add("release");
			if(b9.getText() == " ")
			{   
				String person= "X";
				b9.setText(person);
				t.fillPlayer(person, 2, 2);
				
			    if(t.isHWin(2,person)){
//					b7.getStyleClass().add("winButton");
//					b8.getStyleClass().add("winButton");
//					b9.getStyleClass().add("winButton");
					gameCondition = false;
					winning();
				}
				else if(t.isMDWin(2, 2, person))
				{
//					b1.getStyleClass().add("winButton");
//					b5.getStyleClass().add("winButton");
//					b9.getStyleClass().add("winButton");
					gameCondition = false;
					winning();
				}
				else if(t.isVWin(2, person))
				{
//					b3.getStyleClass().add("winButton");
//					b6.getStyleClass().add("winButton");
//					b9.getStyleClass().add("winButton");
					gameCondition = false;
					winning();
				}
			    if(t.isGameOver() && gameCondition == true)
				{
			    	draw();
				}
			    if(gameCondition != false)
			    {
			    	fillCom(t);
			    }
			
			}});
		b = new BorderPane();
		
	}
	public void createLayoutForMainPane()
	{
		gp = new GridPane();
		gp.add(b1, 0, 0);
		gp.add(b2, 1, 0);
		gp.add(b3, 2, 0);
		gp.add(b4, 0, 1);
		gp.add(b5, 1, 1);
		gp.add(b6, 2, 1);
		gp.add(b7, 0, 2);
		gp.add(b8, 1, 2);
		gp.add(b9, 2, 2);
		gp.setAlignment(Pos.CENTER);
		gp.setVgap(5);
		gp.setHgap(5);
		b.getStyleClass().add("border-pane");
		b.setCenter(gp);
	}

	public void start(Stage stage) throws Exception {
		s = stage;
		createNodesForMainPane();
		createLayoutForMainPane();
		Scene sc = new Scene(b,1300,700);
		URL url = this.getClass().getResource("TicTacToeUserInterface.css");
		sc.getStylesheets().add(url.toExternalForm());
		s.setScene(sc);
		s.setTitle("TicTacToe");
		s.show();
	}
	
	
public static void main(String[] args) {
		Application.launch(args);

	}

}
