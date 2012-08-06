/*
 * @author Mark Kiddo Jr.
 * CMPSC221 Assignment 5 Part 2
 * Completed 13 October 2009
 * Originally Compiled in Mac OS X 10.6.1 using NetBeans 6.7.1
 */
import javax.swing.*;

public class TestPokerGame {
    public static void main(String[] args) {
        int numberOfHands;  // number of hands to deal
        
        do{
        // Obtain the number of hands to deal
        numberOfHands = Integer.parseInt(JOptionPane.showInputDialog(
                "Please Input the Number of Hands to Deal:"));
        while (numberOfHands > 10){
            JOptionPane.showMessageDialog(null, "Invalid Entry! Please try again.");
            numberOfHands = Integer.parseInt(JOptionPane.showInputDialog(
                "Please Input the Number of Hands to Deal:"));
        }
        // Create an instance of PokerHandsFrame
        PokerHandsFrame ph = new PokerHandsFrame(numberOfHands);
        if(numberOfHands < 6) {
            // Set the size
            ph.setSize(400,(numberOfHands*140));
        }
        else {
            ph.setSize(800,700);
        }
        // Set Default Close Operation to exit on close
        ph.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Make Frame visible
        ph.setVisible(true);
        // Make Frame non-resizable
        ph.setResizable(false);
        // Continue while user selects yes
        }while(JOptionPane.showConfirmDialog(null, "Continue?")
                == JOptionPane.YES_OPTION);
    }
}
