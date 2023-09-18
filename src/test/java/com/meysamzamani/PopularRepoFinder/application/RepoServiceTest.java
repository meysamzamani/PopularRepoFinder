package com.meysamzamani.PopularRepoFinder.application;

import com.meysamzamani.PopularRepoFinder.domain.Repo;
import com.meysamzamani.PopularRepoFinder.infrastructure.github.GithubApiClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RepoServiceTest {

    @InjectMocks
    private RepoService repoService;

    @Mock
    private GithubApiClient githubApiClient;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Given language and limit when getPopularRepositories called then should verify one time and equal")
    void givenLanguageAndLimit_whenPopularRepoCalled_thenShouldVerifyOneTimeAndEqual() {
        // Given
        String language = "java";
        int limit = 10;

        // Mock the behavior of GithubApiClient
        when(githubApiClient.searchRepositories(anyString(), anyString(), anyString(), anyInt()))
                .thenReturn(new Repo());

        // When
        Repo result = repoService.getPopularRepositories(limit, language, null);

        // Then
        verify(githubApiClient, times(1))
                .searchRepositories("java", "stars", "desc", limit);
        assertEquals(0, result.getTotal_count());
    }

    @Test
    @DisplayName("Given sinceDate when searchRepositories called then verify one time and equal expected")
    void givenSinceDate_whenSearchRepositoriesCalled_thenVerifyOneTimeAndEqualExpected() {
        // Given
        String sinceDate = "2022-01-01";
        int limit = 20;

        // Mock the behavior of GithubApiClient
        when(githubApiClient.searchRepositories(anyString(), anyString(), anyString(), anyInt()))
                .thenReturn(new Repo());

        // When
        Repo result = repoService.getPopularRepositories(limit, null, sinceDate);

        // Then
        verify(githubApiClient, times(1))
                .searchRepositories("created:2022-01-01", "stars", "desc", limit);
        assertEquals(0, result.getTotal_count());
    }

}