package com.example.apicall.model;

public class PostModel {
    private String login;
    private String id;
    private String url;
    private String repos_url;





    public PostModel(String login, String id, String url, String repos_url){
        this.login = login;
        this.id = id;
        this.url = url;
        this.repos_url = repos_url;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getRepos_url() {
        return repos_url;
    }

    public void setRepos_url(String repos_url) {
        this.repos_url = repos_url;
    }


}
