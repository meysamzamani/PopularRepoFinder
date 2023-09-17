package com.meysamzamani.PopularRepoFinder.infrastructure.github;

import com.meysamzamani.PopularRepoFinder.domain.Repo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "github-api", url = "https://api.github.com")
public interface GithubApiClient {

    @RequestMapping(method = RequestMethod.GET, value = "/search/repositories")
    Repo searchRepositories(
            @RequestParam("q") String query,
            @RequestParam("sort") String sort,
            @RequestParam("order") String order,
            @RequestParam("per_page") int perPage);

}
