package jp.co.scraper.newemployees.error;

/**
 * プロパティファイルの入出力に関するエラークラス。
 *
 * @author user
 */
public class PropertiesError extends RuntimeException {
    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    /** ファイル名 */
    private String fileName;

    /** コンストラクタ */
    public PropertiesError(String message, String fileName) {
        super(message);
        this.fileName = fileName;
    }

    /**
     * @return the fileName
     */
    public String getFileName() {
        return fileName;
    }
}
