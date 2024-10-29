package java15;

import config.HibernateConfig;
import jakarta.persistence.EntityManagerFactory;

import java.sql.SQLOutput;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        EntityManagerFactory emf = HibernateConfig.getManagerFactory();

        if(emf != null) {
            System.out.println("Hibernate config successfully loaded");
            emf.close();
        }else {
            System.out.println("Hibernate config not found");
        }


    }
}
