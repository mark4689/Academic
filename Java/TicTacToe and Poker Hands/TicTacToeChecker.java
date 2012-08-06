/*
 * @author Mark Kiddo Jr.
 * CMPSC221 Assignment 5 Part 1
 * Completed 13 October 2009
 * Originally Compiled in Windows XP SP3 using NetBeans 6.5
 * Some logical assistance from Chris Shumaker
 */
import java.awt.*;
import java.util.Random;
import javax.swing.*;

public class TicTacToeChecker extends JFrame {
    private ImageIcon x = new ImageIcon("src/TicTacToe/x.png");       //image of x
    private ImageIcon o = new ImageIcon("src/TicTacToe/o.png");       //image of o
    private ImageIcon empty = new ImageIcon("src/TicTacToe/e.png");   //empty cell
    private int[] trace = new int[9];   //array to symbolize board
    private Random XOGen = new Random();//generator to generate index

    public TicTacToeChecker() {
        setLayout(new BorderLayout());              //create a bordered layout
        add(gameTable(), BorderLayout.CENTER);      //add gameTable to center
        add(winnerMessage(), BorderLayout.SOUTH);   //add winnerMessage to bottom
    }

    public JPanel gameTable() {
        JPanel game = new JPanel(new GridLayout(3, 3)); //create a new grid layout
        
        for (int i = 0; i < 9; i++)         //initialize the array to -1
            trace[i]=-1;
        
        int rand;
        boolean isSet;
        //play the game
        for(int i = 0; i < 9; i++){         //place x's and o's
            isSet=false;                    //reset isSet to false
            while(isSet==false){            //while the x/o hasnt been set
                rand = XOGen.nextInt(9);    //generate a random index
                if(trace[rand] < 0){        //if the index is empty
                    if(i==0){               //and this is the first traversal
                        trace[rand] = 3;    //place an empty spot
                        isSet=true;         //break out of while
                    }
                    else if((i%2)==0){      //otherwise if this is an even trav.
                        trace[rand] = 1;    //place an x
                        isSet=true;         //break out of while
                    }
                    else{
                    trace[rand] = 2;        //otherwise place an o
                    isSet=true;             //break out of while
                    }
                }
            }
        }
        //display the game board
        for(int i = 0; i < 9; i++){         //traverse through the array and
            if(trace[i] == 1)               //display what is on the board
                game.add(new JLabel(x));
            else if(trace[i] == 2)
                game.add(new JLabel(o));
            else
                game.add(new JLabel(empty));
        }

        return game;                        //return the JPanel

    }

    public JLabel winnerMessage() {
        StringBuffer message = new StringBuffer();
        String  stringArr[] = {"Both Win!","X's Win!","O's Win!"};
        
        //test to see which won and append it to message
        if(takesRow(trace) >= 0)
            message.append(stringArr[takesRow(trace)]);
        else if(takesCol(trace) >= 0)
            message.append(stringArr[takesCol(trace)]);
        else if(takesLeftDiagnal(trace) >= 0)
            message.append(stringArr[takesLeftDiagnal(trace)]);
        else if(takesRightDiagnal(trace) >= 0)
            message.append(stringArr[takesRightDiagnal(trace)]);
        else if(takesCorners(trace) >= 0)
            message.append(stringArr[takesCorners(trace)]);
        else
            message.append("Niether Wins!");

        //return a JLabel of the winner
        return new JLabel(message.toString(), JLabel.CENTER);
    }

    public int takesRow(int[] intArray) {
        //@param: int[] intArray, an array of ints (the trace of the tictactoe board
        //@return int: an integer from -1,0,1,2
        //-1 = niether wins, 0 = both win, 1 = X's win, 2 = O's win
        int winner = 0;
        for (int i = 0; i < 3; i++) {
            //go through each row and see if theres a winner
            if (intArray[3*i] == intArray[3*i + 1]
                    && intArray[3*i + 1] == intArray[3*i + 2]) {
                winner += intArray[3*i];//if so add its value to winner
            }
        }
        if (winner == 1) return 1;      //if winner is 1 x wins
        else if (winner == 2) return 2; //if winner is 2 o wins
        else if (winner == 3) return 0; //if winner is 3 both win
        else return -1;                 //otherwise neither win the row
    }

    public int takesCol(int[] intArray) {
        //@param int[] intArray, an array of ints (the trace of the tictactoe board
        //@return int, an integer from -1,0,1,2
        //-1 = niether wins, 0 = both win, 1 = X's win, 2 = O's win
        int winner = 0;
        for (int i = 0; i < 3; i++) {
            //go through each column and see if theres a winner
            if (intArray[i] == intArray[i + 3] 
                    && intArray[i + 3] == intArray[i + 6]) {
                winner += intArray[i];//if so add its value to winner
            }
        }
        if (winner == 1) return 1;      //if winner is 1 x wins
        else if (winner == 2) return 2; //if winner is 2 o wins
        else if (winner == 3) return 0; //if winner is 3 both win
        return -1;                      //otherwise neither win the column
   }

    public int takesLeftDiagnal(int [] intArray){
        //@param int[] intArray, an array of ints (the trace of the tictactoe board
        //@return int, an integer from -1,1,2
        //-1 = niether wins, 1 = X's win, 2 = O's win
        if(intArray[0] == intArray[4]
                && intArray[4] == intArray[8]){
            //if the 0th,4th,and 8th indexes are the same return the winner
            return intArray[0];
        }
        return -1;                      //otherwise no left diagnal winner
    }
    
    public int takesRightDiagnal(int [] intArray){
        //@param int[] intArray, an array of ints (the trace of the tictactoe board
        //@return int, an integer from -1,1,2
        //-1 = niether wins, 1 = X's win, 2 = O's win
        if(intArray[2] == intArray[4]
                && intArray[4] == intArray[6]){
            //if the 2nd,4th,and 6th indexes are the same return the winner
            return intArray[2];
        }
        return -1;                      //otherwise no right diagnal winner
    }
    
    public int takesCorners(int [] intArray){
        //@param int[] intArray, an array of ints (the trace of the tictactoe board
        //@return int, an integer from -1,0,1,2
        //-1 = niether wins, 1 = X's win, 2 = O's win
        if(intArray[0] == intArray[2] && intArray[6] == intArray[8] 
                && intArray[2] == intArray[6]){
            //if the 0th,2nd,6th,and 8th indexes are the same return the winner
            return intArray[0];
        }
        return -1;                      //otherwise no corners winner
    }

    public static void main(String[] args) {
        //create a new TicTacToeChecker instance
        TicTacToeChecker check = new TicTacToeChecker();
        //set title of JFrame
        check.setTitle("TicTacToe");
        //set size of JFrame
        check.setSize(190, 210);
        //disable resizing to keep format in tact
        check.setResizable(false);
        //set the location
        check.setLocationRelativeTo(null);
        //set the program to exit on close
        check.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //make JFrame visible
        check.setVisible(true);
    }
}
