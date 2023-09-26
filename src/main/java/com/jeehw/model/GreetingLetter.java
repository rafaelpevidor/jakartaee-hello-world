package com.jeehw.model;

public class GreetingLetter {

    private String id;

    private GreetingLetterTemplate template;

    private Guest guest;

    private boolean sent;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public GreetingLetterTemplate getTemplate() {
        return template;
    }

    public void setTemplate(GreetingLetterTemplate template) {
        this.template = template;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public boolean isSent() {
        return sent;
    }

    public void setSent(boolean sent) {
        this.sent = sent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GreetingLetter that)) return false;

        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "GreetingLetter{" +
                "id='" + id + '\'' +
                ", template=" + template +
                ", guest=" + guest +
                ", sent=" + sent +
                '}';
    }
}
