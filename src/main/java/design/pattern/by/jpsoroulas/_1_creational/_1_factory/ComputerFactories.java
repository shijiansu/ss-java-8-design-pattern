package design.pattern.by.jpsoroulas._1_creational._1_factory;

import design.pattern.by.jpsoroulas._1_creational._1_factory.Computer.ComputerModel;
import java.util.EnumMap;
import java.util.function.Supplier;

public class ComputerFactories {

  abstract static class ComputerFactory {

    public static Computer create(ComputerModel model) {
      Computer computer;
      switch (model) {
        case HOME:
          computer = new HomeComputer();
          break;
        case SERVER:
          computer = new ServerComputer();
          break;
        default:
          throw new IllegalStateException("Model " + model + " is not available yet!");
      }
      return computer;
    }
  }

  abstract static class LambdaComputerFactory { // use abstract class then no require private constructor

    private static final EnumMap<ComputerModel, Supplier<Computer>> customComputers =
        new EnumMap<>(ComputerModel.class);

    static {
      customComputers.put(ComputerModel.HOME, HomeComputer::new);
      customComputers.put(ComputerModel.SERVER, ServerComputer::new);
    }

    static Computer createLambda(ComputerModel model) {
      return customComputers
          .get(model) // get Supplier, it the "new"
          .get(); // Supplier.get, same as execution of method
    }
  }
}
