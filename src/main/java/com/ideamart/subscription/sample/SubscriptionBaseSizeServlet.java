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
import hms.kite.samples.api.subscription.messages.SubQueryBaseRequest;
import hms.kite.samples.api.subscription.messages.SubQueryBaseResponse;

import java.io.IOException;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Handle SubscriptionBaseSize Request
 */
public class SubscriptionBaseSizeServlet extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 2903211524501294066L;
	private String baseSize;

    /**
     * Process Received SubscriptionBaseSize Request
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
	public void doGet(HttpServletRequest request,  HttpServletResponse response)
            throws ServletException, IOException {

        // create subscriptionRequestSender with Subscription BaseSize URL.
        SubscriptionRequestSender subscriptionRequestSender
                = new SubscriptionRequestSender(new URL(SubscriptionKeyBox.SUBSCRIPTION_BASESIZE_URL));

        // Create SubQueryBaseRequest with Defined Application Id and Password.
        SubQueryBaseRequest subQueryBaseRequest = new SubQueryBaseRequest();
        subQueryBaseRequest.setApplicationId(SubscriptionKeyBox.APP_ID);
        subQueryBaseRequest.setPassword(SubscriptionKeyBox.APP_PASSWORD);

        try {
            // Get SubQueryBaseResponse and assign base size to display
            SubQueryBaseResponse subQueryBaseResponse =
                    subscriptionRequestSender.sendSubscriptionQueryBaseRequest(subQueryBaseRequest);
            baseSize = subQueryBaseResponse.getBaseSize();
        } catch (Exception ex) {
            System.out.println("Error occurred due to " + ex);
        }
        response.getWriter().print(baseSize);
    }
}
