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

import hms.kite.samples.api.subscription.SubscriptionRequestSender;
import hms.kite.samples.api.subscription.messages.SubscriptionStatusRequest;
import hms.kite.samples.api.subscription.messages.SubscriptionStatusResponse;

import java.io.IOException;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Handle Subscription Status
 */
public class SubscriptionStatusServlet extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 3114744301017537465L;
	private String subscriptionStatus;

    /**
     * Process Received SubscriptionStatus Request
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
	public void doGet(HttpServletRequest request,  HttpServletResponse response)
            throws ServletException, IOException {

        // create subscriptionRequestSender with Subscription Status URL.
        SubscriptionRequestSender subscriptionRequestSender
                = new SubscriptionRequestSender(new URL(SubscriptionKeyBox.SUBSCRIPTION_STATUS_URL));

        // Create SubscriptionRequest with Defined Application Id, Password, Subscriber Mobile Number
        SubscriptionStatusRequest subscriptionStatusRequest = new SubscriptionStatusRequest();
        subscriptionStatusRequest.setApplicationId(SubscriptionKeyBox.APP_ID);
        subscriptionStatusRequest.setPassword(SubscriptionKeyBox.APP_PASSWORD);
        subscriptionStatusRequest.setSubscriberId(SubscriptionKeyBox.MSISDN);

        try {
            // Get SubscriptionStatusResponse and assign Subscription Status to display
            SubscriptionStatusResponse subscriptionStatusResponse
                    = subscriptionRequestSender.sendSubscriptionStatusRequest(subscriptionStatusRequest);
            subscriptionStatus = subscriptionStatusResponse.getSubscriptionStatus();
        } catch (Exception ex) {
            System.out.println("Error occurred due to " + ex);
        }
        response.getWriter().print(subscriptionStatus);
    }
}
