import main.java.Main;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MainTest {

    private Main main = null;
    @Before
    public void setup() {
        main = new Main();
    }
    @Test
    public void isInstanceNotNull() {
        Assert.assertNotNull(main);
    }

    @Test
    public void checkIfCPFNotNull() {
        Assert.assertTrue(main.isNotNullCPF("00000000000"));
    }

    @Test
    public void checkIfCPFSizeValid() {
        boolean isSizeValid = main.isSizeValid("00000000000");
        Assert.assertTrue(isSizeValid);
    }

    @Test
    public void checkIfCPFOnlyNumbers() {
        boolean isCPFOnlyNumber = main.isCPFOnlyNumbers("12345678912");
        Assert.assertTrue(isCPFOnlyNumber);
    }

    @Test
    public void checkIfIsValidFormat() {
        Assert.assertTrue(main.isContainsOnlySameValue("00000000000"));
        Assert.assertTrue(main.isContainsOnlySameValue("11111111111"));
        Assert.assertTrue(main.isContainsOnlySameValue("22222222222"));
        Assert.assertTrue(main.isContainsOnlySameValue("33333333333"));
        Assert.assertTrue(main.isContainsOnlySameValue("44444444444"));
        Assert.assertTrue(main.isContainsOnlySameValue("55555555555"));
        Assert.assertTrue(main.isContainsOnlySameValue("66666666666"));
        Assert.assertTrue(main.isContainsOnlySameValue("77777777777"));
        Assert.assertTrue(main.isContainsOnlySameValue("88888888888"));
        Assert.assertTrue(main.isContainsOnlySameValue("99999999999"));
    }

    @Test
    public void checkValidatorDigit() {
        Assert.assertTrue(main.isDigitsValid("02206261030"));
    }

}