package com.haky.domain.enums;

public enum SocialType {
    FACEBOOK("facebook"),
    GOOGLE("google"),
    KAKAO("kakao");

    private final String ROLE_PREFIX = "ROLE_";
    private String name;

    SocialType(String name) {
        this.name = name;
    }

    public String getRoleType() {
        return ROLE_PREFIX + this.name.toUpperCase();
    }

    public String getValue() {
        return this.name;
    }

    public boolean isEquals(String authority) {
        return this.getValue().equals(authority);
    }
}
