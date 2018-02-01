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
public class BonusScore implements GameScore{
    
    /**
     * El juego inicia con 0 p
     * @pre correctCount >=0 & incorrectCount >=0
     * @pos puntaje >= 0
     * @param correctCount - cantidad acertadas
     * @param incorrectCount - cantidad fallas
     * @return el puntaje alcanzado bonificando cada letra con 10 p y penalizando cada letra 5 p
     */
    @Override
    public int calculateScore(int correctCount, int incorrectCount) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
