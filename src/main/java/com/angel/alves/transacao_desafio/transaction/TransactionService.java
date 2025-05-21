package com.angel.alves.transacao_desafio.transaction;

import com.angel.alves.transacao_desafio.wallet.Wallet;
import com.angel.alves.transacao_desafio.wallet.WalletRepository;
import com.angel.alves.transacao_desafio.wallet.WalletType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransactionService {

    private final WalletRepository walletRepository;
    private final TransactionRepository transactionRepository;


    public TransactionService(WalletRepository walletRepository, TransactionRepository transactionRepository) {
        this.walletRepository = walletRepository;
        this.transactionRepository = transactionRepository;
    }

    @Transactional
    public Transaction createTransaction(Transaction transaction){
        validate(transaction);

        var newTransaction = transactionRepository.save(transaction);

        // 3 debitar e creditar e salvar
        // pagador
        var walletPayer = walletRepository.findById(transaction.payer());

        // recebedor
        var walletPayee = walletRepository.findById(transaction.payee());


        // 4  autorizar

        // 5 notificar

        return transaction;
    }


    public void validate(Transaction transaction){
        walletRepository.findById(transaction.payee()).map(
                payee -> walletRepository.findById(transaction.payer()).
                        map( payer -> isTransactionValid(transaction, payer) ? transaction : null
                ).orElseThrow(() -> new RuntimeException("Dont pass"))
        ).orElseThrow(() -> new RuntimeException("Payee not found"));
    }
    
    public boolean isTransactionValid(Transaction transaction, Wallet payer){
        return payer.type() == WalletType.COMUM.getValue()
                && payer.balance().compareTo(transaction.value()) >= 0 &&
                payer.id() != transaction.payee();
    }
}
