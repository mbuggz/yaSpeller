package enums;

public enum YandexSpellerParameters {
  Param_Text("text"),
  Param_Option("options"),
  Param_Lang("lang");

  private String text;

  YandexSpellerParameters(String text) {
    this.text = text;
  }

  @Override
  public String toString() {
    return text;
  }
}
