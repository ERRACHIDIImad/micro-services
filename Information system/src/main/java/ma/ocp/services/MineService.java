package ma.ocp.services;
import ma.ocp.Entities.resources.Mine;
import ma.ocp.Repositories.MineRepository;
import ma.ocp.Repositories.MiningRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service @Component @Transactional
public class MineService {
    @Autowired
    private MineRepository mineRepository;

    @Autowired
    private MiningRepository miningRepository;

    public List<Mine> getAllMines() {
        return mineRepository.findAll();
    }

        public Optional<Mine> getMine(Long id) {
        return mineRepository.findById(id);
    }

    public void removeMine(Mine mine) {
        mineRepository.delete(mine);
    }

    public Mine saveMine(Mine mine) {
        return mineRepository.save(mine);
    }



}
