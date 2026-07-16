An integer has sequential digits if and only if each digit in the number is one more than the previous digit.

Return a sorted list of all the integers in the range [low, high] inclusive that have sequential digits.

 

Example 1:

Input: low = 100, high = 300
Output: [123,234]

Example 2:

Input: low = 1000, high = 13000
Output: [1234,2345,3456,4567,5678,6789,12345]

Intuition

Sequential digit numbers have a special property: the difference between two consecutive sequential numbers of the same length is a number consisting entirely of 1s.

For example, for 2-digit numbers:

12 → 23 → 34 → 45 → ...
Difference = 11

For 3-digit numbers:

123 → 234 → 345 → ...
Difference = 111

Similarly,

4 digits → 1111
5 digits → 11111

So instead of checking every integer in the range, we can:

Generate the smallest sequential number having the same number of digits as low.
Keep adding the corresponding value (11, 111, 1111, …) to generate the next sequential number of the same length.
When the last digit becomes 9, there are no more sequential numbers of that length. We then move to the next digit length by generating 123... with one extra digit and updating the increment value accordingly.
Continue until the generated number exceeds high.
Approach

1-Compute the first sequential number having the same number of digits as low using calBeg().
2-Compute the increment value (11...1) of the same length using calAddVal().
3-If the starting number lies within the range [low, high], add it to the answer.
4-Recursively generate the next sequential number by adding the increment value.
5-If the generated number ends with 9, generate the first sequential number of the next digit length and update the increment value.
6-Stop when the generated number exceeds high or when a 9-digit sequential number has already been processed.
Complexity

    Time complexity:

O(1)

    Space complexity:

O(1)

Code

class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
       List<Integer> list = new ArrayList<>();
       if(String.valueOf(low).length()==9){
        return new ArrayList<>();
       }
       int start = calBeg(low);
       int addVal = calAddVal(low);
       if(start>=low&&start<=high){
        list.add(start);
       }
       rec(list,low,start,high,addVal);
       return list; 
    }
    public void rec(List<Integer> list,int low,int start,int high,int addVal){
        start = start + addVal;
        if(start>=low&&start<=high){
            list.add(start);
        }
        if(start>high){
            return;
        }
        if(start%10==9){
            if(String.valueOf(start).length()==9){
                return;
            }
            start = calBeg(start+1);
            addVal = calAddVal(addVal*10);
        }
        rec(list,low,start,high,addVal);
    }
    public int calAddVal(int low){
        int len = String.valueOf(low).length();
        int val = 0;
        while(len>0){
            val = val*10 + 1;
            len--;
        }
        return val;
    }
    public int calBeg(int low){
        int len = String.valueOf(low).length();
        int val = 0;
        int ind = 1;
        while(len>0){
            val = val*10 + ind;
            ind++;
            len--;
        }
        return val;
    }
}
