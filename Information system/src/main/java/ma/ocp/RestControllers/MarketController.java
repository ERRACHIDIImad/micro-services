package ma.ocp.RestControllers;

import ma.ocp.Dtos.MarketDTO;
import ma.ocp.Entities.OperationalSystem.Market;
import ma.ocp.Repositories.CommercialRepository;
import ma.ocp.services.MarketServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.CannotCreateTransactionException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;


@RestController
@CrossOrigin("*")
@RequestMapping("/Markets")
public class MarketController {

    @Autowired
    MarketServices marketServices;
    @Autowired
    private CommercialRepository commercialRepository;

    @GetMapping("/all")
    public List<Market> getMarkets() {
        return marketServices.getAllMarkets();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteMarket(@PathVariable Long id) {
        try
        {
            this.marketServices.deleteMarket(this.marketServices.getMarket(id).get());
            return ResponseEntity.ok("Element has been deleted successfully");
        }
        catch (NoSuchElementException e1)
        {
           return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("There is no such element");
        }
        catch (CannotCreateTransactionException e2)
        {
            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error has occured in the server");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity getMarket(@PathVariable Long id) {
        Optional<Market> market = marketServices.getMarket(id);
        return market.map(ResponseEntity::ok).orElseGet(() -> {
           return  ResponseEntity.notFound().build();
        });
    }

    @PostMapping("/Save")
    public ResponseEntity<Market> saveMarket(@RequestBody MarketDTO marketdto){
       return ResponseEntity.ok(this.marketServices.saveMarket(Market.builder()
                .name(marketdto.getName())
                .location(marketdto.getLocation())
                .targetCustomers(marketdto.getTargetCustomers())
                .commercialDivision(commercialRepository.findById(marketdto.getCommercial_division_id()).get())
                .build()));
    }

    @PutMapping(value= "/Update/{id}")
    public ResponseEntity UpdateMarket(@RequestBody MarketDTO marketDTO, @PathVariable Long id) throws Exception {
        try{
            marketServices.update(marketDTO,id);
            return ResponseEntity.ok("Updated Successfully");
        }
        catch(Exception e) {
            return ResponseEntity.ok("Division not found");
        }
    }

    }

