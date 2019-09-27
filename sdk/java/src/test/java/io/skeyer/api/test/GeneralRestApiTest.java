package io.skeyer.api.test;

import io.skeyer.api.client.SkeyerApiClientFactory;
import io.skeyer.api.client.SkeyerApiRestClient;
import io.skeyer.api.client.domain.general.BrokerInfo;
import io.skeyer.api.test.constant.Constants;

public class GeneralRestApiTest {

    public static void main(String[] args) {

        SkeyerApiClientFactory factory = SkeyerApiClientFactory.newInstance();
        SkeyerApiRestClient client = factory.newRestClient();

        System.out.println("\n ------BrokerInfo-----");
        BrokerInfo brokerInfo = client.getBrokerInfo();
        System.out.println(brokerInfo);

    }


}
