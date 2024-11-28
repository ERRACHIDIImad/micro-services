package ma.ocp.RestControllers;

import ma.ocp.Dtos.IndustrialDivisionDto;
import ma.ocp.Entities.OperationalSystem.IndustrialDivision;
import ma.ocp.Entities.resources.Plant;
import ma.ocp.services.IndustrialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController @CrossOrigin("*")
@RequestMapping("/industrialDivisions")
public class IndustrialController {
    @Autowired
    private IndustrialService industrialService;

    @GetMapping("/all")
    public List<IndustrialDivision> getAllIndustrialDivisions() {
        return industrialService.getAllIndustrialDivisions();
    }
    @GetMapping("/{id}")
    public ResponseEntity<IndustrialDivision> getIndustrialDivision(@PathVariable Long id) {
      Optional<IndustrialDivision> i = industrialService.getIndustrialDivision(id);
      return i.map(ResponseEntity::ok).orElseGet(()-> ResponseEntity.notFound().build());
    }
    @GetMapping("/{id}/plants")
    public Set<Plant> getPlants(@PathVariable Long id) {
        IndustrialDivision industrialDivision = industrialService.getIndustrialDivision(id).get();
        return industrialService.getPlants(industrialDivision);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteIndustrialDivision(@PathVariable Long id) {
        industrialService.removeIndustrialDivision(industrialService.getIndustrialDivision(id).get());
        return ResponseEntity.noContent().build();
    }
    @PostMapping("/Save")
    public ResponseEntity<IndustrialDivision> createIndustrialDivision(@RequestBody IndustrialDivision industrialDivision) {
        return ResponseEntity.ok(industrialService.saveIndustrialDivision(industrialDivision));
    }
    @PutMapping(value= "/Update/{id}")
    public ResponseEntity UpdateIndustrialDivision(@RequestBody IndustrialDivisionDto industrialDivisionDto, @PathVariable Long id) throws Exception {
        try{
            industrialService.update(industrialDivisionDto,id);
            return ResponseEntity.ok("Updated Successfully");
        }
        catch(Exception e) {
            return ResponseEntity.ok("Division not found");
        }
    }
}
