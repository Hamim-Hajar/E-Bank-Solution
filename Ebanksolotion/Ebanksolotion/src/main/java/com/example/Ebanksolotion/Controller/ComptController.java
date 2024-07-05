package com.example.Ebanksolotion.Controller;

import com.example.Ebanksolotion.Entity.Compt;
import com.example.Ebanksolotion.Service.ComptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/account/api")
public class ComptController {
  @Autowired
  ComptService comptService;

  @GetMapping("/show")
    public List<Compt> show() {
    return comptService.getComptList();

}
  @PostMapping("/save")
    public Compt saveAccount (@RequestBody Compt compt) {
     return comptService.save(compt);
}

  @PostMapping("/add")
  public Compt add(@RequestBody Compt compt) {
    return comptService.addAccount(compt.getType_compt(), compt.getSolde());
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
