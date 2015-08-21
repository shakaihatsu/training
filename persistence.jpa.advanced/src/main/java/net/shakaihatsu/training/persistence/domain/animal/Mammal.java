package net.shakaihatsu.training.persistence.domain.animal;

public class Mammal extends Animal {
	private static final int DEFAULT_NUMBER_OF_LEGS_FOR_MAMMALS = 4;

	{
		setNumberOfLegs(DEFAULT_NUMBER_OF_LEGS_FOR_MAMMALS);
	}
}
