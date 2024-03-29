package design.pattern.by.jpsoroulas._2_structural._1_decorator;

import java.util.List;

abstract class WebFilterDecorator implements WebFilter {

  abstract List<String> remove(List<String> urls);

  private WebFilter webFilter;

  WebFilterDecorator(WebFilter webFilter) {
    this.webFilter = webFilter;
  }

  @Override
  public List<String> filter(List<String> urls) {
    if (webFilter != null) {
      return webFilter.filter(urls);
    }
    return urls;
  }
}
