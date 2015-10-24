package jp.co.scraper.newemployees;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

/**
 * {@link ExitStatus}のテストクラス。
 *
 * @author user
 */
public class ExitStatusTest {
    @Test
    public void OK_SUCCESSのステータスコード0を取得できる() {
        assertThat(ExitStatus.SUCCESS.getStatusCode(), is(0));
    }

    @Test
    public void OK_ABENDのステータスコード1を取得できる() {
        assertThat(ExitStatus.ABEND.getStatusCode(), is(1));
    }
}
