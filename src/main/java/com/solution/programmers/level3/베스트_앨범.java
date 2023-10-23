package com.solution.programmers.level3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class 베스트_앨범 {

    public static void main(String args[]) {
        String[] genres = new String[]{"classic", "pop", "classic", "classic", "pop"};
        int[] plays = new int[]{500, 600, 150, 800, 2500};
        int[] solutions = solution(genres, plays);
        for (int solution : solutions) {
            System.out.println(solution);
        }
    }

    public static int[] solution(String[] genres, int[] plays) {

        Map<String, PriorityQueue<Pair>> map = new HashMap<>();
        Map<String, Integer> sumMap = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            Pair pair = new Pair();
            pair.setPair(i, genres[i], plays[i]);

            if (map.containsKey(genres[i])) {
                PriorityQueue<Pair> priorityQueue = map.get(genres[i]);
                priorityQueue.add(pair);

                Integer sum = sumMap.get(genres[i]);
                sumMap.put(genres[i], sum + plays[i]);
            } else {
                PriorityQueue<Pair> priorityQueue = new PriorityQueue<>((o1, o2) -> o2.plays - o1.plays);
                priorityQueue.add(pair);
                map.put(genres[i], priorityQueue);

                sumMap.put(genres[i], plays[i]);
            }
        }

        List<Integer> result = new ArrayList<>();
        List<Map.Entry<String, Integer>> list = new ArrayList<>(sumMap.entrySet());
        Collections.sort(list, (o1, o2) -> o2.getValue().compareTo(o1.getValue()));

        for (Map.Entry<String, Integer> entry : list) {
            String sumKey = entry.getKey();
            PriorityQueue<Pair> priorityQueue = map.get(sumKey);
            int size = priorityQueue.size();
            for (int i = 0; i < (Math.min(size, 2)); i++) {
                Pair poll = priorityQueue.poll();
                result.add(poll.sn);
            }
        }


        return result
                .stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    static class Pair {

        private int sn;
        private String genres;
        private int plays;


        public void setPair(int sn, String genres, int plays) {
            this.sn = sn;
            this.genres = genres;
            this.plays = plays;
        }
    }
}
