package design.pattern.by.jpsoroulas._2_structural._1_decorator;

import java.util.List;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class WebFilterOfWebMails extends WebFilterDecorator {

  WebFilterOfWebMails(WebFilter webFilter) {
    super(webFilter);
  }

  @Override
  List<String> remove(List<String> urls) {
    log.info("Removing of web mails... ...");
    return urls.stream()
        .filter(url -> !url.contains("mail"))
        .collect(Collectors.toList());
  }

  @Override
  public List<String> filter(List<String> urls) {
    log.info("Filtering of web mails... ...");
    return remove(super.filter(urls));
  }

}
