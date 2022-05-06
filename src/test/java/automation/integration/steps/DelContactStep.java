package automation.integration.steps;

import io.cucumber.java.pt.*;
import io.restassured.response.Response;
import org.testng.Assert;

public class DelContactStep extends AbstractStep{

    private static final String ENDPOINT = "contacts";
    private Response response;
    private String statusCode;
    private String idExecucao;

    public DelContactStep() {
        super(ENDPOINT);
    }

    @Dado("o endpoint DEL api-de-tarefas.herokuapp.com\\contacts {string}, {string}")
    public void o_endpoint_del_api_de_tarefas_herokuapp_com_contacts(String id, String descricao) {
        idExecucao = id;
        System.out.println("Descrição do caso: "+descricao);
    }
    @Quando("envia a requisicao")
    public void envia_a_requisicao() {
        response = sendRequestDel();
    }
    @Entao("retornara statushttp {string}")
    public void retornara_statushttp(String statuscode) {
        statusCode = Integer.toString(response.statusCode());
        Assert.assertEquals(statusCode, statuscode);
    }


}
