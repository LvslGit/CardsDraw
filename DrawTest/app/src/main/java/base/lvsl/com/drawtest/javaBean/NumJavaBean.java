package base.lvsl.com.drawtest.javaBean;

public class NumJavaBean {
    /**
     * status : 1
     * msg : 查询成功
     * result : 你今天还可以免费3次
     */

    private int status;
    private String msg;
    private String result;

    public NumJavaBean() {
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "NumJavaBean{" +
                "status=" + status +
                ", msg='" + msg + '\'' +
                ", result='" + result + '\'' +
                '}';
    }
}
