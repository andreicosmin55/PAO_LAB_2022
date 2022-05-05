package Repositories;

import Entitati.Angajat.Job;

import java.util.Arrays;

public class JobRepository implements GenericRepository<Job>{

    static private Job[] jobs= new Job[10];
    @Override
    public void add(Job entity) {
        for(int i=0;i<jobs.length;i++)
            if(jobs[i] == null){
                jobs[i] = entity;
                return;
            }
        Job[] newJobs = Arrays.<Job, Job>copyOf(jobs, 1+jobs.length, Job[].class);
        newJobs[jobs.length] = entity;
        jobs = newJobs;
    }

    @Override
    public Job get(int id) {
        return jobs[id];
    }

    @Override
    public void update(Job entity, Job newEntity) {
        for(int i=0;i<jobs.length;i++){
            if(jobs[i] == entity){
                jobs[i] = newEntity;
                return;
            }
        }
    }

    @Override
    public void delete(Job entity) {
        for(int i=0;i<jobs.length;i++) {
            if (jobs[i] == entity) {
                jobs[i] = null;
                return;
            }
        }
    }

    @Override
    public int getSize() {
        return jobs.length;
    }
}
