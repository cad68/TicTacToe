package com.draumateymid.tictactoe;

public class GameStatus{
	public static boolean isEmpty(char[] board, int input){
		if(board[input-1] == ' ')
				return true; 
		else
			return false; 	
	}

	public static boolean checkWinnerHorizontal(char[] board){
		for(int i = 0; i < 9; i += 3){
			if(board[i] == board[i+1] && board[i+1] == board[i+2] && board[i] != ' ')
					return true;
		}
		return false; 
	}

	public static boolean checkWinnerVertical(char[] board){
		for(int i = 0; i < 3; i++){
			if(board[i] == board[i+3] && board[i+3] == board[i+6] && board[i] != ' ')
				return true; 
		}
		return false; 
	}

	public static boolean checkWinnerDiagonal(char[] board){
		if(board[0] == board[4] && board[4] == board[8] && board[0] != ' ')
			return true; 
		if(board[2] == board[4] && board[4] == board[6] && board[0] != ' ')
			return true; 
		return false; 
	}

	public static boolean checkWinner(char[] board){
		if(checkWinnerVertical(board) || checkWinnerDiagonal(board) || checkWinnerHorizontal(board))
			return true;
		return false; 
	}

	public static boolean draw(char[] board){
		int count = 0; 
		for(int i = 0; i < 9; i++){
			if(board[i] == 'X')
				count++; 
		}
		if(count == 5)
			return true; 
		else 
			return false; 
	}

	public static boolean gameIsOver(char[] board){
		if(checkWinner(board) || draw(board))
			return true; 
		else 
			return false; 
	}
}