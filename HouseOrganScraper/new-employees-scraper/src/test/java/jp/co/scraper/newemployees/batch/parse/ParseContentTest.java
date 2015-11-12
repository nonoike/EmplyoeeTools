package jp.co.scraper.newemployees.batch.parse;

import static jp.co.scraper.newemployees.batch.parse.ParseContentTestHelper.*;
import static jp.co.scraper.newemployees.batch.parse.ProfileMatcher.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.time.YearMonth;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static jp.co.scraper.newemployees.TestHelper.*;
import jp.co.scraper.newemployees.entity.Profile;

/**
 * {@link ParseContent}のテストクラス。
 *
 * @author user
 */
public class ParseContentTest {
    private ParseContent sut;
    private BufferedReader br;

    @Before
    public void setUp() throws Exception {
        br = new BufferedReader(new InputStreamReader(ParseContentTest.class.getClassLoader().getResourceAsStream("content_dummy.txt"), "UTF-8"));
        sut = new ParseContent(br);
    }

    @After
    public void tearDown() throws Exception {
        br.close();
    }

    @Ignore
    @Test
    public void createProfilesEachMonthで年月毎の新入社員紹介一覧を取得できる() throws Exception {
        Map<YearMonth, List<Profile>> actualMap = sut.createProfilesEachMonth();
        YearMonth yearMonth;
        List<Profile> actuals;

        assertThat(actualMap.size(), is(2));

        // 1月
        yearMonth = YearMonth.now().withMonth(1);
        assertThat(actualMap, hasKey(yearMonth));

        actuals = actualMap.get(yearMonth);
        actuals.sort(Comparator.comparing(Profile::getFirstName));
        assertThat(actuals.size(), is(1));
        assertThat(actuals.get(0), sameValuesAs(Profileの作成_1月()));

        // 2月
        yearMonth = YearMonth.now().withMonth(2);
        assertThat(actualMap, hasKey(yearMonth));

        actuals = actualMap.get(yearMonth);
        actuals.sort(Comparator.comparing(Profile::getFirstName));
        assertThat(actuals.size(), is(2));
        assertThat(actuals.get(0), sameValuesAs(Profileの作成_2月1人目()));
        assertThat(actuals.get(1), sameValuesAs(Profileの作成_2月2人目()));
    }

    @Test
    public void readUntilIntroductionBeginsは該当部まで読み飛ばす() throws Exception {
        sut.readUntilIntroductionBegins();
        String actual = sut.content.readLine();
        String expected = "<h3 id=\"freshman02\">1月入社</h3>";
        assertThat(actual, is(expected));
    }
}
