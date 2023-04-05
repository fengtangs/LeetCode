package com.java.demo;


import java.util.*;
/**
 * 动态规划相关题目，来源leetcode
 * date: 20220531
 * author：nsf
 * cite form 代码随想录
 */
public class dp {

    //斐波那契数  https://leetcode.cn/problems/fibonacci-number/
    public int fib(int n) {
        if(n==0||n==1)
            return n;
        int[] f=new int[n+1];
        f[0]=0;
        f[1]=1;
        for(int i=2;i<=n;i++)
        {
            f[i]=f[i-1]+f[i-2];
        }
        return f[n];
    }
    //使用最小花费爬楼梯  https://leetcode.cn/problems/min-cost-climbing-stairs/
    public int minCostClimbingStairs(int[] cost) {
        int[]dp=new int[cost.length];
        dp[0]=cost[0];
        dp[1]=cost[1];
        for(int i=2;i<cost.length;i++){
            dp[i]=Math.min(dp[i-1]+cost[i],dp[i-2]+cost[i]);

        }
        return Math.min(dp[cost.length-1],dp[cost.length-2]);
    }
    //不同路径 https://leetcode.cn/problems/unique-paths/
    public int uniquePaths(int m, int n) {
        int[][] dp=new int[m][n];
        int[] ten=new int[n];
        Arrays.fill(ten, 1);
        Arrays.fill(dp,ten);
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                dp[i][j]=dp[i][j-1]+dp[i-1][j];
            }
        }
        return dp[m-1][n-1];
    }
    //不同路径2 https://leetcode.cn/problems/unique-paths-ii/
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m= obstacleGrid.length;
        int n=obstacleGrid[0].length;
        int[][] dp=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dp[i][j]=0;

            }
        }
        for(int i=0;i<m&&obstacleGrid[i][0]==0;i++){
            dp[i][0]=1;
        }
        for(int j=0;j<n&&obstacleGrid[0][j]==0;j++){
            dp[0][j]=1;

        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(obstacleGrid[i][j]==1) continue;
                dp[i][j]=dp[i][j-1]+dp[i-1][j];

            }
        }

        return dp[m-1][n-1];
    }
    //未完成
    //不同二叉搜索树 https://leetcode.cn/problems/unique-binary-search-trees/
    public int numTrees(int n) {
        return 0;
    }
    // 分割等和子集 https://leetcode.cn/problems/partition-equal-subset-sum/
    public boolean canPartition(int[] nums) {
        int sum=0;
        int length=nums.length;
        int[] dp=new int[10001];
        for(int i=0;i<length;i++)sum+=nums[i];
        if(sum%2==1)return false;
        sum/=2;
        Arrays.fill(dp,0);
        for(int i=1;i<length;i++){
            for(int j=sum;j>=nums[i];j--){
                dp[j]=Math.max(dp[j],dp[j-nums[i]]+nums[i]);
            }
        }
        if(dp[sum]==sum) return true;
        return false;
    }
    //最后一块石头的重量2 https://leetcode.cn/problems/last-stone-weight-ii/
    public int lastStoneWeightII(int[] stones) {
        int sum=0;
        int length=stones.length;
        // if(length==2)
        // return stones[0]-stones[1]>=0? stones[0]-stones[1]:stones[1]-stones[0];
        int[] dp =new int[15001];
        Arrays.fill(dp,0);
        for(int i=0;i<length;i++) sum+=stones[i];

        for(int i=0;i<length;i++){
            for(int j=sum/2;j>=stones[i];j--){
                dp[j]=Math.max(dp[j],dp[j-stones[i]]+stones[i]);
            }
        }
        return sum-dp[sum/2]-dp[sum/2];
    }
    //目标和 https://leetcode.cn/problems/target-sum/
    public int findTargetSumWays(int[] nums, int target) {
        int length=nums.length;
        int sum=0;
        for(int i=0;i<length;i++) sum+=nums[i];
        int t;
        if(Math.abs(target)>sum) return 0;
        if((sum+target)%2==1) return 0;
        t=(sum+target)/2;
        int[] dp =new int[t+1];
        Arrays.fill(dp,0);
        dp[0]=1;
        for(int i=0;i<length;i++){
            for(int j=t;j>=nums[i];j--){
                dp[j]+=dp[j-nums[i]];
            }
        }
        return dp[t];

    }
    //1和0 https://leetcode.cn/problems/ones-and-zeroes/
    public int findMaxForm(String[] strs, int m, int n) {
        int max=0;
        int[][] dp =new int[m+1][n+1];
        for(String str:strs){
            int num0=0,num1=0;
            for(int i=0;i<str.length();i++){
                if(str.charAt(i)=='0')num0++;
                else num1++;
            }
            for (int i = m; i >= num0; i--) { // 遍历背包容量且从后向前遍历！
                for (int j = n; j >= num1; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - num0][j - num1] + 1);
                }
            }
        }
        return dp[m][n];
    }
    //零钱兑换2 https://leetcode.cn/problems/coin-change-2/
    public int change(int amount, int[] coins) {
        int [] dp =new int[amount+1];
        int length=coins.length;
        Arrays.fill(dp,0);
        dp[0]=1;
        for(int i=0;i<length;i++){
            for(int j=coins[i];j<=amount;j++){
                dp[j]=dp[j]+dp[j-coins[i]];
            }
        }
        return  dp[amount];
    }
    //组合总和4 https://leetcode.cn/problems/combination-sum-iv/
    public int combinationSum4(int[] nums, int target) {
        int length=nums.length;
        int[] dp = new int [target+1];
        Arrays.fill(dp,0);
        dp[0]=1;
        for(int i=0;i<=target;i++){
            for(int j=0;j<length;j++){
                if(i-nums[j]>=0)
                    dp[i]+=dp[i-nums[j]];
            }
        }
        return dp[target];

    }
    //爬楼梯 https://leetcode.cn/problems/climbing-stairs/
    public int climbStairs(int n) {
        int[] dp=new int[n+1];
        Arrays.fill(dp,0);
        if(n<=2) return n;
        dp[1]=1;
        dp[2]=2;
        for(int i=3;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
    //零钱兑换 https://leetcode.cn/problems/coin-change/
    public int coinChange(int[] coins, int amount) {
        int[] dp =new int[amount+1];
        Arrays.fill(dp,amount+1);
        dp[0]=0;
        for(int i=1;i<=amount;i++){
            for(int cion:coins){
                if(i-cion>=0){
                    dp[i]=Math.min(dp[i],dp[i-cion]+1);
                }
            }
        }
        return dp[amount]==(amount+1) ? -1: dp[amount];
    }
    //完全平方数 https://leetcode.cn/problems/perfect-squares/
//    public int numSquares(int n) {
//        int value=(new Double(n)).intValue();
//        if(Math.sqrt(n)==value) return 1;
//        int[] dp =new int[n+1];
//        Arrays.fill(dp,value+1);
//        dp[0]=0;
//        for(int i=0;i<=n;i++){
//            for(int j=1;j*j<=i;j++){
//                if(i-j*j>=0){
//                    dp[i]=Math.min(dp[i],dp[i-j*j]+1);
//                }
//            }
//        }
//        return dp[n];
//    }
    //单词拆分 https://leetcode.cn/problems/word-break/
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> ss =new HashSet<>();
        for(String str: wordDict){
            ss.add(str);
        }
        boolean[] dp=new boolean[s.length()+1];
        Arrays.fill(dp,false);
        dp[0]=true;
        for(int i=1;i<=s.length();i++){
            for(int j=0;j<i;j++){
                if(ss.contains(s.substring(j,i))&&dp[j]){
                    dp[i]=true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
    //打家劫舍 https://leetcode.cn/problems/house-robber/
    public int rob(int[] nums) {
        if(nums.length==0)
            return 0;
        if(nums.length==1)
            return nums[0];
        if(nums.length==2)
            return nums[0]>nums[1]? nums[0]:nums[1];
        int[] dp=new int[nums.length];
        dp[0]=nums[0];
        dp[1]=Math.max(nums[1],dp[0]);
        for(int i=2;i<nums.length;i++){
            dp[i]=Math.max(dp[i-1],nums[i]+dp[i-2]);
        }
        return dp[nums.length-1];
    }
    //打家劫舍2 https://leetcode.cn/problems/house-robber-ii/
    private int rob1(int[] nums, int begin,int end) {
        if(begin==end) return nums[begin];
        int[] dp=new int[nums.length];
        dp[begin]=nums[begin];
        dp[begin+1]=Math.max(nums[begin],nums[begin+1]);
        for(int i=begin+2;i<=end;i++){
            dp[i]=Math.max(dp[i-1],nums[i]+dp[i-2]);
        }
        return dp[end];
    }
    public int rob2(int[] nums) {
        if(nums.length==0)
            return 0;
        if(nums.length==1)
            return nums[0];
        int r1=rob1(nums,0,nums.length-2);
        int r2=rob1(nums,1,nums.length-1);
        return r1>r2? r1:r2;
    }
    //打家劫舍3 https://leetcode.cn/problems/house-robber-iii/
    public int[] robtree(TreeNode root){
        if(root==null) return new int[]{0, 0};
        int[] left=robtree(root.left);
        int[] right=robtree(root.right);
        int val =root.val+left[0]+right[0];
        int val2 = Math.max(left[0],left[1])+Math.max(right[0],right[1]);
        return new int[]{val2,val};
    }
    public int rob3(TreeNode root) {
        int[] res = robtree(root);
        return Math.max(res[0],res[1]);
    }
    //买股票的最佳时机 https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/
    public int maxProfit(int[] prices) {
        int res=0;
        int min=prices[0];
        for(int i=1;i<prices.length;i++){
            if(min>prices[i])
                min=prices[i];
            if(res<prices[i]-min)
                res=prices[i]-min;
        }
        return res;
    }
    //买股票的最佳时机2 https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii/
    public int maxProfit2(int[] prices) {
        //dp[i][1]第i天持有的最多现金
        //dp[i][0]第i天持有股票后的最多现金
        int n=prices.length;
        int[][]dp=new int[n][2];
        dp[0][0]-=prices[0];
        for(int i=1;i<n;i++){
            //第i天持股票所剩最多现金=max(第i-1天持股票所剩的现金，第i-1天持现金-买第i天的股票)
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]-prices[i]);
            //dp[i][1]第i天持有最多现金=max(第i-1天持最多现金，第i-1天持有股票的最多现金+第i天卖出股票)
            dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0]+prices[i]);
        }
        return Math.max(dp[n-1][0],dp[n-1][1]);
    }
    //未完成
    //买股票的最佳时机3 https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-iii/
    public int maxProfit3(int[] prices) {
        return 1;
    }
    //未完成
    //买股票的最佳时机4 https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-iv/
    public int maxProfit4(int k, int[] prices) {
        return 1;
    }


    //https://leetcode.cn/problems/li-wu-de-zui-da-jie-zhi-lcof/
    //剑指 Offer 47. 礼物的最大价值
    public int maxValue(int[][] grid) {
            int m=grid.length;
            int n=grid[0].length;
            int dp[] [] =new int[m][n];
//            dp[0][0]=grid[0][0];
            for (int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    if(i>0){
                        dp[i][j]=Math.max(dp[i-1][j],dp[i][j]);
                    }
                    if(j>0){
                        dp[i][j]=Math.max(dp[i][j],dp[i][j-1]);
                    }
                    dp[i][j]+=grid[i][j];
                }
            }
            return dp[m-1][n-1];


    }


    //https://leetcode.cn/problems/minimum-recolors-to-get-k-consecutive-black-blocks/
    //得到K个黑块的最少涂色次数
    public int minimumRecolors(String blocks, int k) {
        int l = 0, r = 0, cnt = 0;
        while (r < k) {     //得到cnt是需要涂白的块数，
            cnt += blocks.charAt(r) == 'W' ? 1 : 0;
            r++;
        }
        int res = cnt;
       while(r<blocks.length())
       {
           cnt+=blocks.charAt(r++)=='W'?1:0; //右边的
           cnt-=blocks.charAt(l++)=='W'?1:0; //左边的
           res=Math.min(res,cnt);
       }
        return res;
    }


    /**
     *https://leetcode.cn/problems/minimum-deletions-to-make-string-balanced/
     *使字符串平衡的最少删除次数
     *
     * 动态规划
     * 1.我们关注第i个字符，如果这个字符串是B，那么他这个字符串的平衡与前i-1一样，我们只需要把preb++
     * 如果这个字符串是a，那么有两种方式，要么把字符串i-1中出现的B全部删掉，要么，把这个a删掉，这里我们取最小值就行
     * dp记录是前i-1中达到平衡需要删除的字符串数量
     * preb记录前面出现的b的数量
     * 也就是当前dp=min(dp+1,preb)
     *
     *
     * @param s
     * @return
     */
    public int minimumDeletions(String s) {
        int dp=0;
        int preb=  s.charAt(0)=='b'? 1:0;
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)=='a'){
                dp=Math.min(dp+1,preb);
            }
            else{
                preb++;
            }

        }
        return dp;
    }



        public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
            int wait=0;
            int n=customers.length;
            int maxllirun=0;
            int nowlirun=0,i=0;
            int minr=-1;
            while(wait>0||i<n){
                wait+=i<n? customers[i] :0;
                int up=Math.min(4,wait);
                wait-=up;
                i++;
                nowlirun+=up*boardingCost-runningCost;
                if(nowlirun>maxllirun){
                    maxllirun=nowlirun;
                    minr=i;
                }

            }
            return minr;
        }

    /**
     * https://leetcode.cn/problems/making-file-names-unique/
     * 保证文件名唯一
      * @param names
     * @return
     */
    public String[] getFolderNames(String[] names) {
            HashMap<String,Integer> same=new HashMap<String,Integer>();
            String [] res=new String[names.length];
            for(int i=0;i<names.length;i++){
                if(same.containsKey(names[i])){
                    int index=same.get(names[i]);

                    while(same.containsKey(addname(names[i],index))){
                        index++;
                    }
                    res[i]=addname(names[i],index);
                    same.put(names[i],index+1);
                    same.put(addname(names[i],index),1);
                }
                else{
                    same.put(names[i],1);
                    res[i]=names[i];

                }


            }
            return res;
     }
     private String addname(String name, int k){
        return name+"("+Integer.toString(k)+")";
     }



    //
    public String printBin(double num) {

        StringBuffer tmp=new StringBuffer("0.");
        int t=0;
        if(num==0){
            return "0";
        }
        while (t<30&&num!=0){
            double r=num*2;
            if(r>=1){
                tmp.append('1');
                num=r-1;
            }
            else{
                tmp.append('0');
                num=r;
            }
            t++;
        }
        if(num!=0){
            return "ERROR";
        }
        return String.valueOf(tmp);

    }


    public int[][] largestLocal(int[][] grid) {
        int lenth=grid.length;
        int[][] res=new int[lenth-2][lenth-2];
        for(int i=0;i<lenth-2;i++){
            for(int j=0;j<lenth-2;j++)
            {
                res[i][j]=localmax(grid,i,j);
            }
        }
        return res;
    }

    private  int localmax(int[][]grid,int l,int r){
        int max=grid[l][r];
        for(int i=l;i<l+3;i++){
            for(int j=r;j<r+3;j++){
                max=grid[i][j]>max?grid[i][j]:max;
            }
        }
        return max;

    }

    /**https://leetcode.cn/problems/merge-similar-items/
     *2363. 合并相似的物品
     * @param items1
     * @param items2
     * @return
     */
    public static List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        List<List<Integer>> im1=new ArrayList<List<Integer>>();
        List<List<Integer>> im2=new ArrayList<List<Integer>>();
        for(int i=0;i<items1.length;i++){
            im1.add(Arrays.asList(items1[i][0],items1[i][1]));
        }
        for(int i=0;i<items2.length;i++){
            im2.add(Arrays.asList(items2[i][0],items2[i][1]));
        }
        im1.sort(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
               return o1.get(0)> o2.get(0)?1 :-1;
            }
        });
        im2.sort(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return o1.get(0)> o2.get(0)?1 :-1;
            }
        });
//        System.out.println(im1);
//        System.out.println(im2);
        int i=0,j=0;
        while (i<im1.size()&&j<im2.size()){
            if(im1.get(i).get(0).equals(im2.get(j).get(0))){
                res.add(Arrays.asList(im1.get(i).get(0),im1.get(i).get(1)+im2.get(j).get(1)));
                i++;
                j++;
            }
            else if(im1.get(i).get(0)>(im2.get(j).get(0))){
                res.add(Arrays.asList(im2.get(j).get(0),im2.get(j).get(1)));
                j++;
            }
            else{
                res.add(Arrays.asList(im1.get(i).get(0),im1.get(i).get(1)));
                i++;
            }
        }
        while(i< im1.size()){
            res.add(Arrays.asList(im1.get(i).get(0),im1.get(i).get(1)));
            i++;
        }
        while(j< im2.size()){
            res.add(Arrays.asList(im2.get(j).get(0),im2.get(j).get(1)));
            j++;
        }
        return res;
    }


    public int minimumOperations(int[] nums) {
        Map<Integer,Integer>t=new HashMap<>();
        int res=0;
        for (int i:nums ) {
            if(i!=0&&!t.containsKey(i)){
                    res++;
                    t.put(i,1);
                }

            }
        return res;

    }


    /**
     * https://leetcode.cn/problems/find-longest-subarray-lcci/
     * 前缀和
     * @param array
     * @return
     */
    public String[] findLongestSubarray(String[] array) {
        Map<Integer,Integer> temp=new HashMap<>();
        temp.put(0,-1);
        int begin=-1,maxl=0;
        int sum=0;
        for(int i=0;i< array.length; i++){
                char x=array[i].charAt(0);
            if(x>='0'&&x<='9'){
                sum++;
            }
            else {
               sum--;
            }

            if(temp.containsKey(sum)){
                if((i- temp.get(sum)>maxl)){
                    maxl=i-temp.get(sum);
                    begin=temp.get(sum)+1;
                }

            }
            else{
                temp.put(sum,i);
            }
        }

        if(maxl==0) return new String[]{};
        String [] res=new String[maxl];
        System.arraycopy(array, begin, res, 0, maxl);
        return res;
    }

    /**
     * https://leetcode.cn/problems/jump-game-ii/
     * 贪心算法
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        if(nums==null||nums.length==1||nums.length==0) return 0;

        int steps=0;
        int n=nums.length;
        int maxdistence=0;
        int curdistance=0;
        int i=0;
        while(i<n){
            maxdistence=Math.max(maxdistence,i+nums[i]);
            if(maxdistence>=n-1){
                steps++;
                return steps;
            }
            if(i==curdistance){
                curdistance=maxdistence;
                steps++;
            }

            i++;
        }


        return steps;
    }


    public int[][] merge(int[][] intervals) {

        int length=intervals.length;
        if(length==0) return new int[][]{};
        Arrays.sort(intervals,(x1,x2)->x1[0]!=x2[0]? Integer.compare(x1[0],x2[0]):Integer.compare(x1[1],x2[1])  );
        int[][] res=new int[length][2];
        int begin=intervals[0][0];
        int end=intervals[0][1];
        int index=0;
        for(int i=1;i<length;i++){
            if(intervals[i][0]<end){
                end= end<intervals[i][1]? intervals[i][1]:end;
            }else{
                res[index][0]=begin;
                res[index++][1]=end;
                begin=intervals[i][0];
                end=intervals[i][1];
            }


        }
        res[index][0]=begin;
        res[index][1]=end;
        return Arrays.copyOfRange(res,0,index+1);

    }


    public boolean isValidSudoku(char[][] board) throws InterruptedException {
        //记录行
        boolean[][] row =new boolean[9][9];
        //记录列
        boolean[][]col =new boolean[9][9];
        //记录小正方形
        boolean[][]block = new boolean[9][9];
            String s=new String();
            s.wait();
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]!='.'){
                    int num=board[i][j]-'0'-1;
                    if(row[i][num]||col[num][i]||block[i/3*3+j/3][num]){
                        return false;
                    }
                    else{
                        row[i][num]=true;
                        col[num][j]=true;
                        block[i/3*3+j/3][num]=true;
                    }
                }

            }
        }

        return true;
    }



//
    public static void main(String[] args) {
//        final int sl;
//        int[][] r={{1,1},{4,5},{3,8}};
//        int[][] r2={{1,5},{3,1}};
//        List<List<Integer>>res=mergeSimilarItems(r,r2);
//        System.out.println(res);

        List<Integer> list=new LinkedList<>();
        list.add(1);
        list.add(2);

        //迭代器遍历--正向输出
        ListIterator<Integer> it = list.listIterator();
        while(it.hasNext()){//1：boolean hasNext()判断集合中是否有元素，如果有元素可以迭代，就返回true。
            System.out.print(it.next()+" ");//2： E next()返回迭代的下一个元素
        }

        System.out.println("\n========================");

        //迭代器遍历--反向输出
        ListIterator<Integer> rit = list.listIterator(list.size());
        while (rit.hasPrevious()){
            System.out.print(rit.previous() +" ");
        }


//
//        for (int y:tt
//             ) {
//            System.out.println(y);
//
//        }
//        System.out.println(tt);

    }
//


}
