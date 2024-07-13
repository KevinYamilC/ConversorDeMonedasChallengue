package com.monedasConversor.aluraChallenge;

import com.fasterxml.jackson.annotation.*;
import java.util.Map;

public class ResponseCoin {
    private String result;
    private String documentation;
    private String termsOfUse;
    private long timeLastUpdateUnix;
    private String timeLastUpdateUTC;
    private long timeNextUpdateUnix;
    private String timeNextUpdateUTC;
    private String baseCode;
    private Map<String, Double> conversionRates;

    @JsonProperty("result")
    public String getResult() {
        return result;
    }

    @JsonProperty("result")
    public void setResult(String value) {
        this.result = value;
    }

    @JsonProperty("documentation")
    public String getDocumentation() {
        return documentation;
    }

    @JsonProperty("documentation")
    public void setDocumentation(String value) {
        this.documentation = value;
    }

    @JsonProperty("terms_of_use")
    public String getTermsOfUse() {
        return termsOfUse;
    }

    @JsonProperty("terms_of_use")
    public void setTermsOfUse(String value) {
        this.termsOfUse = value;
    }

    @JsonProperty("time_last_update_unix")
    public long getTimeLastUpdateUnix() {
        return timeLastUpdateUnix;
    }

    @JsonProperty("time_last_update_unix")
    public void setTimeLastUpdateUnix(long value) {
        this.timeLastUpdateUnix = value;
    }

    @JsonProperty("time_last_update_utc")
    public String getTimeLastUpdateUTC() {
        return timeLastUpdateUTC;
    }

    @JsonProperty("time_last_update_utc")
    public void setTimeLastUpdateUTC(String value) {
        this.timeLastUpdateUTC = value;
    }

    @JsonProperty("time_next_update_unix")
    public long getTimeNextUpdateUnix() {
        return timeNextUpdateUnix;
    }

    @JsonProperty("time_next_update_unix")
    public void setTimeNextUpdateUnix(long value) {
        this.timeNextUpdateUnix = value;
    }

    @JsonProperty("time_next_update_utc")
    public String getTimeNextUpdateUTC() {
        return timeNextUpdateUTC;
    }

    @JsonProperty("time_next_update_utc")
    public void setTimeNextUpdateUTC(String value) {
        this.timeNextUpdateUTC = value;
    }

    @JsonProperty("base_code")
    public String getBaseCode() {
        return baseCode;
    }

    @JsonProperty("base_code")
    public void setBaseCode(String value) {
        this.baseCode = value;
    }

    @JsonProperty("conversion_rates")
    public Map<String, Double> getConversionRates() {
        return conversionRates;
    }

    @JsonProperty("conversion_rates")
    public void setConversionRates(Map<String, Double> value) {
        this.conversionRates = value;
    }
}