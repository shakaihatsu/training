package net.shakaihatsu.training.persistence.service;

import java.util.concurrent.atomic.AtomicLong;

public class IdSequencer {
	public static final AtomicLong ID_SEQUENCE = new AtomicLong(1L);
}
