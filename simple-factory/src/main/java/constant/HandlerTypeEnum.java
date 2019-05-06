package constant;

/**
 * 数据类型
 *
 * @author WangCong
 * @since 2019-05-06
 */
public enum HandlerTypeEnum {
    /**
     * 上传
     */
    Upload(1),
    /**
     * 访问
     */
    Visit(2);

    private final int type;

    HandlerTypeEnum(int type) {
        this.type = type;
    }
}
