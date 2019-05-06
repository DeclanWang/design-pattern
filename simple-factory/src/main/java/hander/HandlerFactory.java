package hander;

import constant.HandlerTypeEnum;
import lombok.extern.slf4j.Slf4j;

/**
 * 处理器工厂类
 *
 * @author WangCong
 * @since 2019-04-18
 */
@Slf4j
public class HandlerFactory {

    private static final String HANDLER_BEAN_NAME_FORMAT = "%sHandler";

    public static Handler loadHandler(HandlerTypeEnum type) {
        Handler handler = null;
        try {
            Class clazz = Class.forName(getHandlerName(type));
            handler = (Handler) clazz.newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            log.error("load handler error, the detail is: ", e);
        }
        return handler;
    }

    private static String getHandlerName(HandlerTypeEnum type) {
        return String.format(HANDLER_BEAN_NAME_FORMAT, type.name());
    }
}
