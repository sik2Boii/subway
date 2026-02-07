package kr.mingling.subway.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 노선별 역 정보
 */
@Entity
@Table(name = "line_stations")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class LineStation extends BaseEntity {

    /**
     * 역
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "station_id", nullable = false)
    private Station station;

    /**
     * 노선
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "line_id", nullable = false)
    private Line line;
}
