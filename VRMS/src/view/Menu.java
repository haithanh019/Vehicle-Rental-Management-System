package view;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class Menu<T> {
    protected String title;
    protected ArrayList<T> option;
    protected Menu parentMenu;
    
    public Menu(){};

    public Menu(String t, String[] op, Menu parentMenu) {
        title = t;
        option = new ArrayList<>();
        for(String s: op) option.add((T)s);
        this.parentMenu = parentMenu;
    }
    //--------------------
    public void display(){
        System.out.println("\n-------------------------");
        System.out.println(title);
        System.out.println("-------------------------");
        for (int i = 0; i < option.size(); i++)
            System.out.println((i+1)+"."+option.get(i));
        System.out.println("-------------------------");
    }
    //--------------------
    public int getSelected(){
        display();
        Scanner sc = new Scanner(System.in);
        System.out.println("Eenter selection..");
        return sc.nextInt();
    }
    //--------------------
    public abstract void execute(int n);
    //--------------------
    public void run(){
        while(true){
            int n = getSelected();
            if(n > 0 && n <= option.size()){
                execute(n);
            } else {
                System.out.println("Invalid selection!");
            }
        }
    }
    //--------------------
}
