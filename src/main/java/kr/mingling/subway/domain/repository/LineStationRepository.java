package kr.mingling.subway.domain.repository;

import java.util.Optional;
import kr.mingling.subway.domain.model.Line;
import kr.mingling.subway.domain.model.LineStation;
import kr.mingling.subway.domain.model.Station;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LineStationRepository extends JpaRepository<LineStation, Long> {

    Optional<LineStation> findByLineAndStationAndIsDeletedFalse(
        Line line,
        Station station
    );
}
