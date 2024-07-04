package com.example.Ebanksolotion.Service;

import com.example.Ebanksolotion.Entity.Compt;
import com.example.Ebanksolotion.Repository.ComptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComptService {
   @Autowired
    ComptRepository comptRepository;
   public void save(Compt compt) {
       comptRepository.save(compt);
   }
      public void addAccount(Compt compt){
    comptRepository.save(compt);
    }
      public List<Compt> getComptList(){
          return comptRepository.findAll();
     }
     public Optional<Compt> getComptById(Integer id){
          return comptRepository.findById(id);
     }
     public void deleteCompt(Integer id){
          comptRepository.deleteById(id);
     }
     public void updateCompt(Integer id,Compt compt){

          comptRepository.save(compt);
     }
   }
