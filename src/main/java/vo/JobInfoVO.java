package vo;

public class JobInfoVO {
    private Integer id;
    private String adminName;
    private String employeeName;
    private String jobName;
    private String jobRemanrk;
    private String deptName;
    private Integer count;

    public JobInfoVO() {
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobRemanrk() {
        return jobRemanrk;
    }

    public void setJobRemanrk(String jobRemanrk) {
        this.jobRemanrk = jobRemanrk;
    }
}
