import app.TestImpl;
import org.junit.Test;

public class AppTest {
    @Test
    public void getTest(){
        app.Test t = new TestImpl();
        System.out.println(t.getText());
    }
}
