/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangman.setup.guice;

/**
 *
 * @author 2106913
 */
import hangman.model.dictionary.*;
import hangman.view.*;
import hangman.model.*;

public class HangmanFactoryServices extends com.google.inject.AbstractModule {

    @Override
    protected void configure() {
        bind(HangmanDictionary.class).to(FrenchDictionaryDataSource.class);
        bind(HangmanPanel.class).to(HangmanColoridoPanel.class);
        bind(Language.class).to(French.class);
        bind(GameScore.class).to(PowerScore.class);
    }

}
