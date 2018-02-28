package com.applet.model;

public class UserReport {
    private String id;

    private Double calorie;

    private Double duration;

    private Double kilometers;

    private String userId;

    public UserReport() {
    }

    public UserReport(String id, Double calorie, Double duration, Double kilometers, String userId) {
        this.id = id;
        this.calorie = calorie;
        this.duration = duration;
        this.kilometers = kilometers;
        this.userId = userId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Double getCalorie() {
        return calorie;
    }

    public void setCalorie(Double calorie) {
        this.calorie = calorie;
    }

    public Double getDuration() {
        return duration;
    }

    public void setDuration(Double duration) {
        this.duration = duration;
    }

    public Double getKilometers() {
        return kilometers;
    }

    public void setKilometers(Double kilometers) {
        this.kilometers = kilometers;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }
}