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
    //买股票的最佳时机2 https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii/
    public int maxProfit(int[] prices) {
        int res=0;
        for(int i=0;i<prices.length-1;i++){
            if(prices[i+1]-prices[i]>0) res+=(prices[i+1]-prices[i]);
        }
        return res;
    }
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
    //未完成
    public int minCameraCover(TreeNode root) {
        return 0;
    }
}
