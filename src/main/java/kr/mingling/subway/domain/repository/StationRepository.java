package kr.mingling.subway.domain.repository;

import java.util.Optional;
import kr.mingling.subway.domain.model.Station;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StationRepository extends JpaRepository<Station, Long> {
    Optional<Station> findByNameAndIsDeletedFalse(String name);
}
