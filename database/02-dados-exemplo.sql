-- =============================================================
-- Dados de exemplo (opcional) para testar a listagem e a consulta
--   psql -U postgres -d concessionaria -f database/02-dados-exemplo.sql
-- =============================================================

INSERT INTO carros (marca, modelo, ano_fabricacao, ano_modelo, motorizacao) VALUES
    ('Volkswagen', 'Golf',    2020, 2021, '1.4 TSI'),
    ('Chevrolet',  'Onix',    2023, 2024, '1.0 Turbo'),
    ('Toyota',     'Corolla', 2022, 2022, '2.0 Flex'),
    ('Fiat',       'Argo',    2021, 2022, '1.3 Firefly'),
    ('Honda',      'Civic',   2019, 2020, '1.5 Turbo');
