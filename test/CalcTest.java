import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalcTest {
    MainFrame mainFrame;

    @BeforeEach
    public void initEach() {
        this.mainFrame = new MainFrame();
    }
    
    @Test
    public void testCalcTc() {
        double actual = this.mainFrame.calcTc(80,25,18);
        double expected = 0.177;
        assertEquals(expected, actual, 0.1);
    }

    @Test
    public void testCalcTcSecond() {
        double actual = this.mainFrame.calcTc(100,37,11);
        double expected = 0.245;
        assertEquals(expected, actual, 0.1);
    }
    @Test
    public void testCalcTcBottom() {
        double actual = this.mainFrame.calcTc(130,45,8);
        double expected = 0.36;
        assertEquals(expected, actual, 0.1);
    }
    @Test
    public void testCalcTcTop() {
        double actual = this.mainFrame.calcTc(110,27,24);
        double expected = 0.169;
        assertEquals(expected, actual, 0.1);
    }


}
