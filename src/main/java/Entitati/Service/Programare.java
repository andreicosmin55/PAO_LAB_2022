package Entitati.Service;

import java.util.Date;

public class Programare {
    private Date data_prog;
    private Service service;
    private String marca_masinii_programata;

    public Programare() {
        this.data_prog = null;
        this.service = null;
        this.marca_masinii_programata = "";
    }

    public Programare(Date data_prog, Service service, String marca_masinii_programata) {
        this.data_prog = data_prog;
        this.service = service;
        this.marca_masinii_programata = marca_masinii_programata;
    }

    public Date getData_prog() {
        return data_prog;
    }

    public Service getService() {
        return service;
    }

    public String getMarca_masinii_programata() {
        return marca_masinii_programata;
    }

    public void setData_prog(Date data_prog) {
        this.data_prog = data_prog;
    }

    public void setMarca_masinii_programata(String marca_masinii_programata) {
        this.marca_masinii_programata = marca_masinii_programata;
    }

    public void setService(Service service) {
        this.service = service;
    }
}
