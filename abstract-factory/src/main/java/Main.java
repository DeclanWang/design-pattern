import cpu.CPU;
import factory.AbstractFactory;
import factory.Architecture;

/**
 * 应用入口
 *
 * @author WangCong
 * @since 2019-05-06
 */
public class Main {
    public static void main(String[] args) {
        AbstractFactory factory = AbstractFactory.getFactory(Architecture.EMBER);
        CPU cpu = factory.createCPU();
    }
}
