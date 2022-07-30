class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Stack<Integer> stack = new Stack();
        
        boolean[] visited = new boolean[n];
        
        if (edges.length == 0 || source == destination) {
            return true;
        }
        
        stack.push(source);
        
        while (!stack.empty()) {
            int v1 = stack.pop();
            if (v1 == destination) {
                return true;
            }
            
            visited[v1] = true;
            
            for (int i = 0; i < edges.length; i++) {
                if (edges[i][0] == v1 && !visited[edges[i][1]]) {
                    if (edges[i][1] == destination) {
                        return true;
                    }
                    stack.push(edges[i][1]);
                } else if (edges[i][1] == v1 && !visited[edges[i][0]]) {
                    if (edges[i][0] == destination) {
                        return true;
                    }
                    stack.push(edges[i][0]);
                }
            }
        }
        return false;
    }
}