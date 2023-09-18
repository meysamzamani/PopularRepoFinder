package com.meysamzamani.PopularRepoFinder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RepoSpecificationTest {

    @Test
    @DisplayName("Given java language when languageContains called then should equal expected")
    void givenJava_whenLanguageContainsCalled_thenShouldEqualExpected() {
        StringBuilder builder = new StringBuilder();
        RepoSpecification.languageContains(builder, "java");
        assertEquals("java", builder.toString());
    }

    @Test
    @DisplayName("Given date when sinceDateContains called then should equal expected")
    void givenDate_whenSinceDateContainsCalled_thenShouldEqualExpected() {
        StringBuilder builder = new StringBuilder();
        RepoSpecification.sinceDateContains(builder, "2021-01-01");
        assertEquals("created:2021-01-01", builder.toString());
    }

}