package model;

//interface xử lý nghiệp vụ chuyển tiền
public interface ITransfer {
    boolean transfer(Account receiveAccount, Double amount, boolean isPremium);
}
