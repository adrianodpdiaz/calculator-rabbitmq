package dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class ResultDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private BigDecimal result;

	public ResultDTO(BigDecimal result) {
		this.result = result;
	}
	
	public BigDecimal getResult() {
		return result;
	}
}
