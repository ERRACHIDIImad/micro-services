package ma.ocp.services;

import ma.ocp.Dtos.MarketDTO;
import ma.ocp.Entities.OperationalSystem.Market;
import ma.ocp.Repositories.CommercialRepository;
import ma.ocp.Repositories.MarketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.CannotCreateTransactionException;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Transactional
@Component
public class MarketServices {

    @Autowired
    private MarketRepository marketRepository;

    @Autowired
    private CommercialRepository commercialRepository;

   public List<Market> getAllMarkets(){
        return  marketRepository.findAll();
    }

    public Optional<Market> getMarket(Long id){
        return  marketRepository.findById(id);
    }

    public void deleteMarket(Market market) throws CannotCreateTransactionException, NoSuchElementException {
        this.marketRepository.delete(market);
        ResponseEntity.ok("Element has been deleted");
    }

    public Market saveMarket(Market market){
         return this.marketRepository.save(market);
    }

    public Market update (MarketDTO marketDTO, Long id) throws Exception {
        if(marketRepository.existsById(id)){
           return this.marketRepository.save(Market.builder()
                    .id(id)
                    .name(marketDTO.getName())
                    .location(marketDTO.getLocation())
                    .targetCustomers(marketDTO.getTargetCustomers())
                    .commercialDivision(commercialRepository.findById(marketDTO.getCommercial_division_id()).get())
                    .build());
        }
        else throw new Exception("User does not exist");
    }
}
