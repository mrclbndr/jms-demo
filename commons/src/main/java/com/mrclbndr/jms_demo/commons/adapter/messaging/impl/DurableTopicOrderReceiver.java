package com.mrclbndr.jms_demo.commons.adapter.messaging.impl;

import javax.annotation.Resource;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSConsumer;
import javax.jms.JMSContext;
import javax.jms.Topic;

@Named
@Dependent
public class DurableTopicOrderReceiver extends AbstractOrderReceiver {
    @Inject
    @JMSConnectionFactory("jms/AppConnectionFactory")
    private JMSContext jmsContext;

    @Resource(lookup = "jms/NewOrdersTopic")
    private Topic newOrders;

    @Override
    JMSConsumer createConsumer() {
        return jmsContext.createDurableConsumer(newOrders, configuration.subscriptionName());
    }
}
