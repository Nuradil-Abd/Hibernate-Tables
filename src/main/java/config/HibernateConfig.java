package config;

import entity.*;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.HibernateException;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import java.util.Properties;

public class HibernateConfig {

    public static EntityManagerFactory getManagerFactory(){
        try{
            Properties prop = new Properties();
            prop.put(Environment.JAKARTA_JDBC_URL, "jdbc:postgresql://localhost:5432/postgres");
            prop.put(Environment.JAKARTA_JDBC_USER, "postgres");
            prop.put(Environment.JAKARTA_JDBC_PASSWORD, "1234");
            prop.put(Environment.HBM2DDL_AUTO,"update");
            prop.put(Environment.DIALECT,"org.hibernate.dialect.PostgreSQLDialect");
            prop.put(Environment.SHOW_SQL, "true");
            prop.put(Environment.FORMAT_SQL, "true");

            Configuration con = new Configuration();
            con.addProperties(prop);

            con.addAnnotatedClass(User.class);
            con.addAnnotatedClass(Post.class);
            con.addAnnotatedClass(Profile.class);
            con.addAnnotatedClass(Comment.class);
            con.addAnnotatedClass(Tag.class);

            System.out.println("Successfully connected to database");
            return con.buildSessionFactory().unwrap(EntityManagerFactory.class);




        }catch (HibernateException e){
            System.out.println(e.getMessage());
        }
        return null;
    }
}
