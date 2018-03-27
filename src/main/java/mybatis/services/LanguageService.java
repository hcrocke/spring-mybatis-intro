package mybatis.services;

import mybatis.controllers.MultiLanguage;
import mybatis.model.languages.LanguageRoot;
import mybatis.model.nyt.challenges.ResponseComparison;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class LanguageService {

    @Autowired
    RestTemplate restTemplate;

    public LanguageRoot detectLanguage(String words) {

        String fQuery = "http://ws.detectlanguage.com/0.2/detect?q=" + words + "&key=";

        LanguageRoot data = restTemplate.getForObject(fQuery, LanguageRoot.class);

        return data;
    }


    public MultiLanguage multiLanguages(String language1, String language2) {

        LanguageRoot langOne = detectLanguage(language1);
        LanguageRoot langTwo = detectLanguage(language2);

        MultiLanguage obj = new MultiLanguage();

        obj.getSearchLanguageTwo();
        obj.getSearchLanguageTwo();
        return obj;
    }
}
