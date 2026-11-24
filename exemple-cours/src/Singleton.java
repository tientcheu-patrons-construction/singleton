public final class Singleton {
    private static Singleton instance = null;
    public int x;
    public int y;
    
    private Singleton() {
       super();
    }
    
    private Singleton(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
    
    public static Singleton getInstance(int x, int y) {
        if (instance == null) {
            instance = new Singleton(x, y);
        }
        return instance;
    }
    
    public void afficher() {
        System.out.println("Singleton instance: x = " + x + ", y = " + y);
    }
    
    public int somme(int x, int y) {
        return x + y;
    }
    
    public float moyenne(int x, int y) {
        return (float) somme(x, y) / 2;
    }
    
    public int produit(int x, int y) {
        return x * y;
    }
    
    @Override 
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }
}
