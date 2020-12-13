package com.array.commonmodule.bean.dto;

/**
 * @author yee
 */
public class TestCase {
    Long testCaseId;
    Long problemId;
    String input;

    public TestCase() {
    }

    public TestCase(Long testCaseId, Long problemId, String input) {
        this.testCaseId = testCaseId;
        this.problemId = problemId;
        this.input = input;
    }

    public Long getTestCaseId() {
        return testCaseId;
    }

    public void setTestCaseId(Long testCaseId) {
        this.testCaseId = testCaseId;
    }

    public Long getProblemId() {
        return problemId;
    }

    public void setProblemId(Long problemId) {
        this.problemId = problemId;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    @Override
    public String toString() {
        return "TestCase{" +
                "testCaseId=" + testCaseId +
                ", problemId=" + problemId +
                ", input='" + input + '\'' +
                '}';
    }
}
