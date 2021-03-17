import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class TQSStackTest {

    private final TQSStack stack = new TQSStack();

    @Test
    //A stack is empty on construction.
    void stackIsEmpty() {
        assertTrue(stack.isEmpty());
    }

    @Test
    //A stack has size 0 on construction.
    void stackSizeZero() {
        assertEquals(0, stack.size());
    }

    @Test
    //After n pushes to an empty stack, n > 0, the stack is not empty and its size is n
    void nPushes() {
        int n = 5;
        int element = 5;

        for(int i = 0; i < n; i++){
            stack.push(element);
            element = element + 5;
        }
        assertEquals(n, stack.size());
    }

    @Test
    //If one pushes x then pops, the value popped is x.
    void pushThenPop() {
        stack.push(5);
        assertEquals(5, stack.pop());
    }

    @Test
    //If one pushes x then peeks, the value returned is x, but the size stays the same
    void pushThenPeek() {
        stack.push(5);

        int size = stack.size();
        assertEquals(5, stack.peek());

        int finalSize = stack.size();
        assertEquals(size, finalSize);
    }

    @Test
    //If the size is n, then after n pops, the stack is empty and has a size 0
    void popsAndSize() {
        stack.push(5);
        stack.push(10);

        int n = stack.size();
        int size = n;

        for(int i = 0; i < n; i++) {
            stack.pop();
        }
        assertTrue(stack.isEmpty());
    }

    @Test
    //Popping from an empty stack does throw a NoSuchElementException [You should test for the Exception occurrence]
    void popFromEmptyStack() {
        assertThrows(NoSuchElementException.class, () -> {
           stack.pop();
        });
    }

    @Test
    //Peeking into an empty stack does throw a NoSuchElementException
    void peekEmptyStack() {
        assertThrows(NoSuchElementException.class, () -> {
           stack.peek();
        });
    }

    @Test
    //For bounded stacks only, pushing onto a full stack does throw an IllegalStateException
    //INCOMPLETO
    void pushFullStack() {
        int maxSize = 10;

        for(int i = 0; i < maxSize; i++) {
            stack.push(5);
        }
        assertThrows(IllegalStateException.class, () -> stack.push(5));

    }

}