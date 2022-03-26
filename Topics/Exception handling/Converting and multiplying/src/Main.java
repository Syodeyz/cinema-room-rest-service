import java.util.Scanner;

class Main {

    public static void multiplyByTen() {
        final Scanner scanner = new Scanner(System.in);
        String currentString  = scanner.next();
        while(!currentString.equals("0")){
            try {
               int currentNumber = Integer.parseInt(currentString);
               if(currentNumber != 0) {
                   System.out.println(currentNumber * 10);
               }
            } catch (NumberFormatException e) {
                System.out.println("Invalid user input: " + currentString);
            }
            currentString = scanner.next();
        }
    }

    public static void main(String[] args) {
        // put your code here

        multiplyByTen();
    }
}