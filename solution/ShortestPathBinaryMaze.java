import java.util.LinkedList;
import java.util.Queue;

/**
 * Shortest Path in Maze Problem
 * 
 * @author  Vamsi Krishna Myalapalli
 * @version 1.0
 * @since   2019-12-27
 */
class ShortestPathBinaryMaze
{
    static int ROW = 3, COL = 3;
    static class Point {
        int x, y;
        public Point(int x, int y) {
            this.x = x;  this.y = y;
        }
        @Override
        public String toString() {
            return "["+x+","+y+"]";
        }
    }

    static class QueueNode   {
        Point point;
        int dist; // cell's distance of from the source
        public QueueNode(Point point, int dist) {
            this.point = point; this.dist = dist;
        }
        @Override
        public String toString() {
            return "Point: "+point+" Dist: "+dist;
        }
    }

    // check whether given cell (row, col) is a valid cell or not.
    static boolean isValid(int row, int col) {
        // return true if row and column are in range
        return (row >= 0) && (row < ROW) && (col >= 0) && (col < COL);
    }

    // These arrays are used to get row and column numbers of 4 neighbours of a given cell
    static int rowNum[] = {-1, 0, 0, 1};
    static int colNum[] = {0, -1, 1, 0};

    static int BFS(int mat[][], Point src, Point dest)
    {
        if (mat[src.x][src.y] != 1 || mat[dest.x][dest.y] != 1)
            return -1;

        boolean[][] visited = new boolean[ROW][COL];
        visited[src.x][src.y] = true;

        // Create a queue for BFS
        Queue<QueueNode> queue = new LinkedList<>();
        QueueNode s = new QueueNode(src, 0); // Distance of source cell is 0
        queue.add(s); // Enqueue source cell

        while (!queue.isEmpty())  {
            QueueNode queueNode = queue.peek();
            Point currentPoint = queueNode.point;

            if (currentPoint.x == dest.x && currentPoint.y == dest.y)
                return queueNode.dist; // If we have reached the destination cell, we are done

            // Otherwise dequeue the front cell in the queue and enqueue its adjacent cells
            queue.remove();

            for (int i = 0; i < 4; i++)
            {
                int row = currentPoint.x + rowNum[i];
                int col = currentPoint.y + colNum[i];
                if (isValid(row, col) && mat[row][col] == 1 && !visited[row][col])  {
                    visited[row][col] = true;
                    QueueNode adjCell = new QueueNode(new Point(row, col), queueNode.dist + 1 );
                    queue.add(adjCell);
                }
            }
        }
        return -1;
    }

    public static void main(String[] args)
    {
        int matrix[][] = {
                { 1, 1, 1 },
                { 1, 1, 1 },
                { 0, 0, 1 }};

        Point source = new Point(0, 0);
        Point dest = new Point(2, 2);

        int dist = BFS(matrix, source, dest);

        if (dist != Integer.MAX_VALUE)
            System.out.println("Shortest Path is " + dist);
        else
            System.out.println("Shortest Path doesn't exist");
    }
}




/*
Output:
—————————

Shortest Path is 4

*/
