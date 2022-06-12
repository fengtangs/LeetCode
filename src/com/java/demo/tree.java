package com.java.demo;

/**
 * 树相关题目，来源 leetcode
 * date: 20220531
 * author：nsf
 * cite form 代码随想录
 */
import java.beans.PropertyEditorSupport;
import java.lang.reflect.Array;
import java.util.*;
//二叉树节点定义 TreeNode root =new TreeNode();
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
//二叉树相关题目
public class tree {
    //二叉树前序递归遍历
    public void pretree(TreeNode root){
        if(root==null) return ;
        System.out.print(root.val);
        if(root.left!=null) pretree(root.left);
        if(root.right!=null) pretree(root.right);
    }
    //二叉树中序递归遍历
    public void midtree(TreeNode root){
        if(root==null) return ;
        if(root.left!=null) pretree(root.left);
        System.out.print(root.val);
        if(root.right!=null) pretree(root.right);
    }
    //二叉树后序递归遍历
    public void posttree(TreeNode root){
        if(root==null) return ;
        if(root.left!=null) pretree(root.left);
        if(root.right!=null) pretree(root.right);
        System.out.print(root.val);
    }
    //二叉树前序遍历，借助stack
    public int[] precengtree(TreeNode root){
        Stack<TreeNode> stack=new Stack<TreeNode>();
        List<Integer> temp=new ArrayList<>();
        if(root==null) return null;
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node=stack.pop();
            temp.add(node.val);
            if(node.right!=null) stack.push(node.right);
            if(node.left!=null) stack.push(node.left);

        }
        return temp.stream().mapToInt(Integer::valueOf).toArray();
    }
    //二叉树后续遍历，借助stack
    public int[] ppstcengtree(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        List<Integer> temp = new ArrayList<>();
        if (root == null) return null;
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            temp.add(node.val);
            if (node.left != null) stack.push(node.left);
            if (node.right != null) stack.push(node.right);
        }
        return temp.stream().mapToInt(Integer::valueOf).toArray();
    }
    //二叉树中序遍历，借助stack
    public int[] midcengtree(TreeNode root){
        Stack<TreeNode> stack=new Stack<TreeNode>();
        List<Integer> res=new ArrayList<>();
        TreeNode cur=root;
        while(cur!=null ||!stack.isEmpty()){
            if(cur!=null){
                stack.push(cur);
                cur=cur.left;
            }else {
                cur=stack.pop();
                res.add(cur.val);
                cur=cur.right;
            }
        }
        return res.stream().mapToInt(Integer::valueOf).toArray();
    }
    //二叉树前序遍历，借助stack
    public  int[] indordertree(TreeNode root){
        List<Integer> res=new ArrayList();
        Stack<TreeNode> stack=new Stack<>();
        if(root!=null) stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node=stack.peek();
            if(node!=null){
                stack.pop();
                if(node.right!=null) stack.push(node.right);
                stack.push(node);
                stack.push(null);
                if(node.left!=null) stack.push(node.left);
            } else{
                stack.pop();
                node=stack.pop();
                res.add(node.val);
            }
        }
        return res.stream().mapToInt(Integer::valueOf).toArray();
    }
    //二叉树的层序遍历 https://leetcode.cn/problems/binary-tree-level-order-traversal/
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> que=new  LinkedList<TreeNode>();
        List<List<Integer>> res=new ArrayList<>();
        if(root!=null) que.add(root);
        while(!que.isEmpty()){
            int size=que.size();
            List<Integer> vec=new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode node=que.poll();
                vec.add(node.val);
                if(node.left!=null) que.add(node.left);
                if(node.right!=null) que.add(node.right);
            }
            res.add(vec);
        }
        //Collections.reverse(res);
        return res;
    }
    // 二叉树的层序遍历2 https://leetcode.cn/problems/binary-tree-level-order-traversal-ii/
    //相比1，倒序
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> que=new  LinkedList<TreeNode>();
        List<List<Integer>> res=new ArrayList<>();
        if(root!=null) que.add(root);
        while(!que.isEmpty()){
            int size=que.size();
            List<Integer> vec=new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode node=que.poll();
                vec.add(node.val);
                if(node.left!=null) que.add(node.left);
                if(node.right!=null) que.add(node.right);
            }
            res.add(vec);
        }
        Collections.reverse(res);
        return res;
    }
    //二叉树右视图 ，还是层次遍历 https://leetcode.cn/problems/binary-tree-right-side-view/
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> que=new  LinkedList<TreeNode>();
        List<List<Integer>> res=new ArrayList<>();
        if(root!=null) que.add(root);
        while(!que.isEmpty()){
            int size=que.size();
            List<Integer> vec=new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode node=que.poll();
                vec.add(node.val);
                if(node.left!=null) que.add(node.left);
                if(node.right!=null) que.add(node.right);
            }
            res.add(vec);
        }
        List<Integer> resu=new ArrayList<>();
        for(List<Integer> l: res){
            resu.add(l.get(l.size()-1));
        }
        return resu;
    }
    //二叉树层平均值 https://leetcode.cn/problems/average-of-levels-in-binary-tree/
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> que=new  LinkedList<TreeNode>();
        List<List<Integer>> res=new ArrayList<>();
        if(root!=null) que.add(root);
        while(!que.isEmpty()){
            int size=que.size();
            List<Integer> vec=new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode node=que.poll();
                vec.add(node.val);
                if(node.left!=null) que.add(node.left);
                if(node.right!=null) que.add(node.right);
            }
            res.add(vec);
        }
        List<Double> resu=new ArrayList<>();
        for(List<Integer> l: res){
            double sum=0;
            for(Integer i:l){
                sum+=i;
            }
            sum=sum/l.size();
            resu.add(sum);
        }
        return resu;
    }
    //找每一层最大值 https://leetcode.cn/problems/find-largest-value-in-each-tree-row/
    public List<Integer> largestValues(TreeNode root) {
        Queue<TreeNode> que=new  LinkedList<TreeNode>();
        List<Integer> res=new ArrayList<>();
        if(root!=null) que.add(root);
        while(!que.isEmpty()){
            int size=que.size();
            int max=Integer.MIN_VALUE;
            for(int i=0;i<size;i++){
                TreeNode node=que.poll();
                if(max<node.val) max= node.val;
                if(node.left!=null) que.add(node.left);
                if(node.right!=null) que.add(node.right);
            }
            res.add(max);
        }

        return res;
    }
    //翻转二叉树 https://leetcode.cn/problems/invert-binary-tree/
    public TreeNode invertTree(TreeNode root) {
        if(root==null)
            return null;
        invertTree(root.left); // 递归找到左节点
        TreeNode rightNode= root.right; // 保存右节点
        root.right = root.left;
        root.left = rightNode;
        // 递归找到右节点 继续交换 : 因为此时左右节点已经交换了,所以此时的右节点为root.left
        invertTree(root.left);
        return root;

    }
    //对称二叉树 https://leetcode.cn/problems/symmetric-tree/
    //方法1
    List<Integer> le=new ArrayList<>();
    List<Integer> ri=new ArrayList<>();
    private void  pri1(TreeNode node){
        if(node==null)
            return;
        le.add(node.val);
        pri1(node.left);
        pri1(node.right);
    }
    private void  pri2(TreeNode node){
        if(node==null)
            return;
        ri.add(node.val);
        pri2(node.left);
        pri2(node.right) ;
    }
    public boolean isSymmetric_1(TreeNode root) {
        pri1(root.left);
        pri2(root.right);
        if(le.size()!=ri.size())
            return false;
        else
        {
            for(int i=0;i<le.size();i++)
            {
                if(le.get(i)!=ri.get(i))
                    return false;
            }
            return true;

        }
    }
    //方法2
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return cmp(root.left, root.right);
    }
    private boolean cmp(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null || node2 == null || node1.val != node2.val) {
            return false;
        }
        return cmp(node1.left, node2.right) && cmp(node1.right, node2.left);
    }
    //二叉树最大深度 https://leetcode.cn/problems/maximum-depth-of-binary-tree/
    public int maxDepth(TreeNode root) {
        return root == null ? 0 : Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
    //二叉树最小深度 https://leetcode.cn/problems/minimum-depth-of-binary-tree/
    public int minDepth(TreeNode root) {
        if(root==null) return 0;
        int mindepth;
        int ldepth=minDepth(root.left);
        int rdepth=minDepth(root.right);
        if(root.left==null&&root.right!=null){
            return 1+rdepth;
        }
        if(root.left!=null&&root.right==null){
            return 1+ldepth;
        }
        mindepth=1+Math.min(ldepth,rdepth);
        return mindepth;

    }
    //求完全二叉树节点数 https://leetcode-cn.com/problems/count-complete-tree-nodes/
    public int countNodes(TreeNode root) {
        if(root==null) return 0;
        int l=0,r=0;
        if(root.left!=null) {
            l=countNodes(root.left);
        }
        if(root.right!=null) {
            r=countNodes(root.right);
        }
        return r+1+l;
    }
    //平衡二叉树 判断高度 https://leetcode.cn/problems/balanced-binary-tree/
    private int getdepth(TreeNode root){
        if(root==null) return 0;
        int l=0,r=0;
        l=getdepth(root.left);
        r=getdepth(root.right);
        if(l==-1||r==-1) return -1;
        if(Math.abs(l-r)<=1) return 1+Math.max(l,r);
        return -1;
    }
    public boolean isBalanced(TreeNode root) {  //判断是否是高度平衡的二叉树

        return getdepth(root)==-1? false:true;
    }
    //二叉树所有路径 https://leetcode.cn/problems/binary-tree-paths/
    public List<String> binaryTreePaths(TreeNode root) {//二叉树到叶子节点的所有路径
        List<String> res=new ArrayList<>();
        Stack<Integer> path=new Stack<>();
        if(root==null) return res;
        traversal(root,path,res);
        return res;
    }
    private void traversal(TreeNode cur,Stack<Integer> path,List<String>res){
        path.push(cur.val);
        if(cur.left==null&&cur.right==null){
            //叶子节点
            String spath=new String();
            for(int i=0;i>path.size()-1;i++){
                spath+=path.get(i).toString();
                spath+="->";
            }
            spath+=path.get(path.size()-1).toString();
            res.add(spath);
            return ;
        }
        if(cur.left!=null){
            traversal(cur.left,path,res);
            path.pop();
        }
        if(cur.right!=null){
            traversal(cur.right,path,res);
            path.pop();
        }
    }
    //左叶子之和 https://leetcode.cn/problems/sum-of-left-leaves/
    public int sumOfLeftLeaves(TreeNode root) {
        if(root==null) return 0;
        int sum=0;
        if((root.left!=null&&root.left.left==null&root.left.right==null)){
            sum+= root.left.val;
        }
        if(root.left!=null){
            sum+=sumOfLeftLeaves(root.left);
        }
        if(root.right!=null){
            sum+=sumOfLeftLeaves(root.right);
        }
        return sum;
    }
    //二叉树深度
    public int treedepth(TreeNode root){
        Queue<TreeNode> que=new LinkedList();
        int depth=0;
        if(root==null) return 0;
        que.add(root);
        while(!que.isEmpty()){
            int size=que.size();
            depth++;
            for(int i=0;i<size;i++){
                TreeNode node=que.poll();
                if(node.left!=null) que.add(node.left);
                if(node.right!=null) que.add(node.right);
            }
        }
        return depth;
    }
    //路径总和 https://leetcode.cn/problems/path-sum/
    private void sum_traversal(TreeNode cur,int sum,List<Integer> res){
        sum+=cur.val;
        if(cur.left==null&&cur.right==null){
            res.add(sum);
            return ;
        }
        if(cur.left!=null){
            sum_traversal(cur.left,sum,res);
        }
        if(cur.right!=null){
            sum_traversal(cur.right,sum,res);
        }
    }
    public boolean hasPathSum(TreeNode root, int targetSum) {//；路径之和
        List<Integer> res=new ArrayList<>();
        int sum=0;
        if(root==null) return false;
        sum_traversal(root,sum,res);
        for(int i=0;i<res.size();i++){
            if(targetSum==res.get(i)) return true;
        }
        return false;
    }
    //路径总和2 https://leetcode.cn/problems/path-sum-ii/
    private void traver(TreeNode cur,Stack<Integer> path,List<List<Integer>>res,int target){
        path.push(cur.val);
        if(cur.left==null&&cur.right==null){
            //叶子节点
            List<Integer> spath=new ArrayList<>();
            int sum=0;
            for(int i=0;i<path.size()-1;i++){
                spath.add(path.get(i));
                sum+=path.get(i);
            }
            spath.add(path.get(path.size()-1));
            sum+=path.get(path.size()-1);
            if(sum==target)
                res.add(spath);
            return ;
        }
        if(cur.left!=null){
            traver(cur.left,path,res, target);
            path.pop();
        }
        if(cur.right!=null){
            traver(cur.right,path,res,target);
            path.pop();
        }
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {//找出所有符合目标和的路径
        List<List<Integer>> res=new ArrayList<>();
        Stack<Integer> path=new Stack<>();
        if(root==null) return res;
        traver(root,path,res,targetSum);
        return res;
    }
    //从中序与后序遍历序列构造二叉树 https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
    //方法1
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(postorder.length==0) return null;
        int rootvalue = postorder[postorder.length-1];
        TreeNode root =new TreeNode(rootvalue);
        int devide=0;
        if(postorder.length==1) return root;
        for(int i=0;i<inorder.length;i++)
        {
            if(inorder[i]==rootvalue)  {
                devide=i;
                break;
            }
        }
        int[] inorderleft=new int[devide];
        int[] posterleft=new int[devide];
        for(int i=0;i<devide;i++){
            inorderleft[i]=inorder[i];
            posterleft[i]=postorder[i];
        }
        int[] inorderright=new int[inorder.length-devide-1];
        int[] posteright=new int[inorderright.length];
        for(int i=0;i<inorder.length-devide-1;i++){
            inorderright[i]=inorder[devide+i+1];
            posteright[i]=postorder[devide+i];
        }

        root.left=buildTree(inorderleft,posterleft);
        root.right=buildTree(inorderright,posteright);
        return root;

    }
    //方法2
    private TreeNode inpost(int[] inorder, int[]postorder,int inbegin,int inend,int postbegin,int postend){
        TreeNode root=new TreeNode(postorder[postend]);
        int i=0;
        for(i=inbegin;inorder[i]!=root.val;i++);
        int llen=i-inbegin;
        int rlen=inend-i;
        if(llen!=0){
            root.left=inpost(inorder,postorder,inbegin,inbegin+llen-1,postbegin,postbegin+llen-1);
        }
        if(rlen!=0){
            root.right=inpost(inorder,postorder,inbegin+llen+1,inend, llen+postbegin,postend-1);
        }
        return root;
    }
    public TreeNode buildTree_1(int[] inorder, int[] postorder) {
        return inpost(inorder,postorder,0,inorder.length-1,0,postorder.length-1);
    }
    //从中序与前序遍历序列构造二叉树 https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
    private TreeNode prein(int[] preorder, int[]inorder,int prebegin,int preend,int inbegin,int inend) {
        if(prebegin==preend+1) return null;
        TreeNode root=new TreeNode(preorder[prebegin]);
        int i=0;
        for(i=inbegin;inorder[i]!=root.val;i++);
        int llen=i-inbegin;
        int rlen=inend-i;
        if(llen!=0){
            root.left=prein(preorder,inorder,prebegin+1,prebegin+llen,inbegin,inend+llen-1);
        }
        else root.left=null;
        if(rlen!=0){
            root.right=prein(preorder,inorder,prebegin+llen+1, preend,inbegin+llen+1,inend);
        }
        else root.right=null;
        return root;
    }
    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        return prein(preorder,inorder,0,preorder.length-1,0,inorder.length-1);
    }
    //最大二叉树https://leetcode.cn/problems/maximum-binary-tree/
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if(nums.length==0) return null;
        if(nums.length==1) return new TreeNode(nums[0]);
        int maxsubscript=0;
        int max=nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]>max){
                max=nums[i];
                maxsubscript=i;
            }
        }
        TreeNode node =new TreeNode(max);
        node.left=constructMaximumBinaryTree(Arrays.copyOfRange(nums,0,maxsubscript));
        node.right=constructMaximumBinaryTree(Arrays.copyOfRange(nums,maxsubscript+1,nums.length));
        return node;

    }
    //合并两个二叉树 https://leetcode-cn.com/problems/merge-two-binary-trees/
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1==null)
            return root2;
        if(root2==null)
            return root1;
        TreeNode m=new TreeNode(root1.val+root2.val);
        m.left=mergeTrees(root1.left,root2.left);
        m.right=mergeTrees(root1.right,root2.right);
        return m;
    }
    //打家劫舍3 https://leetcode.cn/problems/house-robber-iii/
    private int[] robtree(TreeNode root){
        if(root==null) return new int[]{0, 0};
        int[] left=robtree(root.left);
        int[] right=robtree(root.right);
        int val =root.val+left[0]+right[0];
        int val2 = Math.max(left[0],left[1])+Math.max(right[0],right[1]);
        return new int[]{val2,val};
    }
    public int rob(TreeNode root) {
        int[] res = robtree(root);
        return Math.max(res[0],res[1]);
    }
    //二叉搜索树中的搜索 https://leetcode.cn/problems/search-in-a-binary-search-tree/
    public TreeNode searchBST(TreeNode root, int val) {
        if(root==null||root.val==val) return root;
        if(val< root.val) return searchBST(root.left,val);
        return searchBST(root.right,val);
    }
    //验证二叉搜索树 https://leetcode.cn/problems/validate-binary-search-tree/
    TreeNode pre=null;
    //错误方法，这个[5,4,6,null,null,3,7]无法判断
    public boolean isValidBST(TreeNode root) {
        if(root==null) return true;
        if(root.left!=null) {
            if(root.left.val>= root.val){
                return false;
            }
        }
        if(root.right!=null) {
            if(root.right.val<= root.val){
                return false;
            }
        }
        if(isValidBST(root.right)==true&&isValidBST(root.right)==true) return true;
        return false;
    }
    //正确方法，使用中序遍历方法判断，因为中序遍历就是有序的
    public boolean isValidBST1(TreeNode root) {
        if (root == null) return true;
        boolean l = isValidBST1(root.left);
        if (pre != null && pre.val >= root.val) return false;
        pre = root;
        boolean r = isValidBST1(root.right);
        return l && r;
    }
    // 二叉搜索树的最小差值 https://leetcode.cn/problems/minimum-absolute-difference-in-bst/
    //方法1.1递归
    int mincha=Integer.MAX_VALUE;
    private void traversal(TreeNode root){
        if(root==null) return ;
        traversal(root.left);
        if(pre!=null){
            mincha=Math.min(mincha, root.val- pre.val);
        }
        pre=root;
        traversal(root.right);
    }
    public int getMinimumDifference0(TreeNode root) {
        traversal(root);
        return mincha;
    }
        //方法1.2递归
    public int getMinimumDifference1(TreeNode root) {
        if(root==null) return mincha;
        int l=getMinimumDifference1(root.left);
        if(pre!=null&&mincha>(Math.abs(pre.val-root.val))){
            mincha=Math.abs(pre.val-root.val);
        }
        pre=root;
        int r=getMinimumDifference1(root.right);
        mincha=Math.min(l,mincha);
        mincha=Math.min(r,mincha);
        return mincha;
    }
    //方法2  迭代，中序遍历
    public int getMinimumDifference2(TreeNode root) {
        Stack<TreeNode> stack=new Stack<>();
        TreeNode pre=null;
        TreeNode cur=root;
        int Mincha=Integer.MAX_VALUE;
        while(!stack.isEmpty()||cur!=null){
            if(cur!=null){
                stack.push(cur);
                cur=cur.left;
            }else{
                TreeNode t=stack.pop();
                if(pre!=null){
                    Mincha=Math.min(Mincha,t.val- pre.val);
                }
                pre=t;
                cur=t.right;
            }
        }
        return Mincha;
    }

    //二叉搜索树中的众数 https://leetcode.cn/problems/find-mode-in-binary-search-tree/
    public int[] findMode(TreeNode root) {
        if(root.left==null&&root.right==null) {
            return new int[]{root.val};
        }
        List<Integer> res=new ArrayList();
        int curmax=0;
        int preval= Integer.MIN_VALUE;
        int summax=0;
        Stack<TreeNode> stack =new Stack<>();
        TreeNode cur=root;
        while(cur!=null||!stack.isEmpty()){
            if(cur!=null){
                stack.push(cur);
                cur=cur.left;
            }else {
                    TreeNode t=stack.pop();
                    if(preval==Integer.MIN_VALUE){
                        curmax=1;
                    }
                    else if(preval==t.val){
                        curmax++;}
                    else {
                        curmax=1;}
                    if(curmax>=summax){
                        if(curmax==summax){
                            res.add(t.val);
                        }
                        else {
                            res.clear();
                            summax = curmax;
                            res.add(t.val);
                        }
                    }
                    preval=t.val;
                    cur=t.right;
            }
        }
        return res.stream().mapToInt(Integer::valueOf).toArray();
    }
    //二叉树的最近公共祖先 https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==p||root==q||root==null) return root;
        TreeNode left=lowestCommonAncestor(root.left,p,q);
        TreeNode right=lowestCommonAncestor(root.right,p,q);
        if(left!=null&&right!=null) return root;
        if(left==null&&right!=null) return right;
        if(left!=null&&right==null) return left;
        return null;
    }
    //改为搜索树，就简单了，因为有序。https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-search-tree/
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if(root.val>p.val&&root.val>q.val){
            return lowestCommonAncestor1(root.left,p,q);
        }else if(root.val<p.val&&root.val<q.val){
            return lowestCommonAncestor1(root.right,p,q);
        }
        return root;
    }
    //搜索树中的插入操作 https://leetcode.cn/problems/insert-into-a-binary-search-tree/
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root==null) return new TreeNode(val);
        TreeNode v=new TreeNode(val);
        TreeNode t=root;
        while(t!=null){
            if(v.val<t.val){
                if(t.left!=null)
                    t=t.left;
                else{
                    t.left=v;
                    return root;
                }

            }
            if(v.val>t.val){
                if(t.right!=null)
                    t=t.right;
                else{
                    t.right=v;
                    return root;
                }

            }
        }
        return root;
    }
    //删除二叉搜索树中的节点  https://leetcode.cn/problems/delete-node-in-a-bst/
    //未掌握
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null) return root;//没有找到，直接返回
        if(root.val==key) {
            //左孩子为空，右孩子不空，删除节点，右孩子补位，
            if(root.left==null) return root.right;
            else if(root.right==null) return root.left;
            else{
                    TreeNode cur=root.right;
                    while(cur.left!=null){
                        cur=cur.left;
                    }
                    cur.left=root.left;
                    TreeNode tmp=root;
                    root=root.right;
                    return root;
            }
        }
        if(root.val>key) root.left=deleteNode(root.left,key);
        if(root.val<key) root.right=deleteNode(root.right,key);
        return root;
    }
    //迭代
    public TreeNode deleteNode1(TreeNode root, int key) {
        if(root==null) return root;
        TreeNode cur=root;
        TreeNode pre=null;
        while(cur!=null){
            if(cur.val==key) break;
            pre=cur;
            if(cur.val>key) cur=cur.left;
            else cur=cur.right;
        }
        if(pre==null) return deleteOneNode(cur);
        if(pre.left!=null&&pre.left.val==key){
            pre.left=deleteOneNode(cur);
        }
        if(pre.right!=null&&pre.right.val==key){
            pre.right=deleteOneNode(cur);
        }
        return root;
    }

    private TreeNode deleteOneNode(TreeNode cur) {
        if(cur==null) return cur;
        if(cur.right==null) return cur.left;
        TreeNode c=cur.right;
        while(c.left!=null){
            c=c.left;
        }
        c.left=cur.left;
        return cur.right;
    }

    //将有序数组转换为⼆叉搜索树  https://leetcode.cn/problems/convert-sorted-array-to-binary-search-tree/
    private TreeNode trvelsal(int[] nums, int left, int right){
        if(left>right) return null;
        int mid=left+(right-left)/2;
        TreeNode node=new TreeNode(nums[mid]);
        node.left = trvelsal(nums,left,mid-1);
        node.right= trvelsal(nums,mid+1,right);
        return node;



    }
    public TreeNode sortedArrayToBST(int[] nums) {
    TreeNode root=trvelsal(nums,0,nums.length-1);
    return root;
    }

}
//二叉树变形定义
class Node1 {
    public int val;
    public Node1 left;
    public Node1 right;
    public Node1 next;

    public Node1() {}

    public Node1(int _val) {
        val = _val;
    }

    public Node1(int _val, Node1 _left, Node1 _right, Node1 _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
//N叉树定义
class Node_n {
    public int val;
    public List<Node_n> children;

    public Node_n() {}

    public Node_n(int _val) {
        val = _val;
    }

    public Node_n(int _val, List<Node_n> _children) {
        val = _val;
        children = _children;
    }
};
class  ntree{
    //N叉树层次遍历https://leetcode.cn/problems/n-ary-tree-level-order-traversal/
    public List<List<Integer>> levelOrder(Node_n root) {
        Queue<Node_n> que=new  LinkedList<Node_n>();
        List<List<Integer>> res=new ArrayList<>();
        if(root!=null) que.add(root);
        while(!que.isEmpty()){
            int size=que.size();
            List<Integer> vec=new ArrayList<>();
            for(int i=0;i<size;i++){
                Node_n node=que.poll();
                vec.add(node.val);
                for(Node_n x: node.children){
                    que.add(x);

                }
            }
            res.add(vec);
        }
        //Collections.reverse(res);
        return res;
    }
    //填充每个节点的右侧指针，也是层次遍历 https://leetcode.cn/problems/populating-next-right-pointers-in-each-node/
    public Node1 connect(Node1 root) {
        Queue<Node1> que=new LinkedList();
        if(root!=null) que.add(root);
        while(!que.isEmpty()){
            int size =que.size();
            Node1 prenode=new Node1();
            Node1 node;
            for(int i=0;i<size;i++){
                if(i==0){
                    prenode= que.poll();
                    node=prenode;
                }else{
                    node= que.poll();
                    prenode.next=node;
                    prenode=prenode.next;
                }
                if(node.left!=null) que.add(node.left);
                if(node.right!=null) que.add(node.right);
            }
            prenode.next=null;
        }
        return root;
    }
    //填充每个节点的右侧指针2，也是层次遍历 https://leetcode.cn/problems/populating-next-right-pointers-in-each-node-ii/
    public Node1 connect2(Node1 root) {
        Queue<Node1> que=new LinkedList();
        if(root!=null) que.add(root);
        while(!que.isEmpty()){
            int size =que.size();
            for(int i=0;i<size;i++){
                Node1 node=que.poll();
                if (node.left != null) que.add(node.left);
                if (node.right!= null) que.add(node.right);
                // 不是每一行末尾的节点需要建立next连接
                if (i < size - 1) node.next = que.peek();
            }
        }
        return root;
    }
    //N叉树最大深度 https://leetcode.cn/problems/maximum-depth-of-n-ary-tree/
    public int maxDepth(Node_n root) {
        if(root==null) return 0;
        int maxdepth=0;
        for(int i=0;i<root.children.size();i++){
            int temp=maxDepth(root.children.get(i));
            if(temp>maxdepth) maxdepth=temp;
        }
        return maxdepth+1;
    }
}