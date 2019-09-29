package com.qwic.assessment.qaAssesment.TestBase;

import com.qwic.assessment.qaAssesment.Util.Driver;

public class Base {
    public static void beforeSuite() {
        Driver.initialize();
    }


    public static void afterSuite() {
        Driver.quit();
    }

}


