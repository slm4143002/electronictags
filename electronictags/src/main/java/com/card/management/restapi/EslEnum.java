package com.card.management.restapi;

public enum EslEnum {
	//组装 接地 耐压 UT
	ASSEMBLE_RESULT("OK", "NG", "1", "0"), GROUND_CONNECTION_RESULT("OK", "NG", "1",
			"0"), WITHSTAND_VOLTAGE_RESULT("OK", "NG", "1", "0"), UT_RESULT("OK", "NG", "1", "0");

	private final String resultLabelOK;
	private final String resultLabelNG;
	private final String resultOK;
	private final String resultNG;

	EslEnum(String resultLabelOK, String resultLabelNG, String resultOK, String resultNG) {
		this.resultLabelOK = resultLabelOK;
		this.resultLabelNG = resultLabelNG;
		this.resultOK = resultOK;
		this.resultNG = resultNG;
	}

	public String getResultLabelOK() {
		return resultLabelOK;
	}

	public String getResultLabelNG() {
		return resultLabelNG;
	}

	public String getResultOK() {
		return resultOK;
	}

	public String getResultNG() {
		return resultNG;
	}
	
	public static String getResultLabelOK(String result) {
        for (EslEnum e : EslEnum.values()) {
            if (e.getResultOK().equals(result)) {
                return e.getResultLabelOK();
            } else {
            	 return e.getResultLabelNG();
            }
        }
        return "";
    }
}
