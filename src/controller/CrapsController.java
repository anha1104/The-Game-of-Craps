package controller;

import model.Craps;
import view.CrapsView;
import javax.swing.JFrame;
import java.awt.*;
/**
 * Represents the controller which connects the model and view of Craps
 *
 * @author An Ha
 * @version 3/15/2023
 */
public class CrapsController {
    /**
     * Main method to run the game.
     * @param theArgs
     */
    public static void main(final String[] theArgs) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                final CrapsView mainPanel =  new CrapsView();
                final Dimension frameSize = new Dimension(400, 500);
                Craps.getInstance().addPropertyChangeListener(mainPanel);
                final JFrame window = new JFrame("The Game of Craps");
                window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                window.setContentPane(mainPanel);
                window.setJMenuBar(mainPanel.createMenuBar());
                window.pack();
                window.setSize(frameSize);
                window.setVisible(true);

            }
        });
    }
}
