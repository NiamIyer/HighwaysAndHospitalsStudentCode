import java.util.Stack;

/**
 * Highways & Hospitals
 * A puzzle created by Zach Blick
 * for Adventures in Algorithms
 * at Menlo School in Atherton, CA
 *
 * Completed by: [YOUR NAME HERE]
 *
 */

public class HighwaysAndHospitals {

    /**
     * TODO: Complete this function, cost(), to return the minimum cost to provide
     *  hospital access for all citizens in Menlo County.
     */
    public static long cost(int n, int hospitalCost, int highwayCost, int cities[][]) {
        // Check if highwayCost < hospitalCost
        // If it is not return hospitalCost * n
        // If it is, do following:
        // Check if everything can be connected by highway
        // If it can, return (n-1) * (highwayCost) + hospitalCost
        // If not, add one hospital to each section
        // (A section is a group of cities that can be connected by highway)
        // Do step 5 for every section
        int counter = 0;
        boolean[] visited = new boolean[n];
        Stack<Integer> stack = new Stack<Integer>();
        stack.add(0);
        for (int i = 0; i < cities.length; i++) {
            int city = stack.pop();

        }
        return 0;
    }
}
