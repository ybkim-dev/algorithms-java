package com.fastcampus.devmatching2022.two;

import java.util.*;

public class Main {
    static boolean[][] visited;
    static int N, M;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static ArrayList<TreeMap<Character, Integer>> areaList = new ArrayList<>();
    static TreeMap<Character, Integer> areaTemp;
    static char mostChar;
    static String[] map;

    static void findMostCharInRange(int startX, int startY) {
        areaTemp = new TreeMap<>();

        Queue<Integer> queue = new LinkedList<>();
        queue.add(startX);
        queue.add(startY);
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            Integer x = queue.poll();
            Integer y = queue.poll();
            if (areaTemp.containsKey(map[x].charAt(y))) {
                areaTemp.put(map[x].charAt(y), areaTemp.get(map[x].charAt(y)) + 1);
            } else {
                // 한 번도 등록된 적 없으면
                areaTemp.put(map[x].charAt(y), 1);
            }


            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                if(nx < 0 || nx >= N || ny < 0 || ny >= M || map[nx].charAt(ny) =='.') continue;
                if(visited[nx][ny] == true) continue;
                queue.add(nx);
                queue.add(ny);
                visited[nx][ny] = true;
            }

        }

        int max = 0;
        Object[] objects = areaTemp.keySet().toArray();
        for (Object object : objects) {
            Character ch = (Character) object;
            if(max <= areaTemp.get(ch)) {
                max = areaTemp.get(ch);
                mostChar = ch;
            }
        }
    }



    static public int solution(String[] maps) {
        N = maps.length;
        M = maps[0].length();
        map = new String[maps.length];
        map = maps.clone();
        visited = new boolean[N][M];

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length(); j++) {
                if(!visited[i][j] && map[i].charAt(j) != '.') {
                    findMostCharInRange(i,j);
                    Object[] objects = areaTemp.keySet().toArray();
                    int most = areaTemp.get(mostChar);
                    for (Object object : objects) {
                        Character ch = (Character) object;

                        if(most > areaTemp.get(ch)) {
                            areaTemp.put(mostChar, areaTemp.get(mostChar) + areaTemp.get(ch));
                            areaTemp.put(ch, 0);
                        }
                    }
                    areaList.add(areaTemp);
                }
            }
        }
        int[] result = new int[26];
        for (int i = 0; i < areaList.size(); i++) {
            TreeMap<Character, Integer> characterIntegerHashMap = areaList.get(i);
            Object[] objects = characterIntegerHashMap.keySet().toArray();
            for (Object object : objects) {
                Character ch = (Character) object;
                result[ch- 'A'] += characterIntegerHashMap.get(ch);
            }
        }

        int resultMax = 0;
        for (int i = 0; i < result.length; i++) {
            if (resultMax < result[i]) {
                resultMax = result[i];
            }
        }

        return resultMax;
    }

    public static void main(String[] args) {
        System.out.println(solution(new String[] {
                "AA.B.AAA",
                "AA.B.AAA",
                "AAA.AAAA",
                "AAAAAAAA",
                "AAAAAAAA",
                "AAAAAAAA",
                "AAAAAAAA"
        }));
    }
}
