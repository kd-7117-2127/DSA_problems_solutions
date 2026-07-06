Given an array intervals where intervals[i] = [li, ri] represent the interval [li, ri), remove all intervals that are covered by another interval in the list.

The interval [a, b) is covered by the interval [c, d) if and only if c <= a and b <= d.

Return the number of remaining intervals.

 

Example 1:

Input: intervals = [[1,4],[3,6],[2,8]]
Output: 2
Explanation: Interval [3,6] is covered by [2,8], therefore it is removed.

Example 2:

Input: intervals = [[1,4],[2,3]]
Output: 1
# Intuition

<!-- Describe your first thoughts on how to solve this problem. -->

The key observation is that after sorting the intervals by their starting point, any interval that is completely covered by a previously processed interval can be identified by comparing their ending points. If two intervals have the same starting point, the interval with the larger ending point should come first so that the smaller one is naturally recognized as covered.

# Approach

<!-- Describe your approach to solving this problem. -->

1. Sort the intervals in ascending order of their starting value. If two intervals have the same starting value, sort them in descending order of their ending value.

2. Maintain three variables:

   * **prevEnd** – stores the ending value of the last valid interval.
   * **currEnd** – stores the ending value of the current interval.
   * **count** – keeps track of the number of intervals that are not covered.

3. Traverse the sorted intervals:

   * Update **currEnd** with the ending value of the current interval.
   * If **currEnd** is greater than **prevEnd**, the current interval is not covered by any previously processed interval, so increment **count** and update **prevEnd**.
   * Otherwise, the current interval is completely covered by a previous interval, so ignore it.

# Complexity

* Time complexity:

<!-- Add your time complexity here, e.g. $$O(n)$$ -->  

```
O(n log n)
```

* Space complexity:

<!-- Add your space complexity here, e.g. $$O(n)$$ -->

```
O(1)
```

# Code

```java []
class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
       Arrays.sort(intervals, (a,b)->{
        if(a[0]==b[0]){
            return b[1]-a[1];
        }
        return a[0]-b[0];
       });
       int len = intervals.length;
       int currEnd = 0;
       int prevEnd = 0;
       int count = 0;
       for(int[] interval:intervals){
        currEnd = interval[1];
        if(currEnd>prevEnd){
            count++;
            prevEnd = currEnd;
        }
       }
       return count;
    }
}
```

