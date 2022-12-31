package com.Fawry.payment_system.Services;

import com.Fawry.payment_system.enums.ProviderName;

import java.util.Map;

public class ServiceProvider {
    ProviderName providerName;
    Map<String, String> fields;
    int numberOfFields;

    public ServiceProvider(ProviderName providerName, Map<String, String> fields, int numberOfFields) {
        this.providerName = providerName;
        this.fields = fields;
        this.numberOfFields = numberOfFields;
    }

    public ProviderName getProviderName() {
        return providerName;
    }

    public void setProviderName(ProviderName providerName) {
        this.providerName = providerName;
    }

    public Map<String, String> getFields() {
        return fields;
    }

    public void setFields(Map<String, String> fields) {
        this.fields = fields;
    }

    public int getNumberOfFields() {
        return numberOfFields;
    }

    public void setNumberOfFields(int numberOfFields) {
        this.numberOfFields = numberOfFields;
    }
}
