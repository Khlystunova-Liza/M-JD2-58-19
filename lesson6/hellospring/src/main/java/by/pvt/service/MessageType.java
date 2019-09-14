package by.pvt.service;

public enum MessageType {

    INVITATION_MESSAGE("invitation","s"),
    CANCEL_MESSAGE("cancel","s");

    MessageType(String body, String subject) {
        this.body = body;
        this.subject = subject;
    }

    private String body;
    private String subject;

    MessageType(String inv) {
    }

    public String getBody() {
        return body;
    }

    public String getSubject() {
        return subject;
    }

}
