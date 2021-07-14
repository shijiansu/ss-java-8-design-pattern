package design.pattern.by.jpsoroulas._1_creational._1_factory;

import lombok.Data;

@Data
public class ComputerSpecs {

  private int cores;
  private int disks;
  private long memory;

  private ComputerSpecs(ComputerSpecsBuilder builder) {
    this.cores = builder.cores;
    this.disks = builder.disks;
    this.memory = builder.memory;
  }

  static class ComputerSpecsBuilder {

    private int cores = 1;
    private int disks = 1;
    private long memory = 2;

    static ComputerSpecs buildStandardSpec() {
      return new ComputerSpecsBuilder().withCores(4).withDisks(2).withMemory(8).build();
    }

    static ComputerSpecs buildExtendedSpec() {
      return new ComputerSpecsBuilder().withCores(8).withDisks(4).withMemory(16).build();
    }

    ComputerSpecsBuilder withCores(int cores) {
      this.cores = cores;
      return this;
    }

    ComputerSpecsBuilder withDisks(int disks) {
      this.disks = disks;
      return this;
    }

    ComputerSpecsBuilder withMemory(long memory) {
      this.memory = memory;
      return this;
    }

    ComputerSpecs build() {
      return new ComputerSpecs(this); // some validation if requires
    }
  }
}
