
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

public class LendemainTest{
    Lendemain len;
    @Before
    public void init(){
        this.len =  new Lendemain();
    }
    @SuppressWarnings("deprecation")
	@Test
    public void lendemainCoverageTest(){
        Assert.assertEquals(len.calcLendemain(14,11,2001), new Date(2001,11,16));
        Assert.assertEquals(len.calcLendemain(30,10,2001), new Date(2001,11,1));
        Assert.assertEquals(len.calcLendemain(27,2,2020), new Date(2020,2,29));
        Assert.assertEquals(len.calcLendemain(27,2,2021), new Date(2021,3,1));
        Assert.assertEquals(len.calcLendemain(30,12,2021), new Date(2022,1,1));

       /* len.calcLendemain(14,11,2001);
        len.calcLendemain(21,10,2001);
        len.calcLendemain(14,2,2001);
        len.calcLendemain(31,12,2021);*/
    }

    @Test
    public void lendemainCoverageExceptionTest(){
        try {
            len.calcLendemain(11,11,1400);

            Assert.fail("try1");
        }
        catch(IllegalArgumentException e){
        assert(e.getMessage().contains("Input Invalid"));
        }

        try {
            len.calcLendemain(32,11,2000);
            Assert.fail("try2");

        }
        catch(IllegalArgumentException e){
            assert(e.getMessage().contains("Input Invalid"));

        }

        try {
            len.calcLendemain(11,13,2000);
            Assert.fail("try3");
        }
        catch(IllegalArgumentException e){
            assert(e.getMessage().contains("Input Invalid"));
        }


    }
}
