package core;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.apache.http.HttpStatus;
import model.YandexSpeller;

import java.util.HashMap;
import java.util.List;
import java.util.Random;

import static org.hamcrest.Matchers.lessThan;
import static utils.TestProperties.getSpellerUrl;

public class YandexSpellerApi {
  private HashMap<String, String> params = new HashMap<>();

  public HashMap<String, String> getParams() {
    return params;
  }

  private YandexSpellerApi() {}

  public static ApiBuilder with() {
    YandexSpellerApi api = new YandexSpellerApi();
    return new ApiBuilder(api);
  }

  //get ready Speller answers list form api response
  public static List<YandexSpeller> getYandexSpellerAnswers(Response response) {
    return new Gson().fromJson(response.asString().trim(),
        new TypeToken<List<YandexSpeller>>() {}.getType());
  }

  //set base request and response specifications tu use in tests
  public static ResponseSpecification successResponse() {
    return new ResponseSpecBuilder()
               .expectContentType(ContentType.JSON)
               .expectHeader("Connection", "keep-alive")
               .expectResponseTime(lessThan(20000L))
               .expectStatusCode(HttpStatus.SC_OK)
               .build();
  }

  public static RequestSpecification baseRequestConfiguration() {
    return new RequestSpecBuilder()
               .setAccept(ContentType.XML)
               .addHeader("custom header2", "header2.value")
               .addQueryParam("requestID", new Random().nextLong())
               .setBaseUri(getSpellerUrl())
               .build();
  }
}
