class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        long start = 1, end = time[0];
        for(int i : time)
            end =  Math.min(end,i);
        end*= totalTrips;
        
        while(start < end){
            long mid = start + (end - start)/2;
            long count = checkValidTrip(time, mid);
            if(count < totalTrips){
             
                 start = mid+1;
            }else
                  end = mid;
        }
        return start;
    }
    
    public long checkValidTrip(int[] time, long mid){
         long count = 0;
         for(int j : time)
             count+= (long)mid/j ;
         return count ;
     }
}
