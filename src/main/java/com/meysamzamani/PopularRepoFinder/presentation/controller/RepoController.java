package com.meysamzamani.PopularRepoFinder.presentation.controller;

import com.meysamzamani.PopularRepoFinder.application.RepoService;
import com.meysamzamani.PopularRepoFinder.domain.RepoItems;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1.0/repo")
public class RepoController {

    @Autowired
    private RepoService repoService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<RepoItems> getPopularRepositories(
            @RequestParam int limit,
            @RequestParam(required = false) String language,
            @RequestParam(required = false) String sinceDate
    ) {
        return repoService.getPopularRepositories(limit, language, sinceDate).getItems();
    }

}
