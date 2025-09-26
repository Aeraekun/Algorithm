-- SELECT * FROM
-- (
--     SELECT CAR_ID, CAR_TYPE,
--         CASE WHEN CAR_TYPE='세단' THEN TRUNC(DAILY_FEE*30*0.9)
--              ELSE TRUNC(DAILY_FEE*30*0.92)
--         END FEE
--     FROM 
--     CAR_RENTAL_COMPANY_CAR
--     WHERE 1=1
--     AND CAR_TYPE IN ('세단','SUV')
--     AND CAR_ID NOT IN 
--     (
--         SELECT CAR_ID 
--         FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
--         WHERE TO_CHAR(END_DATE,'YYYYMMDD') >= '20221101'
--         AND TO_CHAR(START_DATE,'YYYYMMDD') <= '20221130'
--         GROUP BY CAR_ID
--     )
-- )
-- WHERE FEE BETWEEN 500000 AND 2000000
-- ORDER BY FEE DESC, CAR_TYPE, CAR_ID DESC
-- SELECT  *
--   FROM  (
--             SELECT  A.CAR_ID
--                  ,  A.CAR_TYPE
--                  ,  30 * A.DAILY_FEE * (1 - (B.DISCOUNT_RATE * 0.01)) AS FEE
--               FROM  CAR_RENTAL_COMPANY_CAR              A
--                  ,  CAR_RENTAL_COMPANY_DISCOUNT_PLAN    B
--              WHERE  A.CAR_TYPE      = B.CAR_TYPE
--                AND  B.DURATION_TYPE = '30일 이상'
--                AND  A.CAR_TYPE IN ('세단', 'SUV')
--                AND  A.CAR_ID NOT IN (
--                                         SELECT  A.CAR_ID
--                                           FROM  CAR_RENTAL_COMPANY_CAR              A
--                                              ,  CAR_RENTAL_COMPANY_RENTAL_HISTORY   B
--                                          WHERE  A.CAR_ID = B.CAR_ID
--                                            AND  A.CAR_TYPE IN ('세단', 'SUV')
--                                            AND  TO_CHAR(B.END_DATE, 'YYYYMMDD') >= '20221101'
--                                            AND  TO_CHAR(B.START_DATE, 'YYYYMMDD') < '20221201'
--                                     )
--         )   A
--  WHERE  A.FEE BETWEEN 500000 AND 1999999
--  ORDER  BY  FEE DESC
--      ,  CAR_TYPE
--      ,  CAR_ID DESC
SELECT
    CAR_ID,
    CAR_TYPE,
    FEE
FROM (
    -- 안쪽 쿼리에서 먼저 FEE를 계산합니다.
    SELECT
        C.CAR_ID,
        C.CAR_TYPE,
        TRUNC(C.DAILY_FEE * 30 * (1 - P.DISCOUNT_RATE / 100)) AS FEE
    FROM
        CAR_RENTAL_COMPANY_CAR C
    JOIN
        CAR_RENTAL_COMPANY_DISCOUNT_PLAN P ON C.CAR_TYPE = P.CAR_TYPE
    WHERE
        C.CAR_TYPE IN ('세단', 'SUV')
        AND P.DURATION_TYPE = '30일 이상'
        AND C.CAR_ID NOT IN (
            SELECT CAR_ID
            FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
            WHERE END_DATE >= TO_DATE('2022-11-01', 'YYYY-MM-DD')
              AND START_DATE <= TO_DATE('2022-11-30', 'YYYY-MM-DD')
        )
)
-- 바깥쪽 쿼리에서는 FEE를 하나의 컬럼으로 인식하므로 WHERE 절에서 사용할 수 있습니다.
WHERE
    FEE >= 500000 AND FEE < 2000000
ORDER BY
    FEE DESC, CAR_TYPE ASC, CAR_ID DESC;