package com.kleens.db.uploadImage2;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="admin")


public class image {
@Id
@Column(name="id")
@GeneratedValue
private Long id;

@Column(name="pic")
private byte [] pic;

public image(byte[] pic) {
	super();
	this.pic = pic;
}


}
