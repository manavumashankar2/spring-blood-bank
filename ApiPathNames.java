package com.netcracker.bloodbank.utils;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public  final class ApiPathNames {
    public static final String BLOOD_CONTROLLER="/blood";
    public static final String CREATE_BGROUP="/create";
    public static final String UPDATE_BGROUP="/update";
    public static final String DELETE_GROUP="/delete";
    public static final String GET_ALL_GROUPS="/read";
    public static final String GET_IN_RANGE="/range";
    public static final String GET_GROUP_PRICE="/Price";
    public static final String GET_GROUP ="/Group";

    public static final String CUSTOMER_CONTROLLER="/customer";
    public static final String CREATE_CUSTOMER="/create";
    public static final String UPDATE_CUSTOMER="/update";
    public static final String DELETE_CUSTOMER="/delete";
    public static final String UPDATE_CUSTOMER_PHONENUMBER="/Number";
    public static final String READ_CUSTOMERS="/readAll";
    public static final String CUSTOMER_BY_CITY="/byCity";
    public static final String CUSTOMER_SORTED_BY_NAME="/byName";
    public static final String CUSTOMER_SORTED_BY_AGE="/byAge";
    public static final String CUSTOMER_BY_GROUP="/byGroup";

    public static final String ORDER_CONTROLLER="/order";
    public static final String CREATE_ORDER="/create";
    public static final String DELETE_ORDER="/delete";
    public static final String READ_ORDERS="/readAll";
    public static final String ORDER_BYTYPE="/Type";
    public static final String CUSTOMER_ORDER="/customer";
    public static final String VIEW_ORDERBYID="/read";

    public static final String INVENTRORY_CONTROLLER="/inventory";
    public static final String STOCK_BYQUANTITY="/inventory/byqty";
    public static final String DISPLAY_STOCK="/inventory/read";
    public static final String DELETE_STOCK="/inventory/delete";
    public static final String UPADTE_STOCK="/inventory/update";
    public static final String ADD_STOCK="/inventory/add";
    public static final String GE_STOCKBY_GROUP="/inventory/group";








}
