package com.java.demo;

import java.util.Arrays;

public class sort {
    //冒泡排序
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
    //选择排序，每次选择最小的放在前面
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
    //插入排序，认为前面一部分有序
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
    //希尔排序，跳着分组，
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
    //快速排序，找一个key，比key大的放后面，比key小的放前面
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
    //归并排序 https://www.runoob.com/data-structures/merge-sort.html
    public void guibing_sort(int[] nums){
        quick_sort(nums,0, nums.length);
    }
    private static void guibing_sort(Comparable[] arr, int l, int r) {
        if(l>=r){
            return;
        }
        int mid=(l+r)/2;
        guibing_sort(arr,l,mid);
        guibing_sort(arr,mid+1,r);
        if(arr[mid].compareTo(arr[mid+1])>0){
            merge(arr,l,mid,r);
        }
    }
    //将arr[l...mid]和arr[mid+1...r]两部分归并
    private static void merge(Comparable[] arr, int l, int mid, int r) {
        Comparable[] aux= Arrays.copyOfRange(arr,l,r+1);
        //初始化，i指向左半部分开头，j指向右半部分开头。
        int i=l,j=mid+1;
        for(int k=l;k<=r;k++){
            if(i>mid){//左部分元素处理完毕
                arr[k]=aux[j-1];
                j++;
            }else if(j>r){//右部分元素处理完毕
                arr[k]=aux[i-1];
                i++;
            }else if(aux[i-1].compareTo(aux[j-1])<0){//左部分元素<右部分，将左边加入
                arr[k]=aux[i-1];
                i++;
            }else{//左部分元素>=右部分，将右边加入
                arr[k]=aux[j-1];
                j++;
            }
        }
    }

}
