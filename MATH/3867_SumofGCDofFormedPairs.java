You are given an integer array nums of length n.

Construct an array prefixGcd where for each index i:

    Let mxi = max(nums[0], nums[1], ..., nums[i]).
    prefixGcd[i] = gcd(nums[i], mxi).

After constructing prefixGcd:

    Sort prefixGcd in non-decreasing order.
    Form pairs by taking the smallest unpaired element and the largest unpaired element.
    Repeat this process until no more pairs can be formed.
    For each formed pair, compute the gcd of the two elements.
    If n is odd, the middle element in the prefixGcd array remains unpaired and should be ignored.

Return an integer denoting the sum of the GCD values of all formed pairs.
The term gcd(a, b) denotes the greatest common divisor of a and b.

 

Example 1:

Input: nums = [2,6,4]

Output: 2

Explanation:

Construct prefixGcd:
i	nums[i]	mxi	prefixGcd[i]
0	2	2	2
1	6	6	6
2	4	6	2

prefixGcd = [2, 6, 2]. After sorting, it forms [2, 2, 6].

Pair the smallest and largest elements: gcd(2, 6) = 2. The remaining middle element 2 is ignored. Thus, the sum is 2.

Intuition

Just so all what is given in the question step by step.
Approach

You are given an integer array nums of length n.

Construct an array prefixGcd where for each index i:

Let mxi = max(nums[0], nums[1], ..., nums[i]).
prefixGcd[i] = gcd(nums[i], mxi).

After constructing prefixGcd:

Sort prefixGcd in non-decreasing order.
Form pairs by taking the smallest unpaired element and the largest unpaired element.
Repeat this process until no more pairs can be formed.
For each formed pair, compute the gcd of the two elements.
If n is odd, the middle element in the prefixGcd array remains unpaired and should be ignored.

Return an integer denoting the sum of the GCD values of all formed pairs.
The term gcd(a, b) denotes the greatest common divisor of a and b.
Complexity

    Time complexity:O(nlog(n))

    Space complexity:O(n)

Code

class Solution {
    public long gcdSum(int[] nums) {
       int n = nums.length;
       int[] mx = new int[n];
       int max = nums[0];
       for(int i=0;i<n;i++){
        if(nums[i]>max){
            max = nums[i];
        }
        mx[i] = max;
       } 
       int[] prefixGCD = new int[n];
       for(int i=0;i<n;i++){
        prefixGCD[i] = functGCD(nums[i],mx[i]);
       }
       Arrays.sort(prefixGCD);
       long sum = 0;
       int r = n-1;
       int l = 0;
       while(l<r){
        sum += functGCD(prefixGCD[l],prefixGCD[r]);
        l++;
        r--;
       }
       return sum;
    }
    public int functGCD(int a,int b){
        if(b==0){
            return a;
        }
        return functGCD(b,a%b);
    }
}
