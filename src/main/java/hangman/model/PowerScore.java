/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangman.model;

/**
 *
 * @author 2104784
 */
public class PowerScore implements GameScore{
    
    /**
     * El juego inicia con 0 p
     * @pre correctCount >=0 & incorrectCount >=0
     * @pos 0 <= puntaje <= 500
     * @param correctCount - cantidad acertadas
     * @param incorrectCount - cantidad fallas
     * @return el puntaje alcanzado, bonificando con 5^iesima letra, penalizando cada letra con 8 p
     */
    @Override
    public int calculateScore(int correctCount, int incorrectCount) {
        int gameScore;
        gameScore = (int) (Math.pow((double)5, (double)correctCount) + (incorrectCount*-8));
        if (gameScore < 0){gameScore=0;}
        if (gameScore > 500){gameScore=500;}
        return gameScore;
    }
    
}
