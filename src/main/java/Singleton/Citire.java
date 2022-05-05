package Singleton;

import Entitati.Angajat.Angajat;
import Entitati.Angajat.Job;
import Entitati.Preturi.Preturi;
import Entitati.Service.Piesa;
import Entitati.Service.Service;
import Repositories.*;
import Services.AngajatService;
import Services.ServiceService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import static java.lang.Boolean.parseBoolean;
import static java.lang.Double.parseDouble;
import static java.lang.Short.parseShort;

public class Citire {
    private static Citire instance = null;

    public Citire(){}

    public static Citire getInstance()
    {
        if (instance == null)
            instance = new Citire();
        return instance;
    }

    private AngajatRepository angajatRepository = new AngajatRepository();
    private PiesaRepository piesaRepository = new PiesaRepository();
    private JobRepository jobRepository = new JobRepository();
    private ServiceRepository serviceRepository = new ServiceRepository();
    private PreturiRepository preturiRepository = new PreturiRepository();
    BufferedReader reader;

    public void citesteAngajati(String filename) throws IOException {
        reader = new BufferedReader(new FileReader(filename));

        String line;
        while((line = reader.readLine()) != null){
            var splitLine = line.split(",");
            Job job = new Job(splitLine[5], Double.parseDouble(splitLine[6]), Double.parseDouble(splitLine[7]), Short.parseShort(splitLine[8]), Boolean.parseBoolean(splitLine[9]));
            Angajat angajat = new Angajat(splitLine[0], splitLine[1], parseDouble(splitLine[2]), splitLine[3], parseBoolean(splitLine[4]), job);
            angajatRepository.add(angajat);
        }
        reader.close();
    }

    public void citesteService(String filename) throws IOException {
        reader = new BufferedReader(new FileReader(filename));

        String line;
        while((line = reader.readLine()) != null){
            var splitLine = line.split(",");
            Job job = new Job(splitLine[17], Double.parseDouble(splitLine[18]), Double.parseDouble(splitLine[19]), Short.parseShort(splitLine[20]), Boolean.parseBoolean(splitLine[21]));
            Angajat angajat = new Angajat(splitLine[12], splitLine[13], parseDouble(splitLine[14]), splitLine[15], parseBoolean(splitLine[16]), job);
            Job job1 = new Job(splitLine[7], Double.parseDouble(splitLine[8]), Double.parseDouble(splitLine[9]), Short.parseShort(splitLine[10]), Boolean.parseBoolean(splitLine[11]));
            Angajat angajat1 = new Angajat(splitLine[2], splitLine[3], parseDouble(splitLine[4]), splitLine[5], parseBoolean(splitLine[6]), job1);
            ArrayList<Angajat> angajati = new ArrayList<Angajat>();
            angajati.add(angajat);
            angajati.add(angajat1);
            Service service = new Service(splitLine[0], splitLine[1], angajati);

            serviceRepository.add(service);
        }
        reader.close();
    }

    public void citestePreturi(String filename) throws IOException {
        reader = new BufferedReader(new FileReader(filename));

        String line;
        while((line = reader.readLine()) != null){
            var splitLine = line.split(",");
            Preturi pret = new Preturi(Boolean.parseBoolean(splitLine[0]), Double.parseDouble(splitLine[1]), Double.parseDouble(splitLine[2]));
            preturiRepository.add(pret);
        }
        reader.close();
    }

    public void citestePiese(String filename) throws IOException {
        reader = new BufferedReader(new FileReader(filename));

        String line;
        while((line = reader.readLine()) != null){
            var splitLine = line.split(",");
            Preturi pret = new Preturi(Boolean.parseBoolean(splitLine[5]), Double.parseDouble(splitLine[6]), Double.parseDouble(splitLine[7]));
            String masini[] = new String[1];
            masini[0] = splitLine[3];
            Piesa piesa = new Piesa(Long.parseLong(splitLine[0]), Boolean.parseBoolean(splitLine[1]), splitLine[2], masini, splitLine[4], pret);
            piesaRepository.add(piesa);
        }
        reader.close();
    }

}
