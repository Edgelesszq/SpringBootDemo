import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestDemo {
    Logger Log= LoggerFactory.getLogger(getClass());
    @Test
    public void test(){
        Log.debug("TEST______________________");
    }
}
