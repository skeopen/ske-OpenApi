package io.skeyer.api.test;

import io.skeyer.api.client.SkeyerApiClientFactory;
import io.skeyer.api.client.SkeyerApiRestClient;
import io.skeyer.api.client.constant.SkeyerConstants;
import io.skeyer.api.test.constant.Constants;

public class UserDataStreamRestApiTest {

    public static void main(String[] args) {

        SkeyerApiClientFactory factory = SkeyerApiClientFactory.newInstance(Constants.ACCESS_KEY, Constants.SECRET_KEY);
        SkeyerApiRestClient client = factory.newRestClient();

        System.out.println("\n ------start user data stream-----");
        String listenKey = client.startUserDataStream(SkeyerConstants.DEFAULT_RECEIVING_WINDOW, System.currentTimeMillis());
        System.out.println(listenKey);

        System.out.println("\n ------keepAlive user data stream-----");
        client.keepAliveUserDataStream(listenKey, SkeyerConstants.DEFAULT_RECEIVING_WINDOW, System.currentTimeMillis());

        System.out.println("\n ------close user data stream-----");
        client.closeUserDataStream(listenKey, SkeyerConstants.DEFAULT_RECEIVING_WINDOW, System.currentTimeMillis());

    }

}
