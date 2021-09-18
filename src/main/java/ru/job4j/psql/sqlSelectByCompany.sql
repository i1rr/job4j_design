 SELECT
 p.name as Employee,
 c.name as Company
 FROM
 person p, company c
 WHERE
 p.company_id = c.id
 and
 p.company_id != 5
 ORDER BY
 c.name;


SELECT c.name as Company, COUNT(p.name) as Amount
FROM company c, person p
WHERE c.id = p.company_id
GROUP BY c.name
ORDER BY Amount desc
LIMIT 1;