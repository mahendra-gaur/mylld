package mine.project.ratelimiter.algorithms;

public interface RateLimiterAlgo {
    public boolean isAllowed(String clientId);

}
