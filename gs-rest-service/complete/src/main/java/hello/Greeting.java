package hello;

public class Greeting {

    private final String minute;
    private final int hitCount;
    private final String content;

    public Greeting(String m, int h, String content) {
        this.minute=m;
        this.hitCount=h;
        this.content = content;
    }

    public String getMinute() {
        return minute;
    }
    public int getHitCount() {
        return hitCount;
    }
    public String getContent() {
        return content;
    }
}
