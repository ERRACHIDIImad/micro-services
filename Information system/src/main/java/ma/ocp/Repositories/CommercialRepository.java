package ma.ocp.Repositories;

import ma.ocp.Entities.OperationalSystem.CommercialDivision;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommercialRepository extends JpaRepository<CommercialDivision,Long > {
}
