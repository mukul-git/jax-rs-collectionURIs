package org.vyomkesh.jaxRs.collectionURIs.rest.model;

import java.math.BigDecimal;

public class ModelData {
    long stepRunId;
    String type;//Actual, Forecast
    BigDecimal value;

    public long getStepRunId() {
        return stepRunId;
    }

    public String getType() {
        return type;
    }

    public BigDecimal getValue() {
        return value;
    }
}
