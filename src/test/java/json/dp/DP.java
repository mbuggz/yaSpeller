package json.dp;

import org.testng.annotations.DataProvider;
import static enums.YandexSpellerLanguage.EN;
import static enums.YandexSpellerLanguage.RU;
import static enums.YandexSpellerLanguage.UK;

public class DP {
  @DataProvider
  public static Object[][] simpleWord() {
    return new Object[][]{
        {EN, "window"},
        {RU, "окно"},
        {UK, "вiкно"}
    };
  }

  @DataProvider
  public static Object[][] digitInWord() {
    return new Object[][]{
        {"11window", "11 window"},
        {"win11dow", "window"},
        {"window11", "window 11"}
    };
  }
}
