package com.andrux.andrux;


//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class Test {
    //    private static final Logger log = LoggerFactory.getLogger(Test.class);
//    private static final Logger log = LogManager.getLogger(Test.class);
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
//        log.info("INFO :this is from org.slf4j.Logger");
//        log.error("ERROR :this is from org.slf4j.Logger");
        System.out.println("enter name : ");
        String next = sc.next();
        System.out.println("is : "+next);
    }
}
