package demo.controller;

import demo.entity.Apply;
import demo.service.DeputyManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeputyManagerController {

    @Autowired
    private DeputyManagerService deputyManagerService;

    @GetMapping("/deputyManager/query")
    public List<Apply> queryAllApply(){
        return deputyManagerService.queryAllApply();
    }

    @GetMapping("/deputyManager/approval")
    public Apply updateApply(@RequestParam(value = "name") String name,@RequestParam(value = "date") String date,
                             @RequestParam(value = "depmanager") String depmanager){
        return deputyManagerService.updateApply(name,date,Integer.parseInt(depmanager));
    }
}
