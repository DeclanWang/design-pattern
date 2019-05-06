import constant.HandlerTypeEnum;
import handler.Handler;
import handler.HandlerFactory;

/**
 * 应用入口
 *
 * @author WangCong
 * @since 2019-05-06
 */
public class Main {

    public static void main(String[] args) {
        String message = "Simple Factory!";

        Handler handler = HandlerFactory.loadHandler(HandlerTypeEnum.Upload);
        handler.handleMessage(message);

        handler = HandlerFactory.loadHandler(HandlerTypeEnum.Visit);
        handler.handleMessage(message);
    }
}
