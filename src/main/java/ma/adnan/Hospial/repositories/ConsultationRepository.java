package ma.adnan.Hospial.repositories;

import ma.adnan.Hospial.entities.Consultation;
import ma.adnan.Hospial.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Dell Latitude 5420
 * IFRAH soumia
 **/
public interface ConsultationRepository extends JpaRepository<Consultation,Long> {
}
