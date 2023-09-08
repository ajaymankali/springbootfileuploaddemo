package cgg.springboot.problemdetails.springbootproblemdetailsdemo.services;

import org.springframework.stereotype.Service;

//service will automatically create the object of the class
@Service
public class VoteService {
    
    public void vote(int age){
        System.out.println("voted.......");
        //database logic.....
    }
}
