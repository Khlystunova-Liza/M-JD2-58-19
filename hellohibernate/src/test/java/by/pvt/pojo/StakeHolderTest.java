package by.pvt.pojo;

import by.pvt.helper.StakeHolderHelper;
import by.pvt.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class StakeHolderTest {

    StakeHolder stakeHolder1;
    StakeHolder stakeHolder2;

    public StakeHolder createStakeHolder(int index){
        StakeHolder stakeHolder = new StakeHolder();
        stakeHolder.setName("name"+index);
        stakeHolder.setSurname("surname"+index);
        return stakeHolder;
    }

    @Before
    public void creteAndSaveStakeHolderAndCompanies(){
        Transaction tx = null;

        try(Session session = HibernateUtil.getInstance().getSession()){
            tx = session.beginTransaction();

            Company company1 = CompanyTest.createCompany(6);
            Company company2 = CompanyTest.createCompany(7);

            stakeHolder1 = createStakeHolder(1);
            stakeHolder2 = createStakeHolder(2);

            StakeHolderHelper.addCompany(stakeHolder1,company1);
            StakeHolderHelper.addCompany(stakeHolder1,company2);
            StakeHolderHelper.addCompany(stakeHolder2,company2);

            session.save(company1);
            session.save(company2);

            session.save(stakeHolder1);
            session.save(stakeHolder2);
            tx.commit();

        }catch (Exception e){
            if(tx!=null)tx.rollback();
            throw  e;
        }
    }

    @Test
    public void saveStakeHolder(){

        Transaction tx = null;
        try(Session session = HibernateUtil.getInstance().getSession()){
            tx = session.beginTransaction();

            List<StakeHolder> from_stakeHolder = session.createQuery("from stakeHolder").list();
            assertEquals(2,from_stakeHolder.size());
            tx.commit();

        }catch (Exception e){
            if(tx!=null)tx.rollback();
            throw  e;
        }
    }
}