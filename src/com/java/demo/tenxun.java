package com.java.demo;

import java.util.*;

public class tenxun {
    //https://leetcode.cn/problems/merge-sorted-array/
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int tail = m + n - 1, n1 = m - 1, n2 = n - 1;
        while (n1 >= 0 && n2 >= 0) {
            if (nums1[n1] > nums2[n2]) {
                nums1[tail--] = nums1[n1--];
            } else {
                nums1[tail--] = nums2[n2--];
            }
        }
        while (n2 >= 0) {
            nums1[tail--] = nums2[n2--];
        }
//        while(n1>=0){
//            nums1[tail--]=nums1[n1--];
//        }

    }

    //https://leetcode.cn/problems/contains-duplicate/
    public boolean containsDuplicate(int[] nums) {
        int length = nums.length;
        if (length == 1) return true;
        Arrays.sort(nums);
        for (int i = 1; i < length; i++) {
            if (nums[i - 1] == nums[i])
                return true;
        }
        return false;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    //https://leetcode.cn/problems/reverse-string/submissions/
    public void reverseString(char[] s) {
        int head = 0, tail = s.length - 1;
        char t;
        while (head < tail) {
            t = s[head];
            s[head] = s[tail];
            s[tail] = t;
            tail--;
            head++;
        }
    }

    //https://leetcode.cn/problems/reverse-words-in-a-string-iii/
    public String reverseWords(String s) {
        String[] temp = s.split(" ");
        StringBuffer res = new StringBuffer();
        for (String i : temp) {
            res.append(new StringBuffer(i).reverse().toString());
            res.append(" ");
        }
        return res.toString().trim();
    }

    //https://leetcode.cn/problems/merge-k-sorted-lists/
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        ListNode head = new ListNode(0);
        ListNode temp = head;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        for (ListNode list : lists) {
            if (list == null) {
                continue;
            }
            pq.add(list);
        }
        while (!pq.isEmpty()) {
            ListNode nextNode = pq.poll();
            temp.next = nextNode;
            temp = temp.next;
            if (nextNode.next != null) {
                pq.add(nextNode.next);
            }
        }
        return head.next;


    }


    //https://leetcode.cn/problems/linked-list-cycle-ii/comments/
    //这个题很好，可以多想想
    public ListNode detectCycle(ListNode head) {
        // 步骤一：使用快慢指针判断链表是否有环
        ListNode slow = head, quick = head;
        boolean hasCycle = false;
        while (quick != null) {
            slow = slow.next;
            if (quick.next != null)
                quick = quick.next.next;
            else return null;
            if (quick == slow) {
                ListNode q = head;
                while (slow != q) {
                    slow = slow.next;
                    q = q.next;
                }
                return q;
            }
        }
        return null;
    }

    //https://leetcode.cn/problems/plus-one/
    public int[] plusOne(int[] digits) {
        if (digits[digits.length - 1] < 9) {
            digits[digits.length - 1] += 1;
            return digits;
        }
        if (digits.length == 1 && digits[0] == 9) return new int[]{1, 0};
        List<Integer> r = new ArrayList<Integer>();
        r.add(0);
        for (int i = digits.length - 2; i >= 0; i--) {
            if (digits[i] + 1 < 10) {
                r.add(digits[i--] + 1);
                while (i >= 0) {
                    r.add(digits[i--]);
                }
                break;
            } else {
                r.add(0);
                if (i == 0) {
                    r.add(1);
                }
            }
        }
        int[] res = new int[r.size()];
        for (int i = 0; i < r.size(); i++) {
            res[r.size() - 1 - i] = r.get(i);
        }
        return res;
    }
    //https://leetcode.cn/problems/sqrtx/

    public int mySqrt(int x) {
        if (x <= 1) return x;
        int min = 0, max = x, res = 0;
        while (min <= max) {
            int mid = min + (max - min) / 2;
            System.out.println(min);
            if ((long) mid * mid <= x) {
                res = mid;
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }
        return res;
    }

    // https://leetcode.cn/problems/pascals-triangle/
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> temp = new ArrayList();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    temp.add(1);
                } else {
                    temp.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
                }
            }
            res.add(temp);
        }
        return res;
    }


    public boolean isPalindrome(String s) {
        if (s.length() == 0) return true;
        String res = new String();
        //转小写并且去除不相干字符
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ((c <= 'z' && c >= 'a') || (c <= 'Z' && c >= 'A') || (c <= '9' && c >= '0')) {
                if ((c <= 'Z' && c >= 'A')) {
                    c |= 32;

                }
                res += c;
            }
        }
        int l = 0, r = res.length() - 1;
        while (l < r) {
            if (res.charAt(l) != res.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }

    //https://leetcode.cn/problems/excel-sheet-column-number/
    public int titleToNumber(String columnTitle) {
        int res = 0;
        int n = 1;
        for (int i = columnTitle.length() - 1; i >= 0; i--) {
            int t = columnTitle.charAt(i) - 'A' + 1;
            res += t * Math.pow(26, n);
            n++;
        }
        return res;
    }

    public int reverseBits(int n) {
        int res = 0;
        int i = 32;
        while (i > 0) {
            res <<= 1;
            res += n & 1;
            n >>= 1;
            i--;
        }
        return res;
    }


    public int firstMissingPositive(int[] nums) {

        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        for (int i = 0; i < n; ++i) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;
    }

    //https://leetcode.cn/problems/is-unique-lcci/
    public boolean isUnique(String astr) {
        boolean[] flag = new boolean[26];
        for (int i = 0; i < astr.length(); i++) {
            if (flag[astr.charAt(i) - 'a'] != false) {
                return false;
            } else
                flag[astr.charAt(i) - 'a'] = true;
        }
        return true;
    }

    //https://leetcode.cn/problems/check-permutation-lcci/
    public boolean CheckPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        for (int i = 0; i < c1.length; i++) {
            if (c1[i] != c2[i]) return false;
        }
        return true;
    }

    //https://leetcode.cn/problems/string-to-url-lcci/
    public String replaceSpaces(String S, int length) {
        // 边界条件
        if (S == null || S.length() == 0) {
            return S;
        }

        char[] str = S.toCharArray();
        // 双指针位置
        int preIndex = length - 1;
        int lastIndex = preIndex;
        for (int i = 0; i < length; i++) {
            if (str[i] == ' ') {
                lastIndex += 2;
            }
        }

        // 替换字符串
        while (lastIndex != preIndex) {
            if (str[preIndex] != ' ') {
                // 复制
                str[lastIndex] = str[preIndex];
                lastIndex--;
                preIndex--;
            } else {
                // 替换 0 2 % ; pre-1; last - 3
                str[lastIndex--] = '0';
                str[lastIndex--] = '2';
                str[lastIndex--] = '%';
                preIndex--;
            }
        }
        return String.valueOf(str).trim();
    }

    //https://leetcode.cn/problems/palindrome-permutation-lcci/comments/
    public boolean canPermutePalindrome(String s) {
        if(s==null) return false;
        Set<Character> set=new HashSet<Character>();
        char c;
        for(int i=0;i<s.length();i++){
            c=s.charAt(i);
            if(set.contains(c)){
                set.remove(c);
            }else{
                set.add(c);
            }
        }
        return set.size()<=1;
    }


    //https://leetcode.cn/problems/compress-string-lcci/comments/
        public String compressString(String S) {
            char[]r=S.toCharArray();
            StringBuffer res=new StringBuffer();
            int j=1;
            for(int i=0;i<r.length;i++){
                res.append(r[i]);
                while (i<r.length&&r[i]==r[i+1]){
                    i++;
                    if(i==r.length){
                        break;
                    }
                    j++;
                }
                res.append(Integer.toString(j));
                j=1;
            }
            if(res.length()>=S.length()) return S;
            return res.toString();
        }


    public boolean isFlipedString(String s1, String s2) {
        if(s1.length()!=s2.length()) return false;
        return (s2+s2).contains(s1);
    }

    //https://leetcode.cn/problems/remove-duplicate-node-lcci/
    public ListNode removeDuplicateNodes(ListNode head) {
        Set<Integer> set=new HashSet<Integer>();
        if(head==null) return head;
        ListNode pre=head,cur=pre.next,res=pre;
        set.add(pre.val);
        while(cur!=null){
            if(set.contains(cur.val)){
                pre.next=cur.next;
                cur=cur.next;
            }
            else{
                set.add(cur.val);
                pre=cur;
                cur=cur.next;

            }

        }
        return res;
    }

    public int kthToLast(ListNode head, int k) {
        ListNode fast=head, slow=head;
        int i=0;
        while(fast!=null) {
            i++;
            if (k <= i) {
                slow = slow.next;
            }
            fast = fast.next;
        }
        return slow.val;
    }

    //https://leetcode.cn/problems/one-away-lcci/
    public boolean oneEditAway(String first, String second) {

        int scale_length=first.length()-second.length();
        int flag=1;
        if(Math.abs(scale_length)>1) return false;
        for(int i=0,j=0;i<first.length()&&j<second.length();i++,j++){
            if(first.charAt(i)!=second.charAt(j)){
                if(scale_length==1)i++;
                else if(scale_length==-1)j++;
                flag--;
            }
            if(flag<0) return false;
        }

        return true;
    }


    class TripleInOne {
        int[] stack;
        int stacksize;
        int[] index;
        public TripleInOne(int stackSize) {
            stack=new int[stackSize*3];
            stacksize=stackSize;
            index=new int[]{0,1,2};
        }

        public void push(int stackNum, int value) {
            if(index[stackNum]>=stacksize*3) return;
            stack[index[stackNum]]=value;
            index[stackNum]+=3;
        }

        public int pop(int stackNum) {
            if(isEmpty(stackNum)) return -1;
            index[stackNum]-=3;
            return stack[index[stackNum]];
        }

        public int peek(int stackNum) {
            if(isEmpty(stackNum)) return -1;
            return stack[index[stackNum]-3];
        }

        public boolean isEmpty(int stackNum) {
            return index[stackNum] < 3;
        }
    }


    public void setZeroes(int[][] matrix) {
        if(matrix.length==0) return;
        boolean[] row=new boolean[matrix.length];
        boolean[] col = new boolean[matrix[0].length];
        for(int i=0;i< matrix.length;i++){
            for(int j=0;j< matrix[0].length;j++){
                if(matrix[i][j]==0){
                    row[i]=true;
                    col[j]=true;
                }
            }
        }
        for(int i=0;i< row.length;i++){
            if(row[i]){
                for(int j=0;j< matrix[0].length;j++){
                    matrix[i][j]=0;
                }
            }
        }
        for(int i=0;i< col.length;i++){
            if(col[i]){
                for(int j=0;j< matrix.length;j++){
                    matrix[j][i]=0;
                }
            }
        }
    }

    //https://leetcode.cn/problems/sum-lists-lcci/
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int jinwei=0;
        ListNode res=new ListNode(0),cur=res;
        while(l1!=null&&l2!=null){
            int sum= l1.val+l2.val+jinwei;
            if(sum>=10){
                jinwei=sum/10;
                cur.next = new ListNode(sum % 10);
            }
            else{
                cur.next = new ListNode(sum % 10);
                jinwei=0;

            }
            cur=cur.next;
            l1=l1.next;
            l2=l2.next;
        }
        while(l1!=null){
            int sum=jinwei+l1.val;
            if(sum>=10){
                jinwei=sum/10;
                cur.next = new ListNode(sum % 10);
            }
            else{
                cur.next = new ListNode(sum % 10);
                jinwei=0;

            }
            cur=cur.next;
            l1=l1.next;

        }
        while(l2!=null){
            int sum=jinwei+l2.val;
            if(sum>=10){
                jinwei=sum/10;
                cur.next = new ListNode(sum % 10);
            }
            else{
                cur.next = new ListNode(sum % 10);
                jinwei=0;

            }
            cur=cur.next;
            l2=l2.next;

        }
        if(jinwei!=0){
            cur.next = new ListNode(jinwei % 10);
        }
        return res.next;
    }

    // https://leetcode.cn/problems/rotate-matrix-lcci/comments/
    public void rotate(int[][] matrix) {
        int row= matrix.length;
        if(row==0) return;
        for( int i=0;i<row;i++){
            for( int j=i+1;j<row;j++){
                int t=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=t;

            }
        }
    int mid=row/2;
        for( int i=0;i<row;i++){
            for(int j=0;j<mid;j++){
                int t=matrix[i][j];
                matrix[i][j]=matrix[i][row-1-j];
                matrix[i][row-1-j]=t;
            }
        }

    }

    //https://leetcode.cn/problems/palindrome-linked-list-lcci/comments/
    public boolean isPalindrome(ListNode head) {

        Integer [] temp=new Integer[]{1,2,3,4,5};
        int a= Collections.max(Arrays.asList(temp));
        ListNode fast = head,slow = head;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
//            if(slow==fast){
//                fast=head;
//                while(slow!=fast){
//                    slow=slow.next;
//                    fast=fast.next;
//                }
//                return slow;
//            }
//            return null;
        }
        ListNode pre = null;
        while(slow!=null){
            ListNode next= slow.next;
            slow.next=pre;
            pre=slow;
            slow=next;
        }
        ListNode node =head;
         while(pre!=null){
             if(pre.val!= node.val){
                 return false;
             }
             pre=pre.next;
             node=node.next;
         }
        return true;
    }


}
