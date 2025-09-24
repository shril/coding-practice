package union_find;

public class OptimisedUnionFind {

    private int[] rank;
    private int[] root;
    public OptimisedUnionFind(int size) {
        rank = new int[size];
        root = new int[size];
        for (int i = 0; i < size; i++) {
            root[i] = i;
            rank[i] = 1;
        }
    }

    public int find(int x) {
        // if we are at the parent node, we return value
        if (x != root[x]) {
            root[x] = find(x);
        }
        // doing path compression for all other nodes
        return root[x];
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rank[rootX] > rank[rootY]) {
            root[rootY] = rootX;
        } else if (rank[rootX] < rank[rootY]) {
            root[rootX] = rootY;
        } else {
            root[rootY] = rootX;
            rank[rootX] += 1;
        }
    }

    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }
}
