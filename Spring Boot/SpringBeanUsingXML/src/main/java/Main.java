import initializingdisposing.A;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {


        ApplicationContext ctx =
                new ClassPathXmlApplicationContext("applicationContext.xml");


        A a =   ctx.getBean("a1",A.class);


        A a2 =   ctx.getBean("a1",A.class);

        System.out.println(a ==a2);










    }

}
