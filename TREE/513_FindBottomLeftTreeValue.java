// Given the root of a binary tree, return the leftmost value in the last row of the tree.

 

// Example 1:


// Input: root = [2,1,3]
// Output: 1
// Example 2:


// Input: root = [1,2,3,4,null,5,6,null,null,7]
// Output: 7

// Intuition
// The intuition of the question is to print the leftmost node of the last level.

// Approach
// For this question we are going to use the bfs level order traversal techinque
// 1-create a lef variable for storing the leftmost value from each level.
// 2-while iterating level wise make use of a loop as per the size of the level
// 3-and when the iterator is at 0th position in the queue then store (that means it is pointing to the first node of that particular level) so store it's value in the lef variable.

// Complexity
// Time complexity:
// O(n)
// Space complexity:
// O(n)

Code
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int findBottomLeftValue(TreeNode root) {
        int lef = 0;
        if(root.left==null&&root.right==null){
            return root.val;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNode curr = queue.poll();
                if(i==0){
                    lef = curr.val;
                }
                if(curr.left!=null){
                    queue.offer(curr.left);
                }
                if(curr.right!=null){
                    queue.offer(curr.right);
                }
            }
        }
        return lef;
    }
}