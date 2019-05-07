import java.util.Enumeration;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 对象池
 *
 * @author WangCong
 * @since 2019-05-07
 */
public abstract class ObjectPool<T> {

    /**
     * 过期时间
     */
    private final long expirationTime;

    /**
     * 空闲资源组，被占用资源组
     */
    private ConcurrentHashMap<T, Long> locked, unlocked;

    public ObjectPool() {
        expirationTime = 30000L;
        locked = new ConcurrentHashMap<>();
        unlocked = new ConcurrentHashMap<>();
    }

    /**
     * 添加资源
     */
    protected abstract T create();

    /**
     * 释放资源
     *
     * @param o 资源对象
     */
    protected abstract void release(T o);

    /**
     * 判断资源是否有效
     *
     * @param o 资源对象
     */
    protected abstract boolean isValidate(T o);


    public synchronized T acquireOne() {
        long now = System.currentTimeMillis();
        T next;
        if (unlocked.size() > 0) {
            Enumeration<T> keys = unlocked.keys();
            while (keys.hasMoreElements()) {
                next = keys.nextElement();
                if ((now - unlocked.get(next)) > expirationTime) {
                    unlocked.remove(next);
                    release(next);
                    next = null;
                } else {
                    if (isValidate(next)) {
                        unlocked.remove(next);
                        locked.put(next, now);
                        return next;
                    } else {
                        unlocked.remove(next);
                        release(next);
                        next = null;
                    }
                }
            }
        }

        next = create();
        unlocked.put(next, now);

        return next;
    }

    public synchronized void returnOne(T o) {
        locked.remove(o);
        unlocked.put(o, System.currentTimeMillis());
    }
}
