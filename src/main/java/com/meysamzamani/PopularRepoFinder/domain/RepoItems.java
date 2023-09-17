package com.meysamzamani.PopularRepoFinder.domain;

public class RepoItems {

    private Long id;
    private String name;
    private String html_url;
    private String description;
    private int stargazers_count;
    private String language;
    private String created_at;

    public RepoItems() {
    }

    public RepoItems(Long id, String name, String html_url, String description, int stargazers_count, String language, String created_at) {
        this.id = id;
        this.name = name;
        this.html_url = html_url;
        this.description = description;
        this.stargazers_count = stargazers_count;
        this.language = language;
        this.created_at = created_at;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getHtml_url() {
        return html_url;
    }

    public String getDescription() {
        return description;
    }

    public int getStargazers_count() {
        return stargazers_count;
    }

    public String getLanguage() {
        return language;
    }

    public String getCreated_at() {
        return created_at;
    }
}
