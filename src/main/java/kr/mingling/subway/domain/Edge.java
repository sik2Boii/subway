package kr.mingling.subway.domain;

/**
 * 역과 역 사이의 이동 정보
 *
 * @param toStationId 도착역 ID
 * @param timeSec     두 역 사이의 이동 시간 (단위: 초)
 */
public record Edge(String toStationId, int timeSec) {}