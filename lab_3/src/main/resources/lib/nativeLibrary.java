import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class nativeLibrary {
    public static int getDll(ArrayList<Integer> array, int size){

        Map map = new HashMap(); // Объявляем мапу

        int l = 0;

		/*Заполняем мапу уникальными элементами из заданного массива*/
        for (int i = 0; i < size; i++) {
            if(!map.containsKey(array.get(i))) { //	Если ключ элемента мапы пустой помещаем в него элемента массива и изменяем значение на false
                map.put(array.get(i), false);
            }
        }

		/*Проверяем каждый элемент массива, до тех пор пока не встретим все элементы записанные в мапу*/
        for (int i = 0; i < size; i++){
            if(map.containsKey(array.get(i))) {// Если ключ элемента мапы не пустой, меняем значение на true
                map.put(array.get(i), true);
            }

			/*Узнаем конечный элемент массива, после которого остальные элементы будут повторяться*/
            if(!map.values().contains(false)) { // Если вся мапа со значениями true получаем индекс последнего элемента
                l = i+1;
                break;
            }
        }

        return l;
    }

}
