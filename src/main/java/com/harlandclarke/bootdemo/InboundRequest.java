package com.harlandclarke.bootdemo;

import java.io.Serializable;

public class InboundRequest implements Serializable {
    private String inbound;

    public InboundRequest() {
        super();
    }

    public InboundRequest(String inbound) {
        this.inbound = inbound;
    }

    public String getInbound() {
        return inbound;
    }

    public void setInbound(String inbound) {
        this.inbound = inbound;
    }
}


