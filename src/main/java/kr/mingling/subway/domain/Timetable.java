package kr.mingling.subway.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalTime;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 운행 시간표
 */
@Entity
@Table(name = "timetables")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Timetable extends BaseEntity {

    /**
     * 열차
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "train_id", nullable = false)
    private Train train;

    /**
     * 노선별 역
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "line_station_id", nullable = false)
    private LineStation lineStation;

    /**
     * 도착 시각
     */
    @Column(nullable = false)
    private LocalTime arrivalTime;

    /**
     * 출발 시각
     */
    @Column(nullable = false)
    private LocalTime departureTime;

    /**
     * 정차 순번
     */
    @Column(nullable = false)
    private int seq;
}
