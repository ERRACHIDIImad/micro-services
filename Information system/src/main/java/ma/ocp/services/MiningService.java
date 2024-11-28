package ma.ocp.services;

import ma.ocp.Dtos.CommercialDivisionDto;
import ma.ocp.Dtos.Mininig_DTO;
import ma.ocp.Entities.OperationalSystem.MiningDivision;
import ma.ocp.Repositories.MineRepository;
import ma.ocp.Repositories.MiningRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MiningService {
    @Autowired
    private MiningRepository miningRepository;
    @Autowired
    private MineRepository  mineRepository;

    public  List<MiningDivision> getAllMines() {
        return miningRepository.findAll();
    }

    public Optional<MiningDivision> getMineDivision(Long id) {
        return miningRepository.findById(id);
    }

    public void removeMineDivision(MiningDivision miningDivision) {
         mineRepository.deleteByMiningDivision(miningDivision);
         miningRepository.delete(miningDivision);
    }


    public MiningDivision saveMineDivision(MiningDivision miningDivision) {
        return miningRepository.save(miningDivision);
    }

    public MiningDivision update(Mininig_DTO mineDTO) throws Exception {
        if(miningRepository.existsById(mineDTO.getId())){
            return this.miningRepository.save(MiningDivision.builder()
                    .id(mineDTO.getId())
                    .name(mineDTO.getName())
                    .location(mineDTO.getLocation())
                    .safetyStandards(mineDTO.getSafetyStandards())
                    .explorationBudget(mineDTO.getExplorationBudget())
                    .environmentalPolicy(mineDTO.getEnvironmentalPolicy())
                    .build());
        }
        else throw new Exception();
    }


}
