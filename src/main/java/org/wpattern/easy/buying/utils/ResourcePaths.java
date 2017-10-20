package org.wpattern.easy.buying.utils;

public final class ResourcePaths {
	

	///////////////////////////////////////////////////////////////
	// ROOT PATH
	///////////////////////////////////////////////////////////////

	public static final String ALL = "/**";
	
    public static final String ROOT_PATH = "/api";
    
    public static final String PUBLIC_ROOT_PATH = ROOT_PATH + "/public";
    
    public static final String PRIVATE_ROOT_PATH = ROOT_PATH + "/private";
    
    ///////////////////////////////////////////////////////////////
    // PRIVATE PATHS
    ///////////////////////////////////////////////////////////////


    public static final String ADDRESS_PATH =  PRIVATE_ROOT_PATH + "/address";

    public static final String BANNER_PATH =  PRIVATE_ROOT_PATH + "/banner";

    public static final String CITY_PATH =  PRIVATE_ROOT_PATH + "/city";

    public static final String SUPPLIER_PATH =  PRIVATE_ROOT_PATH + "/supplier";

    public static final String EMPLOYEE_PATH =  PRIVATE_ROOT_PATH + "/employee";

    public static final String NEIGHBORHOOD_PATH =  PRIVATE_ROOT_PATH + "/neighborhood";

    public static final String PAYMENT_PATH =  PRIVATE_ROOT_PATH + "/payment";

    public static final String PAYMENT_FEATURE_PATH =  PRIVATE_ROOT_PATH + "/payment_feature";

    public static final String NOTIFICATION_TEMPLATE_PATH =  PRIVATE_ROOT_PATH + "/notification_template";

    public static final String NOTIFICATION_TYPE_PATH =  PRIVATE_ROOT_PATH + "/notification_type";

    public static final String SUPPLIER_PRODUCT_PATH =  PRIVATE_ROOT_PATH + "/supplier_product";

    public static final String PRODUCT_PATH =  PRIVATE_ROOT_PATH + "/product";

    public static final String PRODUCT_CATEGORY_PATH =  PRIVATE_ROOT_PATH + "/product_category";

    public static final String PRODUCT_REQUEST_PATH =  PRIVATE_ROOT_PATH + "/product_request";

    public static final String QUOTATION_PATH =  PRIVATE_ROOT_PATH + "/quotation";

    public static final String STATE_PATH =  PRIVATE_ROOT_PATH + "/state";

    public static final String USER_PATH =  PRIVATE_ROOT_PATH + "/user";
    
    public static final String PERMISSION_PATH = PRIVATE_ROOT_PATH + "/permission";

    public static final String PACKAGEE_PATH = PRIVATE_ROOT_PATH + "/packagee";

    ///////////////////////////////////////////////////////////////
    // PRIVATE CLIENT
    ///////////////////////////////////////////////////////////////

    public static final String CLIENT_PATH =  PUBLIC_ROOT_PATH + "/client";

    ///////////////////////////////////////////////////////////////
    // PUBLIC PATHS
    ///////////////////////////////////////////////////////////////

    public static final String LOGIN_PATH = PUBLIC_ROOT_PATH + "/login";

    public static final String LOGOUT_PATH = PUBLIC_ROOT_PATH + "/logout";

    private ResourcePaths() {}

}
