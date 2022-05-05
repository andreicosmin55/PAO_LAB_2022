package Repositories;

import Entitati.Service.Service;

import java.util.ArrayList;

public class ServiceRepository implements GenericRepository<Service>{
    static private ArrayList<Service> serviceuri = new ArrayList<Service>();

    @Override
    public void add(Service entity) {
        serviceuri.add(entity);
    }

    @Override
    public Service get(int id) {
        return serviceuri.get(id);
    }

    @Override
    public void update(Service entity, Service newEntity) {
        for(int i=0; i<serviceuri.size();i++){
            if(serviceuri.get(i) == entity){
                serviceuri.set(i, newEntity);
                return;
            }
        }
    }

    @Override
    public void delete(Service entity) {
        serviceuri.remove(entity);
    }

    @Override
    public int getSize() {
        return serviceuri.size();
    }
}
