package factory;

import cpu.CPU;
import cpu.EnginolaCPU;
import mmu.EnginolaMMU;
import mmu.MMU;

public class EnginolaToolkit extends AbstractFactory {
    @Override
    public CPU createCPU() {
        return new EnginolaCPU();
    }

    @Override
    public MMU createMMU() {
        return new EnginolaMMU();
    }
}
