package com.jjq.ap.dijkstra;


import java.util.List;

public class RoadGraph {

    private int[][] data;



    public RoadGraph() {
        this(9,9);
    }

    public RoadGraph(int c, int r) {
        this.data = new int[c][r];
    }


    /**
     * 行和列都代表节点，数组的值代表两点间的距离
     */
    public void buildGraph() {
        if (this.data == null) {
            this.data = new int[9][9];
        }
        this.data[0][1] = 4;
        this.data[0][7] = 8;
        this.data[1][2] = 8;
        this.data[1][7] = 11;
        this.data[2][3] = 7;
        this.data[2][5] = 4;
        this.data[2][8] = 2;
        this.data[3][4] = 9;
        this.data[3][5] = 14;
        this.data[4][5] = 10;
        this.data[5][6] = 4;
        this.data[6][7] = 1;
        this.data[6][8] = 6;
        this.data[7][8] = 7;
    }

    /**
     * 获取两点直接的距离
     * @param curr
     * @param target
     * @return
     */
    public int getDistance(int curr, int target) {
        return this.data[curr][target];
    }

    /**
     * 获取相连的节点
     * @param target
     * @param excludes 排查的节点
     * @return
     */
    public int[] getConnects(int target, List<Integer> excludes) {



        return null;
    }

    public static void main(String[] args) {
        RoadGraph roadGraph = new RoadGraph();

        roadGraph.buildGraph();
        //第一列的值
        int[] datum = roadGraph.data[1];


    }





}
