# Write your MySQL query statement below
select 
    a.stock_name,
    (total_sold - total_buy) as capital_gain_loss
from (
    select
        stock_name,
        sum(price) as total_sold
    from stocks
    where operation = 'Sell'
    group by stock_name
) as a
inner join (
    select
        stock_name,
        sum(price) as total_buy
    from stocks
    where operation = 'Buy'
    group by stock_name
) as b
on a.stock_name = b.stock_name;