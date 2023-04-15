CREATE TABLE IF NOT EXISTS public.items (
    id bigint NOT NULL,
    product_id bigint NOT NULL,
    quantity INTEGER NOT NULL,
    total NUMERIC(5, 2) NOT NULL,
    PRIMARY KEY (id)
);

CREATE SEQUENCE IF NOT EXISTS public.seq_items START WITH 1 INCREMENT BY 1 MAXVALUE 9999999 MINVALUE 1;
ALTER SEQUENCE public.seq_items OWNED BY public.items.id;