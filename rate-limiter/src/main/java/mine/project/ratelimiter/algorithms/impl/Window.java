package mine.project.ratelimiter.algorithms.impl;

public class Window {
    private final long startTime;
    private int requestCount;

    public Window(long startTime, int requestCount) {
        this.startTime = startTime;
        this.requestCount = requestCount;
    }

    public long getStartTime() {
        return startTime;
    }

    public int getRequestCount() {
        return requestCount;
    }

    public void setRequestCount(int requestCount) {
        this.requestCount = requestCount;
    }
}