package com.meysamzamani.PopularRepoFinder.presentation.controller;

import com.meysamzamani.PopularRepoFinder.domain.RepoItems;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class RepoControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    @DisplayName("Given all params when search endpoint called then should return 10 record and not empty")
    void givenQueryParams_whenEndPointCalled_thenShouldNotNullAndOK() {
        ResponseEntity<List<RepoItems>> response = restTemplate.exchange(
                "/api/v1.0/repo?limit=10&language=java&sinceDate=2021-01-01",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<RepoItems>>() {}
        );

        assertEquals(HttpStatus.OK, response.getStatusCode());
        List<RepoItems> repositories = response.getBody();
        assertNotNull(repositories);
        assertFalse(repositories.isEmpty());
        assertEquals(10, repositories.size());
    }

    @Test
    @DisplayName("Given since date param when search endpoint called then should return one with OK status")
    void givenQueryParams_whenRepoEndPointCalled_thenShouldEqualOneAndOK() {
        ResponseEntity<List<RepoItems>> response = restTemplate.exchange(
                "/api/v1.0/repo?limit=1&sinceDate=2021-01-01",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<RepoItems>>() {}
        );

        assertEquals(HttpStatus.OK, response.getStatusCode());
        List<RepoItems> repositories = response.getBody();
        assertNotNull(repositories);
        assertFalse(repositories.isEmpty());
        assertEquals(1, repositories.size());
    }

    @Test
    @DisplayName("Given go language param when search endpoint called then should return two with OK status")
    void givenGoLanguage_whenRepoEndPointCalled_thenShouldEqualTwoAndOK() {
        ResponseEntity<List<RepoItems>> response = restTemplate.exchange(
                "/api/v1.0/repo?limit=2&language=go",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<RepoItems>>() {}
        );

        assertEquals(HttpStatus.OK, response.getStatusCode());
        List<RepoItems> repositories = response.getBody();
        assertNotNull(repositories);
        assertFalse(repositories.isEmpty());
        assertEquals(2, repositories.size());
    }

    @Test
    @DisplayName("Given data without parameter when search called then should bad request return")
    void givenWithoutParameter_whenSearchCalled_thenShould400Return() {
        ResponseEntity<Object> response = restTemplate.exchange(
                "/api/v1.0/repo",
                HttpMethod.GET,
                null,
                Object.class
        );

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertNotNull(response);
    }

}