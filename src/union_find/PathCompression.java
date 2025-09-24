package union_find;

public class PathCompression {

    private int[] root;

    public PathCompression(int size) {
        root = new int[size];
        for (int i = 0; i < size; i++) {
            root[i] = i;
        }
    }

    public int find(int x) {
        // if we are at root -> we return root
        if (x == root[x]) {
            return x;
        }
        // here is where compression is happening
        // this recursion will reset the root of all
        // the elements to the head root value
        root[x] = find(root[x]);
        return root[x];
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            root[rootY] = rootX;
        }
    }

    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }
}
