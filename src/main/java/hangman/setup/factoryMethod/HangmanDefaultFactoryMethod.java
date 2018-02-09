package hangman.setup.factoryMethod;

import com.google.inject.Inject;
import hangman.model.English;
import hangman.model.GameScore;
import hangman.model.Language;
import hangman.model.dictionary.EnglishDictionaryDataSource;
import hangman.model.dictionary.HangmanDictionary;
import hangman.view.HangmanPanel;
import hangman.view.HangmanStickmanPanel;

public class HangmanDefaultFactoryMethod extends HangmanFactoryMethod {
    
    
    @Inject
    private Language language;
    
    @Inject 
    private HangmanDictionary dictionary;
    
    @Inject
    private HangmanPanel hangmanPanel;
    
    @Inject
    private GameScore gs;
    
    @Override
    public Language createLanguage() {
        return language;
    }

    @Override
    public HangmanDictionary createDictionary() {
        return dictionary;
    }

    @Override
    public HangmanPanel createHangmanPanel() {
        return hangmanPanel;
    }
    
    @Override
    public GameScore createGameScore(){
        return gs;
    }
}
