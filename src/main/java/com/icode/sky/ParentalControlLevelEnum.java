package com.icode.sky;

/**
 * Created by kerimc on 23.05.2017.
 */
public enum ParentalControlLevelEnum {
    PCL_U("U", 0), PCL_PG("PG", 1), PCL_12("12", 2),PCL_15("15", 3),PCL_18("18", 4);

    private String label;
    private Integer order;

    ParentalControlLevelEnum(String label, Integer order) {

        this.label = label;
        this.order = order;
    }

    public String getLabel() {
        return label;
    }

    public Integer getOrder() {
        return order;
    }

    public static ParentalControlLevelEnum findPCL(String label){
        switch (label){
            case "U": return PCL_U;
            case "PG": return PCL_PG;
            case "12": return PCL_12;
            case "15": return PCL_15;
            case "18": return PCL_18;
        }
        return null;
    }
}
