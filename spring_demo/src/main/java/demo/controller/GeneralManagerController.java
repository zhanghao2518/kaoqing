package demo.controller;

import demo.entity.Apply;
import demo.service.GeneralManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GeneralManagerController {

    @Autowired
    private GeneralManagerService generalManagerService;

    @GetMapping("/generalManager/query")
    public List<Apply> queryAllApply(){return generalManagerService.queryAllApply();}

    @GetMapping("/generalManager/approval")
    public Apply updateApply(@RequestParam(value = "name") String name,@RequestParam(value = "date") String date,
                             @RequestParam(value = "genmanager") String genmanager){
        return generalManagerService.updateApply(name,date,Integer.parseInt(genmanager));
    }

}
