package Academic_ERP.bean;

public class Course_Min {
    private String cid;
    private String name;
    private String facultyName;
    private  int slotNo;

    public Course_Min(){

    }

    public Course_Min(String cid, String name, String facultyName, int slotNo){
        this.cid = cid;
        this.name = name;
        this.facultyName = facultyName;
        this.slotNo = slotNo;
    }

    public int getSlotNo() {
        return slotNo;
    }

    public void setSlotNo(int slotNo) {
        this.slotNo = slotNo;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }
}
