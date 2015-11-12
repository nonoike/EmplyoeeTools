package jp.co.scraper.newemployees.error;

/**
 * ロジック部に関するエラークラス。
 *
 * @author user
 */
public class LogicError extends RuntimeException {
    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /** コンストラクタ */
    public LogicError(String message) {
        super(message);
    }

}
