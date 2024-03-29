package design.pattern.by.jpsoroulas._1_creational._1_factory;

import design.pattern.by.jpsoroulas._1_creational._1_factory.ComputerSpecs.ComputerSpecsBuilder;
import java.util.Optional;
import lombok.Data;

@Data
public abstract class Computer {

  private ComputerSpecs specs;

  public Computer(ComputerSpecs spec) {
    this.specs = spec;
  }

  public enum ComputerModel {
    HOME, SERVER
  }
}

class HomeComputer extends Computer {

  public HomeComputer() {
    this(null);
  }

  public HomeComputer(ComputerSpecs spec) {
    super(Optional.ofNullable(spec)
        .orElseGet(ComputerSpecsBuilder::buildStandardSpec));
  }

}

class ServerComputer extends Computer {

  public ServerComputer() {
    this(null);
  }

  public ServerComputer(ComputerSpecs spec) {
    super(Optional.ofNullable(spec)
        .orElseGet(ComputerSpecsBuilder::buildExtendedSpec));
  }

}