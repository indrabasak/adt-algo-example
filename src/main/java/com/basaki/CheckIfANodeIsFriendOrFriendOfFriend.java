package com.basaki;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SuppressWarnings({"squid:S1192", "squid:S3776", "squid:S106",
        "squid:ClassVariableVisibilityCheck"})
public class CheckIfANodeIsFriendOrFriendOfFriend {

    public boolean isRelated1(Node node0, Node node1) {
        if (node0 == node1) {
            return false;
        }
        int iterations = 0;
        HashSet<Node> visitedSet = new HashSet<>();
        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.add(node0);
        while (!queue.isEmpty()) {
            ++iterations;
            Node node = queue.remove();
            if (node == node1) {
                System.out.println("iterations=" + iterations);
                return true;
            }
            visitedSet.add(node);
            for (Node friend : node.friends) {
                if (!visitedSet.contains(friend)) {
                    queue.add(friend);
                }
            }
        }

        System.out.println("iterations=" + iterations);
        return false;
    }

    // Using bidirectional BFS + set intersection.
    // Perform BFS starting from each node. At each distance level, perform an
    // intersection of each visited set.
    // ~O(x^(d/2) + x^(d/2)) where x = average number of friends and d =
    // distance between nodes
    public boolean isRelated2(Node node0, Node node1) {
        if (node0 == node1) {
            return false;
        }
        int iterations = 0;
        HashSet<Node> visitedSet0 = new HashSet<>();
        HashSet<Node> visitedSet1 = new HashSet<>();
        ArrayDeque<Node> queue0 = new ArrayDeque<>();
        ArrayDeque<Node> queue1 = new ArrayDeque<>();
        queue0.add(node0);
        queue1.add(node1);
        int depthTillNextIteration0 = 1;
        int depthTillNextIteration1 = 1;
        while (!queue0.isEmpty() && !queue1.isEmpty()) {
            while (depthTillNextIteration0 > 0) {
                ++iterations;
                Node node00 = queue0.remove();
                visitedSet0.add(node00);
                for (Node friend : node00.friends) {
                    if (!visitedSet0.contains(friend)) {
                        queue0.add(friend);
                    }
                }
                --depthTillNextIteration0;
            }
            while (depthTillNextIteration1 > 0) {
                ++iterations;
                Node node11 = queue1.remove();
                visitedSet1.add(node11);
                for (Node friend : node11.friends) {
                    if (!visitedSet1.contains(friend)) {
                        queue1.add(friend);
                    }
                }
                --depthTillNextIteration1;
            }
            depthTillNextIteration0 = queue0.size();
            depthTillNextIteration1 = queue1.size();
            iterations += visitedSet0.size();
            if (intersects(visitedSet0, visitedSet1)) {
                System.out.println("iterations=" + iterations);
                return true;
            }
        }
        System.out.println("iterations=" + iterations);
        return false;
    }

    public boolean intersects(Set<Node> set0, Set<Node> set1) {
        for (Node node : set0) {
            if (set1.contains(node)) {
                return true;
            }
        }
        return false;
    }

    public static class Node {
        public String name;

        public List<Node> friends;

        public Node(String name) {
            this.name = name;
            friends = new ArrayList<>();
        }

        public void beFriend(Node friend) {
            friends.add(friend);
            friend.friends.add(this);
        }
    }
}
