-- we don't know how to generate root <with-no-name> (class Root) :(
create table Category
(
    id                     INTEGER
        primary key autoincrement,
    name                   TEXT not null,
    total_category_product INTEGER default 0
);

create table account
(
    account_id         INTEGER
        primary key autoincrement,
    account_name       TEXT,
    account_password   TEXT,
    account_is_user  INTEGER,
    account_is_admin   INTEGER,
    account_address    TEXT,
    account_first_name TEXT,
    account_last_name  TEXT,
    account_email      TEXT,
    account_phone      TEXT
);

create table "Order"
(
    id         INTEGER
        primary key autoincrement,
    account_id INTEGER not null
        references account
            on delete cascade,
    total      REAL    not null,
    date       TEXT    not null
);

create table Product
(
    id           INTEGER
        primary key autoincrement,
    name         TEXT    not null,
    price        REAL    not null,
    description  TEXT,
    category_id  INTEGER
                         references Category
                             on delete set null,
    account_id   INTEGER
        references account
            on delete cascade,
    is_deleted   INTEGER default 0 not null,
    amount       INTEGER not null,
    image        BLOB,
    base64_image TEXT
);

create table CartProduct
(
    id         INTEGER
        primary key autoincrement,
    product_id INTEGER not null
        references Product
            on delete cascade,
    quantity   INTEGER not null,
    price      REAL    not null
);

create table OrderCartProduct
(
    order_id        INTEGER not null
        references "Order"
            on delete cascade,
    cart_product_id INTEGER not null
        references CartProduct
            on delete cascade,
    primary key (order_id, cart_product_id)
);

