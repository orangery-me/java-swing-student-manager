package model;

import java.io.Serializable;
import java.time.LocalDate;

public class Contestant implements Serializable{
    private String ConID;
    private String name;
    private Province province;
    private LocalDate DOB;
    private int gender;
    private Double score1;
    private Double score2;
    private Double score3;
    public Contestant(){}
    public Contestant(String conID, String name, Province province, LocalDate dOB, int gender, Double score1, Double score2,
            Double score3) {
        this.ConID = conID;
        this.name = name;
        this.province = province;
        this.DOB = dOB;
        this.gender = gender;
        this.score1 = score1;
        this.score2 = score2;
        this.score3 = score3;
    }
    public String getConID() {
        return ConID;
    }
    public void setConID(String conID) {
        this.ConID = conID;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Province getProvince() {
        return province;
    }
    public void setProvince(Province province) {
        this.province = province;
    }
    public LocalDate getDOB() {
        return DOB;
    }
    public void setDOB(LocalDate dOB) {
        DOB = dOB;
    }
    public int getGender() {
        return gender;
    }
    public void setGender(int gender) {
        this.gender = gender;
    }
    public Double getScore1() {
        return score1;
    }
    public void setScore1(Double score1) {
        this.score1 = score1;
    }
    public Double getScore2() {
        return score2;
    }
    public void setScore2(Double score2) {
        this.score2 = score2;
    }
    public Double getScore3() {
        return score3;
    }
    public void setScore3(Double score3) {
        this.score3 = score3;
    }
    @Override
    public String toString() {
        return "Contestant [ConID=" + ConID + ", name=" + name + ", province=" + province + ", DOB=" + DOB + ", gender="
                + gender + ", score1=" + score1 + ", score2=" + score2 + ", score3=" + score3 + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Contestant other = (Contestant) obj;
        if (ConID == null) {
            if (other.ConID != null)
                return false;
        } else if (!ConID.equals(other.ConID))
            return false;
        return true;
    }
    
    
}
