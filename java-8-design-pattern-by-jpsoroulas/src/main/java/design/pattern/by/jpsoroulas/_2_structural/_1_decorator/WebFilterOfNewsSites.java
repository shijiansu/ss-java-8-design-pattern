package design.pattern.by.jpsoroulas._2_structural._1_decorator;

import java.util.List;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class WebFilterOfNewsSites extends WebFilterDecorator {

  WebFilterOfNewsSites(WebFilter webFilter) {
    super(webFilter);
  }

  @Override
  List<String> remove(List<String> urls) {
    log.info("Removing of news... ...");
    return urls.stream()
        .filter(url -> !url.contains("news")) // no news
        .collect(Collectors.toList());
  }

  @Override
  public List<String> filter(List<String> urls) {
    log.info("Filtering of news... ...");
    return remove(super.filter(urls));
  }

}
