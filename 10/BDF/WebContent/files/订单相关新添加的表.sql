-- 订单相关的新添加表
CREATE TABLE orders
(
	id bigint NOT NULL AUTO_INCREMENT,
	customer_id bigint,
	PRIMARY KEY (id)
);


CREATE TABLE order_item
(
	id bigint NOT NULL AUTO_INCREMENT,
	-- 购买个数
	count int NOT NULL COMMENT '购买个数',
	product_id bigint(19),
	order_id bigint,
	PRIMARY KEY (id)
);




/* Create Foreign Keys */

ALTER TABLE orders
	ADD FOREIGN KEY (customer_id)
	REFERENCES customer (id)
	ON UPDATE CASCADE
	ON DELETE CASCADE
;


ALTER TABLE order_item
	ADD FOREIGN KEY (order_id)
	REFERENCES orders (id)
	ON UPDATE CASCADE
	ON DELETE CASCADE
;


ALTER TABLE order_item
	ADD FOREIGN KEY (product_id)
	REFERENCES product (id)
	ON UPDATE CASCADE
	ON DELETE CASCADE
;



