package ma.ocp.Repositories;

import ma.ocp.Entities.OperationalSystem.MiningDivision;
import ma.ocp.Entities.resources.Mine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface MineRepository extends JpaRepository<Mine, Long> {
    public void deleteByMiningDivision(MiningDivision miningDivision);
    public Set<Mine> getMineByMiningDivision(MiningDivision miningDivision);
}
