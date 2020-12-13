package com.array.commonmodule.bean.dto;

import java.util.List;

public class TestList {
    private List<TestCase> testCaseList;

    public TestList(List<TestCase> testCaseList) {
        this.testCaseList = testCaseList;
    }

    public TestList() {
    }

    public List<TestCase> getTestCaseList() {
        return testCaseList;
    }

    public void setTestCaseList(List<TestCase> testCaseList) {
        this.testCaseList = testCaseList;
    }
}
