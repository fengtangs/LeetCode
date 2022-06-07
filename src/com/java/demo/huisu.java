package com.java.demo;

import java.util.*;

public class huisu {
    //组合 https://leetcode.cn/problems/combinations/
    List<List<Integer>> res=new ArrayList<>();
    List<Integer> path=new ArrayList<>();
    void backtracking(int n,int k, int started){
        if(path.size()==k){
//            List<Integer> temp=new ArrayList<>();//注意，这里不申请空间的话，是不行的，因为一回溯res里面的值也变了
//            for(int i=0;i<path.size();i++) temp.add(path.get(i));
            res.add(new ArrayList<>(path.subList(0, path.size())));
            return;
        }
        for(int i=started;i<=n-(k- path.size())+1;i++){
            path.add(i);
            backtracking(n,k,i+1);
            path.remove(path.size()-1);
        }
    }
    public List<List<Integer>> combine(int n, int k) {
            res.clear();
            path.clear();
            backtracking(n,k,1);

            return res;
    }
    //216. 组合总和 III https://leetcode.cn/problems/combination-sum-iii/
    int sum=0;
    public void backtracking1(int n,int k,int started){
        if(sum>n) return;
        if(path.size()==k){
            if(n==sum){
                res.add(new ArrayList<>(path.subList(0, path.size())));
            }
            return;
        }
        for(int i=started;i<=9-(k- path.size())+1;i++){//-(k- path.size())+1这是剪枝操作，减少循环
            path.add(i);
            sum+=i;
            backtracking1(n,k,i+1);
            sum-=i;
            path.remove(path.size()-1);

        }
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        res.clear();
        path.clear();
        backtracking1(n,k,1);
        return res;
    }
    //电话号码的字母组合 https://leetcode.cn/problems/letter-combinations-of-a-phone-number/
    List<String> resphone=new ArrayList<>();
    String spath;
    Map<Character, String> phonemap=new HashMap<Character, String>(){{
        put('2',"abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};
    public List<String> letterCombinations(String digits) {
            resphone.clear();
            spath="";
            if(digits.length()==0) return resphone;
            backtracking2(digits,0);

            return resphone;
    }
    private void backtracking2(String digits,int index){
        if(index==digits.length()){
            resphone.add(new String(spath));
            return;
        }
        char digit=digits.charAt(index);
        String letters=phonemap.get(digit);
        for(int i=0;i<letters.length();i++){
            spath=spath+letters.charAt(i);
            backtracking2(digits,index+1);
            spath=spath.substring(0,spath.length()-1);

        }
    }

    // 组合总和2 https://leetcode.cn/problems/combination-sum/
    //注意在，这个答案改成了去掉重复组合的答案了
    boolean[] used=new boolean[101];
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
            res.clear();
            path.clear();
            sum=0;
            Arrays.sort(candidates);//为了去重
            backtracking3(candidates,target,0);
            return res;
    }
    private void backtracking3(int[] candidates, int target,int startindex){
        if(sum==target){

            res.add(new ArrayList<>(path.subList(0, path.size())));
        }
        if(sum>target) return;
        for(int i=startindex;i<candidates.length;i++){
            if(i>0&&candidates[i]==candidates[i-1]&&used[i-1]==false){
                continue;
            }
            sum+=candidates[i];
            path.add(candidates[i]);
            used[i]=true;
            backtracking3(candidates,target,i+1);//注意，如果是不能重复取，那就是i+1,还要注意，used数组是为了去重加的，还有那个排序
            sum-=candidates[i];
            used[i]=false;
            path=path.subList(0, path.size()-1);
        }
    }
    //分割回文串 https://leetcode.cn/problems/palindrome-partitioning/
    List<List<String>> resstring=new ArrayList<>();
    List<String> strings = new ArrayList<>();
    private void backtracking4(String s, int index) {
        if (index >= s.length()) {
            resstring.add(new ArrayList<>(strings));
            return;
        }
        for (int i = index; i < s.length(); i++) {
            if (ispalindrome(s, index, i)) {//是回文串
                String temp = s.substring(index, i + 1);
                strings.add(temp);
            } else {
                continue;
            }
                backtracking4(s, i + 1);
                strings.remove(strings.size() - 1);
            }
        }
    private boolean ispalindrome(String s,int sindex,int endindex){
        for(int i=sindex,j=endindex;i<=j;i++,j--){
            if(s.charAt(i)!=s.charAt(j)) return false;
        }
        return true;

    }
    public List<List<String>> partition(String s) {
        resstring.clear();
        strings.clear();
        backtracking4(s,0);
        return resstring;
    }
    //复原IP地址 https://leetcode.cn/problems/restore-ip-addresses/
    List<String> resip=new ArrayList<>();
    private void backtracking5(StringBuilder s, int sindex,int numofpoint){
        if(numofpoint==3){
            if(isvaild(s,sindex,s.length()-1)){
                resip.add(new String(s.toString()));
            }
            return;
        }
        for(int i=sindex;i<s.length();i++){
            if(isvaild(s,sindex,i)){
                s.insert(i+1,'.');
                numofpoint++;
                backtracking5(s,i+2,numofpoint);
                numofpoint--;
                s.delete(i+1,i+2);

            }
            else break;
        }
    }
    private boolean isvaild(StringBuilder s,int sindex,int endindex){
        if(sindex>endindex) return false;
        if(s.charAt(sindex)=='0'&&sindex!=endindex) return false;
        int num=0;
        for(int i=sindex;i<=endindex;i++){
            if(s.charAt(i)>'9'||s.charAt(i)<'0')return false;
            num=num*10+(s.charAt(i)-'0');
            if(num>255)return false;
        }
        return true;
    }
    public List<String> restoreIpAddresses(String s) {
        StringBuilder news=new StringBuilder(s);
        resip.clear();
        if(s.length()>12) return resip;
        backtracking5(news,0,0);
        return resip;
    }
    //求子集问题 https://leetcode.cn/problems/subsets/
    void backtracking6(int[] nums, int startindex){
        res.add(new ArrayList<>(path));//注意这里，必须new一个
        if(startindex>=nums.length){

            return;
        }
        for(int i=startindex; i< nums.length;i++){
            path.add(nums[i]);
            backtracking6(nums,i+1);
            path.remove(path.size()-1);
        }

    }
    public List<List<Integer>> subsets(int[] nums) {
                res.clear();
                path.clear();
                backtracking6(nums,0);
                return res;
    }
    //全排列 https://leetcode.cn/problems/permutations/
    void backtracking7(int[] nums,boolean[] used){
        if(path.size()==nums.length){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(used[i]==false){
                path.add(nums[i]);
                used[i]=true;
                backtracking7(nums,used);
                used[i]=false;
                path.remove(path.size()-1);
            }
        }


    }
    public List<List<Integer>> permute(int[] nums) {
            boolean[] used=new boolean[nums.length];
            Arrays.fill(used,false);
            res.clear();
            path.clear();
            backtracking7(nums,used);
            return res;
    }
    //全排列问题2 https://leetcode.cn/problems/permutations-ii/
    void backtracking8(int[] nums, boolean[] used){
        if(path.size()== nums.length){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(i>0&&nums[i]==nums[i-1]&&used[i-1]==false)continue;
            if(used[i]==false){
                path.add(nums[i]);
                used[i]=true;
                backtracking8(nums,used);
                used[i]=false;
                path.remove(path.size()-1);
            }
        }

    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        res.clear();
        path.clear();
        boolean[] used=new boolean[nums.length];
        Arrays.fill(used,false);
        Arrays.sort(nums);//为了去重
        backtracking8(nums,used);
        return res;
    }
}
