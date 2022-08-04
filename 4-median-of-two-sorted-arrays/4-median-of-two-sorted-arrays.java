class Solution {
    int imx = Integer.MAX_VALUE;
    int imi = Integer.MIN_VALUE;
    public double findMedianSortedArrays(int[] a, int[] b) {
        int n = a.length;
        int m = b.length;
        if(n > m){
            return findMedianSortedArrays(b , a);
        }
        if(n == 0){
            int mid = m / 2;
            if(m % 2 == 0){
                return (double)(b[mid] + b[mid - 1]) / (double)2;
            }
            else{
                return (double)b[mid];
            }
        }
        int l = 0;
        int r = n;
        while(l <= r){
            int ela = (l + r) / 2; // elements from 'a'
            int elb = (n + m + 1) / 2 - ela;
            int l1 = ela == 0 ? imi : a[ela - 1];
            int r1 = ela == n ? imx : a[ela];
            int l2 = elb == 0 ? imi : b[elb - 1];
            int r2 = elb == m ? imx : b[elb];
            if(l1 <= r2 && l2 <= r1){
                if((n + m) % 2 == 0){
                    return (double)(Math.max(l1 , l2) + Math.min(r1 , r2)) / (double)2;
                }
                else{
                    return (double)Math.max(l1 , l2);
                }
            }
            if(l1 > r2){
                r = ela - 1;
            }
            else{
                l = ela + 1;
            }
        }
        return -1;
    }
}