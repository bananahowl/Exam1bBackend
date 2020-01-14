package facades;

import entities.MenuPlan;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * Rename Class to a relevant name Add add relevant facade methods
 */
public class RecipeFacade {
    private String urlRecipe = "http://46.101.217.16:4000";
    private static RecipeFacade instance;
    private static EntityManagerFactory emf;
    
    //Private Constructor to ensure Singleton
    private RecipeFacade() {}
    
    
    /**
     * 
     * @param _emf
     * @return an instance of this facade class.
     */
    public static RecipeFacade getFacadeExample(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new RecipeFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    

        public String call() throws Exception {
            URL url = new URL(urlRecipe);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Accept", "application/json;charset=UTF-8");
            con.setRequestProperty("User-Agent", "server"); //remember if you are using SWAPI
            Scanner scan = new Scanner(con.getInputStream());
            String jsonStr = null;
            if (scan.hasNext()) {
                jsonStr = scan.nextLine();
                //jsonStr += "\n";
            }
            scan.close();
            return jsonStr;
        }

}
