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

//    public boolean exist(char[][] board, String word) {
//        int length=board.length, width=board[0].length,wordlength=word.length();
//        boolean[][] flag=new boolean[length][width];
////        Arrays.fill(flag,false);
//        int i=0,j=0,k=0;
//
//        while(i<length&&j<width){
//            if(board[i][j]==word.charAt(k)){
//                k++;
//                flag[i][j]=true;
//                if(k==wordlength) return true;
//            }
//            if(j+1<width){
//                if(board[i][j+1]==word.charAt(k)&&flag[i][j+1]==false){
//                    k++;
//                    j++;
//                    flag[i][j]=true;
//                    if(k==wordlength) return true;
//
//                }
//            }
//            if(i+1<length){
//                if(board[i+1][j]==word.charAt(k)&&flag[i+1][j]==false){
//                    k++;
//                    i++;
//                    flag[i][j]=true;
//                    if(k==wordlength) return true;
//
//                }
//            }
//            if(j-1>=0){
//                if(board[i][j-1]==word.charAt(k)&&flag[i][j-1]==false){
//                    k++;
//                    j--;
//                    flag[i][j]=true;
//                    if(k==wordlength) return true;
//
//                }
//            }
//            if(i-1>=0){
//                if(board[i][j+1]==word.charAt(k)&&flag[i-1][j]==false){
//                    k++;
//                    i++;
//                    flag[i][j]=true;
//                    if(k==wordlength) return true;
//
//                }
//            }
//
//        }
//        return false;
//    }
        //. 矩阵中的路径 https://leetcode.cn/problems/ju-zhen-zhong-de-lu-jing-lcof/ https://leetcode.cn/problems/word-search/
    public boolean exist(char[][] board, String word) {
        if(board==null||board.length==0||board[0].length==0||word.length()> board.length* board[0].length) return false;
        boolean[][] flag=new boolean[board.length][board[0].length];
        for(int i=0;i< board.length;i++){
            for(int j=0;j< board[0].length;j++){
                if(dfs(board,word,flag, i,j,0)) return true;
            }
        }
        return false;
    }
    private boolean dfs(char[][] board, String word,boolean[][] flag, int i,int j,int start){

        if(i<0||i>=board.length||j>=board[0].length||j<0||word.charAt(start)!=board[i][j]||flag[i][j]==true) return false;
        if(start==word.length()-1) return true;
        flag[i][j]=true;
        boolean temp=dfs(board, word, flag, i+1, j, start+1)||
                dfs(board, word, flag, i, j+1, start+1)||
                dfs(board, word, flag, i-1, j, start+1)||
                dfs(board, word, flag, i, j-1, start+1);
        flag[i][j]=false;
        return temp;
    }
    //机器人的运动范围 https://leetcode.cn/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/
    //这样不行，这样会导致路径不连续。
    public int movingCount1(int m, int n, int k) {
        int res=0;
        if(k==0) return 1;
        for(int i=0;i<m;i++){
            int t1=i,sum=0;
            while(t1!=0){
                sum+=t1%10;
                t1/=10;
            }
            if(sum<=k){
                for(int j=0;j<n;j++){
                    t1=j;
                    int t=0;
                    while(t1!=0){
                        t=t1%10;
                        t1/=10;
                    }
                    if(t+sum<=k) res++;
                    else break;
                }
            }

        }
        return res;
    }
    private int dfs1(boolean[][] flag, int i,int j,int m,int n,int k){

        if(i<0||j<0||j>=n||i>=m||flag[i][j]==true||(i/10+i%10+j/10+j%10)>k) return 0;
        flag[i][j]=true;
        return dfs1(flag, i+1, j, m, n, k)+
                dfs1(flag, i, j+1, m, n, k)+
                dfs1(flag, i-1, j, m, n, k)+
                dfs1(flag, i, j-1, m, n, k)+1;

    }
    public int movingCount(int m, int n, int k) {
        boolean[][] flag=new boolean[m][n];
        return dfs1(flag,0,0,m,n,k);



    }

    // 剪绳子 https://leetcode.cn/problems/jian-sheng-zi-lcof/
    public int cuttingRope(int n) {
            int[] dp =new int[n+1];
            if(n<=2) return 1;
            dp[1]=1;
            dp[2]=1;
        for(int i=3;i<n+1;i++){
            for(int j=1;j<i;j++){
                //j即是将n从第j处分割
                //Math.max(j*(i-j),j*dp[i-j]) 中 j*(i-j)指的是分割一次后的乘积；j*dp[i-j]指
                //分割一次后，剩余部分继续分割后的最大乘积,前面已经求解过，所以只需要取结果
                //下面综合起来就是，但j取不同时，与前一次j取值后的dp[i]比较，取最大值，直到j遍历完
                dp[i]=Math.max(dp[i],Math.max(j*(i-j),j*dp[i-j]));
            }
        }
        return dp[n];
    }
    //剪绳子2  https://leetcode.cn/problems/jian-sheng-zi-ii-lcof/comments/
    public int cuttingRope1(int n) {
        if(n == 2)
            return 1;
        if(n == 3)
            return 2;
        long res = 1;
        while(n > 4){
            res *= 3;
            res = res % 1000000007;
            n -= 3;
        }
        return (int)(res * n % 1000000007);
    }

    public double myPow(double x, int n) {
        if(n==0) return 1;
        if(n==1) return x;
        if(n==-1) return 1/x;
        double res=x;
        int nn=Math.abs(n);
        while(nn>1){
            res*=x;
            nn--;
        }
        if(n>0){
            return res;
        }
        return 1/res;
    }
    //删除链表的节点 https://leetcode.cn/problems/shan-chu-lian-biao-de-jie-dian-lcof/
    public ListNode deleteNode(ListNode head, int val) {
            ListNode pre=head, h=head;
            if(h.val==val) return head.next;
            while(h!=null){
                if(h.val==val){
                    pre.next=h.next;
                    return head;
                }
                else{
                    pre=h;
                    h=h.next;
                }

            }
            return head;
    }

    // 调整数组顺序使奇数位于偶数前面 https://leetcode.cn/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof/
    public int[] exchange(int[] nums) {
        int length=nums.length,head=0;
        int tail=length-1;
        if(length==0||length==1) return nums;
        while(head!=tail){
            if(nums[head]%2==1) head++;
            else{
                int t=nums[head];
                nums[head]=nums[tail];
                nums[tail--]=t;
            }
        }
        return nums;
    }
//    // 表示数值的字符串  https://leetcode.cn/problems/biao-shi-shu-zhi-de-zi-fu-chuan-lcof/
//    public boolean isNumber(String s) {
//        boolean xiaoshu=false,e=false;
//        for(int i=0;i<s.length();i++){
//            if(s.charAt(i)<='9'&&s.charAt(i)>='0')
//        }
//    }
    //链表中倒数第k个节点 https://leetcode.cn/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode quick=head,slow=head;
        int t=1;
        while(quick!=null&&t!=k){
            quick=quick.next;
            t++;
        }
        while(quick.next!=null){
            quick=quick.next;
            head=head.next;
        }
        return head;
    }
    //合并两个有序链表 https://leetcode.cn/problems/merge-two-sorted-lists/
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null) return list2;
        if(list2==null) return list1;
        ListNode newhead=new ListNode(0);
        ListNode t=newhead;
        while(list1!=null&&list2!=null){
            if(list1.val< list2.val) {
                t.next=list1;
                t=t.next;
                list1=list1.next;
            }
            else{
                t.next=list2;
                t=t.next;
                list2=list2.next;
            }

    }
        // 任一为空，直接连接另一条链表
        if (list1 == null) {
            t.next = list2;
        } else {
            t.next = list1;
        }
        return newhead.next;

    }
    //镜像二叉树
    public TreeNode mirrorTree(TreeNode root) {
        if(root==null) return null;
        mirrorTree(root.right);
        TreeNode temp=root.right;
        root.right=root.left;
        root.left=temp;
        mirrorTree(root.right);
        return root;
    }
    //顺时针打印矩阵 https://leetcode.cn/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/
    public int[] spiralOrder(int[][] matrix) {
        if(matrix.length==0) return new int[0];
        int lenth=matrix.length*matrix[0].length;
        int[] res=new int[lenth];
        int count=0;
        int rl = 0, rh = matrix.length-1; //记录待打印的矩阵上下边缘
        int cl = 0, ch = matrix[0].length-1; //记录待打印的矩阵左右边缘
        while(count<lenth){
            for(int i=cl;i<=ch;i++) res[count++]=matrix[rl][i];
            if(count>lenth-1) break;
            rl++;
            for(int i=rl;i<=rh;i++) res[count++]=matrix[i][ch];
            if(count>lenth-1) break;
            ch--;
            for(int i=ch;i>=cl;i--) res[count++]=matrix[rh][i];
            if(count>lenth-1) break;
            rh--;
            for(int i=rh;i>=rl;i--) res[count++]=matrix[i][cl];
            if(count>lenth-1) break;
            cl++;
        }
        return res;
    }
        //包含min函数的栈 https://leetcode.cn/problems/bao-han-minhan-shu-de-zhan-lcof/ https://leetcode.cn/problems/min-stack/
    class MinStack {

        /** initialize your data structure here. */
        Stack<Integer> stack;
        int min;
        public MinStack() {
            stack=new Stack<Integer>();
            min=Integer.MAX_VALUE;
        }

        public void push(int x) {
            stack.push(min);
            if(x<min) min=x;
            stack.push(x);
        }

        public void pop() {
                stack.pop();
                min=stack.pop();


        }

        public int top() {
            return stack.peek();
        }

        public int min() {
            return min;
        }
    }
    // 圆圈中最后剩下的数字 https://leetcode.cn/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/
    //不行，会超时
    public int lastRemaining(int n, int m) {
        if(n==1) return 0;
        boolean[] flag = new boolean[n];
        Arrays.fill(flag,false);
        int r=n,i=-1,t=0;
        while(r!=0){
            i=(i+1)%n;
            if(flag[i]==false){
                t++;
            }
            if(t==m) {
                t = 0;
                flag[i] = true;
                r--;
//                System.out.println(i);
            }

        }
        return i;
    }
//    ArrayList<Integer> list = new ArrayList<>(n);
//        for (int i = 0; i < n; i++) {
//        list.add(i);
//    }
//    int idx = 0;
//        while (n > 1) {
//        idx = (idx + m - 1) % n;
//        list.remove(idx);
//        n--;
//    }
//        return list.get(0);


    //数组中出现次数超过一半的数字 https://leetcode.cn/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof/
    //  https://leetcode-cn.com/problems/majority-element/
    public int majorityElement(int[] nums) {
        int num=nums[0];
        int count=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]!=num){
                    count--;
                if(count==0) {
                    num = nums[i+1];
                }
            }
            else
                count++;
        }
        return num;
    }

}
