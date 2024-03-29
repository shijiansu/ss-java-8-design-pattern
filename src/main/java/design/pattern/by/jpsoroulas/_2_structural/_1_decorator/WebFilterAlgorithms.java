package design.pattern.by.jpsoroulas._2_structural._1_decorator;

import java.util.List;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public interface WebFilterAlgorithms {

  Logger log = LoggerFactory.getLogger(WebFilterAlgorithms.class);

  static List<String> removeSocialNetworks(List<String> urls) {
    log.info("Removing of social media... ...");
    return urls.stream()
        .filter(url -> !(url.contains("facebook")
            || url.contains("twitter")))
        .collect(Collectors.toList());
  }

  static List<String> removeWebMails(List<String> urls) {
    log.info("Removing of web mails... ...");
    return urls.stream()
        .filter(url -> !url.contains("mail"))
        .collect(Collectors.toList());
  }

  static List<String> removeNewsSites(List<String> urls) {
    log.info("Removing of news... ...");
    return urls.stream()
        .filter(url -> !url.contains("news"))
        .collect(Collectors.toList());
  }

}
