package view;

import model.Craps;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
/**
 * Represents the GUI part of the game and listeners.
 *
 * @author An Ha
 * @version 3/15/2023
 */
public class CrapsView extends JPanel implements PropertyChangeListener {
    /**
     * The roll button.
     */
    private JButton myRoll;
    /**
     * Dice 1 label.
     */
    private JLabel myDice1;
    /**
     * Dice 2 label.
     */
    private JLabel myDice2;
    /**
     * Total points when rolled.
     */
    private JLabel myTotal;
    /**
     * First point when rolled.
     */
    private JLabel myPoint;
    /**
     * Text field display number of wins for player.
     */
    private JTextField myPlayerField;
    /**
     * Text field display number of wins for the house.
     */
    private JTextField myHouseField;
    /**
     * Play again button.
     */
    private JButton myPlayAgain;
    /**
     * Menu bar.
     */
    private JMenuBar menu = new JMenuBar();
    /**
     * Menu item to start the game.
     */
    private JMenuItem myStart;
    /**
     * Menu item to reset the game.
     */
    private JMenuItem myReset;
    /**
     * Menu item to exit the game.
     */
    private JMenuItem myExit;
    /**
     * Menu item to display information.
     */
    private JMenuItem myAbout;
    /**
     * Menu item to display the rules.
     */
    private JMenuItem myRule;
    /**
     * Number of win player has.
     */
    private int myWin;
    /**
     * Number of win house has.
     */
    private int myHouseWin;
    /**
     * Button to set the bank.
     */
    private JButton mySetBank;
    /**
     * Button to set the bet.
     */
    private JButton mySetBet;
    /**
     * Text field to enter bank amount.
     */
    private JTextField myBank;
    /**
     * Text field to enter bet amount.
     */
    private JTextField myBet;
    /**
     * Label image of dice 1.
     */
    private JLabel myd1;
    /**
     * Label image of dice 2.
     */
    private JLabel myd2;

    /**
     * Constructor for CrapsView.
     * Panels locations within frame
     */

    public CrapsView() {
        setLayout(new BorderLayout());
        JPanel mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        mainPanel.setBackground(Color.PINK);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        mainPanel.add(diceRoll(), gbc);

        myRoll.setPreferredSize(new Dimension(100, 100));
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 0.5;
        gbc.weighty = 0.5;
        gbc.anchor = GridBagConstraints.CENTER;
        mainPanel.add(myRoll, gbc);

        myPoint.setPreferredSize(new Dimension(100, 100));
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        mainPanel.add(myPoint, gbc);

        gbc.gridx = 3;
        gbc.gridy = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        mainPanel.add(myTotal, gbc);



        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        mainPanel.add(dicePanel(), gbc);

        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        mainPanel.add(theBank(), gbc);


        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.weightx = 0.5;
        gbc.weighty = 0.5;
        gbc.anchor = GridBagConstraints.CENTER;
        mainPanel.add(theWin(), gbc);

        myPlayAgain.setSize(150, 150);
        gbc.gridx = 3;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 0.5;
        gbc.weighty = 0.5;
        gbc.anchor = GridBagConstraints.SOUTHWEST;
        mainPanel.add(myPlayAgain, gbc);

        add(mainPanel, BorderLayout.CENTER);
        addListeners();


    }

    /**
     * Win panel display house and player win rounds.
     * @return panel of winning information
     */

    public JPanel theWin() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setPreferredSize(new Dimension(150, 150));
        JLabel myPlayerWin = new JLabel("Player Win Total");
        myPlayerField = new JTextField(5);
        JLabel myHouseWin = new JLabel("House Win Total");
        myHouseField = new JTextField(5);
        myHouseField.setEditable(false);
        myPlayerField.setEditable(false);
        panel.add(myPlayerWin);
        panel.add(myPlayerField);
        panel.add(myHouseWin);
        panel.add(myHouseField);
        return panel;
    }

    /**
     * Bank panel to set bank and bet amount.
     * @return bank panel
     */

    public JPanel theBank() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setPreferredSize(new Dimension(150, 150));
        panel.setBackground(Color.PINK);
        panel.setBorder(BorderFactory.createTitledBorder("Bank"));
        myBank = new JTextField();
        mySetBank = new JButton("Set Bank");
        myBet = new JTextField();
        mySetBet = new JButton("Set Bet");
        panel.add(myBank);
        panel.add(mySetBank);
        panel.add(myBet);
        panel.add(mySetBet);
        return panel;


    }


    /**
     * Dice panel display dice number in text when roll.
     * @return panel of dice information
     */
    public JPanel diceRoll() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createTitledBorder("Current Roll Dice"));
        panel.setPreferredSize(new Dimension(150, 150));
        myRoll = new JButton("Roll Dice");
        myRoll.setMnemonic('r');
        myPlayAgain = new JButton("Play Again");
        myPlayAgain.setMnemonic('p');
        myDice1 = new JLabel("Dice 1");
        myDice1.setSize(15, 15);
        myDice2 = new JLabel("Dice 2");
        myDice2.setSize(15, 15);
        myTotal = new JLabel("Dice total:");
        myPoint = new JLabel("Point");
        panel.add(myDice1);
        panel.add(myDice2);
        return panel;
    }

    /**
     * Dice panel for image of dices.
     * @return dice image panel
     */
    public JPanel dicePanel() {
        JPanel dicePanel = new JPanel();
        myd1 = new JLabel();
        myd1.setSize(150,150);
        myd2 = new JLabel();
        myd2.setSize(150,150);
        setDiceValues(1, 6);
        dicePanel.add(myd1);
        dicePanel.add(myd2);
        return dicePanel;

    }

    /**
     * Set dices image according to dice number.
     * @param value1 dice 1 value
     * @param value2 dice 2 value
     */
    public void setDiceValues(int value1, int value2) {
        ImageIcon icon1 = new ImageIcon("image/dice" + value1 + ".png");
        Image image1 = icon1.getImage().getScaledInstance(myd1.getWidth(), myd1.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon icon2 = new ImageIcon("image/dice" + value2 + ".png");
        Image image2 = icon2.getImage().getScaledInstance(myd2.getWidth(), myd2.getHeight(), Image.SCALE_SMOOTH);
        myd1.setIcon(new ImageIcon(image1));
        myd2.setIcon(new ImageIcon(image2));
    }

    /**
     * Menu bar and shortcut keys.
     * @return JMenuBar for craps
     */
    public JMenuBar createMenuBar() {
        JMenu myGameMenu = new JMenu("Game");
        JMenu myHelpMenu = new JMenu("Help");
        myStart = new JMenuItem("Start");
        myStart.setMnemonic(KeyEvent.VK_S);
        myReset = new JMenuItem("Reset");
        myReset.setMnemonic(KeyEvent.VK_R);
        myExit = new JMenuItem("Exit");
        myExit.setMnemonic(KeyEvent.VK_E);
        myAbout = new JMenuItem("About");
        myAbout.setMnemonic(KeyEvent.VK_R);
        myRule = new JMenuItem("Rule");
        myReset.setMnemonic(KeyEvent.VK_U);

        myGameMenu.add(myStart);
        myGameMenu.add(myReset);
        myGameMenu.add(myExit);
        myHelpMenu.add(myAbout);
        myHelpMenu.add(myRule);
        menu.add(myGameMenu);
        menu.add(myHelpMenu);
        menuAddListeners();
        return menu;
    }


    /**
     * Add listeners for the menu items.
     */
    private void menuAddListeners() {
        Craps craps = model.Craps.getInstance();
        myReset.setEnabled(false);

        myStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                craps.startGame();
                myDice1.setText("Dice 1");
                myDice2.setText("Dice 2");
                myPoint.setText("Point");
                myTotal.setText("Total");

                myStart.setEnabled(false);
                myBank.setEditable(true);
                mySetBank.setEnabled(true);
                myReset.setEnabled(true);
                JOptionPane.showMessageDialog(null,
                        "Please set your bank amount before playing");
            }
        });
        myAbout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Name: AN HA\n" +
                        "Version: Winter 2023\n" +
                        "Java 19" );
            }
        });
        myRule.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,
                        "Pass line bet wins on a 7 or 11, loses on a 2, 3, or 12\n " +
                        " on the first roll. On other rolls, the bet wins if \n" +
                        " the shooter rolls the point before rolling a 7,\n" +
                        " and loses if a 7 is rolled before the point.");
            }
        });

        myExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int result = JOptionPane.showConfirmDialog(null,
                        "Do you want to exit the game ?", "Exit",
                        JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }


            }
        });

        myReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reset();
                JOptionPane.showMessageDialog(null, "Press Start to play");
            }
        });

    }

    /**
     * Action method to reset the game when reset button hit.
     */

    private void reset() {
        myWin = 0;
        myPlayerField.setText(String.valueOf(myWin));
        myHouseWin = 0;
        myHouseField.setText(String.valueOf(myHouseWin));
        myBet.setText("");
        myBank.setText("");
        myBank.setEditable(false);
        myBet.setEditable(false);
        mySetBank.setEnabled(false);
        mySetBet.setEnabled(false);
        myStart.setEnabled(true);
        myPlayAgain.setEnabled(false);
        myReset.setEnabled(false);
    }

    /**
     * Add listeners for buttons in the game.
     */
    private void addListeners() {
        Craps craps = model.Craps.getInstance();

        myRoll.setEnabled(false);
        myPlayAgain.setEnabled(false);
        myBank.setEditable(false);
        mySetBank.setEnabled(false);
        myBet.setEditable(false);
        mySetBet.setEnabled(false);

        myRoll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (craps.getGameActive()) {
                    craps.roll();
                    myDice1.setText("Dice 1: " + craps.getDice1());
                    myDice2.setText("Dice 2: " + craps.getDice2());
                    myTotal.setText("Total: " + craps.getMyTotal());
                    setDiceValues(craps.getDice1(), craps.getDice2());
                    if (craps.getPoint() != 0) {
                        myPoint.setText("Point: " + craps.getPoint());
                    } else {
                        myPoint.setText("Point: ");
                    }
                    if (!craps.getGameActive()) {
                        if(craps.getGameWon()) {
                            JOptionPane.showMessageDialog(null, "Winner ");
                            myWin++;
                            myPlayerField.setText(String.valueOf(myWin));
                        } else {
                            JOptionPane.showMessageDialog(null, "Better luck next time");
                            myHouseWin++;
                            myHouseField.setText(String.valueOf(myHouseWin));
                        }
                        craps.calculateBank();
                        if(craps.getBank() == 0) {
                            JOptionPane.showMessageDialog(null, "Game is over! " +
                                    "Press Start to play again");
                            reset();

                        }
                        myBank.setText(String.valueOf(craps.getBank()));
                        craps.setBank(Integer.valueOf(myBank.getText()));
                        myPlayAgain.setEnabled(true);

                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Game not active!");
                }
            }
        });

        myPlayAgain.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                craps.startGame();
                myBet.setText("");
                myBet.setEditable(true);
                mySetBet.setEnabled(true);
                myPlayAgain.setEnabled(false);

            }
        });

        myBank.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               setBank(craps);
            }
        });

        myBet.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setBet(craps);
            }
        });
        mySetBank.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setBank(craps);
            }
        });

        mySetBet.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setBet(craps);
            }
        });
    }

    /**
     * Method to set the bank from player's information.
     * @param craps instance of craps created
     */
    private void setBank(Craps craps) {

        try {
            craps.setBank(Integer.valueOf(myBank.getText()));
            if (Integer.valueOf(myBank.getText()) <= 0 ) {
                throw new Exception("Invalid amount");
            }
            myBank.setEditable(false);
            mySetBank.setEnabled(false);
            myBet.setEditable(true);
            mySetBet.setEnabled(true);
        } catch (final Exception ex) {
            JOptionPane.showMessageDialog(null, "Please enter a valid number");
        }

    }

    /**
     * Method to set the bet from player's information.
     * @param craps
     */
    private void setBet(Craps craps) {
        try {

            craps.setBet(Integer.valueOf(myBet.getText()));
            if (Integer.valueOf(myBet.getText()) > Integer.valueOf(myBank.getText()) ||
                    Integer.valueOf(myBet.getText()) <= 0 ) {
                throw new Exception("Invalid amount");
            }
            myBank.setText(String.valueOf(craps.getBank() - craps.getBet()));
            myBet.setEditable(false);
            mySetBet.setEnabled(false);
            myRoll.setEnabled(true);
        } catch (final Exception ex) {
            JOptionPane.showMessageDialog(null, "Please enter a valid amount");

        }

    }

    /**
     * Action when a registered change happen.
     * @param evt A PropertyChangeEvent object describing the event source
     *          and the property that has changed.
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName() == "active")
        if ((boolean)evt.getNewValue() == false) {
            myRoll.setEnabled(false);
            JOptionPane.showMessageDialog(null, "Game not active");
        }
    }
}
