package automation.integration.steps;

import io.cucumber.java.pt.*;
import io.restassured.response.Response;
import org.testng.Assert;
import java.io.IOException;

public class GetContactStep extends AbstractStep{

    private static final String ENDPOINT = "contacts/1542";
    private Response response;
    private String statusCode;
    private String idExecucao;
    private String email;
    private Integer number;
    private String idContact;

    public GetContactStep() {
        super(ENDPOINT);
    }

    @Dado("o endpoint GET api-de-tarefas.herokuapp.com\\contacts {string}, {string}")
    public void o_endpoint_get_api_de_tarefas_herokuapp_com_contacts(String id, String descricao) {
        idExecucao = id;
        System.out.println("Descrição do caso: "+descricao);
    }
    @Quando("a requisicao e enviada")
    public void a_requisicao_e_enviada() {
        response = sendRequestGet();
    }
    @Entao("retornara statushttP {string}")
    public void retornara_statushtt_p(String statuscode) {
        statusCode = Integer.toString(response.statusCode());
        Assert.assertEquals(statusCode, statuscode);

    }
    @Entao("o payload contendo a resposta da requisicao enviada para o endpoint GET api-de-tarefas.herokuapp.com\\contacts {string}")
    public void o_payload_contendo_a_resposta_da_requisicao_enviada_para_o_endpoint_get_api_de_tarefas_herokuapp_com_contacts(String payloadResponse) throws IOException {
        String payloadDinamico = response.asString();
        String payloadEstatico = searchJson(payloadResponse,"response");

        Assert.assertEquals(payloadDinamico, payloadEstatico);
    }

}
