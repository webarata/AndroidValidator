package link.webarata3.dro.common.validator.enums;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class TrimTypeTest {
    @Test
    public void trimType_NONEの場合() throws Exception {
        assertThat(TrimType.NONE.trim(" あいうえお "), is(" あいうえお "));
    }

    @Test
    public void trimType_BOTHの場合() throws Exception {
        assertThat(TrimType.BOTH.trim(" あいうえお "), is("あいうえお"));
    }

    @Test
    public void trimType_LEFTの場合() throws Exception {
        assertThat(TrimType.LEFT.trim(" あいうえお "), is("あいうえお "));
    }

    @Test
    public void trimType_RIGHTの場合() throws Exception {
        assertThat(TrimType.RIGHT.trim(" あいうえお "), is(" あいうえお"));
    }
}
