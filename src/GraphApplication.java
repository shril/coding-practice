import java.util.*;

public class GraphApplication {
    Map<Integer, ArrayList<Integer>> graph;

    public GraphApplication(int n) {
        this.graph = new HashMap<>();
        this.createNodes(n);
    }

    private void createNodes(int n) {
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }
    }

    public void createEdge(int source, int destination) {
        graph.get(source).add(destination);
    }

    public void createGraph() {
        createEdge(0, 1);
        createEdge(0, 2);
        createEdge(1, 3);
        createEdge(1, 4);
        createEdge(2, 5);
        createEdge(2, 6);
        createEdge(3, 7);
        createEdge(3, 8);
        createEdge(4, 9);
        createEdge(5, 10);
        createEdge(6, 11);
        createEdge(6, 12);
    }

    public void bfs(int start) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        // Add start to visited and queue
        visited.add(start);
        queue.add(start);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");
            for (int child: graph.get(node)) {
                if (!visited.contains(child)) {
                    queue.add(child);
                }
            }
        }
    }

    public void shortestPathBFS(int start, int end) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        Map<Integer, Integer> distanceMap = new HashMap<>();

        // add start to queue and visited
        visited.add(start);
        queue.add(start);
        distanceMap.put(start, 0);
        boolean found = false;

        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            int currentDistance = distanceMap.get(currentNode);

            for (int child: graph.get(currentNode)) {
                if (!visited.contains(child)) {
                    visited.add(child);
                    queue.add(child);
                    distanceMap.put(child, currentDistance + 1);

                    if (child == end) {
                        System.out.println("Distance is: " + distanceMap.get(child));
                        found = true;
                        break;
                    }
                }
            }
            if (found) break;
        }
    }

    public void dfs(int start) {
        Set<Integer> visited = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        stack.add(start);

        while (!stack.empty()) {
            int node = stack.pop();
            if (!visited.contains(node)) {
                visited.add(start);
                System.out.print(node + " ");
                Stack<Integer> tempStack = new Stack<>();
                for (int child : graph.get(node)) {
                    if (!visited.contains(child)) {
                        tempStack.add(child);
                    }
                }
                while (!tempStack.empty()) {
                    stack.add(tempStack.pop());
                }
            }
        }
    }

    static void main() {
        GraphApplication app = new GraphApplication(13);
        app.createGraph();
         app.bfs(0);
        // app.dfs(0);
        app.shortestPathBFS(0, 11);
        app.shortestPathBFS(6, 11);
        app.shortestPathBFS(2, 10);
    }
}
