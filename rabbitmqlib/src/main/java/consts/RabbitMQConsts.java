package consts;

public enum RabbitMQConsts {
	
	EXCHANGE_NAME ("amq.direct"),
	CALCULATIONS_QUEUE("CALCULATIONS");

	private String value;
	
	RabbitMQConsts(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}
}
