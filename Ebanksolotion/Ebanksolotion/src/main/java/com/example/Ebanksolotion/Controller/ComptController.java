package com.example.Ebanksolotion.Controller;

import com.example.Ebanksolotion.Entity.Compt;
import com.example.Ebanksolotion.Service.ComptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/compt")
public class ComptController {
  @Autowired
  ComptService comptService;
  @GetMapping("/show")
    public List<Compt> show() {
    return comptService.getComptList();

}
  @PostMapping("/save")
    public void save(@RequestBody Compt compt) {
     comptService.save(compt);
}
  @PostMapping("/add")
    public void add(@RequestBody Compt compt) {
      comptService.addAccount(compt);
  }
    @DeleteMapping("/delete/{id}")
    public void deleteAccount(@PathVariable("id") Integer id) {
      comptService.deleteCompt(id);
    }
    @PutMapping("/update/{id}")
    public void updateAccount( @PathVariable("id") Integer id,@RequestBody Compt compt) {
      comptService.updateCompt(id,compt);
    }
}
