package com.java.demo;

import java.util.Arrays;

public class tu {

    public int maximalNetworkRank(int n, int[][] roads) {
        int[] degree =new int[n];
        boolean[][] connect=new boolean[n][n];
        for (int i = 0; i < roads.length; i++) {
            connect[roads[i][0]][roads[i][1]]=true;
            connect[roads[i][1]][roads[i][0]]=true;
            degree[roads[i][0]]+=1;
            degree[roads[i][1]]+=1;
        }
        int max=0;
        for (int i = 0; i <n; i++) {
            for (int j = i+1; j < n; j++) {
                int t=degree[i]+degree[j]-(connect[i][j]?1:0);
                max=max>t?max:t;
            }
        }
        return max;
    }


    /**
     * https://leetcode.cn/problems/count-subarrays-with-median-k/
     * @param nums
     * @param k
     * @return
     */
    public int countSubarrays(int[] nums, int k) {
        int ans=1; //这里要算上自身，所以初始化为1
        int length=nums.length;
        int [] cnt=new int[2*length+1];

        int index=0;
        for (int i = 0; i < length; i++) {
            if(nums[i]==k){
                index=i;
                break;
            }
        }
//        if (index==length-1) return 1;
        int cha=0;
        for (int i = index+1; i <length ; i++) {
            cha+=k>nums[i]? -1:1;
            if(cha>=0&&cha<=1){
                ans++;
            }
            cnt[cha+length]++;
        }

        cha=0;
        for (int i = index-1; i >-1 ; i--) {
            cha+=k>nums[i]? -1:1;
            if(cha>=0&&cha<=1){
                ans++;
            }
            ans+=cnt[length-cha]+cnt[length+1-cha];
        }
        return ans;


    }






}
