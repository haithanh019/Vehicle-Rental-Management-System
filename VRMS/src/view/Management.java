
package view;

public class Management extends Menu<String>{
    
    public static void main(String[] args) {
        Management mg = new Management();
        mg.run();
    }
    
    static String[] menu ={"Ha An Cut 1","Ha An Cut 2","Ha An Cut 3","Exit"};
    public Management(){
        super("Car Management", menu, null);
    }

    @Override
    public void execute(int n) {
        switch(n){
            case 1:
                //Vi du
                searchVehicle();
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                System.out.println("Exiting application...");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid!");
                break;
        }
    }
      
    public void searchVehicle(){
        String[] mSearch = {"Mortorcycle","Bicycle","Back to MENU"};
        Menu m = new Menu("Vehicle Searching", mSearch, this) {
            @Override
            public void execute(int n) {
                switch(n){
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        System.out.println("Returning to the main menu.");
                        if (parentMenu != null) {
                            parentMenu.run();
                        }
                        break;

                }
            }
        };
        m.run();
    }
}
