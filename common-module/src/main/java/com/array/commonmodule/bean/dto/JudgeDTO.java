package com.array.commonmodule.bean.dto;

import java.util.List;

/**
 * @author yee
 */
public class JudgeDTO {
    String submitID;
    String problemID;
    String lang;
    List<TestCaseAssociation> testCases;
    String src;

    public JudgeDTO() {
    }

    public JudgeDTO(String submitID, String problemID, String lang, List<TestCaseAssociation> testCases, String src) {
        this.submitID = submitID;
        this.problemID = problemID;
        this.lang = lang;
        this.testCases = testCases;
        this.src = src;
    }

    public String getSubmitID() {
        return submitID;
    }

    public void setSubmitID(String submitID) {
        this.submitID = submitID;
    }

    public String getProblemID() {
        return problemID;
    }

    public void setProblemID(String problemID) {
        this.problemID = problemID;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public List<TestCaseAssociation> getTestCases() {
        return testCases;
    }

    public void setTestCases(List<TestCaseAssociation> testCases) {
        this.testCases = testCases;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    @Override
    public String toString() {
        return "JudgeDTO{" +
                "submitID='" + submitID + '\'' +
                ", problemID='" + problemID + '\'' +
                ", lang='" + lang + '\'' +
                ", testCases=" + testCases +
                ", src='" + src + '\'' +
                '}';
    }
}
