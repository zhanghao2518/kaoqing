package demo.service;

import demo.dao.AccidentDao;
import demo.entity.Apply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

@Service
public class AccidentService {

    @Autowired
    private AccidentDao accidentDao;

    public Apply insertApply(String name,int type,String date,int days){
        Apply apply = new Apply();
        apply.setName(name);
        apply.setType(type);
        apply.setDate(date);
        apply.setDays(days);
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String time = dateFormat.format(calendar.getTime());//记录提交申请的时间
        apply.setTime(time);
        apply.setDivmanager(2);
        apply.setDepmanager(2);
        apply.setGenmanager(2);
        apply.setResult(2);
        return accidentDao.insertApply(apply);
    }

    public Apply queryApply(String name,String date){
        Apply apply = accidentDao.queryApply(name,date);
        return apply;
    }

    public List<Apply> queryNameApply(String name){
        return accidentDao.queryNameApply(name);
    }

    public List<Apply> queryAllApply(){
        return accidentDao.queryAllApply();
    }
}
