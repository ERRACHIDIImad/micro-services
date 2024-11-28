package ma.ocp.RestControllers;
import ma.ocp.Dtos.Mininig_DTO;
import ma.ocp.Entities.OperationalSystem.MiningDivision;
import ma.ocp.Entities.resources.Mine;
import ma.ocp.Repositories.MineRepository;
import ma.ocp.services.MiningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController @CrossOrigin("*")
@RequestMapping("/miningDivisions")
public class MiningController {
    @Autowired
    private MiningService miningService;
    @Autowired
    private MineRepository mineRepository;

    @GetMapping("/all")
    public List<MiningDivision> getAllMiningDivisions() {
        return miningService.getAllMines();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MiningDivision> getMiningDivisionById(@PathVariable Long id) {
        Optional<MiningDivision> minigdivision  = this.miningService.getMineDivision(id);
        return minigdivision.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());}

    @GetMapping("/{id}/Mines")
    public Set<Mine> getMiningDivisionMines(@PathVariable Long id) {
        Optional<MiningDivision> minigdivision = this.miningService.getMineDivision(id);
        return mineRepository.getMineByMiningDivision(minigdivision.get());

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteMiningDivisionById(@PathVariable Long id) {
        miningService.removeMineDivision(miningService.getMineDivision(id).get());
        return ResponseEntity.noContent().build();
    }

  @PostMapping("/Save")
    public ResponseEntity<MiningDivision> createMiningDivision(@RequestBody MiningDivision miningDivision) {
        return ResponseEntity.ok(miningService.saveMineDivision(miningDivision));
    }

    @PutMapping(value= "/Update")
    public ResponseEntity UpdateMiningDivision(@RequestBody Mininig_DTO mining_DTO) {
        try{
            miningService.update(mining_DTO);
            return ResponseEntity.ok("Updated Successfully");
        }
        catch(Exception e) {
            return ResponseEntity.ok("Division not found");
        }
    }
}
