
package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SessionDeConnexion {
    private static final String URL = "jdbc:mysql://localhost:3306/e_commerce";
    private static final String UTILISATEUR = "nom";
    private static final String MOT_DE_PASSE = "passe";

    private static Connection connexion;

    public static Connection obtenirConnexion() {
        if (connexion == null) {
            try {
                connexion = DriverManager.getConnection(URL, UTILISATEUR, MOT_DE_PASSE);
                System.out.println("Connexion établie avec succès !");
            } catch (SQLException e) {
                System.out.println("Erreur lors de la connexion à la base de données : " + e.getMessage());
            }
        }
        return connexion;
    }

    public static void fermerConnexion() {
        if (connexion != null) {
            try {
                connexion.close();
                System.out.println("Connexion fermée avec succès !");
            } catch (SQLException e) {
                System.out.println("Erreur lors de la fermeture de la connexion : " + e.getMessage());
            }
        }
    }
}
