package Model;

public class Mail {
    public String to;
    public String subject;
    public String text;

    public Mail(String to, String subject, String text) {
        this.to = to;
        this.subject = subject;
        this.text = text;
    }
}
