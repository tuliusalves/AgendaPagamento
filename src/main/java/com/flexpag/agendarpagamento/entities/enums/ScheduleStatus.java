package com.flexpag.agendarpagamento.entities.enums;

public enum ScheduleStatus {
	PAID(1),
	PENDING(2);
	
	private int code;
	
	private ScheduleStatus(int code) {
		this.code=code;
	}
	
	public int getCode() {
		return code;
	}
	//Método de conversão de um númerico em um enum
	public static ScheduleStatus valueOf(int code) {
		for(ScheduleStatus value: ScheduleStatus.values()) {
			if(value.getCode()==code) {
				return value;
			}
		}throw new IllegalArgumentException("Código inválido");
	}

}
