package ma.ocp.RestControllers;

import ma.ocp.Dtos.CommercialDivisionDto;
import ma.ocp.Entities.OperationalSystem.CommercialDivision;
import ma.ocp.services.CommercialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController @CrossOrigin("*")
@RequestMapping("/commercialDivisions")
public class CommercialController {
    @Autowired
    private CommercialService commercialService;

    @GetMapping("/commercialDivisions")
    public ResponseEntity getAllCommercialDivisions() {
        List <CommercialDivision> CommercialDivisions = commercialService.getAllCommercialDivisions();
        if(CommercialDivisions.size() == 0)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("There is no Commercial division in database");
        else
            return ResponseEntity.ok(CommercialDivisions);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommercialDivision> getCommercialDivision(@PathVariable Long id) {
        Optional <CommercialDivision> c = commercialService.getCommercialDivision(id) ;
        return c.map(ResponseEntity::ok).orElseGet(()-> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCommercialDivision(@PathVariable Long id) {
       try
       {
           Optional<CommercialDivision> commercialDivision = commercialService.getCommercialDivision(id);
           commercialService.removeCommercialDivision(commercialDivision.get());
           return ResponseEntity.ok("A commercial Division has been deleted");
       }
       catch(Exception e) {
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Does not exist in database!!!!!!");
       }
    }

    @GetMapping("/{id}/markets")
    public ResponseEntity getMarkets(@PathVariable Long id) {
        try
            {
                Optional<CommercialDivision> commercialDivision = commercialService.getCommercialDivision(id);
                return ResponseEntity.ok(commercialService.getMarkets(commercialDivision));
            }

        catch(Exception e)
            {
                return ResponseEntity.ok("Does not exist in database!!!!!!");
            }

    }



    @PostMapping( "/addCommercialDivision")
    public ResponseEntity<CommercialDivision>  createCommercialDivision(@RequestBody CommercialDivisionDto CommercialDivisionDto) {
       return ResponseEntity.ok(commercialService.saveCommercialDivision(CommercialDivision.builder()
               .name(CommercialDivisionDto.getName())
               .id(Long.valueOf(0))
               .location(CommercialDivisionDto.getLocation())
               .customerRelations(CommercialDivisionDto.getCustomerRelations())
               .salesStrategy(CommercialDivisionDto.getSalesStrategy())
               .build()));

    }


    @PutMapping(value= "/Update/{id}")
    public ResponseEntity<CommercialDivision> UpdateCommercialDivision(@RequestBody CommercialDivisionDto commercialDivisionDto, @PathVariable Long id) throws Exception {
        try
        {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(commercialService.update(commercialDivisionDto,id));
        }
        catch(Exception e) {
            return ResponseEntity.noContent().build();
        }
    }




    }
