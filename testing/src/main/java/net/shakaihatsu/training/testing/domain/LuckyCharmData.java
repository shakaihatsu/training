package net.shakaihatsu.training.testing.domain;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class LuckyCharmData {
	private String luckyCharm;
	
	public String getLuckyCharm() {
		return luckyCharm;
	}
	
	public void setLuckyCharm(String luckyCharm) {
		this.luckyCharm = luckyCharm;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((luckyCharm == null) ? 0 : luckyCharm.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LuckyCharmData other = (LuckyCharmData) obj;
		if (luckyCharm == null) {
			if (other.luckyCharm != null)
				return false;
		} else if (!luckyCharm.equals(other.luckyCharm))
			return false;
		return true;
	}
}
