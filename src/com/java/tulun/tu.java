package com.java.tulun;

import java.util.*;

public class tu {
    public static void main(String[] args) {
//        List<List<Integer>> rooms=new ArrayList<>();
//        rooms.add(new ArrayList<>(Arrays.asList(1,2)));
//        rooms.add(new ArrayList<>(Arrays.asList(3)));
//        rooms.add(new ArrayList<>(Arrays.asList(3)));
//        rooms.add(new ArrayList<>(Arrays.asList()));
        int[][]r=new int[][]{{1,2},{3},{3},{}};
//        rooms.add(new ArrayList<>(Arrays.asList(4)));
//
//        rooms.add(new ArrayList<>(Arrays.asList()));
//        rooms.add(new ArrayList<>(Arrays.asList(1,9,2,3)));
//        rooms.add(new ArrayList<>(Arrays.asList(7)));
//        rooms.add(new ArrayList<>(Arrays.asList(6,5)));
//        rooms.add(new ArrayList<>(Arrays.asList(2,3,1)));
        System.out.println(canFinish(2,new int[][]{{1,0}}));

    }
    /**
     * https://leetcode.cn/problems/keys-and-rooms/
     * @param rooms
     * @return
     */
//    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
//        int length= rooms.size();
//        boolean[]used=new boolean[length];
//        boolean[] flag=new boolean[length];
//        Arrays.fill(used,false);
//        Arrays.fill(flag,false);
//        flag[0]=true;
//        int f=0;
//        int i=0;
//        while(i<length){
//            if(flag[i]&&!used[i]){
//                used[i]=true;
//                for (Integer t:rooms.get(i)) {
//                    f=1;
//                    flag[t]=true;
//                }
//            }
//
//            i++;
//            if(f==0&&i==10){
//                break;
//            }
//            if(i==length&&f==1){
//                f=0;
//                i=0;
//            }
//
//        }
//        for (int j = 0; j < length; j++) {
//            if(!flag[j]){
//                return false;
//            }
//        }
//        return true;
//    }


    /**
     * https://leetcode.cn/problems/all-paths-from-source-to-target/
     * 所有可能的路径
     * @param graph
     * @return
     */
//    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
//        List<List<Integer>> res=new ArrayList<>();
//        List<Integer> tmp=new ArrayList<>();
//        boolean[] used=new boolean[graph.length];
//        tmp.add(0);
//        dfs(res,tmp,used,graph,0);
//
//        return res;
//    }
//
//    private static void dfs(List<List<Integer>> res, List<Integer> tmp, boolean[] used, int[][] graph, int now_point) {
//        if(now_point==graph.length-1){
//            res.add(new ArrayList<>(tmp));
//            return ;
//        }
//
//        for (int i = 0; i < graph[now_point].length; i++) {
//            tmp.add(graph[now_point][i]);
//            dfs(res,tmp,used,graph,graph[now_point][i]);
//            tmp.remove(tmp.size()-1);
//        }
//    }


    /**
     * 课程表
     *
     * https://leetcode.cn/problems/course-schedule/
     * @param prerequisites
     * @return
     */
    public static boolean canFinish(int numCourses, int[][] prerequisites) {

        Map<Integer,List<Integer>> adj=new HashMap<>();//邻接表，表示key课程，需要先修value[]门课。
        int[] rudu=new int[numCourses];//入度表，表示课程i的入读为rudu[]
        Arrays.fill(rudu,0);

        //初始化入读表，初始化邻接表，
        for (int[] react:prerequisites) {
            int cur =react[1];
            int next=react[0];

            rudu[next]++;

            if(!adj.containsKey(cur)){

                adj.put(cur,new ArrayList<>());
            }
            adj.get(cur).add(next);
        }

        //使用队列，首先将入度为0的课程入列。
        Queue<Integer> queue=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(rudu[i]==0){
                queue.add(i);
            }
        }

        //开始遍历队列，队列中放的是现在能学的课程
        while(!queue.isEmpty()){
            int cur= queue.poll();

            if(!adj.containsKey(cur)){
                continue;
            }

            //获取到我现在学完这门课，能够学其他的什么课。
            List<Integer> successorList = adj.get(cur);

            for (int k : successorList) {
                rudu[k]--;
                if (rudu[k] == 0) {
                    queue.offer(k);
                }
            }


        }

        for (int i = 0; i < numCourses; i++) {
            if(rudu[i]!=0) return false;
        }
        return  true;

    }


}
