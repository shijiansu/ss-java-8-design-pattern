package design.pattern.by.jpsoroulas._1_creational._1_factory;

import design.pattern.by.jpsoroulas._1_creational._1_factory.ComputerFactories.ComputerFactory;
import design.pattern.by.jpsoroulas._1_creational._1_factory.ComputerFactories.LambdaComputerFactory;
import design.pattern.by.jpsoroulas.AbstractTest;
import design.pattern.by.jpsoroulas._1_creational._1_factory.Computer.ComputerModel;
import design.pattern.by.jpsoroulas._1_creational._1_factory.ComputerSpecs.ComputerSpecsBuilder;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class ComputerFactoriesTest extends AbstractTest {

  public void non_lambda_factory_create_home_computer() {
    Computer computer = ComputerFactory.create(ComputerModel.HOME);
    ComputerSpecs spec = computer.getSpecs(); // inside HomeComputer, it is standard specification
    ComputerSpecs sdSpec = ComputerSpecsBuilder.buildStandardSpec();
    Assert.assertEquals(spec, sdSpec, "Unexpected specs");
  }

  public void lambda_factory_create_server_computer() {
    Computer computer = LambdaComputerFactory.createLambda(ComputerModel.SERVER);
    ComputerSpecs spec = computer.getSpecs();
    ComputerSpecs exSpec = ComputerSpecsBuilder.buildExtendedSpec();
    Assert.assertEquals(spec, exSpec, "Unexpected specs");
  }

  public void compare_factories() {
    Computer computer = ComputerFactory.create(ComputerModel.SERVER);
    Computer computer2 = LambdaComputerFactory.createLambda(ComputerModel.SERVER);
    Assert.assertEquals(computer, computer2, "Unexpected computer");
  }
}
