package zz.common.net;

public class Request {
    private String action;
    private String data;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getAction() {

        return action;
    }

    public void setAction(String action) {
        this.action = action;

    }

    //session
    private  Long currentUserId;

    public Long getCurrentUserId() {
        return currentUserId;
    }

    public void setCurrentUserId(Long currentUserId) {
        this.currentUserId = currentUserId;
    }
}
