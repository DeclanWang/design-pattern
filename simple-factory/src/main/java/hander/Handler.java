package hander;

/**
 * 处理器接口
 *
 * @author WangCong
 * @since 2019-04-18
 */
public interface Handler {

    /**
     * 处理信息
     *
     * @param message 信息
     */
    default void handleMessage(String message) {
    }
}
