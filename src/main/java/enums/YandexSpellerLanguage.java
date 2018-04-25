package enums;

public enum YandexSpellerLanguage {
  RU("ru"),
  UK("uk"),
  EN("en");

  public String languageCode;

  YandexSpellerLanguage(String lang) {
    this.languageCode = lang;
  }
}
