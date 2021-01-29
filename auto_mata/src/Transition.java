public class Transition {
    public final String startState;
    public final String input;
    public final String newState;

    public Transition(String startState, String input, String newState) {
        this.startState = startState;
        this.input = input;
        this.newState = newState;
    }
}
