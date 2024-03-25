package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Random;
/**
 * Represent the logic part of Craps.
 *
 * @author An Ha
 * @version 3/15/2023
 */
public class Craps {
    /**
     * Notify the changes to the listeners.
     */
    PropertyChangeSupport changes = new PropertyChangeSupport(this);
    /**
     * Random object to generate the dices.
     */
    private static Random roller = new Random();
    /**
     * Dice 1 roll.
     */
    private int myDice1;
    /**
     * Dice 2 roll.
     */
    private int myDice2;
    /**
     * Total number roll of 2 dices.
     */
    private int myTotal;
    /**
     * Point on first roll.
     */
    private int myPoint;
    /**
     * Bank amount.
     */
    private int myBank;
    /**
     * Bet amount.
     */
    private int myBet;
    /**
     * Boolean if the game is active.
     */
    private boolean myGameActive;
    /**
     * Boolean if user won the game.
     */
    private boolean myGameWon;

    /**
     * Craps instance.
     */

    private static Craps myInstance = new Craps();

    /**
     * Start the game.
     */
    private Craps () {
        startGame();
    }

    /**
     * Get craps instance.
     * @return craps
     */
    public static Craps getInstance() { return myInstance; }

    /**
     * Start the game.
     */
    public void startGame() {
        setGameActive(true);
        setGameWon(false);
        setPoint(0);
    }

    /**
     * Set the game active or not active.
     * @param theGameActive pass in the boolean from the view.
     */
    public void setGameActive(final boolean theGameActive) {
        myGameActive = theGameActive;
        if (!myGameActive) {
            changes.firePropertyChange("active", null, false);
        }
    }

    /**
     * Set the game win or lose
     * @param theGameWon pass in boolean from the view
     */

    public void setGameWon(final boolean theGameWon) { myGameWon = theGameWon;}

    /**
     * Set the point for the game.
     * @param thePoint when roll the dice
     */
    public void setPoint(final int thePoint) { myPoint = thePoint;}

    /**
     * Total points of 2 dices each roll.
     * @param theTotal total points of dices
     */
    public void setTotal(final int theTotal) { myTotal = theTotal;   }

    /**
     * Display the point of game.
     * @return game point.
     */
    public int getPoint() { return myPoint;}

    /**
     * Display the total of the dices.
     * @return total number on dices
     */
    public int getMyTotal() { return myTotal;}

    /**
     * Display number on dice 1.
     * @return dice 1 value
     */
    public int getDice1() { return myDice1;}

    /**
     * Display number on dice 2
     * @return dice 2 value
     */
    public int getDice2() {return myDice2;}

    /**
     * Display whether the game is active
     * @return boolean active
     */
    public boolean getGameActive() {return myGameActive;}

    /**
     * Display whether the game won
     * @return boolean win or lose
     */
    public boolean getGameWon() {return myGameWon;}

    /**
     * Roll the dice for win or lose or points.
     */
    public void roll() {
        if (myGameActive) {
            myDice1 = roller.nextInt(6) + 1;
            myDice2 = roller.nextInt(6) + 1;
            setTotal(myDice1 + myDice2);
            if (myPoint == 0) {
                if (myTotal == 2 || myTotal == 3 || myTotal ==12) {
                    setGameWon(false);
                    setGameActive(false);
                } else if (myTotal == 7 || myTotal == 11) {
                    setGameWon(true);
                    setGameActive(false);
                } else {
                    setPoint(myTotal);
                }
            } else {
                if (myTotal == myPoint) {
                    setGameWon(true);
                    setGameActive(false);
                } else if (myTotal == 7) {
                    setGameWon(false);
                    setGameActive(false);
                }
            }
        }
    }

    /**
     * Set the bank amount
     * @param theBank enter by user
     */
    public void setBank(final int theBank) {
        if(theBank > 0) {
            myBank = theBank;
        } else {
            throw new IllegalArgumentException("Invalid amount");
        }
    }

    /**
     * Calculate the bank after winning or losing
     */
    public void calculateBank() {
        if(getGameWon()) {
            myBank += myBet;
        } else {
            myBank -= myBet;
        }
    }

    /**
     * Display the bank amount
     * @return the bank amount
     */
    public int getBank() {
        return myBank;
    }

    /**
     * Set the bet amount.
     * @param theBet from user's enter
     */
    public void setBet(final int theBet) {
        if (theBet <= myBank) {
            myBet = theBet;
        } else {
            throw new IllegalArgumentException("Invalid amount");
        }

    }

    /**
     * Display the bet amount
     * @return the bet
     */
    public int getBet() {
        return myBet;
    }

    /**
     * Register listener
     * @param listener
     */
    public void addPropertyChangeListener(PropertyChangeListener listener) {
         changes.addPropertyChangeListener(listener);
    }

    /**
     * Remove listener
     * @param listener
     */
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changes.removePropertyChangeListener(listener);
    }

}
