package com.angel.alves.transacao_desafio.wallet;

import org.springframework.stereotype.Service;

@Service
public class WalletService {

    private final WalletRepository walletRepository;

    public WalletService(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }

    public void save(Wallet wallet){
        walletRepository.save(wallet);
    }
}
