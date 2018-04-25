package enums;

public enum YandexSpellerOptions {
  IGNORE_DIGITS("2"),
  IGNORE_URLS("4"),
  FIND_REPEAT_WORDS("8"),
  IGNORE_CAPITALIZATION("512");

  private String text;

  YandexSpellerOptions(String text) {
    this.text = text;
  }

  @Override
  public String toString() {
    return text;
  }
}
