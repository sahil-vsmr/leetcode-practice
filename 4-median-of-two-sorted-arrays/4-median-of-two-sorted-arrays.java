class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length + nums2.length];
        int m = nums1.length;
        int n = nums2.length;
        int i = 0;
        int j = 0;
        int counter = 0;
        
        while (i < nums1.length || j < nums2.length) {
            boolean presentIn1 = i < nums1.length;
            boolean presentIn2 = j < nums2.length;
            
            if (presentIn1 && presentIn2) {
                result[counter++] = nums1[i] < nums2[j] ? nums1[i++] : nums2[j++];
            } else if (presentIn1) {
                result[counter++] = nums1[i++];
            } else {
                result[counter++] = nums2[j++];
            }
        }
        
        if ((m+n)%2 == 0) {
            int element1 = result[(m+n)/2];
            int element2 = result[(m+n)/2 -1];
            return (element1 + element2)/2.0;
        } else {
            return result[(m+n)/2];
        }
    }
}