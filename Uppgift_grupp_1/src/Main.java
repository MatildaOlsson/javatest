import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


//        System.out.println("Hello! You need to get out of here as soon as possible!! Look around... as you can see this room is full of useful tools, that hopefullt can help you get out of here");
//        System.out.println("Don't waste any time! Look around and try to figure a way out");



                //Scanner scanner = new Scanner(System.in);
                //int choice = scanner.nextInt();
                // switch (choice) {}

                ArrayList<String> tools = new ArrayList<>();

                //Alternativt en hashmap med eb enum-klass?

                tools.add("En hammare"); // index 0
                tools.add("En skruvmejsel");
                tools.add("En toalettstol");
                tools.add("En mixer");
                tools.add("En påse");
                tools.add("En kniv");
                tools.add("En kista");
                tools.add("En krok");
                tools.add("En karta med koltabletter");
                tools.add("En burk med bikarbonat");
                tools.add("En såg");
                tools.add("En tidning");
                tools.add("En kikare");
                tools.add("En ficklampa");
                tools.add("En sensor");

                //printar ut första föremålet
                // System.out.println(tools.get(0));

                //printar ut hela arraylistan med olika föremål
                for (int i = 0; i < tools.size(); i++ ) {
                    System.out.println(i + 1 + "." + tools.get(i));
                }

                // Skapar en lista fär föremålan som spelaren "håller i" . - max 2 st
                ArrayList<String> myHands = new ArrayList<>();
                Scanner input = new Scanner(System.in);

                //lägga in en while-loop för att återkomma till valen, ev flera whileloopar som reperensterar olika "faser" i spelet,

                System.out.println("Välj ett föremål i listan genom att skriva in förmålets nummer");
                int valtNummer = input.nextInt();
                int val1 = valtNummer - 1;
                // kanske snyggare att skriva in föremålets namn när man gör valet?
                // Listan kan innehålla förmål med samma "genus" för att undvika språkliga svårigheter

                // Undvika att förlora föremål.. dvs "tappa" föremål när de läggs i lista..
                // Kankse bäst att skapa en arraylist som innehåller Obejekt och inte ensaka varibaler.

                System.out.println("Du plockar upp " + tools.get(val1));
                // pLacerar föremålet i "hand-listan"
                myHands.add(tools.get(val1));
                System.out.println("Du håller i (läggs i hand-listan): " + myHands.get(0));
                //Plockas bort från "toools-listan"
                System.out.println(tools.remove(val1) + " plockas bort från objektlistan");

                //Printar ut hela objektlistan, nu med ett förmål mindre

                for (int i = 0; i < tools.size(); i++ ) {
                    System.out.println(i + 1 + "." + tools.get(i));
                }

                //Printar ut "my hand" lista innehållande ett föremål som plockats upp
                for (int i = 0; i < myHands.size(); i++ ) {
                    System.out.println(i + 1 + "." + myHands.get(i));
                }

                putDown(myHands, tools);

//        //Plocka bort ett objekt från "mina händer
//        System.out.println("Välj ett utav föremålen i listan som du vill lägga ifrån dig: ");
//        for (int i = 0; i < myHands.size(); i++ ) {
//            System.out.println(i + 1 + "." + myHands.get(i));
//        }
//        valtNummer = input.nextInt();
//        val1 = valtNummer - 1;
//
//        // Tar bort det valda föremålets enligt index från "händerna" och printar sedan ut listan på nytt
//        myHands.remove(val1);
//        System.out.println("Dina tillgängliga föremål: ");
//        for (int i = 0; i < myHands.size(); i++ ) {
//            System.out.println(i + 1 + "." + myHands.get(i));
//        }






            }

            // Metod för att "plocka bort" föremål med en Arraylist
            public static void putDown (ArrayList<String> myHands, ArrayList<String> tools) {
//        for (int i = 0; i < myHands.size(); i++) {
//            System.out.println(i + 1 + "." + myHands.get(i));
//        }

//        Plocka bort ett objekt från "mina händer
                Scanner input = new Scanner(System.in);
                System.out.println("Välj ett utav föremålen i listan som du vill lägga ifrån dig: ");
                for (int i = 0; i < myHands.size(); i++) {
                    System.out.println(i + 1 + "." + myHands.get(i));
                }
                int valtNummer = input.nextInt();
                // valt1 ...

                if (valtNummer >= 1 && valtNummer <= myHands.size()) {
                    //Lägger föremålet i "tools-listan" och tar bort det ifrån "myHands listan

                    tools.add(myHands.get(valtNummer -1));
                    myHands.remove(valtNummer - 1);
                    System.out.println("Dina tillgängliga föremål: ");
                    for (int i = 0; i < myHands.size(); i++) {
                        System.out.println(i + 1 + "." + myHands.get(i));
                    }

                }
                else if(myHands.isEmpty()) {
                    System.out.println("Du håller inte i några föremål för tillfället!");
                }
                else {
                    System.out.println("Ogiltig input");

                }
            }

        }
}