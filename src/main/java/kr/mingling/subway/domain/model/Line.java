package kr.mingling.subway.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 노선 정보
 */
@Entity
@Table(name = "lines")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Line extends BaseEntity {

    /**
     * 노선 이름
     */
    @Column(nullable = false, length = 50)
    private String name;

    /**
     * 노선 색상
     */
    private String color;

    public static Line create(String name) {
        Line line = new Line();
        line.name = name;
        return line;
    }
}
