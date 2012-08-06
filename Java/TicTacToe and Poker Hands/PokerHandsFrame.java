/*
 * @author Mark Kiddo Jr.
 * CMPSC221 Assignment 5 Part 2
 * Completed 13 October 2009
 * Originally Compiled in Mac OS X 10.6.1 using NetBeans 6.7.1
 * Some logical assistance from Chris Shumaker
 */
import java.awt.*;
import java.util.Random;
import javax.swing.*;

public class PokerHandsFrame extends JFrame {
    private int numHands;                       // create a variable for number of hands
    private PokerHandPanel dealt[];             // create an array of hands dealt
    private final int sizeOfHand = 5;           // create a variable for size of hand
    private final int cardsInDeck = 54;         // create a variable for size of deck
    private int dealtHandsIter;                 // keep track of hands dealt
    private int deck[] = new int [cardsInDeck]; // create a deck of 54 cards

    public PokerHandsFrame() {
        for(int i = 0; i < cardsInDeck; i++) 
            deck[i] = i+1;                      // initialize the deck
        
        dealtHandsIter = 0;                     // initialize hands dealt thusfar
        numHands = 1;                           // set dealt number of hands
        dealt = new PokerHandPanel[1];
        setLayout(new GridLayout(numHands,1,3,3));// create a grid layout
        dealHand();                             // deal a hand
        showHands();                            // show the hand
        
    }

    public PokerHandsFrame(int numHands) {
        for(int i = 0; i < cardsInDeck; i++)
            deck[i] = i+1;                      // initialize the deck
        dealtHandsIter = 0;                     // initialize hands dealt thusfar
        this.numHands = numHands;               // set dealt number of hands
        dealt = new PokerHandPanel[numHands];   // resize array for number of hands dealt
        if(numHands < 6)
            setLayout(new GridLayout(numHands,1,3,3));  // create a grid layout
        else
            setLayout(new GridLayout(5,2,3,3));
        for(int i = 0; i < numHands; i++)       // deal the hands
            dealHand();
        showHands();                            // show hands
    }

    protected void dealHand() {
        dealt[dealtHandsIter] = new PokerHandPanel();   // deal a hand
        dealtHandsIter++;                               // and increment the iterator
    }

    protected void showHands() {
        for (int i = 0; i < numHands; i++)
            add(dealt[i]);                      // add each hand to layout
        
    }

    class PokerHandPanel extends JPanel {
        private int dealtOfSize;                // number of cards of total so far
        private int hand[];                     // holds a hand of cards
        private String handImage[];             // holds the src path for card img

        PokerHandPanel() {
            setLayout(new GridLayout(1, sizeOfHand));   // set up grid layout
            dealtOfSize = 0;                            // initialize iterator
            hand = new int[sizeOfHand];                 // resize for number of cards
            handImage = new String[sizeOfHand];         // '                         '
            for (int i = 0; i < sizeOfHand; i++){
                addCard();                              // fill the hand
            }
            for(int i = 0; i < sizeOfHand; i++)         // fill the array of images
                add(new JLabel(new ImageIcon(handImage[i])));

        }

        protected void addCard() {
            Random cardGen = new Random();                  // make a card generator
            boolean gotCard = false;                        // set got card to false
            while (!gotCard && dealtOfSize < sizeOfHand) {  // while it still hasnt
                                                            // found an unused card
                int selectCard = cardGen.nextInt(54);       // select a card
                boolean used = false;                       // set used card to false
                for (int i = 0; i < sizeOfHand; i++)        // search for selected card
                    if (hand[i] == selectCard) used = true; // if found set used to true
                if (!used && deck[selectCard] != -1) {
                    handImage[dealtOfSize] = new String("src/image/card/"
                            + selectCard + ".png");         // otherwise add its src
                                                            // path to the array
                    hand[dealtOfSize] = selectCard;         // and keep track of it
                    gotCard = true;                         // set gotCard to true
                    deck[selectCard] = -1;                  // mark in the deck as used
                    dealtOfSize++;                          // increment iterator
                }
            }
        }
    }
}