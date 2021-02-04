package Pjt210204_02;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {
  public static void main(String[] args) {
    GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationContext.xml");
    
    TransportationWalk transportationWalk = ctx.getBean("trWalk", TransportationWalk.class);
    transportationWalk.move();
    
    ctx.close();
  }
}
