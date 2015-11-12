package jp.co.scraper.newemployees.batch.parse;

import java.io.BufferedReader;
import java.io.IOException;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jp.co.scraper.newemployees.entity.Profile;

/**
 * パース処理を行うクラス。
 *
 * @author user
 */
public class ParseContent {
    /** ソースコード */
    BufferedReader content;

    /** コンストラクタ */
    public ParseContent(BufferedReader content) {
        this.content = content;
    }

    /**
     * 月毎の新入社員紹介の一覧を作成します。
     *
     * @return 月毎の新入社員一覧
     */
    public Map<YearMonth, List<Profile>> createProfilesEachMonth() {
        Map<YearMonth, List<Profile>> profilesEachMonth = new HashMap<>();
        readUntilIntroductionBegins();
        return profilesEachMonth;
    }

    /**
     * 新入社員紹介の一覧を作成します。
     *
     * @return 新入社員紹介の一覧
     */
    private List<Profile> createProfiles() {
        List<Profile> profiles = new ArrayList<>();
        return profiles;
    }

    /**
     * 新入社員紹介を作成します。
     *
     * @return 新入社員紹介
     */
    private Profile createProfile() {
        Profile profile = new Profile();
        return profile;
    }

    /**
     * 新入社員紹介の部分まで読み飛ばします。
     *
     * @throws IOException
     */
    void readUntilIntroductionBegins() {
        String line;
        try {
            while ((line = content.readLine()) != null) {
                if (ParseRegex.matchesRegex(line).equals(ParseRegex.START)) {
                    return;
                }
            }
        } catch (IOException e) {
            // TODO 例外処理
        }
    }
}
