package automation.integration.steps;

import io.cucumber.java.pt.*;
import io.restassured.response.Response;
import org.testng.Assert;

import java.io.IOException;

public class PostContactStep extends AbstractStep{

    private static final String ENDPOINT = "contacts";
    private Response response;
    private String statusCode;
    private String idExecucao;
    private String email;
    private Integer number;
    private String idContact;
    int min = 100;
    int max = 600;


    public PostContactStep() {
        super(ENDPOINT);
    }

    @Dado("o endpoint POST api-de-tarefas.herokuapp.com\\contacts {string}, {string}")
    public void o_endpoint_post_api_de_tarefas_herokuapp_com_contacts(String id, String descricao) {
        idExecucao = id;
        System.out.println("Descrição do caso: "+descricao);
        number = (int)(Math.random()*(max-min+1) + min);
        email = "cmns"+Integer.toString(number)+"@gmail.com";

    }
    @Quando("envia a requisicao {string}")
    public void envia_a_requisicao(String payloadRequest) throws IOException {
        response = sendRequestPost(searchJson(payloadRequest,"request").replace("?",email));
    }
    @Entao("retornara statusHttp {string}")
    public void retornara_status_http(String statuscode) {
        String responseBody = extract(response, null);
        System.out.println("Response: "+ responseBody);
        statusCode = Integer.toString(response.statusCode());
        Assert.assertEquals(statusCode, statuscode);
    }

    @Entao("o payload contendo a resposta da requisicao enviada para o endpoint POST https:\\/\\/api-de-tarefas.herokuapp.com\\/contacts {string}")
    public void o_payload_contendo_a_resposta_da_requisicao_enviada_para_o_endpoint_post_https_api_de_tarefas_herokuapp_com_contacts(String payloadResponse) throws IOException {
        idContact = extract(response, "data.id");
        String payloadEstatico = searchJson(payloadResponse, "response").replace("?",email).replace("!",idContact);
        String payloadDinamico = response.asString();

        Assert.assertEquals(payloadDinamico, payloadEstatico);
    }
}
