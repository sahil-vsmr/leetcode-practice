class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        
        int size = len1 + len2;
        int[] result = new int[size];
        int i = 0;
        
        int index1 = 0;
        int index2 = 0;
        
        int medianIndex = (int)((len1+len2) % 2 == 0 ? (len1+len2)/2 : Math.floor((len1+len2)/2));
        boolean isEven = (len1+len2) % 2 == 0;
        while (index1 < len1 && index2 < len2) {
            if (i == medianIndex + 1) {
                break;
            }
            if (nums1[index1] > nums2[index2]) {
                result[i] = nums2[index2];
                index2++;
                i++;
            } else {
                result[i] = nums1[index1];
                index1++;
                i++;
            }
        }
        
        while (index1 < len1) {
            if (i == medianIndex + 1) {
                break;
            }
            result[i] = nums1[index1];
            index1++;
            i++;
        }
        
        while (index2 < len2) {
            if (i == medianIndex + 1) {
                break;
            }
            result[i] = nums2[index2];
            index2++;
            i++;
        }
        //System.out.println(medianIndex);
        if (i == (medianIndex + 1)) {
            if (isEven) {
                //System.out.println(result[medianIndex]);
                //System.out.println(result[medianIndex-1]);
                return (result[medianIndex] + result[medianIndex - 1]) / 2.0;   
            } else {
                return result[medianIndex];
            }
        }
        return result[medianIndex];
        
    }
}