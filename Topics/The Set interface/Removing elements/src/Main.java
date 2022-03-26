import java.util.*;

class SetUtils {

    public static Set<Integer> getSetFromString(String str) {
        // write your code here
        String[] input = str.split(" ");
        Set<Integer> numbersSet = new TreeSet<>();
        for(String s : input) {
            int number = Integer.parseInt(s);
            numbersSet.add(number);
        }
        return numbersSet;
    }

    public static void removeAllNumbersGreaterThan10(Set<Integer> sets) {
        // write your code here
        Set<Integer> tempSet = new TreeSet<>();
        for(Integer elem : sets) {
            if(elem > 10 ){
                tempSet.add(elem);
            }
        }

        sets.removeAll(tempSet);

    }

}

/* Do not change code below */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String numbers = scanner.nextLine();
        Set<Integer> set = SetUtils.getSetFromString(numbers);
        SetUtils.removeAllNumbersGreaterThan10(set);
        set.forEach(e -> System.out.print(e + " "));
    }
}