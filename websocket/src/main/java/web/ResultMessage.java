package web;

import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;
import java.util.Map;

/**
 * Created by zhangheng on 2017/9/14.
 */
public class ResultMessage implements Serializable{

    private String message;
    private String error;
    private boolean result = true;
    private Map<String,Object> attributes;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public Map<String, Object> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<String, Object> attributes) {
        this.attributes = attributes;
    }

    public static ResultMessage successResult(String message) {
        ResultMessage rm = new ResultMessage();
        rm.result = true;
        rm.message = message;
        return rm;
    }

    public static ResultMessage successResult(String message, Map<String, Object> attributes) {
        ResultMessage rm = new ResultMessage();
        rm.result = true;
        rm.message = message;
        rm.attributes = attributes;
        return rm;
    }

    public static ResultMessage failResult(String message, String cause) {
        ResultMessage rm = new ResultMessage();
        rm.result = false;
        rm.message = message;
        return rm;
    }

    public static ResultMessage errorResult(String error) {
        ResultMessage rm = new ResultMessage();
        rm.result = false;
        rm.error = error;
        return rm;
    }

    public static ResultMessage failResult(String message, Map<String, Object> attributes) {
        ResultMessage rm = new ResultMessage();
        rm.result = false;
        rm.message = message;
        rm.attributes = attributes;
        return rm;
    }

    public String toString() {
        JSONObject stringer = new JSONObject();
        stringer.put("result",this.result);
        stringer.put("result",this.result);
        stringer.put("message",this.message);
        stringer.put("attributes",this.attributes);
        stringer.put("error",this.error);
        stringer.put("result",this.result);
        return stringer.toString();
    }
}
