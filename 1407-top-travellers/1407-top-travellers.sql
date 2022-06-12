# Write your MySQL query statement below
select
    name,
    case
        when dist is null then 0
        else dist
    end as travelled_distance
from users
left join (
    select
        user_id,
        sum(distance) as dist
    from rides
    group by user_id
) as a
on users.id = a.user_id
order by
    travelled_distance desc,
    name asc;