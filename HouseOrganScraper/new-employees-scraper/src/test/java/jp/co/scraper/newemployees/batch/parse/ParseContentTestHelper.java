package jp.co.scraper.newemployees.batch.parse;

import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import jp.co.scraper.newemployees.entity.Department;
import jp.co.scraper.newemployees.entity.Division;
import jp.co.scraper.newemployees.entity.EnterMonth;
import jp.co.scraper.newemployees.entity.Image;
import jp.co.scraper.newemployees.entity.Profile;
import jp.co.scraper.newemployees.entity.Section;

/**
 * {@link ParseContentTest}のヘルパークラス。
 *
 * @author user
 */
public class ParseContentTestHelper {
    /** ダミーデータ1月に該当するProfileの作成 */
    public static Profile Profileの作成_1月() {
        Profile profile = new Profile();
        YearMonth yearMonth = YearMonth.now().withMonth(1);
        Section section = new Section();
        section.setName("11課");
        Department department = new Department();
        department.setName("a1部");
        Division division = new Division();
        division.setName("A事業部");
        section.setDepartment(department);
        department.setSections(Arrays.asList(section));
        department.setDivision(division);
        division.setDepartments(Arrays.asList(department));
        EnterMonth enterMonth = new EnterMonth();
        enterMonth.setEnterMonth(yearMonth.format(DateTimeFormatter.ofPattern("yyyyMM")));
        Image image = new Image();
        image.setFilePath("img/fresh_01.jpg");

        profile.setId(null);
        profile.setSection(section);
        profile.setEnterMonth(enterMonth);
        profile.setImage(image);
        profile.setLastName("姓");
        profile.setFirstName("名");
        profile.setLastNameKana("せい");
        profile.setFirstNameKana("めい");
        profile.setHobby("趣味1");
        profile.setCareer("経歴1");
        profile.setSelfPr("自己PR1");
        profile.setRemarks(null);
        profile.setDeleteFlg(null);
        profile.setCreated(null);
        profile.setModified(null);
        return profile;
    }

    /** ダミーデータ2月1人目に該当するProfileの作成 */
    public static Profile Profileの作成_2月1人目() {
        Profile profile = new Profile();
        YearMonth yearMonth = YearMonth.now().withMonth(2);
        Section section = new Section();
        section.setName("12課");
        Department department = new Department();
        department.setName("");
        Division division = new Division();
        division.setName("A2事業本部");
        section.setDepartment(department);
        department.setSections(Arrays.asList(section));
        department.setDivision(division);
        division.setDepartments(Arrays.asList(department));
        EnterMonth enterMonth = new EnterMonth();
        enterMonth.setEnterMonth(yearMonth.format(DateTimeFormatter.ofPattern("yyyyMM")));
        Image image = new Image();
        image.setFilePath("img/fresh_02.jpg");

        profile.setId(null);
        profile.setSection(section);
        profile.setEnterMonth(enterMonth);
        profile.setImage(image);
        profile.setLastName("姓2");
        profile.setFirstName("名2");
        profile.setLastNameKana("せいに");
        profile.setFirstNameKana("めいに");
        profile.setHobby("趣味2_1<br />趣味2_2");
        profile.setCareer("経歴2_1<br />経歴2_2");
        profile.setSelfPr("自己PR2_1<br />自己PR2_2");
        profile.setRemarks(null);
        profile.setDeleteFlg(null);
        profile.setCreated(null);
        profile.setModified(null);
        return profile;
    }

    /** ダミーデータ2月2人目に該当するProfileの作成 */
    public static Profile Profileの作成_2月2人目() {
        Profile profile = new Profile();
        YearMonth yearMonth = YearMonth.now().withMonth(2);
        Section section = new Section();
        section.setName("13課");
        Department department = new Department();
        department.setName("a3部&nbsp;b3部");
        Division division = new Division();
        division.setName("A3本部");
        section.setDepartment(department);
        department.setSections(Arrays.asList(section));
        department.setDivision(division);
        division.setDepartments(Arrays.asList(department));
        EnterMonth enterMonth = new EnterMonth();
        enterMonth.setEnterMonth(yearMonth.format(DateTimeFormatter.ofPattern("yyyyMM")));
        Image image = new Image();
        image.setFilePath("img/fresh_03.jpg");

        profile.setId(null);
        profile.setSection(section);
        profile.setEnterMonth(enterMonth);
        profile.setImage(image);
        profile.setLastName("姓3");
        profile.setFirstName("名3");
        profile.setLastNameKana("せいさん");
        profile.setFirstNameKana("めいさん");
        profile.setHobby("趣味3_1<br /><br />趣味3_3(3_2はなし)<br />");
        profile.setCareer("経歴3_1<br /><br />経歴3_3(3_2はなし)<br />");
        profile.setSelfPr("自己PR3_1<br /><br />自己PR3_3(3_2はなし)<br />");
        profile.setRemarks(null);
        profile.setDeleteFlg(null);
        profile.setCreated(null);
        profile.setModified(null);
        return profile;
    }
}
