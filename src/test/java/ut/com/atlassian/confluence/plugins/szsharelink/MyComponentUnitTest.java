package ut.com.atlassian.confluence.plugins.szsharelink;

import org.junit.Test;
import com.atlassian.confluence.plugins.szsharelink.MyPluginComponent;
import com.atlassian.confluence.plugins.szsharelink.MyPluginComponentImpl;

import static org.junit.Assert.assertEquals;

public class MyComponentUnitTest
{
    @Test
    public void testMyName()
    {
        MyPluginComponent component = new MyPluginComponentImpl(null);
        assertEquals("names do not match!", "myComponent",component.getName());
    }
}