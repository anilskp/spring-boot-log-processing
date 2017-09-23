package com.askp.springbootlogprocessing;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@RestController
public class ProcessEvent {

    @Autowired
    private FirewalleventService firewalleventService;


    @Autowired
    private FirewalleventRepository firewalleventRepository;
    @RequestMapping("/parse")
    public String process() {

        String data="Anil-Benil-Haanin Shafeeque";
        String[] pdata = data.split("-");
        return pdata[2];
    }

    @RequestMapping("/parsejson")
    public String displayson() throws IOException {

        String jsonString = "{\"id\":\"2411\",\"name\":\"Ravi\",\"dept\":\"IT\"}";
        ObjectMapper mapper = new ObjectMapper();

        JsonNode actualObj = mapper.readValue(jsonString, JsonNode.class);
        // When
        JsonNode jsonNode1 = actualObj.get("name");

        return jsonNode1.textValue();

    }

    @RequestMapping("/events")
    public List<Firewallevent> getFirewallevent(){
        return firewalleventService.getAllEvents();
    }

    @RequestMapping("/events/{id}")
    public Firewallevent getEvent(@PathVariable UUID id){

        return firewalleventService.getEvent(id);
    }



    @RequestMapping(method = RequestMethod.POST,value = "/events")
    public void addEvent(@RequestBody Firewallevent firewallevent) throws IOException {
        firewalleventService.addEvent(firewallevent);
    }


    @RequestMapping(method = RequestMethod.DELETE,value = "/events/{id}")
    public void deleteEvent(@PathVariable UUID id){

        firewalleventService.deleteEevent(id);
    }
}
