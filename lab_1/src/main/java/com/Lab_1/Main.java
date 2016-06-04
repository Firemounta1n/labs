import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class Main {
    public static void main(String[] args) {
        Paginator paginator = new Paginator();

        try {
            String html = paginator.html(9, 20, 7);
            String fileName = "index.html";

            File file = new File(fileName);
            if (!file.exists()) {
                file.createNewFile();
            }

            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            writer.write(html);
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
