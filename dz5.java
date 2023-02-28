
import java.util.LinkedList;
import java.util.Queue;

public class dz5 {
  public static void main(String[] args) {

    var mg = new MapGenerator();
    var lee = new Map(mg.getMap());
    lee.StartMap(new Coord(3, 3));
    System.out.println(new MapPrinter().rawData(mg.getMap()));
  }
}

class Coord {
  int x, y;

  public Coord(int x, int y) {
    this.x = x;
    this.y = y;
  }
}

class MapGenerator {
  int[][] map;

  public MapGenerator() {
    int[][] map = {
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, 00, 00, 00, -1, 00, 00, 00, 00, 00, 00, 00, 00, 00, -1 },
        { -1, 00, 00, 00, 00, 00, 00, -1, 00, 00, 00, 00, 00, 00, -1 },
        { -1, 00, 00, 00, -1, 00, 00, -1, 00, 00, 00, 00, 00, 00, -1 },
        { -1, 00, 00, 00, -1, 00, -1, -1, -1, -1, 00, 00, 00, 00, -1 },
        { -1, 00, 00, 00, -1, 00, -1, 00, 00, -1, 00, 00, 00, 00, -1 },
        { -1, -1, -1, 00, -1, 00, -1, 00, 00, -1, 00, 00, 00, 00, -1 },
        { -1, 00, 00, 00, -1, 00, -1, 00, 00, -1, -1, -1, 00, 00, -1 },
        { -1, 00, 00, 00, -1, 00, 00, 00, 00, -1, 00, 00, 00, 00, -1 },
        { -1, 00, 00, 00, -1, 00, 00, 00, 00, -1, 00, 00, 00, 00, -1 },
        { -1, 00, 00, 00, -1, -1, -1, -1, -1, -1, 00, 00, 00, 00, -1 },
        { -1, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, -1 },
        { -1, 00, 00, 00, -1, -1, -1, -1, -1, -1, -1, 00, 00, 00, -1 },
        { -1, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }
    };

    this.map = map;
  }

  public int[][] getMap() {
    return map;
  }
}

class MapPrinter {

  public MapPrinter() {
  }

  public String rawData(int[][] map) {
    StringBuilder sb = new StringBuilder();

    for (int row = 0; row < map.length; row++) {
      for (int col = 0; col < map[row].length; col++) {
        sb.append(String.format("%5d", map[row][col]));
      }
      sb.append("\n");
    }
    for (int i = 0; i < 3; i++) {
      sb.append("\n");
    }

    return sb.toString();
  }
}

class Map {
  int[][] map;

  public Map(int[][] map) {
    this.map = map;
  }

  public void StartMap(Coord startCoord) {
    Queue<Coord> queue = new LinkedList<Coord>();
    queue.add(startCoord);
    map[startCoord.x][startCoord.y] = 1;

    while (queue.size() != 0) {
      Coord p = queue.remove();

      if (map[p.x - 1][p.y] == 0) {
        queue.add(new Coord(p.x - 1, p.y));
        map[p.x - 1][p.y] = map[p.x][p.y] + 1;
      }
      if (map[p.x][p.y - 1] == 0) {
        queue.add(new Coord(p.x, p.y - 1));
        map[p.x][p.y - 1] = map[p.x][p.y] + 1;
      }
      if (map[p.x + 1][p.y] == 0) {
        queue.add(new Coord(p.x + 1, p.y));
        map[p.x + 1][p.y] = map[p.x][p.y] + 1;
      }
      if (map[p.x][p.y + 1] == 0) {
        queue.add(new Coord(p.x, p.y + 1));
        map[p.x][p.y + 1] = map[p.x][p.y] + 1;
      }
    }
  }

}