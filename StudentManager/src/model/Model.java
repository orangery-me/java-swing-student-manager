package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Model implements Serializable{
    ArrayList <Contestant> conList;
    String choice;
    static int num;
    String fileName;

    public Model(ArrayList<Contestant> conList) {
        this.conList = conList;
        this.choice="";
        num=0;
        fileName="";
    }

    public void insert(Contestant con){
        this.conList.add(con);
        num++;
    }

    public void delete(Contestant con){
        this.conList.remove(con);
        num--;
    }
    
    public ArrayList<Contestant> getConList() {
        return conList;
    }

    public void setConList(ArrayList<Contestant> conList) {
        this.conList = conList;
        num= conList.size();
    }

    public String getChoice() {
        return choice;
    }

    public void setChoice(String choice) {
        this.choice = choice;
    }
    

    @Override
    public String toString() {
        return "ContestantList [conList=" + conList + "]";
    }

    public int getNum() {
        return num;
    }

    public void setNum(int Num) {
        num = Num;
    }
    
    public Contestant isInContestantList(Contestant contestant){
        for (Contestant c : conList) {
			if (contestant.equals(c))
				return c;
		}
        return null;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

}
