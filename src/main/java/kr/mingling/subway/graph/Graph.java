package kr.mingling.subway.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kr.mingling.subway.domain.Edge;

/**
 * 지하철 노선도를 인접 리스트 그래프로 관리하는 클래스
 */
public class Graph {

    /**
     * 인접 리스트 그래프
     * key:   출발역 ID
     * value: 이동 가능한 역 목록
     */
    private final Map<String, List<Edge>> adjList = new HashMap<>();

    /**
     * 두 역 사이의 이동 정보를 그래프에 추가
     *
     * @param fromStationId 출발역 ID
     * @param toStationId   도착역 ID
     * @param timeSec       이동 시간 (단위: 초)
     */
    public void addEdge(String fromStationId, String toStationId, int timeSec) {
        adjList.computeIfAbsent(fromStationId, key -> new ArrayList<>())
            .add(new Edge(toStationId, timeSec));
    }

    /**
     * 특정 역에서 이동 가능한 모든 역 목록 조회
     *
     * @param stationId 조회할 출발역 ID
     * @return 해당 역에서 갈 수 있는 인접 역 목록
     */
    public List<Edge> findEdgesById(String stationId) {
        return adjList.getOrDefault(stationId, List.of());
    }
}
