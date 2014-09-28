import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * Created by Zane on 2014-09-26.
 */
public class TestMain {
    @org.junit.Test
    public static void main (String[] args){
        junit.textui.TestRunner.run(suite());
    }
    public static Test suite (){
        TestSuite suite = new TestSuite("All JUnit Tests");
        suite.addTest(new TestSuite(SharedFileTest.class));
        return suite;
    }
}
