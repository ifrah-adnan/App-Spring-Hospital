package ma.adnan.Hospial.services;

import ma.adnan.Hospial.entities.Consultation;
import ma.adnan.Hospial.entities.Medecin;
import ma.adnan.Hospial.entities.Patient;
import ma.adnan.Hospial.entities.RendezVous;

/**
 * @author Dell Latitude 5420
 * IFRAH soumia
 **/
public interface IHospitalService {
    Patient savePatient(Patient patient);
    Medecin saveMedecin (Medecin medecin);
        RendezVous saveRDV(RendezVous rendezVous);
Consultation saveConsultation(Consultation consultation);
}
