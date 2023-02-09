package leetcode.node;

import java.util.HashMap;
import java.util.Map;

public class AuthenticationManager {

    private final int timeToLive;

    private final Map<String, Integer> tokenMap;

    public AuthenticationManager(int timeToLive) {
        this.timeToLive = timeToLive;
        this.tokenMap = new HashMap<>();
    }

    public void generate(String tokenId, int currentTime) {
        this.tokenMap.put(tokenId, currentTime + timeToLive);
    }

    public void renew(String tokenId, int currentTime) {
        Integer time = this.tokenMap.get(tokenId);
        if (time == null) {
            //不存在
            return;
        }
        if (time <= currentTime) {
            //已过期
            return;
        }
        this.tokenMap.put(tokenId, currentTime + timeToLive);
    }

    public int countUnexpiredTokens(int currentTime) {
        int res = 0;
        for (Map.Entry<String, Integer> entry : this.tokenMap.entrySet()) {
            if (entry.getValue() > currentTime) {
                ++res;
            }
        }
        return res;
    }
}