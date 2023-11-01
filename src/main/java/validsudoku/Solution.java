package validsudoku;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;


public class Solution {

    private enum BlockType {ROW, COL, SQUARE};

    public boolean isValidSudoku(char[][] board) {

        for(int i = 0; i < 9; i++)
        {
            for(BlockType blockType: BlockType.values()) {
                if (!isBlockCorrect(getBlock(blockType, i, board)))
                    return false;
            }
        }
        return true;
    }

    private static char[] getBlock(BlockType blockType, int index, char[][] board)
    {
        char[] emptyRes = {};

        switch (blockType) {

        case ROW -> {
            return new String(board[index]).replaceAll("\\.", "").toCharArray();
        }
        case COL -> {
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < 9; i++)
            {
                sb.append(board[i][index] == '.' ? "" : board[i][index]);
            }
            return sb.toString().toCharArray();
        }
        case SQUARE -> {
            StringBuilder sb = new StringBuilder();
            int iMin = 0, iMax = 3, jMin = 0, jMax = 3;
            switch (index) {
                case 1 -> {iMin = 3; iMax = 6;}
                case 2 -> {iMin = 6; iMax = 9;}
                case 3 -> {jMin = 3; jMax = 6;}
                case 4 -> {iMin = 3; iMax = 6; jMin = 3; jMax = 6;}
                case 5 -> {iMin = 6; iMax = 9; jMin = 3; jMax = 6;}
                case 6 -> {jMin = 6; jMax = 9;}
                case 7 -> {iMin = 3; iMax = 6; jMin = 6; jMax = 9;}
                case 8 -> {iMin = 6; iMax = 9; jMin = 6; jMax = 9;}

            }
            for(int i = iMin; i < iMax; i++)
                for(int j = jMin; j < jMax; j++)
                {
                    sb.append(board[i][j] == '.' ? "" : board[i][j]);
                }
            return sb.toString().toCharArray();
        }
        default -> {return emptyRes;}}
    }

    private static boolean isBlockCorrect(char[] block)
    {
        Set<Character> uniqueChars = new HashSet<>();
        for(char c: block)
        {
            if(!uniqueChars.add((Character) c))
                return false;
        }
        return true;
    }




    @Test
    public void test1()
    {
        char[][] board = {{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};

        assertEquals(true, isValidSudoku(board));
    }

    @Test
    public void test2()
    {
        char[][] board = {{'8','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};

        assertEquals(false, isValidSudoku(board));
    }

    @Test
    public void test3()
    {
        char[][] board = {{'5','3','.','.','7','.','1','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};

        assertEquals(true, isValidSudoku(board));
    }

    @Test
    public void test4()
    {
        char[][] board = {{'8','3','.','.','7','.','.','.','9'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};

        assertEquals(false, isValidSudoku(board));
    }
}
