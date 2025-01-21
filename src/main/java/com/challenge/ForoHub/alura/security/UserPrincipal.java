package com.challenge.ForoHub.alura.security;

public class UserPrincipal {
    private String username;
    private Long authorId;

    public UserPrincipal(String username, Long authorId) {
        this.username = username;
        this.authorId = authorId;
    }

    public String getUsername() {
        return username;
    }

    public Long getAuthorId() {
        return authorId;
    }
}