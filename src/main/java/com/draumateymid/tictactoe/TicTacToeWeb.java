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









