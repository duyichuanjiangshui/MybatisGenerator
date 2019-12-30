package entity;

import java.util.Date;

public class Staff {
    private Integer id;

    private String name;

    private Integer gender;

    private Date birthday;

    private String phone;

    private String address;

    private Date entrytime;

    private Integer state;

    private Integer settlementtype;

    private Integer salary;

    private String position;

    private Integer stafftype;

    private String description;

    private Integer depid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Date getEntrytime() {
        return entrytime;
    }

    public void setEntrytime(Date entrytime) {
        this.entrytime = entrytime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getSettlementtype() {
        return settlementtype;
    }

    public void setSettlementtype(Integer settlementtype) {
        this.settlementtype = settlementtype;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position == null ? null : position.trim();
    }

    public Integer getStafftype() {
        return stafftype;
    }

    public void setStafftype(Integer stafftype) {
        this.stafftype = stafftype;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Integer getDepid() {
        return depid;
    }

    public void setDepid(Integer depid) {
        this.depid = depid;
    }
}