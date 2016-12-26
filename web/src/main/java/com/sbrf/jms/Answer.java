package com.sbrf.jms;

public class Answer {
    private long userId;
    private boolean correctPassword;

    public Answer() {
    }

    public Answer(long userId, boolean correctPassword) {
        this.userId = userId;
        this.correctPassword = correctPassword;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public boolean isCorrectPassword() {
        return correctPassword;
    }

    public void setCorrectPassword(boolean correctPassword) {
        this.correctPassword = correctPassword;
    }
}
