package core;

import static org.junit.Assert.assertEquals;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
@RunWith(Parameterized.class)
public class POMtest {
    @BeforeClass
    public static void BeforeClass01() throws Exception  {
    }
    // Test data generator
   @Parameters(name = "Iteration # {index} : tc: {0}{1};Named: {2};exp: {3}; act: {4}")
    public static Collection<String[]> data() throws IOException {
           core.POM POM = new core.POM();
           return Arrays.asList(POM.a2d());
    }
    // @Parameter for Field injection instead of Constructor
    @Parameter(value = 0)
    public String cycle;
    @Parameter(value = 1)
    public String tc;
    @Parameter(value = 2)
    public String name;
    @Parameter(value = 3)
    public String expected_Result;
    @Parameter(value = 4)
    public String actual_Result;
    @Test
    public void test_POM() {
    System.out.println(cycle + tc + " Named: "+ name + "Expected Result: " + expected_Result + "; Actual Result: " + actual_Result + ".");
           assertEquals("FALSE", expected_Result, actual_Result);
    }
}