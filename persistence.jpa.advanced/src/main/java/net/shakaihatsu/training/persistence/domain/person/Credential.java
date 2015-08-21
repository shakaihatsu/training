package net.shakaihatsu.training.persistence.domain.person;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlTransient;

import net.shakaihatsu.training.persistence.domain.common.PersistentEntity;

@Entity
public class Credential extends PersistentEntity {
	private String personalId;
	@OneToOne
	@JoinColumn(name = "owner_id")
	// @MapsId
	private Person owner;

	public String getPersonalId() {
		return personalId;
	}

	public void setPersonalId(String personalId) {
		this.personalId = personalId;
	}

	@XmlTransient
	public Person getOwner() {
		return owner;
	}

	public void setOwner(Person owner) {
		this.owner = owner;
	}

}
