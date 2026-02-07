package kr.mingling.subway.path;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 지하철 노선도를 인접 리스트 그래프로 관리하는 클래스
 */
public class SubwayGraph {

    /**
     * 인접 리스트 그래프
     * key:   출발역
     * value: 해당 역에서 이동 가능한 역 목록
     */
    private final Map<Station, List<Section>> adjList = new HashMap<>();

    /**
     * 지하철 노선에 역 추가
     *
     * @param station 추가할 역
     */
    public void addStation(Station station) {
        adjList.putIfAbsent(station, new ArrayList<>());
    }

    /**
     * 두 역 사이의 이동 정보를 그래프에 추가
     *
     * @param from    출발역
     * @param to      도착역
     * @param timeSec 이동 시간 (단위: 초)
     */
    public void addSection(Station from, Station to, int timeSec) {
        addStation(from);
        addStation(to);
        adjList.get(from).add(new Section(to, timeSec));
    }

    /**
     * 환승 구간 연결
     *
     * @param from    환승 시작 지점
     * @param to      환승 목적 지점
     * @param timeSec 환승에 소요되는 시간 (단위: 초)
     */
    public void addTransfer(Station from, Station to, int timeSec) {
        addSection(from, to, timeSec);
        addSection(to, from, timeSec);
    }

    /**
     * 특정 역에서 이동 가능한 모든 역 목록 조회
     *
     * @param station 조회할 출발역 ID
     * @return 해당 역에서 갈 수 있는 인접 역 목록
     */
    public List<Section> findSectionsFrom(Station station) {
        return adjList.getOrDefault(station, List.of());
    }
}
