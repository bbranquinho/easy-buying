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


    public static final String USER_PATH =  PRIVATE_ROOT_PATH + "/user";
    
    public static final String PERMISSION_PATH = PRIVATE_ROOT_PATH + "/permission";

    public static final String PACKAGEE_PATH = PRIVATE_ROOT_PATH + "/packagee";

    ///////////////////////////////////////////////////////////////
    // PRIVATE ADDRESS
    ///////////////////////////////////////////////////////////////

    public static final String ADDRESS_PATH =  PRIVATE_ROOT_PATH + "/address";

    ///////////////////////////////////////////////////////////////
    // PRIVATE NEIGHBORHOOD
    ///////////////////////////////////////////////////////////////
    public static final String NEIGHBORHOOD_PATH =  PRIVATE_ROOT_PATH + "/neighborhood";

    ///////////////////////////////////////////////////////////////
    // PRIVATE CITY
    ///////////////////////////////////////////////////////////////
    public static final String CITY_PATH =  PRIVATE_ROOT_PATH + "/city";

    ///////////////////////////////////////////////////////////////
    // PRIVATE STATE
    ///////////////////////////////////////////////////////////////
    public static final String STATE_PATH =  PRIVATE_ROOT_PATH + "/state";

    ///////////////////////////////////////////////////////////////
    // PRIVATE PRODUCT CATEGORY
    ///////////////////////////////////////////////////////////////
    public static final String PRODUCT_CATEGORY_PATH =  PRIVATE_ROOT_PATH + "/productcategory";

    ///////////////////////////////////////////////////////////////
    // PRIVATE PRODUCT
    ///////////////////////////////////////////////////////////////
    public static final String PRODUCT_PATH =  PRIVATE_ROOT_PATH + "/product";

    ///////////////////////////////////////////////////////////////
    // PRIVATE PRODUCT REQUEST
    ///////////////////////////////////////////////////////////////
    public static final String PRODUCT_REQUEST_PATH =  PRIVATE_ROOT_PATH + "/productrequest";

    ///////////////////////////////////////////////////////////////
    // PRIVATE SUPPLIER
    ///////////////////////////////////////////////////////////////
    public static final String SUPPLIER_PATH =  PRIVATE_ROOT_PATH + "/supplier";

    ///////////////////////////////////////////////////////////////
    // PUBLIC PATHS
    ///////////////////////////////////////////////////////////////


    public static final String LOGIN_PATH = PUBLIC_ROOT_PATH + "/login";

    public static final String LOGOUT_PATH = PUBLIC_ROOT_PATH + "/logout";

    private ResourcePaths() {}

}
