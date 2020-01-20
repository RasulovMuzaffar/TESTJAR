import app.T;
import app.Test;
import app.TestImpl;

public class App {
    public static void main(String[] args) {
        Test t = new TestImpl();
        System.out.println(t.getText());
        T t1 = new T();
        t1.getCs();
    }
}
