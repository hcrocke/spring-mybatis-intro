package mybatis.controllers;

/*Write an API endpoint in your project (in a controller) that will call a service method (in a service class)
 that will use the restTemplate to call the 3rd party API and map the response to the POJOs you created
 */

import mybatis.model.languages.LanguageRoot;
import mybatis.model.nyt.challenges.ResponseComparison;
import mybatis.services.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController

@RequestMapping("/language")

public class LanguageController {

    @Autowired
    LanguageService languageService;

    @RequestMapping("/detect")
    public LanguageRoot detectLanguage(@RequestParam(value = "words", defaultValue = "helloooo")String words) {

        LanguageRoot obj = languageService.detectLanguage(words);
        return obj;
    }

    @RequestMapping("/searchmultiple")
    public MultiLanguage multiLanguages(@RequestParam(value = "language1", required = true) String language1,
                                                @RequestParam(value = "language2", required = true) String language2) {

        return languageService.multiLanguages(language1,language2);
    }


}
