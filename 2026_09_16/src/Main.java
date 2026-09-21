import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        //nie wiem nie dziala a 3 zadanie nie ma sensu tymbarzdiej dobranoc smacznej kawusi mam nadzieje ze pan tego nie czyta
        //zad1();
        zad2();
        //zad3();
    }
    public static void zad1()
    {
        File f = new File("src/liczby.txt");
        int counter = 0;
        boolean first = false;

        try (Scanner reader = new Scanner(f)) {
            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                if(data.substring(0, 1).equals(data.substring(data.length() -1)))
                {
                    if(!first)
                    {
                        System.out.println(data);
                        first = true;
                    }
                    counter++;
                }
            }
            System.out.println(counter);
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public static void zad2()
    {
        File f = new File("src/liczby.txt");

        int i = 0;
        int maxDzielniki = 0;
        int maxRozne = 0;
        try (Scanner reader = new Scanner(f)) {
            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                int liczba = Integer.parseInt(data);
                int dzielnik = 2;
                int currentDzielniki = 0;
                int indexLiczby = 0;
                int indexLiczbyRozne = 0;
                int currentRozne = 0;
                while(liczba > 1)
                {
                    while(liczba%dzielnik == 0)
                    {
                        //System.out.println(dzielnik);
                        liczba = liczba/dzielnik;
                        currentDzielniki++;
                        if(maxDzielniki < currentDzielniki)
                        {
                            maxDzielniki = currentDzielniki;
                            System.out.println("Max: " + maxDzielniki);
                            i = indexLiczby;
                        }

                    }
                    dzielnik++;
                    if(currentRozne > maxRozne)
                    {
                        maxRozne = currentRozne;
                        System.out.println("Rozne: " + maxRozne);
                    }
                }
                i++;

            }

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}