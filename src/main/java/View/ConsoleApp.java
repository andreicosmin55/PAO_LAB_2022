package View;

import Entitati.Angajat.Angajat;
import Entitati.Angajat.Job;
import Entitati.Preturi.Preturi;
import Entitati.Service.Piesa;
import Entitati.Service.Service;
import Exceptii.InvalidDataException;
import Repositories.JobRepository;
import Repositories.PiesaRepository;
import Services.AngajatService;
import Services.PiesaService;
import Services.ServiceService;
import Singleton.Citire;
import Singleton.Scriere;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Boolean.parseBoolean;
import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Short.parseShort;

public class ConsoleApp {
    private Scanner s = new Scanner(System.in);
    private AngajatService angajatService = new AngajatService();
    private PiesaService piesaService = new PiesaService();
    private ServiceService serviceService = new ServiceService();
    private JobRepository jobRepository = new JobRepository();
    private PiesaRepository piesaRepository = new PiesaRepository();
    private static Citire singleton = new Citire();
    static Scriere audit;

    static {
        try {
            audit = Scriere.getInstance();
        } catch (IOException exc) {
            exc.printStackTrace();
        }
    }
    public ConsoleApp() throws IOException {
        Citire citire = Citire.getInstance();
        citire.citesteService("C:\\Users\\andre\\IdeaProjects\\Etapa1LabPAOPAO\\src\\main\\resources\\service.csv");
        citire.citesteAngajati("C:\\Users\\andre\\IdeaProjects\\Etapa1LabPAOPAO\\src\\main\\resources\\angajati.csv");
        citire.citestePiese("C:\\Users\\andre\\IdeaProjects\\Etapa1LabPAOPAO\\src\\main\\resources\\piese.csv");
        citire.citestePreturi("C:\\Users\\andre\\IdeaProjects\\Etapa1LabPAOPAO\\src\\main\\resources\\preturi.csv");
    }
    public static void main(String args[]) throws Exception {
        ConsoleApp app = new ConsoleApp();
        audit.ScrieAudit("Deschidere aplicatie");
        while (true) {
            app.showMenu();
            int option = app.readOption();
            app.execute(option);
        }
    }

    private void read() throws IOException {
        singleton.citesteAngajati("C:\\Users\\andre\\IdeaProjects\\Etapa1LabPAOPAO\\src\\main\\resources\\angajati.csv");
        singleton.citesteService("C:\\Users\\andre\\IdeaProjects\\Etapa1LabPAOPAO\\src\\main\\resources\\service.csv");
    }

    private void showMenu() {

        System.out.println("Ce actiune doriti sa faceti?");
        System.out.println("1. Adaugarea unui nou job");
        System.out.println("2. Afisarea tuturor job-urilor");
        System.out.println("3. Adaugarea unui nou service");
        System.out.println("4. Afisarea tuturor service-urilor");
        System.out.println("5. Afisarea service-urilor infiintate in anul ...");
        System.out.println("6. Adaugarea unei noi piese");
        System.out.println("7. Afisarea tuturor pieselor");
        System.out.println("8. Afisarea pieselor de la furnizorul ...");
        System.out.println("9. Adaugarea unui nou angajat");
        System.out.println("10. Afisarea tuturor angajatiilor");
        System.out.println("11. Afisarea angajatilor cu vechime de peste 3 ani");
        System.out.println("12. Calculeaza reducerea pentru piesa cu id-ul ...");
        System.out.println("13. Inchiderea meniului");
    }

    private int readOption() {
        try {
            int option = readInt();
            if (option >= 1 && option <= 13) {
                return option;
            }
        } catch (InvalidDataException invalid) {}
        System.out.println("Invalid option. Try again");
        return readOption();
    }

    private void execute(int option) throws IOException {
        switch (option) {
            case 1:
                adaugaJob();
                break;
            case 2:
                AfiseazaToateJoburile();
                break;
            case 3:
                AdaugaService();
                break;
            case 4:
                AfiseazaToateService_urile();
                break;
            case 5:
                ServiceDinAnul();
                break;
            case 6:
                AdaugaPiesa();
                break;
            case 7:
                AfiseazaToatePiese();
                break;
            case 8:
                PieseCuFurnizor();
                break;
            case 9:
                adaugaAngajat();
                break;
            case 10:
                AfiseazaTotiAngajatii();
                break;
            case 11:
                AngajatCuMaiMultDe3AniExp();
                break;
            case 12:
                CalculeazaReducere();
                break;
            case 13:
                audit.ScrieAudit("Inchidere aplicatie");
                audit.close();
                System.exit(0);
                break;
        }
    }

    private int readInt() throws InvalidDataException {
        String line = s.nextLine();
        if (line.matches("^\\d+$")) {
            return parseInt(line);
        } else {
            throw new InvalidDataException("Invalid number");
        }
    }

    private void PieseCuFurnizor() throws IOException {
        System.out.println("Numele furnizorului este: ");
        String furnizor = "";
        furnizor = s.nextLine();
        System.out.println("Piesele sunt:\n---------------------");
        for (Piesa p : piesaService.AfiseazaPieseleDeLaFurnizorul(furnizor)) {
            System.out.println(p.getNume_piesa());
        }
        audit.ScrieAudit("Afisarea pieselor impreuna cu furnizorii acestora");
    }

    private void ServiceDinAnul() throws IOException {
        System.out.println("Anul cautat este: ");
        String an = "";
        an = s.nextLine();
        System.out.println("Service-urile sunt:\n---------------------");
        for (Service s : serviceService.AfiseazaServiceurileInfiintateInAnul(an)) {
            System.out.println(s.getNume());
        }
        audit.ScrieAudit("Afisarea unui service din anul "+ an);
    }

    private void AngajatCuMaiMultDe3AniExp() throws IOException {
        System.out.println("Angajatii sunt:\n---------------------");
        for (Angajat a : angajatService.afiseazaAngajatiCuVechimePeste3Ani()) {
            System.out.println(a.getNume() + " " + a.getPrenume() + " cu o vechime de " + a.getVechime());
        }
        audit.ScrieAudit("Afisarea angajatilor cu peste 3 ani experienta");
    }

    private void adaugaJob() throws IOException {
        System.out.print("Salariu minim: ");
        String sal_min = s.nextLine();

        System.out.print("Salariu maxim: ");
        String sal_max = s.nextLine();

        System.out.print("Nr maxim de angajati: ");
        String nr_max_ang = s.nextLine();

        System.out.print("Sunt locuri libere pe acest job?: 1-DA  0-NU");
        String locuri_libere = s.nextLine();

        System.out.print("Nume job: ");
        String nume_job = s.nextLine();

        Job job = new Job(nume_job,parseDouble(sal_max), parseDouble(sal_min), parseShort(nr_max_ang), parseBoolean(locuri_libere));
        jobRepository.add(job);
        audit.ScrieAudit("Adaugarea unui nou job");
    }

    private void AdaugaPiesa() throws IOException {
        System.out.print("Nume piesa: ");
        String nume = s.nextLine();

        System.out.print("Nr total piese: ");
        String nr_tot_pie = s.nextLine();

        System.out.print("Furnizor: ");
        String furnizor = s.nextLine();

        System.out.print("Este piesa in stoc?:1-DA  0-NU ");
        String in_stoc = s.nextLine();

        System.out.print("Pretul piesei:");
        String pret_piesa = s.nextLine();

        System.out.print("Pretul manoperei:");
        String pret_manopera = s.nextLine();

        System.out.print("Piesa este comandata pt un client fidel:1--DA  0--NU");
        String client_fidel = s.nextLine();

        System.out.println("Cate masini sunt compatibile cu aceasta piesa?");
        String nr = s.nextLine();

        List<String> masini = new ArrayList<String>();
        for(int i=0;i<parseInt(nr);i++) {
            System.out.print("Introduceti o masina compatibila: ");
            String masina = s.nextLine();
            masini.add(masina);
        }
        String masini_final[] = masini.toArray(new String[0]);
        Preturi pret = new Preturi(parseBoolean(client_fidel), parseDouble(pret_manopera), parseDouble(pret_piesa));

        piesaService.adaugaPiesa(parseInt(nr_tot_pie), parseBoolean(in_stoc), furnizor, masini_final, nume, pret);
        audit.ScrieAudit("Adaugarea unei noi piese");
    }

    private void adaugaAngajat() throws IOException {
        System.out.print("Nume: ");
        String nume = s.nextLine();

        System.out.print("Prenume: ");
        String prenume = s.nextLine();

        System.out.print("Pozitie: ");
        String pozitie = s.nextLine();

        System.out.print("Vechime: ");
        String vechime = s.nextLine();

        System.out.print("Are functie de conducere?:1--DA   0--NU ");
        String fct_conducere = s.nextLine();


        System.out.print("Informatii despre job-ul noului angajat: ");
        System.out.print("Salariu minim: ");
        String sal_min = s.nextLine();

        System.out.print("Salariu maxim: ");
        String sal_max = s.nextLine();

        System.out.print("Nr maxim de angajati: ");
        String nr_max_ang = s.nextLine();

        System.out.print("Sunt locuri libere pe acest job?: 1-DA  0-NU");
        String locuri_libere = s.nextLine();

        System.out.print("Nume job: ");
        String nume_job = s.nextLine();
        Job job = new Job(nume_job, parseDouble(sal_max), parseDouble(sal_min), parseShort(nr_max_ang), parseBoolean(locuri_libere));
        angajatService.adaugaUnAngajat(nume, prenume, parseDouble(vechime), pozitie, parseBoolean(fct_conducere), job);
        audit.ScrieAudit("Adaugarea unui nou angajat");
    }

    private void AdaugaService() throws IOException {

        System.out.print("Nume service: ");
        String nume_service = s.nextLine();

        System.out.print("An infiintare: ");
        String an_infiintare = s.nextLine();

        System.out.print("Cati angajati are acest service?: ");
        String nr_ang = s.nextLine();
        ArrayList<Angajat> angajati_final = new ArrayList<Angajat>();

        for(int i=0;i<parseInt(nr_ang);i++) {

            System.out.print("Nume: ");
            String nume = s.nextLine();

            System.out.print("Prenume: ");
            String prenume = s.nextLine();

            System.out.print("Pozitie: ");
            String pozitie = s.nextLine();

            System.out.print("Vechime: ");
            String vechime = s.nextLine();

            System.out.print("Are functie de conducere?:1--DA   0--NU ");
            String fct_conducere = s.nextLine();


            System.out.print("Informatii despre job-ul noului angajat: ");
            System.out.print("Salariu minim: ");
            String sal_min = s.nextLine();

            System.out.print("Salariu maxim: ");
            String sal_max = s.nextLine();

            System.out.print("Nr maxim de angajati: ");
            String nr_max_ang = s.nextLine();

            System.out.print("Sunt locuri libere pe acest job?: 1-DA  0-NU");
            String locuri_libere = s.nextLine();

            System.out.print("Nume job: ");
            String nume_job = s.nextLine();
            Job job = new Job(nume_job, parseDouble(sal_max), parseDouble(sal_min), parseShort(nr_max_ang), parseBoolean(locuri_libere));
            Angajat angajat = new Angajat(nume, prenume, parseDouble(vechime), pozitie, parseBoolean(fct_conducere), job);
            angajati_final.add(angajat);
        }

        serviceService.adaugaService(nume_service, an_infiintare, angajati_final);
        audit.ScrieAudit("Adaugarea unui nou service");
    }

    private void AfiseazaToatePiese() throws IOException {
        System.out.println("Piesele sunt:\n---------------------");
        for (Piesa p : piesaService.AfiseazaToatePiesele()) {
            System.out.println(p.getNume_piesa());
        }
        audit.ScrieAudit("Afisarea tuturor pieselor");
    }

    private void AfiseazaToateService_urile() throws IOException {
        System.out.println("Service-urile sunt:\n---------------------");
        for (Service s : serviceService.AfiseazaToateServiceurile()) {
            System.out.println(s.getNume());
        }
        audit.ScrieAudit("Afisarea tuturor service-urilor");
    }

    private void AfiseazaTotiAngajatii() throws IOException {
        for (Angajat a : angajatService.afiseazaAngajatii()) {
            System.out.println(a.getNume() + " " + a.getPrenume());
        }
        audit.ScrieAudit("Afisarea tuturor angajatilor");
    }

    private  void AfiseazaToateJoburile() throws IOException {
        for(int i=0;i<jobRepository.getSize();i++)
        {
            if(jobRepository.get(i) != null){
                System.out.println(jobRepository.get(i).getNume_job() + " " + "salariul minim fiind" + jobRepository.get(i).getSalariu_minim());
            }
        }
        audit.ScrieAudit("Afisarea tuturor job-urilor");
    }

    private void CalculeazaReducere() throws IOException {
        System.out.println("Introduceti id-ul piese pentru care doriti sa aflati discount-ul!");
        int id = parseInt(s.nextLine());
        Piesa piesa = piesaRepository.get(id);
        if(piesa == null){
            System.out.println("Id-ul introdus este invalid!");
            return;
        }
        Preturi pret = new Preturi();
        double pret_initial = pret.calculeaza_pret(piesa);
        if (pret.calc_reducere(piesa) != 0){
            double pret_final = pret_initial - pret_initial*pret.calc_reducere(piesa);
            System.out.println("In loc de " + pret_initial + " platiti "+ pret_final + " ceea ce inseamna o reducere de " + pret.calc_reducere(piesa) + "%.");
        }
        else {
            System.out.println("Nu s-a putut obtine o reducere pentru aceasta piesa");
        }
        audit.ScrieAudit("Calculare de reducere");
    }


}
