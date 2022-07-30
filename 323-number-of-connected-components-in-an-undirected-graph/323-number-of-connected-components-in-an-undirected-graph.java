class Solution {
    
    class UnionFind {
        int[] arr;
        int[] rank;
        UnionFind(int size) {
            arr = new int[size];
            rank = new int[size];
            
            for (int i = 0; i < size; i++) {
                arr[i] = i;
                rank[i] = 1;
            }
        }
        
        public int find(int v1) {
            if (v1 == arr[v1]) {
                return v1;
            }
            
            return arr[v1] = find(arr[v1]);
        }
        
        public void union(int v1, int v2) {
            int rootV1 = find(v1);
            int rootV2 = find(v2);
            
            if (rootV1 != rootV2) {
                if (rank[rootV1] > rank[rootV2]) {
                    arr[rootV1] = rootV1;
                } else if (rank[rootV2] > rank[rootV1]) {
                    arr[rootV1] = rootV2;
                } else {
                    arr[rootV2] = rootV1;
                    rank[rootV2]++;
                }
            }
        }
        
        public void printArray() {
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
            
            System.out.println();
        }
    }
    public int countComponents(int n, int[][] edges) {
        
        UnionFind uf = new UnionFind(n);
        
        for (int i = 0; i < edges.length; i++) {
            int v1 = edges[i][0];
            int v2 = edges[i][1];
            uf.union(v1, v2);
        }
        
        HashSet<Integer> resultSet = new HashSet<Integer>();
        for (int i = 0; i < n; i++) {
            resultSet.add(uf.find(i));
        }
        return resultSet.size();
        
        
    }
}