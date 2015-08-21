package net.shakaihatsu.training.persistence.domain.animal;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@NamedQueries({ @NamedQuery(name = Dog.FIND_ALL, query = "SELECT e FROM Dog e"), })
@DiscriminatorValue("DOG")
@Entity
public class Dog extends Mammal {
	public static final String FIND_ALL = "Dog.findAll";
}
