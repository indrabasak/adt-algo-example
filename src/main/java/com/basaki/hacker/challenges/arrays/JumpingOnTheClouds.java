package com.basaki.hacker.challenges.arrays;

import java.util.Arrays;
import java.util.List;

/**
 * There is a new mobile game that starts with consecutively numbered clouds. Some of the clouds are thunderheads and others are cumulus. The player can jump on any cumulus cloud having a number that is equal to the number of the current cloud plus  or . The player must avoid the thunderheads. Determine the minimum number of jumps it will take to jump from the starting postion to the last cloud. It is always possible to win the game.
 *
 * For each game, you will get an array of clouds numbered  if they are safe or  if they must be avoided.
 *
 * Example
 *
 * Index the array from . The number on each cloud is its index in the list so the player must avoid the clouds at indices  and . They could follow these two paths:  or . The first path takes  jumps while the second takes . Return .
 *
 * Function Description
 *
 * Complete the jumpingOnClouds function in the editor below.
 *
 * jumpingOnClouds has the following parameter(s):
 *
 * int c[n]: an array of binary integers
 * Returns
 *
 * int: the minimum number of jumps required
 * Input Format
 *
 * The first line contains an integer , the total number of clouds. The second line contains  space-separated binary integers describing clouds  where .
 *
 * Constraints
 *
 * Output Format
 *
 * Print the minimum number of jumps needed to win the game.
 *
 * Sample Input 0
 *
 * 7
 * 0 0 1 0 0 1 0
 * Sample Output 0
 *
 * 4
 */
public class JumpingOnTheClouds {

    /*
     * Complete the 'jumpingOnClouds' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY c as parameter.
     */

    public static int jumpingOnClouds(List<Integer> c) {
        int jumps = 0;

        Integer[] clouds = c.toArray(new Integer[0]);
        int index = 0;
        while (index < clouds.length) {
            int current = clouds[index];
            if (current == 1) {
                jumps++;
                index++;
            } else {
                if (index + 2 < clouds.length && clouds[index + 2] == 0) {
                    jumps++;
                    index = index + 2;
                } else if (index + 1 < clouds.length && clouds[index + 1] == 0) {
                    jumps++;
                    index++;
                } else {
                    index++;
                }

            }
        }

        return jumps;
    }

    public static void main(String... args) {
        List<Integer> clouds = Arrays.asList(0, 0, 0, 0, 1, 0);
        System.out.println(jumpingOnClouds(clouds));

        clouds = Arrays.asList(0, 0, 1, 0, 0, 1, 0);
        System.out.println(jumpingOnClouds(clouds));
    }
}
