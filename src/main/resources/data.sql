INSERT INTO orders (customer_email, total, status, created_at) VALUES
                                                                   ('customer1@email.com', 199.99, 'PENDING', datetime('now')),
                                                                   ('customer2@email.com', 299.99, 'COMPLETED', datetime('now'));

INSERT INTO order_items (order_id, product_name, price, quantity) VALUES
                                                                      (1, 'Product A', 99.99, 1),
                                                                      (1, 'Product B', 100.00, 1),
                                                                      (2, 'Product C', 299.99, 1);