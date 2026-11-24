import java.util.ArrayList;
import java.util.List;


public final class Journal {
    private static Journal instance = null;

    private final List<String> messages = new ArrayList<>();
    private int compteur = 0;

    private Journal() {
        System.out.println("[JOURNAL] creation de l'unique journal");
    }

    public static Journal getInstance() {
        if (instance == null) {
            instance = new Journal();
        }
        return instance;
    }

    public void info(String source, String message) {
        ecrire("INFO", source, message);
    }

    public void erreur(String source, String message) {
        ecrire("ERREUR", source, message);
    }

    private void ecrire(String niveau, String source, String message) {
        compteur++;
        String ligne = String.format("%03d [%s] %s : %s", compteur, niveau, source, message);
        messages.add(ligne);
        System.out.println(ligne);
    }

    public void afficherHistorique() {
        System.out.println("----- Historique du journal (" + messages.size() + " messages) -----");
        for (String ligne : messages) {
            System.out.println(ligne);
        }
    }

    public int getNombreMessages() {
        return messages.size();
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }
}
