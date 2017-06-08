package com.mrclbndr.jms_demo.commons.adapter.messaging.impl;

import javax.annotation.Resource;
import javax.enterprise.context.Dependent;
import javax.inject.Named;
import javax.jms.Destination;
import javax.jms.JMSConsumer;
import javax.jms.JMSContext;

@Named
@Dependent
public class QueueOrderReceiver extends AbstractOrderReceiver {
    @Resource(lookup = "jms/NewOrdersQueue")
    private Destination newOrders;

    @Override
    JMSConsumer createConsumer(JMSContext jmsContext) {
        return jmsContext.createConsumer(newOrders);
    }
}