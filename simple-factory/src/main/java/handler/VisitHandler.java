package handler;

import lombok.extern.slf4j.Slf4j;

/**
 * 访问处理器
 *
 * @author WangCong
 * @since 2019-05-06
 */
@Slf4j
public class VisitHandler implements Handler {

    @Override
    public void handleMessage(String message) {
        log.info("handle visit message:{}", message);
    }
}
