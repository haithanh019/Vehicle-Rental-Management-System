package view;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class Menu<T> {

    protected String title;
    protected ArrayList<T> options;

    public Menu() {
    }

    public Menu(String td, String[] mc) {
        title = td;
        options = new ArrayList<>();
        for (String s : mc) {
            options.add((T) s);
        }
    }
//-------------------------------------------

    public void display() {
        System.out.println("\n===============[" + title + "]===============");
        for (int i = 0; i < options.size(); i++) {
            System.out.println((i + 1) + "." + options.get(i));
        }
        System.out.println("--------------------------------");
    }
//-------------------------------------------

    public int getSelected() {
        display();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter selection..");
        return sc.nextInt();
    }
//-------------------------------------------

    public abstract void execute(int n);
//-------------------------------------------

    public void run() {

        while (true) {
            int n = getSelected();
            execute(n);
            if (n >= options.size()) {
                return;
            }
        }

    }
//-------------------------------------------    
}
