package ma.ocp.Repositories;

import ma.ocp.Entities.OperationalSystem.IndustrialDivision;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IndustrialRepositry extends JpaRepository<IndustrialDivision, Long> {

}
