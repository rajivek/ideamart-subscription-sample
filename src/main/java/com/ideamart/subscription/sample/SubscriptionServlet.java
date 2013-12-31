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

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Main Servlet to view Subscription Details.
 */
public class SubscriptionServlet extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = -4397147890931809264L;

	/**
     * Redirect to Subscription Detail View
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
	public void doGet(HttpServletRequest request,  HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("/subscriptionDetailView.jsp");
    }
}