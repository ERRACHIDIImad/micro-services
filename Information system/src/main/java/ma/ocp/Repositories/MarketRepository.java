package ma.ocp.Repositories;

import ma.ocp.Entities.OperationalSystem.Market;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface MarketRepository extends JpaRepository<Market, Long> {
    public void deleteByCommercialDivision_Id(Long id);
    public Set<Market> findByCommercialDivision_Id(Long id);
}
