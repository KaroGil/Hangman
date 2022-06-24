package Hangman.src;

import javax.swing.JComponent;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;


public class Model extends JComponent {  
    Hangman hangman;
    private ArrayList<String> words = new ArrayList<>(Arrays.asList("London", "Tokyo", "New York"));
    public Model(){
        hangman = new Hangman(words.get(randomeIndex()), 6);

        this.setFocusable(true);
        getPreferredSize();

    }

    public Dimension getPreferredSize() {
        return new Dimension(700,500);
    }

    int randomeIndex(){
        return (int) ((Math.random() * (words.size())));
    }

    public void paint(Graphics canvas) {
        super.paint(canvas);

       paintStart(canvas);
       drawLostLife(canvas, hangman.getTries());
       drawWord(canvas);

    }

    void paintStart(Graphics canvas){
        canvas.setColor(Color.black);
        canvas.drawLine(50, 400, 400, 400);
        canvas.drawLine(100, 400, 100, 150);
        canvas.drawLine(100, 150, 300, 150);
        canvas.drawLine(300, 150, 300, 180);

    }

    void drawWord(Graphics canvas){
        ArrayList<Character> list = hangman.getWordList();
        String listString = list.toString().replaceAll(",", " ").replace("[", " ").replaceAll("]", " ");
        canvas.drawString(listString, 450, 200);
    }

    void drawLostLife(Graphics canvas, int life){
        if(life <= 5){
            //head
            canvas.drawOval(285, 180, 30, 30);
            if(life <= 4){
                //body
                canvas.drawLine(300, 210, 300, 280);
                //arms
                if(life <= 3){
                    //right
                    canvas.drawLine(300, 230, 340, 250);
                    if(life <= 2){
                        //left
                        canvas.drawLine(300, 230, 260, 250);
                        //legs
                        if(life <= 1){
                            //right
                            canvas.drawLine(300, 280, 340, 320);
                            if(life <= 0){
                                //left
                                canvas.drawLine(300, 280, 260, 320);
                            }
                        }
                    }
                }
            }            
        }
        
        if(life > 0 && !hangman.checkWin()){
            canvas.drawString("Press a key to guess letter!", 450, 100);
        }
        else if(hangman.checkWin()){
            canvas.drawString("You guessed the word! You win!!", 450, 100);
        }
        else{
            canvas.drawString("Game Over!", 450, 100);
        }

        // for (Character letter : hangman.getLettersGuessedList()) {
        //     canvas.drawString(letter.toString(), 450, 400);
        // }
        if(hangman.getCharArray() != null){
            canvas.drawChars(hangman.getCharArray(),0, hangman.getCharArray().length, 450, 400);
        }

    }
  
}
