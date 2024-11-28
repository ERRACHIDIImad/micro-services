package ma.ocp.Repositories;

import ma.ocp.Entities.OperationalSystem.IndustrialDivision;
import ma.ocp.Entities.resources.Plant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface PlantRepository extends JpaRepository<Plant, Long> {


    public void deleteByIndustrialDivision(IndustrialDivision industrialDivision);
    public Set<Plant> findByIndustrialDivision(IndustrialDivision industrialDivision);

}
