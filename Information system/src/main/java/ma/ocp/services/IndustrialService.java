package ma.ocp.services;


import ma.ocp.Dtos.IndustrialDivisionDto;
import ma.ocp.Entities.Human_resourses.Department;
import ma.ocp.Entities.Human_resourses.Employee;
import ma.ocp.Entities.OperationalSystem.CommercialDivision;
import ma.ocp.Entities.OperationalSystem.IndustrialDivision;
import ma.ocp.Entities.OperationalSystem.Market;
import ma.ocp.Entities.resources.Plant;
import ma.ocp.Repositories.IndustrialRepositry;
import ma.ocp.Repositories.PlantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Component
@Transactional
public class IndustrialService {
    @Autowired
    private IndustrialRepositry industrialRepository;


    @Autowired
    private  PlantRepository plantRepository;

    public List<IndustrialDivision> getAllIndustrialDivisions() {
        return industrialRepository.findAll();
    }


    public Optional<IndustrialDivision> getIndustrialDivision(Long Id) {
        return industrialRepository.findById(Id);
    }

    public Set<Plant> getPlants(IndustrialDivision industrialDivision){
        return plantRepository.findByIndustrialDivision(industrialDivision);
    }

    public void removeIndustrialDivision(IndustrialDivision industrialdivision) {
        plantRepository.deleteByIndustrialDivision(industrialdivision);
        industrialRepository.delete(industrialdivision);
    }


    public IndustrialDivision saveIndustrialDivision(IndustrialDivision industrialDivision) {
        return industrialRepository.save(industrialDivision);
    }


    public IndustrialDivision update (IndustrialDivisionDto industrialDivisionDto, Long id ) throws Exception {
        if(industrialRepository.existsById(id)){
          return  this.industrialRepository.save(IndustrialDivision.builder()
                    .id(id).name(industrialDivisionDto.getName())
                    .location(industrialDivisionDto.getLocation())
                    .processImprovements(industrialDivisionDto.getProcessImprovements())
                    .qualityControl(industrialDivisionDto.getQualityControl()).build());
        }
        else throw new Exception("User does not exist");
    }

}

