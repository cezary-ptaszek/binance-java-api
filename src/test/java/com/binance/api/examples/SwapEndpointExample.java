package com.binance.api.examples;

import com.binance.api.client.BinanceApiClientFactory;
import com.binance.api.client.BinanceApiSwapRestClient;
import com.binance.api.client.domain.account.*;
import com.binance.api.examples.constants.PrivateConfig;

import java.util.List;

public class SwapEndpointExample {

    public static void main(String[] args) {

        BinanceApiClientFactory binanceApiClientFactory = BinanceApiClientFactory.newInstance(PrivateConfig.API_KEY, PrivateConfig.SECRET_KEY);
        BinanceApiSwapRestClient swapClient = binanceApiClientFactory.newSwapRestClient();
        List<Pool> pools = swapClient.listAllSwapPools();
        for(Pool pool:pools) {
            System.out.println(pool);
            Liquidity poolLiquidityInfo = swapClient.getPoolLiquidityInfo(pool.getPoolId());
            System.out.println(poolLiquidityInfo);
        }
        SwapQuote swapQuote = swapClient.requestQuote("USDT", "USDC", "10");
        System.out.println(swapQuote);
        SwapRecord swapRecord = swapClient.swap("USDT", "USDC", "10");
        SwapHistory swapHistory = swapClient.getSwapHistory(swapRecord.getSwapId());
        System.out.println(swapHistory);
    }


}
