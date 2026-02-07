package kr.mingling.subway.path;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 다익스트라 알고리즘을 이용해 두 역 사이의 최단 경로를 계산하는 클래스
 */
public class SubwayPathFinder {

    /**
     * 출발역에서 도착역까지의 최단 경로 계산
     *
     * @param subwayGraph 지하철 노선도 그래프
     * @param startStation 출발역 Node (역 + 호선)
     * @param endStation   도착역 Node (역 + 호선)
     * @return 최단경로
     */
    public static PathResult shortestPath(SubwayGraph subwayGraph, Station startStation, Station endStation) {

        Map<Station, Integer> shortestTimeSec = new HashMap<>();
        Map<Station, Station> prevStations = new HashMap<>();
        PriorityQueue<State> priorityQueue = new PriorityQueue<>(Comparator.comparing(state -> state.timeSec));

        // 출발역 초기화
        shortestTimeSec.put(startStation, 0);
        priorityQueue.add(new State(startStation, 0));

        while (!priorityQueue.isEmpty()) {
            State currentStation = priorityQueue.poll();

            // 도착역에 도달하면 탐색 종료
            if (currentStation.station.equals(endStation)) {
                break;
            }

            // 인접 역 탐색
            for (Section section : subwayGraph.findSectionsFrom(currentStation.station)) {
                int nextTimeSec = currentStation.timeSec + section.timeSec();

                // 더 짧은 경로인 경우 갱신
                if (nextTimeSec < shortestTimeSec.getOrDefault(section.toStation(), Integer.MAX_VALUE)) {
                    shortestTimeSec.put(section.toStation(), nextTimeSec);
                    prevStations.put(section.toStation(), currentStation.station);
                    priorityQueue.add(new State(section.toStation(), nextTimeSec));
                }
            }
        }

        // 경로 복원
        return buildPath(prevStations, shortestTimeSec, startStation, endStation);
    }

    /**
     * 이전 역 정보를 이용해 실제 경로를 복원
     */
    private static PathResult buildPath(Map<Station, Station> prevStations,
                                        Map<Station, Integer> shortestTimeSec,
                                        Station startStation,
                                        Station endStation) {

        List<Station> path = new ArrayList<>();

        // 도착역부터 출발역까지 역순으로 추적
        for (Station station = endStation; station != null; station = prevStations.get(station)) {
            path.add(station);
        }

        // 순서 변환
        Collections.reverse(path);

        return new PathResult(path, shortestTimeSec.getOrDefault(endStation, -1));
    }

    /**
     * 우선순위 큐에서 사용하는 내부 노드
     *
     * @param station    현재 역 ID
     * @param timeSec 누적 이동 시간 (단위: 초)
     */
    private record State(Station station, int timeSec) {}
}
