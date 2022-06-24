package Hangman.src;

import javax.swing.*;

public class Main {

    public static final String WINDOW_TITLE = "Hangman";
    public static void main(String[] args) {
        Model model = new Model();

        HangmanController controll = new HangmanController(model);        

        JFrame frame = new JFrame(WINDOW_TITLE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        frame.setContentPane(model);

        frame.pack();
        frame.setVisible(true);
    }
    
}
