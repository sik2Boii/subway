package kr.mingling.subway.path;

/**
 * 역과 역 사이의 이동 정보
 *
 * @param toStation 도착역 (역 + 호선)
 * @param timeSec   두 역 사이의 이동 시간 (단위: 초)
 */
public record Section(Station toStation, int timeSec) {}