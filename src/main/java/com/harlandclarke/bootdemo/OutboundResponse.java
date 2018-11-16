package com.harlandclarke.bootdemo;


import java.io.Serializable;

/**
 *
 * @author root
 */
public class OutboundResponse implements Serializable {

    private String response;

    public OutboundResponse() {
        super();
    }

    public OutboundResponse(String s) {
        this.response = s;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

}
