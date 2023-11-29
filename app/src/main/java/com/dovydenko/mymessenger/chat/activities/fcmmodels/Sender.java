package com.dovydenko.mymessenger.chat.activities.fcmmodels;

public class Sender {
    private final Data data;
    private final String to;

    public Sender(Data data, String to) {
        this.data = data;
        this.to = to;
    }
}
