package com.applet.entity.chinapayresentity;

import com.applet.entity.ChinaPayResBaseEntity;

public class TradingElementsQueryResEntity extends ChinaPayResBaseEntity {

    private static final long serialVersionUID = 4885441308232145678L;

    /** 响应保留域 **/
    private String TransExfield;

    public String getTransExfield() {
        return TransExfield;
    }

    public void setTransExfield(String transExfield) {
        TransExfield = transExfield;
    }
}
