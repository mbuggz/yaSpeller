package json;

import core.YandexSpellerApi;
import json.dp.DP;
import model.YandexSpeller;
import enums.YandexSpellerLanguage;
import org.testng.annotations.Test;

import java.util.List;

import static core.YandexSpellerApi.successResponse;
import static enums.YandexSpellerLanguage.EN;
import static enums.YandexSpellerOptions.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;


public class TestYandexSpeller {

  @Test(dataProviderClass = DP.class, dataProvider = "simpleWord")
  public void checkSimpleWord(YandexSpellerLanguage lang, String word) {
    YandexSpellerApi
        .with()
        .language(lang)
        .text(word)
        .callApi()
        .then()
        .specification(successResponse());
  }

  @Test(dataProviderClass = DP.class, dataProvider = "digitInWord")
  public void checkErrorWordWithDigit(String wrongWord, String rightWord) {
    List<YandexSpeller> answers =
        YandexSpellerApi.getYandexSpellerAnswers(
            YandexSpellerApi
                .with()
                .language(EN)
                .text(wrongWord)
                .callApi());
    assertThat(answers.get(0).getSuggestion().get(0), equalTo(rightWord));
  }

  @Test
  public void optionsValueIgnoreDigits(){
    List<YandexSpeller> answers =
        YandexSpellerApi.getYandexSpellerAnswers(
            YandexSpellerApi
                .with()
                .text("11window")
                .options(IGNORE_DIGITS)
                .callApi());
    assertThat("Expected number of answers is wrong.", answers.size(), equalTo(0));
  }

  @Test
  public void optionsIgnoreWrongCapital(){
    List<YandexSpeller> answers =
        YandexSpellerApi.getYandexSpellerAnswers(
            YandexSpellerApi
                .with()
                .text("moscow")
                .options(IGNORE_CAPITALIZATION)
                .callApi());
    assertThat("Expected number of answers is wrong.", answers.size(), equalTo(0));
  }

  @Test
  public void optionsIgnoreWrongUri(){
    List<YandexSpeller> answers =
        YandexSpellerApi.getYandexSpellerAnswers(
            YandexSpellerApi
                .with()
                .text("http://moscow.com")
                .options(IGNORE_URLS)
                .callApi());
    assertThat("Expected number of answers is wrong.", answers.size(), equalTo(0));
  }

  @Test
  public void validateSpellerAnswerAsAnObject(){
    List<YandexSpeller> answers =
        YandexSpellerApi.getYandexSpellerAnswers(
            YandexSpellerApi.with()
                .language(EN)
                .text("motherr fatherr,").callApi());

    assertThat("expected number of answers is wrong.", answers.size(), equalTo(2));
    assertThat(answers.get(0).getWord(), equalTo("motherr"));
    assertThat(answers.get(1).getWord(), equalTo("fatherr"));
    assertThat(answers.get(0).getSuggestion().get(0), equalTo("mother"));
    assertThat(answers.get(1).getSuggestion().get(0), equalTo("father"));
  }
}

