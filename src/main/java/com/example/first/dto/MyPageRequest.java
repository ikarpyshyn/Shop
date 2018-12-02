package com.example.first.dto;

public class MyPageRequest {

    private int numberPage;
    private int sizePage;

    private SortRequest sortRequest;

    public MyPageRequest() {
    }

    public MyPageRequest(int numberPage, int sizePage) {
        this.numberPage = numberPage;
        this.sizePage = sizePage;
    }

    public int getNumberPage() {
        return numberPage;
    }

    public void setNumberPage(int numberPage) {
        this.numberPage = numberPage;
    }

    public int getSizePage() {
        return sizePage;
    }

    public void setSizePage(int sizePage) {
        this.sizePage = sizePage;
    }

    public SortRequest getSortRequest() {
        return sortRequest;
    }

    public void setSortRequest(SortRequest sortRequest) {
        this.sortRequest = sortRequest;
    }
}
