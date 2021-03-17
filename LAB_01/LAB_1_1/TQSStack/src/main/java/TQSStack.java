import java.sql.Struct;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class TQSStack {

    private ArrayList<Double> stack;

    public TQSStack() {
        stack = new ArrayList<Double>();
    }

    public boolean push(double element) {
        stack.add(element);
        return true;
    }

    public double pop() {
        if (stack.size() == 0) {
            throw new NoSuchElementException();
        }
        return stack.remove(stack.size() - 1);
    }

    public double peek() {
        if (stack.size() == 0) {
            throw new NoSuchElementException();
        }
        return stack.get(stack.size() - 1);
    }

    public int size() {
        return stack.size();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

}
