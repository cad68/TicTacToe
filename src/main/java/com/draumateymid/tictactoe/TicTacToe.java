package com.draumateymid.tictactoe;

import spark.*;
import static spark.Spark.*;
import spark.servlet.SparkApplication;

public class TicTacToeWeb implements SparkApplication {
	
	private static GameController controller = new GameController();
	
	public static void main(String [] args)
	{
		staticFileLocation("/public");
        SparkApplication TicTacToeWeb = new TicTacToeWeb();
		
		String port = System.getenv("PORT");
        if (port != null) {
            port(Integer.valueOf(port));
        }
		
		TicTacToeWeb.init();
	}
	
	@Override
    public void init() {   
        get("/random", (req, res) -> "Some string");
        get("/id", (req, res) -> "Some string");
		post("/tictactoe", (req, res) -> 

			{ 
				return controller.makeMove((String) req.queryParams("name"));
			}
		);
		post("/winner", (req, res) ->  "");
    }

}











/****************************
package com.draumateymid.tictactoe;

import java.io.InputStream; 
import java.util.Scanner; 
import java.io.Console; 
import java.io.*; 

/**
*##TicTacToe class
*
*This class handles the main method of the game
*@author Draumateymid
*Date created 23.10.2016
*
*/


/**********************************
public class TicTacToe {

	public static void main(String[] args) {
		GameRunner runner = new GameRunner();	
		Scanner userInput = new Scanner(System.in);
		char marker = ' '; 
		int input = -1; 

		while(!GameStatus.gameIsOver(runner.getBoard())) { 

			marker = runner.switchUser(marker); 

			DisplayGameBoard.inputMessage(marker);

			input = getUserInput(userInput);

			while(!runner.isEmpty(input)) {
				DisplayGameBoard.fullFieldMessage(); 
				input = getUserInput(userInput);
			}
			
			runner.movePlayer(marker, input);

			DisplayGameBoard.displayTicTac(runner.getBoard());

			if(GameStatus.checkWinner(runner.getBoard())) {
				DisplayGameBoard.makeWinner(marker);
   				break;
			}
   				
			if(GameStatus.draw(runner.getBoard())) {
				DisplayGameBoard.makeDraw();
				break;
			}

		}
		userInput.close(); 		
	}

	private static int getUserInput(Scanner userInput){
		int input = userInput.nextInt();
		
		while (input < 1  || input > 9){
			DisplayGameBoard.invalidInputMessage();
			input = userInput.nextInt(); 
		}
		return input;
	}
}

*/
