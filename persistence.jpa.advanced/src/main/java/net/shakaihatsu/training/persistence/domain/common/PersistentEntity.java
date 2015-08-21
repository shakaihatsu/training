package net.shakaihatsu.training.persistence.domain.common;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

import net.shakaihatsu.training.persistence.api.Identifiable;

@MappedSuperclass
public class PersistentEntity implements Identifiable {
	@Id
	private Long id;
	@Version
	private Long version;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

}
