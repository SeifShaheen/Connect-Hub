
package com.mycompany.connect.hub;

import Backend.Content;
import Backend.ContentFactory;
import Backend.Post;
import Backend.PostsFactorty;
import Backend.StoringContent;
import Backend.Story;


public class ConnectHub {

    public static void main(String[] args) throws InterruptedException {
        
        PostsFactorty factory= new PostsFactorty();
        Post p=(Post)factory.createContent();
       
        p.create("the first post");
        
        
       /* 
        ContentFactory fac=new ContentFactory();
        Content con=fac.createContent("post");
        con.create("i am posting right now");
        StoringContent.store(con);
        Thread.sleep(10000);
        con.create("a new post after 10 sec");
        StoringContent.store(con);
*/
        System.out.println("done correctly!");
        
    }
}
