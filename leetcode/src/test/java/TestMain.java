import java.util.*;

public class TestMain {

    public static int[] computeNext(String pat) {
        int m = pat.length();
        int[] next = new int[m];
        int j = 0;  // 前缀索引

        for (int i = 1; i < m; i++) {
            while (j > 0 && pat.charAt(i) != pat.charAt(j)) {
                j = next[j - 1];  // 失配时回溯
            }
            if (pat.charAt(i) == pat.charAt(j)) {
                j++;  // 匹配成功，前缀长度+1
            }
            next[i] = j;  // 记录最长相等前缀后缀长度
        }
        return next;
    }

    public int closedIsland(int[][] grid) {



        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        // 岛屿数字标识
        int[][] island = new int[m][n];
        // 岛屿路径
        List<List<int[]>> ret = new ArrayList<>();
        int number=0;
        // 1. if !visited[i]  寻找island 保存到List<List<(i,j)>>
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0 && !visited[i][j]){
                    List<int[]> path = new ArrayList<>();
                    dfs(grid,i,j,visited,path,island,number++);
                    ret.add(path);
                }
            }
        }

        // 2. 如何判断是否为closed island？（非边界元素 & 判断4个方向都是1 或同属于一个island）
        // 3. 如何判定两个元素实在一个island里的呢？冗余一个island[i][j]=isLandNumber
        int count = 0;
        for(List<int[]> path:ret){
            boolean close = judge(grid,path,island);
            if(close){
                count++;
            }
        }

        return count;
    }

    void dfs(int[][] grid,int i,int j,boolean[][] visited,List<int[]> path,int[][] island,int number){
        // 边界条件
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || visited[i][j]){
            return;
        }
        if(grid[i][j]==1){
            return;
        }
        visited[i][j]=true;
        island[i][j]=number;
        path.add(new int[]{i,j});
        dfs(grid,i+1,j,visited,path,island,number);
        dfs(grid,i,j+1,visited,path,island,number);
        dfs(grid,i-1,j,visited,path,island,number);
        dfs(grid,i,j-1,visited,path,island,number);
    }

    boolean judge(int[][] grid,List<int[]> path,int[][] isLand){
        for(int[] pos:path){
            // 边界不符合条件
            if(pos[0]==0 || pos[1]==0 || pos[0]==grid.length-1 || pos[1]==grid[0].length-1){
                return false;
            }

            if(grid[pos[0]-1][pos[1]]!=1 &&
                    isLand[pos[0]-1][pos[1]]!=isLand[pos[0]][pos[1]]){
                return false;
            }
            if(grid[pos[0]][pos[1]-1]!=1 &&
                    isLand[pos[0]][pos[1]-1]!=isLand[pos[0]][pos[1]]){
                return false;
            }
            if(grid[pos[0]+1][pos[1]]!=1 &&
                    isLand[pos[0]+1][pos[1]]!=isLand[pos[0]][pos[1]]){
                return false;
            }
            if(grid[pos[0]][pos[1]+1]!=1 &&
                    isLand[pos[0]][pos[1]+1]!=isLand[pos[0]][pos[1]]){
                return false;
            }
        }

        return true;
    }
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();

        for(String str:strs){
            char[] charcc = str.toCharArray();
            Arrays.sort(charcc);
            String strOrder = String.valueOf(charcc);
            if(map.get(strOrder)==null){
                map.put(strOrder,new ArrayList<>());
            }
            map.get(strOrder).add(str);
        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {

      int[] num = new int[]{1,2,3,5};
    }
}
