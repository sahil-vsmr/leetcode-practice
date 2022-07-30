class Solution {
    int[] arr;

    public int find(int vertex) {
        while (vertex != arr[vertex]) {
            vertex = arr[vertex];
        }
        return vertex;
    }
    
    public void union(int v1, int v2) {
        int rootV1 = find(v1);
        int rootV2 = find(v2);
        
        if (rootV1 != rootV2) {
            arr[rootV1] = rootV2;
        }
    }
    
    public int findCircleNum(int[][] isConnected) {
        arr = new int[isConnected.length];
        
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = i; j < isConnected.length; j++) {
                if (isConnected[i][j] == 1) {
                    union(i, j);
                }
            }
        }
        
        HashSet<Integer> result = new HashSet<Integer>();
        
        for (int i = 0; i < isConnected.length; i++) {
            result.add(find(i));
        }
        return result.size();
    }
}