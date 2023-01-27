package u5pp;
import java.util.Scanner;

public class InputHelper {

    Scanner myScanner = new Scanner(System.in);
    
    public InputHelper(Scanner scanner){
        this.myScanner = scanner;
    }

    public int[] getChessLocation(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = myScanner.nextLine();
            if (input.length() == 2) {
                int col = input.charAt(0);
                int row = input.charAt(1);
                //Checks if the first char is bewteen a-h or A-H
                if ((col >= 'a' && col <= 'h') || (col >= 'A' && col <= 'H')) {
                    //Checks if the second char is between 1-8
                    if (row >= '1' && row <= '8') {
                        //Creats an array where the first char is the row and the second char is the column 
                        int[] array = new int[2];
                        array[0] = row - '1';
                        //makes the char lowercase 
                        array[1] = Character.toLowerCase(col) - 'a';
                        return array;
                    }
                }
            }
            System.out.println("Bro that don't work, try again");
        }
    }
}
