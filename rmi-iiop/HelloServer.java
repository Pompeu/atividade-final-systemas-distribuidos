import javax.naming.InitialContext;
import javax.naming.Context;


public class HelloServer {
    public static void main(String[] args) {
        try {
            HelloImpl helloRef = new HelloImpl();
            Context initialNamingContext = new InitialContext();
            initialNamingContext.rebind("HelloService", helloRef );

         } catch (Exception e) {
            System.out.println("Trouble: " + e);
            e.printStackTrace();
         } 
     }
}
