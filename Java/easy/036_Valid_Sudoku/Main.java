/*
 * Copyright 2016 Yuanjie
 */
package pkg036_valid_sudoku;

import java.util.HashMap;

/*
Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
http://sudoku.com.au/TheRules.aspx
The Sudoku board could be partially filled, where empty cells are filled with
the character '.'.


A partially filled sudoku which is valid.

Note:
A valid Sudoku board (partially filled) is not necessarily solvable. 
 Only the filled cells need to be validated.
https://leetcode.com/problems/valid-sudoku/


[".87654321","2........","3........","4........","5........","6........","7........","8........","9........"]
["..4...63.",".........","5......9.","...56....","4.3.....1","...7.....","...5.....",".........","........."]



 */
public class Main {
    public static boolean isValid(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            HashMap mapRow = new HashMap();
            HashMap mapCol = new HashMap();
            HashMap mapS = new HashMap();
            
            for (int j = 0; j < board.length; j++) {
                // row
                if (board[i][j] != '.') {
                    if (mapRow.put(board[i][j], j) != null) {
                        return false;
                    }
                }
                
                // col
                if (board[j][i] != '.') { 
                    if (mapCol.put(board[j][i], j) != null) {
                        return false;
                    }
                }
                
                // S block
                if (board[i/3*3 + j/3][i%3*3 + j%3] != '.') {
                    if (mapS.put(board[i/3*3 + j/3][i%3*3 + j%3], j) != null) {
                        return false;
                    }
                }
            }
            
            
        }
        
        
        return true;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        char[][] board = {
                          {'.', '.', '4', '.', '.', '.', '6', '3', '.'}, 
                          {'.', '.', '.', '.', '.', '.', '.', '.', '.'}, 
                          {'5', '.', '.', '.', '.', '.', '.', '9', '.'}, 
                          {'.', '.', '.', '5', '6', '.', '.', '.', '.'}, 
                          {'4', '.', '3', '.', '.', '.', '.', '.', '1'}, 
                          {'.', '.', '.', '7', '.', '.', '.', '.', '.'}, 
                          {'.', '.', '.', '5', '.', '.', '.', '.', '.'}, 
                          {'.', '.', '.', '.', '.', '.', '.', '.', '.'}, 
                          {'.', '.', '.', '.', '.', '.', '.', '.', '.'}
                        };

        char[][] board1 = {
                          {'.', '8', '7', '6', '5', '4', '3', '2', '1'}, 
                          {'2', '.', '.', '.', '.', '.', '.', '.', '.'}, 
                          {'3', '.', '.', '.', '.', '.', '.', '.', '.'}, 
                          {'4', '.', '.', '.', '.', '.', '.', '.', '.'}, 
                          {'5', '.', '.', '.', '.', '.', '.', '.', '.'}, 
                          {'6', '.', '.', '.', '.', '.', '.', '.', '.'}, 
                          {'7', '.', '.', '.', '.', '.', '.', '.', '.'}, 
                          {'8', '.', '.', '.', '.', '.', '.', '.', '.'}, 
                          {'9', '.', '.', '.', '.', '.', '.', '.', '.'}
                        };
        
        System.out.println(isValid(board));
        
        System.out.println(isValid(board1));

    }
    
}
