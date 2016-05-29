import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Lab_3 {

    public static void main(String[] args) throws FileNotFoundException {

        Lab_3 obj  = new Lab_3();
        nativeLibrary dll = new nativeLibrary(); // Создаем объект из подключенной библиотеки

        Scanner input = new Scanner(System.in); // Объявляем Scanner
        String vvod = input.next();

        System.out.println("");

        if (vvod.equals("--vvod")) {

            System.out.println("Enter array length: "+ "");
            int size = input.nextInt(); // Читаем с клавиатуры размер массива и записываем в size

            ArrayList<Integer> list = new ArrayList<Integer>(); // Создаём массив int размером в size

            System.out.println("Insert array elements:");

            /* Пройдёмся по всему массиву, заполняя его */
            for (int i = 0; i < size; i++) {
                list.add(input.nextInt()); // Заполняем массив элементами, введёнными с клавиатуры
            }

            int l = dll.getDll(list, list.size());
            System.out.println("L = " + l);

            vvod = input.next();
            if (vvod.equals("--debug")) {
                System.out.println("Array elements:" + list);
                System.out.println("Array size:" + list.size());
            }

        } else {

            if (vvod.equals("--file")) {

                ArrayList<Integer> array = obj.getFile("file/test.txt");
                int l = dll.getDll(array, array.size());
                //System.out.println(obj.getFile("file/test.txt"));
                System.out.println("L = " + l);

                vvod = input.next();
                if (vvod.equals("--debug")) {
                    System.out.println("Array elements:" + array);
                    System.out.println("Array size:" + array.size());
                }
            }
        }
    }

    private ArrayList<Integer> getFile(String fileName) {

        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(fileName).getFile());
        ArrayList<Integer> list = new ArrayList<Integer>();

        try (Scanner scanner = new Scanner(file)) {

            while (scanner.hasNextInt()) {
                    int number = scanner.nextInt();
                    list.add(number);
            }

            scanner.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return list;
    }
}