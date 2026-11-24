public class App {
    public static void main(String[] args) throws Exception {
        Singleton s1 = Singleton.getInstance();
        int somme = s1.somme(5, 10);
        System.out.println("La somme de 5 et 10 est : " + somme);
        
        Singleton s2 = Singleton.getInstance(3, 7);
        s2.afficher();
        
        Singleton s3 = Singleton.getInstance(16, 4);
        s3.afficher();
    }
}