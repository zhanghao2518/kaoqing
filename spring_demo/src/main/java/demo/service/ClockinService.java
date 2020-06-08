package demo.service;

import demo.dao.ClockinDao;
import demo.entity.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

@Service
public class ClockinService {

    @Autowired
    private ClockinDao clockinDao;

    public Record insertRecord(String name) {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String time = dateFormat.format(calendar.getTime());//记录打卡时间
        int abnormal = 1;
        if(calendar.get(Calendar.HOUR_OF_DAY) >= 9){
            abnormal = 0;
        }//判断是否超时
        Record record = new Record();
        record.setName(name);
        record.setTime(time);
        record.setAbnormal(abnormal);
        return clockinDao.insertRecord(record);
    }

    public List<Record> queryAllRecords(String name) {
        return clockinDao.queryAllRecords(name);
    }

    public List<Record> queryRecords() {
        return clockinDao.queryRecords();
    }
}
