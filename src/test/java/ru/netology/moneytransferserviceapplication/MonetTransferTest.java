package ru.netology.moneytransferserviceapplication;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.testcontainers.containers.GenericContainer;
import ru.netology.model.Amount;
import ru.netology.model.ConfirmInfo;
import ru.netology.model.OperationResponse;
import ru.netology.model.Transfer;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MonetTransferTest {
    @Autowired
    TestRestTemplate restTemplate;


    private static GenericContainer<?> devapp = new GenericContainer<>("devapp")
            .withExposedPorts(8080);

    @BeforeAll
    public static void setUp() {
        devapp.start();
    }

    @Test
    void transferTest() {
        Transfer transfer = new Transfer(
                new Amount("RUB", 200F),
                "123",
                "1234123412341234",
                "12/23",
                "5678567856785678"
        );
        OperationResponse response = restTemplate.postForObject("http://192.168.99.101:" +
                devapp.getMappedPort(8080) + "/transfer",transfer, OperationResponse.class);
        Assertions.assertEquals(response.getOperationId(), "1");

    }

    @Test
    void confirmTest() {
        ConfirmInfo confirmInfo = new ConfirmInfo();
        confirmInfo.setOperationId("1");
        confirmInfo.setCode("200");


        OperationResponse response = restTemplate.postForObject("http://192.168.99.101:" +
                devapp.getMappedPort(8080) + "/confirmOperation",confirmInfo, OperationResponse.class);
        Assertions.assertEquals(response.getOperationId(), null);

    }




}
