package com.basaki.cracking.treesandgraphs;

import java.util.List;
import lombok.Getter;

public class Graph {


    public static class Node {
        @Getter
        private int value;

        private List<Node> adjacentNodes;

        public Node(int value) {
            this.value = value;
        }
    }
}
