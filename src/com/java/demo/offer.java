package com.java.demo;

import java.util.*;


public class offer {
    //Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }





    // 数组中重复的数字 https://leetcode.cn/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/
    //还有一种就是数组下标方法
    public int findRepeatNumber(int[] nums) {
        Arrays.sort(nums);
        for(int i=1;i<nums.length;i++){
            if(nums[i-1]==nums[i])
                return nums[i];
        }
        return nums[nums.length-1];
    }
    // 二维数组中的查找 https://leetcode.cn/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/
    //还可以从右上角开始，那样更快，
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int n=matrix.length;
        if(n==0) return false;
        int m =matrix[0].length;
        for (int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]==target) return true;
                if(matrix[i][j]>target){
                    m=j;
                    break;
                }
            }
        }
        return false;
    }
    //替换空格 https://leetcode.cn/problems/ti-huan-kong-ge-lcof/
    //        s.replace(" ","%20");
    public String replaceSpace(String s) {
        String res=new String();

        for (int i=0;i<s.length();i++){
            if(s.charAt(i)!=' '){
                res+=s.charAt(i);
            }
            else {
                res+="%20";
            }
        }
        return res;
    }
    //从尾到头打印链表 https://leetcode.cn/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
    public int[] reversePrint(ListNode head) {
        if(head==null) return new int[0];
        int length=0;
        ListNode temp=head;
        while(temp!=null){
            length++;
            temp=temp.next;
        }
        int[] res=new int[length];
        for(int i=length-1;i>=0;i--){
            res[i]=head.val;
            head=head.next;
        }
        return res;
    }
    //重建二叉树 https://leetcode.cn/problems/zhong-jian-er-cha-shu-lcof/
    //做过
    private TreeNode prein(int[] preorder, int[]inorder,int prebegin,int preend,int inbegin,int inend) {
        if(prebegin==preend+1) return null;
        TreeNode root=new TreeNode(preorder[prebegin]);
        int i=0;
        for(i=inbegin;inorder[i]!=root.val;i++);
        int llen=i-inbegin;
        int rlen=inend-i;
        if(llen!=0){
            root.left=prein(preorder,inorder,prebegin+1,prebegin+llen,inbegin,inend+llen-1);
        }
        else root.left=null;
        if(rlen!=0){
            root.right=prein(preorder,inorder,prebegin+llen+1, preend,inbegin+llen+1,inend);
        }
        else root.right=null;
        return root;
    }
    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        return prein(preorder,inorder,0,preorder.length-1,0,inorder.length-1);
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return prein(preorder,inorder,0,preorder.length-1,0,inorder.length-1);
    }

    //两个栈实现队列 https://leetcode.cn/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/
    class CQueue {
        Stack<Integer> s1;
        Stack<Integer> s2;
        public CQueue() {
            s1=new Stack<Integer>();
            s2=new Stack<Integer>();
        }

        public void appendTail(int value) {
            s1.push(value);

        }

        public int deleteHead() {
            if(s1.isEmpty()) return -1;
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
            int res=s2.pop();
            while(!s2.isEmpty()){
                s1.push(s2.pop());
            }
           return res;
        }
    }
    //斐波那契数列 https://leetcode.cn/problems/fei-bo-na-qi-shu-lie-lcof/
    //递归会超时
    public int fib(int n) {
        if (n<=1) return n;
        int res=0,pre=1;
        while(n>0){
            res+=pre;
            pre=res-pre;
            res%=1000000007;
            n--;
        }
        return res;
    }
    // 爬楼梯 https://leetcode.cn/problems/qing-wa-tiao-tai-jie-wen-ti-lcof/
    public int numWays(int n) {
            int[] dp =new int[n+1];
            if(n==0) return 1;
            if(n<=2) return n;
            Arrays.fill(dp,0);
            dp[1]=1;
            dp[2]=2;
            for(int i=3;i<=n;i++){
                dp[i]=(dp[i-1]+dp[i-2])%1000000007;
            }
            return dp[n];
        }

    //旋转数组的最小数字 https://leetcode.cn/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/
    public int minArray(int[] numbers) {
        int min=numbers[0];
        for(int i=1;i<numbers.length;i++){
            if(numbers[i]<min){
                return numbers[i];
            }
        }
        return min;
    }
    //. 二进制中1的个数 https://leetcode.cn/problems/er-jin-zhi-zhong-1de-ge-shu-lcof/
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        return Integer.bitCount(n);
    }
    //打印从1到最大的n位数 https://leetcode.cn/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof/
    public int[] printNumbers(int n) {
        int length=(int)Math.pow(10,n);

        int[] res =new int[length-1];
        for(int i=0;i<length;i++)
        {
            res[i]=i+1;
        }
            return res;
    }


}
