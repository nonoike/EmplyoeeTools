package jp.co.scraper.newemployees.util;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import jp.co.scraper.newemployees.error.PropertiesError;

/**
 * Propertiesに関連する処理をまとめたクラス。
 *
 * @author user
 */
public class PropertiesUtils {

    /** 読み込み済みのプロパティのキャッシュ。クラスがキー、そのクラスの対象のプロパティファイルの読み込み結果がvalue */
    private static Map<Class<Enum<?>>, Properties> propCache = new HashMap<>();

    /** インスタンス化を禁止するコンストラクタ */
    private PropertiesUtils() {
    }

    /**
     * keyに対するvalueを取得します。<br>
     * その際、未読み込みのプロパティファイルならば読み込みを行ない、キャッシュします。
     *
     * @param key プロパティファイルのkey
     * @return プロパティファイルのkeyに対するvalue
     */
    @SuppressWarnings("unchecked")
    public static String getValue(PropKey key) {
        Properties properties;
        if (propCache.containsKey(key.getClass())) {
            properties = propCache.get(key.getClass());
        } else {
            properties = loadProperties(key.getFileName());
            propCache.put((Class<Enum<?>>) key.getClass(), properties);
        }
        return properties.getProperty(key.getKey());
    }

    /**
     * プロパティファイルの読み込み結果を返します。
     *
     * @param path プロパティファイルのパス
     * @return ファイルの読み込み結果
     */
    private static Properties loadProperties(String fileName) {
        try (InputStream resource = PropertiesUtils.class.getClassLoader().getResourceAsStream(fileName);) {
            Properties prop = new Properties();
            prop.load(resource);
            return prop;
        } catch (Exception e) {
            throw new PropertiesError("failed to load properties.", fileName);
        }
    }
}
