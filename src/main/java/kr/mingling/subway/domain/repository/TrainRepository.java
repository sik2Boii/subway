package kr.mingling.subway.domain.repository;

import java.util.Optional;
import kr.mingling.subway.domain.model.DayType;
import kr.mingling.subway.domain.model.Line;
import kr.mingling.subway.domain.model.OperationType;
import kr.mingling.subway.domain.model.Train;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainRepository extends JpaRepository<Train, Long> {

    Optional<Train> findByTrainNoAndLineAndDayTypeAndOperationTypeAndIsDeletedFalse(
        String trainNo,
        Line line,
        DayType dayType,
        OperationType operationType
    );
}
