package com.joshian.appdeveloper.app.ws.io.entity;

import java.io.Serializable;

import javax.persistence.Id;

public class UserEntity implements Serializable{

	private static final long serialVersionUID = 8886422077117017840L;
	@Id
	private long id;
}
