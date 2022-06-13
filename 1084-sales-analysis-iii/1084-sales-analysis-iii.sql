# Write your MySQL query statement below
select product_id, product_name
from product
where product_id
in (
    select product_id
    from Sales
    group by product_id
    having
        max(sale_date) <= '2019-03-31'
        and min(sale_date) >= '2019-01-01'
)