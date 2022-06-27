package com.java.demo;


/***
 * this is a test
 *
 *
 */

import com.sun.deploy.util.ArrayUtil;

import java.util.*;


class Solution {


    public int[] twoSum(int[] nums, int target) {
        int length= nums.length;
        int temp[]=new int[2];
        for(int i=0; i<length-1;i++)
        {
            for(int j=i+1; j<length;j++)
            {
                if(nums[i]+nums[j]==target)
                {
                    temp[0]=i;
                    temp[1]=j;
                    return temp;
                }
            }

        }
        return null;
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m=nums1.length;
        int n=nums2.length;
        if(m==0||n==0)
        {
            if(m==0)
            {
                if(n%2==0)
                    return (nums2[n/2-1]+nums2[n/2])/2.0;
                return nums2[n/2];
            }
            if(n==0)
            {
                if(m%2==0)
                    return (nums1[m/2-1]+nums1[m/2])/2.0;
                return nums1[m/2];
            }
        }
        else if((m+n)%2==0)
        {
            int tagert1=((m+n))/2;
            int sum[]=new int[m+n];
            int i=0,j=0,t=0;
            while(i<m&&j<n){
                if(nums1[i]<=nums2[j]){
                    sum[t++]=nums1[i++];

                }
                else{
                    sum[t++]=nums2[j++];
                }

                if(t-1==tagert1)
                {
                    return (sum[tagert1-1]+sum[tagert1])/2.0;
                }
            }
            while (i<m)
            {
                sum[t++]=nums1[i++];
            }
            while (j<n)
            {
                sum[t++]=nums2[j++];
            }
            return (sum[tagert1]+sum[tagert1-1])/2.0;
        }
        else {
            int tagert1 = ((m + n)) / 2;
            int sum[] = new int[m + n];
            int i = 0, j = 0, t = 0;
            while (i < m && j < n) {
                if (nums1[i] <= nums2[j]) {
                    sum[t++] = nums1[i++];

                } else {
                    sum[t++] = nums2[j++];
                }

                if (t - 1 == tagert1) {
                    return sum[t - 1];
                }
            }
            while (i < m) {
                sum[t++] = nums1[i++];
            }
            while (j < n) {
                sum[t++] = nums2[j++];
            }
            return sum[tagert1];
        }
        return 0;
    }
    public int leastInterval(char[] tasks, int n) {
            int[] arr = new int[26];
            for (char c : tasks) {
                arr[c - 'A']++;
            }
            int max = 0;
            for (int i = 0; i < 26; i++) {
                max = Math.max(max, arr[i]);
            }
            int ret = (max - 1) * (n + 1);
            for (int i = 0; i < 26; i++) {
                if (arr[i] == max) {
                    ret++;
                }
            }
            return Math.max(ret, tasks.length);
        }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        boolean[] flag=new boolean[nums.length];
        List<Integer> res=new ArrayList<>();
        int t=0;
        res.size();
        for(int i=0;i<nums.length;i++){
            flag[nums[i]-1]=true;
        }
        for(int i=0;i<flag.length;i++)
        {
            if(!flag[i])
            {
               res.add(i+1);
            }
        }
        return res;

    }

    public void nextPermutation(int[] nums) {
        int flag=0;
        int length=nums.length;
        int weizhi1=length-1;
        if(length==1)
            return;
        for(int i=length-1;i>0;i--){
            if(nums[i]>nums[i-1])
            {
                weizhi1=i-1;
                flag=1;
                break;
            }
        }
        if(flag==0)
        {
            Arrays.sort(nums,0,length);
            return;
        }
        System.out.println(weizhi1);
        System.out.print(nums[0]);
        System.out.print(nums[1]);
        System.out.println(nums[2]);
        Arrays.sort(nums,weizhi1+1,length);
        System.out.print(nums[0]);
        System.out.print(nums[1]);
        System.out.println(nums[2]);
        for(int i=weizhi1+1;i<length;i++)
        {
            if(nums[i]>nums[weizhi1]){
                int t=nums[i];
                nums[i]=nums[weizhi1];
                nums[weizhi1]=t;
                break;
            }
        }

    }



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



}
public class main {
    public static  int q =0;

    public static void main(String[] args) {
        offer a=new offer();
//        int[] nums=new int[]{1,2,1,1,2};
        System.out.println(a.isNumber(" "));
//        int[] nums=new int[]{87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78,87,78};
//        int x1=0,x2=0,x3=0;
//        for(int i=0;i< nums.length-1;i++){
//            if(nums[i]==nums[i+1])
//                System.out.println(nums[i]);
//            if(nums[i]==87){
//                x1++;
//            }
//            if(nums[i]==78){
//                x2++;
//            }
//            else
//                x3++;
//        }
//        System.out.println(x1);
//        System.out.println(x2);
//        System.out.println(x3);
//        int res=a.lastRemaining(70866,116922);
//        System.out.println(res);
        //        List<String> string=new ArrayList<>();
//        string.add("nsf");
//        string.add("jfz");
//        string.get(0),string.get(0).replace(string.get(0).charAt(2), 'x');
//        System.out.println(Math.pow(10,3));
//        Map<String, Map<String, Integer>> targets = new HashMap();
//        List<List<String>> tickets=new ArrayList<>();
//        tickets.add(Arrays.asList("JFK","SFO"));
//        tickets.add(Arrays.asList("JFK","ATL"));
//        tickets.add(Arrays.asList("SFO","ATL"));
//        tickets.add(Arrays.asList("ATL","JFK"));
//        tickets.add(Arrays.asList("ATL","SFO"));
//        tickets.sort((o1,o2)->o1.get(1).compareTo(o2.get(1)));
//        System.out.println(tickets);
//        for(List<String>v:tickets){
//            // Map<出发机场, map<到达机场, 航班次数>> targets
//            Map<String, Integer> temp=new HashMap();
//            if(targets.containsKey(v.get(0))){
//                temp=targets.get(v.get(0));
//                if(temp.containsKey(v.get(1))){
//                    temp.replace(v.get(1), temp.get(v.get(1))+1);
//                }else{
//                    temp.put(v.get(1),1);
//                }
//                targets.replace(v.get(0),temp);
//            }
//            else{
//                temp.put(v.get(1),1);
//                targets.put(v.get(0),temp);
//            }
//        }
//        System.out.println(targets);
//        for(Map<String,Integer>target: targets.values()){
//            System.out.println(target.size());
//        }


//        res.en
//        res.replace("nsf",tem);
//        res.put("nsf",res.get("nsf").replace());
//        System.out.println(res);
//          char[][]board=new char[][]{{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},
//                  {'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'},};
//          int[][]ttt=new int[][]{{9,12},{1,10},{4,11},{8,12},{3,9},{6,9},{6,7}};
//          System.out.println(ttt[0].length);
//        for(int i=0;i<board.length;i++) {
//            for (int j = 0; j < board[0].length; j++)
//                System.out.print(board[i][j] + " ");
//            System.out.println();
//        }
//        System.out.println("success");
//            huisu a=new huisu();
//                long begin=System.currentTimeMillis();
//                a.solveSudoku(board);
//                long end=System.currentTimeMillis();
//                for(int i=0;i<board.length;i++){
//                    for(int  j=0;j<board[0].length;j++)
//                        System.out.print(board[i][j]+" ");
//                    System.out.println();
//                }
//        System.out.println(end-begin+"ms");

//                char []bb=new char[]{'3'};
//                System.out.println(bb);
//                a.test(bb);
//                System.out.println(bb);
//        int[][] n=new int[][]{{1,2},{1,3},{2,3},{3,4}};
//        int nums2[]=new int[]{10,1,2,7,6,1,5,1};
////        int resu[]=new int[2];
//        TreeNode treeNode=new TreeNode(0);
//        TreeNode treeNode1=new TreeNode(1);
//        TreeNode treeNode2=new TreeNode(2);
//        TreeNode treeNode3=new TreeNode(2);
//        TreeNode treeNode4=new TreeNode(2);
//        treeNode.right=treeNode2;
//        treeNode.left=treeNode1;
//        treeNode2.right=treeNode3;
//        treeNode3.right=treeNode4;
//        //Solution x=new Solution();
//        tree tr=new tree();
//        tanxin tan=new tanxin();
//        System.out.println(x.isBalanced(treeNode));
//        ntree hha=new ntree();
//        int num1[]=new int[]{3,9,20,15,7};
//        int num2[]=new int[]{9,3,15,20,7,7};
//        sort s=new sort();
//        s.guibing_sort(num2);
//        for(int i=0;i<num2.length;i++)
//            System.out.print(num2[i]+"\t");
//        System.out.println();
//        huisu h=new huisu();
//        System.out.println(h.restoreIpAddresses("25525511135"));
//        res=x.merge(ttt);"bbbbbbbbbbbbbbbb"
//        x.pretree(treeNode);
//        x.midtree(treeNode);
//        x.posttree(treeNode);
       // List<Double> ha=x.averageOfLevels(treeNode);
//        for(int i=0;i< ha.length;i++)
            //System.out.println(ha);
//        x.nextPermutation(nums2);
//        System.out.print(nums2[0]);
//        System.out.print(nums2[1]);
//        System.out.println(nums2[2]);

       // int v=x.uniquePathsWithObstacles(n);
        //int tt=x.findTargetSumWays(nums1,-4);
        // \u000d // System.out.println(tt);
//        HashSet<String> s =new HashSet<>();
//        s.add("111");
//        s.add("222");
//        boolean[] dp=new boolean[5];
//        System.out.println(dp[1]);
//        List<String> xxx=new ArrayList<String>();
//        xxx.add("code");
//        xxx.add("leet");
//        System.out.println("leetcode".substring(0,2));
//        boolean f= x.wordBreak("leetcode",xxx);




    }
}
