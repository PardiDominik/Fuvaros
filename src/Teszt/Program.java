package app;
 
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
 
 
public class Program {
    private static List<Fuvar> fuvarok;
    private static List<String> sorok;
    public static void main(String[] args) throws IOException {
       program();
    }
    private static void program() throws IOException{
      System.out.println(" Összes fuvar értéke: " + Osszfuvarert() );
      System.out.println(" Legdrágább fuvar rendszáma: " + legdragabbFuvar());
      System.out.println(" Legolcsóbb fuvar értéke: " + legolcsobbFuvar() );
     
    };
    static void ini() throws IOException{
        sorok = Files.readAllLines(Path.of("Fuvarok.csv"));
        fuvarok = new ArrayList<>();
        for (String sor : sorok) {
            fuvarok.add(new Fuvar(sor));
        }
    };
    public static int Osszfuvarert() throws IOException {
        ini();
        int osszeg = 0;
        for (Fuvar f : fuvarok) {
            osszeg += f.getOsszeg();
        }
        return osszeg;
    };
    public static String legdragabbFuvar() {
        Fuvar legdragabb = fuvarok.get(0);
        for (Fuvar f : fuvarok) {
            if (f.getOsszeg()> legdragabb.getOsszeg()) {
                legdragabb = f;
            }
        }
        return legdragabb.getRsz();
    };
    public static int legolcsobbFuvar() {
        if (fuvarok.isEmpty()) return 0;
        int min = (int) fuvarok.get(0).getOsszeg();
        for (Fuvar f : fuvarok) {
            if (f.getOsszeg()< min) {
                min = (int) f.getOsszeg();
            }
        }
        return min;
    };
}