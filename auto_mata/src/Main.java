import javax.swing.text.Style;
import java.awt.*;
import java.util.*;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        ArrayList<Data> list = new ArrayList<Data>();
        System.out.println("*************** Welcome to DFA and NFA ***************");
        System.out.println("!!!!!********************************************!!!!!");
        System.out.println("a: Design a finite automaton (FA)");
        System.out.println("b: Test if a FA is deterministic or non-deterministic");
        System.out.println("c: Test if a string is accepted by a FA");
        System.out.println("e: Construct an equivalent DFA from an NFA");
        System.out.println("d: Minimize a DFA");
        System.out.println("Exit (press key e or exit)");
        while (true){
            Data d = new Data();
            System.out.println("Enter step of automata: ");
            String condition = keyboard.next();
            if (condition.equals("a")) {
                System.out.println("Enter total state: ");
                int totalState = keyboard.nextInt();
                // state
                ArrayList<String> arrayState = new ArrayList<>();
                for (int i = 0; i < totalState; i++) {
                    arrayState.add("q"+i);
                }
                // symbol
                System.out.println("Enter total symbol: ");
                int totalSymbols = keyboard.nextInt();
                ArrayList<String> arraySymbols = new ArrayList<>();
                for (int i = 0; i < totalSymbols; i++) {
                    arraySymbols.add(keyboard.next());
                }

                String[] states = arrayState.toArray( new String[] {} );
                String[] symbols = arraySymbols.toArray( new String[] {} );

                d.setStates(states);
                d.setSymbols(symbols);

                System.out.println("Enter total transition: ");
                int totalTransitions = keyboard.nextInt();
                for (int i = 0; i<totalTransitions; i++){

                    System.out.println("Design finite automata: ");
                    String data = keyboard.next();
                    String[] parts = data.split("->");

                    String part1 = parts[0];
                    String part2 = parts[1];
                    String part3 = parts[2];

                    d.setTransitions(new Transition[] {
                            new Transition(part1, part2, part3),
                    });
                }
                System.out.println("Enter start state: ");
                d.setStartState(keyboard.next());
                System.out.println("Enter final state: ");
                d.setFinalState(keyboard.next());
                list.add(d);
            }
            if (condition.equals("b")){
                d.toDisplay(list);
            }
            if (condition.equals("c")){
                d.toCheck(list);
            }
            if (condition.equals("d")){
                d.toSearch(list);
            }
            if (condition.equals("f")){
//                d.isAccepting(list);
            }
            if (condition.equals("exit") || condition.equals("exit()")){
                System.out.println("Good Bye");
                break;
            }
        }
    }
}
