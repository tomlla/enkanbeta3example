package enkanexample;

import enkan.collection.Multimap;
import lombok.val;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static enkan.collection.OptionMap.of;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MainTest {

    private int count = 0;

    @Before
    public void setUp() {
        count++;

        val i1 = 1;
        System.out.println(this.count);
    }

    @Test
    public void test01() {
        assertThat("x", is("x"));
    }

    public void test_MultiMap() {
        Multimap<String, String> enkanMM1 = Multimap.empty();
        Multimap<String, String> enkanMM2 = Multimap.of(
                "x", "vim",
                "y", "emacs");
        System.out.println(enkanMM1);
        System.out.println(enkanMM2);
        System.out.println("--");
    }
}
