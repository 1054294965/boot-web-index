package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Utils {
    private static Logger logger = LoggerFactory.getLogger(Utils.class);
    public static boolean used=false;
    public synchronized static void work(){
        if(!used){
            try {
                logger.info("work start");
                used=true;
                Thread.sleep(3000);
                System.out.println(0/0);
//                used=false;
                logger.info("work end");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }catch (Exception e){
                e.printStackTrace();
            }
        }else{
            logger.info("资源正在使用中");
        }

    }


    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 3; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    work();
                }
            });
        }
    }
}
