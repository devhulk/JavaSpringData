package com.example.Config;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;

import static org.junit.Assert.*;

/**
 * Created by mad1 on 4/12/17.
 */
public class AppConfigTest {
/*    @Autowired
    DataSource ds;*/
    @Test
    public void dataSource() throws Exception {

       /* if (ds != null) {
            System.out.println("Test Passed");
        } else {
            throw new Exception("TEST FAILEDDDDDDDDDDDDDD");
        }
*/

    }

    @Test
    public void entityManagerFactoryBean() throws Exception {
    }

    @Test
    public void transactionManager() throws Exception {
    }

}