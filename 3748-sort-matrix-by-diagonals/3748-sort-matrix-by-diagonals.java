class Solution {
   public int[][] sortMatrix(int[][] grid) {
       
       List<List<Pair<Integer, Integer>>> diagonals = new ArrayList<>();
       
       // bottom-left triangle (including main diagonal)
       for(int i = 0; i < grid.length; i++) {
           List<Pair<Integer, Integer>> bltDiagonals = new ArrayList<>(); 
           int x = i;  // ììì  ìì : (i, 0)ë¶í° ìì
           int y = 0;

           while(x < grid.length && y < grid[0].length) {
               bltDiagonals.add(new Pair<>(x++, y++));
           }
           diagonals.add(bltDiagonals);
       }
       
       // top-right triangle (excluding main diagonal)
       for(int j = 1; j < grid[0].length; j++) {
           List<Pair<Integer, Integer>> trDiagonals = new ArrayList<>();
           int x = 0;
           int y = j;  // ììì : (0, j)ë¶í° ìì

           while(x < grid.length && y < grid[0].length) {
               trDiagonals.add(new Pair<>(x++, y++));
           }
           diagonals.add(trDiagonals);
       }
       
       // ê° ëê°ì ë³ë¡ ì ë ¬ ë° ìë³¸ ë°°ì´ì ì ì©
       for(int d = 0; d < diagonals.size(); d++) {
           List<Pair<Integer, Integer>> diagonal = diagonals.get(d);
           
           // ê°ë¤ ì¶ì¶
           List<Integer> values = new ArrayList<>();
           for(Pair<Integer, Integer> pos : diagonal) {
               values.add(grid[pos.getKey()][pos.getValue()]);
           }
           
           // ì ë ¬: bottom-leftë ë´ë¦¼ì°¨ì, top-rightë ì¤ë¦ì°¨ì
           if(d < grid.length) {
               // bottom-left triangle (including main diagonal)
               values.sort(Collections.reverseOrder());
           } else {
               // top-right triangle  
               Collections.sort(values);
           }
           
           // ì ë ¬ë ê°ë¤ì ë¤ì ë°°ì¹
           for(int i = 0; i < diagonal.size(); i++) {
               Pair<Integer, Integer> pos = diagonal.get(i);
               grid[pos.getKey()][pos.getValue()] = values.get(i);
           }
       }
       
       return grid;
   }
}