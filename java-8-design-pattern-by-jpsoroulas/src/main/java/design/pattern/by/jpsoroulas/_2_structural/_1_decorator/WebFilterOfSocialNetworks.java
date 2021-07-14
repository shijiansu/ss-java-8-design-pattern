package design.pattern.by.jpsoroulas._2_structural._1_decorator;

import java.util.List;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class WebFilterOfSocialNetworks extends WebFilterDecorator {

  WebFilterOfSocialNetworks() {
    super(null);
  }

  @Override
  List<String> remove(List<String> urls) {
    log.info("Removing of social media... ...");
    return urls.stream()
        .filter(url -> !(url.contains("facebook") || url.contains("twitter")))
        .collect(Collectors.toList());
  }

  @Override
  public List<String> filter(List<String> urls) {
    log.info("Filtering of social media... ...");
    return remove(super.filter(urls));
  }

}
