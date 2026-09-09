import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        HandleGame();
    }
    static void HandleGame()
    {
        int number = Begin();
        ThrowDice(number);
    }
    static int Begin()
    {
        Scanner reader = new Scanner(System.in);
        int number = 0;
        while(number < 3 || number > 10)
        {
            System.out.println("ile kostek chcesz rzucic? (3-10)");
            number = reader.nextInt();
        }
        return number;
    }
    static void ThrowDice(int number){
        Random rand = new Random();
        int punktyFinal = 0;
        ArrayList<Integer> punkty = new ArrayList<Integer>();
        for(int i =1; i<=number; i++)
        {
            int x = rand.nextInt(6)+1;
            System.out.println("Kostka " + i + ": " + x);
            punkty.add(x);
        }
        punkty.sort(null);
        for (int i = 1; i<punkty.toArray().length; i++)
        {
            if(punkty.get(i-1) == punkty.get(i))
            {
                punktyFinal += punkty.get(i);
            }
        }
        System.out.println("punkty: " + punktyFinal);
        Scanner reader = new Scanner(System.in);
        String answer = "a";
        while(true)
        {
            System.out.println("chcesz zagrac jeszcze? t/n");
            answer = reader.next();
            if(answer.equals("t")) HandleGame();
            else if(answer.equals("n")) return;
        }
    }
}