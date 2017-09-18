package com.askp.springbootlogprocessing;

import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FirewalleventRepository extends CrudRepository<Firewallevent,String> {



}
