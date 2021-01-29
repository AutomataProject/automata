import java.util.*;

public class Data{
    public String[] states;
    public String[] symbols;
    public String[] acceptingStates;
    public int id;

    public String startState;
    public String finalState;

    private final HashMap<String, Transition> transitions = new HashMap<String, Transition>();

    public Data(int id, String[] states, String[] acceptingStates, String[] symbols, Transition[] transitions, String startState, String finalState) {

        this.id = id;
        this.states = states;
        this.symbols = symbols;
        this.acceptingStates = acceptingStates;
        this.startState = startState;
        this.finalState = finalState;

        for (Transition transition: transitions){
            System.out.println(transition);
        }

    }

    public Data(){}

    public void setTransitions(Transition[] transition){
        for (Transition t: transition){
            String key = getKeyForTransition(t.startState, t.input, t.newState);
            this.transitions.put(key, t);
        }
    }
    public void accepts(){
        System.out.println("Hello");
    }

    public String[] getStates() {
        return states;
    }

    private String getKeyForTransition(String startState, String input, String newState) {
        return startState + "->"+ input +"->"+newState;
    }

    private String getKeyForSymbols(String input) {
        return input;
    }

    public HashMap<String, Transition> getTransitions() {
        return transitions;
    }
    public String[] getSymbols() {
        return symbols;
    }

    public int getId(){
        return id;
    }

    public void setStates(String[] states) {
        this.states = states;
    }

    public void setSymbols(String[] symbols) {
        this.symbols = symbols;
    }

    public void setId(int id){
        this.id = id;
    }

    public boolean isAccepting(ArrayList<Data> list) {
        for (Data data: list) {
            System.out.println(data.transitions.keySet());
        }
        return true;
    }

    public void setStartState(String startState) {
        this.startState = startState;
    }

    public String getStartState() {
        return startState;
    }

    public void setFinalState(String finalState) {
        this.finalState = finalState;
    }

    public String getFinalState() {
        return finalState;
    }

    public void toDisplay(ArrayList<Data> list) {
        if (list.isEmpty()){
            System.out.println("Empty");
        }
        else {
            for (Data data : list) {
                System.out.println(Arrays.toString(data.getStates()) +"\t"+ Arrays.asList(data.getSymbols())
                        +"\t"+ data.getTransitions().keySet() +"\t");

            }
        }
    }

    public void toCheck(ArrayList<Data> list){
        Scanner input = new Scanner(System.in);
        if (list.isEmpty()){
            System.out.println("Empty");
        }
        else {
            int count = 1;
            for (Data data : list) {
                setId(count);
                System.out.println(getId() +" "+"Q: "+data.getStates().length+", "+"∑: "+data.getSymbols().length+", "+ "δ: "+ data.getTransitions().size());
                count++;
            }
        }
    }

    public void toSearch(ArrayList<Data> list){
        Scanner input = new Scanner(System.in);
        int count = 1;
        System.out.println("Enter id search: ");
        int num = input.nextInt();
        int state = 0;
        int symbol = 0;
        int transition = 0;
        int id = 0;
        for (Data data : list) {
            setId(count);
            if (getId() == num){
                System.out.println(getId() +" "+"Q: "+data.getStates().length+", "+"∑: "+data.getSymbols().length+", "+ "δ: "+data.getTransitions().size());
                state = data.getStates().length;
                symbol = data.getSymbols().length;
                transition = data.getTransitions().size();
                id = getId();
            }
            count++;
        }
        int c = 1;
        if (state*symbol == transition){
            System.out.println("DFA");
            for (Data data : list) {
                setId(c);
                if (getId() == id){
                    System.out.println(data.getTransitions().keySet());
                }
                c++;
            }
        }
        else {
            System.out.println("NFA");
            for (Data data : list) {
                setId(c);
                if (getId() == id){
                    for (String a: data.getTransitions().keySet()) {
                        String[] parts = a.split("->");
                        System.out.println(parts[1]);
                    }
                }
                c++;
            }
        }
    }
}
