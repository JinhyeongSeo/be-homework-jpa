package com.springboot.order.entity;

import com.springboot.coffee.entity.Coffee;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@Setter
public class OrderCoffee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long orderCoffeeId;

	@Column(nullable = false)
	private int quantity;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "ORDER_ID")
	private Order order;

	public void setOrder(Order order) {
		this.order = order;
		if (!this.order.getOrderCoffees().contains(this)) {
			order.setOrderCoffeeList(this);
		}
	}

	@Setter
	@ManyToOne
	@JoinColumn(name = "COFFEE_ID")
	private Coffee coffee;
}
