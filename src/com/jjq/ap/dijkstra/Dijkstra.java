package com.jjq.ap.dijkstra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jiangjunqing
 * @date 2022/6/6
 * @description: Dijkstra算法
 * @version:
 */
public class Dijkstra {


    /**
     * 执行路口
     * @param args
     */
    public static void main(String[] args) {

        RoadGraph roadGraph = new RoadGraph(9, 9);
        roadGraph.buildGraph();
        int[] route = calcShortestRoute(0, roadGraph);
        System.out.println("最短路径是:" + Arrays.toString(route));
    }

    /**
     * 计算最短路径
     * @param target
     * @param roadGraph
     * @return
     */
    public static int[] calcShortestRoute(int target, RoadGraph roadGraph) {

        Integer[] excludeNodes = new Integer[roadGraph.getNodeSize()];
        int tmpTarget = target;
        int[] connects = roadGraph.getConnects(tmpTarget, excludeNodes);

        return null;
    }
}
