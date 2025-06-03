class Solution {
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        int n = status.length;
        boolean[] hasKey = new boolean[n];
        boolean[] opened = new boolean[n];
        boolean[] seen = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        
        for (int box : initialBoxes) {
            queue.offer(box);
            seen[box] = true;
        }

        int totalCandies = 0;
        
        boolean progress = true;
        while (progress) {
            progress = false;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int box = queue.poll();
                
                if (status[box] == 0 && !hasKey[box]) {
                    queue.offer(box); // ìì§ ì´ ì ìì
                    continue;
                }

                
                // ë°ì¤ ì´ê¸°
                if (opened[box]) continue;
                opened[box] = true;
                progress = true;

                // ì¬í ëíê¸°
                totalCandies += candies[box];
                
                // ì´ì  ì ì¥
                for (int key : keys[box]) {
                    hasKey[key] = true;
                }
                
                // ë°ì¤ ì¶ê°
                for (int b : containedBoxes[box]) {
                    if (!seen[b]) {
                        seen[b] = true;
                        queue.offer(b);
                    }
                }

                // key ì»ìì ìë ìì¼ë ë¤ì í ì±ì°ê¸°
                for (int j = 0; j < n; j++) {
                    if (seen[j] && !opened[j]) {
                        queue.offer(j);
                    }
                }
            }
        }

        return totalCandies;
    }
}
