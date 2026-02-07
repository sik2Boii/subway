package kr.mingling.subway.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 역 정보
 */
@Entity
@Table(name = "stations")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Station extends BaseEntity {

    /**
     * 역 이름
     */
    @Column(nullable = false, length = 50)
    private String name;

    /**
     * 위도
     */
    private Double latitude;

    /**
     * 경도
     */
    private Double longitude;
}
