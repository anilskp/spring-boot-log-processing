package com.askp.springbootlogprocessing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;


@Service
public class FirewalleventService {

    @Autowired
    private FirewalleventRepository firewalleventRepository;



    public List<Firewallevent> getAllEvents(){
        List<Firewallevent> firewallevents = new ArrayList<>();
        firewalleventRepository.findAll().forEach(firewallevents::add);
        return firewallevents;

    }

    public Firewallevent getEvent(UUID id){

        return firewalleventRepository.findOne(id);

    }


    public void addEvent(Firewallevent firewallevent) {
        firewalleventRepository.save(firewallevent);

    }

    public void updateEvent( Firewallevent firewallevent){
       // employeeRepository.save(employeeRepository.findOne(id));
        firewalleventRepository.save(firewallevent);
    }

    public void deleteEevent(UUID id){
        firewalleventRepository.delete(id);

    }
}
