package kr.mingling.subway.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import kr.mingling.subway.domain.Edge;

/**
 * 다익스트라 알고리즘을 이용해 두 역 사이의 최단 경로를 계산하는 클래스
 */
public class Dijkstra {

    /**
     * 출발역에서 도착역까지의 최단 경로 계산
     *
     * @param graph          지하철 노선도 그래프
     * @param startStationId 출발역 ID
     * @param endStationId   도착역 ID
     * @return 최단경로
     */
    public static PathResult shortestPath(Graph graph, String startStationId, String endStationId) {

        Map<String, Integer> shortestTimeSec = new HashMap<>();
        Map<String, String> prevStations = new HashMap<>();
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(Comparator.comparing(node -> node.timeSec));

        // 출발역 초기화
        shortestTimeSec.put(startStationId, 0);
        priorityQueue.add(new Node(startStationId, 0));

        while (!priorityQueue.isEmpty()) {
            Node currentStation = priorityQueue.poll();

            // 도착역에 도달하면 탐색 종료
            if (currentStation.stationId.equals(endStationId)) {
                break;
            }

            // 인접 역 탐색
            for (Edge edge : graph.findEdgesById(currentStation.stationId)) {
                int nextTimeSec = currentStation.timeSec + edge.timeSec();

                // 더 짧은 경로인 경우 갱신
                if (nextTimeSec < shortestTimeSec.getOrDefault(edge.toStationId(), Integer.MAX_VALUE)) {
                    shortestTimeSec.put(edge.toStationId(), nextTimeSec);
                    prevStations.put(edge.toStationId(), currentStation.stationId);
                    priorityQueue.add(new Node(edge.toStationId(), nextTimeSec));
                }
            }
        }

        // 경로 복원
        return buildPath(prevStations, shortestTimeSec, startStationId, endStationId);
    }

    /**
     * 이전 역 정보를 이용해 실제 경로를 복원
     */
    private static PathResult buildPath(Map<String, String> prevStations,
                                        Map<String, Integer> shortestTimeSec,
                                        String startStationId,
                                        String endStationId) {

        List<String> path = new ArrayList<>();

        // 도착역부터 출발역까지 역순으로 추적
        for (String stationId = endStationId; stationId != null; stationId = prevStations.get(stationId)) {
            path.add(stationId);
        }

        // 순서 변환
        Collections.reverse(path);

        return new PathResult(path, shortestTimeSec.getOrDefault(endStationId, -1));
    }

    /**
     * 우선순위 큐에서 사용하는 내부 노드
     *
     * @param stationId 현재 역 ID
     * @param timeSec   누적 이동 시간 (단위: 초)
     */
    private record Node(String stationId, int timeSec) {}
}
