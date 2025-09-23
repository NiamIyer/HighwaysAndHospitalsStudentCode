/**
 * Highways & Hospitals
 * A puzzle created by Zach Blick
 * for Adventures in Algorithms
 * at Menlo School in Atherton, CA
 *
 * Completed by: [Niam]
 *
 */

public class HighwaysAndHospitals {


    public static long cost(int n, int hospitalCost, int highwayCost, int cities[][]) {
        // If it is cheaper to build hospitals then there would be no point in building any highway
        if (hospitalCost <= highwayCost) {
            return (long) n * hospitalCost;
        }

        // Array to store information about amount of disconnected components and which nodes are connected
        int[] parents = new int[n + 1];
        // Since each node is its own parent, every node is set to -1 since 1 is the size
        for (int i = 1; i <= n; i++) {
            parents[i] = -1;
        }

        for (int i = 0; i < cities.length; i++) {
            // For every possible highway, check to see how that changes the components
            connect(cities[i][0], cities[i][1], parents);
        }
        // Finds amount of disconnected components by seeing how many nodes have "parents" that are negative
        int counter = 0;
        for (int i = 1; i <= n; i++) {
            if (parents[i] < 0) {
                counter ++;
            }
        }
        // Return the amount of disconnected components * the hospitalCost +
        // (the amount of cities - the amount of disconnected components) * the highway cost
        return (long) counter * hospitalCost + (long) (n - counter) * highwayCost;
    }
    private static int find (int city, int[] parents) {
        int parent = city;
        // While the parent's parent isn't negative (while it isn't the root)
        // Set the parent to its parent to find the root
        while (parents[parent] >= 0) {
            parent = parents[parent];
        }

        // While the city isn't its parent, set the parent of city to the root,
        // and the city to its parent so that we can check again for the city's old parent
        while (city != parent) {
            int nextParent = parents[city];
            parents[city] = parent;
            city = nextParent;
        }

        return parent;
    }
    private static void connect (int first, int last, int[] parents) {
        // Finds the roots of both cities for the possible highway
        int rootFirst = find(first,parents);
        int rootLast = find(last,parents);

        // If the roots aren't the same (if they aren't already in the same disconnected component)
        if (rootFirst != rootLast) {
            // Finds the size
            int sizeFirst = -1 * parents[rootFirst];
            int sizeLast = -1 * parents[rootLast];
            // Sets the root of one as the other and adds the size, depending on which one's bigger
            if (sizeFirst >= sizeLast) {
                parents[rootFirst] = -(sizeFirst + sizeLast);
                parents[rootLast] = rootFirst;
            }
            else {
                parents[rootLast] = -(sizeLast + sizeFirst);
                parents[rootFirst] = rootLast;
            }
        }

    }
}
