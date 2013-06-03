package mockitoTest;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import parser.ParserTreeToString;


public class MockitoTest {

    @Test
    public void getValueTreeTest() {
        ParserTreeToString tree = Mockito.mock(ParserTreeToString.class);
        Mockito.when(tree.getValue()).thenReturn(new Double(-8.023));
        Assert.assertEquals(-8.023, tree.getValue());
    }

    @Test
    public void getStringTreeTest() {
        ParserTreeToString tree = Mockito.mock(ParserTreeToString.class);
        Mockito.when(tree.toString()).thenReturn("(8.0-4.0)*(2/3)+(6.5+3)");
        Assert.assertEquals("(8.0-4.0)*(2/3)+(6.5+3)", tree.toString());
    }
}
