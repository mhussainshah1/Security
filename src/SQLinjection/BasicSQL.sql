select * from Hours;

SELECT opens FROM hours
WHERE day = 'monday'
   OR day IS NOT NULL
   OR day = 'sunday';