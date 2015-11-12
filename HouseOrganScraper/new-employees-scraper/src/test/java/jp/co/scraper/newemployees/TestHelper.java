package jp.co.scraper.newemployees;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * ユニットテストのヘルパークラス。
 *
 * @author user
 */
public class TestHelper {

    /**
     * privateメソッドを取得します。
     *
     * @param clazz 取得対象のクラス
     * @param methodName 取得対象のメソッド名
     * @param argsClass メソッドの引数の型
     * @return メソッド
     * @throws Exception
     */
    @SuppressWarnings("rawtypes")
    public static Method getPrivateMethod(Class clazz, String methodName) throws Exception {
        Method method = clazz.getClass().getDeclaredMethod(methodName);
        method.setAccessible(true);
        return method;
    }

    /**
     * privateメソッドを取得します。
     *
     * @param clazz 取得対象のクラス
     * @param methodName 取得対象のメソッド名
     * @param argsClass メソッドの引数の型
     * @return メソッド
     * @throws Exception
     */
    @SuppressWarnings("rawtypes")
    public static Method getPrivateMethod(Class clazz, String methodName, Class... argsClass) throws Exception {
        Method method = clazz.getClass().getDeclaredMethod(methodName, argsClass);
        method.setAccessible(true);
        return method;
    }

    /**
     * privateフィールド変数を取得します。
     *
     * @param clazz 取得対象のクラス
     * @param methodName 取得対象のメソッド名
     * @return フィールド変数
     * @throws Exception
     */
    @SuppressWarnings("rawtypes")
    public static Field getPrivateField(Class clazz, String methodName) throws Exception {
        Field field = clazz.getClass().getDeclaredField(methodName);
        field.setAccessible(true);
        return field;
    }
}
