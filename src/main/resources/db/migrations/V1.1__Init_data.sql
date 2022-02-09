CREATE TABLE favourites
(
    id            uuid DEFAULT gen_random_uuid() PRIMARY KEY,
    name          varchar(250) not null,
    favouriteType varchar      not null
);