package demo.controller;

import demo.entity.Apply;
import demo.service.DivisionManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DivisionManagerController {

    @Autowired
    private DivisionManagerService divisionManagerService;

    @GetMapping("/divisionManager/query")
    public List<Apply> queryAllApply(){
        return divisionManagerService.queryAllApply();
    }

    @GetMapping("/divisionManager/approval")
    public Apply updateApply(@RequestParam(value = "name") String name,@RequestParam(value = "date") String date,
                             @RequestParam(value = "divmanager") String divmanager){
        return divisionManagerService.updateApply(name,date,Integer.parseInt(divmanager));
    }

}
