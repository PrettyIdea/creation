package entity;

import java.io.Serializable;

import entity.OrderItem;
import entity.Orders;
import entity.Product;

/**
 * Model class of 订单条目.
 * 
 * @author generated by ERMaster
 * @version $Id$
 */
public class OrderItem implements Serializable {

	/** serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** id. */
	private Long id;

	/** 购买个数. */
	private Integer count;

	/** 商品. */
	private Product product;

	/** 订单. */
	private Orders orderOrders;

	/**
	 * Constructor.
	 */
	public OrderItem() {
	}

	/**
	 * Set the id.
	 * 
	 * @param id
	 *            id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Get the id.
	 * 
	 * @return id
	 */
	public Long getId() {
		return this.id;
	}

	/**
	 * Set the 购买个数.
	 * 
	 * @param count
	 *            购买个数
	 */
	public void setCount(Integer count) {
		this.count = count;
	}

	/**
	 * Get the 购买个数.
	 * 
	 * @return 购买个数
	 */
	public Integer getCount() {
		return this.count;
	}

	/**
	 * Set the 商品.
	 * 
	 * @param product
	 *            商品
	 */
	public void setProduct(Product product) {
		this.product = product;
	}

	/**
	 * Get the 商品.
	 * 
	 * @return 商品
	 */
	public Product getProduct() {
		return this.product;
	}

	/**
	 * Set the 订单.
	 * 
	 * @param orderOrders
	 *            订单
	 */
	public void setOrderOrders(Orders orderOrders) {
		this.orderOrders = orderOrders;
	}

	/**
	 * Get the 订单.
	 * 
	 * @return 订单
	 */
	public Orders getOrderOrders() {
		return this.orderOrders;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		OrderItem other = (OrderItem) obj;
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		return true;
	}

}
