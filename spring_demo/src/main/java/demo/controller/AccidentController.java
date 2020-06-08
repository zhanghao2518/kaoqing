package demo.controller;

import demo.entity.Apply;
import demo.service.AccidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccidentController {

    @Autowired
    private AccidentService accidentService;

    @GetMapping("/accident")
    public Apply addApply(@RequestParam(value = "name") String name, @RequestParam(value = "type") String type,
                          @RequestParam(value = "date") String date, @RequestParam(value = "days") String days) {
        return accidentService.insertApply(name,Integer.parseInt(type),date,Integer.parseInt(days));
    }

    @GetMapping("/accident/query")
    public Apply queryApply(@RequestParam(value = "name") String name , @RequestParam(value = "date") String date) {
        return accidentService.queryApply(name,date);
    }

    @GetMapping("/accident/query/user")
    public List<Apply> queryNameApply(@RequestParam(value = "name") String name){
        return accidentService.queryNameApply(name);
    }

    @GetMapping("/accident/query/alluser")
    public List<Apply> queryAllApply(){
        return accidentService.queryAllApply();
    }
}
