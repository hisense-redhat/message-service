package com.sample.model;

public class Event {
	
	private String deviceId;
	
	private String command;
	
	private String data;
	
	private Long createDate;
	
	private String nodeId;
	
	private String sensorId;

	public Event() {
		super();
	}

	public Event(String deviceId, String command, String data, Long createDate, String nodeId, String sensorId) {
		super();
		this.deviceId = deviceId;
		this.command = command;
		this.data = data;
		this.createDate = createDate;
		this.nodeId = nodeId;
		this.sensorId = sensorId;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getCommand() {
		return command;
	}

	public void setCommand(String command) {
		this.command = command;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Long getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Long createDate) {
		this.createDate = createDate;
	}

	public String getNodeId() {
		return nodeId;
	}

	public void setNodeId(String nodeId) {
		this.nodeId = nodeId;
	}

	public String getSensorId() {
		return sensorId;
	}

	public void setSensorId(String sensorId) {
		this.sensorId = sensorId;
	}

	
}
