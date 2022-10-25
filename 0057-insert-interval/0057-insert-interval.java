class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int start = newInterval[0];
        int end = newInterval[1];
        int index = 0;
        int inputLength = intervals.length;
        LinkedList<int[]> output = new LinkedList<int[]>();
        
        int[] data = new int[2];
        
        while (index < inputLength && start > intervals[index][0]) {
            output.add(intervals[index++]);
        }
        
        if (output.isEmpty() || output.getLast()[1] < start) {
            output.add(newInterval);
        } else {
            data = output.removeLast();
            data[1] = Math.max(data[1], end);
            output.add(data);
        }
        
        while (index < inputLength) {
            data = intervals[index++];
            start = data[0];
            end = data[1];
            if (output.getLast()[1] < start) {
                output.add(data);
            } else {
                data = output.removeLast();
                data[1] = Math.max(end, data[1]);
                output.add(data);
            }
        }
        return output.toArray(new int[output.size()][2]);

    }
}