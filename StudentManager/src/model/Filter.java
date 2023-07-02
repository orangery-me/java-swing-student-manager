package model;

import java.util.ArrayList;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Filter{

    public static Predicate <Contestant> filterByPro (String proNameSearch){
        return a->a.getProvince().getProName().equals(proNameSearch);
    }

    public static Predicate <Contestant> filterByID (String IDSearch){
        return a->a.getConID().indexOf(IDSearch)>=0;
    }

    public static ArrayList <Contestant> listFound (ArrayList <Contestant> initialList, Predicate <Contestant> filter){
        return initialList.stream().filter(filter).collect(Collectors.toCollection(ArrayList::new));
    }
}