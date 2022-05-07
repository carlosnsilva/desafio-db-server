package automation.integration.steps;

import io.cucumber.messages.internal.com.google.gson.Gson;
import io.restassured.path.json.JsonPath;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;

public class AbstractStep {

    private String endpoint;
    private RequestSpecification request;
    private Response response;
    protected static final String URL = "https://api-de-tarefas.herokuapp.com/";

    public AbstractStep(String endpoint){
        this.endpoint = URL+endpoint;
    }

    public RequestSpecification configRequest(){
        request = given()
                    .accept(ContentType.JSON)
                    .contentType(ContentType.JSON);

        return request;
    }

    public Response sendRequestGet(){
        response = configRequest().when().get(endpoint);

        return response;
    }

    public Response sendRequestPost(String body){
        RequestSpecification requestPost = configRequest();
        requestPost.header("Content-Type","application/json");
        requestPost.body(body);
        response = requestPost.post(endpoint);

        return response;
    }

    public Response sendRequestPut(String body){
        RequestSpecification requestPut = configRequest();
        requestPut.header("Content-Type","application/json");
        requestPut.body(body);
        response = requestPut.put(endpoint);

        return response;
    }

    public Response sendRequestDel(String idContact){
        RequestSpecification requestDel = configRequest();
        String url = endpoint+"/"+idContact;
        response = requestDel.delete(url);

        return response;
    }

    public String extract(Response response, String field){
        String extracted;

        if(field == null){
            extracted = extractBody(response);
            return extracted;
        }else{
            extracted = extractField(response, field);
            return extracted;
        }
    }

    private String extractBody(Response response){
        return response.body().asString();

    }

    private String extractField(Response response, String field){
        String body = extractBody(response);
        String value = JsonPath.from(body).get(field);

        return value;
    }

    public String searchJson(String json, String type) throws IOException {
        if(type.equals("request")){
            return searchJsonRequest(json);
        }else{
            return searchJsonResponse(json);
        }
    }

    private String searchJsonRequest(String json) throws IOException {
        String jsonRequest = String.join("", Files.readAllLines(Paths.get("src/test/resources/payloadRequest/"+json+".json"), StandardCharsets.UTF_8));

        return jsonRequest;
    }

    private String searchJsonResponse(String json) throws IOException {
        String jsonRequest = String.join("", Files.readAllLines(Paths.get("src/test/resources/payloadResponse/"+json+".json"), StandardCharsets.UTF_8));

        return jsonRequest;
    }

    public Object serializeObjects(String json, Object cls){
        Object result = new Gson().fromJson(json, (Type) cls);

        return result;
    }

    public void saveId(String idContact) throws IOException {
        OutputStream os = new FileOutputStream("src/test/resources/idContact/id.txt");
        Writer wr = new OutputStreamWriter(os);
        BufferedWriter br = new BufferedWriter(wr);

        br.write(idContact);
        br.newLine();
        br.close();
    }

    public String searchArq(String path) throws IOException {
        String arch = String.join("", Files.readAllLines(Paths.get("src/test/resources/idContact/"+path), StandardCharsets.UTF_8));

        return arch;
    }

}
