package ma.ocp.RestControllers;

import ma.ocp.Dtos.Mine_DTO;
import ma.ocp.Entities.resources.Mine;
import ma.ocp.Repositories.MiningRepository;
import ma.ocp.services.MineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController @CrossOrigin("*")
@RequestMapping( "/mines")
public class MineServiceController {
    @Autowired
    private MineService mineService;
    @Autowired
    private MiningRepository miningRepository;

    @GetMapping("/all")
    public List<Mine> getAllMines() {
        return mineService.getAllMines();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mine> getMineById(@PathVariable Long id) {
    Optional<Mine> mine =this.mineService.getMine(id);
    return mine.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());}


    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteMineById(@PathVariable Long id) {
        mineService.removeMine(mineService.getMine(id).get());
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/Save")
    public ResponseEntity<Mine> createMine(@RequestBody Mine_DTO minedto) {
        return ResponseEntity.ok(
                mineService.saveMine(Mine.builder()
                .name(minedto.getName())
                .capacity(minedto.getCapacity())
                .location(minedto.getLocation())
                .miningDivision(miningRepository.findById(minedto.getMining_division_id()).get())
                .build()));
    }



}
