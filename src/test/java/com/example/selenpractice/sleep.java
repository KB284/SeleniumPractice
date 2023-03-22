package com.example.selenpractice;

import java.lang.Thread;

public class sleep{
         public static void sleeperAgent(){
             try{
                 Thread.sleep(3000);
             }catch(InterruptedException e){
                 throw new RuntimeException(e);
             }
         }


}
