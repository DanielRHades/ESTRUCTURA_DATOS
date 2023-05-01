import java.io.File;

public class xdd {
    public static void main(String[] args) {
        File dir = new File("productos/");
        String[] files = dir.list();
        for (int i = 0; i < files.length; i++) {
            System.out.println(files[i]);
        }
    }
}
