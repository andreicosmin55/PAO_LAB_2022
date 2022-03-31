package Repositories;

import Entitati.Angajat.Mecanic;

import java.util.ArrayList;

public class MecanicRepository implements GenericRepository<Mecanic> {

    private ArrayList<Mecanic> mecanici = new ArrayList<Mecanic>();
    @Override
    public void add(Mecanic entity) {
        mecanici.add(entity);
    }

    @Override
    public Mecanic get(int id) {
        return mecanici.get(id);
    }

    @Override
    public void update(Mecanic entity, Mecanic newEntity) {
        for(int i=0;i< mecanici.size();i++)
        {
            if(mecanici.get(i) == entity){
                mecanici.set(i, newEntity);
                return;
            }
        }
    }

    @Override
    public void delete(Mecanic entity) {
        mecanici.remove(entity);
    }

    @Override
    public int getSize() {
        return mecanici.size();
    }
}
