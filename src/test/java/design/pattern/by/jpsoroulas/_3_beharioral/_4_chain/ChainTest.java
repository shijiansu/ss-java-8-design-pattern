package design.pattern.by.jpsoroulas._3_beharioral._4_chain;

import design.pattern.by.jpsoroulas.AbstractTest;
import design.pattern.by.jpsoroulas._3_beharioral._4_chain.ItSupportRequest.RequestType;
import java.util.Arrays;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.Validate;
import org.testng.Assert;
import org.testng.annotations.Test;

@Slf4j
public class ChainTest extends AbstractTest {

  public ItSupport non_lambda_init_chain_1() {
    return new ItSupportOf1stLevel(new ItSupportOf2ndLevel(new ItSupportOf3rdLevel()));
  }

  public ItSupport non_lambda_init_chain_2() {
    return Arrays.stream(new ItSupport[]{
        new ItSupportOf1stLevel(), new ItSupportOf2ndLevel(), new ItSupportOf3rdLevel()
    }).reduce((f, n) -> { // reduce to the handler that chains all handlers together
      // f -> current; n -> next;
      ItSupport target = f.getNextSupport();
      if (null == target) {
        target = f; // first level
      }
      target.setNextSupport(n); // setup as next support
      return f;
    }).get();
  }

  public ItSupport non_lambda_init_chain_3() {
    return Stream.<Supplier<ItSupport>>of(
        ItSupportOf1stLevel::new, ItSupportOf2ndLevel::new, ItSupportOf3rdLevel::new)
        .map(Supplier::get) // create the handler instance
        .reduce((f, n) -> { // reduce to the handler that chains all handlers together
          ItSupport target = f.getNextSupport();
          if (null == target) {
            target = f;
          }
          target.setNextSupport(n);
          return f;
        }).get();
  }

  @Test
  public void non_lambda_chain() {
    ItSupport supportChain = non_lambda_init_chain_3();
    // only level 2 support
    ItSupportRequest request = new ItSupportRequest(RequestType.LEVEL2);
    supportChain.handle(request);
    Assert.assertTrue(request.isHandled(), "The request should be handled");
  }

  @Test(expectedExceptions = {UnsupportedRequestException.class})
  public void non_lambda_chain_unsolved() {
    ItSupport supportChain = non_lambda_init_chain_3();
    // level 4 support is unsolved
    ItSupportRequest request = new ItSupportRequest(RequestType.LEVEL4);
    supportChain.handle(request);
  }

  private Function<ItSupportRequest, ItSupportRequest> initChainLambda() {
    // handler wrapper function that decides whether the actual handler should be invoked or not
    UnaryOperator<Function<ItSupportRequest, ItSupportRequest>> handlerWrapper =
        f -> r -> {
          Validate.notNull(r, "Support request is required!");
          if (r.isHandled()) { // do not invoke the handler if the support request is handled
            return r; // just return the already handled support request
          }
          return f.apply(r); // otherwise invoke the handler
        };

    // create a final handler that throws an UnsupportedRequestException
    // when the support request is not handled
    Function<ItSupportRequest, ItSupportRequest> hanldedChecker =
        r -> {
          if (r.isHandled()) { // if the support request is finally handled, just return the request
            return r;
          } // otherwise, throw an exception
          throw new UnsupportedRequestException(r.getType().toString());
        };

    return Stream.of(
        handlerWrapper.apply(ItSupportHandlerAlgorithms::firstLevelSupport),
        handlerWrapper.apply(ItSupportHandlerAlgorithms::secondLevelSupport),
        handlerWrapper.apply(ItSupportHandlerAlgorithms::thirdLevelSupport),
        hanldedChecker)
        .reduce(Function.identity(), Function::andThen);
  }

  @Test
  public void lambda_chain() {
    Function<ItSupportRequest, ItSupportRequest> supportChainLambda = initChainLambda();
    ItSupportRequest request = new ItSupportRequest(RequestType.LEVEL2);
    supportChainLambda.apply(request);
    Assert.assertTrue(request.isHandled(), "The request should be handled");
  }

  @Test(expectedExceptions = {UnsupportedRequestException.class})
  public void lambda_chain_unsolved() {
    Function<ItSupportRequest, ItSupportRequest> supportChainLambda = initChainLambda();
    ItSupportRequest request = new ItSupportRequest(RequestType.LEVEL4);
    supportChainLambda.apply(request);
  }

}
