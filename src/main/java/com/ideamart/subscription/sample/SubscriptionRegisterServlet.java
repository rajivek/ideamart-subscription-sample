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


import hms.kite.samples.api.SdpException;
import hms.kite.samples.api.subscription.SubscriptionRequestSender;
import hms.kite.samples.api.subscription.messages.SubscriptionRequest;
import hms.kite.samples.api.subscription.messages.SubscriptionResponse;

import java.io.IOException;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Handle Subscription Registration
 */
public class SubscriptionRegisterServlet extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 9075628872410660834L;
	private String subscriptionRegisterStatus;

    /**
     * Process Received Subscription Register Request
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
	public void doGet(HttpServletRequest request,  HttpServletResponse response)
            throws ServletException, IOException {

        // create subscriptionRequestSender with Subscription Message URL.
        SubscriptionRequestSender subscriptionRequestSender =
                new SubscriptionRequestSender(new URL(SubscriptionKeyBox.SUBSCRIPTION_MESSAGE_URL));

        // Create SubscriptionRequest with Defined Application Id, Password, Subscriber Mobile Number, Action(1- OPT_IN), Version.
        /* NOTE :SDP simulator only checks the status assigned in Subscription UI (Assign Subscription Details - Status)
         without considering the Action  1- OPT_IN/ 0- OPT_OUT. when processing Subscription Register/UnRegister*/
        SubscriptionRequest subscriptionRequest = new SubscriptionRequest();
        subscriptionRequest.setApplicationId(SubscriptionKeyBox.APP_ID);
        subscriptionRequest.setPassword(SubscriptionKeyBox.APP_PASSWORD);
        subscriptionRequest.setSubscriberId(SubscriptionKeyBox.MSISDN);
        subscriptionRequest.setAction(SubscriptionKeyBox.REG_ACTION);
        subscriptionRequest.setVersion(SubscriptionKeyBox.VERSION);

        try {
            // Get SubscriptionResponse and assign Subscription Register Status to display
            SubscriptionResponse subscriptionResponse
                    = subscriptionRequestSender.sendSubscriptionRequest(subscriptionRequest);
            subscriptionRegisterStatus = subscriptionResponse.getStatusDetail();
        } catch (SdpException e) {
            System.out.println("Error Occurred due to" + e);
        }
        response.getWriter().print(subscriptionRegisterStatus);
    }

}
