
package com.mycompany.connect.hub;

import Backend.Content;
import Backend.ContentFactory;
import Backend.StoringContent;


public class ConnectHub {

    public static void main(String[] args) throws InterruptedException {
        ContentFactory fac=new ContentFactory();
        Content con=fac.createContent("post");
        con.create("i am posting right now");
        StoringContent.store(con);
        Thread.sleep(10000);
        con.create("a new post after 10 sec");
        StoringContent.store(con);

        
        
        
        System.out.println("done correctly!");
        
    }
}
