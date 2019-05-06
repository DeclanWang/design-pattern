package factory;

import cpu.CPU;
import cpu.EmberCPU;
import mmu.EmberMMU;
import mmu.MMU;

public class EmberToolkit extends AbstractFactory {
    @Override
    public CPU createCPU() {
        return new EmberCPU();
    }

    @Override
    public MMU createMMU() {
        return new EmberMMU();
    }
}
