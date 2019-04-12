package org.academiadecodigo.asciimos;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class App {

    public static void main(String[] args) {

        /*JpaBootstrap jpa = new JpaBootstrap();
        EntityManagerFactory emf = jpa.start();

        JpaSessionManager sm = new JpaSessionManager(emf);
        TransactionManager tx = new JpaTransactionManager(sm);*/



        //ApplicationContext context = new FileSystemXmlApplicationContext("/src/main/resources/spring-config/spring-config.xml");

    }
/*
    private void bootStrap(TransactionManager tx, JpaSessionManager sm) {

        AccountServiceImpl accountService = new AccountServiceImpl();
        accountService.setAccountDao(new JpaAccountDao(sm));
        accountService.setTransactionManager(tx);

        CustomerServiceImpl customerService = new CustomerServiceImpl();
        customerService.setCustomerDao(new JpaCustomerDao(sm));
        customerService.setTransactionManager(tx);

        Bootstrap bootstrap = new Bootstrap();

        bootstrap.setAuthService(new AuthServiceImpl());
        bootstrap.setAccountService(accountService);
        bootstrap.setCustomerService(customerService);

        Controller controller = bootstrap.wireObjects();

        // start application
        controller.init();
    }*/
}
