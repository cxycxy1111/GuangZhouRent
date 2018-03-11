package com.guangzhourent.version.Util;

public class Ref {

    public static final String prefix = "{\"stat\":\"";
    public static final String idPrefix = "{\"id\":";
    public static final String dataPrefix = "{\"data\":";
    public static final String suffix = "\"}";
    public static final String dataSuffix = "}";
    public static final String idSuffix = "}";

    public static final String EXE_FAIL =prefix +  "exe_fail" + suffix;
    public static final String EXE_PARTLY_FAIL =prefix +  "exe_partly_fail" + suffix;
    public static final String EXE_SUC = prefix + "exe_suc" + suffix;

    public static final String INST_NOT_MATCH = prefix + "institution_not_match" + suffix;
    public static final String EMPTY_RESULT = prefix + "empty_result" + suffix;
    public static final String SESSION_EXPIRED=prefix + "session_expired" + suffix;
    public static final String AUTHORIZE_FAIL=prefix + "authorize_fail" + suffix;

    public static final String INST_NOT_FOUND = prefix + "institution_not_found" + suffix;
    public static final String SOURCE_NOT_FOUND = prefix + "source_not_found" + suffix;
    public static final String INST_USER_NOT_MATCH = prefix + "institution_user_not_match" + suffix;
    public static final String PROVINCE_NOT_MATCH = prefix + "province_not_match" + suffix;
    public static final String CITY_NOT_MATCH = prefix + "city_not_match" + suffix;
    public static final String DISTRICT_NOT_MATCH = prefix + "district_not_match" + suffix;

    public static final String INST_DUPLICATE = prefix + "institution_duplicate" + suffix;
    public static final String SOURCE_DUPLICATE = prefix + "institution_duplicate" + suffix;
    public static final String INST_USER_DUPLICATE = prefix + "institution_duplicate" + suffix;
    public static final String IP = "39.104.72.97";
    public static final String LOCAL_HOST = "http://" + IP + ":8080/GuangZhouRent/pictureDownload?imgName=";
}
