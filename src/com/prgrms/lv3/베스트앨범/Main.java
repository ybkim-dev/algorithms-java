package com.prgrms.lv3.베스트앨범;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class Main {

  public static void main(String[] args) {
    solution(new String[]{"classic", "pop", "classic", "classic", "pop"},
        new int[]{500, 600, 150, 800, 2500});
  }

  static HashMap<String, List<Info>> countMap = new HashMap<>();

  static public int[] solution(String[] genres, int[] plays) {
    int index = 0;
    for(String genre : genres) {
      if(countMap.containsKey(genre)) {
        countMap.get(genre).add(new Info(plays[index], index));
      } else {
        List<Info> infos = new ArrayList<>();
        infos.add(new Info(plays[index], index));
        countMap.put(genre, infos);
      }
      index++;
    }

    List<Count> counts = new ArrayList<>();
    for(String genre : countMap.keySet()) {
      counts.add(new Count(genre, countMap.get(genre).size()));
    }
    Collections.sort(counts, (o1,o2) -> o2.size - o1.size);

    PriorityQueue<Info> pq = new PriorityQueue<>((o1,o2) -> {
      if(o1.playCount != o2.playCount) return o2.playCount - o1.playCount;
      else return o1.idx - o2.idx;
    });

    int[] answer = new int[counts.size() * 2];
    int answerIndex= 0;
    for(int i = 0; i < counts.size(); i++) {
      pq.clear();

      for(int j = 0; j < countMap.get(counts.get(i).genre).size(); j++) {
        pq.add(countMap.get(counts.get(i).genre).get(j));
      }

      Info first = pq.poll();
      Info second = pq.poll();
      answer[answerIndex++] = first.idx;
      answer[answerIndex++] = second.idx;
    }

    return answer;
  }

}

class Count {
  String genre;
  int size;

  public Count(String genre, int size) {
    this.genre = genre;
    this.size = size;
  }
}

class Info {
  int playCount;
  int idx;

  public Info(int playCount, int idx) {
    this.playCount = playCount;
    this.idx = idx;
  }
}
