package demo.entity;

public class Apply {

    private String name;
    private int type;//外出为：1；请假为：2
    private String date;
    private int days;
    private String time;
    private int divmanager;//不同意为：0；同意为：1；未审核为：2
    private int depmanager;//不同意为：0；同意为：1；未审核为：2
    private int genmanager;//不同意为：0；同意为：1；未审核为：2
    private int result;//不批准为：0；批准为：1；未审核为：2

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getType() { return type; }
    public void setType(int type) { this.type = type; }

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }

    public int getDays() { return days; }
    public void setDays(int days) { this.days = days; }

    public String getTime() { return time; }
    public void setTime(String time) { this.time = time; }

    public int getDivmanager() { return divmanager; }
    public void setDivmanager(int divmanager) { this.divmanager = divmanager; }

    public int getDepmanager() { return depmanager; }
    public void setDepmanager(int depmanager) { this.depmanager = depmanager; }

    public int getGenmanager() { return genmanager; }
    public void setGenmanager(int genmanager) { this.genmanager = genmanager; }

    public int getResult() { return result; }
    public void setResult(int result) { this.result = result; }
}
