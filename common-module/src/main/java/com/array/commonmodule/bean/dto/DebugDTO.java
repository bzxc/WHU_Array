package com.array.commonmodule.bean.dto;

import java.util.List;

/**
 * @author yee
 */
public class DebugDTO {
    String submitID;
    String problemID;
    String lang;
    String input;
    String src;

    public DebugDTO() {
    }

    public DebugDTO(String submitID, String problemID, String lang, String input, String src) {
        this.submitID = submitID;
        this.problemID = problemID;
        this.lang = lang;
        this.input = input;
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

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    @Override
    public String toString() {
        return "DebugDTO{" +
                "submitID='" + submitID + '\'' +
                ", problemID='" + problemID + '\'' +
                ", lang='" + lang + '\'' +
                ", input='" + input + '\'' +
                ", src='" + src + '\'' +
                '}';
    }
}
