package ru.netology.repository;

import org.springframework.stereotype.Repository;
import ru.netology.model.Transfer;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class TransferRepository {
    private HashMap<String, String> transferStateMap;
    private HashMap<String, Transfer> transferList;
    private AtomicInteger id;
    public TransferRepository(){
        this.transferStateMap = new HashMap<>();
        this.transferList = new HashMap<>();
        id = new AtomicInteger(0);
    }
    public String addTransfer(Transfer transfer){
        String transferId = String.valueOf(id.incrementAndGet());
        transferStateMap.put(String.valueOf(transferId), "LOAD");
        transferList.put(String.valueOf(transferId), transfer);
        return transferId;
    }
    public Transfer confirmOperation(String id){
        if(!transferStateMap.containsKey(id)){
            return null;
        }
        transferStateMap.put(id, "OK");
        return transferList.get(id);
    }
    public Transfer errorConfirmOperation(String id){
        if(!transferStateMap.containsKey(id)){
            return null;
        }
        transferStateMap.put(id, "ERROR");
        return transferList.get(id);
    }
    public String getTransferState(String id){
        return transferStateMap.get(id);
    }
}
