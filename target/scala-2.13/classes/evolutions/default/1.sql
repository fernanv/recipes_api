# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table ingredient (
  id                            bigint generated by default as identity not null,
  name                          varchar(255),
  when_created                  timestamp not null,
  constraint uq_ingredient_name unique (name),
  constraint pk_ingredient primary key (id)
);

create table ingredient_quantity (
  id                            bigint generated by default as identity not null,
  quantity                      bigint,
  type                          varchar(255),
  parent_ingredient_id          bigint,
  when_created                  timestamp not null,
  constraint pk_ingredient_quantity primary key (id)
);

create table recipe (
  id                            bigint generated by default as identity not null,
  title                         varchar(255),
  description_id                bigint,
  preparation_time              integer not null,
  level                         varchar(255),
  version                       bigint not null,
  when_created                  timestamp not null,
  when_modified                 timestamp not null,
  constraint uq_recipe_title unique (title),
  constraint uq_recipe_description_id unique (description_id),
  constraint pk_recipe primary key (id)
);

create table recipe_ingredient (
  recipe_id                     bigint not null,
  ingredient_id                 bigint not null,
  constraint pk_recipe_ingredient primary key (recipe_id,ingredient_id)
);

create table recipe_ingredient_quantity (
  recipe_id                     bigint not null,
  ingredient_quantity_id        bigint not null,
  constraint pk_recipe_ingredient_quantity primary key (recipe_id,ingredient_quantity_id)
);

create table recipe_utensil (
  recipe_id                     bigint not null,
  utensil_id                    bigint not null,
  constraint pk_recipe_utensil primary key (recipe_id,utensil_id)
);

create table recipe_tag (
  recipe_id                     bigint not null,
  tag_id                        bigint not null,
  constraint pk_recipe_tag primary key (recipe_id,tag_id)
);

create table recipe_description (
  id                            bigint generated by default as identity not null,
  description                   varchar(255),
  constraint uq_recipe_description_description unique (description),
  constraint pk_recipe_description primary key (id)
);

create table step (
  id                            bigint generated by default as identity not null,
  description                   varchar(255),
  step_number                   bigint,
  parent_recipe_id              bigint,
  when_created                  timestamp not null,
  constraint uq_step_description unique (description),
  constraint pk_step primary key (id)
);

create table tag (
  id                            bigint generated by default as identity not null,
  name                          varchar(255),
  when_created                  timestamp not null,
  constraint uq_tag_name unique (name),
  constraint pk_tag primary key (id)
);

create table utensil (
  id                            bigint generated by default as identity not null,
  name                          varchar(255),
  when_created                  timestamp not null,
  constraint uq_utensil_name unique (name),
  constraint pk_utensil primary key (id)
);

create index ix_ingredient_quantity_parent_ingredient_id on ingredient_quantity (parent_ingredient_id);
alter table ingredient_quantity add constraint fk_ingredient_quantity_parent_ingredient_id foreign key (parent_ingredient_id) references ingredient (id) on delete restrict on update restrict;

alter table recipe add constraint fk_recipe_description_id foreign key (description_id) references recipe_description (id) on delete restrict on update restrict;

create index ix_recipe_ingredient_recipe on recipe_ingredient (recipe_id);
alter table recipe_ingredient add constraint fk_recipe_ingredient_recipe foreign key (recipe_id) references recipe (id) on delete restrict on update restrict;

create index ix_recipe_ingredient_ingredient on recipe_ingredient (ingredient_id);
alter table recipe_ingredient add constraint fk_recipe_ingredient_ingredient foreign key (ingredient_id) references ingredient (id) on delete restrict on update restrict;

create index ix_recipe_ingredient_quantity_recipe on recipe_ingredient_quantity (recipe_id);
alter table recipe_ingredient_quantity add constraint fk_recipe_ingredient_quantity_recipe foreign key (recipe_id) references recipe (id) on delete restrict on update restrict;

create index ix_recipe_ingredient_quantity_ingredient_quantity on recipe_ingredient_quantity (ingredient_quantity_id);
alter table recipe_ingredient_quantity add constraint fk_recipe_ingredient_quantity_ingredient_quantity foreign key (ingredient_quantity_id) references ingredient_quantity (id) on delete restrict on update restrict;

create index ix_recipe_utensil_recipe on recipe_utensil (recipe_id);
alter table recipe_utensil add constraint fk_recipe_utensil_recipe foreign key (recipe_id) references recipe (id) on delete restrict on update restrict;

create index ix_recipe_utensil_utensil on recipe_utensil (utensil_id);
alter table recipe_utensil add constraint fk_recipe_utensil_utensil foreign key (utensil_id) references utensil (id) on delete restrict on update restrict;

create index ix_recipe_tag_recipe on recipe_tag (recipe_id);
alter table recipe_tag add constraint fk_recipe_tag_recipe foreign key (recipe_id) references recipe (id) on delete restrict on update restrict;

create index ix_recipe_tag_tag on recipe_tag (tag_id);
alter table recipe_tag add constraint fk_recipe_tag_tag foreign key (tag_id) references tag (id) on delete restrict on update restrict;

create index ix_step_parent_recipe_id on step (parent_recipe_id);
alter table step add constraint fk_step_parent_recipe_id foreign key (parent_recipe_id) references recipe (id) on delete restrict on update restrict;


# --- !Downs

alter table ingredient_quantity drop constraint if exists fk_ingredient_quantity_parent_ingredient_id;
drop index if exists ix_ingredient_quantity_parent_ingredient_id;

alter table recipe drop constraint if exists fk_recipe_description_id;

alter table recipe_ingredient drop constraint if exists fk_recipe_ingredient_recipe;
drop index if exists ix_recipe_ingredient_recipe;

alter table recipe_ingredient drop constraint if exists fk_recipe_ingredient_ingredient;
drop index if exists ix_recipe_ingredient_ingredient;

alter table recipe_ingredient_quantity drop constraint if exists fk_recipe_ingredient_quantity_recipe;
drop index if exists ix_recipe_ingredient_quantity_recipe;

alter table recipe_ingredient_quantity drop constraint if exists fk_recipe_ingredient_quantity_ingredient_quantity;
drop index if exists ix_recipe_ingredient_quantity_ingredient_quantity;

alter table recipe_utensil drop constraint if exists fk_recipe_utensil_recipe;
drop index if exists ix_recipe_utensil_recipe;

alter table recipe_utensil drop constraint if exists fk_recipe_utensil_utensil;
drop index if exists ix_recipe_utensil_utensil;

alter table recipe_tag drop constraint if exists fk_recipe_tag_recipe;
drop index if exists ix_recipe_tag_recipe;

alter table recipe_tag drop constraint if exists fk_recipe_tag_tag;
drop index if exists ix_recipe_tag_tag;

alter table step drop constraint if exists fk_step_parent_recipe_id;
drop index if exists ix_step_parent_recipe_id;

drop table if exists ingredient;

drop table if exists ingredient_quantity;

drop table if exists recipe;

drop table if exists recipe_ingredient;

drop table if exists recipe_ingredient_quantity;

drop table if exists recipe_utensil;

drop table if exists recipe_tag;

drop table if exists recipe_description;

drop table if exists step;

drop table if exists tag;

drop table if exists utensil;

