package com.java.demo;

public class sort {
    public void maopao(int[] nums){
        if(nums.length<=1) return;
        int max=0;
        for(int i=0;i<nums.length-1;i++){
            for(int j=0;j< nums.length-1-i;j++){
                if(nums[j]>nums[j+1]){
                    int t=nums[j];
                    nums[j]=nums[j+1];
                    nums[j+1]=t;
                }
            }
        }
    }
    public void xuanze(int[] nums){
        if(nums.length<=1) return;
        int max=0;
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j< nums.length;j++){
                if(nums[j]<nums[i]){
                    int t=nums[j];
                    nums[j]=nums[i];
                    nums[i]=t;
                }
            }
        }
    }
    public void insert_sort(int[] nums){
        if(nums.length<=1) return;
        int max=0;
        for(int i=1;i<nums.length;i++){
            int t=nums[i];
            for(int j=i;j>0;j--){
                if(nums[j]<nums[j-1]){
                    int tt=nums[j];
                    nums[j]=nums[j-1];
                    nums[j-1]=t;
                }
                else break;
            }
        }
    }
    public  void shell_sort(int[] nums){
        int j;
        for(int gap= nums.length/2;gap>0;gap/=2){
            for(int i=gap;i< nums.length;i++){
                int temp=nums[i];
                for(j=i;j>=gap&&temp<nums[j-gap];j-=gap){
                    nums[j]=nums[j-gap];
                }
                nums[j]=temp;
            }
        }
    }
    private void quick_sort(int[] nums,int l,int r){
        if(l+1>=r) return;
        if(r==0) return;
        int first=l,last= r-1,key=nums[first];
        while(first<last){
            while(first<last&&nums[last]>=key){
                --last;
            }
            nums[first]=nums[last];
            while(first<last&&nums[first]<key){
                ++first;
            }
            nums[last]=nums[first];
        }
        nums[first]=key;

        quick_sort(nums,l,first);
        quick_sort(nums,first+1,r);
    }

    public void quick_sort(int[] nums){
        quick_sort(nums,0, nums.length);
    }

}
