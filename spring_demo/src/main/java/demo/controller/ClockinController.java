package demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import demo.entity.Record;
import demo.service.ClockinService;

import java.util.List;

@RestController
public class ClockinController {

    @Autowired
    private ClockinService clockinService;

    @GetMapping("/clockin")
    public Record addRecord(@RequestParam(value = "name") String name) {
        return clockinService.insertRecord(name);
    }

    @GetMapping("/clockin/query")
    public List<Record> getAllRecords(@RequestParam(value = "name") String name) {
        return clockinService.queryAllRecords(name);
    }

    @GetMapping("/clockin/queryall")
    public List<Record> getRecords() {
        return clockinService.queryRecords();
    }
}
