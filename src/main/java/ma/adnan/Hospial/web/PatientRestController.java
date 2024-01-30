package ma.adnan.Hospial.web;

import ma.adnan.Hospial.entities.Patient;
import ma.adnan.Hospial.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Dell Latitude 5420
 * IFRAH soumia
 **/
@RestController
public class PatientRestController {
@Autowired
    private PatientRepository patientRepository;
@GetMapping("/patients")
public List<Patient> patientList(){
    return patientRepository.findAll();
}

}
