class Solution {
    Map<Integer, Integer> resultSet = new HashMap<>();
    
    public int climbStairs(int n) {
        return fibo(n);
    }
    
    public int fibo(int n) {
        if (n==1) {
            return 1;
        }
        
        if (n == 2) {
            return 2;
        }
        
        int nMinus1 = 0;
        
        if (!resultSet.containsKey(n-1)) {
            resultSet.put(n-1, fibo(n-1));
        }
        nMinus1 = resultSet.get(n-1);
        
        
        int nMinus2 = 0;
        
        if (!resultSet.containsKey(n-2)) {
            resultSet.put(n-2, fibo(n-2));
        }
        nMinus2 = resultSet.get(n-2);
        
        return nMinus2 + nMinus1;
        
        
    }
}