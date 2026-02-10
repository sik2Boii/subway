package kr.mingling.subway.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 열차 정보
 */
@Entity
@Table(name = "trains")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Train extends BaseEntity {

    /**
     *
     */
    private String trainNo;

    /**
     * 노선
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "line_id", nullable = false)
    private Line line;

    /**
     *
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "day_type", nullable = false)
    private DayType dayType;

    /**
     *
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "operation_type", nullable = false, length = 20)
    private OperationType operationType;

    /** 기점 */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "start_station_id", nullable = false)
    private Station startStation;

    /** 종점 */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "end_station_id", nullable = false)
    private Station endStation;

    /**
     *
     * @param trainNo
     * @param line
     * @param dayType
     * @param operationType
     * @param startStation
     * @param endStation
     */
    private Train(String trainNo, Line line, DayType dayType, OperationType operationType, Station startStation, Station endStation) {
        this.trainNo = trainNo;
        this.line = line;
        this.dayType = dayType;
        this.operationType = operationType;
        this.startStation = startStation;
        this.endStation = endStation;
    }

    /**
     *
     * @param trainNo
     * @param line
     * @param dayType
     * @param operationType
     * @param startStation
     * @param endStation
     * @return
     */
    public static Train create(String trainNo, Line line, DayType dayType, OperationType operationType, Station startStation, Station endStation) {
        return new Train(trainNo, line, dayType, operationType, startStation, endStation);
    }
}
