package ma.adnan.Hospial.services;

import jakarta.transaction.Transactional;
import ma.adnan.Hospial.entities.Consultation;
import ma.adnan.Hospial.entities.Medecin;
import ma.adnan.Hospial.entities.Patient;
import ma.adnan.Hospial.entities.RendezVous;
import ma.adnan.Hospial.repositories.ConsultationRepository;
import ma.adnan.Hospial.repositories.MedecinRepository;
import ma.adnan.Hospial.repositories.PatientRepository;
import ma.adnan.Hospial.repositories.RendezVousRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author Dell Latitude 5420
 * IFRAH soumia
 **/
@Service
@Transactional
public class HospitalServiceImpl implements IHospitalService{

    private PatientRepository patientRepository;
    private MedecinRepository medecinRepository;



    private RendezVousRepository rendezVousRepository;
    private ConsultationRepository consultationRepository;
    public HospitalServiceImpl(PatientRepository patientRepository, MedecinRepository medecinRepository, RendezVousRepository rendezVousRepository, ConsultationRepository consultationRepository) {
        this.patientRepository = patientRepository;
        this.medecinRepository = medecinRepository;
        this.rendezVousRepository = rendezVousRepository;
        this.consultationRepository = consultationRepository;
    }
    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Medecin saveMedecin(Medecin medecin) {
        return medecinRepository.save(medecin);
    }

    @Override
    public RendezVous saveRDV(RendezVous rendezVous) {
        rendezVous.setId(UUID.randomUUID().toString());
        return rendezVousRepository.save(rendezVous);
    }

    @Override
    public Consultation saveConsultation(Consultation consultation) {
        return consultationRepository.save(consultation);
    }
}
