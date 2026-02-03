package kr.mingling.subway.graph;

import java.util.List;

/**
 * 경로 탐색 결과
 *
 * @param path         출발역부터 도착역까지의 역 ID 목록
 * @param totalTimeSec 전체 이동 시간 (단위: 초)
 */
public record PathResult(List<String> path, int totalTimeSec) {}
