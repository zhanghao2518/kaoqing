package demo.service;

import demo.dao.AccidentDao;
import demo.entity.Apply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

@Service
public class DivisionManagerService {


    @Autowired
    private AccidentDao accidentDao;

    public List<Apply> queryAllApply(){
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String time = dateFormat.format(calendar.getTime());//当前时间
        List<Apply> applies = accidentDao.queryAllApply();
        for(Apply apply : applies){
            if(apply.getDate().compareTo(time) >= 0 || apply.getDivmanager() != 2){
                applies.remove(apply);
            }
        }
        return applies;
    }

    public Apply updateApply(String name,String date,int divmanager){
        Apply apply = accidentDao.queryApply(name,date);
        if(apply.getDays() <= 3 && divmanager == 1){
            apply.setDivmanager(1);
            apply.setResult(1);
        }
        else if(apply.getDays() > 3 && divmanager == 1){
            apply.setDivmanager(1);
        }
        else{
            apply.setDivmanager(0);
            apply.setResult(0);
        }
        return accidentDao.insertApply(apply);
    }
}
