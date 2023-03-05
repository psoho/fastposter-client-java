package net.fastposter.client.utils;

/**
 * 字符串工具类
 *
 * @author Alex小新 fastposter@163.com
 * @see <a href="https://cloud.fastposter.net/doc/sdk/java.html"></>
 */
public class StringUtils {

    /**
     * 是否为空
     *
     * @param cs
     * @return
     */
    public static boolean isBlank(final CharSequence cs) {
        final int strLen = length(cs);
        if (strLen == 0) {
            return true;
        }
        for (int i = 0; i < strLen; i++) {
            if (!Character.isWhitespace(cs.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * 获取长度
     *
     * @param cs
     * @return
     */
    public static int length(final CharSequence cs) {
        return cs == null ? 0 : cs.length();
    }


}
