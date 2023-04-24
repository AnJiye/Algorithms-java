package study.chapter3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 60p. 2차원 배열 응용
 * 교점에 별 만들기
 * https://school.programmers.co.kr/learn/courses/30/lessons/87377
 */
public class Solution1 {
  // 좌표
  private static class Point {
    public final long x, y;
    private Point(long x, long y) {
      this.x = x;
      this.y = y;
    }
  }

  /**
   * 1. 모든 직선 쌍에 대해 반복
   */
  private static Point intersection(long a1, long b1, long c1, long a2, long b2, long c2) {
    // 1-A. 교점 좌표 구하기
    double x = (double) (b1 * c2 - b2 * c1) / (a1 * b2 - a2 * b1);
    double y = (double) (a2 * c1 - a1 * c2) / (a1 * b2 - a2 * b1);

    // 1-B. 정수 좌표만 저장
    if (x % 1 != 0 || y % 1 != 0) return null;

    return new Point((long) x, (long) y);
  }

  /**
   * 2. 저장된 정수들에 대해 x, y 좌표의 최댓값, 최솟값 구하기
   * - 각 좌표의 최댓값과 최솟값 구하기
   */
  private static Point getMinimumPoint(List<Point> points) {
    // 가장 작은 좌표 찾기
    // points 리스트 안의 모든 Point 객체를 순회하면서 가장 작은 x, y 값을 찾고, 이를 사용하여 Point 객체를 만들어 반환
    long x = Long.MAX_VALUE;
    long y = Long.MAX_VALUE;

    for (Point p : points) {
      if (p.x < x) x = p.x;
      if (p.y < y) y = p.y;
    }

    return new Point(x, y);
  }

  private static Point getMaximumPoint(List<Point> points) {
    // 가장 큰 좌표 찾기
    // points 리스트 안의 모든 Point 객체를 순회하면서 가장 큰 x, y 값을 찾고, 이를 사용하여 Point 객체를 만들어 반환
    long x = Long.MIN_VALUE;
    long y = Long.MIN_VALUE;

    for (Point p : points) {
      if (p.x > x) x = p.x;
      if (p.y > y) y = p.y;
    }

    return new Point(x, y);
  }

  public static String[] solution(int[][] line) {
    List<Point> points = new ArrayList<>();
    for (int i=0; i<line.length; i++) {
      for (int j=i+1; j<line.length; j++) {
        Point intersection = intersection(line[i][0], line[i][1], line[i][2], line[j][0], line[j][1], line[j][2]);

        // 정수 좌표만 저장
        if (intersection != null) {
          points.add(intersection);
        }
      }
    }

    /**
     * 3. 구한 최댓값, 최솟값을 이용하여 2차원 배열의 크기 결정
     */
    Point minimum = getMinimumPoint(points);
    Point maximum = getMaximumPoint(points);

    // 배열의 크기이므로 구한 값에 +1
    int width = (int) (maximum.x - minimum.x + 1);
    int height = (int) (maximum.y - minimum.y + 1);

    // 2차원 배열 선언 및 초기화
    char[][] arr = new char[height][width];
    for (char[] row : arr) {
      Arrays.fill(row, '.');
    }

    /**
     * 4. 2차원 배열에 별 표시
     * #주의# 교점을 표현할 수 있는 가장 작은 크기로 2차원 배열을 선언했기 때문에 좌표 변환 필요
     */
    for (Point p : points) {
      // 2차원 배열에 별 찍기
      int x = (int) (p.x - minimum.x);
      int y = (int) (maximum.y - p.y);
      arr[y][x] = '*';
    }

    /**
     * 5. 문자열 배열로 변환 후 반환
     */
    String[] result = new String[arr.length];
    for (int i=0; i<result.length; i++) {
      result[i] = new String(arr[i]);
      System.out.println(result[i]);
    }

    return result;
  }

  public static void main(String[] args) {
    int[][] case1 = {{2, -1, 4}, {-2, -1, 4}, {0, -1, 1}, {5, -8, -12}, {5, 8, 12}};
    int[][] case2 = {{0, 1, -1}, {1, 0, -1}, {1, 0, 1}};
    int[][] case3 = {{1, -1, 0}, {2, -1, 0}};
    int[][] case4 = {{1, -1, 0}, {2, -1, 0}, {4, -1, 0}};

    solution(case1);
    solution(case2);
    solution(case3);
    solution(case4);
  }
}
