package com.meysamzamani.PopularRepoFinder.domain;

import java.util.List;

public class Repo {

    private int total_count;
    private boolean incomplete_results;
    private List<RepoItems> items;

    public Repo() {
    }

    public Repo(int total_count, boolean incomplete_results, List<RepoItems> items) {
        this.total_count = total_count;
        this.incomplete_results = incomplete_results;
        this.items = items;
    }

    public int getTotal_count() {
        return total_count;
    }

    public boolean isIncomplete_results() {
        return incomplete_results;
    }

    public List<RepoItems> getItems() {
        return items;
    }

}
