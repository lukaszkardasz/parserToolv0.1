package pl.accenture.entity.firstCase;

public class FirstCaseLogLineJobStartEntity {
    private String date;
    private String market;
    private String batchId;
    private String jobStatus;
    private String entity;
    private String processedCount;

    public FirstCaseLogLineJobStartEntity() {
    }

    public FirstCaseLogLineJobStartEntity(String date, String market, String batchId, String jobStatus, String entity, String processedCount) {
        this.date = date;
        this.market = market;
        this.batchId = batchId;
        this.jobStatus = jobStatus;
        this.entity = entity;
        this.processedCount = processedCount;
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

    public String getProcessedCount() {
        return processedCount;
    }

    public void setProcessedCount(String processedCount) {
        this.processedCount = processedCount;
    }

    @Override
    public String toString() {
        return
                "  date: " + date + "\n" +
                "  market: " + market + "\n" +
                "  batchId: " + batchId + "\n" +
                "  jobStatus: " + jobStatus + "\n" +
                "  entity: " + entity + "\n" +
                "  processed count: " + processedCount + "\n";
    }
}
