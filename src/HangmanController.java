package Hangman.src;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class HangmanController implements java.awt.event.KeyListener{
    /**
     * states
     * 0 => active game
     * 1 => win
     * 2 => loose
     */


    Model model;
    int state = 0;

    public HangmanController(Model model){
        this.model = model;

        model.addKeyListener(this);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        //keycode of keyboard press
        int keyCode = e.getKeyCode();

        //arraylist of the characters in the word to guess
        ArrayList<Character> wordInChar = model.hangman.convertToCharArray();

        int countWrong = 0;
        int countRight = 0;
        
        //lopping thru word to see if the key pressed matches a character in the word
        for (int i = 0; i < wordInChar.size(); i++) {
            if(keyCode == wordInChar.get(i)){
                System.out.println("correct");

                model.repaint();
                model.hangman.changeViewWord( wordInChar.get(i), i);

                System.out.println(model.hangman.getWordList().toString());
                countRight++;
            }
            else{
                countWrong++;
            }
        }
        System.out.println(countWrong);

        if(countWrong>0 && countRight==0){
            model.hangman.failedTry();
            System.out.println(model.hangman.getTries());
        }
      
        if(model.hangman.checkWin()){
            state = 1;
        }
        else if(model.hangman.checkLoose()){
            state = 2;
        }
        model.repaint();
        
    }


    @Override
    public void keyReleased(KeyEvent e) {
    }
    @Override
    public void keyTyped(KeyEvent e) {
    }
    
}
