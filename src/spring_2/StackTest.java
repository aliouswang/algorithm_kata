package spring_2;

public class StackTest {

    public static void main(String[] args) {
        IStack<Integer> stack = new ArrayStack<>();
        for (int i = 0; i < 20; i++) {
            stack.push(i);
        }

        for (int i = 0; i < 20; i++) {
            System.out.println(stack.pop());
        }
    }

}
