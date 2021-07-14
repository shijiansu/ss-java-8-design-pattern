package design.pattern.by.jpsoroulas._2_structural._1_decorator;

import static org.testng.Assert.assertEquals;

import design.pattern.by.jpsoroulas.AbstractTest;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;
import org.testng.annotations.Test;

public class WebFilterDecoratorTest extends AbstractTest {

  private final List<String> URLs = Arrays.asList(
      "https://www.facebook.com/",
      "https://twitter.com/",
      "https://mail.google.com",
      "http://www.bbc.com/news",
      "http://www.a.site/");

  @Test
  public void non_lambda_filters_of_social_media() {
    WebFilter firstFilter = new WebFilterOfSocialNetworks();
    assertEquals(firstFilter.filter(URLs).size(), 3,
        "Only social media sites should be filtered");
  }

  @Test
  public void non_lambda_filters_of_all() {
    WebFilter firstFilter = new WebFilterOfSocialNetworks();
    WebFilter decorator = new WebFilterOfNewsSites(new WebFilterOfWebMails(firstFilter));
    assertEquals(decorator.filter(URLs).size(), 1,
        "Social media, web mail and news sites should be filtered");
  }

  @Test
  public void lambda_filters_of_social_media() {
    Function<List<String>, List<String>> filter = WebFilterAlgorithms::removeSocialNetworks;
    assertEquals(filter.apply(URLs).size(), 3,
        "Only social media sites should be filtered");
  }

  @Test
  public void lambda_filters_of_all() {
    // put class type after of, otherwise cannot be recognize
    Function<List<String>, List<String>> filterDecorator = Stream.<Function<List<String>, List<String>>>of(
        WebFilterAlgorithms::removeSocialNetworks,
        WebFilterAlgorithms::removeWebMails,
        WebFilterAlgorithms::removeNewsSites)
        .reduce((f, n) -> n.compose(f)) // here is binding. compose is FUNCTION, put next before first to execution
        .get();
    assertEquals(filterDecorator.apply(URLs).size(), 1,
        "Social media, web mail and news sites should be filtered");
  }
}
