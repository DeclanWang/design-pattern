package factory;

import cpu.CPU;
import mmu.MMU;

public abstract class AbstractFactory {
    private static final EmberToolkit EMBER_TOOLKIT = new EmberToolkit();
    private static final EnginolaToolkit ENGINOLA_TOOLKIT = new EnginolaToolkit();

    /**
     * Returns a concrete factory object that is an instance of the
     * concrete factory class appropriate for the given architecture.
     */
    public static AbstractFactory getFactory(Architecture architecture) {
        AbstractFactory factory;
        switch (architecture) {
            case ENGINOLA:
                factory = ENGINOLA_TOOLKIT;
                break;
            case EMBER:
                factory = EMBER_TOOLKIT;
                break;
            default:
                factory = null;
        }
        return factory;
    }

    public abstract CPU createCPU();

    public abstract MMU createMMU();
}
