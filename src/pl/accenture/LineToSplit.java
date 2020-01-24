package pl.accenture;

public class LineToSplit {
    String date;
    String market;
    String batchId;
    String jobStatus;
    String entity;
    String patternType;
    String totallyProcessed;

    public LineToSplit() {
    }

    public LineToSplit(String date, String market, String batchId, String jobStatus, String entity, String patternType, String totallyProcessed) {
        this.date = date;
        this.market = market;
        this.batchId = batchId;
        this.jobStatus = jobStatus;
        this.entity = entity;
        this.patternType = patternType;
        this.totallyProcessed = totallyProcessed;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
    }

    public String getBatchId() {
        return batchId;
    }

    public void setBatchId(String batchId) {
        this.batchId = batchId;
    }

    public String getJobStatus() {
        return jobStatus;
    }

    public void setJobStatus(String jobStatus) {
        this.jobStatus = jobStatus;
    }

    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }

    public String getPatternType() {
        return patternType;
    }

    public void setPatternType(String patternType) {
        this.patternType = patternType;
    }

    public String getTotallyProcessed() {
        return totallyProcessed;
    }

    public void setTotallyProcessed(String totallyProcessed) {
        this.totallyProcessed = totallyProcessed;
    }
}
