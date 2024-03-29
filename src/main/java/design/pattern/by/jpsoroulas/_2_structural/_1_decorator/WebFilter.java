package design.pattern.by.jpsoroulas._2_structural._1_decorator;

import java.util.List;

@FunctionalInterface
public interface WebFilter {

  List<String> filter(List<String> urls);

}


