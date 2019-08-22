package by.pvt.helper;

import by.pvt.pojo.Company;
import by.pvt.pojo.StakeHolder;

import java.util.ArrayList;

public class StakeHolderHelper {

    public static void addCompany(StakeHolder stakeHolder,Company company){
        if(stakeHolder==null||company==null)
            throw new IllegalArgumentException("cannot be null");

        if(stakeHolder.getCompanies()==null)
            stakeHolder.setCompanies(new ArrayList<>());
        stakeHolder.getCompanies().add(company);

        if(company.getStakeHolders() == null)
            company.setStakeHolders(new ArrayList<>());
        company.getStakeHolders().add(stakeHolder);
    }

    public static void removeCompany(StakeHolder stakeHolder,Company company){

        if(stakeHolder==null||company==null)
            throw new IllegalArgumentException("cannot be null");

        stakeHolder.getCompanies().remove(company);
        company.getStakeHolders().remove(stakeHolder);
    }

}
