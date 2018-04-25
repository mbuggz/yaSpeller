package core;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import enums.YandexSpellerLanguage;
import enums.YandexSpellerOptions;

import static enums.YandexSpellerParameters.Param_Lang;
import static enums.YandexSpellerParameters.Param_Option;
import static enums.YandexSpellerParameters.Param_Text;
import static utils.TestProperties.getSpellerUrl;

public class ApiBuilder {
  YandexSpellerApi spellerApi;

  public ApiBuilder(YandexSpellerApi gcApi) {
    spellerApi = gcApi;
  }

  public ApiBuilder text(String text) {
    spellerApi.getParams().put(Param_Text.toString(), text);
    return this;
  }

  public ApiBuilder options(YandexSpellerOptions options) {
    spellerApi.getParams().put(Param_Option.toString(), options.toString());
    return this;
  }

  public ApiBuilder language(YandexSpellerLanguage language) {
    spellerApi.getParams().put(Param_Lang.toString(), language.languageCode);
    return this;
  }

  public Response callApi() {
    return RestAssured.with()
               .queryParams(spellerApi.getParams())
               .log()
               .all()
               .get(getSpellerUrl())
               .prettyPeek();
  }
}
