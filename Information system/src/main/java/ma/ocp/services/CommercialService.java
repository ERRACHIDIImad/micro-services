package ma.ocp.services;


import ma.ocp.Dtos.CommercialDivisionDto;
import ma.ocp.Entities.OperationalSystem.CommercialDivision;
import ma.ocp.Entities.OperationalSystem.Market;
import ma.ocp.Repositories.CommercialRepository;
import ma.ocp.Repositories.MarketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service @Transactional
@Component
public class CommercialService {
    @Autowired
    private CommercialRepository CommercialRepository;
    @Autowired
    private MarketRepository marketRepository;

    public List<CommercialDivision> getAllCommercialDivisions() {
        return CommercialRepository.findAll();
    }

    public Optional<CommercialDivision> getCommercialDivision(Long Id) {
        return CommercialRepository.findById(Id);
    }

    public void removeCommercialDivision(CommercialDivision commercialDivision) {
        commercialDivision.setCustomerRelations(null);
        marketRepository.deleteByCommercialDivision_Id(commercialDivision.getId());
        CommercialRepository.delete(commercialDivision);
    }

    public Set<Market> getMarkets(Optional<CommercialDivision> commercialDivision) {
        return marketRepository.findByCommercialDivision_Id(commercialDivision.get().getId());

    }

    public CommercialDivision saveCommercialDivision(CommercialDivision commercialDivision) {
        return CommercialRepository.save(commercialDivision);
    }

    public CommercialDivision update (CommercialDivisionDto commercialDivisionDto,Long id ) throws Exception {
        if(CommercialRepository.existsById(id)){
        return    this.CommercialRepository.save(CommercialDivision.builder()
                    .id(id).name(commercialDivisionDto.getName())
                    .location(commercialDivisionDto.getLocation())
                    .salesStrategy(commercialDivisionDto.getSalesStrategy())
                    .customerRelations(commercialDivisionDto.getCustomerRelations()).build());
        }
        else throw new Exception("User does not exist");
    }
}
