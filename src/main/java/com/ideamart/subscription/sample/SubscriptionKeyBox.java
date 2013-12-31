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


public class SubscriptionKeyBox {

    // Subscription Message Url (OPT_IN/OPT_OUT)
    public static final String SUBSCRIPTION_MESSAGE_URL = "http://127.0.0.1:7000/subscription/send";

    // Subscription BaseSize Url for get the Base Size.
    public static final String SUBSCRIPTION_BASESIZE_URL = "http://127.0.0.1:7000/subscription/query-base";

    // Subscription Status Url
    public static final String SUBSCRIPTION_STATUS_URL = "http://127.0.0.1:7000/subscription/getStatus";

    // Application Id
    public static final String APP_ID = "APP_00001";

    //Application password
    public static final String APP_PASSWORD = "password";

    //Subscriber Mobile Number
    public static final String MSISDN = "94771122336";

    // For registration action should be 1 (0 - Opt Out | 1 - Opt In)
    public static final String REG_ACTION = "1";

    //Specific Version
    public static final String VERSION = "1.0";

}
