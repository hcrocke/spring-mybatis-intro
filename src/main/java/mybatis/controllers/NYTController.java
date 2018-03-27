package mybatis.controllers;

// RESTful entry points, like the new main()

import mybatis.model.nyt.external.NYTRoot;
import mybatis.model.nyt.challenges.ResponseComparison;
import mybatis.services.NYTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController

// listening for all requests beginning with /nyt
@RequestMapping("/nyt")
public class NYTController {

    // dependency injection - called "Field injection"
    @Autowired
    NYTService nytService;

    @RequestMapping("/search")
    public NYTRoot searchNYT(@RequestParam(value ="query", defaultValue = "cats") String query,
    @RequestParam(value ="p", defaultValue = "true") boolean persist) {

        return nytService.searchNYT(query, persist);
    }

    @RequestMapping("/compare")
    public ResponseComparison compareNYTResults(@RequestParam(value = "t1", required = true) String t1,
                                                @RequestParam(value = "t2", required = true) String t2) {

        return nytService.compareNYTResults(t1,t2);
    }
}


