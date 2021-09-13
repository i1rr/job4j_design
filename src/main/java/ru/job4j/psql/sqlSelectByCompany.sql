SELECT
person.name as Employee,
company.name as Company
FROM
person
JOIN
company
ON
person.company_id = company.id
WHERE
company_id != 5
ORDER BY
company.name;

-- Надеюсь это говнище не увидит потенциальный работодатель
SELECT MAX(c.name), MAX(ppl.num)
FROM
(SELECT p.company_id as pid, COUNT(p.name) as num FROM company c JOIN person p ON c.id = p.company_id GROUP BY pid) as ppl
JOIN company c
ON c.id = ppl.pid;