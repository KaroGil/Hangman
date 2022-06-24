package Hangman.src;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class HangmanController implements java.awt.event.KeyListener{
    Model model;
    int state = 0;
    public HangmanController(Model model){
        this.model = model;

        model.addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();

        ArrayList<Character> wordInChar = model.hangman.convertToCharArray();
        
        for (int i = 0; i < wordInChar.size(); i++) {
            if(keyCode == wordInChar.get(i)){
                System.out.println("correct");
                model.repaint();
                model.hangman.changeViewWord( wordInChar.get(i), i);
                System.out.println(model.hangman.getWordList().toString());
            }
            else{
                System.out.println(keyCode);
            }
        }
      
        if(model.hangman.checkWin()){
            state = 1;
        }
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
    
}
