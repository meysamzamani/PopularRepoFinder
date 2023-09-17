package com.meysamzamani.PopularRepoFinder.application;

import com.meysamzamani.PopularRepoFinder.domain.Repo;
import com.meysamzamani.PopularRepoFinder.domain.RepoSpecification;
import com.meysamzamani.PopularRepoFinder.infrastructure.github.GithubApiClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class RepoService {

    @Autowired
    private GithubApiClient githubApiClient;

    @Value("${com.meysamzamani.default_date}")
    private String defaultDate;

    public Repo getPopularRepositories(
            int limit,
            @RequestParam(required = false) String language,
            @RequestParam(required = false) String sinceDate
    ) {
        StringBuilder stringBuilder = new StringBuilder();
        String sort = "stars";
        String order = "desc";

        if (language != null) {
            RepoSpecification.languageContains(stringBuilder, language);
        } else if (sinceDate != null) {
            RepoSpecification.sinceDateContains(stringBuilder, sinceDate);
        } else {
            RepoSpecification.sinceDateContains(stringBuilder, defaultDate);
        }

        return githubApiClient.searchRepositories(stringBuilder.toString(), sort, order, limit);
    }

}
