create table titles
(
    id         text
        constraint titles_pk
            unique,
    title      text,
    platform   text,
    image_url text,
    psn_url   text,
    price_usd text,
    publisher  text
);

comment on table titles is 'Catalog of ps4 games ';

comment on column titles.id is 'Same as ps4 game id';

comment on column titles.title is 'Name of the game';