package ru.netology.service;

import org.springframework.stereotype.Service;
import ru.netology.exception.ErrorOperation;
import ru.netology.exception.InvalidDataException;
import ru.netology.logger.Logger;
import ru.netology.logger.LoggerImpl;
import ru.netology.model.ConfirmInfo;
import ru.netology.model.OperationResponse;
import ru.netology.model.Transfer;
import ru.netology.repository.TransferRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

@Service
public class TransferService {
    private TransferRepository transferRepository;
    private Logger logger;
    public TransferService(TransferRepository transferRepository){
        this.transferRepository = transferRepository;
        logger = LoggerImpl.getInstance();
    }
    public OperationResponse doTransfer(Transfer transfer){
        checkValid(transfer);
        transfer.setDate(LocalDate.now().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)));
        transfer.setTime(LocalTime.now().format(DateTimeFormatter.ofPattern("HH.mm.ss.nnn")));
        String id = transferRepository.addTransfer(transfer);
        logger.log("Try: " + transfer);
        return new OperationResponse(id);
    }
    public OperationResponse confirmOperation(ConfirmInfo info){
        checkValid(info);
        Transfer transfer;
        if (info.getCode().equals("000")) {
            transfer = transferRepository.confirmOperation(info.getOperationId());
            if (transfer == null) {
                throw new ErrorOperation("Error confirm : " + info);
            }
            logger.log("Confirm: " + transfer);
        } else {
            transfer = transferRepository.errorConfirmOperation(info.getOperationId());
            if (transfer == null) {
                throw new ErrorOperation("Error  errorConfirm : " + info);
            }
            logger.log("Error confirm: " + transfer);
        }
        return new OperationResponse(info.getOperationId() + "");
    }
    private void checkValid(Transfer transfer){
        StringBuilder msg = new StringBuilder();
        boolean flag = true;
        if (transfer.getCardFromCVV() == null || transfer.getCardFromCVV().length() == 0) {
            msg.append("Invalid CardFromCVV ");
            flag = false;
        }
        if (transfer.getCardFromNumber() == null || transfer.getCardFromNumber().length() == 0) {
            msg.append("Invalid CardFromNumber ");
            flag = false;
        }
        if (transfer.getCardFromValidTill() == null || transfer.getCardFromValidTill().length() == 0) {
            msg.append("Invalid CardFromValidTill ");
            flag = false;
        }
        if (transfer.getCardToNumber() == null || transfer.getCardToNumber().length() == 0) {
            msg.append("Invalid CardToNumber ");
            flag = false;
        }
        if (transfer.getAmount() == null || transfer.getAmount().getValue() < 0 ||
                transfer.getAmount().getCurrency().length() == 0) {
            msg.append("Invalid CardToNumber ");
            flag = false;
        }
        if (!flag) {
            throw new InvalidDataException("Invalid transfer :" + msg);
        }
    }
    private void checkValid(ConfirmInfo info){
        StringBuilder msg = new StringBuilder();
        boolean flag = true;
        if (info.getCode() == null || info.getCode().length() == 0) {
            msg.append("Invalid code");
            flag = false;
        }
        if (info.getOperationId() == null || info.getOperationId().length() == 0) {
            msg.append("Invalid OperationId ");
            flag = false;
        }
        if (!flag) {
            throw new InvalidDataException("Invalid confirm :" + msg);
        }
    }
}