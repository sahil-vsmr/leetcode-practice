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
        
        public boolean checkForSingleRoot() {
            HashSet<Integer> roots = new HashSet();
            
            for (int i = 0; i < arr.length; i++) {
                roots.add(find(i));
            }
            
            return roots.size() == 1;
        }
    }
    
    public int earliestAcq(int[][] logs, int n) {
        UnionFind uf = new UnionFind(n);
        Arrays.sort(logs, new Comparator<int[]>() {
            @Override
            public int compare(int[] log1, int[] log2) {
                Integer tsp1 = new Integer(log1[0]);
                Integer tsp2 = new Integer(log2[0]);
                return tsp1.compareTo(tsp2);
            }
        });
        int timeStamp = 0;
        for (int i = 0; i < logs.length; i++) {
            timeStamp = logs[i][0];
            int v1 = logs[i][1];
            int v2 = logs[i][2];
            uf.union(v1, v2);
            //uf.printArray();
            if(uf.checkForSingleRoot()) {
                return timeStamp;
            }
        }
        return -1;
    }
}