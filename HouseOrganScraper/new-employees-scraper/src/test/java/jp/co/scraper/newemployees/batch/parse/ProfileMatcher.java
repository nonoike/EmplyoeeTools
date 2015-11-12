package jp.co.scraper.newemployees.batch.parse;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;

import jp.co.scraper.newemployees.entity.EnterMonth;
import jp.co.scraper.newemployees.entity.Image;
import jp.co.scraper.newemployees.entity.Profile;
import jp.co.scraper.newemployees.entity.Section;

/**
 * {@link Profile}のカスタムマッチャークラス。
 *
 * @author user
 */
public class ProfileMatcher extends BaseMatcher<Profile> {
    /** 期待結果 */
    private Profile expected;
    /** 不一致の項目名 */
    private String field;
    /** 不一致の項目の期待結果 */
    private Object expectedValue;
    /** 不一致の項目の実際の結果 */
    private Object actualValue;

    /**
     * 比較メソッドを呼び出します。
     *
     * @param expected 期待結果
     * @return カスタムマッチャー
     */
    public static Matcher<Profile> sameValuesAs(Profile expected) {
        return new ProfileMatcher(expected);
    }

    /** コンストラクタ */
    private ProfileMatcher(Profile expected) {
        this.expected = expected;
    }

    @Override
    public boolean matches(Object actualObj) {
        if (expected == null) {
            return actualObj == null;
        }
        if (!(actualObj instanceof Profile)) {
            return false;
        }

        Profile actual = (Profile) actualObj;
        if (notEquals(expected.getId(), actual.getId())) {
            setFields("id", expected.getId(), actual.getId());
            return false;
        }
        if (hasErrorInBelong(expected.getSection(), actual.getSection())) {
            return false;
        }
        if (hasErrorInEnterMonth(expected.getEnterMonth(), actual.getEnterMonth())) {
            return false;
        }
        if (hasErrorInImage(expected.getImage(), actual.getImage())) {
            return false;
        }
        if (notEquals(expected.getLastName(), actual.getLastName())) {
            setFields("lastName", expected.getLastName(), actual.getLastName());
            return false;
        }
        if (notEquals(expected.getFirstName(), actual.getFirstName())) {
            setFields("firstName", expected.getFirstName(), actual.getFirstName());
            return false;
        }
        if (notEquals(expected.getLastNameKana(), actual.getLastNameKana())) {
            setFields("lastNameKana", expected.getLastNameKana(), actual.getLastNameKana());
            return false;
        }
        if (notEquals(expected.getFirstNameKana(), actual.getFirstNameKana())) {
            setFields("firstNameKana", expected.getFirstNameKana(), actual.getFirstNameKana());
            return false;
        }
        if (notEquals(expected.getHobby(), actual.getHobby())) {
            setFields("hobby", expected.getHobby(), actual.getHobby());
            return false;
        }
        if (notEquals(expected.getCareer(), actual.getCareer())) {
            setFields("career", expected.getCareer(), actual.getCareer());
            return false;
        }
        if (notEquals(expected.getSelfPr(), actual.getSelfPr())) {
            setFields("selfPr", expected.getSelfPr(), actual.getSelfPr());
            return false;
        }
        if (notEquals(expected.getRemarks(), actual.getRemarks())) {
            setFields("remarks", expected.getRemarks(), actual.getRemarks());
            return false;
        }
        if (notEquals(expected.getDeleteFlg(), actual.getDeleteFlg())) {
            setFields("deleteFlg", expected.getDeleteFlg(), actual.getDeleteFlg());
            return false;
        }
        if (notEquals(expected.getCreated(), actual.getCreated())) {
            setFields("created", expected.getCreated(), actual.getCreated());
            return false;
        }
        if (notEquals(expected.getModified(), actual.getModified())) {
            setFields("modified", expected.getModified(), actual.getModified());
            return false;
        }
        return true;
    }

    @Override
    public void describeTo(Description desc) {
        if (expected == null || field == null) {
            desc.appendValue(expected);
        } else {
            desc.appendText(field + " is ").appendValue(expectedValue).appendText(", but ").appendValue(actualValue);
        }
    }

    /**
     * 画像項目の内容を比較します。
     *
     * @param expected 期待結果
     * @param actual 実際の結果
     * @return 結果が等しくなければtrue、そうでなければfalse
     */
    private boolean hasErrorInImage(Image expected, Image actual) {
        if (notEquals(expected, actual)) {
            setFields("imageEntity", expected, actual);
            return true;
        }
        if (notEquals(expected.getFilePath(), actual.getFilePath())) {
            setFields("imageFilePath", expected.getFilePath(), actual.getFilePath());
            return true;
        }
        return false;
    }

    /**
     * 入社年月項目の内容を比較します。
     *
     * @param expected 期待結果
     * @param actual 実際の結果
     * @return 結果が等しくなければtrue、そうでなければfalse
     */
    private boolean hasErrorInEnterMonth(EnterMonth expected, EnterMonth actual) {
        if (notEquals(expected, actual)) {
            setFields("enterMonthEntity", expected, actual);
            return true;
        }
        if (notEquals(expected.getEnterMonth(), actual.getEnterMonth())) {
            setFields("enterMonth", expected.getEnterMonth(), actual.getEnterMonth());
            return true;
        }
        return false;
    }

    /**
     * 所属項目の内容を比較します。
     *
     * @param expected 期待結果
     * @param actual 実際の結果
     * @return 結果が等しくなければtrue、そうでなければfalse
     */
    private boolean hasErrorInBelong(Section expected, Section actual) {
        // section
        if (notEquals(expected, actual)) {
            setFields("sectionEntity", expected, actual);
            return true;
        }
        if (notEquals(expected.getName(), actual.getName())) {
            setFields("sectionName", expected.getName(), actual.getName());
            return true;
        }

        // department
        if (notEquals(expected.getDepartment(), actual.getDepartment())) {
            setFields("departmentEntity", expected.getDepartment(), actual.getDepartment());
            return true;
        }
        if (notEquals(expected.getDepartment().getName(), actual.getDepartment().getName())) {
            setFields("departmentName", expected.getDepartment().getName(), actual.getDepartment().getName());
            return true;
        }

        // division
        if (notEquals(expected.getDepartment().getDivision(), actual.getDepartment().getDivision())) {
            setFields("divisionEntity", expected.getDepartment().getDivision(), actual.getDepartment().getDivision());
            return true;
        }
        if (notEquals(expected.getDepartment().getDivision().getName(), actual.getDepartment().getDivision().getName())) {
            setFields("divisionName", expected.getDepartment().getDivision().getName(), actual.getDepartment().getDivision().getName());
            return true;
        }
        return false;
    }

    /**
     * 項目の内容を比較します。
     *
     * @param expected 期待結果
     * @param actual 実際の結果
     * @return 結果が等しくなければtrue、そうでなければfalse
     */
    private boolean notEquals(Object expected, Object actual) {
        if (expected == null) {
            return actual != null;
        }
        return !expected.equals(actual);
    }

    /**
     * 不備結果の説明文に埋め込む要素に値をセットします。
     *
     * @param field 項目名
     * @param expectedValue 期待結果
     * @param actualValue 実際の結果
     */
    private void setFields(String field, Object expectedValue, Object actualValue) {
        this.field = field;
        this.expectedValue = expectedValue;
        this.actualValue = actualValue;
    }
}
