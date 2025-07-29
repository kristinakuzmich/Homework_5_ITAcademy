package by.it_academy.jd2.dto;

import java.time.LocalDateTime;

public class Message {
    private final String fromUser;
    private final String toUser;
    private final String text;
    private final LocalDateTime  sendTime;


    public Message(String fromUser, String toUser, String text, LocalDateTime sendTime) {
        this.fromUser = fromUser;
        this.toUser = toUser;
        this.text = text;
        this.sendTime = sendTime;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getFromUser() {
        return fromUser;
    }

    public String getToUser() {
        return toUser;
    }

    public String getText() {
        return text;
    }

    public LocalDateTime getSendTime() {
        return sendTime;
    }

    public static class Builder {
        private String fromUser;
        private String toUser;
        private String text;
        private LocalDateTime sendTime;

        public Builder from(String from) {
            this.fromUser = from;
            return this;
        }

        public Builder to(String to) {
            this.toUser = to;
            return this;
        }

        public Builder text(String text) {
            this.text = text;
            return this;
        }

        public Builder sendTime(LocalDateTime sendTime) {
            this.sendTime = sendTime;
            return this;
        }

        public Message build() {
            return new Message(fromUser, toUser, text, sendTime);
        }
    }
}