package com.java.demo;

import java.util.*;

/**
 * 贪心算法相关题目，来源leetcode
 * date: 20220531
 * author：nsf
 * cite form 代码随想录
 */
public class tanxin {
    //分发饼干  https://leetcode-cn.com/problems/assign-cookies/
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(s);
        int res=0;
        for(int i=0;i<g.length;i++){
            for(int j=0;j<s.length;j++){
                if(s[j]>=g[i]){
                    s[j]=0;
                    res++;
                    break;
                }

            }
        }
        return res;
    }
    //摆动序列 https://leetcode.cn/problems/wiggle-subsequence/
    public int wiggleMaxLength(int[] nums) {
        if(nums.length==1) return 1;
        int res=1;
        int pre=0;
        int cur=0;
        for(int i=0;i< nums.length-1;i++){
            cur=nums[i+1]-nums[i];
            if(cur>0&&pre<=0 ||cur<0&&pre>=0){
                res++;
                pre=cur;
            }
        }
        return res;
    }
    //最大子序和 https://leetcode.cn/problems/maximum-subarray/
    public int maxSubArray(int[] nums) {
        int max=nums[0];
        int length=nums.length;
        int temp=nums[0];
        for(int i=1;i<length;i++)
        {
            if(temp+nums[i]>=nums[i])
            {
                temp=temp+nums[i];
            }
            else{
                temp=nums[i];
            }
            if(temp>max){
                max=temp;
            }

        }
        return max;
    }

//    public int maxProfit(int[] prices) {
//            int pre=prices[0];
//            int sum=0;
//            if(prices.length==1 ) return prices[0];
//        for (int i = 0; i < prices.length; i++) {
//            if(prices[i]>pre){
//                sum=sum+prices[i]-pre;
//            }
//            pre=prices[i];
//
//        }
//        return sum;
//    }
    //买股票的最佳时机2 https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii/
    public int maxProfit(int[] prices) {
        int res=0;
        for(int i=0;i<prices.length-1;i++){
            if(prices[i+1]-prices[i]>0) res+=(prices[i+1]-prices[i]);
        }
        return res;
    }

//    public boolean canJump(int[] nums) {
//        int fanwei=nums[0]+1;
//        if(nums[0]==0 ) {
//            if(nums.length==1)
//                return true;
//            return false;
//        }
//        for(int i=1;i< nums.length;i++){
//            int t=i+1+nums[i];
//            fanwei=t>fanwei?t:fanwei;
//            if(fanwei>=nums.length) {
//                return true;
//            }
//            if(fanwei==(i+1))return false;
//
//        }
//        return fanwei>= nums.length? true:false;
//    }



    //跳跃游戏 https://leetcode.cn/problems/jump-game/
    public boolean canJump(int[] nums) {
        if(nums[0]==0 ) {
            if(nums.length==1)
                return true;
            return false;
        }
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]==0) {
                int t=1;
                for(int j=i-1;j>=0;j--){
                    if(nums[j]>t) break;
                    t++;
                }
                if(t-1==i) return false;
            }
        }
        return true;

    }



    //跳跃游戏2 https://leetcode.cn/problems/jump-game-ii/

//    public int jump(int[] nums) {
//        int length= nums.length;
//        int curmax=0;
//        int max=0;
//        int res=0;
//        for (int i=0;i<length-1;i++){
//            max=max>(i+nums[i])? max:(i+nums[i]);
//            if(i==max){
//                curmax=max;
//                res++;
//            }
//        }
//        return res;
//    }
    public int jump(int[] nums) {
        int length= nums.length;
        int nextcover=0, nowcover=0,res=0;
        if(length==1) return 1;
        for(int i=0;i<length;i++){
            nextcover= Math.max(i+nums[i],nextcover);
            if(i==nowcover) {
                if(nowcover!=length-1){
                    res++;
                    nowcover=nextcover;
                    if(nextcover>=length-1) break;
                }
                else break;

            }

        }
        return res;
    }
    //K 次取反后最大化的数组和 https://leetcode.cn/problems/maximize-sum-of-array-after-k-negations/
/*    public int largestSumAfterKNegations(int[] nums, int k) {
        Integer [] num =new Integer[nums.length];
        for (int i = 0; i < num.length; i++) {
            num[i]=nums[i];
        }
        Arrays.sort(num,(a,b)-> Math.abs( b)-Math.abs( a)
        );
        for (int i = 0; i < num.length; i++) {
            if(num[i]<0&&k>0){
                num[i]=-num[i];
                k--;
            }
        }
        if(k%2==1) num[num.length-1]=-num[num.length-1];
        int sum=0;
        for (int i = 0; i < num.length; i++) {
            sum+=num[i];
        }

        return sum;

    }*/



    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        int res=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<0&&k>0){
                nums[i]=-nums[i];
                k--;
            }
            else if(nums[i]==0&&k>0){
                k=0;
                break;
            }
            else if(nums[i]>0&&k>0){
                if(i-1>=0){
                    if(nums[i-1]>0&&nums[i-1]<nums[i]){
                        if(k%2==0){
                            break;
                        }
                        else{
                            nums[i-1]=-nums[i-1];
                            k=0;
                            break;
                        }
                    }
                    else{
                        if(k%2==0)break;
                        else{
                            nums[i]=-nums[i];
                            k=0;
                            break;
                        }
                    }
                }
                if(i==0){
                    if(k%2==0)break;
                    else{
                        nums[i]=-nums[i];
                        k=0;
                        break;
                    }
                }

            }
        }
        if(k>0){
            Arrays.sort(nums);
            if(k%2==1){
                nums[0]=-nums[0];
                k=0;
            }
        }
        for(int i=0;i<nums.length;i++)res+=nums[i];
        return res;
    }
    //分发糖果 https://leetcode.cn/problems/candy/
    public int candy(int[] ratings) {
        int res=0;
        int length=ratings.length;
        int[] candies=new int[length];
        Arrays.fill(candies,1);
        if(length==1) return 1;
        for(int i=1;i<length;i++){
            if(ratings[i]>ratings[i-1]){
                candies[i]+=candies[i-1];
            }
        }
        for(int i=length-2;i>=0;i--){
            if(ratings[i]>ratings[i+1]&&candies[i]<=candies[i+1]){
                candies[i]=candies[i+1]+1;
            }
        }
        for(int i=0;i<length;i++) res+=candies[i];
        return res;
    }
    //柠檬水找零 https://leetcode.cn/problems/lemonade-change/
    public boolean lemonadeChange(int[] bills) {
        int sum5=0,sum10=0;
        int length=bills.length;

        for(int i=0;i<length;i++){
            if(bills[i]==5){
                sum5++;
            }
            if(bills[i]==10){
                sum10++;
                if(sum5>0) sum5--;
                else return false;
            }
            if(bills[i]==20){
                if(sum10>0){
                    sum10--;
                    if(sum5>0) sum5--;
                    else return false;
                }
                else if(sum5>2)sum5-=3;
                else return false;
            }
        }
        return true;
    }
    //根据身高重建队列 https://leetcode.cn/problems/queue-reconstruction-by-height/
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people,(x1,x2)->{
            if (x1[0] != x2[0]){
                return x2[0]-x1[0];
            }else {
                return x1[1]-x2[1];
            }
        });
        LinkedList<int[]> que = new LinkedList<>();

        for (int[] p : people) {
            que.add(p[1],p);//按照index（p[1]）进行插入，这是一个链表结构。
        }

        return que.toArray(new int[people.length][]);

    }
    //用最少数量的箭引爆气球 https://leetcode.cn/problems/minimum-number-of-arrows-to-burst-balloons/
    public int findMinArrowShots(int[][] points) {
        int length=points.length;
        if(length==1) return 1;
        Arrays.sort(points, (x1,x2)-> x1[0]!=x2[0]? Integer.compare(x1[0],x2[0]): Integer.compare(x1[1],x2[1]) );
//        for(int i=0;i<length;i++){
//            System.out.print(points[i][0]+" "+points[i][1]+"\n");
//        }
        for(int i=1;i<length;i++){
            int temp=points[i-1][1]-points[i][0];
            if(temp>=0&&points[i-1][1]>=points[i][0]){
                points[i][1]=Math.min(points[i-1][1],points[i][1]);
                points[i-1][0]=0;
                points[i-1][1]=-1;
            }
        }
        for(int i=0;i<length;i++){
            System.out.print(points[i][0]+" "+points[i][1]+"\n");
        }
        int res=0;
        for(int i=0;i<length;i++){
            if(points[i][0]>points[i][1]) continue;
            else res++;
        }
        return res;
    }
    // 无重叠区间 https://leetcode.cn/problems/non-overlapping-intervals/
    public int eraseOverlapIntervals(int[][] intervals) {
        int length=intervals.length;
        if(length==1) return 0;
        Arrays.sort(intervals,new Comparator<int [] >(){
            public int compare(int [] a1,int [] a2) {
                return a1[1] - a2[1];   //升序排列
            }
        });
//        for(int i=0;i<length;i++){
//            System.out.print(intervals[i][0]+" "+intervals[i][1]+"\n");
//        }
        int count = 1;	//最多能组成的不重叠区间个数
        int end = intervals[0][1];
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][0] < end) {
                continue;
            }
            end = intervals[i][1];
            count++;
            System.out.println(end);
        }
        return intervals.length - count;
    }
    //划分字母区间    https://leetcode.cn/problems/partition-labels/
    public List<Integer> partitionLabels(String s) {
        int[] dic=new int[26];
        List<Integer> list = new ArrayList();
        for(int i=0;i<s.length();i++){
            dic[s.charAt(i)-'a']=i;
        }

        int left=0;
        int right=0;
        for(int i=0;i<s.length();i++){
            if(dic[s.charAt(i)-'a']>right) right=dic[s.charAt(i)-'a'];
            if(i==right){
                list.add(right-left+1);
                left=i+1;
            }
        }

        return list;
    }
    //合并区间 https://leetcode.cn/problems/merge-intervals/
    public int[][] merge(int[][] intervals) {
        int length=intervals.length;
        Arrays.sort(intervals, (x1,x2)-> x1[0]!=x2[0]? Integer.compare(x1[0],x2[0]): Integer.compare(x1[1],x2[1]) );
//        for(int i=0;i<length;i++){
//            System.out.print(intervals[i][0]+" "+intervals[i][1]+"\n");
//        }
        for(int i=1;i<length;i++){
            int temp=intervals[i-1][1]-intervals[i][0];
            if(temp>=0&&intervals[i-1][1]>=intervals[i][0]){
                intervals[i][0]=intervals[i-1][0];
                intervals[i][1]=Math.max(intervals[i-1][1],intervals[i][1]);
                intervals[i-1][0]=-1;
                intervals[i-1][1]=-1;
                i--;
            }
        }
//        for(int i=0;i<length;i++){
//            System.out.print(intervals[i][0]+" "+intervals[i][1]+"\n");
//        }

        LinkedList<int[]> res = new LinkedList<>();

        for (int[] p : intervals) {
            if(p[0]!=-1)
                res.add(p);
        }

        return res.toArray(new int[res.size()][]);

    }
    // 买卖股票的最佳时机含手续费 https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
    public int maxProfit(int[] prices, int fee) {
        int res=0;
        int minprices=500001;
        for(int i=0;i<prices.length;i++){
            if(prices[i]<minprices) minprices=prices[i];
            if(prices[i]>minprices+fee){
                res+= prices[i]-minprices-fee;
                minprices=prices[i]-fee;
            }
        }
        return res;
    }
    //  监控二叉树   https://leetcode.cn/problems/binary-tree-cameras/
    //后序处理，
    int result;
    private  int travealsal(TreeNode cur){
        //空节点,该节点有覆盖
        if(cur==null) return 2;
        int left=travealsal(cur.left);
        int right= travealsal(cur.right);

        //case 1
        //左右节点都有覆盖
        if(left==2&&right==2) return 0;
        //case2
        //left==0 &&right==0 都无覆盖
        //left==1 &&right==0左节点有摄像头，右没有
        //left==0 &&right==1左没有，右有
        //left==0 &&right==2 左没有，右被覆盖
        //left==2 &&right==0 左覆盖，右没有
        if(left==0||right==0){
            result++;
            return 1;
        }
        //case 3
        //left==1 &&right==2 左节点有摄像头,右节点被覆盖
        //left==2 &&right==1左节点被覆盖，右节点有摄像头
        //left==1 &&right==1 左右都有摄像头
        if(left==1||right==1) return 2;
        return -1;
    }
    //简化版本
    private int travealsal1(TreeNode cur){
        if(cur==null) return 2;
        int left=travealsal1(cur.left);
        int right=travealsal1(cur.right);
        if(left==2&&right==2) return 0;
        else if(left==0||right==0){
            result++;
            return 1;
        }
        else  return 2;
    }
    public int minCameraCover(TreeNode root) {
        result=0;
        //case 4
        if(travealsal1(root)==0){
            result++;
        }
        return result;
    }


    /**
     * https://leetcode.cn/problems/find-valid-matrix-given-row-and-column-sums/
     * 给定行和列的和求满足的矩阵
     *使用贪心算法，因为行的和与列的和是相等的，所以我们对于矩阵的每一个位置，我们都用当前行和列的最小值作为当前值，然后不断更新行的和与列的和，直到为0
     * */

    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int[][] res=new int[rowSum.length][colSum.length];
        for (int i = 0; i < rowSum.length; i++) {
            for (int j = 0; j < colSum.length; j++) {
                res[i][j]=0;
                int min=rowSum[i]<colSum[j]?rowSum[i]:colSum[j];
                if(min==0){
                    continue;
                }
                res[i][j]=min;
                rowSum[i]-=min;
                colSum[j]-=min;

            }
        }
        return res;



    }

}
