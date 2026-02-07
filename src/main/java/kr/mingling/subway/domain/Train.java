package kr.mingling.subway.domain;

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
 * 열차 정보
 */
@Entity
@Table(name = "trains")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Train extends BaseEntity {

    /**
     * 노선
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "line_id", nullable = false)
    private Line line;

    /**
     * 운행 방향
     */
    @Column(nullable = false, length = 50)
    private String direction;
}
