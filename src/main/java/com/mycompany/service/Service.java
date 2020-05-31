/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.service;


import com.mycompany.mavenproject1.Person;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author don_d
 */
@Path("/Service")
public class Service {
    private static Map<Integer,Person> persons= new HashMap<Integer,Person>();
    
    static{
        for (int i = 0; i < 10; i++) {
            Person perso= new Person();
            int id =i+1;
            perso.setId(id);
            perso.setFullname(id+"uno");
            int ed=new Random().nextInt(40)+1;
            perso.setAge(ed);
            int sala=ed+2000/3;
            perso.setSalario(sala);
            persons.put(i, perso);
        }
    }
    
    
    @GET
    @Path("/getP/{id}")
    @Produces(MediaType.APPLICATION_XML)
    public Person getPersonByXML(@PathParam("siete") int siete){
        return persons.get(siete);
    }
    
    @GET
    @Path("/getPeJ/{uno}")
    @Produces(MediaType.APPLICATION_JSON)
    public Person getPersonByJson(@PathParam("uno") int uno){
        return persons.get(uno);
    }
    
    @GET
    @Path("/getAllPeJ")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Person> getAllPersonByJson(){
        return new ArrayList<Person>(persons.values());
    }
    
    @GET
    @Path("/getSalProm")
    @Produces(MediaType.APPLICATION_XML)
    public int getSalProm(){
       int sal=0;
       Person p= new Person();
        for (int i = 0; i < 10; i++) {
            p=persons.get(i);
            sal=sal+p.getSalario();
        }
       
        return sal/10;
    }
    
    @GET
    @Path("/getSalTotal")
    @Produces(MediaType.APPLICATION_JSON)
    public int getSalTotal(){
       int total=0;
       Person p= new Person();
        for (int i = 0; i < 10; i++) {
            p=persons.get(i);
            total=total+p.getSalario();
        }
        return total;
    }
    
    
}
