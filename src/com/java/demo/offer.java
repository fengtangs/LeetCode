package com.java.demo;

import java.sql.SQLOutput;
import java.util.*;

class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
}
public class offer {
    //Definition for singly-linked list.
    public  class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { this.val = x; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
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

        int index=0;
        // 整数的格式可以用[+|-]B表示, 其中B为无符号整数
        //这个题还没有做出来
        private boolean scanInteger(String s){
            if(index==s.length()) return true;
            if(s.charAt(index) == '+' || s.charAt(index) == '-')
                ++index;
            return scanUnsignedInteger(s);
        }
        private boolean scanUnsignedInteger(String s){
            int befor = index;
            while(index != s.length() && s.charAt(index) >= '0' &&  s.charAt(index) <= '9')
                index ++;
            return index > befor;
        }
        // 数字的格式可以用A[.[B]][e|EC]或者.B[e|EC]表示，
        // 其中A和C都是整数（可以有正负号，也可以没有），而B是一个无符号整数

        public boolean isNumber(String s) {
            if(s.equals("0e")) return false;
            if(s.equals(".")) return false;
            if(s.length() == 0)
                return false;
//            int index = 0;
            //字符串开始有空格，可以返回true
            while(index!=s.length()&& s.charAt(index) == ' ')  //书中代码没有该项测试
                ++index;
            if(index==s.length()) return false;
            boolean numeric = scanInteger(s);
            if(index==s.length()){
                return numeric;
            }
            // 如果出现'.'，接下来是数字的小数部分
            if(s.charAt(index) == '.'){
                ++index;
                if(index==s.length()) return true;
                // 下面一行代码用||的原因：
                // 1. 小数可以没有整数部分，例如.123等于0.123；
                // 2. 小数点后面可以没有数字，例如233.等于233.0；
                // 3. 当然小数点前面和后面可以有数字，例如233.666
                numeric = scanUnsignedInteger(s) || numeric;
            }
            // 如果出现'e'或者'E'，接下来跟着的是数字的指数部分
            if(index==s.length()) return false;
            if( s.charAt(index) == 'e' ||  s.charAt(index) == 'E'){
                ++index;
                // 下面一行代码用&&的原因：
                // 1. 当e或E前面没有数字时，整个字符串不能表示数字，例如.e1、e1；
                // 2. 当e或E后面没有整数时，整个字符串不能表示数字，例如12e、12e+5.4
                numeric = numeric && scanInteger(s);
            }
            //字符串结尾有空格，可以返回true
            if(index<s.length()){
                while( s.charAt(index) == ' ')
                    ++index;
            }

            return numeric && index == s.length();//最后看是否所有部分都符合，如1a3只会检测第一部分是整数然后是a就不会继续检测了，index!=size，所以返回false
        }

        //https://leetcode.cn/problems/zheng-ze-biao-da-shi-pi-pei-lcof/
        public boolean isMatch(String s, String p) {
            if(p.length()==0&&s.length()==0) return true;
            if(p.length()==0) return false;
            boolean[][] dp=new boolean[s.length()+1][p.length()+1];
            dp[0][0]=true;
            for(int i=1;i<p.length()+1;i++){
                if(i>1){
                    if(p.charAt(i-1)=='*'){
                        dp[0][i]=dp[0][i-2];
                    }
                    else {
                        dp[0][i]=false;
                    }
                }
                else {
                    if(p.charAt(i-1)=='*'){
                        dp[0][i]=true;
                    }
                }

            }
            for(int i=1;i<s.length()+1;i++){
                for(int j=1;j<p.length()+1;j++){
                    if(s.charAt(i-1)==p.charAt(j-1)||p.charAt(j-1)=='.'){
                        dp[i][j]=dp[i-1][j-1];
                    }
                    else if(p.charAt(j-1)=='*'){
                        if(j>1){
                            if(dp[i][j-2]){
                                dp[i][j]=true;
                            }
                            else {
                                if(p.charAt(j-2)==s.charAt(i-1)||p.charAt(j-2)=='.'){
                                    dp[i][j]=dp[i-1][j];
                                }
                            }
                        }
                    }
                }//end for_1
            }//end for_whole

            return dp[s.length()][p.length()];
        }

    //https://leetcode.cn/problems/shu-de-zi-jie-gou-lcof/
    public boolean isSubStructure(TreeNode A, TreeNode B) {
            if(A==null||B==null) return false;
            return compare(A,B)||isSubStructure(A.left, B)||isSubStructure(A.right,B);

    }
    private boolean search(TreeNode A, TreeNode B){
            if(A.val==B.val&&compare(A,B)){
                return true;
            }
            return search(A.left, B)||search(A.right,B);
    }
    private boolean compare(TreeNode A,TreeNode B){
            if(B==null) return true;
            if(A==null) return false;
            return A.val==B.val&&compare(A.left,B.left)&&compare(A.right,B.left);
    }

    public boolean validateStackSequences(int[] pushed, int[] popped) {
            Stack<Integer> stack=new Stack<Integer>();
            int length= pushed.length,i=0,j=0;
            while(i<length){
                stack.push(pushed[i++]);
                while(j<length&&!stack.isEmpty()&&stack.peek()==popped[j]){
                    j++;
                    stack.pop();
                }
            }
            if(j==length) return true;
            return false;
    }
    //https://leetcode.cn/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof/
    //层次遍历
    public int[] levelOrder(TreeNode root) {
        if(root==null) return new int[0];
        Queue<TreeNode> que=new  LinkedList<TreeNode>();
        List<Integer> res=new ArrayList<Integer>();
        que.add(root);
        while(!que.isEmpty()){
            TreeNode temp=que.poll();
            res.add(temp.val);
            if(temp.left!=null) que.add(temp.left);
            if(temp.right!=null) que.add(temp.right);

        }
        return res.stream().mapToInt(Integer::valueOf).toArray();
    }
    //https://leetcode.cn/problems/cong-shang-dao-xia-da-yin-er-cha-shu-ii-lcof/
    public List<List<Integer>> levelOrder1(TreeNode root) {
        Queue<TreeNode> que=new  LinkedList<TreeNode>();
        boolean flag=true;
        List<List<Integer>> res=new ArrayList<>();
        if(root!=null) que.add(root);
        while(!que.isEmpty()){
            int size=que.size();
            List<Integer> vec=new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode node=que.poll();
                vec.add(node.val);
                if(node.left!=null) que.add(node.left);
                if(node.right!=null) que.add(node.right);
            }
            if (flag == false) {
                flag=true;
                Collections.reverse(vec);
                res.add(vec);
            }
            else{
                flag=false;
                res.add(vec);
            }

        }
        //Collections.reverse(res);
        return res;
    }

    //https://leetcode.cn/problems/zi-fu-chuan-de-pai-lie-lcof/
    //回溯
    LinkedHashSet<String> res = new LinkedHashSet<>();
    int j=0;
    void backtracking(String s,boolean[] used,char [] path){
        if(j==s.length()){
            res.add(new String(path));
            return;
        }
        for(int i=0;i<s.length();i++){
            if(used[i]==false){
                path[j++]=s.charAt(i);
                used[i]=true;
                backtracking(s,used,path);
                used[i]=false;
                j--;
            }
        }


    }
    public String[] permutation(String s) {
        boolean[] used=new boolean[s.length()];
        char[] path=new char[s.length()];
        Arrays.fill(used,false);
        res.clear();
        backtracking(s,used,path);
        return res.toArray(new String[res.size()]);
    }

    //https://leetcode.cn/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof/
    public int maxSubArray(int[] nums) {
        int max=nums[0];
        int length=nums.length;
        int nowmax=nums[0];
        for(int i=1;i<length;i++){
            if(nowmax+nums[i]>=nums[i]){
                nowmax+=nums[i];
            }
            else {
                nowmax=nums[i];
            }
            if(nowmax>max){
                max=nowmax;
            }
        }
        return max;
    }


    //https://leetcode.cn/problems/ugly-number-ii/
    public int nthUglyNumber(int n) {

        int[] res=new int[n+1];
        res[1]=1;
        int p2=1,p3=1,p5=1;
        for(int i=2;i<n+1;i++){
            int num2=res[p2]*2,num3=res[p3]*3,num5=res[p5]*5;
            res[i]=Math.min(Math.min(num2,num3),num5);
            if(res[i]==num2){
                p2++;
            }
            if(res[i]==num3){
                p3++;
            }
            if(res[i]==num5){
                p5++;
            }
        }
        return res[n];
    }
    public int[] twoSum(int[] nums, int target) {
            int p=0,r=nums.length-1;
            while(p<r){
                int res=nums[p]+nums[r];
                if(res==target)
                    return new int [] {nums[p],nums[r]};
                else if(res>target)
                {
                    r--;
                }
                else if(res<target){
                    p++;
                }
            }
            return new int[2];
    }

    private boolean cmp(TreeNode r1,TreeNode r2){
        if(r1==null&&r2==null) return true;
        if(r1==null||r2==null||r1.val!= r2.val) return false;
        return cmp(r1.left,r2.right)&& cmp(r2.left,r1.right);
    }
    //https://leetcode.cn/problems/dui-cheng-de-er-cha-shu-lcof/
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return false;
        return cmp(root.left,root.right);
    }

    //https://leetcode.cn/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof/
    public boolean verifyPostorder(int[] postorder) {
        if (postorder.length==0) return true;
        Stack<Integer> stack = new Stack();
        int preval=Integer.MAX_VALUE;
        int length=postorder.length-1;
        for(int i=length;i>=0;i--){
            if(postorder[i]>preval){
                return false;
            }
            while(!stack.isEmpty()&&postorder[i]<stack.peek()){
                        preval=stack.pop();
            }
            stack.push(postorder[i]);

        }
        return true;
    }

    //https://leetcode.cn/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof/
     public char firstUniqChar(String s) {
        int length=s.length();
        if(length==0) return ' ';
        int[] flag=new int[26];
        Arrays.fill(flag,-1);
//        for(int i: flag){
//            System.out.print(i+" ");
//        }
//         System.out.println(" ");
         for (int i=0;i<length;i++) {
             int  t=s.charAt(i)-'a';
//             System.out.println(t);
             if(flag[t]!=-1){
                 flag[t]=-2;
             }
             else
                flag[t]=i;
         }
//         for(int i: flag){
//             System.out.print(i+" ");
//         }
//         System.out.println(" ");
         int m=length+1;
         int c=-1;
         for(int i=0;i<26;i++){
             if(flag[i]!=-1&&flag[i]!=-2){
                 if(flag[i]<m){
                     m=flag[i];
                     c=i;
                 }
             }
         }
         if (c==-1) return ' ';
         else {
             char res= (char) ('a'+c);
             return res;
         }
    }

    //https://leetcode.cn/problems/shu-ju-liu-zhong-de-zhong-wei-shu-lcof/
    class MedianFinder {
        List<Integer> nums;
        Queue<Integer> A,B;
        /** initialize your data structure here. */
        public MedianFinder() {
//            nums=new ArrayList();
            A=new PriorityQueue<>();
            B=new PriorityQueue<>((x, y) -> (y - x));
        }

        public void addNum(int num) {
//            nums.add(num);
            if(A.size() != B.size()) {
                A.add(num);
                B.add(A.poll());
            } else {
                B.add(num);
                A.add(B.poll());
            }
        }

        public double findMedian() {
            return A.size() != B.size() ? A.peek() : (A.peek() + B.peek()) / 2.0;
//            int length=nums.size();
//            if(length==0) return 0;
//            Collections.sort(nums);
//            if(length%2==0) return 0.5*(nums.get(length/2-1)+nums.get(length/2));
//            return nums.get(length/2);
        }
    }

    //https://leetcode.cn/problems/li-wu-de-zui-da-jie-zhi-lcof/
    public int maxValue(int[][] grid) {
        int dp[][] =grid;
        for (int j = 1; j < grid[0].length; j++) {
            dp[0][j]+=dp[0][j-1];
        }
        for (int j = 1; j < grid.length; j++) {
            dp[j][0]+=dp[j-1][0];
        }

        for( int i=1;i<grid.length;i++){
            for(int j=1;j<grid[0].length;j++){
                    dp[i][j]=dp[i][j]+Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[grid.length-1][grid[0].length-1];
    }

    //https://leetcode.cn/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/
    public int search(int[] nums, int target) {
            int res=0;
            for(int i=0;i<nums.length;i++){
                if(nums[i]==target) res++;
            }
            return res;
    }

    //https://leetcode.cn/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof/comments/
    public int[] singleNumbers(int[] nums) {
            int t = 0;
            for (int n : nums) {
                t ^= n;
            }
            int div = 1;
            while ((div & t) == 0) {
                div <<= 1;
            }
            int a = 0, b = 0;
            for (int n : nums) {
                if ((div & n) != 0) {
                    a ^= n;
                } else {
                    b ^= n;
                }
            }
            return new int[]{a, b};
    }

    // https://leetcode.cn/problems/bu-ke-pai-zhong-de-shun-zi-lcof/
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int temp=0;
        for(int i=1;i<5;i++){
            if(nums[i-1]==0) continue;
            if(nums[i]==nums[i-1]) return false;
            temp+=(nums[i]-nums[i-1]);

        }
        return temp<5;
    }

    // https://leetcode.cn/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof/
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null||headB==null) return null;
        ListNode l1=headA,l2=headB;
        while(l1!=l2){
            l1= l1==null? headA:l1.next;
            l2= l2==null? headB:l2.next;
        }
        return l1;
    }
    //https://leetcode.cn/problems/gu-piao-de-zui-da-li-run-lcof/
    public int maxProfit(int[] prices) {
        if(prices.length==0) return 0;
        int res=0;
        int min=prices[0];
        for(int i:prices){
//            System.out.println(i);
            if(min>i){
                min=i;
            }
            if(res<i-min){
                res=i-min;
                System.out.println(res);
            }
        }
        return res;
    }

    class MaxQueue {
        ListNode queuehead;
        ListNode queuetail;
        int mmax;
        int length;
        public MaxQueue() {
             queuehead = null;
            queuetail = null;
            mmax=Integer.MIN_VALUE;
            length=0;
        }

        public int max_value() {
            if(length==0) return -1;
            else return mmax;
        }

        public void push_back(int value) {
            if(mmax<value)mmax=value;
            ListNode t = new ListNode(value);
            if(length==0){
                queuehead=t;
            }else {
                queuetail.next=t;
            }
            queuetail = t;
            length += 1;
        }

        public int pop_front() {
            if(length==0) return -1;
            int t=queuehead.val;
            queuehead=queuehead.next;
            length--;
            if(length==0){
                queuetail=null;
                mmax=Integer.MIN_VALUE;
            }
            else if(t==mmax){
                int max=Integer.MIN_VALUE;
                ListNode temp=queuehead;
                while(temp!=null){
                    if(max< temp.val){
                        max=temp.val;
                    }
                    temp=temp.next;
                }
               mmax=max;
            }
            return t;
        }
    }

    //https://leetcode.cn/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof/
    public int[] maxSlidingWindow(int[] nums, int k) {
        int length=nums.length;
        if(length==0) return new int[0];
        List<Integer> res=new ArrayList<Integer>();
        for(int i=0;i<=length-k;i++){
            int max=nums[i];
            int j=i;
            while(j<i+k){
                if(max<nums[j])max=nums[j];
                j++;
            }
            res.add(max);
        }
        System.out.println(res);
        return res.stream().mapToInt(Integer::valueOf).toArray();
    }



    //https://leetcode.cn/problems/gou-jian-cheng-ji-shu-zu-lcof/solution/gou-jian-cheng-ji-shu-zu-by-leetcode-sol-aqg2/
    public int[] constructArr(int[] a) {
        int length=a.length;
        if(length<=1) return a;
        int[] l=new int[length];
        int [] r=new int[length];
        l[0]=1;
        for(int i=1;i<length;i++){
            l[i]=a[i-1]*l[i-1];
        }
        r[length-1]=1;
        for(int i=length-2;i>=0;i--){
            r[i]=a[i+1]*r[i+1];
        }
        int [] res=new int[length];
        for(int i=0;i<length;i++){
            res[i]=l[i]*r[i];
        }
        return res;
    }

    //https://leetcode.cn/problems/ba-zi-fu-chuan-zhuan-huan-cheng-zheng-shu-lcof/comments/
    public int strToInt(String str) {
        long res=0;
        boolean flag=false;
        int length=str.length();
        if(length==0) return 0;
        int i=0;
        System.out.println(length);

        while(i<length&&str.charAt(i)==' '){
            i++;
        }
        System.out.println(i);
        if(i>=length) return 0;
        if((str.charAt(i)!='-'&&str.charAt(i)!='+')&&(str.charAt(i)<'0'||str.charAt(i)>'9'))
            return 0;
        if(str.charAt(i)=='-'){
            flag=true;
            i++;
        }

        else if(str.charAt(i)=='+'){
            i++;
        }
        while(i<length&&str.charAt(i)>='0'&&str.charAt(i)<='9'){
            res= res*10+str.charAt(i)-'0';
            if(flag==false&&res>Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }
            if(flag==true&& -res<Integer.MIN_VALUE)
                return Integer.MIN_VALUE;
            i++;
        }

    return (int) (flag? -res:res);

    }

    //https://leetcode.cn/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof/
    public int[][] findContinuousSequence(int target) {

        List<int[]>res=new ArrayList<int[]>();
        for(int x=1;x<=target;x++){
            for(int n=2;n<=target-x+1;n++){
                if((2*x+n-1)*n==2*target){
                    int[] t=new int[n];
                    int j=x;
                    for(int i=0;i<n;i++){
                       t[i]=j;
                       j++;
                    }
                    res.add(t);
                }
                else if((2*x+n-1)*n>2*target){
                    break;

                }
            }
        }
//        int [][]r=new int [res.size()][]
//        for(int i=0;i<res.size();i++){
//            for(int j=0;j< res.get(i).length;j++){
//                System.out.print(res.get(i)[j]+" ");
//            }
//            System.out.println();
//        }
        return res.toArray(new int[0][]);
    }


    public int reversePairs(int[] nums) {
        int res=0;
        for(int i=0;i< nums.length-1;i++){
            for(int j=i+1;j< nums.length;j++){
                if(nums[i]>nums[j])
                    res++;
            }
        }
        return res;
    }
    //https://leetcode.cn/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/
    int rres=0,nums=0;
    private void youzhongzuo(TreeNode root, int k){
        if(root==null) return;

        youzhongzuo(root.right,k);
        if(++nums==k) rres=root.val;

        youzhongzuo(root.left,k);
    }
    public int kthLargest(TreeNode root, int k) {
        youzhongzuo(root,k);
        return rres;
    }


    //https://leetcode.cn/problems/er-cha-shu-de-shen-du-lcof/
    public int maxDepth(TreeNode root) {
        if(root==null) return 0;
        Queue<TreeNode> queue=new LinkedList<>();
        int res=0;
        queue.add(root);
        while(!queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<size;i++){
                TreeNode t=queue.poll();
                if(t.left!=null) queue.add(t.left);
                if(t.right!=null) queue.add(t.right);
            }
            res++;
        }
        return res;
    }


    //https://leetcode.cn/problems/fan-zhuan-dan-ci-shun-xu-lcof/
    public String reverseWords(String s) {
        String result=new String();
        s = s.trim();
        int f=0;
        String[] res=s.split("\\s+");
        System.out.println(res.length);
        for(int i=res.length-1;i>=0;i--){
            if(res[i]!=" "){
                if(f==0){
                    result+=res[i];
                    f=1;
                }
                else{
                    result=result+" "+res[i];
                }
            }

        }
        return result;
    }

    // https://leetcode.cn/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof/
    public String reverseLeftWords(String s, int n) {
        String res=new String();
        res=s.substring(n,s.length());
        res+=s.substring(0,n);
        return res;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==p||root==q||root==null) return root;
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right =lowestCommonAncestor(root.right,p,q);
        if(left!=null&&right!=null) return root;
        if(left==null&&right!=null) return right;
        if(left!=null&&right==null) return left;
        return null;
    }



    //https://leetcode.cn/problems/fu-za-lian-biao-de-fu-zhi-lcof/submissions/
//    class Node {
//        int val;
//        Node next;
//        Node random;
//
//        public Node(int val) {
//            this.val = val;
//            this.next = null;
//            this.random = null;
//        }
    Map<Node,Node > resmap =new HashMap<Node,Node>();
//    public Node copyRandomList(Node head) {
//        if(head==null)
//            return null;
//        if(!resmap.containsKey(head)){
//            Node temp=new Node(head.val);
//            resmap.put(head, temp);
//            temp.next=copyRandomList(head.next);
//            temp.random=copyRandomList(head.random);
//        }
//        return resmap.get(head);
//    }
    //https://leetcode.cn/problems/xu-lie-hua-er-cha-shu-lcof/
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        String res=new String();
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        if(root==null) return new String();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode temp= queue.poll();
            if(temp!=null){
                res+=String.valueOf(temp.val)+",";
                queue.add(temp.left);
                queue.add(temp.right);
            }
            else{
                res+="null,";
            }
        }
        if(res.length()!=0) res=res.substring(0,res.length()-1);
        return res;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        Queue<String> queue = new LinkedList<String>();
        for(int i = 0; i < arr.length; i++){
            queue.offer(arr[i]);
        }
        return help(queue);
    }
    private TreeNode help(Queue<String> queue){
        String val = queue.poll();
        if(val.equals("null")){
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(val));
        root.left = help(queue);
        root.right = help(queue);
        return root;
    }

    Node pre,head;
    public Node treeToDoublyList(Node root) {
        if(root==null) return null;
        zhuanhuan(root);
        head.left=pre;
        pre.right=head;
        return head;
    }
    private void zhuanhuan(Node root){
            if(root==null) return ;
            zhuanhuan(root.left);
            if(pre==null) head=root;
            else if(pre!=null) pre.right=root;
            root.left=pre;
            pre=root;
            zhuanhuan (root.right);
    }

    // https://leetcode.cn/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof/comments/
    public int translateNum(int num) {
        if(num<10) return 1;
        String nums= String.valueOf(num);
        int[] dp =new int[nums.length()];
        dp[0]=1;
        dp[1]= nums.charAt(0)-'0'==1||nums.charAt(0)-'0'==2&&nums.charAt(1)-'0'<6 ?2:1;
        for(int i=2;i<dp.length;i++){
            dp[i]=nums.charAt(i-1)-'0'==1||nums.charAt(i-1)-'0'==2&&nums.charAt(i)-'0'<6 ?dp[i-1]+dp[i-2]:dp[i-1];
        }
        return dp[dp.length-1];
    }

    //https://leetcode.cn/problems/shu-zi-xu-lie-zhong-mou-yi-wei-de-shu-zi-lcof/
    public int findNthDigit(int n) {
        if(n<10) return n;
        int digit = 1;
        long start = 1;
        long count = 9;
        while (n > count) { // 1.
            n -= count;
            digit += 1;
            start *= 10;
            count = digit * start * 9;
        }
        long num = start + (n - 1) / digit; // 2.
        return Long.toString(num).charAt((n - 1) % digit) - '0'; // 3.

    }

    //https://leetcode.cn/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof/
    public int lengthOfLongestSubstring(String s) {
        int res=0;
        Set<Character> set=new HashSet<Character>();
        int begin=0;
        for(int i=0;i<s.length();i++){
            char temp=s.charAt(i);
            while(set.contains(temp)){//向后滑动
                set.remove(s.charAt(begin++));
            }
            set.add(temp);
            res=Math.max(res,i-begin+1);
        }
        return res;
    }
    //https://leetcode.cn/problems/1nzheng-shu-zhong-1chu-xian-de-ci-shu-lcof/
    //不会
    public int countDigitOne(int n) {
        // mulk 表示 10^k
        // 在下面的代码中，可以发现 k 并没有被直接使用到（都是使用 10^k）
        // 但为了让代码看起来更加直观，这里保留了 k
        long mulk = 1;
        int ans = 0;
        for (int k = 0; n >= mulk; ++k) {
            ans += (n / (mulk * 10)) * mulk + Math.min(Math.max(n % (mulk * 10) - mulk + 1, 0), mulk);
            mulk *= 10;
        }
        return ans;
    }

    //https://leetcode.cn/problems/ba-shu-zu-pai-cheng-zui-xiao-de-shu-lcof/
    public String minNumber(int[] nums) {
    String[] str=new String[nums.length];
    for(int i=0;i<nums.length;i++){
        str[i]=String.valueOf(nums[i]);
    }
    Arrays.sort(str,(x,y)->(x+y).compareTo(y+x));
    String res=new String();
    for(String i:str){
        res+=i;
    }
    return res;


    }

    //https://leetcode.cn/problems/nge-tou-zi-de-dian-shu-lcof/
    public double[] dicesProbability(int n) {
        //因为最后的结果只与前一个动态转移数组有关，所以这里只需要设置一个一维的动态转移数组
        //原本dp[i][j]表示的是前i个骰子的点数之和为j的概率，现在只需要最后的状态的数组，所以就只用一个一维数组dp[j]表示n个骰子下每个结果的概率。
        //初始是1个骰子情况下的点数之和情况，就只有6个结果，所以用dp的初始化的size是6个
        double[] dp = new double[6];
        //只有一个数组
        Arrays.fill(dp,1.0/6.0);
        //从第2个骰子开始，这里n表示n个骰子，先从第二个的情况算起，然后再逐步求3个、4个···n个的情况
        //i表示当总共i个骰子时的结果
        for(int i=2;i<=n;i++){
            //每次的点数之和范围会有点变化，点数之和的mid值最大是i*6，最小是i*1，i之前的结果值是不会出现的；
            //比如i=3个骰子时，最小就是3了，不可能是2和1，所以点数之和的值的个数是6*i-(i-1)，化简：5*i+1
            //当有i个骰子时的点数之和的值数组先假定是temp
            double[] temp = new double[5*i+1];
            //从i-1个骰子的点数之和的值数组入手，计算i个骰子的点数之和数组的值
            //先拿i-1个骰子的点数之和数组的第j个值，它所影响的是i个骰子时的temp[j+k]的值
            for(int j=0;j<dp.length;j++){
                //比如只有1个骰子时，dp[1]是代表当骰子点数之和为2时的概率，它会对当有2个骰子时的点数之和为3、4、5、6、7、8产生影响，因为当有一个骰子的值为2时，另一个骰子的值可以为1~6，产生的点数之和相应的就是3~8；比如dp[2]代表点数之和为3，它会对有2个骰子时的点数之和为4、5、6、7、8、9产生影响；所以k在这里就是对应着第i个骰子出现时可能出现六种情况，这里可能画一个K神那样的动态规划逆推的图就好理解很多
                for(int k=0;k<6;k++){
                    //这里记得是加上dp数组值与1/6的乘积，1/6是第i个骰子投出某个值的概率
                    temp[j+k]+=dp[j]*(1.0/6.0);
                }
            }
            //i个骰子的点数之和全都算出来后，要将temp数组移交给dp数组，dp数组就会代表i个骰子时的可能出现的点数之和的概率；用于计算i+1个骰子时的点数之和的概率
            dp = temp;
        }
        return dp;
    }


    public int maxAliveYear(int[] birth, int[] death) {
        int[] res=new int[105];
//        Arrays.fill(res,0);
        for( int i=0;i<birth.length;i++){
            res[birth[i]-1900]++;
            res[death[i]-1900+1]--;
        }
        int max=0;
        int tem=0,idx=0;
        for( int i=0;i<101;i++){
            tem+=res[i];
            if(tem>max){
                max=tem;
                idx=i;
            }
        }
        return idx+1900;
    }

    //https://leetcode.cn/problems/successor-lcci/comments/
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root==null)
            return null;
        if(root.val<=p.val){
            inorderSuccessor(root.right,p);
        }
        TreeNode t = inorderSuccessor(root.left,p);
        return t==null?root:t;
    }


    // https://leetcode.cn/problems/0H97ZC/
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int t=arr1[0];
        int index=0;
        for( int i=0;i< arr2.length;i++){
            for(int j=index;j<arr1.length;j++){
                if(arr1[j]==arr2[i]){
                   int tt=arr1[j];
                   arr1[j]=arr1[index];
                   arr1[index]=tt;
                   index++;
                }
            }
        }
        return arr1;
    }
    

    class CBTInserter {
        TreeNode root;
        public CBTInserter(TreeNode root) {
            this.root=root;
        }

        public int insert(int val) {
            int result = 0;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while(!queue.isEmpty()){
                int size = queue.size();
                for(int i = 0; i < size; i++){
                    TreeNode temp = queue.poll();
                    //满二叉树
                    if(temp.left == null && temp.right == null){
                        //插左边
                        temp.left = new TreeNode(val);
                        result = temp.val;
                        //找到结束所有循环
                        while(! queue.isEmpty()){
                            queue.poll();
                        }
                        break;
                    }
                    //完全二叉树
                    if(temp.right == null){
                        //插右边
                        temp.right = new TreeNode(val);
                        result =  temp.val;
                        //找到结束所有循环
                        while(! queue.isEmpty()){
                            queue.poll();
                        }
                        break;
                    }
                    //左子树不为空
                    if(temp.left != null){
                        queue.offer(temp.left);
                    }
                    //右子树不为空
                    if(temp.right != null){
                        queue.offer(temp.right);
                    }

                }
            }
            return result;
        }

        public TreeNode get_root() {
            return root;
        }
    }
    public int[] arrayRankTransform(int[] arr) {
        int length = arr.length;
        int []res = new int[length];
        int [] sorted=new int[length];
        sorted=Arrays.copyOfRange(arr,0,length);
        Arrays.sort(sorted);
        int count=1;
        HashMap<Integer, Integer>hashMap=new HashMap<Integer, Integer>();
        for(int i=0;i<length;i++){
            if(!hashMap.containsKey(sorted[i])){
                hashMap.put(sorted[i],count);
                count++;
            }
        }
        for(int i =0;i<length;i++){
            res[i]=hashMap.get(arr[i]);
        }
        return res;
    }


    public String orderlyQueue(String s, int k) {
        if(k==1){
            String smallest=s;
            StringBuffer stemp=new StringBuffer(s);
            for(int i=1;i<s.length();i++){
                char c =stemp.charAt(0);
                stemp.deleteCharAt(0);
                stemp.append(c);
                if(stemp.toString().compareTo(smallest)<0){
                    smallest = stemp.toString();
                }
            }
            return smallest;
        }else{
            char [] ans = s.toCharArray();
            Arrays.sort(ans);
            return new String(ans);
        }
    }



    //https://leetcode.cn/problems/add-one-row-to-tree/
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth==1||depth==0){
            TreeNode temp =new TreeNode(val);
            temp.left=root;
            return temp;
        }
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        int nowdepth =1;
        while(nowdepth<depth-1){
            int size=q.size();
            for(int j=0;j<size;j++){
                TreeNode t=q.poll();
                if(t.left!=null){q.add(t.left);}
                if(t.right!=null){q.add(t.right);}
            }
            nowdepth++;
        }
        while(q.size()>0){
            TreeNode t=q.poll();
            TreeNode l=t.left;
            TreeNode r=t.right;
            t.left=new TreeNode(val);
            t.right=new TreeNode(val);
            t.left.left=l;
            t.right.right=r;
        }
        return root;
    }

//    public String generateTheString(int n) {
//        StringBuffer sb =new StringBuffer();
//        if(n%2==0){
//            return sb.append("a".repeat(n - 1)).append("b").toString();
//        }
//        return sb.append("a".repeat(n)).toString();
//    }
//public boolean validateStackSequences(int[] pushed, int[] popped) {
//    Stack<Integer> stack=new Stack<Integer>();
//    int j=0;
//    for(int i=0;i<pushed.length;i++){
//        stack.push(pushed[i]);
//        while(!stack.isEmpty()&&stack.peek()==popped[j]){
//            stack.pop();
//            j++;
//        }
//    }
//    return stack.isEmpty();
//}

public int kSimilarity(String s1, String s2) {
    int n=s1.length();
    char c[]=s2.toCharArray();
    Map<String,Integer> map=new HashMap<>();
    List<String> list=new ArrayList<>();
    list.add(s1);
    map.put(s1,0);
    for(int i=0;i<list.size();i++){
        String s=list.get(i);
        char c1[]=s.toCharArray();
        int a=map.get(s);
        for(int j=0;j<n;j++){
            if(c1[j]!=c[j]){
                for(int k=j+1;k<n;k++){
                    if(c1[k]==c[j]&&c1[k]!=c[k]){
                        exchange(c1,j,k);
                        String t=new String(c1);
                        if(t.equals(s2)){return 1+a;}
                        if(!map.containsKey(t)){
                            list.add(t);
                            map.put(t,a+1);
                        }
                        exchange(c1,j,k);
                    }
                }
                break;
            }
        }
    }
    return 0;
}
void exchange(char c[],int x,int y){
    char ch=c[x];
    c[x]=c[y];
    c[y]=ch;
}






        class MyLinkedList {

            class ListNode {
                int val;
                ListNode next;
                public ListNode() {}
                public ListNode(int val) {this.val = val;}
                public ListNode(int val, ListNode next) {this.val = val; this.next = next;}
            }

            int size;
            ListNode head;

            public MyLinkedList() {
                size = 0;
                head = new ListNode();
            }

            public int get(int index) {
                if (index < 0 || index >= size) return -1;
                ListNode cur = head;
                for (int i = 0; i <= index; i++) {
                    cur = cur.next;
                }
                return cur.val;
            }

            public void addAtHead(int val) {
                addAtIndex(0, val);
            }

            public void addAtTail(int val) {
                addAtIndex(size, val);
            }

            public void addAtIndex(int index, int val) {
                if (index > size) return;
                if (index < 0) index = 0;
                size++;
                ListNode node = new ListNode(val), cur = head;
                for (int i = 0; i < index; i++) {
                    cur = cur.next;

                }
                node.next = cur.next;
                cur.next = node;
            }

            public void deleteAtIndex(int index) {
                if (index < 0 || index >= size) return;
                size--;
                ListNode cur = head;
                for (int i = 0; i < index; i++) {
                    cur = cur.next;
                }
                cur.next = cur.next.next;
            }
        }


    //https://leetcode.cn/problems/generate-parentheses/comments/ 括号生成
    public List<String> generateParenthesis(int n) {
        List<String> res =new ArrayList<String>() ;

        generateresult(0,0,n,"",res);
        return res;

    }
    private void  generateresult(int left,int right,int n,String string,List<String> res){
        if(left>n||right>n) return;
        if(left==n&& right==n) res.add(string);
        else{
            if(left>=right){
                String s=new String(string);
                generateresult(left+1,right,n,s+"(",res);
                generateresult(left,right+1,n,s+")",res);
            }
        }

    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>>map=new HashMap<>();
        for(String s:strs){
            char[] ch=s.toCharArray();
            Arrays.sort(ch);
            String key=String.valueOf(ch);
            if(map.containsKey(key)){
                List<String> tmp=new ArrayList<>(map.get(key));
                tmp.add(s);
                map.put(key,tmp);
            }
            else {
                 map.put(key,Arrays.asList(s));
            }
        }
        List<List<String>> res=new ArrayList<>();
        Iterator < String > iterator = map.keySet().iterator();
        while(iterator.hasNext()){
            String key=iterator.next();
            res.add(map.get(key));
        }
        return res;
    }

    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
            int needEngery=0;
            int needExperience=0;
            for(int i=0;i<energy.length;i++){
                if(initialEnergy<= energy[i]){
                    int t=energy[i]-initialEnergy+1;
                    needEngery+=t;
                    initialEnergy=1;
                }
                else {
                    initialEnergy-=energy[i];
                }
                if(initialExperience<=experience[i]){
                    int t=experience[i]-initialExperience+1;
                    needExperience+=t;
                    initialExperience+=experience[i];
                }
                else {
                    initialExperience+=experience[i];
                }
            }
            return needEngery+needExperience;
    }

    /**
     * https://leetcode.cn/problems/longest-subsequence-with-limited-sum/
     * @param nums
     * @param queries
     * @return
     */

    public int[] answerQueries(int[] nums, int[] queries) {
            int[] res= new int[queries.length];
        Arrays.sort(nums);
        int []sum=new int[nums.length];
        sum[0]=nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum[i]=sum[i-1]+nums[i];
        }


        for (int i = 0; i < queries.length; i++) {
            res[i]=bysearch(sum,queries[i]);

        }
        return res;
    }
    private int  bysearch(int[] nums, int t){
        int low = 0, high = nums.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > t) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;

    }

    /**
     * https://leetcode.cn/problems/split-two-strings-to-make-palindrome/
     * @param a
     * @param b
     * @return
     */

//    private boolean huiwen(String a){
//        if (a.length()==0){
//            return true;
//        }
//        int i=0,j=a.length()-1;
//        while(i<j){
//            if(a.charAt(i++)!=a.charAt(j--))
//            {
//                return false;
//            }
//
//        }
//        return true;
//
//    }
    public boolean checkPalindromeFormation(String a, String b) {
        int n=b.length();
        if (n==0||n==1){
            return true;
        }
        return checkconcatent(a,b)||checkconcatent(b,a);
    }
    private boolean checkconcatent(String a ,String b){
        int n=a.length();
        int i=0,j=n-1;
        while(i<j&&a.charAt(i)==b.charAt(j)){
            i++;
            j--;
        }
        if(i>=j) {
            return true;
        }
        return checkselfij(a,i,j)||checkselfij(b,i,j);
    }
    private boolean checkselfij(String a, int i,int j){
        while (i<j&&a.charAt(i)==a.charAt(j)){
            i++;
            j--;
        }
        return i>=j;



    }

    public boolean findSubarrays(int[] nums) {
        HashMap<Integer,Integer> temp=new HashMap<>();
        int length=nums.length;
        if (length==2) return false;
        for (int i=0;i<length-1;i++){
            int sum=nums[i]+nums[i+1];
            if(temp.containsKey(sum))return true;
            temp.put(sum,1);
        }
        return false;

    }
    public int test(int n,int[]nums){
        int[] dp=new int[n];
        dp[0]=nums[0];
        boolean flag=false;
        dp[1]=nums[1]>nums[0]?nums[1]:nums[0];
        if(dp[1]!=dp[0]) flag=false;
        for (int i=2;i<n;i++){
            int t1=dp[i-2]+nums[i];
            if(t1>dp[i-1]){
                flag=true;
                dp[i]=t1;
            }
            else{
                dp[i]=dp[i-1];
            }
        }
        return dp[n];
    }

    public int search1 (int[] nums, int target) {
        // write code here
        int begin=0,end=nums.length-1;

        while(begin<=end){
            int mid=begin+(end-begin)/2;
            if(nums[mid]==target){
                return mid;
            }
            else if(nums[mid]>target){
                end=mid-1;
            }
            else{
                begin=mid+1;
            }
            if (end==begin&&nums[end]!=target){
                return -1;
            }
        }
        return -1;
    }
    public boolean Find(int target, int [][] array) {
            int row=0;
            int col=array[0].length-1;
            while(row<=array.length-1&&col>=0){
               if(target==array[row][col]){
                   return true;
               }
               else if(target>array[row][col]){
                   row++;
               }
               else
               {
                   col--;
               }

            }
            return false;
    }
    public int minmumNumberOfHost (int n, int[][] startEnd) {
        int[] start = new int[n];
        int[] end = new int[n];
        //分别得到活动起始时间
        for(int i = 0; i < n; i++){
            start[i] = startEnd[i][0];
            end[i] = startEnd[i][1];
        }
        //单独排序
        Arrays.sort(start, 0, start.length);
        Arrays.sort(end, 0, end.length);
        int res = 0;
        int j = 0;
        for(int i = 0; i < n; i++){
            //新开始的节目大于上一轮结束的时间，主持人不变
            if(start[i] >= end[j])
                j++;
            else
                //主持人增加
                res++;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] tree = new int[n];
        for (int i = 0; i < n; i++) {
            tree[i] = in.nextInt();
        }
        int[] sum=new int[n];
        sum[0]=tree[0]%m;
        int res=0;
        if(tree[0]%m==0)
            res++;
        for (int i = 1; i < n; i++) {
            sum[i]=sum[i-1]+tree[i];
//            if(tree[i]%m==0){
//                res++;
//            }
        }

        for (int i = 1; i <n; i++) {
            if(sum[i]%m==0){
                res++;
            }
            for (int j = i-1; j >=0 ; j--) {
                    int temp=sum[i]-sum[j];
                    if(temp%m==0){
                        res++;
                    }
            }
        }
        System.out.println(res);


    }

            // 注意 hasNext 和 hasNextLine 的区别
//            while (in.hasNextLine()) { // 注意 while 处理多个 case
//                int n = in.nextInt();
//                char[] a= in.next().toCharArray();
//                char[]  b= in.next().toCharArray();
//                Arrays.sort(a);
//                Arrays.sort(b);
//                int res=0;
//                for (int i = 0; i < a.length; i++) {
//                        res+=Math.abs((int)(a[i]-b[i]));
//                }
//                System.out.println(res);
//                if(a<=9){
//                    System.out.println(a);
//                    continue;
//                }
//                if(a>45){
//                    System.out.println(-1);
//                }
//                int i=0;
//                int sum=0;
//                while(a>0){
//                    if(a>=(9-i)){
//                        int t=(9-i)*(int)Math.pow(10,i);
//                        sum+=t;
//                        a=a-(9-i);
//                        i++;
//
//                    }
//                    else{
//                        int t=a*(int)Math.pow(10,i);
//                        sum+=t;
//                        a=0;
//                    }
//                }
//                System.out.println(sum);


//            }
//        }
//        offer o=new offer();
//        System.out.println(o.minmumNumberOfHost(3,new int[][]{{1,2},{1,2},{2,3}}));
//        String[] s=new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
//        List<List<String>> res=groupAnagrams(s);
//        System.out.println(res);
//        offer o=new offer();
//        long t =System.currentTimeMillis();
//        System.out.println(System.currentTimeMillis());
////        System.out.println(dfs(45));
//        System.out.println(System.currentTimeMillis()-t);
//        System.out.println(o.huiwen("adaada"));



}
