
import bl.Util;
import entity.Language;
import entity.Word_Text;
import java.sql.SQLException;
import service.LanguageService;
import service.MongoLanguageService;
import service.WordTextService;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Алина
 */
public class Domain {
    public static void main(String[] args){
        LanguageService languageService = new LanguageService();
//        WordTextService wordTextService = new WordTextService();
        
        Language language = new Language();
        
//        language.setId(3);
//        language.setName("Russian");
//        languageService.add(language);
//        MongoLanguageService languageService = new MongoLanguageService();
//        Language language = new Language();
        
//        language.setId(3);
//        language.setName("Russian");
//        languageService.add(language);
//        languageService.getAll();

        //Word_Text wordText = new Word_Text();
        //wordText.setWord_id(word.getId());
        //wordText.setWord_id(text.getId());
        
        //try{
            //languageService.add(language);
            //wordTextService.add(wordText);
        //} catch (SQLException e){
        //    e.printStackTrace();
        //}
        
        //Util util = new Util();
        //util.getConnection();
    }
}
