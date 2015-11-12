package jp.co.scraper.newemployees.util;

/**
 * プロパティファイルの処理に関するインターフェース。
 *
 * @author user
 */
public interface PropKey {
    /**
     * プロパティファイルの名称を取得します。
     *
     * @return ファイル名
     */
    public String getFileName();

    /**
     * keyを取得します。
     *
     * @return key
     */
    public String getKey();
}
