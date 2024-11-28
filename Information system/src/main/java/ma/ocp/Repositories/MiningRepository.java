package ma.ocp.Repositories;

import ma.ocp.Entities.OperationalSystem.MiningDivision;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MiningRepository extends JpaRepository<MiningDivision,Long> {

}
