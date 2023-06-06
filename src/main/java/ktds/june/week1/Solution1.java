package ktds.june.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 6월 1주차
 * 68645번: 월간 코드 챌린지 시즌1 > 삼각 달팽이
 * 피보나치 수
 * https://school.programmers.co.kr/learn/courses/30/lessons/68645
 */
public class Solution1 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    List<Integer> list = new ArrayList<>();


    for (int i = 0; i < n; i++) {
      list.add(i+1);
      for (int j = 0; j < i; j++) {
        if (i == 1) {
          list.add(3 * (n - 1));
        } else {

        }
      }
    }

    Object[] answer = list.toArray();

    System.out.println(Arrays.toString(answer));
  }
}
