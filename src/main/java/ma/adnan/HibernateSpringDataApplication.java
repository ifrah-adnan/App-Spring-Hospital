package ma.adnan;

import ma.adnan.Hospial.entities.*;
import ma.adnan.Hospial.repositories.ConsultationRepository;
import ma.adnan.Hospial.repositories.MedecinRepository;
import ma.adnan.Hospial.repositories.PatientRepository;
import ma.adnan.Hospial.repositories.RendezVousRepository;
import ma.adnan.Hospial.services.IHospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.awt.*;
import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class HibernateSpringDataApplication implements CommandLineRunner {
@Autowired
    private IHospitalService hospitalService;
@Autowired
private PatientRepository patientRepository;
        @Autowired
        private  MedecinRepository medecinRepository;
        @Autowired
        private RendezVousRepository rendezVousRepository;

    public static void main(String[] args) {
        SpringApplication.run(HibernateSpringDataApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        Stream.of("mohamed","hassan","najat").forEach(name->{
            Patient patient=new Patient();
            patient.setNom(name);
            patient.setDateNaissance(new Date());
            patient.setMalade(false);

            hospitalService.savePatient(patient);
        });
        Stream.of("adnan","hajar","fatima").forEach(name->{
            Medecin medecin=new Medecin();
            medecin.setNom(name);
            medecin.setSpecialite(Math.random()>0.5?"cardio":"Dentiste");
            medecin.setEmail(name+"@gmail.com");
            hospitalService.saveMedecin(medecin);
        });
        Patient patient1=patientRepository.findByNom("mohamed");
Medecin medecin1=medecinRepository.findByNom("adnan");
        RendezVous rendezVous=new RendezVous();
        rendezVous.setStatusRndv(StatusRndv.PENDING);
        rendezVous.setDate(new Date());
        rendezVous.setPatient(patient1);
        rendezVous.setMedecin(medecin1);
         RendezVous saveRdv=hospitalService.saveRDV(rendezVous);
        System.out.println("test 1: "+saveRdv.getId());
        System.out.println("test 2: "+rendezVous.getId());

        //find rendez vous
        RendezVous rendezVous1=rendezVousRepository.findAll().get(0);
        Consultation consultation=new Consultation();
        consultation.setDateConsultation(new Date());
        consultation.setRendezVous(rendezVous1);
        hospitalService.saveConsultation(consultation);


    }
}
