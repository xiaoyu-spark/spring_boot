package com.example.square.model;

public class AutoConfig {
    private String path;
    private String name;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "AutoConfig{" +
                "path='" + path + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
