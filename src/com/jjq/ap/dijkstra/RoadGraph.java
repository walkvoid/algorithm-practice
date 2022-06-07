package com.jjq.ap.dijkstra;


import java.util.Arrays;
import java.util.List;

/**
 * 路径图表达,使用二维数据,另外提供一些工具方法,column列表示各个节点,row代表能直接连通的节点,值代表了距离
 */
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

        this.data[1][0] = 4;
        this.data[1][2] = 8;
        this.data[1][7] = 11;

        this.data[2][1] = 8;
        this.data[2][3] = 7;
        this.data[2][5] = 4;
        this.data[2][8] = 2;

        this.data[3][2] = 7;
        this.data[3][4] = 9;
        this.data[3][5] = 14;

        this.data[4][3] = 9;
        this.data[4][5] = 10;

        this.data[5][2] = 4;
        this.data[5][3] = 14;
        this.data[5][4] = 10;
        this.data[5][6] = 2;

        this.data[6][5] = 2;
        this.data[6][7] = 1;
        this.data[6][8] = 6;

        this.data[7][0] = 8;
        this.data[7][1] = 11;
        this.data[7][6] = 1;
        this.data[7][8] = 7;

        this.data[8][2] = 2;
        this.data[8][6] = 6;
        this.data[8][7] = 7;
    }

    public int getNodeSize() {
        return this.data[0].length;
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
     * @param column
     * @param excludes 排查的节点
     * @return
     */
    public int[] getConnects(int column, Integer... excludes) {
        List<Integer> excludeList = Arrays.asList(excludes);
        //获取行数
        int rowNum = this.data[column].length;
        int[] resultTmp = new int[rowNum];
        //遍历行数,取this.data[column][i]的值大于0,并返回所有符合要求i
        for (int i = 0; i < rowNum; i++) {
            if (this.data[column][i] > 0 && !excludeList.contains(i)) {
                resultTmp[i] = i;
            } else {
                resultTmp[i] = -1;
            }
        }
        return resultTmp;
    }
}
