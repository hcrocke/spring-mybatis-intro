package mybatis.controllers;

/*Write an API endpoint in your project (in a controller) that will call a service method (in a service class)
 that will use the restTemplate to call the 3rd party API and map the response to the POJOs you created
 */

import mybatis.model.User;
import mybatis.model.languages.LanguageRoot;
import mybatis.model.languages.MultiLanguage;
import mybatis.services.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController

@RequestMapping("/language")

public class LanguageController {

    @Autowired
    LanguageService languageService;

    @RequestMapping("/detect")
    public LanguageRoot detectLanguage(@RequestParam(value = "words", defaultValue = "helloooo") String words, String apiKey) {

        LanguageRoot obj = languageService.detectLanguage(words);
        return obj;
    }

    @RequestMapping("/searchmultiple")
    public MultiLanguage multiLanguages(@RequestParam(value = "t1", required = true) String t1,
                                        @RequestParam(value = "t2", required = true) String t2,
                                        @RequestParam(value = "p", required = true) boolean persist) {

        return languageService.multiLanguages(t1, t2, persist);
    }
    //create
    @RequestMapping(method = RequestMethod.POST, value = "/")
    public MultiLanguage addNew(@RequestBody MultiLanguage multiLanguage) {
        return languageService.insertLanguageInfo(multiLanguage);

    }
    //update
    @RequestMapping(method = RequestMethod.PATCH, value = "/")
    public MultiLanguage update(@RequestBody MultiLanguage multiLanguage) {
        return languageService.updateInfo(multiLanguage);
    }
    //delete
    @RequestMapping(method= RequestMethod.DELETE, value="/")
    public User deleteById(@RequestParam(value="id")int id) {
        return languageService.deleteById(id);
    }

}
