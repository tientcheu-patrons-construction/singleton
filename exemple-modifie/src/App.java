public class App {
    public static void main(String[] args) throws Exception {
        Journal j1 = Journal.getInstance();
        j1.info("Inscription", "inscription de Alice");
        j1.info("Paiement", "Alice a paye 50000 FCFA");

        Journal j2 = Journal.getInstance();
        j2.erreur("Inscription", "dossier incomplet pour Bob");
        j2.info("Paiement", "Carine a paye 25000 FCFA");

        System.out.println("j1 == j2 : " + (j1 == j2));
        System.out.println("nombre de messages : " + j1.getNombreMessages());
        j1.afficherHistorique();
    }
}
