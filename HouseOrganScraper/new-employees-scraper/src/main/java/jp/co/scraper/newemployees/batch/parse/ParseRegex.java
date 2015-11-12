package jp.co.scraper.newemployees.batch.parse;

import static jp.co.scraper.newemployees.util.PropertiesUtils.*;
import static org.hamcrest.CoreMatchers.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.swing.text.html.HTMLEditorKit.Parser;

import jp.co.scraper.newemployees.util.PropKey;
import jp.co.scraper.newemployees.util.PropertiesUtils;

/**
 * パース処理のトリガーとなるワードの定義クラス。
 *
 * @author user
 */
public enum ParseRegex implements PropKey {
    /** 該当なし */
    NONE(""),

    /** 画像 */
    IMAGE("image"),
    /** 所属 */
    BELONG("belong"),
    /** 氏名 */
    NAME("name"),
    /** 氏名かな */
    NAME_KANA("name.kana"),
    /** 経歴 */
    CAREER("career"),
    /** 趣味 */
    HOBBY("hobby"),
    /** 自己PR */
    SELFPR("selfpr"),

    /** 年月 */
    MONTH("month"),
    /** 新入社員紹介部の始まり */
    START("start"),
    /** 新入社員紹介部の終わり */
    END("end"),
    /** 社員紹介1人分の始まり */
    PROFILE_START("profile.start"),
    /** 社員紹介1人分の終わり */
    PROFILE_END("profile.end"),
    /** 項目の始まり */
    BLOCK_START("block.start"),
    /** 項目の終わり */
    BLOCK_END("block.end"),;

    /** LOGGER */
    private static final Logger LOGGER = Logger.getLogger(ParseRegex.class.getName());

    // /** プロフィールの要素のみを抽出した配列 */
    // private static final ParseRegex[] USED_PROFILE_VALUES = { IMAGE, BELONG, NAME, NAME_KANA, CAREER, HOBBY, SELFPR
    // };

    /** プロパティファイルのkey */
    private String key;

    /** ファイル名 */
    private static String fileName;

    /** コンストラクタ */
    private ParseRegex(String key) {
        this.key = key;
    }

    @Override
    public String getFileName() {
        // TODO fileNameがnullならば最新ファイルをセット
        return "parse_regex_201507.properties";
    }

    @Override
    public String getKey() {
        return key;
    }

    /**
     * @param fileName the fileName to set
     */
    public void setFileName(String fileName) {
        ParseRegex.fileName = fileName;
    }

    /**
     * 行がパースのトリガーとなる構文となっているかを判定します。
     *
     * @param line 行
     * @return トリガー行ならばtrue
     */
    public static ParseRegex matchesRegex(String line) {
        // List<ParseRegex> regexes = Stream.of(USED_PROFILE_VALUES).filter(e ->
        // line.matches(getValue(e))).collect(Collectors.toList());
        List<ParseRegex> regexes = valuesWithoutNone().stream().filter(e -> line.matches(getValue(e))).collect(Collectors.toList());
        switch (regexes.size()) {
        case 0:
            return NONE;
        case 1:
            return regexes.get(0);
        default:
            LOGGER.warning("multiple parse-regexes match.");
            return NONE;
        }
    }

    /**
     * 読み込み中の年月が終了であるかを判定します。
     *
     * @param line 行
     * @return 今の年月のデータが終了する行ならばtrue
     */
    public static boolean isEndOfYearMonth(String line) {
        return Arrays.asList(MONTH, END).stream().anyMatch(e -> line.matches(getValue(e)));
    }

    /**
     * NONE以外の要素の一覧を取得します。
     *
     * @return NONE以外の要素の一覧
     */
    private static List<ParseRegex> valuesWithoutNone() {
        return Stream.of(values()).filter(e -> !e.equals(NONE)).collect(Collectors.toList());
    }
}
