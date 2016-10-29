package com.draumateymid.tictactoe;

import java.io.IOException;
/**
 * ##Display Game Board Class
 * 
 * @author Draumateymið
 * Date created: 27.10.2016
 * 
 * Prints out a given game status for the game TicTacToe.
 *
 */
public class DisplayGameBoard {
	
	/**
	 * Constructor that prints out the initial, empty board.
	 * @param board
	 */
	public DisplayGameBoard(char[] board){
		checkInput(board);
		displayTicTac(board);
	}
	/**
	 * Private function that checks whether parameter board is valid for the game.
	 * Throws exception if board is not valid.
	 * @param board
	 */
	private static void checkInput(char[] board){
		if(board == null){
			throw new IllegalArgumentException("Board cannot be null");
		}
		if(board.length != 9){
			throw new IllegalArgumentException("Board is of the wrong size");
		}
		for(int i = 0; i < board.length; i++){
			if(board[i] == 'O' || board[i] == 'X' || board[i] == ' '){
				continue;
			}
			else{
				throw new IllegalArgumentException("Illegal input in board");
			}
		}
	}
	/**
	 * Public void function that displays the current game status for a given input.
	 * @param board
	 */
	public static void displayTicTac(char[] board){
		checkInput(board);
		System.out.print(stringBuilder(board));
	}
	
	public static String stringBuilder(char[] board){
		checkInput(board);
		String s = "";
		s += " " + board[0] + " | " + board[1] + " | " + board[2] + " \n";
		s += "---+---+---\n";
		s += " " + board[3] + " | " + board[4] + " | " + board[5] + " \n";
		s += "---+---+---\n";
		s += " " + board[6] + " | " + board[7] + " | " + board[8] + " \n";
		return s;
	}
	
	public static void inputMessage(char c){
		System.out.println(inputString(c));
	}
	
	public static String inputString(char c){
		String s = "Player " + c + " turn,  select position, 1-3 is top row, 4 - 6 is center row and 7 - 9 is bottom row";
		return s;
	}
	
	public static void invalidInputMessage(){
		System.out.print(invalidInputString());
	}
	
	public static String invalidInputString(){
		String s = "Value entered is not valid please try again: ";
		return s;	
	}
	
	public static void fullFieldMessage(){
		System.out.print(fullFieldString());
	}
	
	public static String fullFieldString(){
		String s = "Field is not empty, please try again: ";
		return s;	
	}
	
	public static void makeWinner(char player){
		System.out.println(makeWinnerString(player));
	}
	
	/** 	
	 * 
	 * This method returns a string, congratulating the winner 	
	 * 
	 * 	
	 * @param player 	
	 */ 	
	public static String makeWinnerString(char player){ 
		if(player != 'X' && player != 'O'){
			throw new IllegalArgumentException("Player has to be either 'X' or 'O'!");
		}
		String s = "Congratulations! Player " + player + " is the Winner!"; 		
		return s; 	
		}
}
