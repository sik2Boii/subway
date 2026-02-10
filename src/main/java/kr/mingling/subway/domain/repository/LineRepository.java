package kr.mingling.subway.domain.repository;

import java.util.Optional;
import kr.mingling.subway.domain.model.Line;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LineRepository extends JpaRepository<Line, Long> {
    Optional<Line> findByNameAndIsDeletedFalse(String name);
}
