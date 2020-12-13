package com.array.commonmodule.bean.dto;

/**
 * @author yee
 */
public class TestCaseAssociation {
    String testCaseId;
    String result;

    public TestCaseAssociation() {
    }

    public TestCaseAssociation(String testCaseId, String result) {
        this.testCaseId = testCaseId;
        this.result = result;
    }

    public String getTestCaseId() {
        return testCaseId;
    }

    public void setTestCaseId(String testCaseId) {
        this.testCaseId = testCaseId;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "TestCaseAssociation{" +
                "testCaseId='" + testCaseId + '\'' +
                ", result='" + result + '\'' +
                '}';
    }
}
