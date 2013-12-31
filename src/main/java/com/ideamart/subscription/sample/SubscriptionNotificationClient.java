/*
 *   (C) Copyright 2010-2013 hSenid Mobile Solutions (Pvt) Limited
 *   All Rights Reserved.
 *
 *   These materials are unpublished, proprietary, confidential source code of
 *   hSenid Mobile Solutions (Pvt) Limited and constitute a TRADE SECRET
 *   of hSenid Mobile Solutions (Pvt) Limited.
 *
 *   hSenid Mobile Solutions (Pvt) Limited retains all title to and intellectual
 *   property rights in these materials.
 *
 */

package com.ideamart.subscription.sample;



import hms.kite.samples.api.subscription.SubscriptionNotificationListener;
import hms.kite.samples.api.subscription.messages.SubscriptionNotification;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;

/**
 * Handle Receiving SubscriptionNotification
 */
public class SubscriptionNotificationClient extends SubscriptionNotification implements SubscriptionNotificationListener {

    public static String subNotification;
    public static List<String> subNotificationList = new ArrayList<String>();

    /**
     * Initialization
     * @param servletConfig
     */
    @Override
    public void init(ServletConfig servletConfig) {
    }

    /**
     * Receive Subscription Notification from SDP
     * @param subscriptionNotification
     */
    @Override
    public void onReceivedSubscription(SubscriptionNotification subscriptionNotification) {
        System.out.println("Subscription Notification Received  =======>>: " + subscriptionNotification.toString() );
        subNotification = subscriptionNotification.toString();
        subNotificationList.add(subNotification);
    }

}