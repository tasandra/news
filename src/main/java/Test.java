import java.util.ArrayList;

public class Test {

    public static void main(String[] args) {

        ArrayList<Integer> test = new ArrayList<>();
        test.add(1);
        test.add(0);
        test.add(0);
        test.add(1);
        test.add(0);

        String winner = whoWin(test);
        System.out.print(winner);
    }

    public static String whoWin(ArrayList<Integer> array) {
        int count = 0;
        String name = "";
        int arrayHalf = (int) Math.floor(array.size() / 2);
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) == 1) {
                count++;
            }
            if (array.size() % 2 == 0 && count == arrayHalf) {
                name = "tie";
            }
            else if (arrayHalf < count) {
                name = "Bob";
            } else {
                name = "Ann";
            }
        }
        return name;
    }

}
