package Services;

import Entitati.Angajat.Angajat;
import Entitati.Service.Service;
import Exceptii.InvalidDataException;
import Repositories.ServiceRepository;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

public class ServiceService {
    private ServiceRepository serviceRepository = new ServiceRepository();

    public void adaugaService(String nume, String an_infiintare, ArrayList<Angajat> angajati) {

        Service service = new Service(nume, an_infiintare, angajati);
        serviceRepository.add(service);
    }

    public Service[] AfiseazaToateServiceurile() {
        List<Service> result = new ArrayList<Service>();
        for(int i=0; i < serviceRepository.getSize();i++){
            result.add(serviceRepository.get(i));
        }
        return result.toArray(new Service[0]);
    }

    public Service[] AfiseazaServiceurileInfiintateInAnul(String an) {
        List<Service> result = new ArrayList<Service>();
        for(int i=0; i < serviceRepository.getSize();i++){
            if(serviceRepository.get(i).getAn_infiintare().equals(an)) {
                result.add(serviceRepository.get(i));
            }
        }
        return result.toArray(new Service[0]);
    }
}
