class Solution {
    public long distributeCandies(int n, int limit) {
        long result = 0;
        for (int i = limit; i >= 0; i--) {
            int remain = n - i;
            if (remain < 0) continue;
            if (remain > 2 * limit) {
                continue; // ëë break ê°ë¥, ì±ë¥ ìµì í ëª©ì 
            }

            // b + c = remain ì¼ ë, bì cë 0 ~ limit ë²ì
            int minB = Math.max(0, remain - limit);
            int maxB = Math.min(limit, remain);
            result += (maxB - minB + 1);
        }
        return result;
    }
}
