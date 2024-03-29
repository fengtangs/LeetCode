package com.java.demo;


/***
 * this is a test
 *
 *
 */

import java.util.*;
class Solution {
    public  class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { this.val = x; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }

         ListNode() {

        }
    }

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

    public ListNode removeElements(ListNode head, int val) {
        ListNode res=new ListNode();
        ListNode p=new ListNode();
        res.next=head;
        p=res;
        ListNode cur=head;
        if (head==null)  return head;
        while (cur!=null){
            if(cur.val==val){
                    p.next=cur.next;
            }
            else{
                    p=cur;
            }
                cur=cur.next;
        }
        return res.next;
    }
    public ListNode removeElements1(ListNode head, int val) {
        while (head!=null&&head.val==val){
            head=head.next;
        }
        ListNode cur=head;
        ListNode p=head;
        while(cur!=null){
            if(cur.val==val){
                p.next=cur.next;
            }
            else{
                p=cur;
            }
            cur=cur.next;
        }
        return head;
    }

    public ListNode swapPairs(ListNode head) {
        if (head==null) return head;
        if(head.next==null) return head;
        ListNode newhead=new ListNode();
        newhead.next=head;
        ListNode cur=newhead;
        ListNode first=cur;
        ListNode second =cur;
        ListNode temp=cur;
        while (cur.next!=null&&cur.next.next!=null){
            temp=cur.next.next.next;
            first=cur.next;
            second=cur.next.next;
            cur.next=second;
            second.next=first;
            first.next=temp;
            cur=first;
        }
        return newhead.next;

    }

    public boolean isHappy(int n) {
        HashSet<Integer> red=new HashSet<>();
        while(n != 1 && !red.contains(n)){
            red.add(n);
            n=getsum(n);
        }
        return n==1? true:false;
    }
    public  static int getsum(int n){
        int sum=0;
        while(n>0){
            sum+=(n%10)*(n%10);
            n=n/10;
        }
        return sum;
    }

        //https://leetcode.cn/problems/4sum-ii/
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Integer,Integer> sum1=new HashMap<>();
        for (int i:nums1){
            for (int j:nums2){
                int temp=i+j;
                if(sum1.containsKey(temp)){
                    sum1.put(temp,sum1.get(temp)+1);
                }
                else {
                    sum1.put(temp,1);
                }
            }
        }
        int res=0;
        for (int i:nums3){
            for(int j:nums4){
                int temp=i+j;
                if(sum1.containsKey(0-temp)){
                 res+=sum1.get(0-temp);
                }


            }
        }
        return res;
    }

    //https://leetcode.cn/problems/ransom-note/
    public boolean canConstruct(String ransomNote, String magazine) {
        int []red=new int[26];
        for (int i=0;i<magazine.length();i++){
            int l=magazine.charAt(i)-'a';
            red[l]++;
        }
        for( int i=0;i<ransomNote.length();i++){
            int l=ransomNote.charAt(i)-'a';
            red[l]--;
            if(red[l]<0)
                return false;
        }
        return true;
    }

    //https://leetcode.cn/problems/3sum/
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res=new ArrayList<>();
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]>0){
                return res;
            }
            if(i>0&&nums[i]==nums[i-1]){
                continue;
            }
            int l=i+1;
            int r=nums.length-1;
            while(l<r){
                int sum=nums[i]+nums[l]+nums[r];
                if(sum>0){
                    r--;
                }
                else if (sum<0){
                    l++;
                }
                else{

                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while(r>l&&nums[l]==nums[l+1])l++;
                    while (r>l&& nums[r]==nums[r-1]) r--;
                    r--;
                    l++;
                }
            }
        }
        return res;
    }

    //https://leetcode.cn/problems/4sum/
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res=new ArrayList<>();
        for(int i=0;i<nums.length-2;i++){
            if(nums[i]>target&&nums[i]>0) break;
            if (i>0&&nums[i]==nums[i-1]) continue;
            for(int j=i+1;j< nums.length-1;j++){
                if(nums[j]+nums[i]>target&&nums[j]>0) break;
                if(j>i+1&&nums[j]==nums[j-1]) continue;
                int l=j+1;
                int r=nums.length-1;
                while(l<r){
                    int sum=nums[i]+nums[j]+nums[l]+nums[r];
                    if(sum>target){
                        r--;
                    }
                    else if (sum<target){
                        l++;
                    }
                    else{

                        res.add(Arrays.asList(nums[i],nums[j], nums[l], nums[r]));
                        while(r>l&&nums[l]==nums[l+1])l++;
                        while (r>l&& nums[r]==nums[r-1]) r--;
                        r--;
                        l++;
                    }
                }
            }

        }
        return res;
    }

    //https://leetcode.cn/problems/reverse-words-in-a-string/
    public String reverseWords(String s) {
        int l=0,r=s.length()-1;
        while(s.charAt(l)==' ')l++;
        while(s.charAt(r)==' ')r--;
        StringBuilder s1=new StringBuilder();
        for(int i=l;i<=r;i++){
            if(s.charAt(i)==' '&&s.charAt(i+1)==' ')
            {
                continue;
            }
            else{
                s1.append(s.charAt(i));
            }
        }
        // 2.反转整个字符串
        reverseString(s1, 0, s1.length() - 1);
        // 3.反转各个单词
        reverseEachWord(s1);
        return s1.toString();
    }

    /**
     * 反转字符串指定区间[start, end]的字符
     */
    public void reverseString(StringBuilder sb, int start, int end) {
        while (start < end) {
            char temp = sb.charAt(start);
            sb.setCharAt(start, sb.charAt(end));
            sb.setCharAt(end, temp);
            start++;
            end--;
        }
    }

    private void reverseEachWord(StringBuilder sb) {
        int start = 0;
        int end = 1;
        int n = sb.length();
        while (start < n) {
            while (end < n && sb.charAt(end) != ' ') {
                end++;
            }
            reverseString(sb, start, end - 1);
            start = end + 1;
            end = start + 1;
        }
    }

    //https://leetcode.cn/problems/find-the-index-of-the-first-occurrence-in-a-string/
    public int strStr(String haystack, String needle) {
        for(int i=0;i<haystack.length();i++){
            if(haystack.charAt(i)==needle.charAt(0)){
                int j=i;
                for(j=i;j<haystack.length()&&(j-i)<needle.length();j++){
                    if(haystack.charAt(j)!=needle.charAt(j-i))
                        break;
                }
                if(j<=haystack.length()&&(j-i)==needle.length()){
                    return i;
                }


            }

        }
        return -1;
    }

    public boolean isValid(String s) {
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<s.length();i++ ){
            if(s.charAt(i)=='('||s.charAt(i)=='['||s.charAt(i)=='{'){
                stack.push(s.charAt(i));
            }
            else{
                if(stack.empty()) return false;
                if(s.charAt(i)==')'&&stack.peek()=='(') {
                    stack.pop();
                }
                else if(s.charAt(i)==']'&&stack.peek()=='[') {
                    stack.pop();
                }
                else if(s.charAt(i)=='}'&&stack.peek()=='{') {
                    stack.pop();
                }
                else  return false;

            }
        }
        if(stack.empty()) return true;
        return false;
    }
    //https://leetcode.cn/problems/evaluate-reverse-polish-notation/
    //逆波兰表达式
    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack=new Stack<>();
        for (int i=0;i<tokens.length;i++){
            if("+".equals(tokens[i])){
                int a=stack.pop();
                stack.push(stack.pop()+a);
            }
            else if("-".equals(tokens[i])){
                int a=stack.pop();
                stack.push(stack.pop()-a);
            }
            else if("*".equals(tokens[i])){
                int a=stack.pop();
                stack.push(stack.pop()*a);
            }
            else if("/".equals(tokens[i])){
                int a=stack.pop();
                stack.push(stack.pop()/a);
            }
            else{
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
        return stack.peek();
    }


    //https://leetcode.cn/problems/sliding-window-maximum/
    class queue1{
        Deque<Integer> deque=new LinkedList<>();
        void poll(int val){
            if (!deque.isEmpty()&&val==deque.peek()){
                deque.poll();
            }
        }
         void add(int val){
            while (!deque.isEmpty()&&val>deque.getLast()){
                deque.removeLast();
            }
            deque.add(val);
        }
        int peek(){
            return deque.peek();
        }

    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        int length= nums.length;
        int[] res=new int[length-k+1];
        queue1 queue1=new queue1();
        for(int i=0;i<k;i++){
            queue1.add(nums[i]);
        }
        res[0]= queue1.peek();
        for (int i=k;i<length;i++){
            queue1.poll(nums[i-k]);
            queue1.add(nums[i]);
            res[i-k+1]= queue1.peek();
        }
        return res;
    }

}


class MyQueue {
    List<Integer> stackin;
    List<Integer> stackout;
    public MyQueue() {
        stackin=new ArrayList<>();
        stackout=new ArrayList<>();
    }

    public void push(int x) {
            stackin.add(x);
    }

    public int pop() {
        capzuo();
        int res=stackout.get(stackout.size()-1);
        stackout.remove(stackout.size()-1);
        return res;
    }

    public int peek() {
        capzuo();
        return stackout.get(stackout.size()-1);
    }

    public boolean empty() {
        capzuo();
        if(stackout.isEmpty()) return true;
        return false;
    }
    public  void capzuo(){
        if(!stackout.isEmpty()) return;
        if(stackin.isEmpty()) return;
        for(int i=stackin.size()-1;i>=0 ;i--){
            stackout.add(stackin.get(i));
        }
        stackin.clear();
    }
}
public class main {
    //最长连续序列
    //https://leetcode.cn/problems/longest-consecutive-sequence/
    public static int longestConsecutive(int[] nums) {
            HashSet<Integer> set =new HashSet<>();
            for (int num : nums){
                set.add(num);
            }
            int res=0;
            int cur =0;
            for (int num : set)
            {
                if (!set.contains(num-1)){
                    cur=num;
                    while(set.contains(cur)) {

                        set.remove(cur);
                        cur++;
                    }
                    res=Math.max(res,cur-num);
                }
            }
            return res;
        /*
        HashSet+枚举每个连续序列起始元素
        1.用HashSet保存元素并去重
        2.遍历HashSet，当集合中不存在num-1时，说明是连续序列起始段，统计其长度
        3.维护每个不同起始元素连续段的最大连续长度
        时间复杂度:O(N) 空间复杂度:O(N)
         */
        }
    //在排序数组中查找元素的第一个和最后一个位置
    //https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/
    public static int[] searchRange(int[] nums, int target) {
        int left=bsearch(nums,target,true);
        int right=bsearch(nums,target,false)-1;
        if(left<=right&&right<= nums.length-1&&nums[left]==target&&nums[right]==target){
            return new int[]{left,right};
        }
        else {
            return new int[]{-1,-1};
        }


    }

   //[5,7,7,8,8,10]
    private static int bsearch(int[] nums, int target,boolean lower) {
        int begin=0,end= nums.length-1;
        int ans= nums.length;
        while (begin<=end){
            int mid=begin+(end-begin)/2;
            if(nums[mid]>target||(lower&&nums[mid]>=target)){
                end=mid-1;
                ans=mid;
            }
            else{
                begin=mid+1;
            }
        }
        return ans;
    }

//https://leetcode.cn/problems/binary-search/
    //二分查找
    public int search(int[] nums, int target) {
        int left=0,right=nums.length-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if (nums[mid]==target) return mid;
            else if (nums[mid]>target){
                right=mid-1;
            }
            else left=mid+1;
        }
        return -1;
    }

    public static void main(String[] args) {
//        ApiTest test=new ApiTest();
//        test.before();
//        test.test_collisionRate();
//        test.test_hashArea();
        int s=4;
        System.out.println(s>>>1);
//        tenxun a=new tenxun();
//        int [] nums = new int[]{0,3,7,2,5,8,4,6,0,1};
//        System.out.println("-XX:+PrintGCDetails");
////        System.out.print(longestConsecutive(nums));
//        Solution temp=new Solution();
//        int res=Solution.evalRPN(new String[]{"1", "2", "+", "3", "*"});
//        System.out.println(res);

        //        System.out.println(a.mySqrt(5));
//        int[] nums=new int[]{1,2,1,1,2};
        //int[] res =a.singleNumbers(new int[]{1, 2, 10, 4, 1, 4, 3, 3});
//        for(int i:res){
//            System.out.print(i);
//        }
//        System.out.println(a.constructArr(new int[]{1,2})[0]);
//        int[][]res =a.findContinuousSequence(9);
//        System.out.println(res.length);
//        for(int i=0;i<res.length;i++){
//            for(int j=0;j<res[i].length;j++){
//                System.out.println(res[i][j]);
//            }
//            System.out.println();
//        }
//        System.out.println();
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
