package kr.mingling.subway.domain.model;

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
    private LocalTime arrivalTime;

    /**
     * 출발 시각
     */
    private LocalTime departureTime;

    /**
     * 정차 순번
     */
    @Column(nullable = false)
    private int stationSeq;

    /**
     *
     * @param train
     * @param lineStation
     * @param stationSeq
     * @param arrivalTime
     * @param departureTime
     */
    private Timetable(Train train, LineStation lineStation, int stationSeq, LocalTime arrivalTime, LocalTime departureTime) {
        this.train = train;
        this.lineStation = lineStation;
        this.stationSeq = stationSeq;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
    }

    public static Timetable create(Train train, LineStation lineStation, int stationSeq, LocalTime arrivalTime, LocalTime departureTime) {
        return new Timetable(train, lineStation, stationSeq, arrivalTime, departureTime);
    }
}
