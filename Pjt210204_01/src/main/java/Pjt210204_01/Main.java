package Pjt210204_01;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {
  public static void main(String[] args) {
//    TransportationWalk transportationWalk = new TransportationWalk();
//    transportationWalk.move();
    
    // GenericXmlApplicationContext : 스프링 컨테이너에 접근하기 위한 데이터 타입
    GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationContext.xml");
    
    // getBean([빈의 아이디], [클래스]);
    TransportationWalk transportationWalk = ctx.getBean("tWalk", TransportationWalk.class);
    transportationWalk.move();
  }
}
