package utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListUtils {
  public static boolean equalLists(List<String> one, List<String> two){
    if (one == null && two == null){
      return true;
    }

    if((one == null && two != null)
           || one != null && two == null
           || one.size() != two.size()){
      return false;
    }
    one = new ArrayList<String>(one);
    two = new ArrayList<String>(two);

    Collections.sort(one);
    Collections.sort(two);
    return one.equals(two);
  }
}
