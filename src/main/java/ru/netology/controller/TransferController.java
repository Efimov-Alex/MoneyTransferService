package ru.netology.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.model.ConfirmInfo;
import ru.netology.model.OperationResponse;
import ru.netology.model.Transfer;
import ru.netology.repository.TransferRepository;
import ru.netology.service.TransferService;

@RestController()
//@CrossOrigin(origins = "https://serp-ya.github.io/card-transfer/", allowedHeaders = "*")
//@CrossOrigin(origins = "http://localhost:3000")
public class TransferController {
    private TransferService transferService;
    public TransferController(){
        TransferRepository repository = new TransferRepository();
        this.transferService = new TransferService(repository);
    }
    @PostMapping("transfer")
    public OperationResponse doTransfer(@RequestBody Transfer transfer){
        return transferService.doTransfer(transfer);
    }
    @PostMapping("confirmOperation")
    public OperationResponse confirmOperation(@RequestBody ConfirmInfo info){
        return transferService.confirmOperation(info);
    }
}
