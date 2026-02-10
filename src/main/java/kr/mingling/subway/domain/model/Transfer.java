package kr.mingling.subway.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 환승 정보
 */
@Entity
@Table(name = "transfers")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Transfer extends BaseEntity {

    /**
     * 출발 노선별 역
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "from_line_station_id", nullable = false)
    private LineStation fromLineStation;

    /**
     * 도착 노선별 역
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "to_line_station_id", nullable = false)
    private LineStation toLineStation;

    /**
     * 환승 소요 시간
     */
    @Column(nullable = false)
    private int transferTime;
}
