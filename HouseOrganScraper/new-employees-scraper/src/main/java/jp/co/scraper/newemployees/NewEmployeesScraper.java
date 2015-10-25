package jp.co.scraper.newemployees;

import java.util.logging.Logger;

/**
 * 社内報の新入社員紹介ページへアクセスし、内容をDBに登録するバッチのメインクラス。
 *
 * @author user
 */
public class NewEmployeesScraper {
    /** LOGGER */
    private static final Logger LOGGER = Logger.getLogger(NewEmployeesScraper.class.getName());

    /**
     * 指定年月の社内報の新入社員紹介ページへアクセスし、内容をDBに登録するバッチのエントリポイント。<br>
     * 年月の指定がない場合は今月のデータを取得する。
     *
     * @param args yyyyMM表記の発行年月
     */
    public static void main(String[] args) {
        LOGGER.info("process start.");

        ExitStatus exitStatus = ExitStatus.SUCCESS;
        try {
            // 不備チェック

            // 処理の実行

        } catch (Exception e) {
            LOGGER.severe("please check the contents of the error.");
            exitStatus = ExitStatus.ABEND;
        }
        LOGGER.info("process end.");
        System.exit(exitStatus.getStatusCode());
    }
}
