package jp.co.scraper.newemployees;

/**
 * バッチ処理の終了ステータスを定義したクラス。
 *
 * @author user
 */
public enum ExitStatus {
    /** 正常終了 */
    SUCCESS(0),
    /** 異常終了 */
    ABEND(1),
    ;

    /** 終了ステータス */
    private int statusCode;

    /** デフォルトコンストラクタ */
    private ExitStatus(final int code) {
        statusCode = code;
    }

    /**
     * @return the statusCode
     */
    public int getStatusCode() {
        return statusCode;
    }
}
