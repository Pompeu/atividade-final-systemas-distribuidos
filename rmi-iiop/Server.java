import javax.naming.InitialContext;
import javax.naming.Context;


public class Server {
    public static void main(String[] args) {
        try {
            ServicoImpl helloRef = new ServicoImpl();
            Context initialNamingContext = new InitialContext();
            initialNamingContext.rebind("Service", helloRef );

         } catch (Exception e) {
            System.out.println("Trouble: " + e);
            e.printStackTrace();
         } 
     }
}
