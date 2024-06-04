package com.aurora.ajax;

public class Temp {
    private final String content = "content";
    private String value;

    public Temp(String content) {
        this.value = content;
    }

    public Temp() {
    }

    @Override
    public String toString() {
        return "temp{" +
                "content='" + content + '\'' +
                ", value='" + value + '\'' +
                '}';
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
