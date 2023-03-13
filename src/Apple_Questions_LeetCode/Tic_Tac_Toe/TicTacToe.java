package Apple_Questions_LeetCode.Tic_Tac_Toe;

class TicTacToe {
    char[][] board;
    int length;

    public TicTacToe(int n) {
        length = n;
        board = new char[n][n];
    }

    public int move(int row, int col, int player) {
        if (player == 1) {
            board[row][col] = 'X';
        } else {
            board[row][col] = 'O';
        }

        // check win condition
        if (checkWin(player, row, col)) {
            return player;
        } else {
            return 0;
        }
    }


    public boolean checkWin(int player, int row, int col) {
        char playerChar = (player == 1) ? 'X' : 'O';

        // check row
        boolean win = true;
        for(int c = 0; c < length; c++){
            if(board[row][c] != playerChar){
                win = false;
                break;
            }
        }
        if(win){
            return true;
        }

        // check col
        win = true;
        for(int r = 0; r < length; r++){
            if(board[r][col] != playerChar){
                win = false;
                break;
            }
        }
        if(win) {
            return true;
        }

        // check diagonal

        if(row == col){
            win = true;
            for(int i = 0; i < length; i++){
                if(board[i][i] != playerChar){
                    win = false;
                    break;
                }
            }
        }
        if(win) {
            return true;
        }


        // check anti-diagonal

        if(row + col == length - 1){
            win = true;
            for(int i = 0; i < length; i++){
                if(board[length - i - 1][i] != playerChar){
                    win = false;
                    break;
                }
            }
        }
        return win;
    }
}
/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */
