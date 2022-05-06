package automation.integration.steps;

import io.restassured.specification.RequestSpecification;

public class AbstractStep {

    private String endpoint;
    private RequestSpecification request;
    private Response response;
}
