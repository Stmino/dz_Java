import java.util.ArrayDeque;
import java.util.Queue;

class Node {
    int x, y, dist;

    Node(int x, int y, int dist) {
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
}

class dz6 {
    private static final int[] row = { -1, 0, 0, 1 };
    private static final int[] col = { 0, -1, 1, 0 };

    private static boolean isValid(int[][] getMap, boolean[][] visited, int row, int col) {
        return (row >= 0) && (row < getMap.length) && (col >= 0) && (col < getMap[0].length)
                && getMap[row][col] == 1 && !visited[row][col];
    }

    private static int ShortersWay(int[][] getMap, int i, int j, int x, int y) {
        int M = getMap.length;
        int N = getMap[0].length;
        boolean[][] visited = new boolean[M][N];
        
        Queue<Node> q = new ArrayDeque<>();
        visited[i][j] = true;
        q.add(new Node(i, j, 0));
        int min_dist = Integer.MAX_VALUE;
        while (!q.isEmpty()) {
            Node node = q.poll();
            i = node.x;
            j = node.y;
            int dist = node.dist;
            if (i == x && j == y) {
                min_dist = dist;
                break;
            }
            for (int k = 0; k < 4; k++) {

                if (isValid(getMap, visited, i + row[k], j + col[k])) {

                    visited[i + row[k]][j + col[k]] = true;
                    q.add(new Node(i + row[k], j + col[k], dist + 1));
                }
            }
        }

        if (min_dist != Integer.MAX_VALUE) {
            return min_dist;
        }
        return -1;

    }
    static int[][] getMap() {
        return new int[][] {
                { 1, 1, 1, 1, 1, 0, 0, 1, 1, 1 },
                { 0, 1, 1, 1, 1, 1, 0, 1, 0, 1 },
                { 0, 0, 1, 1, 1, 1, 1, 0, 0, 1 },
                { 1, 0, 1, 1, 1, 0, 1, 1, 0, 1 },
                { 1, 0, 0, 1, 0, 0, 0, 1, 0, 1 },
                { 1, 0, 1, 1, 1, 0, 0, 1, 1, 0 },
        };
    }
    public static void main(String[] args) {

        int min_dist = ShortersWay(getMap(), 0, 0, 3, 3);
        if (min_dist != -1) {
            System.out.println("кратчайщий путь: " + min_dist);
        } else {
            System.out.println("ошибка поиска пути");
        }  
    }
}