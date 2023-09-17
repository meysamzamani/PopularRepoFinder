package com.meysamzamani.PopularRepoFinder.domain;

public class RepoSpecification {
    public static void languageContains(StringBuilder builder, String language) {
        if (language != null) {
            builder.append(language);
        }
    }

    public static void sinceDateContains(StringBuilder builder, String sinceDate) {
        if (sinceDate != null) {
            builder.append("created:").append(sinceDate);
        }
    }
}
